package com.example.storebackend.modelos;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "detalleorden")
public class DetalleOrden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre", length = 60, nullable = false)
    private String nombre;

    @Column(name = "papellido", length = 60, nullable = false)
    private String papellido;

    @Column(name = "sapellido", length = 60, nullable = false)
    private String sapellido;

    @Column(name="fecha", nullable = false, updatable = false)
    private String fecha;

    @Column(name="total", nullable = false)
    private Double total;

    @Column(name="estado", length = 20, nullable = false)
    private String estado;

    @OneToMany( cascade = CascadeType.ALL, mappedBy = "detalleorden", fetch = FetchType.LAZY)
    private List<Orden> items;

}
