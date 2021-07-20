package in.learnjavaskills.easybank.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.learnjavaskills.easybank.entity.User;
import in.learnjavaskills.easybank.model.Contact;
import in.learnjavaskills.easybank.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PageController
{
	private final UserRepository userRepository;
	
//	@GetMapping("contact")
//	public String contact()
//	{
//		return "Welcome to the contact";
//	}
	
	@GetMapping("notices")
	public String notices()
	{
		return "Welcome to the notices";
	}
	
	@GetMapping("myAccount")
	public String account()
	{
		return "Welcome to the account";
	}
	
	@GetMapping("myBalance")
	public String myBalance()
	{
		return "Welcome to the myBalance";
	}
	
	
	@GetMapping("myCards")
	public String myCards()
	{
		return "Welcome to the myCards";
	}
	
	@GetMapping("myLoans")
	public String myLoans()
	{
		return "Welcome to the myLoans";
	}
	
	@GetMapping("user")
	public User getUserDetailsAfterLogin(Principal user)
	{
		return userRepository.findByUserIdEmailOrUserIdUsername(user.getName(), user.getName());
	}
	
	@PostMapping("contact")
	public Contact contact(@RequestBody Contact contact)
	{
		return contact;
	}
}
