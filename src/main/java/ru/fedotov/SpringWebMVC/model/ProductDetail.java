package ru.fedotov.SpringWebMVC.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "Product_detail")


public class ProductDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne()
    @JoinColumn(name = "prod_id")
    private Product product;
    private int count;

    private int invoice_number;
    private int series;

    private Date date_of_delive;
}
