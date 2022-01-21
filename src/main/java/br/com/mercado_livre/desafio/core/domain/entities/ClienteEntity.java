package br.com.mercado_livre.desafio.core.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteEntity {

    @JsonProperty("id_cliente")
    private String idCliente;

    @JsonProperty("nome")
    String nome;

}
