package com.simplon.dvdstore.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

@Data
@AllArgsConstructor
public class ClientGetDTO {
    public String nom;
    public String prenom;
    public String telephone;
    public Long id;

    public ClientGetDTO() {

    }

    public ClientGetDTO(String nom, String prenom, String telephone, Optional<Long> id) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.id = id.orElse(null);
    }
}
