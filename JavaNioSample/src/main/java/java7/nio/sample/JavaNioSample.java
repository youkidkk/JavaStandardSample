package java7.nio.sample;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.Comparator;

/**
 * java.nio サンプル
 */
public class JavaNioSample {

    /** キャラクタセット */
    public static Charset CHARSET = Charset.forName("UTF-8");

    /** 一時ディレクトリパス */
    public static Path TMP_PATH = Paths.get(".", "tmp");

    /**
     * 一時ディレクトリの削除
     *
     * @throws IOException IO例外時
     */
    public void deleteTempDir() throws IOException {
        if (!Files.exists(TMP_PATH)) {
            return;
        }
        try {
            Files.walk(TMP_PATH)
                    .sorted(Comparator.reverseOrder())
                    .forEach(path -> {
                        try {
                            Files.delete(path);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (RuntimeException e) {
            Throwable cause = e.getCause();
            if (cause instanceof IOException) {
                throw (IOException) cause;
            } else {
                throw e;
            }
        }
    }

    /**
     * 一時ディレクトリの作成
     *
     * @throws IOException IO例外時
     */
    public void createTempDir() throws IOException {
        Files.createDirectory(TMP_PATH);
    }

    /**
     * パスにテキストを書き込む
     *
     * @param path パス
     * @param text テキスト
     * @throws IOException IO例外時
     */
    public void writeFile(Path path, String text) throws IOException {
        Files.write(path, text.getBytes(CHARSET), StandardOpenOption.CREATE);
    }

    /**
     * コピーを行う
     *
     * @param src コピー元パス
     * @param dist コピー先パス
     * @throws IOException IO例外時
     */
    public void copy(Path src, Path dist) throws IOException {
        Files.copy(src, dist, StandardCopyOption.COPY_ATTRIBUTES,
                StandardCopyOption.REPLACE_EXISTING);
    }

    /**
     * パスの内容を読み込む
     *
     * @param path パス
     * @return パスの内容のテキスト
     * @throws IOException IO例外時
     */
    public String readFile(Path path) throws IOException {
        return new String(Files.readAllBytes(path), CHARSET);
    }

    /**
     * メインクラス
     *
     * @param args 引数
     * @throws IOException IO例外時
     */
    public static void main(String[] args) throws IOException {
        JavaNioSample filesSample = new JavaNioSample();

        filesSample.deleteTempDir();

        filesSample.createTempDir();

        Path newFilePath = Paths.get(TMP_PATH.toString(), "NewFile.txt");
        filesSample.writeFile(newFilePath, "New File Text.");

        Path copiedFilePath = Paths.get(TMP_PATH.toString(), "CopiedFile.txt");
        filesSample.copy(newFilePath, copiedFilePath);

        String text = filesSample.readFile(copiedFilePath);
        System.out.println(text);
    }

}
