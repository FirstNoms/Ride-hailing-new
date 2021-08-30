package user;

import exceptions.UserAlreadyExistsException;
import exceptions.UserNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import service.PassengerServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class PassengerTest {
    service.PassengerServiceImpl passengerServiceImpl;
    Passenger passenger1;
    Passenger passenger2;

    @BeforeEach
    void setUp() {
        passenger1 = new Passenger("1", "Nomso", "okere", "nomso@gmail.com",
                "08134356478", "JesusLovesYou");

        passenger2 = new Passenger("2", "Jane", "ishola","jane@gmail.com",
                "09076547328", "GodLovesYou");
        passengerServiceImpl = new PassengerServiceImpl();
    }

    @Test
    @DisplayName("Create Passenger")
    void testThatPassengerCanBeCreated() throws UserAlreadyExistsException {
        //given
        Passenger passenger1 = new Passenger("1", "Nomso", "okere", "nomso@gmail.com",
                "08134356478", "JesusLovesYou");

        Passenger passenger2 = new Passenger("2", "Jane", "ishola","jane@gmail.com",
                "09076547328", "GodLovesYou");
        try {
            passengerServiceImpl.createPassenger(passenger1);
            passengerServiceImpl.createPassenger(passenger2);
        } catch (UserAlreadyExistsException UserAlreadyExistsException) {
            System.out.printf("%s: "+ UserAlreadyExistsException.getLocalizedMessage());
        }
        assertEquals(2, passengerServiceImpl.count());
    }

    @Test
    @DisplayName("Passenger Already Exists Test")
    void testThatTheSamePassengerCannotBeCreatedTwice(){
        Passenger passenger3 = new Passenger("1", "Nomso", "okere", "nomso@gmail.com",
                "08134356478", "JesusLovesYou");

        try {
            passengerServiceImpl.createPassenger(passenger1);
            passengerServiceImpl.createPassenger(passenger2);
        } catch (UserAlreadyExistsException UserAlreadyExistsException) {
            System.out.printf("%s: "+ UserAlreadyExistsException.getLocalizedMessage());
        }
        assertEquals(2, passengerServiceImpl.count());

        UserAlreadyExistsException exception = assertThrows(UserAlreadyExistsException.class,
                () -> passengerServiceImpl.createPassenger(passenger3));
        assertEquals("Passenger already exists", exception.getLocalizedMessage());
    }

    @Test
    @DisplayName("Find Passenger")
    void testToFindPassenger(){
        try {
            passengerServiceImpl.createPassenger(passenger1);
            passengerServiceImpl.createPassenger(passenger2);
        } catch (UserAlreadyExistsException UserAlreadyExistsException) {
            System.out.printf("%s: "+ UserAlreadyExistsException.getLocalizedMessage());
        }
        assertEquals(2, passengerServiceImpl.count());

        Passenger foundPassenger = null;
        try {
            foundPassenger = passengerServiceImpl.findPassenger(passenger1);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        assertNotNull(foundPassenger);
    }

    @Test
    @DisplayName("Passenger object does not exist")
    void testToThrowExceptionPassengerDoesNotExist(){
        UserNotFoundException exception = assertThrows(UserNotFoundException.class,
                ()-> passengerServiceImpl.findPassenger(passenger1));

        assertEquals("Passenger Not Found", exception.getLocalizedMessage());
    }

    @Test
    @DisplayName("Find passengerId")
    void testToFindPassengerId() throws UserNotFoundException {
        try {
            passengerServiceImpl.createPassenger(passenger1);
            passengerServiceImpl.createPassenger(passenger2);
        } catch (UserAlreadyExistsException UserAlreadyExistsException) {
            System.out.printf("%s: "+ UserAlreadyExistsException.getLocalizedMessage());
        }
        Passenger foundPassenger = passengerServiceImpl.findPassengerById("1");
        assertEquals("okere", foundPassenger.getLastName());
    }
}