package com.pressing.pressing.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categorie")
public class Categorie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, name = "utilisateur_id")
    private Integer utilisateurid;

    @CreationTimestamp
    @Column(name = "creationDate", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp creationDate;

    @UpdateTimestamp
    private Timestamp lastUpdatedDate;

    private String description;
}
