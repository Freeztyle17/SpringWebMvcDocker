package ru.fedotov.SpringWebMVC.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.fedotov.SpringWebMVC.model.Provider;

import java.util.List;
import java.util.Optional;

public interface ProviderRepository extends CrudRepository<Provider, Long> {

    List<Provider> findAll();

    Provider save(Provider provider);
}
