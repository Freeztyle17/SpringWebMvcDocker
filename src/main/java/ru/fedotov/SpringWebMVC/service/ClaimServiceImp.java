package ru.fedotov.SpringWebMVC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fedotov.SpringWebMVC.model.Claim;
import ru.fedotov.SpringWebMVC.model.ClaimInfo;
import ru.fedotov.SpringWebMVC.model.Provider;
import ru.fedotov.SpringWebMVC.repository.ClaimRepository;
import ru.fedotov.SpringWebMVC.repository.InvoiceRepository;
import ru.fedotov.SpringWebMVC.repository.ProviderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClaimServiceImp implements ClaimService{
    @Autowired
    ClaimRepository cr;

    @Autowired
    ProviderRepository pr;

    @Override
    public List<Claim> getAllClaims() {
        return cr.findAll();
    }

    @Override
    public ClaimInfo createClaim(ClaimInfo claimInfo) {
        return cr.save(claimInfo);
    }

    @Override
    public Claim find(long id) {
        return cr.findAll().stream().filter(claim -> claim.getId() == id).findAny().get();
    }



    public ClaimInfo toDTO(Claim claim){

        Optional<Provider> provider = pr.findById(claim.getProvider().getId());

        return ClaimInfo.builder()
                .id(claim.getId())
                .provider_id(provider.get().getId())
                .date_of_claim(claim.getDate_of_claim())
                .delivery_or_refund(claim.getDelivery_or_refund())
                .comment(claim.getComment())
                .status(claim.getStatus())
                .build();
    }

    @Override
    public ClaimInfo update(long id, Claim updClaim){

        Claim updatedClaim = find(id);

        updatedClaim.setStatus(updClaim.getStatus());

        return cr.save(toDTO(updatedClaim));
    }

}
