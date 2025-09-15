<%@ taglib prefix="s" uri="/struts-tags" %>
    <html>

    <body>
        <h2>経理データ一覧</h2>
        <table border="1">
            <tr>
                <th>日付</th>
                <th>科目</th>
                <th>金額</th>
                <th>摘要</th>
            </tr>
            <s:iterator value="transactions">
                <tr>
                    <td>
                        <s:property value="date" />
                    </td>
                    <td>
                        <s:property value="category" />
                    </td>
                    <td>
                        <s:property value="amount" />
                    </td>
                    <td>
                        <s:property value="description" />
                    </td>
                </tr>
            </s:iterator>
        </table>
        <a href="entry">新規登録</a>
    </body>

    </html>