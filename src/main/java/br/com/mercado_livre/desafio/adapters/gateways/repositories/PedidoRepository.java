package br.com.mercado_livre.desafio.adapters.gateways.repositories;

import br.com.mercado_livre.desafio.adapters.gateways.repositories.dto.PedidoDTO;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.QueryRequest;
import com.amazonaws.services.dynamodbv2.model.QueryResult;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class PedidoRepository {

    public static final String NOME_TABELA = "MercadoLivrePedidos";

    private final AmazonDynamoDB amazonDynamoDB;
    private final DynamoDBMapper dynamoDBMapper;

    public PedidoRepository(AmazonDynamoDB amazonDynamoDB) {
        this.amazonDynamoDB = amazonDynamoDB;
        this.dynamoDBMapper = new DynamoDBMapper(this.amazonDynamoDB);
    }

    public Optional<PedidoDTO> findByIdPedido(String idPedido) {

        HashMap<String, AttributeValue> attrValues = new HashMap<>();
        attrValues.put(":idPedido", new AttributeValue().withS(idPedido));

        QueryRequest queryReq = new QueryRequest()
                .withTableName(NOME_TABELA)
                .withKeyConditionExpression("idPedido = :idPedido")
                .withExpressionAttributeValues(attrValues);

        QueryResult response = amazonDynamoDB.query(queryReq);
        List<Map<String, AttributeValue>> items = response.getItems();

        while (!items.isEmpty()) {
            return Optional.of(dynamoDBMapper.marshallIntoObject(PedidoDTO.class, items.get(0)));
        }

        return Optional.empty();

    }
}
