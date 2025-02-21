@powershell -NoProfile -ExecutionPolicy RemoteSigned -Command "&([ScriptBlock]::Create((Get-Content '%~f0'|?{$_.ReadCount -gt 1}|Out-String)))" %* & goto :eof

$msg = "クリップボードにコピーしたいメッセージ"
$cnt = 0

while ($true)
{
    try
    {
        Set-Clipboard -Value $msg
        break
    }
    catch [System.Runtime.InteropServices.ExternalException]
    {
        $cnt++
        Clear-Host
        Write-Host "Retry: $cnt"
        Start-Sleep 1
    }
}

Read-Host 'Press Enter Key to continue...'
