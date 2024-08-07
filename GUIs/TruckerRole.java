package GUIs;

import java.util.Date;
import java.util.List;


public class TruckerRole {

    private int IDNumber;
    private String password;
    private String name;
    private JobDatabase jobDatabase;  //to interact with job data

    public TruckerRole() {
        IDNumber = -1;
        password = "NOT INPUT";
        name = "DEFAULT";
        jobDatabase = new JobDatabase();
    }

    public TruckerRole(int IDNumber, String password, String name) {
        this.IDNumber = IDNumber;
        this.password = password;
        this.name = name;
        this.jobDatabase = new JobDatabase();
    }

    //Method to view current jobs assigned to the trucker
    public void viewCurrentJobs() {
        //Declare 'jobs' to hold a list of 'Job' objects
        List<Job> jobs = jobDatabase.getJobListSortedByDate();

        //check it any job is assigned
        if (jobs.isEmpty()) {
            System.out.println("No jobs assigned.");
        } else {
            //for-each loop to print details of each 'Job' object in the 'jobs' list
            for (Job job : jobs) {
                System.out.println(job.printJob());
            }
        }
    }

    //Method to input information about a job
    public void inputLoadData(int jobID, String startLocation, String endLocation, boolean paid, String status, Date completionTime, int jobHours, String notes) {
        //create a new object Job for the provided details
        Job job = new Job(jobID, startLocation, endLocation, paid, status, completionTime, this.IDNumber, jobHours, notes);

        // Add the new job to the job database
        jobDatabase.addJob(job);

        //notify the trucker that data was added succesfully
        System.out.println("Load data has been added successfully for the job ID: " + jobID);
    }


    //setter and getters

    public int getIDNumber() {
        return IDNumber;
    }

    public void setIDNumber(int IDNumber) {
        this.IDNumber = IDNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
