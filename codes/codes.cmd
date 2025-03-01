@echo off
powershell -ExecutionPolicy RemoteSigned -Command ^
 "Add-Type -Path %~dp0Codes.cs; [Codes]::Main()"
pause
