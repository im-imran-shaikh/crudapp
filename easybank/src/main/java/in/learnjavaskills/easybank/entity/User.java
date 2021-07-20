package in.learnjavaskills.easybank.entity;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import in.learnjavaskills.easybank.embaded.Address;
import in.learnjavaskills.easybank.embadedId.UsersId;
import in.learnjavaskills.easybank.enums.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class User
{
	@EmbeddedId
	private UsersId userId;
	
	private String password;
	
	private String firstName;
	
	private String lastName;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Embedded
	private Address address;
	
}
