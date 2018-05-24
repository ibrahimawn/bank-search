package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Controller for providing REST endpoints
 *
 * @author Mohamed Ibrahim
 */
@RestController
@RequestMapping("/")
public class BankController {

    private static final Map<String, String> status;

    static {
        status = new HashMap<>();
        status.put("status", "OK");
    }

    @RequestMapping(method = RequestMethod.GET)
    public Map<String, String> healthCheck() {
        return status;
    }
}
