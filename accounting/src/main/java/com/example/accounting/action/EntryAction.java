package com.example.accounting.action;

import com.example.accounting.dao.TransactionDao;
import com.example.accounting.model.Transaction;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntryAction extends BaseAction {
    private static final long serialVersionUID = 1L;

    private String date;
    private String category;
    private BigDecimal amount;
    private String description;

    @Override
    public String execute() {
        Transaction t = new Transaction();
        t.setDate(LocalDate.parse(date));
        t.setCategory(category);
        t.setAmount(amount);
        t.setDescription(description);
        TransactionDao.add(t);
        return SUCCESS;
    }

    @Override
    public void validate() {
        if (date == null || date.trim().isEmpty()) {
            addFieldError("date", "日付は必須です");
        }
        if (amount == null || amount.signum() <= 0) {
            addFieldError("amount", "金額は正の数で入力してください");
        }
    }
}
