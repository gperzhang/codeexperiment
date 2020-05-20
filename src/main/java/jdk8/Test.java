package jdk8;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by zj on 2020-05-20
 */
public class Test {
    public static void main(String[] args) {
        File[] hiddenFiles = new File("").listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });

        File[] hiddenFiles1 = new File(".").listFiles(File::isHidden);
    }
}
