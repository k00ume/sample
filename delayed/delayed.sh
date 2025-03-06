#!/bin/bash

# ファイル名の最後に日付を付加して退避していた入力ファイルを順次入力フォルダに戻し、
# 退避ファイルに付加していた日付をファイルの更新日時に設定して過去日の処理を行う。

# スクリプトのフォルダに移動
dir="${0%/*}"
cd "${dir}"

# 入力フォルダ
in_dir="./in"

# 退避フォルダ
backup_dir="./bk"

# app.log退避ファイルパターン
regexp="app_([0-9]{4})([0-9]{2})([0-9]{2})\.log"

# 入力フォルダ、退避フォルダがない場合は終了
if [ ! -d "$in_dir" ] || [ ! -d "$backup_dir" ]; then
    echo "入力フォルダまたは退避フォルダが存在しません。"
    exit 1
fi

for f in $(find "$backup_dir" -maxdepth 1 -type f -name "*.log")
do
    if [[ "$f" =~ $regexp ]]; then
        # 入力ファイル
        in_file="$in_dir/app.log"

        # 入力フォルダにファイル名を変更して配置
        cp -p "$f" "$in_file"

        # 退避ファイル名に付いていた日付をファイルの更新日時とする。
        upd_date="${BASH_REMATCH[1]}-${BASH_REMATCH[2]}-${BASH_REMATCH[3]} 12:34:56"
        touch -d "$upd_date" "$in_file"

        # 何らかの処理を実行
        # （入力ファイルが固定値のJavaプログラム）
        java Process.java

        # エラーが発生した場合は終了
        if [ $? -ne 0 ]; then
            exit 1
        fi
    fi
done
