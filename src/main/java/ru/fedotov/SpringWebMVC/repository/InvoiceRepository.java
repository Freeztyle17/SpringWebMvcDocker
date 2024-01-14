package ru.fedotov.SpringWebMVC.repository;

import org.springframework.data.repository.CrudRepository;
import ru.fedotov.SpringWebMVC.model.Invoice;

import java.util.List;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

    List<Invoice> findAll();

    Invoice save(Invoice invoice);
}
