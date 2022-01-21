package br.com.mercado_livre.desafio.unittests.adapters.http.rest.v1.mappers;

import br.com.mercado_livre.desafio.adapters.http.v1.mappers.PedidosMapper;
import br.com.mercado_livre.desafio.adapters.http.v1.models.response.get_pedidos.GetPedidosResponse;
import br.com.mercado_livre.desafio.adapters.http.v1.models.response.post_consultas_pedidos.PostConsultasPedidosResponse;
import br.com.mercado_livre.desafio.core.domain.entities.ClienteEntity;
import br.com.mercado_livre.desafio.core.domain.entities.PedidoEntity;
import br.com.mercado_livre.desafio.core.domain.entities.ProdutoEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class PedidosMapperTest {

    @Autowired
    private PedidosMapper pedidosMapper;

    @Test
    public void converter_dto_em_post_consultas_pedidos_entity() {

        ProdutoEntity produtoEntity = ProdutoEntity
                .builder()
                    .idProduto("442a8a38-1db4-4e9b-bb2e-c473bb04b2af")
                    .nome("Teste")
                    .quantidade(123)
                    .valor(new BigDecimal("123.05"))
                .build();

        ClienteEntity clienteEntity = ClienteEntity
                .builder()
                    .idCliente("442a8a38-1db4-4e9b-bb2e-c473bb04b2af")
                    .nome("Teste")
                .build();

        PedidoEntity pedidoEntity = PedidoEntity
                .builder()
                    .idPedido("442a8a38-1db4-4e9b-bb2e-c473bb04b2af")
                    .produtoList(Arrays.asList(produtoEntity))
                    .cliente(clienteEntity)
                    .dataHoraCompra(
                            LocalDateTime.of(
                                    2022,
                                    Month.JANUARY,
                                    14,
                                    19,
                                    30,
                                    40
                            )
                    )
                .build();

        PostConsultasPedidosResponse postConsultasPedidosResponse = pedidosMapper.toPostConsultasPedidosResponse(pedidoEntity);
        assertNotNull(postConsultasPedidosResponse);

    }

    @Test
    public void converter_dto_em_post_consultas_pedidos_entity_produto_cliente_null() {

        List<ProdutoEntity> produtoEntityList = new ArrayList<>();
        produtoEntityList.add(null);

        PedidoEntity pedidoEntity = PedidoEntity
                .builder()
                .idPedido("442a8a38-1db4-4e9b-bb2e-c473bb04b2af")
                .produtoList(produtoEntityList)
                .cliente(null)
                .dataHoraCompra(
                        LocalDateTime.of(
                                2022,
                                Month.JANUARY,
                                14,
                                19,
                                30,
                                40
                        )
                )
                .build();

        PostConsultasPedidosResponse postConsultasPedidosResponse = pedidosMapper.toPostConsultasPedidosResponse(pedidoEntity);
        assertNotNull(postConsultasPedidosResponse);

    }

    @Test
    public void converter_dto_em_post_consultas_pedidos_entity_produto_list_null() {

        PedidoEntity pedidoEntity = PedidoEntity
                .builder()
                .idPedido("442a8a38-1db4-4e9b-bb2e-c473bb04b2af")
                .produtoList(null)
                .cliente(null)
                .dataHoraCompra(
                        LocalDateTime.of(
                                2022,
                                Month.JANUARY,
                                14,
                                19,
                                30,
                                40
                        )
                )
                .build();

        PostConsultasPedidosResponse postConsultasPedidosResponse = pedidosMapper.toPostConsultasPedidosResponse(pedidoEntity);
        assertNotNull(postConsultasPedidosResponse);

    }

    @Test
    public void converter_dto_em_post_consultas_pedidos_entity_pedido_null() {

        PostConsultasPedidosResponse postConsultasPedidosResponse = pedidosMapper.toPostConsultasPedidosResponse(null);
        assertNull(postConsultasPedidosResponse);

    }

    @Test
    public void converter_dto_em_get_pedidos_entity() {

        ProdutoEntity produtoEntity = ProdutoEntity
                .builder()
                .idProduto("442a8a38-1db4-4e9b-bb2e-c473bb04b2af")
                .nome("Teste")
                .quantidade(123)
                .valor(new BigDecimal("123.05"))
                .build();

        ClienteEntity clienteEntity = ClienteEntity
                .builder()
                .idCliente("442a8a38-1db4-4e9b-bb2e-c473bb04b2af")
                .nome("Teste")
                .build();

        PedidoEntity pedidoEntity = PedidoEntity
                .builder()
                .idPedido("442a8a38-1db4-4e9b-bb2e-c473bb04b2af")
                .produtoList(Arrays.asList(produtoEntity))
                .cliente(clienteEntity)
                .dataHoraCompra(
                        LocalDateTime.of(
                                2022,
                                Month.JANUARY,
                                14,
                                19,
                                30,
                                40
                        )
                )
                .build();

        GetPedidosResponse getPedidosResponse = pedidosMapper.toGetPedidosResponse(pedidoEntity);
        assertNotNull(getPedidosResponse);

    }

    @Test
    public void converter_dto_em_get_pedidos_entity_produto_cliente_null() {

        List<ProdutoEntity> produtoEntityList = new ArrayList<>();
        produtoEntityList.add(null);

        PedidoEntity pedidoEntity = PedidoEntity
                .builder()
                .idPedido("442a8a38-1db4-4e9b-bb2e-c473bb04b2af")
                .produtoList(produtoEntityList)
                .cliente(null)
                .dataHoraCompra(
                        LocalDateTime.of(
                                2022,
                                Month.JANUARY,
                                14,
                                19,
                                30,
                                40
                        )
                )
                .build();

        GetPedidosResponse getPedidosResponse = pedidosMapper.toGetPedidosResponse(pedidoEntity);
        assertNotNull(getPedidosResponse);

    }

    @Test
    public void converter_dto_em_get_pedidos_entity_produto_list_null() {

        PedidoEntity pedidoEntity = PedidoEntity
                .builder()
                .idPedido("442a8a38-1db4-4e9b-bb2e-c473bb04b2af")
                .produtoList(null)
                .cliente(null)
                .dataHoraCompra(
                        LocalDateTime.of(
                                2022,
                                Month.JANUARY,
                                14,
                                19,
                                30,
                                40
                        )
                )
                .build();

        GetPedidosResponse getPedidosResponse = pedidosMapper.toGetPedidosResponse(pedidoEntity);
        assertNotNull(getPedidosResponse);

    }

    @Test
    public void converter_dto_em_get_pedidos_entity_pedido_null() {

        GetPedidosResponse getPedidosResponse = pedidosMapper.toGetPedidosResponse(null);
        assertNull(getPedidosResponse);

    }

}
