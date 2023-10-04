package com.simplon.dvdstore.repositories;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="vente")
public class VenteRepository {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @CreationTimestamp
    @Column(name = "date")
    private LocalDate date;

    @Column(name = "montant")
    private Float montant ;

    @Column(name = "quantite_vendue")
    private int quantiteVendue;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_client")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ClientRepository clientRepository;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dvd")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private DvdRepositoryModel dvdRepositoryModel;

    public VenteRepository(LocalDate date, Float montant, int quantiteVendue, ClientRepository clientRepository, DvdRepositoryModel dvdRepositoryModel) {
        this.date = date;
        this.montant = montant;
        this.quantiteVendue = quantiteVendue;
        this.clientRepository = clientRepository;
        this.dvdRepositoryModel = dvdRepositoryModel;
    }



}
