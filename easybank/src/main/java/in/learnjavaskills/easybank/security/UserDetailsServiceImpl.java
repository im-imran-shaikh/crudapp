package in.learnjavaskills.easybank.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import in.learnjavaskills.easybank.entity.User;
import in.learnjavaskills.easybank.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService
{
	private final UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		User user = userRepository.findByUserIdEmailOrUserIdUsername(username, username);
		if (user == null)
			throw new UsernameNotFoundException("User with " + username + " does not exist");
		
		return new UserDetailsImpl(user);
	}

}
