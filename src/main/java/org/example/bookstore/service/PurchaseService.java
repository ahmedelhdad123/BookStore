package org.example.bookstore.service;

import org.example.bookstore.dto.PurchaseRequest;
import org.example.bookstore.dto.PurchaseResponse;

public interface PurchaseService {
    PurchaseResponse addRequest(PurchaseRequest purchaseRequest);
}
