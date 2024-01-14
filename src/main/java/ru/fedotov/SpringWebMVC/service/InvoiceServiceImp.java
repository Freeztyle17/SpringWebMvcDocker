package ru.fedotov.SpringWebMVC.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.fedotov.SpringWebMVC.model.Invoice;
import ru.fedotov.SpringWebMVC.model.RejectedInvoice;
import ru.fedotov.SpringWebMVC.model.RejectedInvoiceProducts;
import ru.fedotov.SpringWebMVC.repository.InvoiceRepository;
import ru.fedotov.SpringWebMVC.repository.RejectedInvoiceRepository;

import java.util.List;

@Service
public class InvoiceServiceImp implements InvoiceService{

    @Autowired
    InvoiceRepository ir;

    @Autowired
    RejectedInvoiceRepository rejectedInvoiceRepository;


    @Override
    public List<Invoice> getAllInvoices() {
        return ir.findAll();
    }


    @SneakyThrows
    public List<RejectedInvoice> returnList(){

        return rejectedInvoiceRepository.findAll();
    }

    @Override
    public RejectedInvoice findByInvoice_number(int invoice_number) {
        return rejectedInvoiceRepository.findAll().stream().filter(rejectedInvoice -> rejectedInvoice.getInvoice_number() == invoice_number).toList().get(0);
    }

    @Override
    public Invoice save(Invoice invoice){
       return ir.save(invoice);
    }

    @Override
    public void deleteInvoiceByInvoice_number(int invoice_number) {
        RejectedInvoice rejectedInvoiceForDelete = findByInvoice_number(invoice_number);
         rejectedInvoiceRepository.delete(rejectedInvoiceForDelete);
    }

}
