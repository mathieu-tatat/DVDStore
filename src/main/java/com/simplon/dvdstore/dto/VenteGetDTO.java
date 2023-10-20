package com.simplon.dvdstore.dto;

import com.simplon.dvdstore.services.ClientServiceModele;
import com.simplon.dvdstore.services.DvdServiceModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



import java.time.LocalDate;


/**
 * The type Vente get dto.
 */
@Data
@NoArgsConstructor

public class VenteGetDTO {

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
    /**
     * The Id.
     */
    public Long id;
    /**
     * The Id client.
     */
    public Long id_client;
    /**
     * The Id dvd.
     */
    public Long id_dvd;

    /**
     * Instantiates a new Vente get dto.
     *
     * @param date                the date
     * @param montant             the montant
     * @param quantiteVendue      the quantite vendue
     * @param aLong               the a long
     * @param clientServiceModele the client service modele
     * @param dvdServiceModel     the dvd service model
     */
    public VenteGetDTO(LocalDate date, Float montant, int quantiteVendue, Long aLong, ClientServiceModele clientServiceModele, DvdServiceModel dvdServiceModel) {
        this.date = date;
        this.montant = montant;
        this.quantiteVendue = quantiteVendue;
        this.id = aLong;
        this.id_client = clientServiceModele.getId().get();
        this.id_dvd = dvdServiceModel.getId().get();
    }
}
