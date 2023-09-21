package com.simplon.dvdstore.services;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientServiceModele {
    private String nom;
    private String prenom;
    private String telephone;
    private Optional <Long> id;



}
