// https://morioh.com/p/8628150eefde
//
import java.io.BufferedReader;
import java.io.FileReader;

public class CsvReader {
    public static void main(String[] args) {
       String file = "data.txt";
       String line;
        try (BufferedReader br =
                     new BufferedReader(new FileReader(file))) {
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
