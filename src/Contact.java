public class Contact {
    private String name;
    private String firstName;
    private String lastName;
    private String number;

    //Empty constructor
    public Contact(){}

    public Contact(String[] contactInformation){
        this.name = contactInformation[0];
        this.number = contactInformation[1];
    }

    public Contact(String firstName, String number){
        this.firstName = firstName;
        this.number = number;
    }
    public Contact(String firstName, String lastName, String number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
