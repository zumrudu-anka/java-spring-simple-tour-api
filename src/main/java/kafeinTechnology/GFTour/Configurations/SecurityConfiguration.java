package kafeinTechnology.GFTour.Configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    private final String[] URLLISTFORONLYADMINS = new String[]{
        "/h2-console/**",
        "/swagger-ui.html/**"
    };

    private final String[] CSRFIGNORINGURLS = new String[]{
        "/h2-console/**",
        "/api/**"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers(URLLISTFORONLYADMINS).hasRole("ADMIN")//allow h2 console access to admins only
            .anyRequest().authenticated()//all other urls can be access by any authenticated role
            .and().formLogin()//enable form login instead of basic login
            .and().csrf().ignoringAntMatchers(CSRFIGNORINGURLS)//don't apply CSRF protection to /h2-console
            .and().headers().frameOptions().sameOrigin();//allow use of frame to same origin urls
    }

}