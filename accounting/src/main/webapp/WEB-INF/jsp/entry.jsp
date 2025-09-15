<%@ taglib prefix="s" uri="/struts-tags" %>
    <html>

    <body>
        <h2>経理データ登録</h2>
        <s:form action="entry">
            <s:textfield name="date" label="日付 (YYYY-MM-DD)" />
            <s:textfield name="category" label="科目" />
            <s:textfield name="amount" label="金額" />
            <s:textfield name="description" label="摘要" />
            <s:submit value="登録" />
        </s:form>
        <s:fielderror />
    </body>

    </html>