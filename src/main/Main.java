package main;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File f = new File("aaa.txt");
        if (!f.exists()) {
            f.createNewFile();
        }
        long t1 = System.currentTimeMillis();
        try (BufferedReader r = new BufferedReader(new FileReader(f));
             BufferedWriter w = new BufferedWriter(new FileWriter("c:\\install\\bbb.txt"))) {
            String s;
            s = r.readLine();
            if(s != null) {w.write(s);}
            while ((s = r.readLine())!= null) {
                w.newLine();
                w.write(s);
            }
        }

        long t2 = System.currentTimeMillis();
        System.out.println("BufferedReader+Writer "+(t2-t1)+" ms");

        t1 = System.currentTimeMillis();
        File f2 = new File("ccc.dll");
        try (InputStream is = new BufferedInputStream(new FileInputStream(f2));
             OutputStream os = new BufferedOutputStream(new FileOutputStream(new File("c:\\install\\ddd.txt")))) {
            int i;
            while ((i = is.read()) != -1) {
                os.write(i);
            }
        }
        t2 = System.currentTimeMillis();
        System.out.println("Input+Otput+Stream " + (t2-t1)+" ms");
    }
}
