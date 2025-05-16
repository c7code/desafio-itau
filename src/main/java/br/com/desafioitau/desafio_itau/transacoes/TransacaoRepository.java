package br.com.desafioitau.desafio_itau.transacoes;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import br.com.desafioitau.desafio_itau.estatisticas.EstatisticasDto;
import org.springframework.stereotype.Repository;

@Repository
public class TransacaoRepository {

    private final List<TransacaoRequest> transacoes = new ArrayList<>();


    public void add(TransacaoRequest transacaoRequest) {
        transacoes.add(transacaoRequest);
    }

    public void limpar() {
        transacoes.clear();
    }

    public EstatisticasDto estatistica(OffsetDateTime horaInicial) {

        if (transacoes.isEmpty()) {
            return new EstatisticasDto();
        } else {

            final BigDecimal[] valoresFiltrados = transacoes.stream()
                    // -->> removido para teste .filter(t -> t.getDataHora().isAfter(horaInicial) || t.getDataHora().equals(horaInicial))
                    .map(t -> t.getValor()).toArray(BigDecimal[]::new);
            DoubleStream doubleStream = Arrays.stream(valoresFiltrados).mapToDouble(BigDecimal::doubleValue);
            return new EstatisticasDto(doubleStream.summaryStatistics());
        }
    }

}
