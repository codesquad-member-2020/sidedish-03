package kr.codesquad.sidedish.common.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
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
    private String getAccessTokenUrl = "https://github.com/login/oauth/access_token";
    private String getUserEmailUrl = "https://api.github.com/user/emails";
    private String clientId = System.getenv("GITHUB_CLIENT_ID");
    private String clientSecret = System.getenv("GITHUB_CLIENT_SECRET");

    public GithubToken getAccessToken(String code) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        Map<String, String> header = new HashMap<>();
        header.put("Accept", "application/json");
        headers.setAll(header);

        log.debug("client_secret : {}", clientSecret);
        MultiValueMap<String, String> requestPayloads = new LinkedMultiValueMap<>();
        Map<String, String> requestPayload = new HashMap<>();
        requestPayload.put("client_id", clientId);
        requestPayload.put("client_secret", clientSecret);
        requestPayload.put("code", code);
        requestPayloads.setAll(requestPayload);

        HttpEntity<?> request = new HttpEntity<>(requestPayloads, headers);
        ResponseEntity<?> response = new RestTemplate().postForEntity(getAccessTokenUrl, request, GithubToken.class);
        return (GithubToken) response.getBody();
    }

    public String getUserEmail(String githubToken) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", githubToken);

        ResponseEntity<String> response = restTemplate.exchange(getUserEmailUrl, HttpMethod.GET, new HttpEntity<String>(headers), String.class);
        log.debug("getUserEmail Response : {}", response.getBody());
        return response.getBody();
    }

}
