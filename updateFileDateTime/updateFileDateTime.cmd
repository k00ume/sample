@powershell -NoProfile -ExecutionPolicy RemoteSigned -Command "&([ScriptBlock]::Create((Get-Content '%~f0'|?{$_.ReadCount -gt 1}|Out-String)))" %* & goto:eof

# �t�@�C���̍쐬�����A�X�V�����A�A�N�Z�X�������ꊇ�ύX

# �Ώۃt�@�C���p�X
${target_path} = '.\target.txt'

# �Ώۓ���
${target_datetime} = '2020/02/29 12:34:56'

'CreationTime', 'LastWriteTime', 'LastAccessTime' | % {
    Set-ItemProperty -Path ${target_path} -Name $_ -Value ${target_datetime}
}

Read-Host 'Press Enter to continue...'
