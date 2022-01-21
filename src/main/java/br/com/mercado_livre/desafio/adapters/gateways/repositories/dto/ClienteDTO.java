package br.com.mercado_livre.desafio.adapters.gateways.repositories.dto;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamoDBDocument
public class ClienteDTO {

    @DynamoDBAttribute
    private String idCliente;

    @DynamoDBAttribute
    private String nome;

}
