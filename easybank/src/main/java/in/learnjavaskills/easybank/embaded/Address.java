package in.learnjavaskills.easybank.embaded;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@ToString
public class Address
{
	private String lineOne;
	
	private String lineTwo;
	
	private String city;
	
	private long zipcode;
	
	private String state;
	
	private String country;
}
