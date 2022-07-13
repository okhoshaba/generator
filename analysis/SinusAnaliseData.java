// https://morioh.com/p/8628150eefde
//
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class SinusAnaliseData {
    public static void main(String[] args) {
       Scanner scan;
       double second, sumSecond = 0.0;
       double sumFromFile=0.0;
       String s = "";
       String inputFile = "data.txt";
       String sumFile = "sum.txt";
       String line;
       int first;
       int n = 0;

       try {
           s = args[0];
       } catch (Exception e) {
           System.out.println("The first argument must be present!");
           System.exit(1);
       }

       try {
           n = Integer.parseInt(args[0]);
       } catch (NumberFormatException e) {
           System.out.println("The second argument must be an integer.");
           System.exit(1);
       }


        try (BufferedReader br =
                     new BufferedReader(new FileReader(inputFile))) {
            while((line = br.readLine()) != null){
//              For diagnostics only
//                System.out.println(line);
                String[] arrOfStr = line.split(",");
                  first = Integer.parseInt(arrOfStr[1]);
                  if (first == n) {
                    second = Double.parseDouble(arrOfStr[6]);
                    sumSecond += second;
//              For diagnostics only
//                    System.out.println(" " + first + " == " + second);
//                    System.out.println(args[0] + " , " + sumSecond);
                  }
            }
            System.out.println(args[0] + "," + sumSecond);
        } catch (Exception e){
            System.out.println(e);
        }

        // Read from file 
        File file = new File(sumFile);
        try {
          scan = new Scanner(file);
          while(scan.hasNextDouble()) {
            sumFromFile = scan.nextDouble() + sumSecond;
//              For diagnostics only
//            System.out.println( " " + sumFromFile );
//            System.out.println( scan.nextDouble() );
        }

        } catch (FileNotFoundException e1) {
          e1.printStackTrace();
        }
          
        // Write to file 
        try {
		        Path fileName = Path.of(sumFile);
		        Files.writeString(fileName, "" + sumFromFile);
        } catch (IOException e) {
          System.out.println("IOException : " + e);
        }
    }
}
