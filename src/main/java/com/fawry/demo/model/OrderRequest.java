package com.fawry.demo.model;

import com.fawry.demo.repository.entity.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest implements Serializable {

    private static final long serialVersionUID = 5393403638138288027L;

    private List<OrderItem> orderItems;
    private double totalPrice;
}