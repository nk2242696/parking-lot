package io.gojek.parkinglot.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * @author nkumar
 *
 */
public final class CommandInputMap
{
	private static final Map<String, Integer> commandsParameterMap = new HashMap<>();
	
	static
	{
		commandsParameterMap.put(Constants.CREATE_PARKING_LOT, 1);
		commandsParameterMap.put(Constants.PARK, 2);
		commandsParameterMap.put(Constants.LEAVE, 1);
		commandsParameterMap.put(Constants.STATUS, 0);
		commandsParameterMap.put(Constants.REG_NUMBER_FOR_CARS_WITH_COLOR, 1);
		commandsParameterMap.put(Constants.SLOTS_NUMBER_FOR_CARS_WITH_COLOR, 1);
		commandsParameterMap.put(Constants.SLOTS_NUMBER_FOR_REG_NUMBER, 1);
	}

	private CommandInputMap() {
	}

	public static Map<String, Integer> getCommandsParameterMap()
	{
		return commandsParameterMap;
	}
	
}
