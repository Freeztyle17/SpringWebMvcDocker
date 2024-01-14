package ru.fedotov.SpringWebMVC.repository;

import org.springframework.data.repository.CrudRepository;
import ru.fedotov.SpringWebMVC.model.Receipt;

import java.util.List;

public interface ReceiptRepository extends CrudRepository<Receipt, Long> {

    public List<Receipt> findAll();
}
