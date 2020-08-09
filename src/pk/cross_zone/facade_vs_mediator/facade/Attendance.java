package pk.cross_zone.facade_vs_mediator.facade;

import java.util.Random;

/**
 * 考勤情况
 * <p>
 * Created by Nelson on 2020/8/9.
 */
public class Attendance {
    // 得到出勤天数
    public int getWorkDays() {
        return (new Random()).nextInt(30);
    }
}