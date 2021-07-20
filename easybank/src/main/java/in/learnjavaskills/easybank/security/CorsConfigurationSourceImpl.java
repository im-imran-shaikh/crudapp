package in.learnjavaskills.easybank.security;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

@Component
public class CorsConfigurationSourceImpl implements CorsConfigurationSource
{

	private final String UI_PATH = "http://localhost:4200";
	private final List<String> ALL_LIST = Collections.singletonList("*");
	
	@Override
	public CorsConfiguration getCorsConfiguration(HttpServletRequest request)
	{
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		
		corsConfiguration.setAllowedOriginPatterns(Collections.singletonList(UI_PATH));
		corsConfiguration.setAllowedMethods(ALL_LIST);
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedHeaders(ALL_LIST);
		corsConfiguration.setMaxAge(3600L);
		
		return corsConfiguration;
	}

}
