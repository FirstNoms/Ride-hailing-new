package user;

import java.util.Objects;

public class Passenger {
    private String passengerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Passenger)) return false;
        Passenger passenger = (Passenger) o;
        return Objects.equals(passengerId, passenger.passengerId) || Objects.equals(email, passenger.email) || Objects.equals(phoneNumber, passenger.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passengerId, email, phoneNumber);
    }

    public Passenger(String passengerId, String firstName, String lastName, String email, String phoneNumber,
                     String password) {
        this.passengerId = passengerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public String getLastName() {
        return lastName;
    }
}
