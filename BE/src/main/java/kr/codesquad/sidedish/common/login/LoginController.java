package kr.codesquad.sidedish.common.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

@RestController
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/githublogin")
    public ResponseEntity<String> githubLogin(@PathParam("code") String code, HttpServletResponse response) {
        log.debug("code : {}", code);
        GithubToken githubToken = loginService.getAccessToken(code);
        response.setHeader("Authorization", githubToken.getAthorizationValue());
        //TODO : 응답객체를 만들어서 Wrapping하여 반환
        return ResponseEntity.ok("logined");
    }
}
