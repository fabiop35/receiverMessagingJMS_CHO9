package com.sia.jms.receiver.web;

import javax.jms.JMSException;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

import com.sia.jms.receiver.OrderReceiver;
import com.sia.entities.TacoOrder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Profile({"jms-template"})
@Controller
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderReceiverController {

    private final OrderReceiver orderReceiver;

    @GetMapping("/receive")
    public String receiveOrder(Model model) throws JMSException {
        log.info("》Controller.Getting Order to prepare!");
        TacoOrder order = orderReceiver.receiveOrder();
        if (order != null) {
            model.addAttribute("order", order);
            return "receiveOrder";
        }
        log.info("Controller. No orders to prepare!");
        return "noOrder";
    }

}
