package User;

public class Passenger {
    private String userId;
    private String firstName;
    private String email;
    private String phoneNumber;
    private String password;

    public Passenger(String userId, String firstName, String email, String phoneNumber, String password) {
        this.userId = userId;
        this.firstName = firstName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }
}
