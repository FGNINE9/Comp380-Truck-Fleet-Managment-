import GUIs.Job;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * Collection of tests for the Job class
 */
class JobTest {

    /**
     * Dummy job used to test
     */
    static Job dummyJob;

    /**
     * Initialize the dummy job so we can test with it
     */
    @BeforeAll
    static void setup()
    {
        dummyJob = new Job(9001,"Tokyo", "Akihabara", true, "on the train", new Date(), 20, 9, "heavy" );

    }


    /**
     * Tests to see if you can print the job
     */
    @Test
    void printJob()
    {
        assertNotNull(dummyJob.printJob(), "Was unable to print!");
    }

    @Test
    void logJob() {
    }

    @Test
    void getID() {
    }

    @Test
    void getStartLocation() {
    }

    @Test
    void getEndLocation() {
    }

    @Test
    void getPaid() {
    }

    @Test
    void getStatus() {
    }

    @Test
    void getCompletionTime() {
    }

    @Test
    void getTruckerID() {
    }

    @Test
    void getJobHours() {
    }

    @Test
    void getNotes() {
    }
}