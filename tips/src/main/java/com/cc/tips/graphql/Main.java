package com.cc.tips.graphql;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://192.168.2.194:38090/graphql";
        String query = "{ highAndLowTypeBySalarySystemType(\\n    salarySystemType: Both\\n   ) {\\n    id\\n    description\\n    highAndLowField\\n    defaultValue\\n   }\\n}\\n\" }";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(String.format("{\"query\": \"%s\"}", query), headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);
        ObjectMapper MAPPER = new ObjectMapper();
        try {
//            Map<String, List<Map<String, Object>>> stringListMap = MAPPER.readValue(response.getBody(), new TypeReference<Map<String, List<Map<String, Object>>>>() {
//            });
            Map<String, Object> map = MAPPER.readValue(response.getBody(), Map.class);
            Map<String, Object> data = (Map<String, Object>) map.get("data");
            List<Map<String, Object>> highAndLowTypeBySalarySystemType = (List<Map<String, Object>>) data.get("highAndLowTypeBySalarySystemType");
            System.out.println(highAndLowTypeBySalarySystemType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }
}
