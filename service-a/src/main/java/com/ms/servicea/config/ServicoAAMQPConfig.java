package com.ms.servicea.config;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicoAAMQPConfig {

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory){
        return new RabbitAdmin(connectionFactory);
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

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("servico-a.ex");
    }
}
