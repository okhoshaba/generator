import java.io.BufferedReader;  
import java.io.FileReader;  
import java.io.IOException;  
import java.lang.Math;

public class AnaliseData
{  
  public static void main(String[] args) {  
    int cycle, countPeriod, amplitude;
    double srt, ptr, mrt;
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
          amplitude = Integer.parseInt(data[6]);
          srt = Double.parseDouble(data[8]);
          srt /= amplitude;
          srt /= 1000000000;
          ptr = 0.1/amplitude;
          mrt = 10 * Math.log10(srt/ptr);

          System.out.printf("%d;%d;%d;%.3f;%.3f;%.2f;%n", cycle, countPeriod, amplitude, srt, ptr, mrt);
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
