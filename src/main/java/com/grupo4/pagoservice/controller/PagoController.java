package com.grupo4.pagoservice.controller;
import com.grupo4.pagoservice.dto.PagoDTO;
import com.grupo4.pagoservice.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @GetMapping("/pedido/{idPedido}")
    public PagoDTO obtenerPagoPorPedido(@PathVariable Long idPedido) {
        return pagoService.obtenerPagoPorPedido(idPedido);
    }
    @GetMapping("/cliente/{clienteId}")
    public List<PagoDTO> obtenerPagosPorCliente(@PathVariable Long clienteId) {
        return pagoService.obtenerPagosPorCliente(clienteId);
    }
}
