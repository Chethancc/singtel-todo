package common;

import fileReaders.CsvReader;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class TestDataProvider extends ElementProvider{

    public String reqFilePath;

    @BeforeTest
    public void preSetUp()
    {
       setWebDriver();
       openUrl();
    }

    @DataProvider(name = "dp")
    public Object[][] getData(){
        CsvReader csvReader = new CsvReader();
        return new Object[][] {
                {csvReader.getData(reqFilePath,"Profile1")}
        };
    }

    @AfterTest
    public void tearDown() throws Exception{
        closeDriver();
    }


}


