#!/bin/bash

# 指定時刻にコマンド実行する
# （txtファイルをzipアーカイブする例）

# 指定時刻
scheduled_time='2024-02-29 12:34:56'
basic_time=$(date -d "$scheduled_time" "+%Y%m%d_%H%M%S")

# ログファイル名（実行日時をファイル名に含む）
log_file="/tmp/nohup_${basic_time}.log"

# 指定時刻までsleepし、その後コマンド実行する
nohup sh -x << 'EOS' > "${log_file}" 2>&1 &
sleep $(( $(date -d "${scheduled_time}" "+%s") - $(date "+%s") ))
zip -r "/dest_dir/dest_file_${basic_time}.zip" "/src_dir/src_file.txt"
EOS
