package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/login")
    public String loginPage() {
        return "<h2>Login Page</h2>"
             + "<form action='/check'>"
             + "User: <input name='u'><br><br>"
             + "Pass: <input name='p' type='password'><br><br>"
             + "<button type='submit'>Login</button>"
             + "</form>";
    }

    @GetMapping("/check")
    public String check(@RequestParam String u, @RequestParam String p) {
        if (u.equals("admin") && p.equals("1234"))
            return "<h1>LOGIN SUCCESS ✔</h1><a href='/login'>Back</a>";
        else
            return "<h1>LOGIN FAILED</h1><a href='/login'>Back</a>";
    }
}
