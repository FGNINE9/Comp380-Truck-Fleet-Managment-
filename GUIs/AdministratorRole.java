package GUIs;

/**
 * Class for that holds the methods used by the Admin
 * @author Raashid Norman
 */
public class AdministratorRole
{
    /**
     * Global variables for the admin log in
     */
    private int IDNumber;
    private String password;
    private String name;

    /**
     * Default constructor
     */
    public AdministratorRole()
    {
        IDNumber = -1;
        password = "NOT INPUT";
        name = "DEFAULT";
    }

    /**
     * Constructor for admin
     * @param IDNumber  admins ID
     * @param password  admins password
     * @param name  admins name
     */
    public AdministratorRole(int IDNumber, String password, String name)
    {
        this.IDNumber = IDNumber;
        this.password = password;
        this.name = name;
    }

    /**
     * Method for Editing Employee data
     *
     */
    public void EditEmployeeData(){
        JobDatabase database = new JobDatabase();
        String command = "Yes";

        System.out.println("Printing Employee Data...");
        database.printDatabase();
        System.out.println("Select Yes to Edit");
        System.out.println("Select No to Exit ");
        /**
         * if statement for selecting the proper choice
         * if the command is equal to the string "Yes", edits
         */
        if ("Yes".equals(command)) {
            System.out.println("Select fields to edit ");
            /**
             * Add methods to edit certain database fields
             * Edit database()
             */
        } else {
            System.out.println("Exiting Menu ");
        }

    }

    /**
     * Method for Assigning jobs to Drivers
     */
    public void AssignJobs(){
        Job job = new Job();
        String command = "Yes";

        System.out.println("Assign GUIs.Job to Employee...");
        job.printJob();
        System.out.println("Please Select Options for job");
        /**
         * if statement for selecting the proper choice
         * if the command is equal to the string "Yes", edits
         */
        if ("Yes".equals(command)) {
            job.logJob();
        } else {
            System.out.println("Exit log");
        }

    }
    /**
     * Method for Viewing tickets for jobs
     */
    public void ViewTickets() {
        Tickets ticket = new Tickets();
        String command = "Yes";
        System.out.println("Current ticket ");
        /**
         * Display Ticket information and then prompt user to download
         */
        ticket.PrintTicket();
        System.out.println("If you would like to download the Ticket enter DownloadTickets");
        if ("Save".equals(command)){
            ticket.DownloadTickets();
        } else {
            System.out.println("Exit");
        }

    }

}
