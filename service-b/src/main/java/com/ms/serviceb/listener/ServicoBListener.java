package com.ms.serviceb.listener;

import com.ms.serviceb.model.ServicoB;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class ServicoBListener {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = "servico-b")
    public void recebendoMsg(@Payload ServicoB servicoB){
        ServicoB resposne = servicoB;
        System.out.println("RECEBENDO MENSAGEM DO SERVICO-A");
        System.out.println("MENSAGEM: " + servicoB);
        System.out.println("ENVIANDO PARA OS SERVICOS C E D");
        rabbitTemplate.convertAndSend("servico-b.ex","",resposne.getMsg());
    }
}
