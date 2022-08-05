// java потоки планирование примеры
// http://proglang.su/java/multithreading
// https://overcoder.net/q/804488/потоки-в-java
// https://www.journaldev.com/1020/thread-sleep-java
//
// java Generator Количество_Тактов Частота_Дискретизации_сигнала
// java Generator Number_of_tacts Signal_Sampling_Rate(Period_of_Time)[1..1000Hz]
// java Generator 
// java Generator > aa.txt
//
import java.io.IOException;
import java.io.InputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Properties;
import java.lang.Math;

class SinusConfig {
	static int executionOrder = 0;
	static int numberOfTacts = 0;
  static int countAmplitude = 0;
  static int trajectoryMassive = 0;
	static int signalOfSamplingRate = 0;
	static int coefLoadImpact = 1;
  static double sumProcessingTime = 0.0;
  static double sumDurationTime = 0.0;
  static double sizeOfPerformanceBottl = 0.0;
	static String commandLine;
	static String trajectoryFile;
  static int [] amplitude;
}

class SinusTestBenchmark implements Runnable {
private int cycle;

public SinusTestBenchmark(int cycle){
  this.cycle = cycle;
}

public void execAmplitude(int cycle, int countPeriod, int countAmplitude) {
      double procTime, loadImpact, processDuration;
      long start, stop;
	    Runtime runtime;
      Process process;
//      long srt;
      // for diagnostic only
//      long  totalStart = System.currentTimeMillis();
    try   {     // Displaying the thread that is running
//      srt = 0L;
      for (int countObject = 0; countObject < countAmplitude ; countObject++) {
//        start = System.currentTimeMillis();
        start = System.nanoTime();
	      runtime = Runtime.getRuntime();
    	  process = runtime.exec(SinusConfig.commandLine);
	      process.waitFor();
        stop = System.nanoTime();
        processDuration = stop - start;
        procTime = (double)(100000000 / countAmplitude);
//        SinusConfig.sumProcessingTime += procTime;
//        SinusConfig.sumDurationTime += processDuration;
//        loadImpact = Math.log10(processDuration / procTime) * SinusConfig.coefLoadImpact; 
        loadImpact = Math.log10(procTime / processDuration) * SinusConfig.coefLoadImpact; 
//        SinusConfig.sizeOfPerformanceBottl += Math.log10(loadImpact); 
      // for diagnostic only
        System.out.println(cycle + "," + countPeriod + "," + countObject + "," + processDuration + "," + procTime + "," + loadImpact);
//        System.out.println(cycle + " , " + Math.log10(loadImpact));
      }

    } // end try
      catch (Exception e)   {     // Throwing an exception
        System.out.println ("Exception is caught");
      }
}

public void run() {
    try   {     // Displaying the thread that is running
      for (int countPeriod = 0; countPeriod < SinusConfig.trajectoryMassive; countPeriod++) {
        execAmplitude(cycle, countPeriod, SinusConfig.amplitude[countPeriod]);
      }
    } // end try
      catch (Exception e)   {     // Throwing an exception
        System.out.println ("Exception is caught");
      }
    } //end run
} 

class SinusGenerator {
    public static void main(String[] args)  throws InterruptedException, FileNotFoundException {
	    int count = 0;

        try (InputStream input = Generator.class.getClassLoader().getResourceAsStream("trajectory_sinus.properties")) {
            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find trajectory_sinus.properties");
                return;
            }

            //load a properties file from class path, inside static method
            prop.load(input);

            SinusConfig.numberOfTacts = Integer.valueOf(prop.getProperty("trajectory.numberOfTacts"));
            SinusConfig.trajectoryMassive = Integer.valueOf(prop.getProperty("trajectory.trajectoryMassive"));
            SinusConfig.coefLoadImpact = Integer.valueOf(prop.getProperty("trajectory.coefLoadImpact"));
            SinusConfig.commandLine = prop.getProperty("trajectory.commandLine");
            SinusConfig.trajectoryFile = prop.getProperty("trajectory.trajectoryFile");
//            Config.periodOfTime = 1000 / Config.signalOfSamplingRate;

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println(" Number of tacts (im units) = " + SinusConfig.numberOfTacts);
        System.out.println(" Number of massive (im units) = " + SinusConfig.trajectoryMassive);
//        System.out.println(" Signal_Sampling_Rate (im Hz) = " + SinusConfig.signalOfSamplingRate);
//        System.out.println(" Period Time (im ms) = " + Config.periodOfTime);
        System.out.println(" Trajectory File: " + SinusConfig.trajectoryFile);
        System.out.println(" Coef Load Impact: " + SinusConfig.coefLoadImpact);
        System.out.println(" Command Line: " + SinusConfig.commandLine);
        System.out.println("cycle , cPeriod , count , procDur , procTime , spb");

        SinusConfig.amplitude = new int [SinusConfig.trajectoryMassive];
//        File text = new File("sinus.txt");
        File text = new File(SinusConfig.trajectoryFile);
        Scanner scanner = new Scanner(text);
        while(scanner.hasNextInt()) 
          SinusConfig.amplitude[count++] = scanner.nextInt();
        scanner.close();

        for (int countCycles = 0; countCycles < SinusConfig.numberOfTacts; countCycles++) {
          SinusConfig.executionOrder = countCycles;
          Thread object = new Thread(new SinusTestBenchmark(countCycles));
            object.start();
            Thread.sleep(100);
          } // end for

      }
}

