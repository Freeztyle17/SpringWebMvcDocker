package ru.fedotov.SpringWebMVC.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests() //.anyRequest().permitAll();

                .requestMatchers("api/provider/**").hasRole("DataAnalyzer")
                .requestMatchers("api/invoice/invoices").hasRole("DataAnalyzer")
                .requestMatchers("/api/product/providerById").hasRole("DataAnalyzer")
                .requestMatchers("/api/receipt/receipts").hasRole("DataAnalyzer")
                .requestMatchers("/api/product/productDetails").hasRole("DataAnalyzer")
                .requestMatchers("api/receipt/receiptStory").hasRole("DataAnalyzer")

                .requestMatchers("/api/product/products2").hasRole("Stocker")
                .requestMatchers("api/invoice/**").hasRole("Stocker")
                .requestMatchers("/api/product/productsForReceipt").hasRole( "Stocker")

                .requestMatchers("/index").hasAnyRole("DataAnalyzer", "Stocker")
                .requestMatchers("/api/product/products").hasAnyRole("DataAnalyzer", "Stocker")
                .requestMatchers("/api/claim/**").hasAnyRole("DataAnalyzer", "Stocker")
                .requestMatchers("/api/info/**").hasAnyRole("DataAnalyzer", "Stocker")

                .requestMatchers("/").permitAll()
                .requestMatchers("/acceptedPage").permitAll()
                .requestMatchers("/api/about/aboutInvoices").permitAll()
                .requestMatchers("/api/about/aboutClaims").permitAll()
                .and().formLogin().permitAll();

        return http.build();
    }

//                .anyRequest().authenticated()
//                .httpBasic(withDefaults());


//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests().requestMatchers("/**").hasRole("userS").and().formLogin();
//        return http.build();
//    }
    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails userStocker = User.withDefaultPasswordEncoder()
                .username("Stocker")
                .password("123")
                .roles("Stocker")
                .build();

        UserDetails userAdmin = User.withDefaultPasswordEncoder()
                .username("DAzer")
                .password("12345")
                .roles("DataAnalyzer")
                .build();

        return new InMemoryUserDetailsManager(userStocker, userAdmin);
    }



}
