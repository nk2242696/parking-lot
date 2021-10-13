package io.gojek.parkinglot.model.strategy;

/**
 * @author nkumar
 *
 */
public interface ParkingStrategy
{
	 void add(int i);
	 int getSlot();
	 void removeSlot(int slot);
}
