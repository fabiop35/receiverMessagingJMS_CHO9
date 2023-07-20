package com.sia.jms.receiver;

import com.sia.jms.receiver.entities.TacoOrder;
import javax.jms.JMSException;

public interface OrderReceiver {

    TacoOrder receiveOrder() throws JMSException;

}
