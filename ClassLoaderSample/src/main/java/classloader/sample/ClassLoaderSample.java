package classloader.sample;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.function.Function;

@SuppressWarnings("javadoc")
public class ClassLoaderSample {

    public void run() throws IOException {
        final String resourceName = "sample.properties";

        // this.getClass()#getResourceAsStream の場合は、
        // 同一パッケージ階層からリソースを取得する
        System.out.println(this.getProperty(resourceName,
                this.getClass()::getResourceAsStream));

        // ClassLoader.getSystemResourceAsStream の場合は、
        // デフォルトパッケージからリソースを取得する
        System.out.println(this.getProperty(resourceName,
                ClassLoader::getSystemResourceAsStream));

        // ClassLoader.getSystemResourceAsStream でパッケージ階層を指定した場合は、
        // そのパッケージ階層からリソースを取得する
        System.out.println(this.getProperty(
                this.getClass().getPackage().getName().replace(".", "/") + "/" + resourceName,
                ClassLoader::getSystemResourceAsStream));
    }

    protected String getProperty(String resourceName,
            Function<String, InputStream> loadFunction) throws IOException {
        try (InputStream inStream = loadFunction.apply(resourceName)) {
            Properties properties = new Properties();
            properties.load(inStream);
            return properties.getProperty("sample");
        }
    }

    public static void main(String[] args) throws IOException {
        new ClassLoaderSample().run();
    }

}
