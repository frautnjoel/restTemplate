package com.utn.demo.dto;

import com.utn.demo.model.Impressions;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PrinterDto {
    private String printer;
    private List<Impressions> items;
}
