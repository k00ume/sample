import java.nio.file.Files;
import java.nio.file.Path;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 固定ファイルの更新日時を使用した処理を行う例
 * 処理したファイルは削除する。
 */
public class Process {

    // 入力ファイルが固定
    private static final String IN_FILE = "./in/app.log";

    public static void main(String[] args) throws Exception {
        System.out.println("----- ----- ----- Process START ----- ----- -----");

        // ファイルの更新日時を取得
        var fileTime = Files.getLastModifiedTime(Path.of(IN_FILE));

        // java.util.Dateに変換
        System.out.println("(java.util.Date)\t:\t" + new Date(fileTime.toMillis()));

        // 適当な形式の文字列に変換
        var ymdhms = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")
                .withZone(ZoneId.systemDefault())
                .format(fileTime.toInstant());
        System.out.println("(yyyy/MM/dd HH:mm:ss)\t:\t" + ymdhms);

        // 入力ファイルを削除
        Files.delete(Path.of(IN_FILE));

        System.out.println("----- ----- ----- Process END   ----- ----- -----");
    }
}
