package com.simplon.dvdstore.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


/**
 * The type Vente get all dto.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VenteGetAllDTO {
    /**
     * The Date.
     */
    public LocalDate date ;
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
     * The Name.
     */
    public String name;
    /**
     * The Nom.
     */
    public String nom;


    /**
     * Instantiates a new Vente get all dto.
     *
     * @param date           the date
     * @param montant        the montant
     * @param quantiteVendue the quantite vendue
     * @param id             the id
     * @param clientGetDTO   the client get dto
     * @param dvdStoreGetDTO the dvd store get dto
     */
    public VenteGetAllDTO(LocalDate date, Float montant, int quantiteVendue, Long id, ClientGetDTO clientGetDTO, AuthRequestDto.DvdStoreGetDTO dvdStoreGetDTO) {

        this.date = date;
        this.montant = montant;
        this.quantiteVendue = quantiteVendue;
        this.id = id;
        this.id_client = clientGetDTO.getId();
        this.id_dvd = dvdStoreGetDTO.getId();
        this.name = dvdStoreGetDTO.getName();
        this.nom = clientGetDTO.getNom();

    }
}
