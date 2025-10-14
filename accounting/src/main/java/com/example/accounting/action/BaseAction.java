package com.example.accounting.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

public abstract class BaseAction extends ActionSupport implements SessionAware {
    private static final long serialVersionUID = 1L;

    protected Map<String, Object> session;

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
