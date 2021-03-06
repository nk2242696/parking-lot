package io.gojek.parkinglot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import io.gojek.parkinglot.exception.ErrorCode;
import io.gojek.parkinglot.exception.ParkingException;
import io.gojek.parkinglot.processor.AbstractProcessor;
import io.gojek.parkinglot.processor.RequestProcessor;
import io.gojek.parkinglot.service.impl.ParkingServiceImpl;

/**
 * Hello world!
 *
 */
public class Main
{
	public static void main(String[] args)
	{
		AbstractProcessor processor = new RequestProcessor();
		processor.setService(new ParkingServiceImpl());
		BufferedReader bufferReader = null;
		String input;
		try
		{
			System.out.println("===================================================================");
			System.out.println("===================      GOJEK PARKING LOT     ====================");
			System.out.println("===================================================================");
			printUsage();
			switch (args.length)
			{
				case 0: // Interactive: command-line input/output
				{
					System.out.println("Please Enter 'exit' to end Execution");
					System.out.println("Input:");
					while (true)
					{
						try
						{
							bufferReader = new BufferedReader(new InputStreamReader(System.in));
							input = bufferReader.readLine().trim();
							if (input.equalsIgnoreCase("exit"))
							{
								break;
							}
							else
							{
								if (processor.validate(input))
								{
									processor.execute(input.trim());
								}
								else
								{
									printUsage();
								}
							}
						}
						catch (Exception e)
						{
							throw new ParkingException(ErrorCode.INVALID_REQUEST.getMessage(), e);
						}
					}
					break;
				}
				case 1:// File input/output
				{
					File inputFile = new File(args[0]);
					try
					{
						bufferReader = new BufferedReader(new FileReader(inputFile));
						int lineNo = 1;
						while ((input = bufferReader.readLine()) != null)
						{
							input = input.trim();
							if (processor.validate(input))
							{
								processor.execute(input);
							}
							else
								System.out.println("Incorrect Command Found at line: " + lineNo + " ,Input: " + input);
							lineNo++;
						}
					}
					catch (Exception e)
					{
						throw new ParkingException(ErrorCode.INVALID_FILE.getMessage(), e);
					}
					break;
				}
				default:
					System.out.println("Invalid input. Usage Style: java -jar <jar_file_path> <input_file_path>");
			}
		}
		catch (ParkingException e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		finally
		{
			try
			{
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void printUsage()
	{
		String buffer = "--------------Please Enter one of the below commands. {variable} to be replaced -----------------------" +
				"\n" +
				"A) For creating parking lot of size n               ---> create_parking_lot {capacity}" +
				"\n" +
				"B) To park a car                                    ---> park <<car_number>> {car_clour}" +
				"\n" +
				"C) Remove(Unpark) car from parking                  ---> leave {slot_number}" +
				"\n" +
				"D) Print status of parking slot                     ---> status" + "\n" +
				"E) Get cars registration no for the given car color ---> registration_numbers_for_cars_with_color {car_color}" +
				"\n" +
				"F) Get slot numbers for the given car color         ---> slot_numbers_for_cars_with_color {car_color}" +
				"\n" +
				"G) Get slot number for the given car number         ---> slot_number_for_registration_number {car_number}" +
				"\n";
		System.out.println(buffer);
	}
}
