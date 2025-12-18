package com.example.ecomerce.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String numero;
    private LocalDate fCreacion;
    private LocalDate fRecibida;
    private BigDecimal total;

    public Pedido() {
    }

    public Pedido(String numero, LocalDate fCreacion, LocalDate fRecibida, BigDecimal total) {
        this.numero = numero;
        this.fCreacion = fCreacion;
        this.fRecibida = fRecibida;
        this.total = total;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDate getfCreacion() {
        return fCreacion;
    }

    public void setfCreacion(LocalDate fCreacion) {
        this.fCreacion = fCreacion;
    }

    public LocalDate getfRecibida() {
        return fRecibida;
    }

    public void setfRecibida(LocalDate fRecibida) {
        this.fRecibida = fRecibida;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
