package in.learnjavaskills.easybank.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import in.learnjavaskills.easybank.entity.User;

public class UserDetailsImpl implements UserDetails
{
	private User user;

	public UserDetailsImpl(User user)
	{
		this.user = user;
	}
	
	private static final long serialVersionUID = 1L;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole().toString()));
	}

	@Override
	public String getPassword()
	{
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername()
	{
		// TODO Auto-generated method stub
		return user.getUserId().getEmail();
	}

	@Override
	public boolean isAccountNonExpired()
	{
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked()
	{
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired()
	{
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled()
	{
		// TODO Auto-generated method stub
		return true;
	}

}
