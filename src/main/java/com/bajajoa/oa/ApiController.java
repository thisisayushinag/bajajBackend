package com.bajajoa.oa;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bfhl")

public class ApiController {
    @PostMapping
    public ResponseEntity<ApiResponse> handlePostRequest(@RequestBody ApiResponse request) {
        List<String> numbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        String highestLowercase = "";

        for (String item : request.getData()) {
            if (item.matches("\\d+")) {
                numbers.add(item);
            } else if (item.matches("[a-zA-Z]")) {
                alphabets.add(item);
                if (item.matches("[a-z]") && item.compareTo(highestLowercase) > 0) {
                    highestLowercase = item;
                }
            }
        }

        ApiResponse response = new ApiResponse();
        response.setIsSuccess(true);
        response.setUserId("john_doe_17091999");
        response.setEmail("john@xyz.com");
        response.setRollNumber("ABCD123");
        response.setNumbers(numbers);
        response.setAlphabets(alphabets);
        response.setHighestLowercaseAlphabet(highestLowercase.isEmpty() ? new ArrayList<>() : List.of(highestLowercase));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<String> handleGetRequest() {
        return ResponseEntity.ok("{ \"operation_code\": 1 }");
    }
}

