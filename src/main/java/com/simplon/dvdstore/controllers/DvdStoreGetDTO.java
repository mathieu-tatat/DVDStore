package com.simplon.dvdstore.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DvdStoreGetDTO {
    public String name;
    public String genre;
    public Long quantity;
    public Float prix;
    public Long id;


    public DvdStoreGetDTO(String jsonString) {
        // Implémentez la logique pour désérialiser la chaîne JSON ici


    }
}
