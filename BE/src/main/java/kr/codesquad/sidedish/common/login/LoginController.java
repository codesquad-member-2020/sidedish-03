package kr.codesquad.sidedish.common.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
        String userEmail = loginService.getUserEmail(githubToken.getAuthorizationValue());
        Cookie email = new Cookie("email", userEmail);
        email.setPath("/");
        response.addCookie(email);
        log.debug("userEmail : {}", userEmail);
        String redirectUrl = "http://15.165.21.99";
        response.sendRedirect(redirectUrl);
        return new ResponseEntity<>(HttpStatus.TEMPORARY_REDIRECT);
    }
}
