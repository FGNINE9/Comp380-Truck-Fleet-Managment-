package GUIs;

import java.util.Date;
import java.util.List;

/**
TruckerRole class provides methods to view trucker's current jobs,
 input Job Data, and generate weekly summary.
 @author Naery Kouyoumjian
 */
public class TruckerRole {

    private int IDNumber;
    private String password;
    private String name;
    private JobDatabase jobDatabase;  //to interact with job data
    private boolean isAdmin;   //to check if user is driver or admin

    /**
     * Default constructor for TruckerRole
     */
    public TruckerRole() {
        IDNumber = -1;
        password = "NOT INPUT";
        name = "DEFAULT";
        jobDatabase = new JobDatabase();
    }

    /**
     * Constructor for TruckerRole with parameters
     * @param IDNumber trucker's ID number
     * @param password trucker's account password
     * @param name trucker's name
     * @param isAdmin boolean to check user is admin (true) or a driver (false)
     */
    public TruckerRole(int IDNumber, String password, String name, boolean isAdmin) {
        this.IDNumber = IDNumber;
        this.password = password;
        this.name = name;
        this.jobDatabase = new JobDatabase();
        this.isAdmin = isAdmin;
    }

    /**
     * check if trucker is admin
     * @return true if admin, false if driver
    */
    public boolean isAdmin() {
        return isAdmin;
    }

    /**
     Method to view current jobs assigned to the trucker
     */
    public void viewCurrentJobs() {
         //Declare 'jobs' to hold a list of 'Job' objects
        List<Job> jobs = jobDatabase.getJobListSortedByDate();

         // check it any job is assigned
        if (jobs.isEmpty()) {
            System.out.println("No jobs assigned.");
        } else {

            // for each loop to print details of each 'Job' object in the 'jobs' list
            for (Job job : jobs) {
                System.out.println(job.printJob());
            }
        }
    }

    /** Method to input information about a job
     * @param jobID
     * @param startLocation
     * @param endLocation
     * @param paid
     * @param status
     * @param completionTime
     * @param jobHours
     * @param notes
     */
    public void inputLoadData(int jobID, String startLocation, String endLocation, boolean paid, String status, Date completionTime, int jobHours, String notes) {

        // create a new object Job for the provided details
        Job job = new Job(jobID, startLocation, endLocation, paid, status, completionTime, this.IDNumber, jobHours, notes);


        // Add the new job to the job database
        jobDatabase.addJob(job);

        //notify the trucker that data was added succesfully
        System.out.println("Job data has been added successfully for the job ID: " + jobID);
    }

    /**
     * A method that displays weekly summary
     * @return string that represents the weekly summary
     */
    public String getWeeklySummary()
    {
        // get the list of the jobs
        List<Job> jobs = jobDatabase.getJobListSortedByDate();

        int ttlJobs = 0;
        int ttlHours = 0;

        Date currDate = new Date();
        long aWeekAgo = currDate.getTime() - (7*24*60*60*1000);  //calculating one week ago from current date

        for (Job job : jobs)
        {
            if (job.getCompletionTime().getTime() >= aWeekAgo && job.getTruckerID() == this.IDNumber)
            {
                ttlJobs++;
                ttlHours += job.getJobHours();
            }
        }

        if (ttlJobs == 0)
        {
            return "No jobs completed.";
        }

        return "Weekly Summary:\n" +
                "Total Jobs this week: " + ttlJobs + ".\n" +
                "Total Hours this week: " + ttlHours + ".\n";
    }


    //setter and getters

    /**
     * Gets trucker's ID number
     * @return int returns trucker's ID number
     */
    public int getIDNumber() {
        return IDNumber;
    }

    /**
     * Sets trucker's ID number
     * @param IDNumber
     */

    public void setIDNumber(int IDNumber) {
        this.IDNumber = IDNumber;
    }

    /**
     * Gets the trucker's password
     * @return String returns Trucker's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets trucker's password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the trucker's name
     * @return string returns Trucker's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the trucker's name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}
