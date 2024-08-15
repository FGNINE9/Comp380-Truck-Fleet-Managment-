package GUIs;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;


/**
 * Database of Jobs<br>
 * Keeps an {@link ArrayList} of jobs<br>
 * Also holds methods used to handle and sort the database.
 * @author Sebastian Borner
 */
public class JobDatabase
{
    /**
     * All the Jobs in the Database
     */
    private ArrayList<Job> jobList;

    //default constructor for jobDatabase
    /**
    * This is the default constructor for a GUIs.JobDatabase<br>
    * Uses the buildDatabaseFromFile method after initializing the arrayList of jobs to fill it in
    */
    public JobDatabase()
    {
        jobList = new ArrayList<>();
        buildDatabaseFromFile();//run this method to set up a new database based on our text file
    }

    /**
     * Method mostly for testing used to get a job by its number orderwise on the list
     * @param target gets a specific job by number on the list
     * @return Job the job at element target
     */
    public Job getJob(int target)
    {
        return jobList.get(target);
    }

    /**
     * Method to add a job into the database.<br>
     * Writes to the database to update it in case you close the file.<br>
     * Will return false and not input the job if another job exists with the same job ID number
     * @param newJob the GUIs.Job to be added into the database
     * @return boolean returns true if the method worked<br> returns false if there exists a job in the jobDatabase that shares the same ID number or if it contains a pipe anywhere
     */
    public boolean addJob(Job newJob)
    {
        int newJobID = newJob.getID();

        //check to see if the new job contains a pipe, which would break the database
        if(newJob.printJob().contains("|"))
        {
            System.out.println("JOBDATABASE ERROR: job contains a \"|\" which is not allowed");
            return false;
        }

        //look to see if the jobsList already contains a job with the ID number
        for (Job job : jobList)
        {
            if (job.getID() == newJobID)
            {
                System.out.println("JOBDATABASE ERROR: job already exists with that job ID number");
                return false;
            }
        }//for end

        System.out.println("ADDING JOB  "+newJob.getID());
        //victory state
        jobList.add(newJob);
        writeDatabase();
        return true;
    }


    /**
     * Method used to remove a job from the database <br>
     * Deletes a job by ID, if two jobs exist with the same ID(which shouldnt happen),<br>
     * instead deletes the first job on the list
     * @param ID the ID number of the job you want to remove
     * @return boolean returns true if a job was removed
     */
    public boolean removeJob(int ID)
    {
        //iterate through the list of jobs to find the first one matching the ID
        for(int i=0;i<jobList.size();i++)
        {
            if(jobList.get(i).getID() == ID)
            {
                jobList.remove(i);
                writeDatabase();
                return true;
            }
        }
        return false;
    }

    /**
     * Method used to "start" a job, it sets the status to "In Progress"
     * @param job
     */
    public void startJob(Job job)
    {
        int jobID = job.getID();
        String startLocation = job.getStartLocation();
        String endLocation = job.getEndLocation();
        Boolean paid = job.getPaid();
        //status will be "In Progress"
        Date completionTime = job.getCompletionTime();
        int truckerId = job.getTruckerID();
        int jobHours = job.getJobHours();
        String notes = job.getNotes();

        jobList.remove(job);
        jobList.add(new Job(jobID, startLocation, endLocation, paid, "In Progress", completionTime, truckerId, jobHours, notes));

    }

    /**
     * Method that updates the start location of a job
     * @param job the job to be updated
     * @param newStartLocation the new start location for the job
     */
    public void updateStartLocation(Job job, String newStartLocation){
        int jobID = job.getID();
        String endLocation = job.getEndLocation();
        Boolean paid = job.getPaid();
        String status = job.getStatus();
        Date completionTime = job.getCompletionTime();
        int truckerId = job.getTruckerID();
        int jobHours = job.getJobHours();
        String notes = job.getNotes();

        jobList.remove(job);
        jobList.add(new Job(jobID, endLocation, newStartLocation, paid, status, completionTime, truckerId, jobHours, notes));
        writeDatabase();
    }


    /**
     * Method that updates the end location of a job
     * @param job the job to be updated
     * @param newEndLocation the new end location for the job
     */
    public void updateEndLocation(Job job, String newEndLocation){
        int jobID = job.getID();
        String startLocation = job.getStartLocation();
        Boolean paid = job.getPaid();
        String status = job.getStatus();
        Date completionTime = job.getCompletionTime();
        int truckerId = job.getTruckerID();
        int jobHours = job.getJobHours();
        String notes = job.getNotes();

        jobList.remove(job);
        jobList.add(new Job(jobID, startLocation, newEndLocation, paid, status, completionTime, truckerId, jobHours, notes));
        writeDatabase();
    }


    /**
     * Prints the database<br>
     * Calls printJob() for each job in the database's arraylist
     * @return a string of all the jobs in a printable form
     */
    public String printDatabase()
    {
        String output ="+++++++++++++++++++++++\n  Printing Database\n\n";

        for (Job job : jobList)
        {
            output += job.printJob() + "\n\n";
        }

        output +="+++++++++++++++++++++++";
        return output;
    }


    /**
     * Method used to print out all jobs in a log form, used for testing
     * @return returns a string of all jobs in log form
     */
    public String logDatabase()
    {
        String output ="";

        for (Job job : jobList)
        {
            output += job.logJob() + "\n";
        }


        return output;
    }

    /**
     * Writes the current arraylist of jobs into the database text file.<br>
     * The file can be found in the source directory of this project
     * @return returns the success or failure of this method
     */
    private boolean writeDatabase()
    {

       // System.out.println("Writing Database");

        try
        {
            //set up a writer
            File target = new File("database.txt");
            BufferedWriter writer = null;
            writer = new BufferedWriter(new FileWriter(target));

            for (Job job : jobList)
            {
                writer.write(job.logJob());
            }

            writer.close();
        }//end try

        catch(IOException | RuntimeException e)
        {
            System.out.println(e.toString()+"\n");
            System.out.println("writer is having issues");
            return false;
        }

        return true;
    }

    /**
     * Reads the database text file and writes it into the database.<br>
     * Used in the default constructor for GUIs.JobDatabase in an effort to make things easier.<br>
     * @return returns the success or failure of this method
     */
    private boolean buildDatabaseFromFile()
    {
        try
        {

            File target = new File("database.txt");
            FileReader fileReader = new FileReader(target);
            BufferedReader br = new BufferedReader(fileReader);

            String line;

            while(br.ready())
            {
                line = br.readLine();
                String[] readJob = line.split("\\|");

                //remove the whitespace that keeps getting tacked on
                for(int i=0;i<readJob.length;i++)
                {
                    readJob[i] = readJob[i].trim();
                }
                this.addJob(new Job(readJob));

            }//while end

        } //try end

        catch(IOException e)
        {
            System.out.println("MISSING DATABASE FILE");
            return false;
        }

        return true;
    }

    /**
     * Method used to get the list of jobs in the database ordered by ID
     * @return a sorted ArrayList of jobs
     */
    public ArrayList<Job> getJobListSortedByID()
    {
        ArrayList<Job> output = jobList;

        output.sort(new JobIDComparator());

        return output;
    }

    /**
     * Method used to get the list of jobs in the database ordered by Date
     * @return a sorted ArrayList of jobs
     */
    public ArrayList<Job> getJobListSortedByDate()
    {
        ArrayList<Job> output = jobList;

        output.sort(new JobIDComparator());

        return output;
    }


    /**
     * Method used to get the list of jobs in the database ordered by startLocation
     * @return a sorted ArrayList of jobs
     */
    public ArrayList<Job> getJobListSortedByStartingLocation()
    {
        ArrayList<Job> output = jobList;

        output.sort(new JobStartLocationComparator());

        return output;
    }


    /**
     * Method used to get the list of jobs in the database ordered by endLocation
     * @return a sorted ArrayList of jobs
     */
    public ArrayList<Job> getJobListSortedByEndLocation()
    {
        ArrayList<Job> output = jobList;

        output.sort(new JobEndLocationComparator());

        return output;
    }


    /**
     * Method used to get the list of jobs in the database ordered by endLocation
     * @return a sorted ArrayList of jobs
     */
    public ArrayList<Job> getJobListPaid()
    {
        ArrayList<Job> output = jobList;

        output.sort(new JobPaidComparator());

        return output;
    }

    /**
     * Method used to get the list of jobs in the database ordered by endLocation
     * @return a sorted ArrayList of jobs
     */
    public ArrayList<Job> getJobListStatus()
    {
        ArrayList<Job> output = jobList;

        output.sort(new JobStatusComparator());

        return output;
    }



}


