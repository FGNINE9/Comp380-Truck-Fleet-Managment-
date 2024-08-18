import GUIs.Job;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;


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
        dummyJob = new Job(9001,"Tokyo", "Akihabara", true, "on the train", new Date(2024, Calendar.JULY, 4 ), 20, 9, "heavy" );

    }


    /**
     * Tests to see if you can print the job, using dummy job to check
     */
    @Test
    void printJob()
    {
        String expected = "GUIs.Job report for job #9001\n" +
                "Start: Tokyo\n" +
                "End: Akihabara\n" +
                "Paid: true\n" +
                "Status: on the train\n" +
                "completionTime: Fri Jul 04 00:00:00 PDT 3924\n" +
                "Assigned to: 20\n" +
                "Hours: 9\n" +
                "Notes: heavy";

        assertEquals(expected, dummyJob.printJob(), "Was unable to print!");
    }

    /**
     * Testing logJob, using the dummy job to check what it's printing
     */
    @Test
    void logJob()
    {
        String expected = "9001| Tokyo| Akihabara| true| on the train| Fri Jul 04 00:00:00 PDT 3924| 20| 9| heavy\n";

        assertEquals(expected, dummyJob.logJob(), "Was unable to log!");
    }


    /**
     * Testing getter for ID using dummy job
     */
    @Test
    void getID()
    {
        assertEquals(9001,dummyJob.getID(),"ID didn't match!");
    }

    /**
     * Testing getter for startLocation using the dummy job
     */
    @Test
    void getStartLocation()
    {
        assertEquals("Tokyo",dummyJob.getStartLocation(),"StartLocation didn't match!");
    }

    /**
     * Testing getter for endLocation using the dummy job
     */
    @Test
    void getEndLocation()
    {
        assertEquals("Akihabara",dummyJob.getEndLocation(),"EndLocation didn't match!");
    }

    /**
     * Testing getter for paid using the dummy job
     */
    @Test
    void getPaid()
    {
        assertTrue(dummyJob.getPaid(),"Paid didn't match!");
    }

    /**
     * Testing getter for status using the dummy job
     */
    @Test
    void getStatus()
    {
        assertEquals("on the train",dummyJob.getStatus(), "Status didn't match!");
    }

    /**
     * Testing getter for completionTime using the dummy job
     */
    @Test
    void getCompletionTime()
    {
        assertEquals(new Date(2024, Calendar.JULY, 4),dummyJob.getCompletionTime(),"Completion Time didn't match!!");
    }

    /**
     * Testing getter for TruckerID using the dummy job
     */
    @Test
    void getTruckerID()
    {
        assertEquals(20,dummyJob.getTruckerID(),"TruckerID didn't match!");
    }

    /**
     * Testing getter for JobHours using the dummy job
     */
    @Test
    void getJobHours()
    {
        assertEquals(9,dummyJob.getJobHours(),"JobHours didn't match!");
    }

    /**
     * Testing getter for Notes using the dummy job
     */
    @Test
    void getNotes()
    {
        assertEquals("heavy",dummyJob.getNotes(),"Notes didn't match!");
    }
}