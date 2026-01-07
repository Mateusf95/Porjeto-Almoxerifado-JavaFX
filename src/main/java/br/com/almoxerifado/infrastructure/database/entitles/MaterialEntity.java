package br.com.almoxerifado.infrastructure.database.entitles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "MATERIAL")
@AllArgsConstructor
@Data
public class MaterialEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "UPDATE_AT")
    private LocalDateTime updateAt;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "CATEGORY", referencedColumnName = "ID")
    private CategoryEntity category;

    @Column(name = "AMOUNT", nullable = false)
    private Integer amount;

    @Column(name = "MINIMUM_STOCK", nullable = false)
    private Integer minimumStock;

    @Column(name = "AVAILABLE", nullable = false)
    private Integer available;

}
