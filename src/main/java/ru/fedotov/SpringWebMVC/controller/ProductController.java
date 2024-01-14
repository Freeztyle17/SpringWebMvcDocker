package ru.fedotov.SpringWebMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.fedotov.SpringWebMVC.model.CheckInfo;
import ru.fedotov.SpringWebMVC.model.Receipt;
import ru.fedotov.SpringWebMVC.model.ReceiptStory;
import ru.fedotov.SpringWebMVC.service.ProductService;
import ru.fedotov.SpringWebMVC.service.ProviderService;
import ru.fedotov.SpringWebMVC.service.ReceiptService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService ps;
    @Autowired
    ProviderService a;
    @Autowired
    ReceiptService rs;

    @GetMapping("/products")
    public String Product(Model model){

        model.addAttribute("Products", ps.getAllProducts());

        return "Products";
    }

    @GetMapping("/productDetails")
    public String ProductDetail(Model model, @RequestParam("id") long id){

        model.addAttribute("ProductDetails", ps.getAllDetailsById(id));

        return "ProductDetails";
    }

    @GetMapping("/providerById")
    public String Provider(Model model, @RequestParam("id") long id){
        model.addAttribute("Providers", a.getProviderById(id));
        return "Providers";
    }

    @GetMapping("/productsForReceipt")
    public String productsForReceipt(Model model){

        model.addAttribute("Products", ps.getAllProducts());
        model.addAttribute("ReceiptFormer", new CheckInfo());

        return "Release";
    }



    @PostMapping("/createReceipt")
    public String createCheck(Model model, @ModelAttribute("ReceiptFormer") CheckInfo checkInfo){



        int nomenclature_count = 0;
        int sum = 0;



        List<Integer> counts = checkInfo.getProducts_count();
        List<Long> ids =  checkInfo.getProducts_id();

        int maxI = ids.size();


        List<Integer> cc = counts.stream().filter(Objects::nonNull).toList();

        List<Integer> indexes = new ArrayList<>();
        for (Long i:ids) {
            indexes.add((int)(i-1));
        }

        System.out.println(maxI);
        System.out.println(indexes);
        System.out.println(ids);
        System.out.println(cc);
        System.out.println(checkInfo.getProducts_id());



        for (int minI=0; minI<maxI; minI++) {


            ReceiptStory receiptStoryTmp = new ReceiptStory(
            rs.getAllReceiptStory().size()+1,
            rs.getMaxCheckId()+1,
            ps.returnProductWithChanges(ids.get(minI),
            cc.get(minI)),
            cc.get(minI),
            ps.getProductById(ids.get(minI)).getPriceRetail()
            );

            nomenclature_count++;
            sum+=ps.getProductById(ids.get(minI)).getPriceRetail();


            rs.saveReceiptStory(receiptStoryTmp);

            minI++;
        }

        Date dateNow = new Date();
        Receipt receipt = new Receipt(
                rs.getAllChecks().size()+1,
                dateNow,
                nomenclature_count,
                sum
        );

        rs.saveReceipt(receipt);

        model.addAttribute("Receipts", rs.getAllChecks());

        return "Receipts";
    }

}


















//          ids.get(index_s);
//          counts.get(index_s);



//            ps.getProductById(checkInfo.getProducts_id().get()),
//            checkInfo.getProducts_count().get(index_s)



//        receiptStory.setId(rs.getAllReceiptStory().size()+1);
//        receiptStory.setReceipt_id();
//        receiptStory.setPriceRetail();
//        receiptStory.setCount();

//            receiptStory.setProduct( ps.getProductById(id));
//            sum += ps.getProductById(id).getPriceRetail()*checkInfo.getProduct_count();

//
//
//
//        Date dateNow = new Date();
//        receipt.setId(rs.getAllChecks().size()+1);
//        receipt.setDate_of_operation(dateNow);
//        receipt.setNomenclature_count(checkInfo.getProduct_count());
//        receipt.setPrice_result();

//        Receipt receipt = new Receipt();
//        receipt.setId(rs.getAllChecks().size()+1);
//
//        Date dateNow = new Date();
//        receipt.setDate_of_operation(dateNow);
//        receipt.setNomenclature_count(checkInfo.size());
//
//        int count = 0;
//        for (CheckInfo prod: checkInfo) {
//
//            int colvo = prod.getProduct_count();
//            count+=(ps.getProductById(prod.getProduct_id()).getPriceRetail()*colvo);
//        }
//
//        receipt.setPrice_result(count);
//