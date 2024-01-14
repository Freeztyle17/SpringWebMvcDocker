package ru.fedotov.SpringWebMVC.repository;

import org.springframework.data.repository.CrudRepository;
import ru.fedotov.SpringWebMVC.model.Product;
import ru.fedotov.SpringWebMVC.model.ProductDetail;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    public List<Product> findAll();

}
