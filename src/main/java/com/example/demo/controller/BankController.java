package com.example.demo.controller;

import com.example.demo.domain.BankDetails;
import com.example.demo.service.BankService;
import com.example.demo.util.ApiError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Controller for providing REST endpoints
 *
 * @author Mohamed Ibrahim
 */
@RestController
@RequestMapping("/")
public class BankController {

    private static final Logger LOG = LoggerFactory.getLogger(BankController.class);

    private static final Map<String, String> status;

    static {
        status = new HashMap<>();
        status.put("status", "OK");
    }

    private final BankService bankService;

    BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Map<String, String> healthCheck() {
        return status;
    }

    @RequestMapping(value = "/banks/{ifsc}", method = RequestMethod.GET)
    public ResponseEntity findByIfsc(@PathVariable("ifsc") final String ifsc) {
        Optional<BankDetails> bankDetails = bankService.findByIfsc(ifsc);
        if (!bankDetails.isPresent()) {
            return new ResponseEntity<>(new ApiError(HttpStatus.NOT_FOUND, "Bank details not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bankDetails.get(), HttpStatus.OK);
    }
}
