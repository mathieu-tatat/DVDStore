package com.simplon.dvdstore.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientGetDTO {
    public String nom;
    public String prenom;
    public String telephone;
    public Long id;

    public ClientGetDTO() {

    }

        public ClientGetDTO(String jsonString) {
            // Implémentez la logique pour désérialiser la chaîne JSON ici
        }

}
