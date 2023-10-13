package com.pressing.pressing.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.CloseableThreadContext;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "produit")
public class Produit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //parvde defaut il doit etre a false
    private boolean status;

    @Column(name = "utilisateur_id", nullable = false)
    private Integer utilisateurid;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    private Double prixTotal;

    private String description;

    private Date  creationDate;

    @JsonIgnore
    @OneToMany(mappedBy = "produit")
    private List<Ligneproduit> ligneproduits;

    //private Integer idLigneProduit;
}
