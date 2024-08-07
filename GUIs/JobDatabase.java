package GUIs;

import java.io.*;
import java.util.ArrayList;

public class JobDatabase
{
    //ArrayList of all jobs in the database
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
     * Method mostly for testing used to get a job by its number oderwise on the list
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
     * @param job the GUIs.Job to be added into the database
     * @return boolean returns true if the method worked
     */
    public boolean addJob(Job job)
    {
        int newJobID = job.getID();
        int failflag =0;

        //look to see if the jobslist already contains a job with the ID number
        for(int i=0; i<jobList.size(); i++)
        {
            if(jobList.get(i).getID() == newJobID)
            {
            System.out.println("JOBDATABASE ERROR: job already exists with that job ID number");
            return false;
            }
        }
        System.out.println("ADDING JOB  "+job.getID());
        //victory state
        jobList.add(job);
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
     * Prints the database<br>
     * Calls printJob() for each job in the database's arraylist
     * @return a string of all the jobs in a printable form
     */
    public String printDatabase()
    {
        String output ="+++++++++++++++++++++++"
                      +"\n  Printing Database\n\n";

        for(int i=0;i<jobList.size();i++)
        {
            output += jobList.get(i).printJob() + "\n\n";
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

        for(int i=0;i<jobList.size();i++)
        {
            output += jobList.get(i).logJob()+"\n";
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

            for(int i=0;i<jobList.size();i++)
            {
                writer.write(jobList.get(i).logJob());
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

            String line = "";

            while(br.ready())
            {
                line = br.readLine();
                String[] readJob = line.split(",");

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



    public ArrayList<Job> getJobListSortedByID()
    {
        ArrayList<Job> output = jobList;

        output.sort(new JobIDComparator());

        return output;
    }


    public ArrayList<Job> getJobListSortedByDate()
    {
        ArrayList<Job> output = jobList;

        output.sort(new JobIDComparator());

        return output;
    }


}


