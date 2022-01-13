import java.io.BufferedReader;  
import java.io.FileReader;  
import java.io.IOException;  

public class AnaliseData
{  
  public static void main(String[] args) {  
    int cycle, countPeriod, amplitude;
    String line = "";  
    String splitBy = ";";  

    try {  //parsing a CSV file into BufferedReader class constructor  
      BufferedReader bufferedReader = new BufferedReader(new FileReader("data.csv")); 
      while ((line = bufferedReader.readLine()) != null) { 
        String[] data = line.split(splitBy); 
//        System.out.println("Data: [Cycle = " + data[2] + ", count Period = " + data[4] + ", amplitude = " + data[6] + ", srt = " + data[8] +"]");  
        try {
          cycle = Integer.parseInt(data[2]);
          countPeriod = Integer.parseInt(data[4]);
          amplitude = Integer.parseInt(data[4]);

          System.out.printf("%d;%d;%d%n", cycle, countPeriod, amplitude);
        }
        catch (NumberFormatException ex) {
          ex.printStackTrace();
        }
      } 
      bufferedReader.close(); 
    } 
    catch (IOException e) { 
      e.printStackTrace(); 
    } 
  } 
} 
