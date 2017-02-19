package resourcebundle.sample;

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
    }

    public static void main(String[] args) {
        new ResourceBundleSample().run();
    }

}
