package br.com.mercado_livre.desafio.core.domain.entities;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PedidoEntity {

    private String idPedido;
    private List<ProdutoEntity> produtoList;
    private ClienteEntity cliente;
    private LocalDateTime dataHoraCompra;

}
