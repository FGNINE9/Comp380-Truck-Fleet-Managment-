package GUIs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 * Class for defining all functions of the Tickets
 */
public class Tickets {
    /**
     * Global Variables used for the tickets
     * Notice ID is String instead of Int
     */
    private String ID;
    private String startlocale;
    private String endlocale;
    private boolean paid;
    private String status;
    private Date completionTime;
    private int truckerID;
    private int jobHours;
    private String notes;

    /**
     * Default constructor for the Tickets method
     */
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

    /**
     * Full Constructor for the tickets method with the following params
     * @param ID ticket ID String
     * @param startlocale Start location
     * @param endlocale Ending location
     * @param paid boolean value for paid or not paid
     * @param status completed or not completed
     * @param completionTime time it took to complete
     * @param truckerID Drivers ID
     * @param jobHours Drivers total hours
     * @param notes Additional info
     */
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

    /**
     * Constructor for that takes the data from Job
     * to populate ticket info
     * @param job association with the job class
     */
    public Tickets(Job job) {
        /**
         * takes the Int value and returns the String value for ticket
         * @param ID ticket ID String
         * @param startlocale Start location
         * @param endlocale Ending location
         * @param paid boolean value for paid or not paid
         * @param status completed or not completed
         * @param completionTime time it took to complete
         * @param truckerID Drivers ID
         * @param jobHours Drivers total hours
         * @param notes Additional info
         */
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

    /**
     * Method for printing tickets
     * @return String
     */
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

    /**
     * Method for downloading tickets to file
     */
    public void DownloadTickets(){
        File file = new File("tickets.txt");

        try {
            /**
             * create writer
             */
            FileWriter writer = new FileWriter(file);

            /**
             * Write tickets
             * Update as needed
             */
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

    /**
     * get the value of ID
     * @return String
     */
    public String getID() {return ID;}
    /**
     * Set value of ID
     * @param ID String output of int ID
     */
    public void setID(String ID) {this.ID = ID;}

    /**
     * get the value of Startlocale
     * @return String
     */
    public String getStartlocale() {return startlocale;}
    /**
     * Set value of Startlocale
     * @param startlocale The Starting location
     */
    public void setStartlocale(String startlocale) {this.startlocale = startlocale;}

    /**
     * get the value of Endlocale
     * @return String
     */
    public String getEndlocale() {return endlocale;}
    /**
     * Set value of Endlocale
     * @param endlocale The Ending Location
     */
    public void setEndlocale(String endlocale) {this.endlocale = endlocale;}

    /**
     * get the truth value of paid
     * @return boolean
     */
    public boolean isPaid() {return paid;}
    /**
     * Set value of Paid
     * @param paid boolean value of paid
     */
    public void setPaid(boolean paid) {this.paid = paid;}

    /**
     * get the value of status
     * @return String
     */
    public String getStatus() {return status;}
    /**
     * Set value of Status
     * @param status if load is completed
     */
    public void setStatus(String status) {this.status = status;}

    /**
     * get the value of CompletionTime
     * @return Date
     */
    public Date getCompletionTime() {return completionTime;}
    /**
     * Set value of CompletionTime
     * @param completionTime time it took to complete load
     */
    public void setCompletionTime(Date completionTime) {this.completionTime = completionTime;}

    /**
     * get the value of Trucker ID
     * @return int
     */
    public int getTruckerID() {return truckerID;}
    /**
     * Set value of TruckerID
     * @param truckerID Int ID of the driver
     */
    public void setTruckerID(int truckerID) {this.truckerID = truckerID;}

    /**
     * get the value of JobHours
     * @return int
     */
    public int getJobHours() {return jobHours;}
    /**
     * Set value of JobHours
     * @param jobHours how many hours the driver currently has
     */
    public void setJobHours(int jobHours) {this.jobHours = jobHours;}

    /**
     * get the value of Notes
     * @return String
     */
    public String getNotes() {return notes;}
    /**
     * Set value of Notes
     * @param notes additional notes
     */
    public void setNotes(String notes) {this.notes = notes;}

}
