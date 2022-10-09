package StepDefinitions;

import common.WebDriverSetUp;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import pages.HomePage;
import utils.ConstantUtils;

import java.util.ArrayList;
import java.util.List;

public class HomePageSteps{
    public WebDriver driver;
    HomePage homePage;
    List<String> compltedData;



    @Before
    public void openBrowserAndLogin(){
        WebDriverSetUp webDriverSetUp = new WebDriverSetUp();
        webDriverSetUp.setWebDriver();
        driver = webDriverSetUp.getDriver();
        driver.get(System.getProperty(ConstantUtils.urlKey));


    }

    @Given("user is on the home page")
    public void user_is_on_the_home_page() {
//         openBrowserAndLogin();
        homePage = new HomePage(driver);
        driver.getTitle().equalsIgnoreCase(ConstantUtils.projectTitle);

    }
    @Then("Verify all the elements are present in the home page")
    public void verify_all_the_elements_are_present_in_the_home_page() {
           homePage.verifyElements();
    }

//    @When("user Enters {string} in the site")
//    public void user_enters_in_the_site(String string) {
//        homePage.enterDetails(string);
//
//    }

    @When("user Enters GetMilk ,test1,test2,werwer in the site")
    public void user_enters_get_milk_test1_test2_werwer_in_the_site(List<String> testData) {
        for(String data : testData){
            homePage.enterDetails(data);
        }
    }

    @Then("verify all the list of todos are present")
    public void verify_all_the_list_of_todos_are_present() {

    }

    @When("user Enters the todos in the site")
    public void user_enters_the_todos_in_the_site(DataTable dataTable) {
        List<String> data = dataTable.row(0);
        for(String dat : data){
            homePage.enterDetails(dat);
        }
    }
    @Then("all the todos must be displayed")
    public void all_the_todos_must_be_displayed(DataTable dataTable) {
        List<String> data = dataTable.row(0);
        for(String dat : data){
            homePage.verifyDetails(dat);
        }
    }
    @Then("it should be displayed in Active section")
    public void it_should_be_displayed_in_active_section(DataTable dataTable) {
        List<String> expectedData = dataTable.row(0);
        List<String> actualData = homePage.getActiveLinkData();
        if(expectedData.size() == actualData.size()) {
            Assert.assertTrue(expectedData.equals(actualData));
        }
    }


    @When("marked it as completed")
    public void marked_it_as_completed(io.cucumber.datatable.DataTable dataTable) {
        List<String> data = dataTable.row(0);
        compltedData = new ArrayList<String>();
        compltedData = homePage.markCompletedAndGetData(data);
    }


    @Then("it should be displayed in completed section")
    public void it_should_be_displayed_in_completed_section(io.cucumber.datatable.DataTable dataTable) {
        List<String> data = dataTable.row(0);
        Assert.assertTrue(data.equals(compltedData));
    }

    @Then("it should be displayed in All section")
    public void it_should_be_displayed_in_all_section(io.cucumber.datatable.DataTable dataTable) {
        List<String> data = dataTable.row(0);
        List<String> expectedData = homePage.clickAllAndVerifyData();
        Assert.assertTrue(data.equals(expectedData));

    }

    @Then("it should be not displayed in active section")
    public void it_should_be_not_displayed_in_active_section() {
        boolean actualData = homePage.clickActiveAndVerifyNoData();
        Assert.assertFalse(actualData);
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }
}
