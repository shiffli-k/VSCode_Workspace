package com.poc.rba.eng.rbaenginepoc.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DatabaseService {

    private final String url = "jdbc:mysql://localhost:3306/RBA_DB_POC";
    private final String user = "root";
    private final String password = "admin";

    public List<TranRecord> getAllTransactionsForCard(String cardNum) {

        List<TranRecord> list = new ArrayList<>();

        String query = "SELECT * FROM TRANSACTION_HIST WHERE card_number = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement ps = conn.prepareStatement(query);) {
            ps.setString(1, cardNum);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TranRecord txn = new TranRecord();

                txn.setId(rs.getLong("id"));
                txn.setCardNumber(rs.getString("card_number"));
                txn.setPurchaseAmount(rs.getBigDecimal("purchase_amount"));
                txn.setMerchantName(rs.getString("merchant_name"));
                txn.setPurchaseCurrency(rs.getString("purchase_currency"));
                txn.setIpAddress(rs.getString("ip_address"));
                txn.setBrowserAgent(rs.getString("browser_agent"));
                txn.setTransactionDatetime(rs.getTimestamp("transaction_datetime").toLocalDateTime());
                txn.setStatus(rs.getString("status"));

                list.add(txn);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

}
