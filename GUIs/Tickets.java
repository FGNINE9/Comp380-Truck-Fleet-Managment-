package GUIs;

public class Tickets {
    //variables
    private String ID;
    private String startlocale;
    private String endlocale;

    public Tickets(){
        ID = "Need Input";
        startlocale = "Set Begin";
        endlocale = "Set End";
    }

    public Tickets(String ID, String startlocale, String endlocale) {
        this.ID = ID;
        this.startlocale = startlocale;
        this.endlocale = endlocale;
    }

    public String PrintTicket()
    {
       return( "ID: " + ID
        +"\nStartLocale: " + startlocale
        +"\nEndLocale: " + endlocale);
    }

    public void DownloadTickets(){
        //Function should download ticket to file
        //or keep basic and say downloaded
        System.out.println("Download ticket");
        //create ticket file
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

}
