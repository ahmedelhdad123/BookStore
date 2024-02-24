package org.example.bookstore.service;

import org.example.bookstore.dao.ClientRepo;
import org.example.bookstore.dto.PurchaseRequest;
import org.example.bookstore.dto.PurchaseResponse;
import org.example.bookstore.entity.Client;
import org.example.bookstore.entity.Items;
import org.example.bookstore.entity.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class PurchaseServiceImpl implements PurchaseService{


    private ClientRepo clientRepo;

    @Autowired
    public PurchaseServiceImpl(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }


    @Transactional
    @Override
    public PurchaseResponse addRequest(PurchaseRequest purchaseRequest) {
        Request request=purchaseRequest.getRequest();
        String code=getCode();
        request.setCode(code);

        List<Items> itemsList=purchaseRequest.getItems();
        itemsList.forEach(request::addItem);

        purchaseRequest.getClient().addRequest(request);

        Client client = purchaseRequest.getClient();
        client.addRequest(request);

        clientRepo.save(purchaseRequest.getClient());

        return new PurchaseResponse(client.getFullName(),code);
    }

    private String getCode() {
        return UUID.randomUUID().toString();
    }
}
