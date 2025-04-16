package com.sena.crud_basic.service;

import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.sena.crud_basic.DTO.RecaptchaResponseDTO;
import com.sena.crud_basic.repository.Irecaptcha;
@Service
public class recapchatService implements Irecaptcha {
    private static final String GOOGLE_RECAPTCHA_ENDPOINT = "https://www.google.com/recaptcha/api/siteverify";

    private final String RECAPTCHA_SECRET = "6LfzuhkrAAAAAKxzh1nPC10JseyOfh-lvMrRAX0I";

    @Override
    public boolean validateRecaptcha(String captcha){
        RestTemplate restTemplate = new RestTemplate();

        MultiValueMap<String, String> requestMap = new LinkedMultiValueMap<>();
        requestMap.add("secret", RECAPTCHA_SECRET);
        requestMap.add("response", captcha);

        RecaptchaResponseDTO apiResponse = restTemplate.postForObject(GOOGLE_RECAPTCHA_ENDPOINT, requestMap, RecaptchaResponseDTO.class);
        if(apiResponse == null){
            return false;
        }

        return Boolean.TRUE.equals(apiResponse.getSuccess());
    }

}
