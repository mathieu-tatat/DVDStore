package com.simplon.dvdstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

import java.sql.Date;
import java.time.LocalDate;


/**
 * The type Vente dto.
 */
@Data
@Value
@AllArgsConstructor

public class VenteDTO {
    /**
     * The Date.
     */
    public LocalDate date;
    /**
     * The Montant.
     */
    public Float montant;
    /**
     * The Quantite vendue.
     */
    public int quantiteVendue;
}
