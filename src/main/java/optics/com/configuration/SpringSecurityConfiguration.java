//package optics.com.configuration;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        auth.inMemoryAuthentication()
//                .withUser("user").password("123").roles("USER")
//                .and()
//                .withUser("admin").password("123").roles("USER", "ADMIN");
//
//    }
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        http.authorizeRequests()
////                .antMatchers("/register").permitAll();
//                //.antMatchers("/confirm").permitAll();
//        //HTTP Basic authentication
//                http.httpBasic()
//                .and()
//                .authorizeRequests()
//              //  .antMatchers(HttpMethod.GET, "/books/**").hasRole("USER")
//                .antMatchers(HttpMethod.POST, "/register").hasRole("ADMIN")
////                .antMatchers(HttpMethod.PUT, "/books/**").hasRole("ADMIN")
////                .antMatchers(HttpMethod.PATCH, "/books/**").hasRole("ADMIN")
////                .antMatchers(HttpMethod.DELETE, "/books/**").hasRole("ADMIN")
//                .and()
//                .csrf().disable()
//                .formLogin().disable();
//    }
//}
