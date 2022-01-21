package br.com.mercado_livre.desafio.adapters.http.v1.models.response;

import java.util.Arrays;
import java.util.Collection;

public class MensagemPadronizadaResponse {

    private Collection<String> mensagens;

    public MensagemPadronizadaResponse(String mensagem) {
        this.mensagens = Arrays.asList(mensagem);
    }

    public MensagemPadronizadaResponse(Collection<String> mensagens) {
        this.mensagens = mensagens;
    }

    public Collection<String> getMensagens() {
        return mensagens;
    }

}
