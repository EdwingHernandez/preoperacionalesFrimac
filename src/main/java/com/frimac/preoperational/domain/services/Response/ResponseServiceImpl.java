package com.frimac.preoperational.domain.services.Response;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frimac.preoperational.persistence.entities.Response;
import com.frimac.preoperational.persistence.repositories.ResponseRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class ResponseServiceImpl implements ResponseService {

    @Autowired
    private ResponseRepository responseRepository;

    public ResponseServiceImpl(ResponseRepository responseRepository) {
        this.responseRepository = responseRepository;
    }

    @Override
    public List<Response> findAll() {
        return responseRepository.findAll();
    }

    @Override
    public Optional<Response> findById(Long id) {
        return responseRepository.findById(id);
    }  
    
    @Override
    public Response save(Response response) {
        return responseRepository.save(response);
    }    

    @Override
    public Response update(Long id, Response response) {
        if (!responseRepository.existsById(id)) {
            throw new EntityNotFoundException("Response no encontrada con id " + id);
        }
        response.setId(id); 
        return responseRepository.save(response);
    }    

    @Override
    @Transactional
    public Optional<Response> delete(Long id) {
        Optional<Response> response = responseRepository.findById(id);
        if (response.isPresent()) {
            responseRepository.deleteById(id);
        }
        return response;
    }



}
