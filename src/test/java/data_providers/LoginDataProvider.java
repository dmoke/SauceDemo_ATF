package data_providers;

import models.LoginData;
import org.testng.annotations.DataProvider;
import utils.CSVUtils;

import java.util.List;

public class LoginDataProvider {
    @DataProvider(name = "loginDataProvider")
    public static Object[][] getLoginData() {
        List<LoginData> loginDataList = CSVUtils.readCSVFile();
        Object[][] data = new Object[loginDataList.size()][1];
        for (int i = 0; i < loginDataList.size(); i++) {
            data[i][0] = loginDataList.get(i);
        }
        return data;
    }
}



