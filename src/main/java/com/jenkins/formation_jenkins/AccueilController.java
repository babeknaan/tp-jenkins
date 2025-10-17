package com.jenkins.formation_jenkins;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AccueilController {

    @GetMapping("message")
    public String message() {
        return "Hello formation jenkins";
    }
}
