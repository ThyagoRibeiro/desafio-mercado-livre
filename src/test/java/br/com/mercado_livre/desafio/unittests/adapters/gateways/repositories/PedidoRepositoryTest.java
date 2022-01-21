package br.com.mercado_livre.desafio.unittests.adapters.gateways.repositories;

import br.com.mercado_livre.desafio.adapters.gateways.repositories.PedidoRepository;
import br.com.mercado_livre.desafio.adapters.gateways.repositories.dto.PedidoDTO;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.QueryRequest;
import com.amazonaws.services.dynamodbv2.model.QueryResult;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class PedidoRepositoryTest {

    @MockBean
    private PedidoRepository pedidoRepository;

    @MockBean
    private AmazonDynamoDB amazonDynamoDB;

    @MockBean
    private DynamoDBMapper dynamoDBMapper;

    @Before
    public void setUp() {
        pedidoRepository = new PedidoRepository(amazonDynamoDB);
    }

    @Test
    public void find_by_id_retorna_registro() {

        String idPedido = "442a8a38-1db4-4e9b-bb2e-c473bb04b2af";

        List<Map<String, AttributeValue>> items = new ArrayList<>();
        items.add(Map.of("Test", new AttributeValue()));

        QueryResult queryResult = new QueryResult();
        queryResult.setItems(items);

        PedidoDTO pedidoDTO = new PedidoDTO();

        when(amazonDynamoDB.query((QueryRequest) any())).thenReturn(queryResult);

        Optional<PedidoDTO> pedidoDTOOpt = pedidoRepository.findByIdPedido(idPedido);
        assertEquals(true, pedidoDTOOpt.isPresent());

    }

    @Test
    public void find_by_id_retorna_vazio() {

        String idPedido = "442a8a38-1db4-4e9b-bb2e-c473bb04b2af";

        QueryResult queryResult = new QueryResult();
        queryResult.setItems(new ArrayList<>());

        when(amazonDynamoDB.query((QueryRequest) any())).thenReturn(queryResult);

        Optional<PedidoDTO> pedidoDTOOpt = pedidoRepository.findByIdPedido(idPedido);
        assertEquals(Optional.empty(), pedidoDTOOpt);

    }

}
