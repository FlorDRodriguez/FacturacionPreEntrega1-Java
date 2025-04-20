package edu.coderhouse.system_facturation.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "INVOICE_DETAILS")
public class InvoiceDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INVOICE_DETAILS_ID", nullable = false)
    private int invoice_details_id;

    @Column(name = "AMOUNT", nullable = false)
    private int amount;

    @Column(name = "PRICE", nullable = false)
    private double price;

    //Relación con factura (1 factura puede tener muchos detalles)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INVOICE_ID", nullable = false)
    private Invoice invoice;

    //Relación con producto (1 producto puede aparecer en muchos detalles)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    private Products products;


}
