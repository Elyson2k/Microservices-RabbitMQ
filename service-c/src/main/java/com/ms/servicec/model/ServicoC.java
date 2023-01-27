package com.ms.servicec.model;

public class ServicoC {
    private String msg;

    public ServicoC(String msg) {
        this.msg = msg;
    }

    public ServicoC() {
    }

    public String getMsg() {
        return msg;
    }

    public ServicoC setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    @Override
    public String toString() {
        return "ServicoC{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
