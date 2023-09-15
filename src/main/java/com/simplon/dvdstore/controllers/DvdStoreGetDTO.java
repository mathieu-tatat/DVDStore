package com.simplon.dvdstore.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class DvdStoreGetDTO {
    public String name;
    public String genre;
    public Long id;

}
