package utilities;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Selectutility {

	public static void selectByVisibleText(WebElement userRoleDropdown, String name)
	{
		Select sel= new Select(userRoleDropdown);
		sel.selectByVisibleText(name);
	}
	
}
