package chatapp.security;

import chatapp.models.User;
import chatapp.repositories.UserRepository;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 *
 * @author jnap
 */
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    UserRepository userRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        User user = userRepository.findByUsername(authentication.getName());
        response.setStatus(HttpStatus.OK.value());
        response.sendRedirect(request.getContextPath() + "/secured/success");
    }
}
