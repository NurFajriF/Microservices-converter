package cc.k3521054.inilengthservice.service;

import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class LengthService {

    private static final List<String> VALID_UNITS = Arrays.asList("Meter", "Kilometer", "Centimeter");

    public double convert(double value, String fromUnit, String toUnit) {
        if (!isValidUnit(fromUnit) || !isValidUnit(toUnit)) {
            throw new IllegalArgumentException("Invalid unit: " + fromUnit + " or " + toUnit);
        }

        if (fromUnit.equalsIgnoreCase("Meter") && toUnit.equalsIgnoreCase("Kilometer")) {
            return value / 1000;
        } else if (fromUnit.equalsIgnoreCase("Kilometer") && toUnit.equalsIgnoreCase("Meter")) {
            return value * 1000;
        } else if (fromUnit.equalsIgnoreCase("Centimeter") && toUnit.equalsIgnoreCase("Meter")) {
            return value / 100;
        } else if (fromUnit.equalsIgnoreCase("Meter") && toUnit.equalsIgnoreCase("Centimeter")) {
            return value * 100;
        } else {
            throw new IllegalArgumentException("Invalid unit conversion");
        }
    }

    private boolean isValidUnit(String unit) {
        return VALID_UNITS.contains(unit);
    }
}
