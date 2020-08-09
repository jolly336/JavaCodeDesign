package pk.cross_zone.facade_vs_mediator.mediator;

/**
 * Created by Nelson on 2020/8/9.
 */
public class Tax extends AbsColleague implements ITax {

    public Tax(AbsMediator _mediator) {
        super(_mediator);
    }

    @Override
    public void raise() {
        super.mediator.up(this);
    }

    @Override
    public void drop() {
        super.mediator.down(this);
    }
}