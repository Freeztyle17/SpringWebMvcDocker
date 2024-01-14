package ru.fedotov.SpringWebMVC.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "Rejected_invoice_products")
public class RejectedInvoiceProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int invoice_number;

    private String nomenclature;

    private int price_purch;

    private int mark_up_percent;

    private int series;

    private int count_by_doc;
}
