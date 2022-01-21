package br.com.mercado_livre.desafio.core.usecases.impl;

import br.com.mercado_livre.desafio.core.domain.entities.PedidoEntity;
import br.com.mercado_livre.desafio.core.domain.ports.PedidoPort;
import br.com.mercado_livre.desafio.core.usecases.PedidosUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PedidosUseCaseImpl implements PedidosUseCase {

    private final PedidoPort pedidoPort;

    public PedidosUseCaseImpl(PedidoPort pedidoPort) {
        this.pedidoPort = pedidoPort;
    }

    public static final Logger LOGGER = LoggerFactory.getLogger(PedidosUseCaseImpl.class);

    @Override
    public Optional<PedidoEntity> buscarPedido(String identificadorPedido) {

        return pedidoPort.buscarPedido(identificadorPedido);

    }

}
