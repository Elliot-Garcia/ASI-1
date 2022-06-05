package com.Transaction.controller;

import com.Transaction.controller.body.BuyBody;
import com.Transaction.controller.body.SellBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTransaction {
    private final ServiceTransaction serviceTransaction;

    RestTransaction(ServiceTransaction serviceTransaction) {
        this.serviceTransaction = serviceTransaction;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/buy")
    public boolean buy(@RequestBody BuyBody body) {
        return serviceTransaction.buy(body);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/sell")
    public boolean sell(@RequestBody SellBody body) {
        return serviceTransaction.sell(body);
    }
}
