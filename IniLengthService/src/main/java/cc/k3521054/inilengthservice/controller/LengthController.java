package cc.k3521054.inilengthservice.controller;

import cc.k3521054.inilengthservice.dto.ConversionRequestDto;
import cc.k3521054.inilengthservice.dto.ConversionResponseDto;
import cc.k3521054.inilengthservice.service.LengthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class LengthController {

    @Autowired
    private LengthService lengthService;

    @PostMapping("/converter/convert-length")
    public ResponseEntity<?> convertLength(@RequestBody ConversionRequestDto request) {
        try {
            double convertedValue = lengthService.convert(request.getValue(), request.getFromUnit(), request.getToUnit());
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

