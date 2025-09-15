package com.example.accounting.dao;

import com.example.accounting.model.Transaction;
import com.example.accounting.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TransactionDao {
    public static void add(Transaction t) {
        String sql = "INSERT INTO transactions (id, date, category, amount, description) " +
                "VALUES (transactions_seq.NEXTVAL, ?, ?, ?, ?)";
        try (Connection con = DBUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDate(1, java.sql.Date.valueOf(t.getDate()));
            ps.setString(2, t.getCategory());
            ps.setBigDecimal(3, t.getAmount());
            ps.setString(4, t.getDescription());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Transaction> findAll() {
        List<Transaction> list = new ArrayList<>();
        String sql = "SELECT id, date, category, amount, description FROM transactions ORDER BY date DESC";
        try (Connection con = DBUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Transaction t = new Transaction();
                t.setId(rs.getLong("id"));
                t.setDate(rs.getDate("date").toLocalDate());
                t.setCategory(rs.getString("category"));
                t.setAmount(rs.getBigDecimal("amount"));
                t.setDescription(rs.getString("description"));
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
