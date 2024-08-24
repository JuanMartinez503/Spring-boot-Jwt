package io.juanmartinez.Jwt;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    //this is how to access the session id
    public String greet(HttpServletRequest request){
        return "Hello Juan, your session id is " + request.getSession().getId();
    }
}
