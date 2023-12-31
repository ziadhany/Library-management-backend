package com.example.librarymanagementbackend.Entity;

import com.example.librarymanagementbackend.book.Book;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@Getter
@Setter
@Entity
public class Cart{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;
    private BigDecimal subTotal;
    @OneToOne
    private Book book;
    @Getter
    @OneToMany(mappedBy = "cartItem")
    @JsonIgnore
    private List<BookToCart> bookToCartItems;

    @ManyToOne
    @JsonIgnore
    private ShoppingCart shoppingCart;

    @ManyToOne
    @JsonIgnore
    private Order order;

}