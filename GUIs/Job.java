package GUIs;

import java.util.Date;

public class Job
{

	//vars
	private int    ID;
	private String startLocation;
	private String endLocation;
	private boolean paid;
	private String status;
	private Date completionTime;
	private int truckerID;
	private int jobHours;
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
	 * Returns a GUIs.Job in a string, expanded view
	 * @return The GUIs.Job in a readable way
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
	 * @return the GUIs.Job in a single line, comma delineated
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

	//get and set for ID
	public int getID()
	{
		return this.ID;
	}
	private void setID(int ID)
	{
		this.ID = ID;
	}

	//get and set for startLocation
	public String getStartLocation()
	{
		return startLocation;
	}
	private void setStartLocation(String startLocation)
	{
		this.startLocation = startLocation;
	}

	//get and set for endLocation
	public String getEndLocation()
	{
		return endLocation;
	}
	private void setEndLocation(String endLocation)
	{
		this.endLocation = endLocation;
	}

	//get and set for paid
	public boolean getPaid()
	{
		return paid;
	}
	private void setPaid(boolean paid)
	{
		this.paid = paid;
	}

	//get and set for status
	public String getStatus()
	{
		return status;
	}
	private void setStatus(String status)
	{
		this.status = status;
	}

	//get and set for completionDate
	public Date getCompletionTime()
	{
		return completionTime;
	}
	private void setCompletionTime(Date completionTime)
	{
		this.completionTime = completionTime;
	}

	//get and set for truckerID
	public int getTruckerID()
	{
		return truckerID;
	}
	private void setTruckerID(int truckerID)
	{
		this.truckerID = truckerID;
	}

	//get and set for jobHours
	public int getJobHours()
	{
		return jobHours;
	}
	private void setJobHours(int jobHours)
	{
		this.jobHours = jobHours;
	}

	//get and set for notes
	public String getNotes()
	{
		return notes;
	}
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