package com.pressing.pressing.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ligneproduit")
public class Ligneproduit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer prix;

    @Column(name= "quantite")
    private BigDecimal quantite;

    private Integer id_produit;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "service_id")
    private Services services;

    @Column(name = "vetement")
    private String vetement;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    private Double prixTotalPartiel;

    private String description;
}
