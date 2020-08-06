package com.utn.demo.controller;

import com.utn.demo.dto.PrinterDto;
import com.utn.demo.service.IntegrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    private IntegrationService service;
    @Autowired
    public ApiController(IntegrationService service) {
        this.service = service;
    }




    @GetMapping("/")
    public ResponseEntity<List<PrinterDto>> read() {
       return  service.read();

    }
}
