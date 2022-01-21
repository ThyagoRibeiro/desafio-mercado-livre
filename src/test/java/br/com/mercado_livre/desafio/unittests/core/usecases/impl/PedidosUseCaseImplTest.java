package br.com.mercado_livre.desafio.unittests.core.usecases.impl;

import br.com.mercado_livre.desafio.core.domain.entities.PedidoEntity;
import br.com.mercado_livre.desafio.core.domain.ports.PedidoPort;
import br.com.mercado_livre.desafio.core.usecases.impl.PedidosUseCaseImpl;
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
public class PedidosUseCaseImplTest {

    @MockBean
    private PedidoPort pedidoPort;

    @Test
    public void buscar_pedido_retorna_sucesso() throws Exception {

        String idPedido = "442a8a38-1db4-4e9b-bb2e-c473bb04b2af";

        when(pedidoPort.buscarPedido((String) any())).thenReturn(Optional.of(new PedidoEntity()));

        PedidosUseCaseImpl pedidosUseCaseImpl = new PedidosUseCaseImpl(pedidoPort);
        Optional<PedidoEntity> pedidoEntityOpt = pedidosUseCaseImpl.buscarPedido(idPedido);

        assertEquals(true, pedidoEntityOpt.isPresent());

    }

}
