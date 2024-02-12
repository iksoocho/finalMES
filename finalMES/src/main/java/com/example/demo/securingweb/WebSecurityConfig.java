package com.example.demo.securingweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.demo.member.CustomAccessDeniedHandler;
import com.example.demo.member.CustomAuthenticationProvider;
import com.example.demo.member.FailureHandler;
import com.example.demo.member.LoginSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	private final LoginSuccessHandler loginSuccessHandler;
	private final FailureHandler failureHandler;
	private final CustomAuthenticationProvider customAuthenticationProvider;

	@Autowired
	public WebSecurityConfig(LoginSuccessHandler loginSuccessHandler, FailureHandler failureHandler,
			CustomAuthenticationProvider customAuthenticationProvider) {
		this.loginSuccessHandler = loginSuccessHandler;
		this.failureHandler = failureHandler;
		this.customAuthenticationProvider = customAuthenticationProvider;
	}
	
	@Bean
	public BCryptPasswordEncoder bcryptEncoder() {
		return new BCryptPasswordEncoder();
	}
//	  @Bean
//	    public PasswordEncoder passwordEncoder() {
//	        return NoOpPasswordEncoder.getInstance();
//	    }
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http
			.authorizeHttpRequests((requests) -> requests
				//.antMatchers("/**").permitAll()
				.antMatchers("/planManage").hasAnyRole("ADMIN")
				.anyRequest().authenticated()
				
			)
			.formLogin((form) -> form
				.loginPage("/login")
				.usernameParameter("userid")
				.successHandler(loginSuccessHandler)
				.failureHandler(failureHandler)
				.permitAll()
			)
			.exceptionHandling((exceptions) -> exceptions
		            .accessDeniedHandler(new CustomAccessDeniedHandler())
		        )
			.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))	
            .invalidateHttpSession(true) //로그아웃시 생성된 세션 삭제 활성화
            .deleteCookies("JSESSIONID")
            
			//.userDetailsService(null)
			;

		return http.build();
	}

	//@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("user")
				.password("1234")
				.roles("ADMIN")
				.build();

		return new InMemoryUserDetailsManager(user);
	}
}
