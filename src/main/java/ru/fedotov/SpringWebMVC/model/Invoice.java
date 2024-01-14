package ru.fedotov.SpringWebMVC.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "Invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne()
    @JoinColumn(name = "provider_id")
    private Provider provider;

    private Date date_of_supply;

    private int invoice_number;

    private int invoice_summ;

    private int nomenclature_count;


}
