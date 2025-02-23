package be.kdg.sa.warehouse.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQTopology {


    public static final String TOPIC_EXCHANGE = "land-to-warehouse-exchange";
    public static final String TRUCK_QUEUE = "truckQueue";
    public static final String TRUCK_ROUTING_KEY = "late";


    @Bean
    public Queue truckQueue(){
        return new Queue(TRUCK_QUEUE,true, false, false);
    }


    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(TOPIC_EXCHANGE);
    }


    @Bean
    public Binding truckBinding(Queue truckQueue, TopicExchange topicExchange){
        return BindingBuilder.bind(truckQueue).to(topicExchange).with(TRUCK_ROUTING_KEY);
    }

}
