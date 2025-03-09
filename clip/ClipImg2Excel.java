import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import javax.imageio.ImageIO;

import org.apache.poi.ss.usermodel.ClientAnchor.AnchorType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ClipImg2Excel {

    // テンプレートファイル
    private static final Path TEMPLATE_PATH = Path.of("template.xlsx");

    // 出力ファイル
    private static final Path OUTPUT_PATH = Path.of("ScreenShot.xlsx");

    // シート
    private static final String SHEET_NAME = "ScreenShot";

    // クリップボードの画像をバイト配列に保存
    private static byte[] clip2Bytes(Clipboard clipboard) throws Exception {
        // クリップボードから画像を取得
        var data = (BufferedImage) clipboard.getData(DataFlavor.imageFlavor);

        // 画像をバイト配列に保存
        var baos = new ByteArrayOutputStream();
        ImageIO.write(data, "png", baos);
        return baos.toByteArray();
    }

    // 出力ファイルを作成
    private static void prepareExcel() throws Exception {
        // テンプレートファイルがなければ新規作成
        if (!Files.exists(TEMPLATE_PATH)) {

            // ワークブックとファイルを作成
            try (var workbook = new XSSFWorkbook();
                    var os = Files.newOutputStream(TEMPLATE_PATH)) {

                // シートを作成
                var sheet = workbook.createSheet(SHEET_NAME);

                // ワークブックをファイルに保存
                workbook.write(os);
            }
        }

        // テンプレートファイルをコピーして出力ファイルを作成
        Files.copy(TEMPLATE_PATH, OUTPUT_PATH,
                StandardCopyOption.REPLACE_EXISTING,
                StandardCopyOption.COPY_ATTRIBUTES);
    }

    // Excelファイルを読込み、画像を貼付
    private static void writeImage2Excel(byte[] bytes) throws Exception {
        // ワークブックを取得
        try (var is = Files.newInputStream(OUTPUT_PATH);
                var xssfWorkbook = (XSSFWorkbook) WorkbookFactory.create(is);
                var workbook = new SXSSFWorkbook(xssfWorkbook);
                var os = Files.newOutputStream(OUTPUT_PATH)) {

            // シートを取得
            var sheet = workbook.getSheet(SHEET_NAME);
            var drawing = sheet.createDrawingPatriarch();

            // 画像をワークブックに追加
            var index = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
            var anchor = workbook.getCreationHelper().createClientAnchor();
            anchor.setRow1(1); // 2行
            anchor.setCol1(1); // B列
            anchor.setAnchorType(AnchorType.DONT_MOVE_AND_RESIZE);

            // シートに画像を挿入
            var picture = drawing.createPicture(anchor, index);
            picture.resize();

            // ワークブックをファイルに保存
            workbook.write(os);
        }
    }

    public static void main(String[] args) throws Exception {
        // クリップボードから画像を取得
        var clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        if (clipboard.isDataFlavorAvailable(DataFlavor.imageFlavor)) {
            // クリップボードの画像をバイト配列に保存
            var bytes = clip2Bytes(clipboard);

            // 出力ファイルを作成
            prepareExcel();

            // 出力ファイルに画像を貼付
            writeImage2Excel(bytes);

        } else {
            System.err.println("クリップボードに画像データが存在しません。");
        }
    }
}
