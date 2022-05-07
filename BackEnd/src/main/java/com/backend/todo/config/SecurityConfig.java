package com.backend.todo.config;

import com.backend.todo.auth.ApiKeyAuthFilter;
import com.backend.todo.auth.ApiKeyAuthProperties;
import com.backend.todo.constant.ErrorMessages;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private ApiKeyAuthProperties properties;

    private static final String[] AUTH_WHITELIST = {
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger",
            "/swagger-ui.html",
            "/webjars/**",
            "/v3/api-docs/**",
            "/swagger-ui/**"
    };

    private static final String[] AUTH_BLACKLIST = {};

    public SecurityConfig(ApiKeyAuthProperties properties){
        this.properties = properties;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ApiKeyAuthFilter filter = new ApiKeyAuthFilter(properties.getHeaderName());
        filter.setAuthenticationManager(authentication -> {
            String principal = (String) authentication.getPrincipal();
            if (!properties.getAuthToken().equals(principal)){
                throw new BadCredentialsException(ErrorMessages.AUTH_FAILED);
            }
            authentication.setAuthenticated(true);
            return authentication;
        });

        http.csrf().requireCsrfProtectionMatcher(new RequestMatcher() {
            private Pattern allowedMethods = Pattern.compile("^(GET|POST|PUT|PATCH|DELETE|HEAD|TRACE|OPTIONS)$");
            private RegexRequestMatcher apiMatcher = new RegexRequestMatcher("/v[0-9]*/.*",null);
                    @Override
                    public boolean matches(HttpServletRequest request) {
                        return !(allowedMethods.matcher(request.getMethod()).matches() || apiMatcher.matches(request));
                    }
                }
        );

        http.antMatcher("/**")
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().addFilter(filter).authorizeRequests()
                .antMatchers(AUTH_WHITELIST).permitAll()
                .antMatchers(AUTH_BLACKLIST).denyAll()
                .anyRequest().authenticated();

    }
}
