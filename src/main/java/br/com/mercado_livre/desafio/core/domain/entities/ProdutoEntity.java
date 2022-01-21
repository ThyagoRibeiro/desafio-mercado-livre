package br.com.mercado_livre.desafio.core.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProdutoEntity {

    @JsonProperty("id_produto")
    private String idProduto;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("quantidade")
    private Integer quantidade;

    @JsonProperty("valor")
    private BigDecimal valor;

}
