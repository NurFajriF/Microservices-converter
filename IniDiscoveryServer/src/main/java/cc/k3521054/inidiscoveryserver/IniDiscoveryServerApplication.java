package cc.k3521054.inidiscoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class IniDiscoveryServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(IniDiscoveryServerApplication.class, args);
    }

}
