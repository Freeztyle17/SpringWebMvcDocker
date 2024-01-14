package ru.fedotov.SpringWebMVC.service;

import ru.fedotov.SpringWebMVC.model.Claim;
import ru.fedotov.SpringWebMVC.model.ClaimInfo;

import java.util.List;

public interface ClaimService {

    List<Claim> getAllClaims();

    ClaimInfo createClaim(ClaimInfo claimInfo);

    Claim find(long id);

    ClaimInfo update(long id, Claim updatedClaim);
}
