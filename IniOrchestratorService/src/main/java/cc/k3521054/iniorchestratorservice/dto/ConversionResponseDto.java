package cc.k3521054.iniorchestratorservice.dto;

public class ConversionResponseDto {

    private Double originalValue;
    private String originalUnit;
    private Double convertedValue;
    private String convertedUnit;

    public ConversionResponseDto(Double originalValue, String originalUnit, Double convertedValue, String convertedUnit) {
        this.originalValue = originalValue;
        this.originalUnit = originalUnit;
        this.convertedValue = convertedValue;
        this.convertedUnit = convertedUnit;
    }

    public Double getOriginalValue() {
        return originalValue;
    }

    public void setOriginalValue(Double originalValue) {
        this.originalValue = originalValue;
    }

    public String getOriginalUnit() {
        return originalUnit;
    }

    public void setOriginalUnit(String originalUnit) {
        this.originalUnit = originalUnit;
    }

    public Double getConvertedValue() {
        return convertedValue;
    }

    public void setConvertedValue(Double convertedValue) {
        this.convertedValue = convertedValue;
    }

    public String getConvertedUnit() {
        return convertedUnit;
    }

    public void setConvertedUnit(String convertedUnit) {
        this.convertedUnit = convertedUnit;
    }
}
