package com.example.accounting.dao;

import com.example.accounting.model.Transaction;
import com.example.accounting.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TransactionDao {

    private static final String ADD_SQL = "INSERT INTO transactions " +
            "(id, date, category, amount, description) VALUES (transactions_seq.NEXTVAL, ?, ?, ?, ?)";
    private static final String DEL_SQL = "DELETE FROM transactions WHERE id = ?";
    private static final String ALL_SQL = "SELECT id, date, category, amount, description " +
            "FROM transactions ORDER BY date DESC";

    public static int add(Transaction t) {
        try (Connection con = DBUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(ADD_SQL)) {
            ps.setDate(1, java.sql.Date.valueOf(t.getDate()));
            ps.setString(2, t.getCategory());
            ps.setBigDecimal(3, t.getAmount());
            ps.setString(4, t.getDescription());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int delete(Long id) {
        try (Connection con = DBUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(DEL_SQL)) {
            ps.setLong(1, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static List<Transaction> findAll() {
        List<Transaction> list = new ArrayList<>();
        try (Connection con = DBUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(ALL_SQL);
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
