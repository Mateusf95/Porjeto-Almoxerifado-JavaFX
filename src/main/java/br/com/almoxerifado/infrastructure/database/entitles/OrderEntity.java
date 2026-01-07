package br.com.almoxerifado.infrastructure.database.entitles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "ORDERS")
@AllArgsConstructor
@Data
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "UPDATE_AT")
    private LocalDateTime updateAt;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @Column(name = "ORDER_STATUS", nullable = false)
    private String orderStatus;

    @ManyToOne
    @JoinColumn(name = "AUTHOR", referencedColumnName = "ID")
    private UserEntity author;
}
