package io.gojek.parkinglot.dao;

import java.util.List;

import io.gojek.parkinglot.model.Vehicle;

/**
 * @author nkumar
 *
 */
public interface ParkingLevelDataManager<T extends Vehicle>
{
	 int parkCar(T vehicle);
	
	 boolean leaveCar(int slotNumber);
	
	 List<String> getStatus();
	
	 List<String> getRegNumberForColor(String color);
	
	 List<Integer> getSlotNumbersFromColor(String colour);
	
	 int getSlotNoFromRegistrationNo(String registrationNo);
	
	 int getAvailableSlotsCount();
	
	 void doCleanUp();
}
