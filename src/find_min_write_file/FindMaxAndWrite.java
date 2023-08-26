package find_min_write_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FindMaxAndWrite {
    public List<Integer> readFile(String filePath) {
        List<Integer> listNumbers = new ArrayList<>();
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                listNumbers.add(Integer.parseInt(line));
            }
            br.close();
        } catch (Exception e) {
            System.err.println("File không tồn tại hoặc nội dung có lỗi!");
        }
        return listNumbers;
    }


    public static int findMax(List<Integer> listNumbers) {
        int max = listNumbers.get(0);
        for (int item : listNumbers) {
            if (max < item) {
                max = item;
            }
        }
        return max;
    }
    public void writeFile(String filePath, int maxValue) {
        try {
            FileWriter writer = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("Max: " + maxValue);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        FindMaxAndWrite findMaxAndWrite = new FindMaxAndWrite();
        List<Integer> lisNumbers = findMaxAndWrite.readFile("src/find_min_write_file/Numbers.txt");
        int maxValue = findMax(lisNumbers);
        findMaxAndWrite.writeFile("src/find_min_write_file/result.txt", maxValue);
    }
}
