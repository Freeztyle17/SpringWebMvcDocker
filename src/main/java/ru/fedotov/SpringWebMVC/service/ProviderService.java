package ru.fedotov.SpringWebMVC.service;
import ru.fedotov.SpringWebMVC.model.Provider;

import java.util.List;

public interface ProviderService {

    List<Provider> getAllProviders();

    Provider getProviderById(long id);

    Provider getProviderByName(String name);

    Provider save(String provider);

    Provider save(Provider provider);

    Provider find(long id);

    Provider update(long id, Provider updatedProvider);
}
