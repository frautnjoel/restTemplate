package com.utn.demo.controller;

import com.utn.demo.dto.PrinterDto;
import com.utn.demo.service.IntegrationService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ApiControllerTest {

    ApiController apiController;
    IntegrationService service;


    @Before
    public void setUp() {
        service = mock(IntegrationService.class);
        apiController = new ApiController(service);
    }

    @Test
    public void readTest(){
        List<PrinterDto> list=new ArrayList<>();
        PrinterDto newPrinter=createPrinter();
        list.add(newPrinter);
        when(service.read()).thenReturn(ResponseEntity.ok(list));
        ResponseEntity<List<PrinterDto>> expected=service.read();
        ResponseEntity<List<PrinterDto>> retorned=apiController.read();
        Assert.assertEquals(expected,retorned);
    }

    private PrinterDto createPrinter() {
        return PrinterDto.builder().printer("a").items(new ArrayList<>()).build();
    }
}
