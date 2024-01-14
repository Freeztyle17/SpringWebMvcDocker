package ru.fedotov.SpringWebMVC.repository;

import org.springframework.data.repository.CrudRepository;
import ru.fedotov.SpringWebMVC.model.RejectedInvoiceProducts;

import java.util.List;

public interface RejectedInvoiceProductsRepository extends CrudRepository<RejectedInvoiceProducts, Long > {

    List<RejectedInvoiceProducts> findAll();

}
