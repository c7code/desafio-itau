package br.com.desafioitau.desafio_itau.estatisticas;

import lombok.Getter;

import java.util.DoubleSummaryStatistics;


@Getter
public class EstatisticasDto {

    private final long count;
    private final Double sum;
    private final Double avg;
    private final Double min;
    private final Double max;


    public EstatisticasDto() {
        this(new DoubleSummaryStatistics());
    }


    public EstatisticasDto(final DoubleSummaryStatistics doubleSummaryStatistics) {
        this.count = doubleSummaryStatistics.getCount();
        this.sum = doubleSummaryStatistics.getSum();
        this.avg = doubleSummaryStatistics.getAverage();
        this.min = doubleSummaryStatistics.getMin() == Double.POSITIVE_INFINITY ? 0 : doubleSummaryStatistics.getMin();
        this.max = doubleSummaryStatistics.getMax() == Double.NEGATIVE_INFINITY ? 0 : doubleSummaryStatistics.getMax();

    }
}
