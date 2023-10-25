package com.pressing.pressing.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.logging.log4j.CloseableThreadContext;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
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

    @CreationTimestamp
    @Column(name = "creationDate", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp creationDate;

    @UpdateTimestamp
    private Timestamp lastUpdatedDate;

    @JsonIgnore
    @OneToMany(mappedBy = "produit")
    private List<Ligneproduit> ligneproduits;

    //private Integer idLigneProduit;
}
