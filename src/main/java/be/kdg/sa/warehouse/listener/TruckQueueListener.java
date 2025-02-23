package be.kdg.sa.warehouse.listener;

import be.kdg.sa.warehouse.controller.dto.MessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TruckQueueListener {

    private static final Logger logger = LoggerFactory.getLogger(TruckQueueListener.class);

    @RabbitListener(queues = "truckQueue")
    public void receiveMessage(String message) {
        logger.info("Received message: {}", message);
    }

    @RabbitListener(queues = "truckQueue")
    public void receiveJsonMessage(MessageDto message) {
        logger.info("Received Json message: {}", message);
    }
}

