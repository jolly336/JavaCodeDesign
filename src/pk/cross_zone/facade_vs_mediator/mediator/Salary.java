package pk.cross_zone.facade_vs_mediator.mediator;

/**
 * Created by Nelson on 2020/8/9.
 */
public class Salary extends AbsColleague implements ISalary {

    public Salary(AbsMediator _mediator) {
        super(_mediator);
    }

    @Override
    public void increaseSalary() {
        super.mediator.up(this);
    }

    @Override
    public void decreaseSalary() {
        super.mediator.down(this);
    }
}