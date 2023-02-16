package Objects;

public class User {

    private int CustomerID;

    private String FirstName;

    private String Surname;

    private String DateOfBirth;

    private String Email;

    private String Password;

    public User (int CustomerID, String FirstName, String Surname, String DateOfBirth, String Email, String Password){
        this.setCustomerID(CustomerID);
        this.setFirstName(FirstName);
        this.setSurname(Surname);
        this.setDateOfBirth(DateOfBirth);
        this.setEmail(Email);
        this.setPassword(Password);

    }


    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
