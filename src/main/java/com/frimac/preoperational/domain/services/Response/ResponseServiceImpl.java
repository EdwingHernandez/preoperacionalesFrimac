package com.frimac.preoperational.domain.services.Response;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.frimac.preoperational.domain.dto.ResponseDTO;
import com.frimac.preoperational.persistence.entities.Question;
import com.frimac.preoperational.persistence.entities.Response;
import com.frimac.preoperational.persistence.entities.User;
import com.frimac.preoperational.persistence.repositories.QuestionRepository;
import com.frimac.preoperational.persistence.repositories.ResponseRepository;
import com.frimac.preoperational.persistence.repositories.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ResponseServiceImpl implements ResponseService {

    private final ResponseRepository responseRepository;
    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;

    public ResponseServiceImpl(ResponseRepository responseRepository, UserRepository userRepository, QuestionRepository questionRepository) {
        this.responseRepository = responseRepository;
        this.userRepository = userRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public List<ResponseDTO> findAll() {
        return responseRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ResponseDTO> findById(Long id) {
        return responseRepository.findById(id).map(this::toDTO);
    }

    @Override
    public ResponseDTO save(ResponseDTO responseDTO) {
        User user = userRepository.findById(responseDTO.getIdUser())
            .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con id " + responseDTO.getIdUser()));

        Question question = questionRepository.findById(responseDTO.getIdQuestion())
            .orElseThrow(() -> new EntityNotFoundException("Pregunta no encontrada con id " + responseDTO.getIdQuestion()));

        Response response = new Response();
        response.setResponse(responseDTO.getResponse());
        response.setDate(responseDTO.getDate() != null ? responseDTO.getDate() : new Date());
        response.setUser(user);
        response.setQuestion(question);

        Response newResponse = responseRepository.save(response);
        return toDTO(newResponse);
    }

    @Override
    public ResponseDTO update(Long id, ResponseDTO responseDTO) {
        Response existingResponse = responseRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Respuesta no encontrada con id " + id));

        if (responseDTO.getResponse() != null) {
            existingResponse.setResponse(responseDTO.getResponse());
        }

        if (responseDTO.getDate() != null) {
            existingResponse.setDate(responseDTO.getDate());
        }

        if (responseDTO.getIdUser() != null) {
            User user = userRepository.findById(responseDTO.getIdUser())
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con id " + responseDTO.getIdUser()));
            existingResponse.setUser(user);
        }

        if (responseDTO.getIdQuestion() != null) {
            Question question = questionRepository.findById(responseDTO.getIdQuestion())
                .orElseThrow(() -> new EntityNotFoundException("Pregunta no encontrada con id " + responseDTO.getIdQuestion()));
            existingResponse.setQuestion(question);
        }

        Response updatedResponse = responseRepository.save(existingResponse);
        return toDTO(updatedResponse);
    }

    @Override
    public Boolean delete(Long id) {
        if (!responseRepository.existsById(id)) {
            return false;
        }
        responseRepository.deleteById(id);
        return true;
    }

    private ResponseDTO toDTO(Response response) {
        return new ResponseDTO(
            response.getId(),
            response.getResponse(),
            response.getDate(),
            response.getUser().getId(),
            response.getQuestion().getId()
        );
    }
}

