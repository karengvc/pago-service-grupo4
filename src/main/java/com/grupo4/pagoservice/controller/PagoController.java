package com.grupo4.pagoservice.controller;
import com.grupo4.pagoservice.dto.PagoDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pagos")
public class PagoController {
    private final List<PagoDTO> pagos = new ArrayList<>();
    @GetMapping("/pedido/{idPedido}")
    public PagoDTO obtenerPagoPorPedido(
            @PathVariable Long idPedido) {
        return pagos.stream()
                .filter(pago -> pago.getIdPedido().equals(idPedido))
                .findFirst()
                .orElse(null);
    }
    @GetMapping("/cliente/{clienteId}")
    public List<PagoDTO> obtenerPagosPorCliente(
            @PathVariable Long clienteId) {
        return new ArrayList<>();
    }}
