package org.dsaprep;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        // Creating a file
        try {
            File file = new File("temp.txt");
            file.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // Writing in a file
        try {
            FileWriter fw = new FileWriter("temp.txt");
            fw.write("Hello world, धन्यवाद!");
            fw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // Read from file
//        try{
//            FileReader fr = new FileReader("temp.txt");
//            while(fr.ready()){
//                System.out.println((char)fr.read());
//            }
//        } catch (IOException e){
//            System.out.println(e.getMessage());
//        }

        try (BufferedReader br = new BufferedReader(new FileReader("temp.txt"))) {
            while (br.ready()) {
                System.out.println(br.readLine());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // delete a file
        try {
            File file = new File("deleteFile.txt");
            file.createNewFile();
            if(file.delete()){
                System.out.println("file deleted successfully.!");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}