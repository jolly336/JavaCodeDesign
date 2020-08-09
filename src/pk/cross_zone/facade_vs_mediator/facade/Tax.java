package pk.cross_zone.facade_vs_mediator.facade;

import java.util.Random;

/**
 * 税收
 * Created by Nelson on 2020/8/9.
 */
public class Tax {

    // 收取多少税金
    public int getTax() {
        // 交纳一个随机数量的税金
        return (new Random()).nextInt(300);
    }
}