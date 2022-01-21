package br.com.mercado_livre.desafio.adapters.http.v1.models.response.post_consultas_pedidos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClienteVO {

    @JsonProperty("id_cliente")
    String idCliente;

    @JsonProperty("nome")
    String nome;

}
