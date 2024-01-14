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
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nomenclature;

    @Column(name = "price_purch")
    private int pricePurch;

    @Column(name = "mark_up_percent")
    private int markUpPercent;

    @Column(name = "price_retail")
    private int priceRetail;
    private int count;
    @ManyToOne()
    @JoinColumn(name = "provider_id")
    private Provider provider;
}
