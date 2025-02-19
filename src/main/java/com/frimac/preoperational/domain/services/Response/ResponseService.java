package com.frimac.preoperational.domain.services.Response;

import java.util.List;
import java.util.Optional;

import com.frimac.preoperational.persistence.entities.Response;


public interface ResponseService {

        List<Response> findAll();
    Optional<Response> findById(Long id);
    Response save(Response response);
    Response update(Long id, Response response);
    Optional<Response> delete(Long id); 
}
