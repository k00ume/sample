<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="s" uri="/struts-tags" %>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>ログイン</title>
            <link rel="stylesheet" href="css/common.css">
        </head>

        <body>
            <h2>ログイン</h2>
            <s:form action="doLogin">
                <s:textfield name="username" label="ユーザ名" />
                <s:password name="password" label="パスワード" />
                <s:submit value="ログイン" />
            </s:form>
            <s:actionerror />
        </body>

        </html>