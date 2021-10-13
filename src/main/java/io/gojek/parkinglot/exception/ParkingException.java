package io.gojek.parkinglot.exception;

public class ParkingException extends Exception
{
	private static final long serialVersionUID = -3552275262672621625L;

	public ParkingException(String message, Throwable throwable)
	{
		super(message, throwable);
	}

	public ParkingException(String message)
	{
		super(message);
	}

}
