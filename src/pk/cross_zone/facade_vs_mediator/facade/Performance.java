package pk.cross_zone.facade_vs_mediator.facade;

import java.util.Random;

/**
 * 绩效
 * Created by Nelson on 2020/8/9.
 */
public class Performance {
    // 基本工资
    private BasicSalary salary = new BasicSalary();

    public int getPerformanceValue() {
        // 随机绩效
        int perf = (new Random()).nextInt(100);
        return salary.getBasicSalary() * perf / 100;
    }
}