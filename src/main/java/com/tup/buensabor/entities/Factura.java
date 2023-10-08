package com.tup.buensabor.entities;

import com.tup.buensabor.enums.EstadoFactura;
import com.tup.buensabor.enums.FormaPago;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "factura")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Factura extends Base {

    //NOTNULL
    @Enumerated(EnumType.STRING)
    @Column(name = "estado_factura", nullable = false)
    private EstadoFactura estadoFactura;

    //NOTNULL
    @Column(name = "fecha_facturacion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFacturacion;

    //NOTNULL
    @Enumerated(EnumType.STRING)
    @Column(name = "forma_pago")
    private FormaPago formaPago;

    @Column(name = "mp_merchant_order_id")
    private Long mpMerchantOrderId;

    @Column(name = "mp_payment_id")
    private Long mpPaymentId;

    @Column(name = "mp_payment_type")
    private String mpPaymentType;

    @Column(name = "mp_preference_id")
    private String mpPreferenceId;

    //NOTNULL
    @Column(name = "total_venta", precision = 10, scale = 2, nullable = false)
    private BigDecimal totalVenta;

    //NOTNULL
    @OneToOne
    @JoinColumn(name = "fk_pedido", nullable = false)
    private Pedido pedido;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_detalle_factura")
    private List<DetalleFactura> detallesFactura = new ArrayList<>();

    public void addDetalleFactura(DetalleFactura detalleFactura){
        this.detallesFactura.add(detalleFactura);
    }


}
