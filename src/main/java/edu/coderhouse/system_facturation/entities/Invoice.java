package edu.coderhouse.system_facturation.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "INVOICE")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private int id;

    @Column(name = "CREATED_AT", nullable = false)
    private String created_at;

    @Column(name = "TOTAL", nullable = false)
    private double total;

    //Relación con cliente (1 cliente puede tener muchas facturas)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLIENT_ID", nullable = false)
    private Clients client;

    //Relación con detalle_factura (1 factura puede tener muchos detalles)
    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<InvoiceDetails> invoice_details;
}
