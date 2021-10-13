package io.gojek.parkinglot.dao;

import java.util.List;

import io.gojek.parkinglot.model.Vehicle;

/**
 * @author nkumar
 *
 */
public interface ParkingDataManager<T extends Vehicle>
{
	int parkCar(int level, T vehicle);
	
	boolean leaveCar(int level, int slotNumber);
	
	List<String> getStatus(int level);
	
	List<String> getRegNumberForColor(int level, String color);
	
	List<Integer> getSlotNumbersFromColor(int level, String colour);
	
	int getSlotNoFromRegistrationNo(int level, String registrationNo);
	
	int getAvailableSlotsCount(int level);
	
	void doCleanup();
}
