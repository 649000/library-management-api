package com.library.controller;

import com.library.model.Lend;
import com.library.service.LendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/lend")
@Slf4j
public class LendController {

    private final LendService lendService;

    @Autowired
    public LendController(LendService lendService) {
        this.lendService = lendService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Lend> lendABook(@RequestBody Lend lend) {
        log.debug("Lend Object: {}", lend.toString());
        return ResponseEntity.ok(lendService.createLend(lend));
    }
    @GetMapping
    public Iterable<Lend> getAllLends(){
        return lendService.getLends();
    }
    @DeleteMapping("/{lendId}")
    public ResponseEntity<Void> deleteLend (@PathVariable String lendId) {
        log.debug("Lend ID: {}", lendId);
        lendService.deleteLend(lendId);
        return ResponseEntity.ok().build();
    }
}
