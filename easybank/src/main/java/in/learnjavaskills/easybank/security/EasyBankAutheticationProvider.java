package in.learnjavaskills.easybank.security;

import java.util.Collections;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import in.learnjavaskills.easybank.entity.User;
import in.learnjavaskills.easybank.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EasyBankAutheticationProvider implements AuthenticationProvider
{
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException
	{
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		User user = userRepository.findByUserIdEmailOrUserIdUsername(username, username);
		
		if (passwordEncoder.matches(password, user.getPassword()))
		{
			List<SimpleGrantedAuthority> authority = Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
			return new UsernamePasswordAuthenticationToken(username, password, authority);
		}
		else
			throw new BadCredentialsException("Username " + username + " doesn't exist");
		
	}

	@Override
	public boolean supports(Class<?> authentication)
	{
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
