package org.example.bookstore.controller;

import org.example.bookstore.dto.PurchaseRequest;
import org.example.bookstore.dto.PurchaseResponse;
import org.example.bookstore.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/buy/")
public class PurchaseController {

    private PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping("Order")
    private PurchaseResponse addRequestOrder(@RequestBody PurchaseRequest purchaseRequest)
    {
        return purchaseService.addRequest(purchaseRequest);
    }
}
