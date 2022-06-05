package com.Transaction.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class RestTransaction {
    private final ServiceTransaction serviceTransaction;

    RestTransaction(ServiceTransaction serviceTransaction) {
        this.serviceTransaction = serviceTransaction;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/buy/{userId}/{templateId}")
    public boolean buy(@PathVariable String userId, @PathVariable String templateId) {
        return serviceTransaction.buy(userId, templateId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/sell/{userId}/{templateId}")
    public boolean sell(@PathVariable String userId, @PathVariable String templateId) {
        return serviceTransaction.sell(userId, templateId);
    }
}
