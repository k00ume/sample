using System.Linq;
using System.IO;
using System.Text;
using System.Text.RegularExpressions;

public class Codes
{
    /*
     * HTMLの<td>タグ内の16桁英数字のコード値を抽出してtxtファイルに出力
     */
    public static void Main()
    {
        var path = ".";
        var pattern = "*.html";
        var reg = new Regex(@"<td>([\dA-Za-z]{16})</td>");

        var codes = from html in Directory.EnumerateFiles(path, pattern)
                    from line in File.ReadLines(html)
                    let match = reg.Match(line)
                    where match.Success
                    select match.Groups[1].Value;
        File.WriteAllLines("codes.txt", codes);
    }
}
