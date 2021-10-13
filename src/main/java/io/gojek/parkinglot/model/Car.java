package io.gojek.parkinglot.model;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * @author nkumar
 *
 */
public class Car extends Vehicle
{
	
	public Car(String registrationNo, String color)
	{
		super(registrationNo, color);
	}

	public Car(){
		super("","");
	}
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException
	{
		super.writeExternal(out);
	}
	
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
	{
		super.readExternal(in);
	}
}
