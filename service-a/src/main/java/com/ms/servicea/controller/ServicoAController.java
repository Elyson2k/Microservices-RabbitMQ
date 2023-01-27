package com.ms.servicea.controller;

import com.ms.servicea.model.ServicoA;
import com.ms.servicea.service.ServicoAService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/v1/servico")
public class ServicoAController {

    @Autowired
    private ServicoAService service;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping
    public ResponseEntity<ServicoA> insert(@RequestBody ServicoA servicoA){
        var id = service.insertService(servicoA).getId();
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(id).toUri();
        rabbitTemplate.convertAndSend("servico-a.ex","",servicoA);
        return ResponseEntity.created(uri).build();
    }
}
