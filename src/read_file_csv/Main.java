package read_file_csv;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReadFile readFile = new ReadFile();
        List<String> stringList = readFile.readFile("src/read_file_csv/Input.csv");
        List<Country> stringCountry = readFile.stringCountry(stringList);
        for (Country item : stringCountry) {
            System.out.println(item.getName());
        }
    }
}
