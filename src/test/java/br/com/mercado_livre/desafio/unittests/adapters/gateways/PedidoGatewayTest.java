package br.com.mercado_livre.desafio.unittests.adapters.gateways;

import br.com.mercado_livre.desafio.adapters.gateways.PedidoGateway;
import br.com.mercado_livre.desafio.adapters.gateways.repositories.PedidoRepository;
import br.com.mercado_livre.desafio.adapters.gateways.repositories.dto.PedidoDTO;
import br.com.mercado_livre.desafio.adapters.gateways.repositories.mappers.PedidoDTOMapper;
import br.com.mercado_livre.desafio.core.domain.entities.PedidoEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class PedidoGatewayTest {

    private PedidoGateway pedidoGateway;

    @MockBean
    private PedidoRepository pedidoRepository;

    @MockBean
    private PedidoDTOMapper pedidoDTOMapper;

    @Before
    public void setUp() {
        pedidoGateway = new PedidoGateway(pedidoRepository, pedidoDTOMapper);
    }

    @Test
    public void buscar_pedido_retorna_registro() {

        String idPedido = "442a8a38-1db4-4e9b-bb2e-c473bb04b2af";
        PedidoEntity pedidoEntity = new PedidoEntity();

        when(pedidoRepository.findByIdPedido(idPedido)).thenReturn(Optional.of(new PedidoDTO()));
        when(pedidoDTOMapper.toEntity((PedidoDTO) any())).thenReturn(pedidoEntity);
        Optional<PedidoEntity> pedidoEntityOpt = pedidoGateway.buscarPedido(idPedido);
        assertEquals(true, pedidoEntityOpt.isPresent());

    }

    @Test
    public void buscar_pedido_retorna_vazio() {

        String idPedido = "442a8a38-1db4-4e9b-bb2e-c473bb04b2af";

        when(pedidoRepository.findByIdPedido(idPedido)).thenReturn(Optional.empty());
        Optional<PedidoEntity> pedidoEntityOpt = pedidoGateway.buscarPedido(idPedido);
        assertEquals(Optional.empty(), pedidoEntityOpt);

    }

}
