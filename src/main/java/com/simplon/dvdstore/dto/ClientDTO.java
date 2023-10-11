package com.simplon.dvdstore.dto;

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
