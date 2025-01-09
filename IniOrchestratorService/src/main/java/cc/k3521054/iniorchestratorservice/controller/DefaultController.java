package cc.k3521054.iniorchestratorservice.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

    @GetMapping("/")
    public String home() {
        return "Welcome to OrchestratorService!";
    }
}

