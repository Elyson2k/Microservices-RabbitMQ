package com.ms.servicec.listener;

import com.ms.servicec.model.ServicoC;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class ServicoCListener {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = "servico-c")
    public void recebendoMsg(@Payload ServicoC servicoC){
        System.out.println("RECEBENDO MENSAGEM DO SERVICO-B");
        System.out.println("MENSAGEM: " + servicoC);
    }
}
