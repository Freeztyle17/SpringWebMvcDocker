package ru.fedotov.SpringWebMVC.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "Providers")
public class Provider {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Name")
    private String name;
    @Column(name = "invoices_count")
    private long invoicesCount;
    @Column(name = "comment")
    private String comment;
}
