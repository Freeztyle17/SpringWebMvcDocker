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
@Builder
@Table(name = "Claim")
public class ClaimInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long provider_id;

    private Date date_of_claim;

    private String delivery_or_refund;

    private String comment;

    private String status;

}
