package br.com.mercado_livre.desafio.core.usecases;

import br.com.mercado_livre.desafio.core.domain.entities.PedidoEntity;

import java.util.Optional;

public interface PedidosUseCase {

    Optional<PedidoEntity> buscarPedido(String identificadorPedido);

}
