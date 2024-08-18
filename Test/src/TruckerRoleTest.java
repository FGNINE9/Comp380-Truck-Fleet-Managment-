import static org.junit.jupiter.api.Assertions.*;
import GUIs.Job;
import GUIs.JobDatabase;
import GUIs.TruckerRole;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;


/**
 * Test for the TruckerRole class.
 */
class TruckerRoleTest {

    static JobDatabase test;
    static int initialDatabaseLength;
    static Job dummyJob1;
    static Job dummyJob2;
    TruckerRole trucker;

    @BeforeAll
    static void setup(){
        test = new JobDatabase();
        initialDatabaseLength = test.getJobListSortedByID().size();
        dummyJob1 = new Job(321, "Sf", "LA", true, "status", new Date(), 55, 21, "nothing");
        dummyJob2 = new Job(123, "Sf", "LA", true, "status", new Date(), 44, 20, "nothing");
    }

    @BeforeEach
    void resetTrucker(){
        trucker = new TruckerRole(112233, "pass", "Adam White", "Driver");
        test.removeJob(dummyJob1.getID());
        test.removeJob(dummyJob2.getID());
    }

//    @BeforeEach()
//    void removeJob(){
//        test.addJob(dummyJob1);
//        assertEquals(initialDatabaseLength + 1, test.getJobListSortedByID().size(), "Job wasnt added correctly");
//
//        test.removeJob(dummyJob1.getID());
//        assertEquals(initialDatabaseLength, test.getJobListSortedByID().size());
//
//        test.addJob(dummyJob2);
//        assertEquals(initialDatabaseLength + 1, test.getJobListSortedByID().size(), "Job wasnt added correctly");
//
//        test.removeJob(dummyJob2.getID());
//        assertEquals(initialDatabaseLength, test.getJobListSortedByID().size());
//    }

    /**
     * Test viewCurrentJobs()
     */
    @Test
    void viewCurrentJobs() {
        trucker.inputLoadData(1, "PHX", "LA", true, "InProgress", new Date(), 19, "None");
        assertNotNull(trucker, "TruckerRole object is null");
    }

    /**
     *Test inputLoadData()
     */
    @Test
    void inputLoadData() {
        trucker.inputLoadData(5, "Arizona", "CA", true, "Done", new Date(), 18, "Note");

        //verify the job is added
        assertNotNull(trucker);
    }

    /**
     *Test getWeeklySummary()
     */
    @Test
    void getWeeklySummary() {
        System.out.println("Initial Database Jobs: " + test.getJobListSortedByID().size());

        assertEquals(initialDatabaseLength, test.getJobListSortedByID().size(), "Database must be at initial state");

        Date currentTime = new Date();
        long oneWeekAgo = currentTime.getTime() - (7 * 24 * 60 * 60 * 1000);
        Date oneWeekAgoDate = new Date(oneWeekAgo);

        Job dummyJob1 = new Job(321, "SF", "LA", true, "status", currentTime, 55, trucker.getIDNumber(), "none");
        Job dummyJob2 = new Job(123, "SF", "LA", true, "status", oneWeekAgoDate, 44, trucker.getIDNumber(), "none");

        test.addJob(dummyJob1);
        test.addJob(dummyJob2);

        System.out.println("Jobs in Database after adding: " + test.getJobListSortedByID().size());

        for (Job job : test.getJobListSortedByID()){
            System.out.println("Job ID: " + job.getID() + ", Trucker ID" + job.getTruckerID() +
                    ", CompletionTime: " + job.getCompletionTime());
        }

        String weeklySummary = trucker.getWeeklySummary();
        System.out.println("Actual Summary:\n"  + weeklySummary);

        String expectedSummary = "Weekly Summary:\nTotal Jobs this week: 2.\n";
        System.out.println("Expected Summary:\n" + expectedSummary);

        assertEquals(expectedSummary, weeklySummary, "Weekly Summary does not match the expected result");

        test.removeJob(dummyJob1.getID());
        test.removeJob(dummyJob2.getID());

        System.out.println("Final Database Jobs: " + test.getJobListSortedByID().size());

        assertEquals(initialDatabaseLength, test.getJobListSortedByID().size(), "Job count didnt return bavk to initial value");
    }

    /**
     * Test getIDNumber()
     */
    @Test
    void getIDNumber() {
        //ensure getIDNumber() method returns the correctID
        assertEquals(112233, trucker.getIDNumber());
    }

    /**
     * Test setIDNumber()
     */
    @Test
    void setIDNumber() {
        // set new ID number
        trucker.setIDNumber(1234);

        // make sure returns updated ID
        assertEquals(1234, trucker.getIDNumber());
    }

    /**
     * Test getPassword()
     */
    @Test
    void getPassword() {
        assertEquals("pass", trucker.getPassword());
    }

    /**
     * Test setPassword()
     */
    @Test
    void setPassword() {
        trucker.setPassword("myNewPass");
        assertEquals("myNewPass", trucker.getPassword());
    }

    /**
     * Test getName()
     */
    @Test
    void getName() {
        assertEquals("Adam White", trucker.getName());
    }

    /**
     * Test setName()
     */
    @Test
    void setName() {
        trucker.setName("Adam Green");
        assertEquals("Adam Green", trucker.getName());
    }

    /**
     * Test getRole()
     */
    @Test
    void getRole() {
        assertEquals("Driver", trucker.getrole());
    }

    /**
     * Test setrole()
     */
    @Test
    void setRole() {
        trucker.setrole("Admin");
        assertEquals("Admin", trucker.getrole());
    }
}