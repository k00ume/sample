<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="s" uri="/struts-tags" %>
        <html>

        <body>
            <h2>会計データ一覧</h2>
            <table border="1">
                <tr>
                    <th class="operation-header">
                        <span>操作</span>
                    </th>
                    <th>日付</th>
                    <th>科目</th>
                    <th>金額</th>
                    <th>摘要</th>
                </tr>
                <s:iterator value="transactions">
                    <tr>
                        <td>
                            <s:form action="delete" method="post" theme="simple" cssClass="delete-form">
                                <s:hidden name="id" value="%{id}" />
                                <s:submit value="🚮" title="削除" />
                            </s:form>
                        </td>
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
            <p>
                <a href="entry">新規登録</a>
            </p>
            <p>
                <a href="logout">ログアウト</a>
            </p>
        </body>

        </html>