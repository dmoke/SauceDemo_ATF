package utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import lombok.SneakyThrows;
import models.LoginData;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CSVUtils {
    private static final String CSV_FILE_PATH = readProperties("src/test/java/properties/workflow.properties", "data");

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
    @SneakyThrows
    public static String readProperties(String path, String property){
        Properties prop = new Properties();
        InputStream input = new FileInputStream(path);
        prop.load(input);

        return prop.getProperty(property);
    }
}
