import java.io.*;
import java.util.ArrayList;


public class JobDatabase
{

    private ArrayList<Job> jobList;

    //default constructor for jobDatabase
    public JobDatabase()
    {
        jobList = new ArrayList<>();
        buildDatabsaeFromFile();
    }



    public boolean addJob(Job job)
    {
        jobList.add(job);

        writeDatabase();
        return true;
    }

    public String printDatabse()
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

    private boolean writeDatabase()
    {
            try
            {

                //set up a writer, that makes a new log file each day
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

    private boolean buildDatabsaeFromFile()
    {
        try {

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

                for(int i=0;i<readJob.length;i++)
                {
                    System.out.print("  |"+readJob[i]);
                }

                System.out.print("\n out of for \n");

                this.addJob(new Job(readJob));

                System.out.print("\n after job make \n");


            }

        } catch(IOException e)
        {
            System.out.println("MISSING DATABASE FILE");
            return false;
        }

        return true;
    }


}
