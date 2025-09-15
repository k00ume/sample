package com.example.accounting.action;

import com.example.accounting.dao.UserDao;
import com.opensymphony.xwork2.ActionSupport;

import lombok.Getter;
import lombok.Setter;

import org.apache.struts2.interceptor.SessionAware;
import java.util.Map;

@Getter
@Setter
public class LoginAction extends ActionSupport implements SessionAware {
    private String username;
    private String password;
    private Map<String, Object> session;

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
