package GUIs;

import java.util.Date;

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
     * Method for Assigning jobs to Drivers
     */

    public void AssignJobs(TruckerRole trucker, Job job, boolean paid, String status){
        /**
         * Manually Creates a new job by assigning
         * the ID of a trucker to the job
         * for paid and status input is selected in the GUI
         */
        Job updatedJob = new Job(
                job.getID(),
                job.getStartLocation(),
                job.getEndLocation(),
                paid,
                status,
                job.getCompletionTime(),
                trucker.getIDNumber(),
                job.getJobHours(),
                job.getNotes()
        );

        /**
         * Displays the newly assigned job
         */
        System.out.println("Job assigned to: " + trucker.getName());
        System.out.println(updatedJob.printJob());
    }

    /**
     * Method for Viewing tickets for jobs
     */
    public void ViewTickets(Job job) {

        Tickets ticket = new Tickets(job);
        /**
         * Display Ticket information and then prompt user to download
         */
        System.out.println("Current ticket: ");
        System.out.println("Ticket ID: " + ticket.getID());
        System.out.println("Trucker ID: " + job.getTruckerID());
        System.out.println("Start Location: " + job.getStartLocation());
        System.out.println("End Location: " + job.getEndLocation());
        System.out.println("Job Time Completion: " + job.getCompletionTime());
        System.out.println("Job Status: " + job.getStatus());
        System.out.println("Job Paid: " + job.getPaid());
        System.out.println("Job Notes: " + job.getNotes());
    }

}
