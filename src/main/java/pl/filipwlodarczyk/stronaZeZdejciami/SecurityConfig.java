package pl.filipwlodarczyk.stronaZeZdejciami;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.filipwlodarczyk.stronaZeZdejciami.user.AppUserRepo;
import pl.filipwlodarczyk.stronaZeZdejciami.user.UserSerivceImplementation;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final AppUserRepo appUserRepo;

    public SecurityConfig(AppUserRepo appUserRepo) {
        this.appUserRepo = appUserRepo;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserSerivceImplementation(appUserRepo);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        String[] forAll = {
                "/css/**",
                "/images/**",
                "/fonts/**",
                "/scripts/**",
                "/registration",
                "/login"
        };


        http.csrf().disable();

        http.authorizeRequests().antMatchers(forAll).permitAll();

        http.authorizeRequests().antMatchers("/story/**").hasAuthority("ROLE_ADMIN");

        http.authorizeRequests().antMatchers("/profile/**").authenticated();

        http.authorizeRequests().anyRequest().authenticated();

        http.formLogin().loginPage("/login")
                .permitAll();

        http.formLogin().defaultSuccessUrl("/home", true);


        http.logout().permitAll();
    }


    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.authenticationProvider(authenticationProvider());
    }
}
