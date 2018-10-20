package edu.miracosta.cs113.printerQueue;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;
import static org.junit.Assert.*;

public class PrinterTest {

    private  Printer printerQueue ;

    private static final int[] NUM_OF_JOBS = { 12, 7, 32, 24, 8, 10 } ;


    @Before
    public void setUp()  {
        printerQueue = new Printer() ;
    }

    @SuppressWarnings("ManualArrrayToCollectionCopy")
    private void populateQueue(int numJobs) {
        Job temp ;
        for (int i = 0; i < numJobs ; i++) {
            temp = new Job(NUM_OF_JOBS[i]) ;
            printerQueue.add(temp);
        }
    }


    @Test
    public void testAdd() {
        populateQueue(1);
        int comp = printerQueue.peek().getPages() ;
        assertEquals("Test fail",NUM_OF_JOBS[0], comp) ;
    }

    @Test
    public void testEmpty() {
        assertTrue("Test Failed - queue should be empty.", printerQueue.isEmpty());
    }

    @Test
    public void testPeekEmpty() {
        assertEquals("Test failed", null, printerQueue.peek());
    }

    @Test
    public void testAddAndExamineMultiple() {
        populateQueue(5);
        int comp = printerQueue.peek().getPages() ;
        assertEquals("Test failed", NUM_OF_JOBS[0], comp);
    }

    @Test
    public void testRemoveEmpty() {
        try {
            printerQueue.remove();
            fail("Test remove failed - Call from an empty queue should throw NoSuchElementException.");
        } catch (NoSuchElementException nsee) { /* Test Success */ }
    }

    @Test
    public void testRemoveOne() {
        printerQueue.add(new Job(NUM_OF_JOBS[0]));
        int comp = printerQueue.remove().getPages() ;
        assertEquals("Test failed", NUM_OF_JOBS[0], comp);
    }

    @Test
    public void testRemoveMany() {
        populateQueue(6);
        int comp ;
        for (int i = 0 ; i < 6; i++) {
            comp = printerQueue.remove().getPages() ;
            assertEquals("Test failed", NUM_OF_JOBS[i], comp );
        }
    }

    @Test
    public void testHasNext() {
        populateQueue(1);
        assertTrue(printerQueue.hasNext());
        printerQueue.remove() ;
        assertFalse(printerQueue.hasNext());
    }

    @Test
    public void testString() {
        populateQueue(3);
        assertEquals("12 7 32 ", printerQueue.toString());
    }


}