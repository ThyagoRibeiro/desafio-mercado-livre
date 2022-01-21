package br.com.mercado_livre.desafio.adapters.gateways.repositories.mappers;

import br.com.mercado_livre.desafio.adapters.gateways.repositories.dto.PedidoDTO;
import br.com.mercado_livre.desafio.core.domain.entities.PedidoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PedidoDTOMapper {

    PedidoEntity toEntity(PedidoDTO pedidoDTO);

}
