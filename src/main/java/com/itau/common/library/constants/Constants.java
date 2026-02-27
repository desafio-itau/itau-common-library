package com.itau.common.library.constants;

import lombok.Getter;

@Getter
public enum Constants {

    CLIENTE_CPF_DUPLICADO("CLIENTE_CPF_DUPLICADO", "CPF já cadastrado no sistema", 400),
    VALOR_MENSAL_INVALIDO("VALOR_MENSAL_INVALIDO", "Valor mensal abaixo do mínimo", 400),
    PERCENTUAIS_INVALIDOS("PERCENTUAIS_INVALIDOS", "Soma dos percentuais diferente de 100%", 400),
    QUANTIDADE_ATIVOS_INVALIDA("QUANTIDADE_ATIVOS_INVALIDA", "Cesta não tem exatamente 5 ativos", 400),
    CLIENTE_JA_INATIVO("CLIENTE_JA_INATIVO", "Cliente já havia saído do produto", 400),
    CLIENTE_NAO_ENCONTRADO("CLIENTE_NAO_ENCONTRADO", "Cliente não encontrado", 404),
    CESTA_NAO_ENCONTRADA("CESTA_NAO_ENCONTRADA", "Nenhuma cesta ativa encontrada", 404),
    COTACAO_NAO_ENCONTRADA("COTACAO_NAO_ENCONTRADA", "Arquivo COTAHIST nao encontrado para a data", 404),
    COMPRA_JA_EXECUTADA("COMPRA_JA_EXECUTADA", "Compra já foi executada para esta data", 409),
    KAFKA_INDISPONIVEL("KAFKA_INDISPONIVEL", "Erro ao publicar no tópico Kafka", 500);

    private final String codigo;
    private final String mensagem;
    private final Integer codigoHTTP;

    Constants(String codigo, String mensagem, Integer codigoHTTP) {
        this.codigo = codigo;
        this.mensagem = mensagem;
        this.codigoHTTP = codigoHTTP;
    }
}
