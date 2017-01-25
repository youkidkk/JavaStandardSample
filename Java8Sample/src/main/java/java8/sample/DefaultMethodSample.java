package java8.sample;

/**
 * デフォルトメソッドサンプル
 */
public class DefaultMethodSample {

    /**
     * サンプルインターフェース
     */
    public static interface SampleInterface {

        /**
         * デフォルトメソッド
         *
         * @param text 文字列
         * @return 結果
         */
        default String defaultMethod(String text) {
            return "Default : " + this.methodA(text);
        }

        /**
         * メソッド
         *
         * @param text 文字列
         * @return 結果
         */
        String methodA(String text);

    }

    /**
     * メインメソッド
     *
     * @param args コマンドライン引数
     */
    public static void main(String[] args) {
        // SampleInterface は抽象メソッドが methodA のみのため、
        // ラムダ式（右辺）を使用して実装を記述
        SampleInterface sample = s -> s + " " + s;

        // デフォルトメソッドを呼び出す
        System.out.println(sample.defaultMethod("test"));
        // Result -> ”Default : test test”
    }

}
