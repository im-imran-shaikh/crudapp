package in.learnjavaskills.easybank.embadedId;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsersId implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String email;
	
	private String username;
}
