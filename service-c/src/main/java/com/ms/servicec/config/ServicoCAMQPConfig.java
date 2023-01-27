package com.ms.servicec.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicoCAMQPConfig {

    public static final String FILA_SERVICO_C = "servico-c";
    public static final String EXCHANGE_DO_SERVICO_B = "servico-b.ex";

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory factory){
        return new RabbitAdmin(factory);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory factory, Jackson2JsonMessageConverter messageConverter){
        RabbitTemplate response = new RabbitTemplate(factory);
        response.setMessageConverter(messageConverter);
        return response;
    }

    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Queue filaServicoC(){
        return QueueBuilder
                .nonDurable(FILA_SERVICO_C)
                .build();
    }

    @Bean
    public FanoutExchange fanoutExchange(){
        return ExchangeBuilder
                .fanoutExchange(EXCHANGE_DO_SERVICO_B)
                .build();
    }

    @Bean
    public Binding binding(){
        return BindingBuilder
                .bind(filaServicoC())
                .to(fanoutExchange());

    }

}
