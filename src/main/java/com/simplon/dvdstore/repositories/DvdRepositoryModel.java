package com.simplon.dvdstore.repositories;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;


@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="dvdstore")
public class DvdRepositoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "genre")
    private String genre;

    public DvdRepositoryModel(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }

}
