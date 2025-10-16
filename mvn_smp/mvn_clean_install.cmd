@echo off
del /s target
del /s %userprofile%\.m2
call mvn clean install -f pom.xml
pause
