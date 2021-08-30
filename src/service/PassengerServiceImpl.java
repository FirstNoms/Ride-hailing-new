package service;

import database.PassengerDb;
import exceptions.UserAlreadyExistsException;
import exceptions.UserNotFoundException;
import user.Passenger;

import java.util.List;

public class PassengerServiceImpl implements PassengerService {

    private final PassengerDb passengerDb;

    public PassengerServiceImpl(){
        passengerDb = new PassengerDb();
    }

    @Override
    public void createPassenger(Passenger passenger) throws UserAlreadyExistsException {
        if (passengerDb.contains(passenger)){
            throw new UserAlreadyExistsException("Passenger already exists");
        }
        passengerDb.save(passenger);
    }

    @Override
    public Passenger findPassenger(Passenger passenger) throws UserNotFoundException {
        Passenger foundPassenger = passengerDb.find(passenger);

        return foundPassenger;
    }

    @Override
    public Passenger findPassengerById(String passengerId) throws UserNotFoundException {
        Passenger foundPassenger = passengerDb.findById(passengerId);
        return foundPassenger;
    }

    @Override
    public List<Passenger> findPassengerByName(Passenger passenger) {
        return null;
    }

    @Override
    public void updatePassenger(Passenger passenger) {
        
    }

    @Override
    public void deletePassenger(Passenger passenger) {

    }

    public long  count(){
        return passengerDb.count();
    }

}
