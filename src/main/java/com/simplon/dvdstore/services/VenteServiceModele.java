package com.simplon.dvdstore.services;
import lombok.*;

import java.time.LocalDate;
import java.util.Optional;

/**
 * The type Vente service modele.
 */
@Data
@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
public class VenteServiceModele {

    private LocalDate date ;
    private Float montant;
    private int quantiteVendue;
    private Optional <Long> id;
    private Optional<ClientServiceModele> client;
    private Optional<DvdServiceModel> dvd;
    private Optional<Long> id_client;
    private Optional<Long> id_dvd;


    /**
     * Instantiates a new Vente service modele.
     *
     * @param date           the date
     * @param montant        the montant
     * @param quantiteVendue the quantite vendue
     * @param id             the id
     */
    public VenteServiceModele(LocalDate date, Float montant, int quantiteVendue, Optional<Long> id) {
        this.date = date;
        this.montant = montant;
        this.quantiteVendue = quantiteVendue;
        this.id = id;

    }

    /**
     * Instantiates a new Vente service modele.
     *
     * @param date           the date
     * @param montant        the montant
     * @param quantiteVendue the quantite vendue
     * @param id             the id
     * @param client         the client
     * @param dvd            the dvd
     * @param withObjects    the with objects
     */
    public VenteServiceModele(LocalDate date, Float montant, int quantiteVendue, Optional<Long> id, Optional<ClientServiceModele> client, Optional<DvdServiceModel> dvd, boolean withObjects) {
        this.date = date;
        this.montant = montant;
        this.quantiteVendue = quantiteVendue;
        this.id = id;
        this.client = client;
        this.dvd = dvd;
    }

    /**
     * Instantiates a new Vente service modele.
     *
     * @param date           the date
     * @param montant        the montant
     * @param quantiteVendue the quantite vendue
     * @param id             the id
     * @param id_client      the id client
     * @param id_dvd         the id dvd
     */
    public VenteServiceModele(LocalDate date, Float montant, int quantiteVendue, Optional<Long> id, Optional<Long> id_client, Optional<Long> id_dvd) {
        this.date = date;
        this.montant = montant;
        this.quantiteVendue = quantiteVendue;
        this.id = id;
        this.id_client = id_client;
        this.id_dvd = id_dvd;
    }
}
