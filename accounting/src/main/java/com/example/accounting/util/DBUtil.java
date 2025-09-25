package com.example.accounting.util;

import java.io.InputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;

public final class DBUtil {
    private static final String PROPS_FILE = "application.properties";
    private static final String URL;
    private static final String USER;
    private static final String PASS;

    static {
        try (InputStream in = getResourceAsStream()) {
            Properties props = new Properties();
            props.load(in);

            URL = requireProperty(props, "datasource.url");
            USER = requireProperty(props, "datasource.username");
            PASS = requireProperty(props, "datasource.password");

            Class.forName(requireProperty(props, "datasource.driver-class-name"));
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("DB設定の読み込みに失敗しました", e);
        }
    }

    private DBUtil() {
    }

    private static InputStream getResourceAsStream() {
        InputStream in = DBUtil.class.getClassLoader().getResourceAsStream(PROPS_FILE);
        return Objects.requireNonNull(in, () -> PROPS_FILE + "が見つかりません");
    }

    private static String requireProperty(Properties props, String key) {
        String value = props.getProperty(key);
        return Objects.requireNonNull(value,
                () -> PROPS_FILE + "の必須キー：" + key + "が未設定です");
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
