package cc.k3521054.initemperatureservice.controller;


import cc.k3521054.initemperatureservice.dto.ConversionRequestDto;
import cc.k3521054.initemperatureservice.dto.ConversionResponseDto;
import cc.k3521054.initemperatureservice.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@RestController
//@RequestMapping("/converter")
public class TemperatureController {

    @Autowired
    private TemperatureService temperatureService;

    @PostMapping("/converter/convert-temperature")
    public ResponseEntity<?> convertTemperature(@RequestBody ConversionRequestDto request) {
        try {
            double convertedValue = temperatureService.convert(request.getValue(), request.getFromUnit(), request.getToUnit());
            ConversionResponseDto response = new ConversionResponseDto(
                    request.getValue(),
                    request.getFromUnit(),
                    convertedValue,
                    request.getToUnit()
            );
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}

