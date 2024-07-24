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





}
