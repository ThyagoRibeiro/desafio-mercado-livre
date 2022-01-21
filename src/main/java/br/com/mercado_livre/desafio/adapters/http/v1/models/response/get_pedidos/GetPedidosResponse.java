package br.com.mercado_livre.desafio.adapters.http.v1.models.response.get_pedidos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class GetPedidosResponse {

    @JsonProperty("id_pedido")
    private String idPedido;

    @JsonProperty("produtos")
    private List<ProdutoVO> produtoList;

    @JsonProperty("cliente")
    private ClienteVO cliente;

    @JsonProperty("data_hora_compra")
    private LocalDateTime dataHoraCompra;

}
