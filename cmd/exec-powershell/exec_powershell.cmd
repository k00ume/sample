@echo off
rem PowerShellスクリプト実行用バッチ
rem ps1ファイルをcmdファイルにD&Dして実行

if "%~x1"==".ps1" (
    echo %~nx1を実行します
    powershell -NoProfile -ExecutionPolicy RemoteSigned %1
) else (
    echo 引数にps1ファイルが指定されていません
    echo 引数：%1
)

pause
