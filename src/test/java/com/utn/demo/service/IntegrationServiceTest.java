package com.utn.demo.service;

import com.utn.demo.dto.PrinterDto;
import com.utn.demo.service.Integration.IntegrationComponent;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class IntegrationServiceTest {

    IntegrationService service;

    @Mock
    IntegrationComponent integrationComponent;

    @Before
    public void setUp() {
        initMocks(this);
        service = new IntegrationService(integrationComponent);
    }

    @Test
    public void redTest(){
       when(integrationComponent.getPetsFromApi()).thenReturn(ResponseEntity.ok(new ArrayList<PrinterDto>()));
        Assert.assertEquals(ResponseEntity.ok(new ArrayList<PrinterDto>()),service.read());
    }


}
