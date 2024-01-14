package ru.fedotov.SpringWebMVC.repository;

import org.springframework.data.repository.CrudRepository;
import ru.fedotov.SpringWebMVC.model.ReceiptStory;

import java.util.List;

public interface ReceiptStoryRepository extends CrudRepository<ReceiptStory, Long> {
    List<ReceiptStory> findAll();
}
