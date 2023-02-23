package Admin;

public class AdminUser {

    private int EmployeeID;

    private String AdminPassword;

    private String AdminFirstName;

    private String AdminSurname;

    public AdminUser(int EmployeeID, String AdminPassword, String AdminFirstName, String AdminSurname) {

        this.EmployeeID = EmployeeID;
        this.AdminPassword = AdminPassword;
        this.AdminFirstName = AdminFirstName;
        this.AdminSurname = AdminSurname;


    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    public String getPassword() {
        return AdminPassword;
    }

    public void setPassword(String password) {
        AdminPassword = password;
    }

    public String getFirstName() {
        return AdminFirstName;
    }

    public void setFirstName(String firstName) {
        AdminFirstName = firstName;
    }

    public String getSurname() {
        return AdminSurname;
    }

    public void setSurname(String surname) {
        AdminSurname = surname;
    }


    @Override
    public String toString() {
        return "AdminUser: \n +" +
                "\n EmployeeID" + EmployeeID +
                "\n AdminFirstName" + AdminFirstName +
                "\n AdminSurname" + AdminSurname +
                "\n AdminPassword" + AdminPassword;

    }
}







