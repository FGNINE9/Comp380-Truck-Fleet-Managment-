
public class Job 
{

	//vars
	private int ID;
	private String startLocation;
	private String endLocation;
	private boolean paid;
	private String status;
	private int truckerID;
	private int jobHours;
	private String notes;


	/**
	 * Default constructor for a Job<br>
	 * Sets the ID to -1, then the rest of the variables will be null or 0
	 */
	public Job()
	{
		this.ID = -1;
		this.startLocation = "AWAITING INPUT";
		this.endLocation = "AWAITING OUTPUT";
	}

	/**
	 * A full constructor for a Job.<br>
	 * Used when manually creating a job
	 *
	 * @param ID the job ID
	 * @param startLocation where the Job begins
	 * @param endLocation where the Job ends
	 * @param paid whether the job has been paid
	 * @param status current status of the load
	 * @param truckerID ID of the trucker assigned to this Job
	 * @param jobHours amount of hours this Job will take to complete
	 * @param notes any extra information
	 */
	public Job(int ID, String startLocation, String endLocation, boolean paid, String status, int truckerID, int jobHours, String notes)
	{
		this.ID = ID;
		this.startLocation = startLocation;
		this.endLocation = endLocation;
		this.paid = paid;
		this.status = status;
		this.truckerID = truckerID;
		this.jobHours = jobHours;
		this.notes = notes;
	}

	/**
	 * Constructor for a Job that takes a string array sized 8<br>
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
		this.truckerID = Integer.parseInt(in[5]);
		this.jobHours = Integer.parseInt(in[6]);
		this.notes = in[7];
	}


	/**
	 * Returns a Job in a string, expanded view
	 * @return The Job in a readable way
	 */
	public String printJob()
	{
		return("Job report for job #" +ID
				+"\nStart: " + startLocation
				+"\nEnd: " + endLocation
				+"\nPaid: " + paid
				+"\nStatus: " + status
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


