package pk.cross_zone.facade_vs_mediator.mediator;

/**
 * 职位
 * Created by Nelson on 2020/8/9.
 */
public class Position extends AbsColleague implements IPosition {

    public Position(AbsMediator _mediator) {
        super(_mediator);
    }

    @Override
    public void promote() {
        super.mediator.up(this);
    }

    @Override
    public void demote() {
        super.mediator.down(this);
    }
}