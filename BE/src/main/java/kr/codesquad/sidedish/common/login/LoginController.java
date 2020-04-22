package kr.codesquad.sidedish.common.login;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

@RestController
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);
    LoginService loginService = new LoginService();

    @GetMapping("/githublogin")
    public ResponseEntity<String> githubLogin(@PathParam("code") String code, HttpServletResponse response) throws JsonProcessingException {
        log.debug("code : {}", code);
        GithubToken githubToken = loginService.getAccessToken(code);
        String token = githubToken.getTokenType() + " " + githubToken.getAccessToken();
        response.setHeader("Authorization", token);
        return ResponseEntity.ok("logined");
    }
}
