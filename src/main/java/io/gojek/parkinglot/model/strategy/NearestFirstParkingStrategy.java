package io.gojek.parkinglot.model.strategy;

import java.util.TreeSet;

/**
 * @author nkumar
 *
 */
public class NearestFirstParkingStrategy implements ParkingStrategy
{
	private final TreeSet<Integer> freeSlots;
	
	public NearestFirstParkingStrategy()
	{
		freeSlots = new TreeSet<>();
	}
	
	@Override
	public void add(int i)
	{
		freeSlots.add(i);
	}
	
	@Override
	public int getSlot()
	{
		return freeSlots.first();
	}
	
	@Override
	public void removeSlot(int availableSlot)
	{
		freeSlots.remove(availableSlot);
	}
}
