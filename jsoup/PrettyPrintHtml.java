import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import org.jsoup.Jsoup;

/**
 * java -cp jsoup-x.x.x.jar PrettyPrintHtml.java sample.html
 */
public class PrettyPrintHtml {

    public static void main(String[] args) throws Exception {
        if (0 < args.length) {
            // HTMLを読込み、改行を一旦除去しておく
            var html = Files.readString(Path.of(args[0])).replaceAll("\\r?\\n", "");

            // HTML解析
            var doc = Jsoup.parse(html);

            // HTMLを出力
            Files.writeString(
                    Path.of("pretty-print.html"),
                    doc.outerHtml(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);

        } else {
            System.err.println("HTMLファイルが指定されていません。");
        }
    }
}
