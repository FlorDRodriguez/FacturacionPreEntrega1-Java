package edu.coderhouse.system_facturation.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "CLIENTS")
public class Clients {
    @Id
    //Le indico que el id es auto incremental
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private int id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "LASTNAME", nullable = false)
    private String lastname;

    @Column(name = "DOCNUMBER", nullable = false, unique = true)
    private String docnumber;

    //Relación con factura (1 cliente puede tener muchas facturas)
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Invoice> invoices;
}
