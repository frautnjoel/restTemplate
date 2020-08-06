package com.utn.demo.service.Integration;

import com.utn.demo.dto.PrinterDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@Component
public class IntegrationComponent {

    private RestTemplate rest;
    private static String url = "http://localhost:8082/printer/";

    @PostConstruct
    private void init() {
        rest = new RestTemplateBuilder()
                .build();
    }

    public ResponseEntity<List<PrinterDto>> getPetsFromApi() {
        ResponseEntity<List<PrinterDto>> response = rest.exchange(
                url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<PrinterDto>>(){});

        return response;
    }
}
