
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



	//default constructor
	public Job()
	{
		this.ID = -1;
		this.startLocation = "AWAITING INPUT";
		this.endLocation = "AWAITING OUTPUT";

	}


	//constructor for just ID
	public Job(int ID)
	{
		this.ID = ID;
		this.startLocation = "AWAITING INPUT";
		this.endLocation = "AWAITING OUTPUT";

	}

	//full constructor
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

	//constructor for an array of String job, used to make a job from the database
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


