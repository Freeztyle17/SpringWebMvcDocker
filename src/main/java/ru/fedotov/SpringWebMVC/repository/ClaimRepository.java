package ru.fedotov.SpringWebMVC.repository;

import org.springframework.data.repository.CrudRepository;
import ru.fedotov.SpringWebMVC.model.Claim;
import ru.fedotov.SpringWebMVC.model.ClaimInfo;

import java.util.List;

public interface ClaimRepository extends CrudRepository<Claim, Long> {

    List<Claim> findAll();

    ClaimInfo save(ClaimInfo claimInfo);

}
