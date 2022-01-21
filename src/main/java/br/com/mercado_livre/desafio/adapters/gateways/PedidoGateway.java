package br.com.mercado_livre.desafio.adapters.gateways;

import br.com.mercado_livre.desafio.adapters.gateways.repositories.PedidoRepository;
import br.com.mercado_livre.desafio.adapters.gateways.repositories.dto.PedidoDTO;
import br.com.mercado_livre.desafio.adapters.gateways.repositories.mappers.PedidoDTOMapper;
import br.com.mercado_livre.desafio.core.domain.entities.PedidoEntity;
import br.com.mercado_livre.desafio.core.domain.ports.PedidoPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PedidoGateway implements PedidoPort {

    private final PedidoRepository pedidoRepository;
    private final PedidoDTOMapper pedidoDTOMapper;

    public PedidoGateway(PedidoRepository pedidoRepository, PedidoDTOMapper pedidoDTOMapper) {
        this.pedidoRepository = pedidoRepository;
        this.pedidoDTOMapper = pedidoDTOMapper;
    }

    @Override
    public Optional<PedidoEntity> buscarPedido(String identificadorPedido) {

        Optional<PedidoDTO> pedidoDTOOpt = pedidoRepository.findByIdPedido(identificadorPedido);

        Optional<PedidoEntity> pedidoEntityOpt = Optional.empty();

        if(pedidoDTOOpt.isPresent())
            pedidoEntityOpt = Optional.of(pedidoDTOMapper.toEntity(pedidoDTOOpt.get()));

        return pedidoEntityOpt;

    }

}