package pk.cross_zone.facade_vs_mediator.facade;

/**
 * 奖金计算
 * Created by Nelson on 2020/8/9.
 */
public class Bonus {

    // 考勤情况
    private Attendance atte = new Attendance();

    // 奖金
    public int getBonus() {
        // 获得出勤情况
        int workDays = atte.getWorkDays();
        // 奖金计算模型
        int bonus = workDays * 1800 / 30;
        return bonus;
    }
}