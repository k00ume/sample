package com.example.accounting.action;

import com.example.accounting.dao.TransactionDao;
import com.example.accounting.model.Transaction;
import com.opensymphony.xwork2.ActionSupport;

import lombok.Getter;

import java.util.List;

@Getter
public class ListAction extends ActionSupport {
    private List<Transaction> transactions;

    @Override
    public String execute() {
        transactions = TransactionDao.findAll();
        return SUCCESS;
    }
}
