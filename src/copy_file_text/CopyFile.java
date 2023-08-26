package copy_file_text;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CopyFile {
    public List<String> readFile(String filePath) {
        List<String> stringList = new ArrayList<>();
        try {
            File file = new File(filePath);

            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                stringList.add(line);
            }
            br.close();
        } catch (Exception e) {
            System.err.println("File không tồn tại hoặc nội dung có lỗi!");
        }
        return stringList;
    }

    public void writeFile(String filePath, List<String> stringList) {
        try {
            FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for ( String item : stringList) {
                bufferedWriter.write(item + "\n");
            }
            bufferedWriter.close();;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CopyFile copyFile = new CopyFile();
        copyFile.writeFile("src/copy_file_text/Output.txt" ,copyFile.readFile("src/copy_file_text/Input.txt"));
    }
}
