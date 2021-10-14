package com.example.dynamodb.controller;

import com.example.dynamodb.model.Lend;
import com.example.dynamodb.service.LendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/lend")
public class LendController {

    private final LendService lendService;

    @Autowired
    public LendController(LendService lendService) {
        this.lendService = lendService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Lend> lendABook(@RequestBody Lend lend) {
        return ResponseEntity.ok(lendService.createLend(lend));
    }
}
