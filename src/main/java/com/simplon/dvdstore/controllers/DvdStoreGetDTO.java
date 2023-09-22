package com.simplon.dvdstore.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

@Data
@AllArgsConstructor
public class DvdStoreGetDTO {
    public String name;
    public String genre;
    public Long quantity;
    public Float prix;
    public Long id;
}
