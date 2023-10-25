package com.pressing.pressing.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "service")
public class Services implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @CreationTimestamp
    @Column(name = "creationDate", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp creationDate;

    @UpdateTimestamp
    private Timestamp lastUpdatedDate;

    @Column(name = "utilisateur_id", nullable = false)
    private Integer utilisateurid;

    private String description;
}
