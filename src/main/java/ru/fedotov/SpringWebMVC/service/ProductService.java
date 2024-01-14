package ru.fedotov.SpringWebMVC.service;
import ru.fedotov.SpringWebMVC.model.Product;
import ru.fedotov.SpringWebMVC.model.ProductDetail;
import ru.fedotov.SpringWebMVC.model.RejectedInvoiceProducts;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    Product getProductById(long id);
    Product getProductByNomenclature(String nomenclature);
    List<ProductDetail> getAllDetails();
    List<ProductDetail> getAllDetailsById(long id);
    Product save(Product product);
    ProductDetail save(ProductDetail productDetail);
    List<RejectedInvoiceProducts> findAllRejectedInvoiceProducts();
    List<RejectedInvoiceProducts> findByInvoiceNumber(int invoice_number);
    RejectedInvoiceProducts save(RejectedInvoiceProducts productDetail);
    Product returnProductWithChanges(long id, int countForCheck);
    void deleteProductsByInvoiceNumber(int invoice_number);

}
