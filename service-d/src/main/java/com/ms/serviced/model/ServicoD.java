package com.ms.serviced.model;

public class ServicoD {
    private String msg;

    public ServicoD(String msg) {
        this.msg = msg;
    }

    public ServicoD() {
    }

    public String getMsg() {
        return msg;
    }

    public ServicoD setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    @Override
    public String toString() {
        return "ServicoD{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
