package ru.fedotov.SpringWebMVC.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "Receipt")
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date date_of_operation;

    @Column(name = "Nomenclature_count")
    private long nomenclature_count;
    @Column(name = "Price_result")
    private int Price_result;
}
