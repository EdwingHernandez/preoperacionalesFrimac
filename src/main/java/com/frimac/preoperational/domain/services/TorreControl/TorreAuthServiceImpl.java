package com.frimac.preoperational.domain.services.TorreControl;

import java.time.Instant;
import java.util.Map;
import org.springframework.http.MediaType;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

@Service
public class TorreAuthServiceImpl implements TorreAuthService{

 
    private final RestTemplate restTemplate;

    private final TorreApiProperties torreApiProperties;
    private String token;
    private Instant tokenExpiration;
    

    public TorreAuthServiceImpl(RestTemplate restTemplate, TorreApiProperties torreApiProperties) {
        this.restTemplate = restTemplate;
        this.torreApiProperties = torreApiProperties;
    }


    @Override
    public String getToken(){
        if (token == null || Instant.now().isAfter(tokenExpiration)) {
            refreshToken();            
        }
        return token;
    }


    public void refreshToken(){

        MultiValueMap<String, String> authRequest = new LinkedMultiValueMap<>();
        authRequest.add("grant_type", "password");
        authRequest.add("username", torreApiProperties.getUsername());
        authRequest.add("password", torreApiProperties.getPassword());
        authRequest.add("client_id", torreApiProperties.getClientid());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(authRequest, headers);
        
    
        ResponseEntity<Map<String, Object>> response = restTemplate.exchange(torreApiProperties.getAuthurl(), HttpMethod.POST, requestEntity, new ParameterizedTypeReference<Map<String, Object>>() {});
 
        Map<String, Object> responseBody = response.getBody();
            if (responseBody != null && responseBody.containsKey("access_token")) {
                token = (String) responseBody.get("access_token");
                int expiresIn = (int) responseBody.get("expires_in"); 
                tokenExpiration = Instant.now().plusSeconds(expiresIn);
            } else {
                throw new RuntimeException("Error obteniendo el token de autenticación");
            }

    }
    

}
