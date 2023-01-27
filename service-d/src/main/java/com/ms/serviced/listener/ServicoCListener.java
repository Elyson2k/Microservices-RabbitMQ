package com.ms.serviced.listener;

import com.ms.serviced.model.ServicoD;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class ServicoCListener {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = "servico-d")
    public void recebendoMsg(@Payload ServicoD servicoB){
        System.out.println("RECEBENDO MENSAGEM DO SERVICO-B");
        System.out.println("MENSAGEM: " + servicoB);
    }
}
