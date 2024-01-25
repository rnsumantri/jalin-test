package com.ronisumantri.jalinbisa.configuration;

import com.ronisumantri.jalinbisa.dto.HttpHeaderDto;
import com.ronisumantri.jalinbisa.repository.MasterRoleRepository;
import com.ronisumantri.jalinbisa.repository.MasterUsersRepository;
import com.ronisumantri.jalinbisa.services.HttpService;
import com.ronisumantri.jalinbisa.services.MasterUserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Base64;

@Component
public class HttpHeaderConfiguration extends OncePerRequestFilter {

    @Autowired
    private HttpService httpService;
    private static final String AUTH = "Authorization";

    @Autowired
    MasterUserService masterUserService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var auth = request.getHeader(AUTH);

        if (auth != null) {
            String[] parts = auth.split("\\s+");
            if (parts.length == 2) {
                String decodedCredentials = new String(java.util.Base64.getDecoder().decode(parts[1]));
                String[] userPassParts = decodedCredentials.split(":");

                if (userPassParts.length == 2) {
                    String username = userPassParts[0].trim();
                    String password = userPassParts[1].trim();
                    String passEncode = Base64.getEncoder().encodeToString(password.getBytes());

                    var isUsernameValid = masterUserService.getUserByUsername(username);
                        if (isUsernameValid != null){
                            var isPasswordValid = isUsernameValid.getHashPassword().equals(passEncode);
                            if (isPasswordValid){
                                filterChain.doFilter(request, response);
                            }
                        return;
                    }
                }
            }
        }

        this.signatureIsNotValid(response);
    }

    private void signatureIsNotValid(ServletResponse servletResponse) throws IOException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String error = "Non-Existent or invalid signature";
        response.reset();
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        servletResponse.setContentLength(error.length());
        servletResponse.getWriter().write(error);
    }
}
