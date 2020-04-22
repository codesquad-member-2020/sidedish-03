package kr.codesquad.sidedish.common.login;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {
    private static final Logger log = LoggerFactory.getLogger(LoginService.class);
    String url = "https://github.com/login/oauth/access_token";
    String client_id = "bed01aae4e0ea3bebf24";
    String client_secret = "452595b0393eef42655db16938b856735d978c32";

    public GithubToken getAccessToken(String code) throws JsonProcessingException {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        Map header = new HashMap<String, String>();
        header.put("Accept", "application/json");
        headers.setAll(header);

        MultiValueMap<String, String> requestPayloads = new LinkedMultiValueMap<>();
        Map requestPayload = new HashMap<String, String>();
        requestPayload.put("client_id", client_id);
        requestPayload.put("client_secret", client_secret);
        requestPayload.put("code", code);
        requestPayloads.setAll(requestPayload);

        HttpEntity<?> request = new HttpEntity<>(requestPayloads, headers);
        ResponseEntity<?> response = new RestTemplate().postForEntity(url, request, String.class);
        String responseBody = response.getBody().toString();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, GithubToken.class);
    }

}
