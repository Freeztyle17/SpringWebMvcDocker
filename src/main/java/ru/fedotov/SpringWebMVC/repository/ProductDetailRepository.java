package ru.fedotov.SpringWebMVC.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.fedotov.SpringWebMVC.model.ProductDetail;

import java.util.List;

public interface ProductDetailRepository extends CrudRepository<ProductDetail, Long> {

     //@Query(name = "SELECT * FROM Product_detail WHERE prod_id=:id")
     List<ProductDetail> findAll();

     ProductDetail save(ProductDetail productDetail);


}
