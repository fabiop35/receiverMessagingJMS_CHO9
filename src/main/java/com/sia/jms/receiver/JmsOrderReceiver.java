package com.sia.jms.receiver;

import org.springframework.jms.support.converter.MessageConverter;
import com.sia.jms.receiver.entities.TacoOrder;
import javax.jms.JMSException;
import javax.jms.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

//@Profile("jms-template")
@Slf4j
@Component
public class JmsOrderReceiver implements OrderReceiver {

    private JmsTemplate jms;
    private MessageConverter converter;

    @Autowired
    public JmsOrderReceiver(JmsTemplate jms, MessageConverter converter) {
        this.jms = jms;
        this.converter = converter;
    }

    /* @Override
    public TacoOrder receiveOrder() throws JMSException {
        Message message = jms.receive("queueTaco");
        System.out.println("msg: " + message.getJMSMessageID());
        return (TacoOrder) converter.fromMessage(message);
    }*/
    //Get the message on JSON format
    @Override
    public TacoOrder receiveOrder() {
        log.info("》》》msg.reiceveOrder() 《《《");
        return (TacoOrder) jms.receiveAndConvert("queueTaco");
    }

}
