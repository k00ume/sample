package com.example.accounting.action;

import com.example.accounting.dao.TransactionDao;
import lombok.Setter;

@Setter
public class DeleteAction extends BaseAction {
    private static final long serialVersionUID = 1L;

    private Long id;

    @Override
    public String execute() {
        TransactionDao.delete(id);
        return SUCCESS;
    }

    @Override
    public void validate() {
        if (id == null || id <= 0L) {
            addActionError("不正なリクエストです");
        }
    }
}
