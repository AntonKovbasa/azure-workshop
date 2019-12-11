package com.example.azure.workshopapp.controller;

import com.example.azure.workshopapp.service.ОтмазкиService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class Controller {

    private final ОтмазкиService отмазкиService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String getОтмазка() {
        return отмазкиService.getОтмазка();
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addОтмазка(@Valid @RequestBody String отмазка) {
        отмазкиService.setОтмазки(отмазка);
        return отмазка;
    }

}
