package GUIs;


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
    	String command = "Yes";
    	
        System.out.println("Printing Employee Data...");
        database.printDatabase();
        System.out.println("Select Yes to Edit");
        System.out.println("Select No to Exit ");
        if ("Yes".equals(command)) {
        	System.out.println("Select fields to edit ");
        	// edit specific employee fields
        } else {
        	System.out.println("Exiting Menu ");
        }
        
    }
    public void AssignJobs(){
    	Job job = new Job();
    	String command = "Yes";
    	
        System.out.println("Assign GUIs.Job to Employee...");
        job.printJob();
        System.out.println("Please Select Options for job");
        if ("Yes".equals(command)) {
        	job.logJob();  
        } else {
        	System.out.println("Exit log");
        }
        
    }
    public void ViewTickets() {
        Tickets ticket = new Tickets();
        String command = "Yes";
        System.out.println("Current ticket ");
        //Display Ticket information and then prompt user to download
        ticket.PrintTicket();
        System.out.println("If you would like to download the Ticket enter DownloadTickets");
        if ("Save".equals(command)){
            ticket.DownloadTickets();
        } else {
            System.out.println("Exit");
        }

    }

}
