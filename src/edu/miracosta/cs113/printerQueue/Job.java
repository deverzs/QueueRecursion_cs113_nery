package edu.miracosta.cs113.printerQueue;

/**
 * This class holds a Job object which holds the number of pages to do
 */
public class Job {

    private int pages ;

    /**
     * Full constructor, sets pages that is the parameter
     * @param pages Number of pages set for the job
     */
    public Job(int pages) {
        setPages(pages);
    }

    /**
     * Default constructor that sets the pages to zero
     */
    public Job() {
        pages =  0 ;
    }

    /**
     * Copy constructor, uses an incoming Job object to shallow copy
     * @param other The other Job to copy
     */
    public Job(Job other) {
        this.pages = other.pages ;
    }

    /**
     * Returns the number of pages in this Job
     * @return Number of pages in this Job
     */
    public int getPages() {
        return pages ;
    }

    /**
     * Sets the pages of this Job
     * Precondition that pages be a positive integer
     * @param pages The incoming pages the Job is set to
     */
    public void setPages(int pages) {
        if (pages >= 0) {
            this.pages = pages;
        }
        else {
            this.pages = 0 ;
        }
    }

    @Override
    public String toString() {
        return "" + pages + " " ;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Job other = (Job) obj;
        return (this.pages == other.pages );

    }
}
