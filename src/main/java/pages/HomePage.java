package pages;

import common.CommonElements;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends CommonElements {

private WebDriver driver;

    @FindBy(xpath = "//input[@autofocus='autofocus']")
    private WebElement searchBox;

    @FindBy(xpath = "//a[text()='Documentation']")
    private WebElement documentationLink;

    @FindBy(css = "a[href^='#/com']")
    private WebElement completedButton;

    @FindBy(css = "a[href^='#/active']")
    private WebElement activeButton;

    @FindBy(css= "a[href^='#/all']")
    private WebElement allButton;

    @FindBy(xpath = "//ul[@class='todo-list']")
    private WebElement toDoList;

    @FindBy(xpath = "//div[@class='view']/label")
    private List<WebElement> allToDos;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void verifyElements(){
        Assert.assertTrue(isElementDisplayed(searchBox));
        Assert.assertTrue(isElementDisplayed(documentationLink));
    }

    public void enterDetails(String todos){
        try{
            if(searchBox.isDisplayed()){
                enterText(todos,searchBox);
                searchBox.sendKeys(Keys.ENTER);Thread.sleep(2000);
            }
            else{
                System.out.println("Element is not displayed");
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void verifyDetails(String expected){
            for(WebElement element : allToDos){
                element.getText().equalsIgnoreCase(expected);
            }
    }

    public List<String> getActiveLinkData(){
        List<String> allToDoData =  new ArrayList<String>();
        try {
            if (activeButton.isDisplayed()) {
                activeButton.click();
                Thread.sleep(1000);
                for(WebElement element : allToDos){
                    allToDoData.add(element.getText());
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return allToDoData;

    }

    public List<String> markCompletedAndGetData(List<String>data){
        List<String> completedTodos =  new ArrayList<String>();
        try{
            if(toDoList.isDisplayed()){
                for(String dat : data) {
                    WebElement element = driver.findElement(By.xpath("//label[text()='" + dat + "']/../input"));
                    element.click();
                    Thread.sleep(1000);
                }
                if(completedButton.isDisplayed()){
                    completedButton.click();
                    Thread.sleep(1000);
                    for(WebElement element : allToDos){
                        completedTodos.add(element.getText());
                    }

                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }


           return completedTodos;

    }

    public List<String> clickAllAndVerifyData(){
        List<String> allTodos =  new ArrayList<String>();
        try{
            if(allButton.isDisplayed()) {
                System.out.println("All Data is displayed");
                Thread.sleep(1000);
                allButton.click();

                for (WebElement element : allToDos) {
                    allTodos.add(element.getText());
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return allTodos;
    }

    public boolean clickActiveAndVerifyNoData(){
        boolean isDataPresent=true;
        try {
            if (allButton.isDisplayed()) {
                System.out.println("All Data is displayed");
                Thread.sleep(1000);
                activeButton.click();
                Thread.sleep(1000);
                isDataPresent = toDoList.isDisplayed();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return isDataPresent;
    }


}
