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
     * Method to add a job into the database.<br>
     * Writes to the database to update it in case you close the file.
     * @param job the GUIs.Job to be added into the database
     */
    public void addJob(Job job)
    {
        jobList.add(job);
        writeDatabase();
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
     * Writes the current arraylist of jobs into the database text file.<br>
     * The file can be found in the source directory of this project
     * @return returns the success or failure of this method
     */
    private boolean writeDatabase()
    {
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

}
