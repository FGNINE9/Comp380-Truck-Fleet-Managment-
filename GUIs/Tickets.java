package GUIs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Tickets {
    //variables
    private String ID;
    private String startlocale;
    private String endlocale;
    private boolean paid;
    private String status;
    private Date completionTime;
    private int truckerID;
    private int jobHours;
    private String notes;

    //default constructor
    public Tickets(){
        ID = "Need Input";
        startlocale = "Set Begin";
        endlocale = "Set End";
        paid = false;
        status = "Not Set";
        completionTime = new Date();
        truckerID = -1;
        jobHours = 0;
        notes = "No notes";
    }

    // Constructor for creating a ticket
    public Tickets(String ID, String startlocale, String endlocale, boolean paid, String status, Date completionTime, int truckerID, int jobHours, String notes) {
        this.ID = ID;
        this.startlocale = startlocale;
        this.endlocale = endlocale;
        this.paid = paid;
        this.status = status;
        this.completionTime = completionTime;
        this.truckerID = truckerID;
        this.jobHours = jobHours;
        this.notes = notes;
    }

    // Constructor for that takes the data from Job
    public Tickets(Job job) {
        this.ID = String.valueOf(job.getID());
        this.startlocale = job.getStartLocation();
        this.endlocale = job.getEndLocation();
        this.paid = job.getPaid();
        this.status = job.getStatus();
        this.completionTime = job.getCompletionTime();
        this.truckerID = job.getTruckerID();
        this.jobHours = job.getJobHours();
        this.notes = job.getNotes();

    }

    //Method to Print Tickets
    public String PrintTicket()
    {
        return( "ID: " + ID
                + "\nStartLocale: " + startlocale
                + "\nEndLocale: " + endlocale
                + "\nPaid: " + paid
                + "\nStatus: " + status
                + "\nCompletion Time: " + completionTime
                + "\nTrucker ID: " + truckerID
                + "\nJob Hours: " + jobHours
                + "\nNotes: " + notes);
    }

    //Method to download ticket to file
    public void DownloadTickets(){
        File file = new File("tickets.txt");

        try {
            //create writer
            FileWriter writer = new FileWriter(file);

            //Write tickets
            //Update as needed
            writer.write("ID: " + ID+ "\n");
            writer.write("StartLocale: " + startlocale + "\n");
            writer.write("EndLocale: " + endlocale + "\n");
            writer.write("Paid: " + paid + "\n");
            writer.write("Status: " + status + "\n");
            writer.write("Completion Time: " + completionTime + "\n");
            writer.write("Trucker ID: " + truckerID + "\n");
            writer.write("Job Hours: " + jobHours + "\n");
            writer.write("Notes: " + notes);


            writer.close();
            System.out.println("Tickets Downloaded");
        } // end try
        catch (IOException e) {
            System.out.println("Error downloading tickets");
        }

    }

    //------------------------------//
    //      Getter and Setters      //
    //------------------------------//
    public String getID() {return ID;}
    public void setID(String ID) {this.ID = ID;}

    public String getStartlocale() {return startlocale;}
    public void setStartlocale(String startlocale) {this.startlocale = startlocale;}

    public String getEndlocale() {return endlocale;}
    public void setEndlocale(String endlocale) {this.endlocale = endlocale;}

    public boolean isPaid() {return paid;}
    public void setPaid(boolean paid) {this.paid = paid;}

    public String getStatus() {return status;}
    public void setStatus(String status) {this.status = status;}

    public Date getCompletionTime() {return completionTime;}
    public void setCompletionTime(Date completionTime) {this.completionTime = completionTime;}

    public int getTruckerID() {return truckerID;}
    public void setTruckerID(int truckerID) {this.truckerID = truckerID;}

    public int getJobHours() {return jobHours;}
    public void setJobHours(int jobHours) {this.jobHours = jobHours;}

    public String getNotes() {return notes;}
    public void setNotes(String notes) {this.notes = notes;}

}
