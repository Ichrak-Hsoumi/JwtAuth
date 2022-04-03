package com.bezkoder.springjwt.security.services.Implements;

import com.bezkoder.springjwt.models.Services;
import com.bezkoder.springjwt.repository.ServiceRepository;
import com.bezkoder.springjwt.security.services.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesServiceImpl implements ServicesService {

    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public List<Services> getAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Services findById(Long id) {
        return serviceRepository.findById(id).isPresent() ? serviceRepository.findById(id).get() : null ;
    }

    @Override
    public void createService(Services service) {
        Services service1 = new Services();

        service1.setNom(service.getNom());
        service1.setCategory(service.getCategory());
        service1.setGuichets(service.getGuichets());
        service1.setClients(service.getClients());
        serviceRepository.save(service1);
    }

    @Override
    public void updateService(Long id, Services service) {
        Services service1 = serviceRepository.findById(id).isPresent() ? serviceRepository.findById(id).get() : null ;
        service1.setNom(service.getNom());
        service1.setCategory(service.getCategory());
        service1.setGuichets(service.getGuichets());
        service1.setClients(service.getClients());
        serviceRepository.save(service1);
    }

    @Override
    public void delete(Long id) {
        Services service1 = serviceRepository.findById(id).isPresent() ? serviceRepository.findById(id).get() : null ;
        serviceRepository.delete(service1);
    }
}
