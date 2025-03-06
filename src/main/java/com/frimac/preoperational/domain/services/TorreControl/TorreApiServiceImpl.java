package com.frimac.preoperational.domain.services.TorreControl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.frimac.preoperational.domain.dto.UserTCDTO;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@Service
public class TorreApiServiceImpl implements TorreApiService{

    private final TorreApiProperties torreApiProperties;
    private final TorreAuthService torreAuthService;
    private final RestTemplate restTemplate;

    public TorreApiServiceImpl(TorreApiProperties torreApiProperties, TorreAuthService torreAuthService,
            RestTemplate restTemplate) {
        this.torreApiProperties = torreApiProperties;
        this.torreAuthService = torreAuthService;
        this.restTemplate = restTemplate;
    }

    public UserTCDTO getUserTC(String id){
        String token = torreAuthService.getToken();

        String filter = "UcrSocId eq 53 and ((contains(Ucr_Code,'"+id+"')) or (contains(Ucr_Name,'" + id + "')) or (contains(Identification,'" + id + "')))";
        
        String url = UriComponentsBuilder.fromUriString(torreApiProperties.getUserurl())
                    .queryParam("$filter", filter)
                    .toUriString();
        url = URLDecoder.decode(url, StandardCharsets.UTF_8);
        System.out.println(url);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<String> entity = new HttpEntity<>(headers);


        ResponseEntity<Map<String, Object>> response = restTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<Map<String, Object>>() {});
        
        Map<String, Object> responseBody = response.getBody();
        System.out.println("Este el el responseBody:" + responseBody);
            if (responseBody != null && responseBody.containsKey("value")) {
                
                @SuppressWarnings("unchecked")
                List<Map<String, Object>> values = (List<Map<String, Object>>) responseBody.get("value");
                System.out.println("Estos son los values:" + values);
                for (Map<String, Object> obj : values) {
                    String idUserTC = (String) obj.get("Identification");
                    String nameUserTC = (String) obj.get("Ucr_Name");
                    String operationUserTC = (String) obj.get("UcrBusinessOperationTypeBopCode");
                    String positionUserTC = (String) obj.get("UtyName");
                    String sucursalUserTC = (String) obj.get("UcrSubsidiarySubCode");

                    boolean stateUserTC = false;
                    Integer condicion = (Integer) obj.get("State");
                    if (condicion == 1) {
                        stateUserTC = true;
                    }
                    return new UserTCDTO(idUserTC, nameUserTC, stateUserTC, operationUserTC, positionUserTC, sucursalUserTC);
                };

            } else {
                throw new RuntimeException("Usuario no encontrado");
            }

            return new UserTCDTO(null, null, false, null, null, null);
    }

    

    
}
