Sub ResetScrollAndZoom()
'
' A1�Z���Ɉړ��A�{��100%�ɐݒ肵�A�ŏ��̃V�[�g��I������}�N��
' ��\���V�[�g�͏��O����
' �i�l�p�}�N���u�b�N�ɒǉ����A�L�[�{�[�h�V���[�g�J�b�g��ݒ肵�Ă����ƕ֗��j
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
