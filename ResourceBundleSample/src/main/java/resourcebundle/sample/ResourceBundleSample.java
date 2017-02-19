package resourcebundle.sample;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.ResourceBundle;

@SuppressWarnings("javadoc")
public class ResourceBundleSample {

    /** Utf8EncodingControl */
    public static final Utf8EncodingControl ENCODING_CONTROL = new Utf8EncodingControl();

    public void run() {
        // デフォルトパッケージのリソースの場合
        ResourceBundle bundleDefaultPackage = ResourceBundle.getBundle("test", ENCODING_CONTROL);
        System.out.println(bundleDefaultPackage.getString("test"));

        // パッケージ階層上のリソースの場合は「.」区切りまたは「/」区切りで指定する
        // 両者が混ざっていても良い
        ResourceBundle bundleCurrentPackageDot = ResourceBundle
                .getBundle(this.getClass().getPackage().getName() + ".test", ENCODING_CONTROL);
        System.out.println(bundleCurrentPackageDot.getString("test"));
        ResourceBundle bundleCurrentPackageSlash = ResourceBundle
                .getBundle(this.getClass().getPackage().getName().replace(".", "/") + ".test",
                        ENCODING_CONTROL);
        System.out.println(bundleCurrentPackageSlash.getString("test"));

        // パスを指定してリソースを取得
        try {
            URL url = Paths.get("./prop").toFile().toURI().toURL();
            System.out.println(url.toString());
            URLClassLoader loader = new URLClassLoader(new URL[] { url });
            // クラスパス内とは別のベース名を指定しないと読み込まれない
            ResourceBundle bundleCurrentPath = ResourceBundle
                    .getBundle("_test", Locale.getDefault(), loader, ENCODING_CONTROL);
            System.out.println(bundleCurrentPath.getString("test"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ResourceBundleSample().run();
    }

}
