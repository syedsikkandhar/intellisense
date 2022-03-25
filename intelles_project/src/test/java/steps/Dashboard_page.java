package steps;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Dashboard_page extends baseclass

{
	SoftAssert s_assert = new SoftAssert();
	public static Properties prop = new Properties();
	
	 @Given("^Go to (.+)$")
	    public void go_to(String url) throws InterruptedException, IOException 
	 	{
		 	WebDriverManager.chromedriver().setup();
	        setDriver();
	        getDriver().get(url);
	        getDriver().manage().window().maximize();
	        Thread.sleep(3000);
	        FileInputStream fis = new FileInputStream("/Users/syedbasha/Documents/Personal_Projects/intelles_project/src/main/java/Properties/locator.properties");
	        prop.load(fis);
	        String expectedtitle = url;
	        String actualtitile = getDriver().getCurrentUrl();
	        s_assert.assertEquals(expectedtitle, actualtitile);
	        System.out.println("Tile are same");
	        
	        
	    }
	 
	 @When("^enter the usename as (.+) and password as (.+)$")
	 public void enter_the_usename_as_and_password_as(String uname, String password) 
	 {
		 WebElement user_name = getDriver().findElement(By.id(prop.getProperty("user_name")));
	     user_name.sendKeys(uname);
	     String actual_name = user_name.getAttribute("value");
	     System.out.println(actual_name);
	     System.out.println("***************");
	     String expected_name = uname;
	     s_assert.assertEquals(expected_name, actual_name);
		 System.out.println("Username is same");
		 
		 WebElement psword = getDriver().findElement(By.id(prop.getProperty("password")));
	     psword.sendKeys(password);
	     String actual_password = psword.getAttribute("value");
	     System.out.println(actual_password);
	     System.out.println("***************");
	     String expected_password = password;
	     s_assert.assertEquals(expected_password, actual_password);
		 System.out.println("Password is same");
		    
	    }

	    @Then("^click sign_in button$")
	    public void click_signin_button() throws InterruptedException 
	    {
	    	WebElement login = getDriver().findElement(By.xpath(prop.getProperty("sign_in")));
	    	login.click();
	    	Thread.sleep(3000);
	        
	    }
	    @Then("^navigate to (.+)$")
	    public void navigate_dashboardpage(String dashboard) throws InterruptedException
	    {
	    	Thread.sleep(3000);
	    	getDriver().get(dashboard);
	    	String expectedtitle = dashboard;
	        String actualtitile = getDriver().getCurrentUrl();
	        s_assert.assertEquals(expectedtitle, actualtitile);
	        System.out.println("Tile are same");
	    	
	    	
	    }
	    @When("^click the time option$")
	    public void click_the_time_option() throws InterruptedException 
	    {
	    	Thread.sleep(5000);
	    	WebElement time = getDriver().findElement(By.xpath(prop.getProperty("date_new")));
	    	time.click();
	    	Thread.sleep(3000);
	    	WebElement historic = getDriver().findElement(By.xpath(prop.getProperty("historic")));
	    	historic.click();
	      }
	    
	    @Then("^select month as (.+) and date as (.+) from dropdown$")
	    public void select_month_as_and_date_as_from_dropdown(String frommonthyear, String fromdate) throws InterruptedException
	    {
	    	Thread.sleep(3000);
	    	WebElement down_arrow = getDriver().findElement(By.xpath(prop.getProperty("from_date")));
	    	down_arrow.click();
	    	WebElement right_button = getDriver().findElement(By.xpath(prop.getProperty("from_right_button")));
	    	while(true)
	    	{
	    		String from_year = getDriver().findElement(By.xpath(prop.getProperty("select_year"))).getText();
		    	String trim_from_year = from_year.replaceAll("\\s+", "");
		    	
		    	System.out.println("***********");
		    	System.out.println(trim_from_year);
	    		if(trim_from_year.equals(frommonthyear))
	    		{
	    			break;
	    		}
	    		else
	    		{
	    			right_button.click();
	    		}
	    	}
	    	List <WebElement> from_date = getDriver().findElements(By.xpath(prop.getProperty("select_from_date")));
	    	int total_date = from_date.size();
	    	for(int i=0;i<total_date;i++)
	    	{
	    		String select_date = from_date.get(i).getText();
	    		System.out.println(select_date);
	    		if(select_date.equals(fromdate))
	    		{
	    			from_date.get(i).click();
	    			break;
	    		}
	    	}
	    }
	    
	    @Then("^select the from_time as (.+) and seconds as (.+)$")
	    public void select_the_fromtime_as_and_seconds_as(String fromtime, String fromseconds) 
	    {
	    	List <WebElement> from_time_select = getDriver().findElements(By.xpath(prop.getProperty("select_time")));
	    	int total_time = from_time_select.size();
	    	for(int i=0;i<total_time;i++)
	    	{
	    		String time_value = from_time_select.get(i).getText();
	    		System.out.println(time_value);
	    		if(time_value.equals(fromtime))
	    		{
	    			from_time_select.get(i).click();
	    		}
	    	}
	    	List <WebElement> from_seconds_select = getDriver().findElements(By.xpath(prop.getProperty("select_seconds")));
	    	int total_seconds = from_seconds_select.size();
	    	for(int i=0;i<total_seconds;i++)
	    	{
	    		String seconds_value = from_seconds_select.get(i).getText();
	    		System.out.println(seconds_value);
	    		if(seconds_value.equals(fromseconds))
	    		{
	    			from_seconds_select.get(i).click();
	    		}
	    	}
	    }
	    
	    @Then("^select month as (.+) and date as (.+) to dropdown$")
	    public void select_month_as_and_date_as_to_dropdown(String tomonthyear, String todate) throws InterruptedException
	    {
	    	Thread.sleep(3000);
	    	WebElement to_down_arrow = getDriver().findElement(By.xpath(prop.getProperty("to_date")));
	    	to_down_arrow.click();
	    	WebElement to_right_button = getDriver().findElement(By.xpath(prop.getProperty("select_to_right_button")));
	    	while(true)
	    	{
	    		String to_year = getDriver().findElement(By.xpath(prop.getProperty("select_to_year"))).getText();
		    	String trim_from_year = to_year.replaceAll("\\s+", "");
		    	System.out.println("***********");
		    	System.out.println(trim_from_year);
	    		if(trim_from_year.equals(tomonthyear))
	    		{
	    			break;
	    		}
	    		else
	    		{
	    			to_right_button.click();
	    		}
	    	}
	    	Thread.sleep(3000);
	    	List <WebElement> to_date = getDriver().findElements(By.xpath(prop.getProperty("select_to_date")));
	    	int total_to_date = to_date.size();
	    	for(int i=0;i<total_to_date;i++)
	    	{
	    		String select_date = to_date.get(i).getText();
	    		System.out.println(select_date);
	    		if(select_date.equals(todate))
	    		{
	    			to_date.get(i).click();
	    			break;
	    		}
	    	}
	    	WebElement submit = getDriver().findElement(By.xpath(prop.getProperty("submit_button")));
	    	JavascriptExecutor js = (JavascriptExecutor)getDriver();
	    	js.executeScript("arguments[0].scrollIntoView();", submit);
	    	
           }
	    @Then("^select the to_time as (.+) and seconds as (.+)$")
	    public void select_the_totime_as_and_seconds_as(String totime, String toseconds) throws InterruptedException 
	    {
	    	Thread.sleep(3000);
	    	List <WebElement> to_time_select = getDriver().findElements(By.xpath(prop.getProperty("select_to_time")));
	    	int total_to_time = to_time_select.size();
	    	for(int i=0;i<total_to_time;i++)
	    	{
	    		String time_to_value = to_time_select.get(i).getText();
	    		System.out.println(time_to_value);
	    		if(time_to_value.equals(totime))
	    		{
	    			to_time_select.get(i).click();
	    		}
	    	}
	    	Thread.sleep(3000);
	    	List <WebElement> to_seconds_select = getDriver().findElements(By.xpath(prop.getProperty("select_to_seconds")));
	    	int total_to_seconds = to_seconds_select.size();
	    	for(int i=0;i<total_to_seconds;i++)
	    	{
	    		String seconds_to_value = to_seconds_select.get(i).getText();
	    		System.out.println(seconds_to_value);
	    		if(seconds_to_value.equals(toseconds))
	    		{
	    			to_seconds_select.get(i).click();
	    		}
	    	}
	    	Thread.sleep(3000);
	    	WebElement submit = getDriver().findElement(By.xpath(prop.getProperty("submit_button")));
	    	submit.click();
	    	Thread.sleep(3000);
	    	JavascriptExecutor jse = (JavascriptExecutor)getDriver();
	    	jse.executeScript("window.scrollBy(0,document.body.scrollHeight);");
	    }
	    @When("^click the homepage icon$")
	    public void click_the_homepageicon() throws InterruptedException 
	    {
	    	Thread.sleep(3000);
	    	WebElement home_button = getDriver().findElement(By.xpath(prop.getProperty("Home_button")));
	    	home_button.click();
	    	Thread.sleep(3000);
	  }
	    @Then("^click Cancel option in the dashboard window$")
	    public void click_okay() throws InterruptedException
	    {
	    	WebElement cancel_button = getDriver().findElement(By.xpath(prop.getProperty("dashboard_window")));
	    	cancel_button.click();
	    	Thread.sleep(3000);
	    	
	    }
	    @When("^click the duplicate dashboard icon$")
	    public void click_the_duplicate_dashboard_icon() throws InterruptedException 
	    {
	    	WebElement duplicate_button = getDriver().findElement(By.xpath(prop.getProperty("duplicate_dashboard")));
	    	duplicate_button.click();
	    	Thread.sleep(3000);
	    
	    }
	    @Then("^click Cancel option in the duplicate dashboard window$")
	    public void click_cancel_option_in_the_duplicate_dashboard_window() throws InterruptedException 
	    {
	    	WebElement check_box = getDriver().findElement(By.xpath(prop.getProperty("check_box")));
	    	check_box.click();
	    	Thread.sleep(3000);
	    	if(check_box.isSelected())
	    	{
	    		System.out.println("Checkbox is selected. So uncheck the checkbox");
	    		check_box.click();
	    		Thread.sleep(3000);
	    	}
	    	WebElement cancel_button = getDriver().findElement(By.xpath(prop.getProperty("dashboard_window")));
	    	cancel_button.click();
	    	Thread.sleep(3000);
	       
	    }
	    
	    @When("^click the download icon$")
	    public void click_the_download_icon() throws InterruptedException 
	    {
	    	WebElement export_data = getDriver().findElement(By.xpath(prop.getProperty("export_data")));
	    	export_data.click();
	    	Thread.sleep(3000);
	    }
	    
	    @Then("^download the files$")
	    public void download_the_files() throws InterruptedException
	    {
	    	WebElement pdf_data = getDriver().findElement(By.xpath(prop.getProperty("report_pdf_01")));
	    	pdf_data.click();
	    	Thread.sleep(3000);
	    	WebElement edit_option = getDriver().findElement(By.xpath(prop.getProperty("edit_option")));
	    	edit_option.click();
	    	Thread.sleep(3000);
	    	WebElement edit_confirm = getDriver().findElement(By.xpath(prop.getProperty("edit_confirm")));
	    	edit_confirm.click();
	    	Thread.sleep(3000);
	    	WebElement report_excel = getDriver().findElement(By.xpath(prop.getProperty("report_excel")));
	    	report_excel.click();
	    	Thread.sleep(3000);
	    	WebElement report_csv = getDriver().findElement(By.xpath(prop.getProperty("report_csv")));
	    	report_csv.click();
	    	Thread.sleep(3000);
	    	WebElement cancel_button = getDriver().findElement(By.xpath(prop.getProperty("cancel_window_01")));
	    	cancel_button.click();
	    	Thread.sleep(3000);
	    	
	    }
	    
	    @When("^click the dashboard icon$")
	    public void click_the_dashboard_icon()
	    {
	    	WebElement dashboard_icon = getDriver().findElement(By.xpath(prop.getProperty("dashboard_icon")));
	    	dashboard_icon.click();
	        
	    }
	    @Then("^check the datas displaying under dashboard icon$")
	    public void check_the_datas() throws InterruptedException 
	    {
	    	WebElement dashboard_data = getDriver().findElement(By.xpath(prop.getProperty("dashboard_data")));
	    	dashboard_data.click();
	    	Thread.sleep(3000);
	    	getDriver().navigate().back();
	    
	    }
	    @When("^click the thickner icon$")
	    public void click_the_thickner_icon() throws InterruptedException 
	    {
	    	WebElement thickner_icon = getDriver().findElement(By.xpath(prop.getProperty("thickner_icon")));
	    	thickner_icon.click();
	    	Thread.sleep(3000);
	    }

	    @When("^click the flotation icon$")
	    public void click_the_flotation_icon() throws InterruptedException 
	    {
	    	WebElement flotation_icon = getDriver().findElement(By.xpath(prop.getProperty("flotation_icon")));
	    	flotation_icon.click();
	    	Thread.sleep(3000);
	    }

	    @When("^click the pump icon$")
	    public void click_the_pump_icon() throws InterruptedException 
	    {
	    	WebElement pump_icon = getDriver().findElement(By.xpath(prop.getProperty("pump_icon")));
	    	pump_icon.click();
	    	Thread.sleep(3000);
	    }

	    @Then("^check the datas displaying under pump icon$")
	    public void check_the_datas_displaying_under_pump_icon() throws InterruptedException 
	    {
	    	WebElement pump_icon = getDriver().findElement(By.xpath(prop.getProperty("pump_operator")));
	    	pump_icon.click();
	    	Thread.sleep(3000);
	    	getDriver().navigate().back();
	      }
	    @Then("^click the search option$")
	    public void click_the_search_option() throws InterruptedException 
	    {
	    	WebElement search_option = getDriver().findElement(By.xpath(prop.getProperty("search_option")));
	    	search_option.click();
	    	Thread.sleep(3000);
	    	WebElement expand_all = getDriver().findElement(By.xpath(prop.getProperty("expand_all")));
	    	expand_all.click();
	    	Thread.sleep(3000);
	    	expand_all.click();
	    	Thread.sleep(3000);
	    	getDriver().navigate().back();
	    	Thread.sleep(3000);
	    	
	  }
	    @Then("^verify the notification option$")
	    public void verify_the_notification_option() throws InterruptedException
	    {
	    	WebElement notification_option = getDriver().findElement(By.xpath(prop.getProperty("notification")));
	    	notification_option.click();
	    	WebElement view_all = getDriver().findElement(By.xpath(prop.getProperty("view_all")));
	    	view_all.click();
	    	Thread.sleep(5000);
	    }
	    @Then("^change the alert options$")
	    public void alert_options() throws InterruptedException
	    {
	    	WebElement enable_check_box = getDriver().findElement(By.xpath(prop.getProperty("enable_check_box")));
	    	enable_check_box.click();
	    	Thread.sleep(3000);
	    	WebElement cancel = getDriver().findElement(By.xpath(prop.getProperty("cancel")));
	    	cancel.click();
	    	String parent = getDriver().getWindowHandle();
	    	System.out.println("Parent window id is" + parent);
	    	WebElement tab_set = getDriver().findElement(By.xpath(prop.getProperty("tab_set")));
	    	tab_set.click();
	    	Thread.sleep(3000);
	    	Set <String> new_window = getDriver().getWindowHandles();
	    	int count = new_window.size();
	    	System.out.println("Total window count is"+ count);
	    	for(String child :new_window)
	    	{
	    		if(!parent.equalsIgnoreCase(child))
	    		{
	    		getDriver().switchTo().window(child);
	    		WebElement text = getDriver().findElement(By.xpath(prop.getProperty("tab_set_text")));
	    		System.out.println("The text of the new window : "+ text.getText());
	    		Thread.sleep(3000);
	    		getDriver().switchTo().window(parent);
	    		}
	    	}
	    	WebElement action_edit = getDriver().findElement(By.xpath(prop.getProperty("action_edit")));
	    	action_edit.click();
	    	Thread.sleep(2000);
	    	WebElement view_details = getDriver().findElement(By.xpath(prop.getProperty("view_details")));
	    	view_details.click();
	    	Thread.sleep(2000);
	    	Actions act = new Actions(getDriver());
	    	act.sendKeys(Keys.ESCAPE).build().perform();
	    }
	    
	    		
}

