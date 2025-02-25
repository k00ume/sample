@echo off
chcp 65001

set NAME=イーサネット

openfiles /query > nul
if %errorlevel% neq 0 (
  echo 管理者権限で実行してください...
  goto :end
)

netsh interface ipv4 show dnsservers "%NAME%"

choice /C:de /M:"AdGuard DNSを無効にするには「D」、有効にするには「E」を入力してください"

if %ERRORLEVEL% equ 1 (
  netsh interface ipv4 set address    "%NAME%" dhcp
  netsh interface ipv4 set dnsservers "%NAME%" dhcp
  netsh interface ipv6 set dnsservers "%NAME%" dhcp
  echo AdGuard DNSを無効化しました（広告が表示されます）
) else if %ERRORLEVEL% equ 2 (
  netsh interface ipv4 set address    "%NAME%" dhcp
  netsh interface ipv4 set dnsservers "%NAME%" static 94.140.14.14      primary validate=no
  netsh interface ipv4 add dnsservers "%NAME%"        94.140.15.15              validate=no
  netsh interface ipv6 set dnsservers "%NAME%" static 2a10:50c0::ad1:ff primary validate=no
  netsh interface ipv6 add dnsservers "%NAME%"        2a10:50c0::ad2:ff         validate=no
  echo AdGuard DNSを有効化しました（広告が消えます）
)

netsh interface ipv4 show dnsservers "%NAME%"

ipconfig /flushdns

:end
pause
