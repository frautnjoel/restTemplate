package com.utn.demo.component;

import com.utn.demo.dto.PrinterDto;
import com.utn.demo.service.Integration.IntegrationComponent;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class IntegrationComponentTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private IntegrationComponent empService = new IntegrationComponent();

    @Test
    public void givenMockingIsDoneByMockito_whenGetIsCalled_shouldReturnMockedObject() {
        List<PrinterDto> emp=new ArrayList<>();
        PrinterDto newPrinter=createPrinter();
        emp.add(newPrinter);
        Mockito.when(restTemplate.exchange(
                "http://localhost:8082/printer/", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<PrinterDto>>(){})).thenReturn(new ResponseEntity(emp, HttpStatus.OK));

        ResponseEntity<List<PrinterDto>> employee = empService.getPetsFromApi();
        Assert.assertEquals(ResponseEntity.ok(emp), employee);
    }

    private PrinterDto createPrinter() {
        return PrinterDto.builder().printer("a").items(new ArrayList<>()).build();
    }
}
