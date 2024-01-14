package ru.fedotov.SpringWebMVC.model;

import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "Receipt_story")
public class ReceiptStory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Receipt_id")
    private long receipt_id;

    @ManyToOne()
    @JoinColumn(name = "Nomenclature_id")
    private Product product;

    @Column(name = "Count")
    private int count;

    @Column(name = "price_retail")
    private int priceRetail;


}
