package com.grupo4.pagoservice.dto;

import java.time.LocalDateTime;

public class PagoDTO {

    private Long idPago;
    private Long idPedido;
    private String metodoPago;
    private Double montoPagado;
    private LocalDateTime fechaPago;
    private String codigoAutorizacion;
    private String estadoPago;

}
