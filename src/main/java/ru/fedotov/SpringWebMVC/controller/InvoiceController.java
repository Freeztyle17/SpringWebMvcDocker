package ru.fedotov.SpringWebMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.fedotov.SpringWebMVC.model.*;
import ru.fedotov.SpringWebMVC.service.InvoiceService;
import ru.fedotov.SpringWebMVC.service.ProductService;
import ru.fedotov.SpringWebMVC.service.ProviderService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/api/invoice")
public class InvoiceController {

    @Autowired
    InvoiceService is;
    @Autowired
    InvoiceService invoiceService;
    @Autowired
    ProductService productService;
    @Autowired
    ProviderService providerService;

    @GetMapping("/invoices")
    public String Invoice(Model model) {

        model.addAttribute("AcceptedInvoices", is.getAllInvoices());

        return "AcceptedInvoices";
    }


    @GetMapping("/newInvoices")
    public String NewInvoice(Model model){

        model.addAttribute("rejectedInvoicesProducts", productService.findAllRejectedInvoiceProducts());
        model.addAttribute("rejectedInvoices", is.returnList());


        return "NewInvoices";
    }

    @GetMapping("/newInvoice/{invoice_number}")
    public String newClaim(Model model, @PathVariable("invoice_number") int invoice_number) {

        model.addAttribute("NewInvoice", invoiceService.findByInvoice_number(invoice_number));

        return "AddNewInvoice";
    }

    @PostMapping("/createNewInvoice/{invoice_number}")
    public String createInvoice(@ModelAttribute("NewInvoice") RejectedInvoice newInvoice){

        Provider provider = providerService.getProviderByName(newInvoice.getProvider());

        if(provider == null){
                providerService.save(newInvoice.getProvider());
        }else{
               provider.setInvoicesCount(provider.getInvoicesCount()+1);
               providerService.save(provider);
        }

        List<RejectedInvoiceProducts> products = productService.findByInvoiceNumber(newInvoice.getInvoice_number());

        Date dateNow = new Date();
        int noms_count=0;
        int sum = 0;

        for (RejectedInvoiceProducts pr: products) {



            Product newProduct = productService.getProductByNomenclature(pr.getNomenclature());
            System.out.println(newProduct);



            if(newProduct == null){


                int priceRetail = pr.getPrice_purch();
                int percent = pr.getMark_up_percent();
                int divider = 100;

                priceRetail+=((pr.getPrice_purch()/divider)*percent);


                Product productForSet = new Product();
                productForSet.setId(productService.getAllProducts().size()+1);

                System.out.println("productNumber is "+productService.getAllProducts().size()+1);




                productForSet.setNomenclature(pr.getNomenclature());
                productForSet.setMarkUpPercent(pr.getMark_up_percent());
                productForSet.setPricePurch(pr.getPrice_purch());
                productForSet.setPriceRetail(priceRetail);
                productForSet.setProvider(providerService.getProviderByName(newInvoice.getProvider()));
                productForSet.setCount(pr.getCount_by_doc());

                productService.save(productForSet);

            }else{

                newProduct.setCount(newProduct.getCount()+pr.getCount_by_doc());
                productService.save(newProduct);

            }




            ProductDetail productDetail = new ProductDetail();

            productDetail.setId(productService.getAllDetails().size()+1);

            System.out.println("productDetail is "+productService.getAllDetails().size()+1);

            productDetail.setProduct(newProduct);
            productDetail.setInvoice_number(newInvoice.getInvoice_number());
            productDetail.setCount(pr.getCount_by_doc());
            productDetail.setDate_of_delive(dateNow);
            productDetail.setSeries(pr.getSeries());

            productService.save(productDetail);

            sum+=(pr.getPrice_purch()*pr.getCount_by_doc());
            noms_count+=1;
        }

        Invoice newInvoiceToAdd = new Invoice();

        newInvoiceToAdd.setId(is.getAllInvoices().size()+1);
        newInvoiceToAdd.setProvider(provider);
        newInvoiceToAdd.setDate_of_supply(dateNow);
        newInvoiceToAdd.setInvoice_number(newInvoice.getInvoice_number());
        newInvoiceToAdd.setInvoice_summ(sum);
        newInvoiceToAdd.setNomenclature_count(noms_count);


        is.save(newInvoiceToAdd);

        invoiceService.deleteInvoiceByInvoice_number(newInvoice.getInvoice_number());
        productService.deleteProductsByInvoiceNumber(newInvoice.getInvoice_number());

        return "redirect:/api/invoice/invoices";
    }



//    @GetMapping("/newInvoicesGoodsById")
//    public String NewInvoice2(Model model, @ModelAttribute("invoice_number") int invoice_number){
//
//        model.addAttribute("RejectedInvoiceProducts", productService.findByInvoiceNumber(invoice_number));
//
//        return "NewInvoiceNomenclatures";
//    }

}
