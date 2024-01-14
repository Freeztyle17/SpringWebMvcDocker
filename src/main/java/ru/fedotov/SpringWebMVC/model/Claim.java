package ru.fedotov.SpringWebMVC.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "Claim")
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne()
    @JoinColumn(name = "provider_id")
    private Provider provider;

    private Date date_of_claim;

    private String delivery_or_refund;

    private String comment;

    private String status;
}
