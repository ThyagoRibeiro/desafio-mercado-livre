package br.com.mercado_livre.desafio.unittests.adapters.gateways.repositories.mappers;

import br.com.mercado_livre.desafio.adapters.gateways.repositories.dto.ClienteDTO;
import br.com.mercado_livre.desafio.adapters.gateways.repositories.dto.PedidoDTO;
import br.com.mercado_livre.desafio.adapters.gateways.repositories.dto.ProdutoDTO;
import br.com.mercado_livre.desafio.adapters.gateways.repositories.mappers.PedidoDTOMapper;
import br.com.mercado_livre.desafio.core.domain.entities.PedidoEntity;
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
public class PedidoDTOMapperTest {

    @Autowired
    private PedidoDTOMapper pedidoDTOMapper;

    @Test
    public void converter_dto_em_entity() {

        ProdutoDTO produtoDTO = ProdutoDTO
                .builder()
                    .idProduto("442a8a38-1db4-4e9b-bb2e-c473bb04b2af")
                    .nome("Teste")
                    .quantidade(123)
                    .valor(new BigDecimal("123.05"))
                .build();

        ClienteDTO clienteDTO = ClienteDTO
                .builder()
                    .idCliente("442a8a38-1db4-4e9b-bb2e-c473bb04b2af")
                    .nome("Teste")
                .build();

        PedidoDTO pedidoDTO = PedidoDTO
                .builder()
                    .idPedido("442a8a38-1db4-4e9b-bb2e-c473bb04b2af")
                    .produtoList(Arrays.asList(produtoDTO))
                    .cliente(clienteDTO)
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

        PedidoEntity pedidoEntity = pedidoDTOMapper.toEntity(pedidoDTO);
        assertNotNull(pedidoEntity);

    }

    @Test
    public void converter_dto_em_entity_produto_list_cliente_null() {

        PedidoDTO pedidoDTO = PedidoDTO
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

        PedidoEntity pedidoEntity = pedidoDTOMapper.toEntity(pedidoDTO);
        assertNotNull(pedidoEntity);

    }

    @Test
    public void converter_dto_em_entity_produto_null() {

        List<ProdutoDTO> produtoDTOList = new ArrayList<>();
        produtoDTOList.add(null);

        PedidoDTO pedidoDTO = PedidoDTO
                .builder()
                .idPedido("442a8a38-1db4-4e9b-bb2e-c473bb04b2af")
                .produtoList(produtoDTOList)
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

        PedidoEntity pedidoEntity = pedidoDTOMapper.toEntity(pedidoDTO);
        assertNotNull(pedidoEntity);

    }

    @Test
    public void converter_dto_em_entity_pedido_null() {

        PedidoEntity pedidoEntity = pedidoDTOMapper.toEntity(null);
        assertNull(pedidoEntity);

    }

}
