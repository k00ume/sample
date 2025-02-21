Sub ResetScrollAndZoom()
'
' A1セルに移動、倍率100%に設定し、最初のシートを選択するマクロ
' 非表示シートは除外する
' （個人用マクロブックに追加し、キーボードショートカットを設定しておくと便利）
'
    Dim ws As Worksheet
    For Each ws In ActiveWorkbook.Worksheets
        If ws.Visible = xlSheetVisible Then
            ws.Select
            Range("A1").Select
            ActiveWindow.ScrollColumn = 1
            ActiveWindow.ScrollRow = 1
            ActiveWindow.Zoom = 100
        End If
    Next ws

    For Each ws In ActiveWorkbook.Worksheets
        If ws.Visible = xlSheetVisible Then
            ws.Select
            Exit For
        End If
    Next ws
End Sub
