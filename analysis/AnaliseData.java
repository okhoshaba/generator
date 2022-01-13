import java.io.BufferedReader;  
import java.io.FileReader;  
import java.io.IOException;  

public class AnaliseData
{  
  public static void main(String[] args) {  
    String line = "";  
    String splitBy = ";";  

    try {  //parsing a CSV file into BufferedReader class constructor  
      BufferedReader bufferedReader = new BufferedReader(new FileReader("data.csv")); 
      while ((line = bufferedReader.readLine()) != null) { 
        String[] data = line.split(splitBy); 
        System.out.println("Data: [Cycle = " + data[2] + ", count Period = " + data[4] + ", amplitude = " + data[6] + ", srt = " + data[8] +"]");  
      } 
      bufferedReader.close(); 
    } 
    catch (IOException e) { 
      e.printStackTrace(); 
    } 
  } 
} 
