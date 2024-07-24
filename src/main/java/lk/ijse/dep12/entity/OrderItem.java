package lk.ijse.dep12.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_item")
@IdClass(OrderItem.class)
public class OrderItem implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "order_id",referencedColumnName = "id")
    private Order order;
    @Id
    @ManyToOne
    @JoinColumn(name = "item_code",referencedColumnName = "code")
    private Item item;
    private BigDecimal price;
    private int discount;
}
