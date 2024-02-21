package org.example.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.bookstore.entity.Client;
import org.example.bookstore.entity.Items;
import org.example.bookstore.entity.Request;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseRequest { // to send Request
    private Client client;
    private Request request;
    private List<Items> items;
}
