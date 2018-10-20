package edu.miracosta.cs113.printerQueue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {

    private Job job ;

    @Before
    public void setup() {
            job = new Job(5);
    }

    @Test
    public void testGetPages() {
        assertEquals(5L, (long) job.getPages());
    }

    @Test
    public void testSetPages() {
        job.setPages(10);
        assertEquals(10, (long) job.getPages());
    }


    @Test
    public void testEquals() {
        Job temp = new Job(5) ;
        assertTrue(job.equals(temp));
    }

    @Test
    public void testString() {
        assertEquals("5 ", job.toString());
    }
}