<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="s" uri="/struts-tags" %>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>会計データ登録</title>
            <link rel="stylesheet" href="css/common.css">
        </head>

        <body>
            <h2>会計データ登録</h2>
            <s:form action="doEntry">
                <s:textfield name="date" label="日付 (YYYY-MM-DD)" />
                <s:textfield name="category" label="科目" />
                <s:textfield name="amount" label="金額" />
                <s:textfield name="description" label="摘要" />
                <s:submit value="登録" />
            </s:form>
            <s:fielderror />
            <p>
                <a href="logout">ログアウト</a>
            </p>
        </body>

        </html>