package in.learnjavaskills.easybank;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import in.learnjavaskills.easybank.embaded.Address;
import in.learnjavaskills.easybank.embadedId.UsersId;
import in.learnjavaskills.easybank.entity.User;
import in.learnjavaskills.easybank.enums.Role;
import in.learnjavaskills.easybank.repository.UserRepository;

@SpringBootTest

public class UserTest
{
	@Autowired
	private UserRepository userRepository;
	
	@Test
	void findAllUsers()
	{
		userRepository.findAll()
					.forEach(System.out :: println);
	}
	
	@Test
	void findByEmail()
	{
		User findByUserIdEmail = userRepository.findByUserIdEmailOrUserIdUsername("imran@learnjavaskills.in", "imran@learnjavaskills.in" );
		System.out.println(findByUserIdEmail);
	}
	
	@Test
	void addUsers()
	{
		User user = new User();
		user.setUserId(new UsersId("imran@learnjavaskills.in", "imran.shaikh"));
		user.setAddress(new Address("tellopela", "janoter", "kejiya", 109235, "nemarito", "zeroko"));
		user.setFirstName("Imran");
		user.setLastName("Shaikh");
		user.setRole(Role.ADMIN);
		user.setPassword(new BCryptPasswordEncoder().encode("imran"));
		
		System.out.println(userRepository.save(user));
	}
}
