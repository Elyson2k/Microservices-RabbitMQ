package com.ms.servicea.service;

import com.ms.servicea.model.ServicoA;
import com.ms.servicea.repository.ServicoARepository;
import com.netflix.discovery.converters.Auto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoAService {

    @Autowired
    private ServicoARepository repository;
    @Autowired
    RabbitTemplate rabbitTemplate;

    public ServicoA insertService(ServicoA servicoA){
        rabbitTemplate.convertAndSend("servico-a.ex","",servicoA);
        return repository.save(servicoA);
    }

}
