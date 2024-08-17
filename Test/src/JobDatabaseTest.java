import GUIs.Job;
import GUIs.JobDatabase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * JUnit testing class for JobDatabase
 */
class JobDatabaseTest
{

    /**
     * A dummy database is required to test
     */
    static JobDatabase test;

    /**
     * Length of the initial database, used to test whether adding or removing jobs works
     */
    static int initialDatabaseLength;

    /**
     * A dummy job that can be used to add or remove or whenever a job is needed.
     */
    static Job dummyJob;

    /**
     * Set up the dummy database before any methods in order to be able to test them
     */
    @BeforeAll
    static void setup()
    {
        test = new JobDatabase();

        initialDatabaseLength = test.getJobListSortedByID().size();
        dummyJob = new Job(115,"San Diego", "New York City", true, "stuck", new Date(), 18, 117, "fragile" );

    }


    /**
     * Test getJob, see if it returns a job
     */
    @DisplayName("Test to see if you can get a job")
    @org.junit.jupiter.api.Test
    void getJob()
    {
        assertNotNull(test.getJob(0), "No jobs in the database!");
    }

    /**
     * Test addJob, done by seeing if the number of jobs in the database changed +1
     */
    @org.junit.jupiter.api.Test
    void addJob()
    {
        test.addJob(dummyJob);

        assertEquals( initialDatabaseLength+1, test.getJobListSortedByID().size() ,"Job could not be added");

        test.removeJobJob(dummyJob);
    }

    /**
     * Test removeJob, tests to see if the number of jobs in the database changed by -1
     */
    @org.junit.jupiter.api.Test
    void removeJob()
    {
        //add the job that will be removed for the test
        test.addJob(dummyJob);

        test.removeJob(115);

        //kind of a weird test because adding and removing a job will have the test be the same value
        assertEquals(initialDatabaseLength, test.getJobListSortedByID().size() ,"Job could not be removed");



    }


    /**
     * Test removeJob by passing the object instead of ID
     */
    @org.junit.jupiter.api.Test
    void removeJobJob()
    {
        //add the job that will be removed for the test
        test.addJob(dummyJob);

        test.removeJobJob(dummyJob);

        //kind of a weird test because adding and removing a job will have the test be the same value
        assertEquals(initialDatabaseLength, test.getJobListSortedByID().size() ,"Job could not be removed");


    }


    /**
     * Test startJob, test to see if the job's status is updated to "In progress"
     */
    @org.junit.jupiter.api.Test
    void startJob()
    {

        //set up the job to be tested
        test.addJob(dummyJob);
        test.startJob(dummyJob);


        //find the job in the list
        for(int i =0;i<test.getJobListSortedByID().size();i++)
        {
            if(test.getJob(i).getID() == dummyJob.getID())
                assertEquals("In Progress", test.getJob(i).getStatus(),"Job could not be started");
        }

        test.removeJob(115);


    }


    /**
     * Test updateStartLocation, test to see if the job's startLocation updated
     */
    @org.junit.jupiter.api.Test
    void updateStartLocation()
    {
        //set up the initial testing conditions
        String startDesired = "The beginning";
        test.addJob(dummyJob);
        test.updateStartLocation(dummyJob, startDesired);

        //set up second dummy job to refind the updated job
        Job tester = test.getJob(0);

        for(int i=0;i<test.getJobListSortedByID().size();i++)
        {
            if(test.getJob(i).getID() == dummyJob.getID())
                tester = test.getJob(i);
        }

        assertEquals(startDesired, tester.getStartLocation(), "Job could not have it's startLocation updated");

        test.removeJob(115);//dummyJob's ID

    }


    /**
     * Test updateEndLocation, test to see if the job's endLocation updated
     */
    @Test
    void updateEndLocation()
    {

        String endDesired = "The end";
        test.addJob(dummyJob);
        test.updateEndLocation(dummyJob, endDesired);

        Job tester = test.getJob(0);

        for(int i=0;i<test.getJobListSortedByID().size();i++)
        {
            if(test.getJob(i).getID() == dummyJob.getID())
                tester = test.getJob(i);
        }

        assertEquals(endDesired, tester.getEndLocation(), "Job could not have it's endLocation updated");

        test.removeJob(115);
    }

    /**
     * Test for updatePaidStatus, tests if the method changed the paid boolean appropriately
     */
    @Test
    void updatePaidStatus()
    {

        Boolean paidDesired = false;
        test.addJob(dummyJob);
        test.updatePaidStatus(dummyJob, paidDesired);

        Job tester = test.getJob(0);

        for(int i=0;i<test.getJobListSortedByID().size();i++)
        {
            if(test.getJob(i).getID() == dummyJob.getID())
                tester = test.getJob(i);
        }

        assertEquals(paidDesired, tester.getPaid(), "Job could not have it's paid updated");

        test.removeJob(115);

    }

    /**
     * Test updateJobStatus, used to test if the job has it's status updated
     */
    @Test
    void updateJobStatus()
    {

        String statusDesired = "Delivered";
        test.addJob(dummyJob);
        test.updateJobStatus(dummyJob, statusDesired);

        Job tester = test.getJob(0);

        for(int i=0;i<test.getJobListSortedByID().size();i++)
        {
            if(test.getJob(i).getID() == dummyJob.getID())
                tester = test.getJob(i);
        }

        assertEquals(statusDesired, tester.getStatus(), "Job could not have it's status updated");

        test.removeJob(115);

    }

    @Test
    void updateCompletionTime()
    {

        Date dateDesired = new Date(2014, Calendar.FEBRUARY, 11);
        test.addJob(dummyJob);
        test.updateCompletionTime(dummyJob, dateDesired);

        Job tester = test.getJob(0);

        for(int i=0;i<test.getJobListSortedByID().size();i++)
        {
            if(test.getJob(i).getID() == dummyJob.getID())
                tester = test.getJob(i);
        }

        assertEquals(dateDesired, tester.getCompletionTime(), "Job could not have it's completionDate updated");

        test.removeJob(115);

    }

    /**
     * Tests printDatabase, will test to see if anything is printed
     */
    @Test
    void printDatabase()
    {
        assertNotNull(test.printDatabase(), "Nothing was in the database!?!?");
    }

    /**
     * Tests logDatabase, will test to see if anythign is printed/logged
     */
    @Test
    void logDatabase()
    {
        assertNotNull(test.logDatabase(), "Nothing was in the database!?!?");
    }

    @Test
    void writeDatabase()
    {

    }

    @Test
    void buildDatabaseFromFile()
    {


    }

    /**
     * Tests getJobSortedByID, will test if the returned list has all the jobs sorted by ID correctly
     */
    @Test
    void getJobListSortedByID()
    {
        Boolean failFlag = true;

        for(int i =0;i<test.getJobListSortedByID().size()-1;i++)
        {
            if(test.getJob(i).getID() > test.getJob(i+1).getID())
                failFlag = false;
            System.out.println(failFlag);
        }

        assertEquals(true, failFlag, "Database is not sorted correctly!");

    }


    /**
     * Tests getJobListSortedByDate, will test if the returned list has all the jobs sorted by Date correctly
     */
    @Test
    void getJobListSortedByDate()
    {
        Boolean failFlag = true;

        int fail =0;

        ArrayList<Job> temp = test.getJobListSortedByDate();

        for(int i =0;i<temp.size()-1;i++)
        {
            System.out.println(temp.get(i).getCompletionTime() + " is earlier than?  "+ temp.get(i+1).getCompletionTime());
            if((temp.get(i).getCompletionTime()).compareTo(temp.get(i + 1).getCompletionTime()) >= 0) {

             System.out.println("inside the if");
                failFlag = false;
                fail++;
            }

                System.out.println(failFlag+" fail= "+fail+"\n");
        }

        assertEquals(true, failFlag, "Database is not sorted correctly!");

    }

    @Test
    void getJobListSortedByStartingLocation() {
    }

    @Test
    void getJobListSortedByEndLocation() {
    }

    @Test
    void getJobListPaid() {
    }

    @Test
    void getJobListStatus() {
    }
}