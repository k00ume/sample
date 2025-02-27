@echo off
powershell -ExecutionPolicy RemoteSigned -Command ^
 "Add-Type -Path %~dp0Hello.cs; [Hello]::Main()"
pause
