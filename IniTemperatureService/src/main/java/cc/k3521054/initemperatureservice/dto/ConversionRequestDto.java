package cc.k3521054.initemperatureservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ConversionRequestDto {
    @NotNull(message = "Value cannot be null")
    private Double value;

    @NotBlank(message = "From unit cannot be blank")
    private String fromUnit;

    @NotBlank(message = "To unit cannot be blank")
    private String toUnit;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getFromUnit() {
        return fromUnit;
    }

    public void setFromUnit(String fromUnit) {
        this.fromUnit = fromUnit;
    }

    public String getToUnit() {
        return toUnit;
    }

    public void setToUnit(String toUnit) {
        this.toUnit = toUnit;
    }
}

