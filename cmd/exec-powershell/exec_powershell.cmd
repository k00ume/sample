@echo off
rem PowerShell�X�N���v�g���s�p�o�b�`
rem ps1�t�@�C����cmd�t�@�C����D&D���Ď��s

if "%~x1"==".ps1" (
    echo %~nx1�����s���܂�
    powershell -NoProfile -ExecutionPolicy RemoteSigned %1
) else (
    echo ������ps1�t�@�C�����w�肳��Ă��܂���
    echo �����F%1
)

pause
