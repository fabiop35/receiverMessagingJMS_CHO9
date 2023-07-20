package com.sia.jms.receiver.listener;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.sia.jms.receiver.entities.TacoOrder;
import com.sia.jms.receiver.ui.KitchenUI;

//@Profile("jms-listener")
@Component
public class OrderListener {
  
  private KitchenUI ui;

  @Autowired
  public OrderListener(KitchenUI ui) {
    this.ui = ui;
  }

  @JmsListener(destination = "queueTaco")
  public void receiveOrder(TacoOrder order) {
    ui.displayOrder(order);
  }
  
}
