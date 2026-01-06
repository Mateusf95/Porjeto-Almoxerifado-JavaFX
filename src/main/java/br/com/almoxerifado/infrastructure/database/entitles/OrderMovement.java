package br.com.almoxerifado.infrastructure.database.entitles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "ORDER_MOVEMENT")
@AllArgsConstructor
@Data
public class OrderMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TYPE", nullable = false)
    private String type;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "ORDER_", referencedColumnName = "ID", nullable = false)
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(name = "STOREKEEPER", referencedColumnName = "ID", nullable = false)
    private OrderEntity storeKeeper;
}
