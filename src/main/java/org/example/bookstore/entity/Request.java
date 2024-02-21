package org.example.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "code")
    private String code;

    @Column(name = "total_price")
    private int totalPrice;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "date_create")
    @CreationTimestamp
    private Date dateCreate;

    @Column(name = "date_update")
    @UpdateTimestamp
    private Date dateUpdate;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "request")
    private List<Items> items=new ArrayList<>();

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client=new Client();

    public void addItem(Items item)
    {
        items.add(item);
        item.setRequest(this);
    }
}
