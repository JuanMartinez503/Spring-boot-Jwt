package io.juanmartinez.Jwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private  UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception{
      return
              http.csrf(customizer->customizer.disable())
        .authorizeHttpRequests(request->request.anyRequest().authenticated())
        //you can enable the form login  .formLogin(Customizer.withDefaults()) enabling the form con sometimes lead to errors
//
        // basic is to enable forms for testing of rest apis
        .httpBasic(Customizer.withDefaults())

        .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).build();

    }
    //this is only an example
//    @Bean
//    public UserDetailsService userDetailsService (){
//        UserDetails user1 = User.withDefaultPasswordEncoder().username("juan").password("123").roles("USER").build(); //do not ever do this in production
//        return new InMemoryUserDetailsManager(user1);
//    }
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        provider.setUserDetailsService(userDetailsService);

        return provider;
    }
}
