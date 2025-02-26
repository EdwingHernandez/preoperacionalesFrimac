package com.frimac.preoperational.domain.services.Response;

import java.util.List;
import java.util.Optional;

import com.frimac.preoperational.domain.dto.ResponseDTO;


public interface ResponseService {

    List<ResponseDTO> findAll();
    Optional<ResponseDTO> findById(Long id);
    ResponseDTO save(ResponseDTO responseDTO);
    ResponseDTO update(Long id, ResponseDTO responseDTO);
    Boolean delete(Long id); 
}
