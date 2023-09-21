package com.simplon.dvdstore.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

@Data
@Value
@AllArgsConstructor
public class DvdStoreDTO {
    private String name;
    private String genre;
    private Long quantity;
    public Float prix;
}

