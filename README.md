# desafio-mercado-livre

Implementação do case do processo seletivo do Mercado Livre.

Dashboard do Kibana: http://ec2-54-207-22-125.sa-east-1.compute.amazonaws.com:5601/app/kibana
Dashboard do Keycloak: https://ec2-54-207-22-125.sa-east-1.compute.amazonaws.com:8443

Geração de token: 
  URL: https://ec2-54-207-22-125.sa-east-1.compute.amazonaws.com:8443/auth/realms/desafio-mercado-livre/protocol/openid-connect/token
  Client Id: d455367a-2c05-4b2b-870a-7f582f4850a4
  Client Secret: QT27DPfvRCSwpapBHBCNyZctwbLUSHGa

Rotas:
GET - http://ec2-54-207-22-125.sa-east-1.compute.amazonaws.com:8080/desafio_mercado_livre/v1/pedidos/{{id_pedido}}
POST - http://ec2-54-207-22-125.sa-east-1.compute.amazonaws.com:8080/desafio_mercado_livre/v1/consultas_pedidos
  - Body:
  {
    "id_pedido": "{{id_pedido}}"
  }

IDs cadastrados: 
  - 442a8a38-1db4-4e9b-bb2e-c473bb04b2af
  - 0ceca624-a131-4d34-afe1-5126607ead83
  - 3791d412-66bf-4ccd-85d2-a46c93cf19c9

Vídeo no YouTube: https://www.youtube.com/watch?v=8Cc1cUrMMLk
