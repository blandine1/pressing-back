package com.pressing.pressing.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
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

    private boolean status;

    //@CreationTimestamp
    //@Column(name = "creationDate", nullable = false, updatable = false)
    //@Temporal(TemporalType.TIMESTAMP)
    //private Timestamp creationDate;
    private Date creationDate;

    //@UpdateTimestamp
    //private Timestamp lastUpdatedDate;
    private Date lastUpdatedDate;

    private String description;
}
