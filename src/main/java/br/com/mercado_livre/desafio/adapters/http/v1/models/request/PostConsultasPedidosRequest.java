package br.com.mercado_livre.desafio.adapters.http.v1.models.request;

import br.com.mercado_livre.desafio.adapters.http.v1.validators.IsUUID;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostConsultasPedidosRequest {

    @JsonProperty("id_pedido")
    @NotBlank
    @IsUUID
    private String idPedido;

}
