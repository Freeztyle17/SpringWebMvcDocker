package ru.fedotov.SpringWebMVC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fedotov.SpringWebMVC.model.*;
import ru.fedotov.SpringWebMVC.repository.ProviderRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProviderServiceImp implements ProviderService{
    @Autowired
    ProviderRepository a;
    @Override
    public List<Provider> getAllProviders() {
        return a.findAll();
    }

    @Override
    public Provider getProviderById(long id) {
        return a.findAll().stream().filter(provider -> provider.getId() == id).toList().get(0);
    }

    @Override
    public Provider getProviderByName(String name) {

        List<Provider>  list = a.findAll();
        if(list.isEmpty()){
            return null;
        }
        for (Provider p: list) {
            if(p.getName().equals(name))
                return p;
        }
        return null;

    }

    @Override
    public Provider save(String provider){

        Provider newProvider = new Provider();
        newProvider.setId(getAllProviders().size()+1);
        newProvider.setInvoicesCount(1);
        newProvider.setName(provider);
        newProvider.setComment("");

        return a.save(newProvider);
    }

    @Override
    public Provider find(long id) {
        return a.findById(id).orElseThrow();
    }

    @Override
    public Provider update(long id, Provider updatedProvider) {

        Provider ProviderUpd = find(id);

        ProviderUpd.setComment(updatedProvider.getComment());

        return a.save(ProviderUpd);
    }

    @Override
    public Provider save(Provider provider){
        return a.save(provider);
    }
}
