package fileReaders;


import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvReader {

        public static List<String []> readFileData(String filePath){
            List<String[]> allData = null;
            try{
                FileReader fileReader = new FileReader(new File(filePath));
                CSVReader csvReader = new CSVReader(fileReader);
                allData =  csvReader.readAll();
                // log.debug("Found the file");


            }catch (Exception fne) {
                System.out.println("Not File Found");
                //log.error("File Not Found , Please Check the File Path");
            }
            return allData;
        }

        public static Map<String,String> getData(String filePath, String profile)
        {
            Map<String,String> myData = new HashMap<String, String>();
            List<String[]> allData = readFileData(filePath);
            int rowNumber = getRowFromProfile(filePath,profile);
            String [] allHeaders = allData.get(0);
            String [] requiredData = allData.get(rowNumber);
            for (int i=1 ; i<requiredData.length;i++) {
                myData.put(allHeaders[i], requiredData[i]);
            }
            return myData;
        }

        public static int getRowFromProfile(String filePath,String profile)
        {
            List<String []> allData = readFileData(filePath);
            int rowNumber = 0;
            for(int i=1;i<allData.size();i++){
                String [] requiredData = allData.get(i);
                String requiredProfile = requiredData[0];
                if(requiredProfile.equals(profile))
                {
                    rowNumber = i;
                    break;
                }
                else{
                    //log.error("No given profile Name");
                }
            }
            return rowNumber;
        }
}
