package com.frontend.qa.modules;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.database.Database;


public class InventoryForm {
	  WebDriver driver;
	 public InventoryForm(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(xpath = "//input[@id='SearchKeyword']")
	WebElement SearchField;

	@FindBy(xpath = "//button[contains(@onclick,'doSearch')]")
	WebElement SubmitButton;

	@FindBy(xpath = "//button[@type='button' and contains(text(),'Soit')][1]")
	WebElement PrDropdown;

	@FindBy(xpath = "//button[contains(@onclick,'removeSearch')]")
	WebElement SerchRemoveButton;

	public void priceRuleValue() throws ClassNotFoundException, SQLException {
		
		//SerchRemoveButton.click();
		// driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String Query = "select stocknumber from inventory_master where dsprovider='IZMOVN-PGA-RENAULT' "
				+ "and dealerid='VNC4491'  and location='Annemasse'and inventory_type='NEW' and source_make='RENAULT'"
				   + " and status='ACTV'";
		ResultSet data = Database.getData(Query);
		boolean firstData = data.next();
		String ID = "";
		if (firstData) {
			ID = data.getString(1);
			// System.out.println(ID);
		}
		SearchField.sendKeys(ID);	
		//SearchField.sendKeys(DataproviderFactory.getExcel().getData("Sheet4", 1, 1));
		SubmitButton.click();
		PrDropdown.click();
	}

	public void otherValue() throws ClassNotFoundException, SQLException {
		SerchRemoveButton.click();
		String Query = "select stocknumber from inventory_master where dsprovider='IZMOVN-PGA-RENAULT' "
				+ "and dealerid='VNC4490'  and location='Thonon Renault'and inventory_type='NEW' and source_make='RENAULT'"
				   + " and status='ACTV'";
		ResultSet data = Database.getData(Query);
		boolean firstData = data.next();
		String ID = "";
		if (firstData) {
			ID = data.getString(1);
			// System.out.println(ID);
		}
		SearchField.sendKeys(ID);
		SubmitButton.click();
		PrDropdown.click();

	}

	public void MakepriceRuleValue() throws ClassNotFoundException, SQLException {
		SerchRemoveButton.click();
		String Query ="select stocknumber from inventory_master where dsprovider='IZMOVN-PGA-RENAULT' and"
				+ " dealerid='VNC4491'  and location='ANNEMASSE' and inventory_type='NEW' and make='RENAULT'"
				+ " and model='CAPTUR NOUVEAU' and trim ='Intens Captur TCe 90 Energy 5 Portes' and  status='ACTV'";
	
		ResultSet data = Database.getData(Query);
		boolean firstData = data.next();
		String ID = "";
		if (firstData) {
			ID = data.getString(1);
			// System.out.println(ID);
		}
		SearchField.sendKeys(ID);	
		SubmitButton.click();
		PrDropdown.click();

	}

	public void otherMakepriceRuleValue() throws ClassNotFoundException, SQLException {
		SerchRemoveButton.click();
		// driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String Query ="select stocknumber from inventory_master where dsprovider='IZMOVN-PGA-RENAULT' and"
				+ " dealerid='VNC4491'  and location='ANNEMASSE' and inventory_type='NEW' and make='RENAULT'"
			+ " and model='CLIO IV' and   status='ACTV'";
	
		ResultSet data = Database.getData(Query);
		boolean firstData = data.next();
		String ID = "";
		if (firstData) {
			ID = data.getString(1);
			// System.out.println(ID);
		}
		SearchField.sendKeys(ID);
		SubmitButton.click();
		PrDropdown.click();

	}
	
		
	//Citroen Dealer 
	
	public void citroenpriceRuleValue() throws ClassNotFoundException, SQLException {
		
		String Query ="select stocknumber from inventory_master where dsprovider='IZMOVN-PGA-CITROEN' "
		+ "and dealerid='SADAL CITROËN ANNECY'  and location='SEYNOD' and inventory_type='NEW' and status='ACTV'";
	
		ResultSet data = Database.getData(Query);
		boolean firstData = data.next();
		String ID = "";
		if (firstData) {
			ID = data.getString(1);
			// System.out.println(ID);
		}
		SearchField.sendKeys(ID);
		SubmitButton.click();
		PrDropdown.click();
	}

	public void citroenExpiredpriceRuleValue() throws ClassNotFoundException, SQLException {
        
		String Query ="select stocknumber from inventory_master where dsprovider='IZMOVN-PGA-CITROEN' "
				+ "and dealerid='SADAL CITROËN ANNECY'  and location='SEYNOD' and inventory_type='NEW' and status='ACTV'";
			
				ResultSet data = Database.getData(Query);
				boolean firstData = data.next();
				String ID = "";
				if (firstData) {
					ID = data.getString(1);
					// System.out.println(ID);
				}
		
		SearchField.sendKeys(ID);
		SubmitButton.click();
		// PrDropdown.click();

	}

	public void inactivepriceRuleValue() throws ClassNotFoundException, SQLException {
		String Query = "select stocknumber from inventory_master where dsprovider='IZMOVN-PGA-RENAULT' "
				+ "and dealerid='VNC4491'  and location='Annemasse'and inventory_type='NEW' and source_make='RENAULT'"
				   + " and status='ACTV'";
		ResultSet data = Database.getData(Query);
		boolean firstData = data.next();
		String ID = "";
		if (firstData) {
			ID = data.getString(1);
			// System.out.println(ID);
		}
		SearchField.sendKeys(ID);
		SubmitButton.click();
		PrDropdown.click();

	}

	public void withousIsPrimary() throws ClassNotFoundException, SQLException {
		String Query ="select stocknumber from inventory_master where dsprovider='IZMOVN-PGA-CITROEN' "
				+ "and dealerid='SADAL CITROËN ANNECY'  and location='SEYNOD' and inventory_type='NEW' and status='ACTV'";
			
				ResultSet data = Database.getData(Query);
				boolean firstData = data.next();
				String ID = "";
				if (firstData) {
					ID = data.getString(1);
					// System.out.println(ID);
				}
		
		SearchField.sendKeys(ID);
		SubmitButton.click();
		// PrDropdown.click();
	}
	
 public void deletecitroenpriceRuleValue() throws ClassNotFoundException, SQLException {
		
		String Query ="select stocknumber from inventory_master where dsprovider='IZMOVN-PGA-CITROEN' "
		+ "and dealerid='SADAL CITROËN ANNECY'  and location='SEYNOD' and inventory_type='NEW' and status='ACTV'";
	
		ResultSet data = Database.getData(Query);
		boolean firstData = data.next();
		String ID = "";
		if (firstData) {
			ID = data.getString(1);
			// System.out.println(ID);
		}
		SearchField.sendKeys(ID);
		SubmitButton.click();
		//PrDropdown.click();
	}
	
	

}
