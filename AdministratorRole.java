public class AdministratorRole
{

    private int IDNumber;
    private String password;
    private String name;


    public AdministratorRole()
    {
        IDNumber = -1;
        password = "NOT INPUT";
        name = "DEFAULT";
    }

    public AdministratorRole(int IDNumber, String password, String name)
    {
        this.IDNumber = IDNumber;
        this.password = password;
        this.name = name;
    }

    public void EditEmployeeData(){
    	JobDatabase database = new JobDatabase();
    	String command = "";
    	
        System.out.println("Printing Employee Data...");
        database.printDatabase();
        System.out.println("Select Yes to Edit");
        System.out.println("Select No to Exit ");
        if (command == "Yes") {
        	System.out.println("Select fields to edit ");
        	// edit specific employee fields
        } else {
        	System.out.println("Exiting Menu ");
        }
        
    }
    public void AssignJobs(){
    	Job job = new Job();
    	String command = "";
    	
        System.out.println("Assign Job to Employee...");
        job.printJob();
        System.out.println("Please Select Options for job");
        if (command == "Yes") {
        	job.logJob();  
        } else {
        	System.out.println("Exit log");
        }
        
    }
    public void ViewTickets() {
        String command = "";
        System.out.println("Current ticket ");
        //Display Ticket information and then prompt user to download
        //.printTicket();
        System.out.println("If you would like to download the Ticket enter DownloadTickets");
        if (command == "Save"){
            DownloadTickets();
        }

    }
    public void DownloadTickets(){
        //Function to export ticket file
        System.out.println("Download ticket");
        //create ticket file
    }




}
