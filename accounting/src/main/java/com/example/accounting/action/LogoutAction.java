package com.example.accounting.action;

public class LogoutAction extends BaseAction {
    private static final long serialVersionUID = 1L;

    @Override
    public String execute() {
        session.clear();
        return SUCCESS;
    }
}
