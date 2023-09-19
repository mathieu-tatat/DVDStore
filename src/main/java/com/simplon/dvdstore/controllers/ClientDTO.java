package com.simplon.dvdstore.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

@Data
@Value
@AllArgsConstructor
public class ClientDTO {
    public String nom;
    public String prenom;
    public String telephone;
}
