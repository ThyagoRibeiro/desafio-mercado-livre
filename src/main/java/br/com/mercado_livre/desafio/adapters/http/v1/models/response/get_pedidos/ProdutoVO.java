package br.com.mercado_livre.desafio.adapters.http.v1.models.response.get_pedidos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ProdutoVO {

    @JsonProperty("id_produto")
    private String idProduto;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("quantidade")
    private Integer quantidade;

    @JsonProperty("valor")
    private BigDecimal valor;

}
