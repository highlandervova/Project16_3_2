package main;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File f = new File("aaa.txt");
        if (!f.exists()) {
            f.createNewFile();
        }
        try (BufferedReader r = new BufferedReader(new FileReader("aaa.txt"));
             BufferedWriter w = new BufferedWriter(new FileWriter("c:\\install\\bbb.txt"))) {
            String s;
            while ((s = r.readLine()) != null) {
                w.write(s);
                w.newLine();
            }
        }

        File f2 = new File("ccc.dll");
        try (InputStream is = new BufferedInputStream(new FileInputStream(f2));
             OutputStream os = new BufferedOutputStream(new FileOutputStream(new File("c:\\install\\ddd.txt")))) {
            int i;
            while ((i = is.read()) != -1) {
                os.write(i);
            }
        }
    }
}
