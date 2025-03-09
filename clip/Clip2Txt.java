import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.nio.file.Files;
import java.nio.file.Path;

public class Clip2Txt {

    public static void main(String[] args) throws Exception {
        // クリップボードから文字列を取得
        var clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
            var data = (String) clipboard.getData(DataFlavor.stringFlavor);

            // 文字列をtxtファイルに保存
            Files.writeString(Path.of("clip.txt"), data);

        } else {
            System.err.println("クリップボードに文字列データが存在しません。");
        }
    }
}
