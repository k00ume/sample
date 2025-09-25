package com.example.accounting.dao;

import com.example.accounting.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {

    private static final String SQL = "SELECT 1 FROM users WHERE username = ? AND password = ?";

    public static boolean authenticate(String username, String password) {
        try (Connection con = DBUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(SQL)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
