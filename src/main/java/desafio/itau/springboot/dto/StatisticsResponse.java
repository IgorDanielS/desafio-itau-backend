package desafio.itau.springboot.dto;

import lombok.Getter;

import java.util.DoubleSummaryStatistics;

@Getter
public class StatisticsResponse {

    private final long count;
    private final double sum;
    private final double avg;
    private final double max;
    private final double min;

    public StatisticsResponse(DoubleSummaryStatistics stats){
        this.count = stats.getCount();
        this.sum = stats.getSum();
        this.avg = stats.getAverage();
        this.max = stats.getMax();
        this.min = stats.getMin();
    }
}
