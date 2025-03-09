import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.image.BufferedImage;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.imageio.ImageIO;

public class Clip2Png {

    public static void main(String[] args) throws Exception {
        // クリップボードから画像を取得
        var clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        if (clipboard.isDataFlavorAvailable(DataFlavor.imageFlavor)) {
            var data = (BufferedImage) clipboard.getData(DataFlavor.imageFlavor);

            // 画像をpngファイルに保存
            try (var out = Files.newOutputStream(Path.of("clip.png"))) {
                ImageIO.write(data, "png", out);
            }

        } else {
            System.err.println("クリップボードに画像データが存在しません。");
        }
    }
}
