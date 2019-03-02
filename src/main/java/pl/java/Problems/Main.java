package pl.java.Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        Process process;

        final String HOME_DIR = System.getProperty("user.home");
        System.out.println(HOME_DIR);

        try {
            process = Runtime.getRuntime().exec("cmd /c dir " + HOME_DIR);
            System.out.println(process.getOutputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }


            process = Runtime.getRuntime().exec("cmd /c " + HOME_DIR + "\\test.txt");
            process = Runtime.getRuntime().exec("mspaint.exe");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
             process.destroy();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
