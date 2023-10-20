package com.simplon.dvdstore.repositories;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.w3c.dom.Text;

/**
 * The type Dvd repository model.
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
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
    @Column(name = "quantity")
    private Long quantity;
    /**
     * The Prix.
     */
    @Column(name = "prix")
    public Float prix;
    /**
     * The Photo.
     */
    @Column(name = "photo")
    public String photo;
    /**
     * The Description.
     */
    @Column(name = "description", columnDefinition = "TEXT")
    public String description;


    /**
     * Instantiates a new Dvd repository model.
     *
     * @param name     the name
     * @param genre    the genre
     * @param quantity the quantity
     * @param prix     the prix
     */
    public DvdRepositoryModel(String name, String genre, Long quantity, Float prix) {
        this.name = name;
        this.genre = genre;
        this.quantity = quantity;
        this.prix = prix;

    }

    /**
     * Instantiates a new Dvd repository model.
     *
     * @param name     the name
     * @param genre    the genre
     * @param quantity the quantity
     * @param prix     the prix
     * @param photo    the photo
     */
    public DvdRepositoryModel(String name, String genre, Long quantity, Float prix, String photo) {
        this.name = name;
        this.genre = genre;
        this.quantity = quantity;
        this.prix = prix;
        this.photo = photo;
    }

    /**
     * Instantiates a new Dvd repository model.
     *
     * @param name        the name
     * @param genre       the genre
     * @param quantity    the quantity
     * @param prix        the prix
     * @param photo       the photo
     * @param description the description
     */
    public DvdRepositoryModel(String name, String genre, Long quantity, Float prix, String photo,String description) {
        this.name = name;
        this.genre = genre;
        this.quantity = quantity;
        this.prix = prix;
        this.photo = photo;
        this.description = description;
    }
}
