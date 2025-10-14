package com.example.accounting.action;

import com.example.accounting.dao.UserDao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginAction extends BaseAction {
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;

    @Override
    public String execute() {
        if (UserDao.authenticate(username, password)) {
            session.put("user", username);
            return SUCCESS;
        } else {
            addActionError("ユーザ名またはパスワードが違います");
            return INPUT;
        }
    }
}
