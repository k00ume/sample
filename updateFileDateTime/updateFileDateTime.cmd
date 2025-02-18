@powershell -NoProfile -ExecutionPolicy RemoteSigned -Command "&([ScriptBlock]::Create((Get-Content '%~f0'|?{$_.ReadCount -gt 1}|Out-String)))" %* & goto:eof

# ファイルの作成日時、更新日時、アクセス日時を一括変更

# 対象ファイルパス
${target_path} = '.\target.txt'

# 対象日時
${target_datetime} = '2020/02/29 12:34:56'

'CreationTime', 'LastWriteTime', 'LastAccessTime' | % {
    Set-ItemProperty -Path ${target_path} -Name $_ -Value ${target_datetime}
}

Read-Host 'Press Enter to continue...'
