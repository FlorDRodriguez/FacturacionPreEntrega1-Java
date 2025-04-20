package edu.coderhouse.system_facturation.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "PRODUCTS")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private int id;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "CODE", nullable = false, unique = true)
    private String code;

    @Column(name = "STOCK", nullable = false)
    private int stock;

    @Column(name = "PRICE", nullable = false)
    private double price;

    //Relación con detalle_factura (1 producto puede aparecer en muchos detalles)
    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<InvoiceDetails> invoice_details;
}
