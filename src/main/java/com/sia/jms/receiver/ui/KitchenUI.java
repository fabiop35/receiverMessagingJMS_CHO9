package com.sia.jms.receiver.ui;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

import com.sia.jms.receiver.entities.TacoOrder;

@Component
@Slf4j
public class KitchenUI {

    public void displayOrder(TacoOrder order) {
        // TODO: Beef this up to do more than just log the received taco.
        //       To display it in some sort of UI.
        log.info("》》》RECEIVED ORDER UI:  " + order);
        log.info("Order sent to the UI");
    }

}
