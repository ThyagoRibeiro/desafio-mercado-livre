package br.com.mercado_livre.desafio.adapters.http.v1.controllers;

import br.com.mercado_livre.desafio.adapters.http.v1.mappers.PedidosMapper;
import br.com.mercado_livre.desafio.adapters.http.v1.models.response.MensagemPadronizadaResponse;
import br.com.mercado_livre.desafio.adapters.http.v1.models.response.get_pedidos.GetPedidosResponse;
import br.com.mercado_livre.desafio.adapters.http.v1.validators.IsUUID;
import br.com.mercado_livre.desafio.core.domain.entities.PedidoEntity;
import br.com.mercado_livre.desafio.core.usecases.PedidosUseCase;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@Validated
@RequestMapping("/desafio_mercado_livre/v1/pedidos")
@Api(value = "Pedidos Api")
@ApiResponses(value={@ApiResponse(code=200, message="OK"), @ApiResponse(code=404, message="Not Found")})
public class PedidosController {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(PedidosController.class);
    private final PedidosUseCase pedidosUseCase;
    private final PedidosMapper pedidosMapper;

    public PedidosController(PedidosUseCase pedidosUseCase, PedidosMapper pedidosMapper) {
        this.pedidosUseCase = pedidosUseCase;
        this.pedidosMapper = pedidosMapper;
    }

    @ApiOperation(value = "Consulta pedido passando identificador como URI Parameter")
    @GetMapping(value = "{id_pedido}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPedidos(HttpServletRequest httpServletRequest,
                                        @Valid @IsUUID @PathVariable(value = "id_pedido", required = true) String idPedido) throws JsonProcessingException {

        Optional<PedidoEntity> pedidoEntityOpt = pedidosUseCase.buscarPedido(idPedido);

        if(pedidoEntityOpt.isEmpty()) {

            MensagemPadronizadaResponse mensagemPadronizadaResponse = new MensagemPadronizadaResponse("Pedido não encontrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MensagemPadronizadaResponse("Pedido não encontrado"));
        }

        GetPedidosResponse getConsultasPedidosResponse = pedidosMapper.toGetPedidosResponse(pedidoEntityOpt.get());
        return ResponseEntity.status(HttpStatus.OK).body(getConsultasPedidosResponse);

    }

}
