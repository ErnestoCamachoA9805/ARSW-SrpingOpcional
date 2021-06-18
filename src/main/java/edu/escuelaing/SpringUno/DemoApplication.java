package edu.escuelaing.SpringUno;

import java.util.Collections;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        //SpringApplication.run(DemoApplication.class, args);
        int port = getPort();
        SpringApplication app = new SpringApplication(DemoApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", port));
        app.run(args);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "Beautifull") String name,
            @RequestParam(value = "apellido", defaultValue = "World") String lastname) {
        return String.format("Hello %s %s!", name, lastname);
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
        return Integer.parseInt(System.getenv("PORT"));
        }
        return 8080; //returns default port if heroku-port isn't set (i.e. on localhost)
        }
}
