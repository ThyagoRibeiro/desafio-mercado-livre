package br.com.mercado_livre.desafio.unittests.adapters.http.rest.v1.controllers;

import br.com.mercado_livre.desafio.adapters.http.v1.mappers.PedidosMapper;
import br.com.mercado_livre.desafio.adapters.http.v1.models.response.get_pedidos.GetPedidosResponse;
import br.com.mercado_livre.desafio.core.domain.entities.PedidoEntity;
import br.com.mercado_livre.desafio.core.usecases.PedidosUseCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc(addFilters = false)
@SpringBootTest
public class PedidosControllerTest {

    private final static String CONTROLLER_ROUTE = "/desafio_mercado_livre/v1/pedidos/%s";

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PedidosMapper pedidosMapper;

    @MockBean
    private PedidosUseCase pedidosUseCase;

    @Test
    public void get_pedidos_deve_retornar_sucesso() throws Exception {

        String idPedido = "442a8a38-1db4-4e9b-bb2e-c473bb04b2af";

        when(pedidosUseCase.buscarPedido(idPedido)).thenReturn(Optional.of(new PedidoEntity()));
        when(pedidosMapper.toGetPedidosResponse((PedidoEntity) any())).thenReturn(new GetPedidosResponse());

        mvc.perform(get(String.format(CONTROLLER_ROUTE, idPedido)))
                .andExpect(status().isOk());

    }

    @Test
    public void get_pedidos_deve_retornar_nao_encontrado() throws Exception {

        String idPedido = "442a8a38-1db4-4e9b-bb2e-c473bb04b2af";

        when(pedidosUseCase.buscarPedido(idPedido)).thenReturn(Optional.empty());
        when(pedidosMapper.toGetPedidosResponse((PedidoEntity) any())).thenReturn(new GetPedidosResponse());

        mvc.perform(get(String.format(CONTROLLER_ROUTE, idPedido)))
                .andExpect(status().isNotFound());

    }

    @Test
    public void get_pedidos_deve_retornar_erro_validacao() throws Exception {

        String idPedido = null;

        when(pedidosUseCase.buscarPedido(idPedido)).thenReturn(Optional.empty());
        when(pedidosMapper.toGetPedidosResponse((PedidoEntity) any())).thenReturn(new GetPedidosResponse());

        mvc.perform(get(String.format(CONTROLLER_ROUTE, idPedido)))
                .andExpect(status().isBadRequest());

    }

}
