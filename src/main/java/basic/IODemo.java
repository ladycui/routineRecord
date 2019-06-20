package basic;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class IODemo {

    public static void main(String[] args) {
        File f1 = new File("./iofile");//File.separator可以取操作系统分隔符，e.g. unix '/', while windows '\\'
        if (!f1.exists()) {
            try {
                f1.createNewFile();
                System.out.println("create a file successfully");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        f1.delete();//If this pathname denotes a directory, then the directory must be empty in order to be deleted.

        File f2 = new File("./src/com/cyn/practising");
        System.out.println(f2.getAbsolutePath());
        File[] files_2 = f2.listFiles();
        for (File f : files_2) {
            System.out.println(f.getName());
        }

        if (f2.isDirectory()) {
            System.out.println("this is a directory not a file");
        }
//        File[] files = f2.listFiles(new FileFilter() {
//            @Override
//            public boolean accept(File pathname) {
//                return pathname.getName().endsWith(".java");
//            }
//        });
        File[] files = f2.listFiles((pathname) -> pathname.getName().endsWith(".java"));
        for (File f : files) {
            System.out.println(f.getName());
        }
    }

}
