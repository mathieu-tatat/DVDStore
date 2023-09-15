package com.simplon.dvdstore.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.Optional;

@Data
@Value
@AllArgsConstructor
public class DvdStoreDTO {
    private String name;
    private String genre;

}

