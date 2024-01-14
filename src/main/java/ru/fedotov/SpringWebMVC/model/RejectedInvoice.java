package ru.fedotov.SpringWebMVC.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "Rejected_invoice")
public class RejectedInvoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String provider;

    private Date date_of_supply;

    private int invoice_number;

   // private BigDecimal invoice_summ;

    @OneToMany
    @JoinColumn(name = "invoice_number")
    private List<RejectedInvoiceProducts> rejectedInvoiceProducts;

    private int nomenclature_count;


}
