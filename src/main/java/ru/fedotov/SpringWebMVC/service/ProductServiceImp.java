package ru.fedotov.SpringWebMVC.service;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fedotov.SpringWebMVC.model.Product;
import ru.fedotov.SpringWebMVC.model.ProductDetail;
import ru.fedotov.SpringWebMVC.model.RejectedInvoiceProducts;
import ru.fedotov.SpringWebMVC.repository.ProductDetailRepository;
import ru.fedotov.SpringWebMVC.repository.ProductRepository;
import ru.fedotov.SpringWebMVC.repository.RejectedInvoiceProductsRepository;
import ru.fedotov.SpringWebMVC.repository.RejectedInvoiceRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImp implements ProductService{

    @Autowired
    ProductRepository pr;
    @Autowired
    ProductDetailRepository pdr;

    @Autowired
    RejectedInvoiceProductsRepository rejectedInvoiceProductsRepository;

    @Override
    public List<Product> getAllProducts() {
        return pr.findAll();
    }

    @Override
    public Product getProductById(long id) {
        return pr.findAll().stream().filter(product -> product.getId() == id).toList().get(0);
    }

    @Override
    public Product getProductByNomenclature(String nomenclature) {
        List<Product>  list = pr.findAll();
        if(list.isEmpty()){
            return null;
        }
        for (Product p: list) {
            if(p.getNomenclature().equals(nomenclature))
                return p;
        }
        return null;
    }
    @Override
    public List<ProductDetail> getAllDetails() {
        return pdr.findAll();
    }

    @Override
    public List<ProductDetail> getAllDetailsById(long id) {
        return pdr.findAll().stream().filter(productDetail -> productDetail.getProduct() != null ).filter(productDetail -> productDetail.getProduct().getId() == id).toList();
    }
    @Override
    public Product save(Product product) {
        return pr.save(product);
    }

    @Override
    public ProductDetail save(ProductDetail productDetail) {
        return pdr.save(productDetail);
    }

    @Override
    public List<RejectedInvoiceProducts> findAllRejectedInvoiceProducts(){
        return rejectedInvoiceProductsRepository.findAll();
    }
    @Override
    public List<RejectedInvoiceProducts> findByInvoiceNumber(int invoice_number) {
        return rejectedInvoiceProductsRepository.findAll().stream().filter(rejectedInvoiceProducts -> rejectedInvoiceProducts.getInvoice_number() == invoice_number).toList();
    }

    @Override
    public RejectedInvoiceProducts save(RejectedInvoiceProducts productDetail) {
        return null;
    }

    @Override
    public Product returnProductWithChanges(long id, int countForCheck){
        Product productTmp = pr.findById(id).orElseThrow();
        List<ProductDetail> details = getAllDetailsById(id);
        int count = countForCheck;
        if(productTmp.getCount()<countForCheck){
            return null;
        }else{
            productTmp.setCount(productTmp.getCount()-countForCheck);
        }
        for (ProductDetail tmp: details) {
            if(tmp.getCount()<=count){
                count-=tmp.getCount();
                tmp.setCount(0);
                pdr.save(tmp);
                if(count==0) {
                    break;
                }
            }else{
                tmp.setCount(tmp.getCount()-count);
                pdr.save(tmp);
                break;
            }
        }
        pr.save(productTmp);
        return productTmp;
    }

    @Override
    public void deleteProductsByInvoiceNumber(int invoice_number) {
        List<RejectedInvoiceProducts> rejectedInvoiceProductsForDelete = findByInvoiceNumber(invoice_number);
        rejectedInvoiceProductsRepository.deleteAll(rejectedInvoiceProductsForDelete);
    }
//
//    @Override
//    public RejectedInvoiceProducts save(RejectedInvoiceProducts rejectedInvoiceProducts) {
//        return rejectedInvoiceProductsRepository.save(rejectedInvoiceProducts);
//    }


}
