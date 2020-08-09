package pk.cross_zone.facade_vs_mediator.mediator;

/**
 * 抽象中介者
 * <p>
 * Created by Nelson on 2020/8/9.
 */
public abstract class AbsMediator {

    private final ISalary salary;
    private final IPosition position;
    private final ITax tax;

    public AbsMediator() {
        this.salary = new Salary(this);
        this.position = new Position(this);
        this.tax = new Tax(this);
    }

    // 工资增加了
    public abstract void up(ISalary _salary);

    // 工资降低了
    public abstract void down(ISalary _salary);

    // 职位提升了
    public abstract void up(IPosition _position);

    // 职位降低了
    public abstract void down(IPosition _position);

    // 税收增加了
    public abstract void up(ITax _tax);

    //  税收降低了
    public abstract void down(ITax _tax);
}