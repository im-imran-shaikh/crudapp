package in.learnjavaskills.easybank.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import in.learnjavaskills.easybank.enums.Role;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SpringSecurityConfigure extends WebSecurityConfigurerAdapter
{
	private final CorsConfigurationSourceImpl corsConfigurationsSourceImpl;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.cors()
			.configurationSource(corsConfigurationsSourceImpl);
		
		http.csrf()
			.ignoringAntMatchers("/contact")
			.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
		
		http.authorizeRequests()
			.antMatchers("/notices").permitAll()
			.antMatchers("/contact").permitAll()
			.antMatchers("/myAccount").hasAnyRole(Role.ADMIN.toString())
			.anyRequest()
			.fullyAuthenticated()
			.and().formLogin().and().httpBasic();
	}
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception
//	{
//		auth.inMemoryAuthentication()
//			.withUser("Imran").password(NoOpPasswordEncoder.getInstance().encode("1234")).roles("admin").and()
//			.withUser("Iqbal").password(NoOpPasswordEncoder.getInstance().encode("1234")).roles("user")
//			.and().passwordEncoder(NoOpPasswordEncoder.getInstance());
//			
//	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
}
