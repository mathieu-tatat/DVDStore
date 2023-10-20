package com.simplon.dvdstore.repositories;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

/**
 * The type Client repository.
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="client")
public class ClientRepository {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name="telephone")
    private String telephone;

    /**
     * Instantiates a new Client repository.
     *
     * @param nom       the nom
     * @param prenom    the prenom
     * @param telephone the telephone
     */
    public ClientRepository(String nom, String prenom, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
    }


}
