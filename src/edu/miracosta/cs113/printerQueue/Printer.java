package edu.miracosta.cs113.printerQueue;

import java.util.Queue ;
import java.util.LinkedList ;

/**
 * This class holds a queue of print jobs for the object Printer
 */
public class Printer {

    private Queue<Job> jobs ;

    /**
     * Default constructor for Printer
     */
    public Printer() {
        jobs = new LinkedList<Job>() ;

    }

    /**
     * Full Constructor for Printer
     * @param jobs  A queue of jobs
     */
    public Printer(Queue<Job> jobs) {
        this.jobs = jobs ;
    }

    /**
     * Copy Constructor for Printer
     * @param p A Printer object to copy
     */
    public Printer(Printer p) {
        jobs = p.jobs ;
    }

    /**
     * Set the job queue to the incomeing queue
     * @param j Incoming queue to set this job queue to
     */
    public void setJob(Queue<Job> j) {
        jobs = j ;
    }

    /**
     * Returns the jobs queue
     * @return a queue of jobs to print
     */
    public Queue getJob() {
        return jobs ;

    }

    /**
     * Equals test of two different Printer objects
     * @param obj  Object being passed in as a Printer
     * @return true or false if object passed in is equal to this Object
     */
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Printer other = (Printer) obj;
        return (this.jobs == other.jobs );

    }


    /**
     * Add a job to the back of the queue
     * @param job Incoming job to add
     */
    public void add(Job job) {
        jobs.add(job) ;
    }

    /**
     * Checks if the queue is empty
     * @return True if list is empty, false if it is not
     */
    public boolean isEmpty() {
        return jobs.isEmpty() ;
    }

    /**
     * Peek at the top of the queue
     * @return A Job Object that is at the top of the queue
     */
    public Job peek() {
        return jobs.peek() ;
    }


    /**
     * Removes the head of the queue
     * @return  A Job Object that was removed from the head
     */
    public Job remove() {
        return jobs.remove() ;
    }

    /**
     * Checks if there is a next print job in the queue
     * @return True if there is another Job, false else
     */
    public boolean hasNext() {
        if (jobs.peek()== null) {
            return false ;
        }
        else {
            return true ;
        }
    }

    @Override
    public String toString() {
        String write = "" ;
        Object[] work = jobs.toArray() ;
        for (int i =  0 ; i < work.length ; i++) {
            write +=  work[i] ;
        }
        return write ;
    }
}
