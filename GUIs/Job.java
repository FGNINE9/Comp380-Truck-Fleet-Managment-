package GUIs;

import java.util.Date;

/**
 * Job object, used to create and manipulate jobs
 * @authos Sebastian Borner
 */
public class Job
{

	/**
	 * The {@link Integer} ID number of the Job.
	 */
	private int    ID;

	/**
	 * The {@link String} location where the job starts.
	 */
	private String startLocation;

	/**
	 * The {@link String} location where the job ends.
	 */
	private String endLocation;

	/**
	 * The {@link Boolean} whether the job is paid.
	 */
	private boolean paid;

	/**
	 * The {@link String} status of the job.
	 */
	private String status;

	/**
	 * The {@link Date} when the job was completed.
	 */
	private Date completionTime;

	/**
	 * The {@link Integer} ID of the trucker this job is assigned to.
	 */
	private int truckerID;

	/**
	 * The {@link Integer} number of hours the job will take to complete.
	 */
	private int jobHours;

	/**
	 * The {@link String} special notes for the job.
	 */
	private String notes;


	/**
	 * Default constructor for a GUIs.Job<br>
	 * Sets the ID to -1, then the rest of the variables will be null or 0
	 */
	public Job()
	{
		this.ID = -1;
		this.startLocation = "AWAITING INPUT";
		this.endLocation = "AWAITING OUTPUT";
	}

	/**
	 * A full constructor for a GUIs.Job.<br>
	 * Used when manually creating a job
	 *
	 * @param ID the job ID
	 * @param startLocation where the GUIs.Job begins
	 * @param endLocation where the GUIs.Job ends
	 * @param paid whether the job has been paid
	 * @param status current status of the load
	 * @param truckerID ID of the trucker assigned to this GUIs.Job
	 * @param jobHours amount of hours this GUIs.Job will take to complete
	 * @param notes any extra information
	 */
	public Job(int ID, String startLocation, String endLocation, boolean paid, String status,Date completionTime, int truckerID, int jobHours, String notes)
	{
		this.ID = ID;
		this.startLocation = startLocation;
		this.endLocation = endLocation;
		this.paid = paid;
		this.status = status;
		this.completionTime = completionTime;
		this.truckerID = truckerID;
		this.jobHours = jobHours;
		this.notes = notes;
	}

	/**
	 * Constructor for a GUIs.Job that takes a string array sized 8<br>
	 * Used to create a job from a string read from the database text file
	 * @param in the string array sized 8 of all the inputs
	 */
	public Job(String[] in)
	{
		this.ID = Integer.parseInt(in[0]);
		this.startLocation = in[1];
		this.endLocation = in[2];
		this.paid = Boolean.parseBoolean(in[3]);
		this.status = in[4];
		this.completionTime = new Date(in[5]);
		this.truckerID = Integer.parseInt(in[6]);
		this.jobHours = Integer.parseInt(in[7]);
		this.notes = in[8];
	}


	/**
	 * Returns a Job in a string, expanded view
	 * @return The Job in a readable way
	 */
	public String printJob()
	{
		return("GUIs.Job report for job #" +ID
				+"\nStart: " + startLocation
				+"\nEnd: " + endLocation
				+"\nPaid: " + paid
				+"\nStatus: " + status
				+"\ncompletionTime" + completionTime
				+"\nAssigned to: "+truckerID
				+"\nHours: " + jobHours
				+"\nNotes: " + notes);
	}


	/**
	 * Turns a job into a line to be inputted into the database<br>
	 * @return the Job in a single line, comma delineated
	 */
	public String logJob()
	{
		return(ID +", " + startLocation
				  +", " + endLocation
				  +", " + paid
				  +", " + status
				  +", " + completionTime
				  +", "+truckerID
				  +", " + jobHours
				  +", " + notes+"\n");
	}



	//----------------------------------------------------//
	//                 Getters and Setters                //
	//----------------------------------------------------//

	/**
	 * Getter for ID
	 * @return int ID
	 */
	public int getID()
	{
		return this.ID;
	}
	/**
	* Setter for ID
	 * @param ID int
	*/
	private void setID(int ID)
	{
		this.ID = ID;
	}

	/**
	 * Getter for StartLocation
	 * @return string StartLocation
	 */
	public String getStartLocation()
	{
		return startLocation;
	}

	/**
	 * Setter for StartLocation
	 * @param startLocation string
	 */
	private void setStartLocation(String startLocation)
	{
		this.startLocation = startLocation;
	}

	/**
	 * Getter for endLocation
	 * @return String endLocation
	 */
	public String getEndLocation()
	{
		return endLocation;
	}
	/**
	 * Setter for endLocation
	 * @param endLocation string
	 */
	private void setEndLocation(String endLocation)
	{
		this.endLocation = endLocation;
	}

	/**
	 * Getter for paid
	 * @return boolean paid
	 */
	public boolean getPaid()
	{
		return paid;
	}

	/**
	 * Setter for paid
	 * @param paid boolean
	 */
	private void setPaid(boolean paid)
	{
		this.paid = paid;
	}

	/**
	 * Getter for status
	 * @return String status
	 */
	public String getStatus()
	{
		return status;
	}

	/**
	 * Setter for status
	 * @param status string
	 */
	private void setStatus(String status)
	{
		this.status = status;
	}

	/**
	 * Getter for completionTime
	 * @return Date completionTime
	 */
	public Date getCompletionTime()
	{
		return completionTime;
	}

	/**
	 * Setter for completionTime
	 * @param completionTime Date
	 */
	private void setCompletionTime(Date completionTime)
	{
		this.completionTime = completionTime;
	}

	/**
	 * Getter for truckerID
	 * @return int truckerID
	 */
	public int getTruckerID()
	{
		return truckerID;
	}

	/**
	 * Setter for truckerID
	 * @param truckerID int
	 */
	private void setTruckerID(int truckerID)
	{
		this.truckerID = truckerID;
	}

	/**
	 * Getter for jobHours
	 * @return int jobHours
	 */
	public int getJobHours()
	{
		return jobHours;
	}

	/**
	 * Setter for jobHours
	 * @param jobHours int
	 */
	private void setJobHours(int jobHours)
	{
		this.jobHours = jobHours;
	}

	/**
	 * Getter for notes
	 * @return String notes
	 */
	public String getNotes()
	{
		return notes;
	}

	/**
	 * Setter for notes
	 * @param notes String
	 */
	private void setNotes(String notes)
	{
		this.notes = notes;
	}

}



//----------------------------------------------------//
//                 Comparators                        //
//----------------------------------------------------//


/**
 * Comparator for sorting jobs by ID number
 */
class JobIDComparator implements java.util.Comparator<Job>
{
	@Override
	public int compare(Job a, Job b)
	{
		return a.getID() - b.getID();
	}
}

/**
 * Comparator for sorting jobs by date number
 */
class JobCompletionTimeComparator implements java.util.Comparator<Job>
{
	@Override
	public int compare(Job a, Job b)
	{
		return a.getCompletionTime().compareTo(b.getCompletionTime());
	}
}