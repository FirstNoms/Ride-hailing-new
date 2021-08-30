package service;

import exceptions.UserAlreadyExistsException;
import exceptions.UserNotFoundException;
import user.Passenger;

import java.util.List;

public interface PassengerService {
    void createPassenger(Passenger passenger) throws UserAlreadyExistsException;
    Passenger findPassenger(Passenger passenger) throws UserNotFoundException;
    Passenger findPassengerById(String passengerId) throws UserNotFoundException;
    List<Passenger> findPassengerByName(Passenger passenger);
    void updatePassenger(Passenger passenger);
    void deletePassenger(Passenger passenger);


}
