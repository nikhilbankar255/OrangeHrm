package utilities;

import net.datafaker.Faker;
import net.datafaker.providers.base.Address;
import net.datafaker.providers.base.Number;

public class FakerUtility {
	static Faker faker= new Faker();
	public static String fakeName()
	{
		 return faker.name().fullName();
	}
	
	public static Number fakeNumber()
	{
		 return  faker.number();
	}
	
	public static String fakeAddress()
	{
		 return  faker.address().fullAddress();
	}
	
	public static String fakeCity()
	{
		 return  faker.address().city();
	}
	
	public static String fakePhoneNumber()
	{
		 return  faker.phoneNumber().cellPhone();
	}
	
	public static  String fakeEmail()
	{
		 return  faker.internet().emailAddress();
	}
}
