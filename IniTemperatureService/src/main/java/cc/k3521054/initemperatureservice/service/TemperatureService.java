package cc.k3521054.initemperatureservice.service;

import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class TemperatureService {

    private static final List<String> VALID_UNITS = Arrays.asList("Celsius", "Fahrenheit", "Kelvin");

    public double convert(double value, String fromUnit, String toUnit) {
        if (!isValidUnit(fromUnit) || !isValidUnit(toUnit)) {
            throw new IllegalArgumentException("Invalid unit: " + fromUnit + " or " + toUnit);
        }

        if (fromUnit.equalsIgnoreCase("Celsius") && toUnit.equalsIgnoreCase("Fahrenheit")) {
            return (value * 9 / 5) + 32;
        } else if (fromUnit.equalsIgnoreCase("Celsius") && toUnit.equalsIgnoreCase("Kelvin")) {
            return value + 273.15;
        } else if (fromUnit.equalsIgnoreCase("Fahrenheit") && toUnit.equalsIgnoreCase("Celsius")) {
            return (value - 32) * 5 / 9;
        } else if (fromUnit.equalsIgnoreCase("Fahrenheit") && toUnit.equalsIgnoreCase("Kelvin")) {
            return (value - 32) * 5 / 9 + 273.15;
        } else if (fromUnit.equalsIgnoreCase("Kelvin") && toUnit.equalsIgnoreCase("Celsius")) {
            return value - 273.15;
        } else if (fromUnit.equalsIgnoreCase("Kelvin") && toUnit.equalsIgnoreCase("Fahrenheit")) {
            return (value - 273.15) * 9 / 5 + 32;
        } else {
            throw new IllegalArgumentException("Invalid unit conversion");
        }
    }

    private boolean isValidUnit(String unit) {
        return VALID_UNITS.contains(unit);
    }
}
