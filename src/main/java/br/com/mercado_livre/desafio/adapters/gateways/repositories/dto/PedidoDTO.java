package br.com.mercado_livre.desafio.adapters.gateways.repositories.dto;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamoDBTable(tableName = "MercadoLivrePedidos")
public class PedidoDTO {

    @DynamoDBHashKey
    private String idPedido;

    @DynamoDBAttribute
    private List<ProdutoDTO> produtoList;

    @DynamoDBAttribute
    private ClienteDTO cliente;

    @DynamoDBAttribute
    private String dataHoraCompra;

}
