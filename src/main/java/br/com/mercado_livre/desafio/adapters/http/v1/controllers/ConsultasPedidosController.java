package br.com.mercado_livre.desafio.adapters.http.v1.controllers;

import br.com.mercado_livre.desafio.adapters.http.v1.mappers.PedidosMapper;
import br.com.mercado_livre.desafio.adapters.http.v1.models.request.PostConsultasPedidosRequest;
import br.com.mercado_livre.desafio.adapters.http.v1.models.response.MensagemPadronizadaResponse;
import br.com.mercado_livre.desafio.adapters.http.v1.models.response.post_consultas_pedidos.PostConsultasPedidosResponse;
import br.com.mercado_livre.desafio.core.domain.entities.PedidoEntity;
import br.com.mercado_livre.desafio.core.usecases.PedidosUseCase;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/desafio_mercado_livre/v1/consultas_pedidos")
@Api(value = "Pedidos Api")
@ApiResponses(value={@ApiResponse(code=200, message="OK"), @ApiResponse(code=404, message="Not Found")})
public class ConsultasPedidosController {

    private final PedidosUseCase pedidosUseCase;
    private final PedidosMapper consultasPedidosMapper;

    public ConsultasPedidosController(PedidosUseCase pedidosUseCase, PedidosMapper consultasPedidosMapper) {
        this.pedidosUseCase = pedidosUseCase;
        this.consultasPedidosMapper = consultasPedidosMapper;
    }

    @ApiOperation(value = "Consulta pedido passando identificador em um JSON")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postConsultasPedidos(HttpServletRequest httpServletRequest,
                                                  @Valid @RequestBody PostConsultasPedidosRequest postConsultasPedidosRequest) throws JsonProcessingException {

        String idPedido = postConsultasPedidosRequest.getIdPedido();

        Optional<PedidoEntity> pedidoEntityOpt = pedidosUseCase.buscarPedido(idPedido);

        if(pedidoEntityOpt.isEmpty()) {

            MensagemPadronizadaResponse mensagemPadronizadaResponse = new MensagemPadronizadaResponse("Pedido não encontrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagemPadronizadaResponse);
        }

        PostConsultasPedidosResponse postConsultasPedidosResponse = consultasPedidosMapper.toPostConsultasPedidosResponse(pedidoEntityOpt.get());
        return ResponseEntity.status(HttpStatus.OK).body(postConsultasPedidosResponse);

    }

}
