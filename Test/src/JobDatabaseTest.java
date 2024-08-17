import GUIs.JobDatabase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JobDatabaseTest {

    static JobDatabase test;

    @BeforeAll
    static void setup()
    {
        test = new JobDatabase();
    }


    @DisplayName("Test to see if you can get a job")
    @org.junit.jupiter.api.Test
    void getJob()
    {
        Assertions.assertNotNull(test.getJob(0));
    }

    @org.junit.jupiter.api.Test
    void addJob() {
    }

    @org.junit.jupiter.api.Test
    void removeJob() {
    }

    @org.junit.jupiter.api.Test
    void startJob() {
    }

    @org.junit.jupiter.api.Test
    void updateStartLocation()
    {
       // assertEquals();
    }

    @Test
    void testGetJob() {
    }

    @Test
    void testAddJob() {
    }

    @Test
    void testRemoveJob() {
    }

    @Test
    void testStartJob() {
    }

    @Test
    void testUpdateStartLocation() {
    }

    @Test
    void updateEndLocation() {
    }

    @Test
    void updatePaidStatus() {
    }

    @Test
    void updateJobStatus() {
    }

    @Test
    void updateCompletionTime() {
    }

    @Test
    void printDatabase() {
    }

    @Test
    void logDatabase() {
    }

    @Test
    void getJobListSortedByID() {
    }

    @Test
    void getJobListSortedByDate() {
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