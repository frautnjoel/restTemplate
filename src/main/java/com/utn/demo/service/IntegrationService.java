package com.utn.demo.service;

import com.utn.demo.dto.PrinterDto;
import com.utn.demo.service.Integration.IntegrationComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IntegrationService {


    IntegrationComponent integrationComponent;
@Autowired
    public IntegrationService(IntegrationComponent integrationComponent) {
        this.integrationComponent = integrationComponent;
    }

    public ResponseEntity<List<PrinterDto>> read() {
return  integrationComponent.getPetsFromApi();
    }
}
