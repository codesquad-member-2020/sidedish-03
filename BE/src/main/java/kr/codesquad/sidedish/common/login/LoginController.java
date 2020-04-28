package kr.codesquad.sidedish.common.login;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.io.IOException;

@RestController
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/githublogin")
    public ResponseEntity<String> githubLogin(@PathParam("code") String code, HttpServletResponse response) throws IOException {
        log.debug("code : {}", code);
        GithubToken githubToken = loginService.getAccessToken(code);
        loginService.getUserEmail(githubToken.getAuthorizationValue());

        ObjectMapper objectMapper = new ObjectMapper();
        String userInfo = loginService.getUserEmail(githubToken.getAuthorizationValue());
        JsonNode user = objectMapper.readTree(userInfo);
        for (JsonNode jsonNode : user) {
            if (jsonNode.get("primary").asBoolean()) {
                response.addCookie(new Cookie("email", jsonNode.get("email").textValue()));
            }
        }

        log.debug("userEmail : {}", user.get("email"));
        String redirectUrl = "http://15.165.21.99";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", redirectUrl);
        HttpStatus status = HttpStatus.TEMPORARY_REDIRECT;
        response.sendRedirect(redirectUrl);
        return new ResponseEntity<>(headers, status);
    }
}
