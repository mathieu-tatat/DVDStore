package com.simplon.dvdstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

/**
 * The type Client get dto.
 */
@Data
@AllArgsConstructor
public class ClientGetDTO {
    /**
     * The Nom.
     */
    public String nom;
    /**
     * The Prenom.
     */
    public String prenom;
    /**
     * The Telephone.
     */
    public String telephone;
    /**
     * The Id.
     */
    public Long id;

    /**
     * Instantiates a new Client get dto.
     */
    public ClientGetDTO() {

    }

    /**
     * Instantiates a new Client get dto.
     *
     * @param nom       the nom
     * @param prenom    the prenom
     * @param telephone the telephone
     * @param id        the id
     */
    public ClientGetDTO(String nom, String prenom, String telephone, Optional<Long> id) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.id = id.orElse(null);
    }
}
