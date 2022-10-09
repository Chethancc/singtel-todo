package common;

import org.openqa.selenium.WebElement;

public class ElementProvider extends UIActions{


    public void clickElement(WebElement element){
        element.click();
    }

    public void doubleClickElement(WebElement element){
        getActions().moveToElement(element).doubleClick();
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public void enterData(String data, WebElement element){
        if(element.isDisplayed()){
            element.sendKeys(data);
        }
    }



}
