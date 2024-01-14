package ru.fedotov.SpringWebMVC.model;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CheckInfo {

    private List<Long> products_id;

    private List<Integer> products_count;
}
