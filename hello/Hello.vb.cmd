@echo off
powershell -ExecutionPolicy RemoteSigned -Command ^
 "Add-Type -Path %~dp0Hello.vb; [Hello]::Main()"
pause
