package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by chethanc on 8/3/20.
 */
public class UIActions extends WebDriverSetUp{

  private WebDriver driver;

    public void switchToNewTab(){

    }

    public void switchToPreviousTab(){

    }


    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    public void contextClick(){
        getActions().contextClick();
    }

    public Actions getActions(){
        Actions actions = new Actions(driver);
        return actions;
    }

    public void scrollToElement(WebElement element){

    }

    public void scrollToPageEnd(){

    }

    public void clickOnElementByID(String id){
        try{
            getDriver().findElement(By.id(id));
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void enterText(String text ,WebElement element){
        if(element.isDisplayed()){
            element.clear();
            element.sendKeys(text);
            if(!element.getText().equalsIgnoreCase(text)){
                element.clear();
                element.sendKeys(text);
            }
        }



    }

    public boolean isElementDisplayed(WebElement element){
            if(element.isDisplayed()){
                return true;
        }else {
                return false;
            }
    }

    public void scrollToElementAndClick(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }
}
