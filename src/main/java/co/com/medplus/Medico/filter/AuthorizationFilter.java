package co.com.medplus.Medico.filter;

import co.com.medplus.Medico.service.TokenService;
import co.com.medplus.Medico.service.KeyGeneratorService;
import java.io.IOException;
import java.security.Key;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

/**
 *
 * @author jorgelp
 */
public class AuthorizationFilter implements Filter {

    @Autowired
    private KeyGeneratorService keyService;

    @Autowired
    private TokenService tokenService;

    private final Boolean estado = true;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest _request = (HttpServletRequest) request;
        HttpServletResponse _response = (HttpServletResponse) response;
        String urlRequest = _request.getRequestURI();

      /*  if (!_request.getMethod().equals("OPTIONS") && !urlRequest.contains("/auth/login") && !urlRequest.contains("/swagger-resources") && !urlRequest.contains("/webjars/springfox-swagger-ui/") && !urlRequest.contains("/swagger-ui.html") && !urlRequest.contains("/v2/api-docs")
              ) {

            String auth = _request.getHeader("Authorization");

            if (auth == null) {

                _response.reset();
                _response.setStatus(HttpStatus.UNAUTHORIZED.value());
                _response.getWriter().println("Debe proporcionar un token de autorizacion");
                _response.getWriter().flush();
                return;

            }

            // Extract the token from the HTTP Authorization header
            String token = auth.substring("Bearer".length()).trim();
            Key _key = keyService.generateKey();

            boolean isValid = tokenService.isValid(token, _key);

            if (!isValid) {
                _response.reset();
                _response.setStatus(HttpStatus.UNAUTHORIZED.value());
                _response.getWriter().println("Token proporcionado invalido.");
                _response.getWriter().flush();
                return;

            }
        }*/
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

}
