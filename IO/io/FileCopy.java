package io;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) throws IOException {

        //Settings.save()
        //Settings.load()
//        if(args.length != 2) {
//            System.err.println("Usage java " + FileCopy.class.getCanonicalName() + " <source> <dest>");
//            System.exit(-1);
//        }

        String fileName1 = "error.log";
        String fileName2 = "error.log.copy";
        //File f = new File("error.log.copy2");
        
        InputStream is = new FileInputStream(fileName1/*args[0]*/);
        OutputStream os = new FileOutputStream(fileName2/*args[1]*/);
        
        int b;
        while((b = is.read()) != -1) {
            os.write(b);
            System.out.println(b);
        }
         
        is.close();
        os.close();

        BufferedReader r = new BufferedReader(new FileReader(fileName1));
        String line;
        while((line = r.readLine()) != null) {
            System.out.println(line);
        }
        r.close();

        r = new BufferedReader(new FileReader(fileName1));
        while((b = r.read()) != -1) {
            System.out.print((char)b);
        }
        r.close();

        //ked chcem byte stream citat v znakoch
        //r = new BufferedReader(new InputStreamReader(is));

    }
}
