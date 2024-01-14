package ru.fedotov.SpringWebMVC.service;

import ru.fedotov.SpringWebMVC.model.Invoice;
import ru.fedotov.SpringWebMVC.model.RejectedInvoice;
import ru.fedotov.SpringWebMVC.model.RejectedInvoiceProducts;

import java.util.List;

public interface InvoiceService {

    List<Invoice> getAllInvoices();

    public List<RejectedInvoice> returnList();

    public RejectedInvoice findByInvoice_number(int invoice_number);

    Invoice save(Invoice invoice);

    void deleteInvoiceByInvoice_number(int invoice_number);
}
