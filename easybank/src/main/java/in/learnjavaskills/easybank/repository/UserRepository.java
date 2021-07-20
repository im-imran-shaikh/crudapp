package in.learnjavaskills.easybank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.learnjavaskills.easybank.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>
{
	User findByUserIdEmailOrUserIdUsername(String email, String username);
}
