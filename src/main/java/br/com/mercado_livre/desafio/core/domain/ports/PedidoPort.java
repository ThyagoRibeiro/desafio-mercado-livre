package br.com.mercado_livre.desafio.core.domain.ports;

import br.com.mercado_livre.desafio.core.domain.entities.PedidoEntity;

import java.util.Optional;

public interface PedidoPort {

    Optional<PedidoEntity> buscarPedido(String identificadorPedido);

}
