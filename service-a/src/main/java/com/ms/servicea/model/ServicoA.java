package com.ms.servicea.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_msA")
public class ServicoA {

    @Id
    @GeneratedValue
    private Long id;
    private String msg;

    public ServicoA() {
    }

    public ServicoA(Long id, String msg) {
        this.id = id;
        this.msg = msg;
    }

    public Long getId() {
        return id;
    }

    public ServicoA setId(Long id) {
        this.id = id;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ServicoA setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}
