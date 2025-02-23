@echo off
powershell -ExecutionPolicy RemoteSigned -Command "Add-Type -Path .\Codes.cs; [Codes]::Main()"
pause
