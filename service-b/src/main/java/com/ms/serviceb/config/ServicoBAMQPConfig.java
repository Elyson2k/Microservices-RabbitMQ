package com.ms.serviceb.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicoBAMQPConfig {

    @Bean
    public Queue filaServicoB(){
        return QueueBuilder
                .nonDurable("servico-b")
                .build();
    }

    @Bean
    public FanoutExchange fanoutExchange(){
        return ExchangeBuilder
                .fanoutExchange("servico-a.ex")
                .build();
    }

    @Bean
    public Binding binding(){
        return BindingBuilder.bind(filaServicoB()).to(fanoutExchange());
    }

    @Bean
    public FanoutExchange fanoutExchangeSecond(){
        return new FanoutExchange("servico-b.ex");
    }

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory factory){
        return new RabbitAdmin(factory);
    }

    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory factory, Jackson2JsonMessageConverter jsonMessageConverter){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(factory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter);
        return rabbitTemplate;
    }
}
