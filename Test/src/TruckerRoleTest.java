import static org.junit.jupiter.api.Assertions.*;

import GUIs.TruckerRole;
import org.junit.jupiter.api.Test;
import java.util.Date;


/**
 * Test for the TruckerRole class.
 */
class TruckerRoleTest {

    private TruckerRole trucker;
    private final


    /**
     * Test viewCurrentJobs()
     */
    @Test
    void viewCurrentJobs() {
        TruckerRole trucker = new TruckerRole(112233, "pass", "Adam White", "Driver");
        trucker.inputLoadData(1, "PHX", "LA", true, "In Progress", new Date(), 41, "Nothing");
    }

    /**
     *Test inputLoadData()
     */
    @Test
    void inputLoadData() {
        TruckerRole trucker = new TruckerRole(112233, "pass", "Adam White", "Driver");
        trucker.inputLoadData(5, "Arizona", "CA", true, "Done", new Date(), 18, "Note");

        //verify the job is added
        assertNotNull(trucker);
    }

    /**
     *Test getWeeklySummary()
     */
    @Test
    void getWeeklySummary() {
        TruckerRole trucker = new TruckerRole(112233, "pass", "Adam White", "Driver");
        trucker.inputLoadData(2, "New York", "Los Angeles", true, "Done", new Date(), 19, "note" );
        trucker.inputLoadData(5, "Canada", "Los Angeles", true, "Done", new Date(), 18, "no note" );

        String weeklySummary = trucker.getWeeklySummary();
        System.out.println("Actual Summary:\n"  + weeklySummary);

        String expectedSummary = "Weekly Summary:\nTotal Jobs this week: 2.\n";
        System.out.println("Expected Summary:\n" + expectedSummary);

        assertEquals(expectedSummary, weeklySummary);
    }

    /**
     * Test getIDNumber()
     */
    @Test
    void getIDNumber() {
        //create new TruckerRole object with ID 112233
        TruckerRole trucker = new TruckerRole(112233, "pass", "Adam White", "Driver");

        //ensure getIDNumber() method returns the correctID
        assertEquals(112233, trucker.getIDNumber());
    }

    /**
     * Test setIDNumber()
     */
    @Test
    void setIDNumber() {
        // create new TruckerRole object with default ID
        TruckerRole trucker = new TruckerRole();

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
        TruckerRole trucker = new TruckerRole(333222, "myPass", "Adam White", "Driver");
        assertEquals("myPass", trucker.getPassword());
    }

    /**
     * Test setPassword()
     */
    @Test
    void setPassword() {
        TruckerRole trucker = new TruckerRole();
        trucker.setPassword("myNewPass");
        assertEquals("myNewPass", trucker.getPassword());
    }

    /**
     * Test getName()
     */
    @Test
    void getName() {
        TruckerRole trucker = new TruckerRole(4321, "password", "Adam White", "Driver");
        assertEquals("Adam White", trucker.getName());
    }

    /**
     * Test setName()
     */
    @Test
    void setName() {
        TruckerRole trucker = new TruckerRole();
        trucker.setName("Adam Green");
        assertEquals("Adam Green", trucker.getName());
    }

    /**
     * Test getRole()
     */
    @Test
    void getrole() {
        TruckerRole trucker = new TruckerRole(1212, "pass", "Adam White", "Driver");
        assertEquals("Driver", trucker.getrole());
    }

    /**
     * Test setrole()
     */
    @Test
    void setrole() {
        TruckerRole trucker = new TruckerRole();
        trucker.setrole("Admin");
        assertEquals("Admin", trucker.getrole());
    }
}