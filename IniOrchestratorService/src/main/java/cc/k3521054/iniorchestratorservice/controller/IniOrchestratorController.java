package cc.k3521054.iniorchestratorservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import cc.k3521054.iniorchestratorservice.dto.ConversionRequestDto;
import cc.k3521054.iniorchestratorservice.dto.ConversionResponseDto;

@RestController
@RequestMapping("/converter")

public class IniOrchestratorController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @PostMapping("/convert")
    public ResponseEntity<ConversionResponseDto> convert(@RequestBody ConversionRequestDto request) {
        ServiceInstance serviceInstance;
        String endpoint;

        if ("Celsius".equalsIgnoreCase(request.getFromUnit()) ||
                "Fahrenheit".equalsIgnoreCase(request.getFromUnit()) ||
                "Kelvin".equalsIgnoreCase(request.getFromUnit())) {
            serviceInstance = loadBalancerClient.choose("temperature-service");
            endpoint = "/converter/convert-temperature";
        } else {
            serviceInstance = loadBalancerClient.choose("ini-length-service");
            endpoint = "/converter/convert-length";
        }

        if (serviceInstance == null) {
            return ResponseEntity.status(503).body(new ConversionResponseDto(
                    request.getValue(),
                    request.getFromUnit(),
                    0.0,
                    "Service Unavailable"
            ));
        }

        String selectedServiceInstanceUri = serviceInstance.getUri().toString();
        String url = selectedServiceInstanceUri + endpoint;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ConversionResponseDto> response = restTemplate.postForEntity(url, request, ConversionResponseDto.class);

        return ResponseEntity.ok(response.getBody());
    }
}

