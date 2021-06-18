package edu.escuelaing.SpringUno;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DateController {

    @GetMapping("/Date")
    public String date(@RequestParam(value = "name",defaultValue =  " world") String name){
        String response= "Local Date: " + LocalDateTime.now() + ". Hello " + name;
        return response;
    } 
}
