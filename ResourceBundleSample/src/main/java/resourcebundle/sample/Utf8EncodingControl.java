package resourcebundle.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.ResourceBundle.Control;

/**
 * UTF-8エンコードコントロール
 */
class Utf8EncodingControl extends Control {

    /** デフォルトキャラクタセット名 */
    protected static final String DEFAULT_CHARSET_NAME = "UTF-8";

    /** プロパティファイルタイプ接尾辞 */
    protected static final String PROPERTY_FILE_SUFFIX = "properties";

    /** キャラクタセット */
    protected static Charset CHARSET = Charset.forName(DEFAULT_CHARSET_NAME);

    /**
     * UTF-8 エンコーディングのプロパティファイルから ResourceBundle オブジェクトを生成
     * @throws IOException IO例外時
     */
    @Override
    public ResourceBundle newBundle(String baseName, Locale locale, String format,
            ClassLoader loader, boolean reload) throws IOException {
        String bundleName = this.toBundleName(baseName, locale);
        String resourceName = this.toResourceName(bundleName, PROPERTY_FILE_SUFFIX);

        try (InputStream is = loader.getResourceAsStream(resourceName);
                InputStreamReader isr = new InputStreamReader(is, CHARSET);
                BufferedReader reader = new BufferedReader(isr);) {
            return new PropertyResourceBundle(reader);
        } catch (UnsupportedEncodingException ex) {
            throw ex;
        } catch (IOException ex) {
            throw ex;
        }
    }

    /**
     * キャラクタセットを設定する
     *
     * @param charset キャラクタセット
     */
    public static void setCharset(Charset charset) {
        CHARSET = charset;
    }

}
