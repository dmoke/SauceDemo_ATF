package utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import models.LoginData;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {
    private static final String CSV_FILE_PATH = "src/test/resources/login_data.csv";

    public static List<LoginData> readCSVFile() {
        List<LoginData> loginDataList = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(CSV_FILE_PATH))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                LoginData loginData = new LoginData();
                loginData.setUsername(line[0]);
                loginData.setPassword(line[1]);
                loginDataList.add(loginData);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return loginDataList;
    }
}
