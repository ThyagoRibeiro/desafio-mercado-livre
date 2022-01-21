package br.com.mercado_livre.desafio.adapters.gateways.repositories.mappers;

import br.com.mercado_livre.desafio.adapters.gateways.repositories.dto.ClienteDTO;
import br.com.mercado_livre.desafio.adapters.gateways.repositories.dto.PedidoDTO;
import br.com.mercado_livre.desafio.adapters.gateways.repositories.dto.ProdutoDTO;
import br.com.mercado_livre.desafio.core.domain.entities.ClienteEntity;
import br.com.mercado_livre.desafio.core.domain.entities.ClienteEntity.ClienteEntityBuilder;
import br.com.mercado_livre.desafio.core.domain.entities.PedidoEntity;
import br.com.mercado_livre.desafio.core.domain.entities.PedidoEntity.PedidoEntityBuilder;
import br.com.mercado_livre.desafio.core.domain.entities.ProdutoEntity;
import br.com.mercado_livre.desafio.core.domain.entities.ProdutoEntity.ProdutoEntityBuilder;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-21T09:44:11-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.12 (Red Hat, Inc.)"
)
@Component
public class PedidoDTOMapperImpl implements PedidoDTOMapper {

    @Override
    public PedidoEntity toEntity(PedidoDTO pedidoDTO) {
        if ( pedidoDTO == null ) {
            return null;
        }

        PedidoEntityBuilder pedidoEntity = PedidoEntity.builder();

        pedidoEntity.idPedido( pedidoDTO.getIdPedido() );
        pedidoEntity.produtoList( produtoDTOListToProdutoEntityList( pedidoDTO.getProdutoList() ) );
        pedidoEntity.cliente( clienteDTOToClienteEntity( pedidoDTO.getCliente() ) );
        if ( pedidoDTO.getDataHoraCompra() != null ) {
            pedidoEntity.dataHoraCompra( LocalDateTime.parse( pedidoDTO.getDataHoraCompra() ) );
        }

        return pedidoEntity.build();
    }

    protected ProdutoEntity produtoDTOToProdutoEntity(ProdutoDTO produtoDTO) {
        if ( produtoDTO == null ) {
            return null;
        }

        ProdutoEntityBuilder produtoEntity = ProdutoEntity.builder();

        produtoEntity.idProduto( produtoDTO.getIdProduto() );
        produtoEntity.nome( produtoDTO.getNome() );
        produtoEntity.quantidade( produtoDTO.getQuantidade() );
        produtoEntity.valor( produtoDTO.getValor() );

        return produtoEntity.build();
    }

    protected List<ProdutoEntity> produtoDTOListToProdutoEntityList(List<ProdutoDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<ProdutoEntity> list1 = new ArrayList<ProdutoEntity>( list.size() );
        for ( ProdutoDTO produtoDTO : list ) {
            list1.add( produtoDTOToProdutoEntity( produtoDTO ) );
        }

        return list1;
    }

    protected ClienteEntity clienteDTOToClienteEntity(ClienteDTO clienteDTO) {
        if ( clienteDTO == null ) {
            return null;
        }

        ClienteEntityBuilder clienteEntity = ClienteEntity.builder();

        clienteEntity.idCliente( clienteDTO.getIdCliente() );
        clienteEntity.nome( clienteDTO.getNome() );

        return clienteEntity.build();
    }
}
