package com.ms.serviceb.model;

import javax.persistence.Entity;
import javax.persistence.Table;


public class ServicoB {

    private String msg;

    public String getMsg() {
        return msg;
    }

    public ServicoB setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    @Override
    public String toString() {
        return "ServicoB{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
