package ru.fedotov.SpringWebMVC.repository;

import org.springframework.data.repository.CrudRepository;
import ru.fedotov.SpringWebMVC.model.RejectedInvoice;

import java.util.List;

public interface RejectedInvoiceRepository extends CrudRepository<RejectedInvoice, Long> {

    List<RejectedInvoice> findAll();
}
