package com.example.accounting.action;

import com.example.accounting.dao.TransactionDao;
import com.example.accounting.model.Transaction;
import java.util.List;
import lombok.Getter;

@Getter
public class ListAction extends BaseAction {
    private List<Transaction> transactions;

    @Override
    public String execute() {
        transactions = TransactionDao.findAll();
        return SUCCESS;
    }
}
