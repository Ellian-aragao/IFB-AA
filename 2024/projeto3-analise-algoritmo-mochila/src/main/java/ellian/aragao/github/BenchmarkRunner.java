package ellian.aragao.github;

import java.io.File;
import java.io.IOException;
import java.net.URLClassLoader;

public class BenchmarkRunner {
    public static void main(String[] args) throws IOException {
        var classLoader = (URLClassLoader) BenchmarkRunner.class.getClassLoader();
        StringBuilder classpath = new StringBuilder();
        for (var url : classLoader.getURLs()) {
            classpath.append(url.getPath()).append(File.pathSeparator);
        }
        System.setProperty("java.class.path", classpath.toString());
        org.openjdk.jmh.Main.main(args);
    }
}