package com.simplon.dvdstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

/**
 * The type Client dto.
 */
@Data
@Value
@AllArgsConstructor
public class ClientDTO {
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
}
