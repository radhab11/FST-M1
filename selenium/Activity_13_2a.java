package SeleniumActivities;

import java.io.IOException;


public class Activity_13_2a {
    public static void main(String args[]) throws IOException {
        String filePath = "src/SeleniumActivities/sample.xlsx";

        Activity_14_2 objExcelFile = new Activity_14_2();

        objExcelFile.writeExcel(filePath);

        objExcelFile.readExcel(filePath);
    }
	
}
