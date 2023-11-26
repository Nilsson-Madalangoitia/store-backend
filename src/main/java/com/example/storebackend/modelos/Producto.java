package com.example.storebackend.modelos;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "categoria", length = 60, nullable = false)
    private String categoria;

    @Column(name = "nombre", length = 60, nullable = false)
    private String nombre;

    @Column(name = "price", nullable = false)
    private Double price;

}