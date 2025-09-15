<%@ taglib prefix="s" uri="/struts-tags" %>
    <html>

    <body>
        <h2>ログイン</h2>
        <s:form action="login">
            <s:textfield name="username" label="ユーザ名" />
            <s:password name="password" label="パスワード" />
            <s:submit value="ログイン" />
        </s:form>
        <s:actionerror />
    </body>

    </html>