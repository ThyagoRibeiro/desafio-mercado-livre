package br.com.mercado_livre.desafio.adapters.http.v1.mappers;

import br.com.mercado_livre.desafio.adapters.http.v1.models.response.get_pedidos.GetPedidosResponse;
import br.com.mercado_livre.desafio.adapters.http.v1.models.response.post_consultas_pedidos.PostConsultasPedidosResponse;
import br.com.mercado_livre.desafio.core.domain.entities.PedidoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PedidosMapper {

    PostConsultasPedidosResponse toPostConsultasPedidosResponse(PedidoEntity pedidoEntity);
    GetPedidosResponse toGetPedidosResponse(PedidoEntity pedidoEntity);

}
