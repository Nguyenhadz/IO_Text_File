package read_file_csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    public List<String> readFile(String filePath) {
        List<String> stringList = new ArrayList<>();
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                stringList.add(line);
            }

        } catch ( Exception e) {
            System.err.println("File error!");
        }
        return stringList;
    }
    public List<Country> stringCountry(List<String> stringList) {
        List<Country> stringComplete = new ArrayList<>();

        for (String item : stringList) {
            String[] infoCountry = item.split(",");
            Country country = new Country(infoCountry[0].replaceAll("[\"']", ""),infoCountry[1].replaceAll("[\"']", ""), infoCountry[2].replaceAll("[\"']", ""));
            stringComplete.add(country);
        }
        return stringComplete;
    }
}
