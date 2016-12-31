package classloader.sample;

import java.io.IOException;
import java.util.Properties;

@SuppressWarnings("javadoc")
public class ClassLoaderSample {

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(ClassLoader.getSystemResourceAsStream("sample.properties"));

        System.out.println(properties.getProperty("sample"));
    }

}
