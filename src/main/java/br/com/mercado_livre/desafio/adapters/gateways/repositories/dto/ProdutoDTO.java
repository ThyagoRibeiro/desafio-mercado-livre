package br.com.mercado_livre.desafio.adapters.gateways.repositories.dto;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamoDBDocument
public class ProdutoDTO {

    @DynamoDBAttribute
    private String idProduto;

    @DynamoDBAttribute
    private String nome;

    @DynamoDBAttribute
    private Integer quantidade;

    @DynamoDBAttribute
    private BigDecimal valor;

}
