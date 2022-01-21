package br.com.mercado_livre.desafio.adapters.http.v1.mappers;

import br.com.mercado_livre.desafio.adapters.http.v1.models.response.get_pedidos.GetPedidosResponse;
import br.com.mercado_livre.desafio.adapters.http.v1.models.response.post_consultas_pedidos.ClienteVO;
import br.com.mercado_livre.desafio.adapters.http.v1.models.response.post_consultas_pedidos.PostConsultasPedidosResponse;
import br.com.mercado_livre.desafio.adapters.http.v1.models.response.post_consultas_pedidos.ProdutoVO;
import br.com.mercado_livre.desafio.core.domain.entities.ClienteEntity;
import br.com.mercado_livre.desafio.core.domain.entities.PedidoEntity;
import br.com.mercado_livre.desafio.core.domain.entities.ProdutoEntity;
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
public class PedidosMapperImpl implements PedidosMapper {

    @Override
    public PostConsultasPedidosResponse toPostConsultasPedidosResponse(PedidoEntity pedidoEntity) {
        if ( pedidoEntity == null ) {
            return null;
        }

        PostConsultasPedidosResponse postConsultasPedidosResponse = new PostConsultasPedidosResponse();

        postConsultasPedidosResponse.setIdPedido( pedidoEntity.getIdPedido() );
        postConsultasPedidosResponse.setProdutoList( produtoEntityListToProdutoVOList( pedidoEntity.getProdutoList() ) );
        postConsultasPedidosResponse.setCliente( clienteEntityToClienteVO( pedidoEntity.getCliente() ) );
        postConsultasPedidosResponse.setDataHoraCompra( pedidoEntity.getDataHoraCompra() );

        return postConsultasPedidosResponse;
    }

    @Override
    public GetPedidosResponse toGetPedidosResponse(PedidoEntity pedidoEntity) {
        if ( pedidoEntity == null ) {
            return null;
        }

        GetPedidosResponse getPedidosResponse = new GetPedidosResponse();

        getPedidosResponse.setIdPedido( pedidoEntity.getIdPedido() );
        getPedidosResponse.setProdutoList( produtoEntityListToProdutoVOList1( pedidoEntity.getProdutoList() ) );
        getPedidosResponse.setCliente( clienteEntityToClienteVO1( pedidoEntity.getCliente() ) );
        getPedidosResponse.setDataHoraCompra( pedidoEntity.getDataHoraCompra() );

        return getPedidosResponse;
    }

    protected ProdutoVO produtoEntityToProdutoVO(ProdutoEntity produtoEntity) {
        if ( produtoEntity == null ) {
            return null;
        }

        ProdutoVO produtoVO = new ProdutoVO();

        produtoVO.setIdProduto( produtoEntity.getIdProduto() );
        produtoVO.setNome( produtoEntity.getNome() );
        produtoVO.setQuantidade( produtoEntity.getQuantidade() );
        produtoVO.setValor( produtoEntity.getValor() );

        return produtoVO;
    }

    protected List<ProdutoVO> produtoEntityListToProdutoVOList(List<ProdutoEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<ProdutoVO> list1 = new ArrayList<ProdutoVO>( list.size() );
        for ( ProdutoEntity produtoEntity : list ) {
            list1.add( produtoEntityToProdutoVO( produtoEntity ) );
        }

        return list1;
    }

    protected ClienteVO clienteEntityToClienteVO(ClienteEntity clienteEntity) {
        if ( clienteEntity == null ) {
            return null;
        }

        ClienteVO clienteVO = new ClienteVO();

        clienteVO.setIdCliente( clienteEntity.getIdCliente() );
        clienteVO.setNome( clienteEntity.getNome() );

        return clienteVO;
    }

    protected br.com.mercado_livre.desafio.adapters.http.v1.models.response.get_pedidos.ProdutoVO produtoEntityToProdutoVO1(ProdutoEntity produtoEntity) {
        if ( produtoEntity == null ) {
            return null;
        }

        br.com.mercado_livre.desafio.adapters.http.v1.models.response.get_pedidos.ProdutoVO produtoVO = new br.com.mercado_livre.desafio.adapters.http.v1.models.response.get_pedidos.ProdutoVO();

        produtoVO.setIdProduto( produtoEntity.getIdProduto() );
        produtoVO.setNome( produtoEntity.getNome() );
        produtoVO.setQuantidade( produtoEntity.getQuantidade() );
        produtoVO.setValor( produtoEntity.getValor() );

        return produtoVO;
    }

    protected List<br.com.mercado_livre.desafio.adapters.http.v1.models.response.get_pedidos.ProdutoVO> produtoEntityListToProdutoVOList1(List<ProdutoEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<br.com.mercado_livre.desafio.adapters.http.v1.models.response.get_pedidos.ProdutoVO> list1 = new ArrayList<br.com.mercado_livre.desafio.adapters.http.v1.models.response.get_pedidos.ProdutoVO>( list.size() );
        for ( ProdutoEntity produtoEntity : list ) {
            list1.add( produtoEntityToProdutoVO1( produtoEntity ) );
        }

        return list1;
    }

    protected br.com.mercado_livre.desafio.adapters.http.v1.models.response.get_pedidos.ClienteVO clienteEntityToClienteVO1(ClienteEntity clienteEntity) {
        if ( clienteEntity == null ) {
            return null;
        }

        br.com.mercado_livre.desafio.adapters.http.v1.models.response.get_pedidos.ClienteVO clienteVO = new br.com.mercado_livre.desafio.adapters.http.v1.models.response.get_pedidos.ClienteVO();

        clienteVO.setIdCliente( clienteEntity.getIdCliente() );
        clienteVO.setNome( clienteEntity.getNome() );

        return clienteVO;
    }
}
