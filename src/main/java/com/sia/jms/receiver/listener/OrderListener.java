package com.sia.jms.receiver.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

import lombok.extern.slf4j.Slf4j;

import com.sia.entities.TacoOrder;
import com.sia.jms.receiver.ui.KitchenUI;

//@Profile("jms-listener")
@Slf4j
@Component
public class OrderListener {

    private KitchenUI ui;

    @Autowired
    public OrderListener(KitchenUI ui) {
        this.ui = ui;
    }

    //@JmsListener(destination = "queueTaco")
    public void receiveOrder(TacoOrder order) {
        ui.displayOrder(order);
    }

    @KafkaListener(topics = "tacocloud.orders.topic")
    public void handle(
            TacoOrder order, ConsumerRecord<String, TacoOrder> record) {
        log.info("Kafka::: Received from partition {} with timestamp {}",
                record.partition(), record.timestamp());

        ui.displayOrder(order);
    }

}
