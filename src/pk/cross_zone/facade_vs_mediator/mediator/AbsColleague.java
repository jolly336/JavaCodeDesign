package pk.cross_zone.facade_vs_mediator.mediator;

/**
 * 抽象同事类
 * <p>
 * Created by Nelson on 2020/8/9.
 */
public abstract class AbsColleague {

    // 每个同事类都对中介者非常了解
    protected AbsMediator mediator;

    public AbsColleague(AbsMediator _mediator) {
        this.mediator = _mediator;
    }
}