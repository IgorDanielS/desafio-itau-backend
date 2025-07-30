package desafio.itau.springboot.dto;

import java.util.DoubleSummaryStatistics;

public class StatisticsResponse {

    private long count;
    private double sum;
    private double avg;
    private double max;
    private double min;

    public StatisticsResponse(DoubleSummaryStatistics stats){
        this.count = stats.getCount();
        this.sum = stats.getSum();
        this.avg = stats.getAverage();
        this.max = stats.getMax();
        this.min = stats.getMin();
    }

    public long getCount() {
        return this.count;
    }

    public double getSum() {
        return this.sum;
    }

    public double getAvg() {
        return this.avg;
    }

    public double getMax() {
        return this.max;
    }

    public double getMin() {
        return this.min;
    }
}
