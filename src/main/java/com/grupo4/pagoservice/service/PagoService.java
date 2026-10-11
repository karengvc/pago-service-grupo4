package com.grupo4.pagoservice.service;
import com.grupo4.pagoservice.dto.PagoDTO;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PagoService {

    private final List<PagoDTO> listaPagos = new ArrayList<>();
    private final Map<Long, Long> clientesPorPedido = new HashMap<>();
    public PagoService() {
        registrarPago(1L, 1L, 10L, "TARJETA_CREDITO",
                130.00, "AUT001", "APROBADO");

        registrarPago(2L, 2L, 10L, "TRANSFERENCIA",
                450.00, "AUT002", "APROBADO");

        registrarPago(3L, 103L, 20L, "TARJETA_CREDITO",
                300.00, "AUT003", "RECHAZADO");
    }
    private void registrarPago(Long idPago, Long idPedido, Long clienteId,
                               String metodoPago, Double montoPagado,
                               String codigoAutorizacion, String estadoPago) {
        PagoDTO pago = new PagoDTO();
        pago.setIdPago(idPago);
        pago.setIdPedido(idPedido);
        pago.setMetodoPago(metodoPago);
        pago.setMontoPagado(montoPagado);
        pago.setFechaPago(LocalDateTime.now());
        pago.setCodigoAutorizacion(codigoAutorizacion);
        pago.setEstadoPago(estadoPago);
        listaPagos.add(pago);
        clientesPorPedido.put(idPedido, clienteId);
    }
    public PagoDTO obtenerPagoPorPedido(Long idPedido) {
        for (PagoDTO pago : listaPagos) {
            if (pago.getIdPedido().equals(idPedido)) {
                return pago;
            }
        }
        return null;
    }
    public List<PagoDTO> obtenerPagosPorCliente(Long clienteId) {
        List<PagoDTO> resultado = new ArrayList<>();
        for (PagoDTO pago : listaPagos) {
            Long idCliente = clientesPorPedido.get(pago.getIdPedido());
            if (clienteId.equals(idCliente)) {
                resultado.add(pago);
            }
        }
        return resultado;
    }
}
