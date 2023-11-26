package com.example.storebackend.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "orden")
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="price", nullable = false)
    private Double price;

    @Column(name="quantity", nullable = false)
    private Double quantity;

    @Column(name="total", nullable = false)
    private Double total;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "detalleorden_id", nullable = false, foreignKey = @ForeignKey(name = "FK_detalle_orden"))
    private DetalleOrden detalleorden;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false, foreignKey = @ForeignKey(name = "FK_producto_orden"))
    private Producto producto;

}