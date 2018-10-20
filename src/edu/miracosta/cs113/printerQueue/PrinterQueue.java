package edu.miracosta.cs113.printerQueue;


import java.util.Random;

/**
 * A Program to simulate testing 1, 2 or 3 printers to print 100 jobs, of varying lengths from 1 to 50 pages each.
 * Printout the time it takes, which printer accepted the job, which printer finished a job and which job was
 * completed, in the order it was completed. Summarize results at the end of the simulation.
 *
 * Algorithm:
 *
 * 1. Populate array of Job objects with Random ints, from 1 to 50
 * 2. For 1 printer test:
 *      a. Create Printer object
 *      b. Populate Printer queue with Jobs
 *      c. WHILE LOOP
 *          i. counter++, print time
 *          ii. assign new currentJob
 *          iii. if currentJob < 10, remove Job from printer queue
 *          iv. if currentJob > 10, print 10 pages
 *          v. if lengthArray of Jobs is not zero, add another Job to the queue
 *          vi. check if lengthArray == 0 And if the queue is empty
 *      d. exit WHILE if (vi) is true
 *      e. Print summary of time it took to print
 * 3. For 2 printers, repeat above algorithm, but add another printer to the loop.
 *      Loop should be exited when lengthArray == 0 And both printer queues are empty.
 * 4. For 3 printers, repeat above algorithm, but add another printer to the loop.
 *      Loop should be exited when lengthArray == 0 And all three printer queues are empty.
 * 5. Summarize simulation times for all three printer options.
 *
 */
public class  PrinterQueue {

    public final static int NUM_OF_JOBS = 100 ;

    public static void main (String[] ars) {

        int counter1 = 0 ;
        int counter2 = 0 ;
        int counter3 = 0 ;
        int num = 0 ;
        Random rand = new Random() ;
        Job[] jobsSet = new Job[NUM_OF_JOBS] ;

        for (int i = 0; i < NUM_OF_JOBS ; i++) {
            num = (rand.nextInt(50)+1) ;
            jobsSet[i] = new Job(num) ;
        }

        Printer a = new Printer() ;
        Printer b = new Printer() ;
        Printer c = new Printer() ;

        boolean done = false ;
        boolean newJob = true ;

        /**
         * One Printer
         * */
        System.out.println("==========================================") ;
        System.out.println("===          USING 1 PRINTER           ===") ;
        System.out.println("==========================================\n\n") ;
        int currentJob = 0 ;

        int lengthArray = jobsSet.length ;
        while (!(done)) {

            counter1++ ;
            System.out.println( " ***** Time: " + counter1 + " ******* ") ;


            // assign new currentJob
            if (a.peek() != null && newJob) {
                currentJob = a.peek().getPages() ;
                newJob = false ;
            }

            if (currentJob < 10 && (a.peek() != null)) {
                System.out.println("                *****************   Print complete for : " + a.remove()) ;
                newJob = true ;
            }

            if (currentJob >= 10 ) {
                currentJob-= 10 ;
                //System.out.println("Current Job is now: " + currentJob) ;
            }

            // add more jobs if available
            if (lengthArray > 0) {
                System.out.println("Received to Printer A : " + jobsSet[lengthArray-1].toString()) ;
                a.add(jobsSet[lengthArray-1]) ;
                lengthArray-- ;
            }
            // done
            if ( (lengthArray == 0) && (a.peek() == null) ) {
                done = true ;
                //System.out.println( " Done ") ;
            }

        }
        System.out.println( "\n\nPrinter A took : " + counter1 + " cycles to complete using 1 printer.\n\n" ) ;




        /**
         * Two Printers
         * */
        System.out.println("==========================================") ;
        System.out.println("===          USING 2 PRINTERS          ===") ;
        System.out.println("==========================================\n\n") ;
        done = false ;
        newJob = true ;
        currentJob = 0 ;


        boolean newJob2 = true ;
        int currentJob2 = 0 ;


        lengthArray = jobsSet.length ;
        while (!(done)) {

            counter2++ ;
            System.out.println( " ***** Time: " + counter2 + " ******* ") ;
            //System.out.println(a.toString()) ;


            // assign new currentJobs
            if (a.peek() != null && newJob) {
                currentJob = a.peek().getPages() ;
                newJob = false ;
            }
            if (b.peek() != null && newJob2) {
                currentJob2 = b.peek().getPages() ;
                newJob2 = false ;
            }

            if (currentJob < 10 && (a.peek() != null)) {
                System.out.println("                *****************   Print complete from Printer A for : " + a.remove()) ;
                newJob = true ;
            }
            if (currentJob2 < 10 && (b.peek() != null)) {
                System.out.println("                *****************   Print complete from Printer B for : " + b.remove()) ;
                newJob2 = true ;
            }

            if (currentJob >= 10 ) {
                currentJob-= 10 ;
                //System.out.println("Current Job is now: " + currentJob) ;
            }

            if (currentJob2 >= 10 ) {
                currentJob2 -= 10 ;
                //System.out.println("Current Job is now: " + currentJob) ;
            }


            // add more jobs if available
            if (lengthArray > 0) {

                if (jobsSet[lengthArray-1].getPages() < 10 ) {
                    System.out.println("Received to Printer A : " + jobsSet[lengthArray-1].toString()) ;
                    a.add(jobsSet[lengthArray-1]) ;
                }
                else {
                    System.out.println("Received to Printer B : " + jobsSet[lengthArray-1].toString()) ;
                    b.add(jobsSet[lengthArray-1]) ;
                }
                lengthArray-- ;
            }


            // done
            if ( (lengthArray == 0) && (a.peek() == null) && (b.peek() == null) ) {
                done = true ;
                //System.out.println( " Done ") ;
            }

        }
        System.out.println( "\n\nPrinter A and B took : " + counter2 + " cycles to complete using 2 printer.\n\n" ) ;





        /**
         * Three Printers
         * */

        System.out.println("==========================================") ;
        System.out.println("===          USING 3 PRINTERS          ===") ;
        System.out.println("==========================================\n\n") ;

        done = false ;
        newJob = true ;
        currentJob = 0 ;
        newJob2 = true ;
        currentJob2 = 0 ;

        boolean newJob3 = true ;
        int currentJob3 = 0 ;


        lengthArray = jobsSet.length ;


        while (!(done)) {

            counter3++ ;
            System.out.println( " ***** Time: " + counter3 + " ******* ") ;
            //System.out.println(a.toString()) ;


            // assign new currentJobs
            if (a.peek() != null && newJob) {
                currentJob = a.peek().getPages() ;
                newJob = false ;
            }
            if (b.peek() != null && newJob2) {
                currentJob2 = b.peek().getPages() ;
                newJob2 = false ;
            }
            if (c.peek() != null && newJob3) {
                currentJob3 = c.peek().getPages() ;
                newJob3 = false ;
            }

            if (currentJob < 10 && (a.peek() != null)) {
                System.out.println("                *****************   Print complete from Printer A for : " + a.remove()) ;
                newJob = true ;
            }
            if (currentJob2 < 10 && (b.peek() != null)) {
                System.out.println("                *****************   Print complete from Printer B for : " + b.remove()) ;
                newJob2 = true ;
            }
            if (currentJob3 < 10 && (c.peek() != null)) {
                System.out.println("                *****************   Print complete from Printer C for : " + c.remove()) ;
                newJob3 = true ;
            }

            if (currentJob >= 10 ) {
                currentJob-= 10 ;
                //System.out.println("Current Job is now: " + currentJob) ;
            }

            if (currentJob2 >= 10 ) {
                currentJob2 -= 10 ;
                //System.out.println("Current Job is now: " + currentJob) ;
            }

            if (currentJob3 >= 10 ) {
                currentJob3 -= 10 ;
                //System.out.println("Current Job is now: " + currentJob) ;
            }








            // add more jobs if available
            if (lengthArray > 0) {

                if (jobsSet[lengthArray-1].getPages() < 10 ) {
                    System.out.println("Received to Printer A : " + jobsSet[lengthArray-1].toString()) ;
                    a.add(jobsSet[lengthArray-1]) ;
                }
                else if (jobsSet[lengthArray-1].getPages() < 20 && jobsSet[lengthArray-1].getPages() > 9) {
                    System.out.println("Received to Printer B : " + jobsSet[lengthArray-1].toString()) ;
                    b.add(jobsSet[lengthArray-1]) ;
                }
                else {
                    System.out.println("Received to Printer C : " + jobsSet[lengthArray-1].toString()) ;
                    c.add(jobsSet[lengthArray-1]) ;
                }
                lengthArray-- ;
            }




            // done
            if ( (lengthArray == 0) && (a.peek() == null) && (b.peek() == null) && (c.peek() == null) ) {
                done = true ;
                //System.out.println( " Done ") ;
            }

        }
        System.out.println( "\n\nPrinter A, B, and C took : " + counter3 + " cycles to complete using 3 printer.\n\n" ) ;


        System.out.println("+++++++++++++++++++++++++++++++++   SUMMARY  ++++++++++++++++++++++++++++++++++++++++");
        System.out.println( "      Printer A took : " + counter1 + " cycles to complete using 1 printer." ) ;
        System.out.println( "    Printer A and B took : " + counter2 + " cycles to complete using 2 printers." ) ;
        System.out.println( "   Printer A, B, and C took : " + counter3 + " cycles to complete using 3 printers.") ;
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }



}
