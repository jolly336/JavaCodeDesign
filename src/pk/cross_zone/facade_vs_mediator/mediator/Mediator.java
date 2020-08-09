package pk.cross_zone.facade_vs_mediator.mediator;

/**
 * 中介者
 * <p>
 * Created by Nelson on 2020/8/9.
 */
public class Mediator extends AbsMediator {

    @Override
    public void up(ISalary _salary) {
        upSalary();
        upTax();
    }

    @Override
    public void down(ISalary _salary) {
        downSalary();
        downTax();
    }

    @Override
    public void up(IPosition _position) {
        upPosition();
        upSalary();
        upTax();
    }

    @Override
    public void down(IPosition _position) {
        downPosition();
        downSalary();
        downTax();
    }

    @Override
    public void up(ITax _tax) {
        upTax();
        downSalary();
    }

    @Override
    public void down(ITax _tax) {
        downTax();
        upSalary();
    }

    private void upSalary() {
        System.out.println("工资翻倍，乐翻天");
    }

    private void upTax() {
        System.out.println("税收上升，为国家做贡献");
    }

    private void upPosition() {
        System.out.println("职位上升一级，狂喜");
    }

    private void downSalary() {
        System.out.println("经济不景气，降低工资");
    }

    private void downTax() {
        System.out.println("税收减少，国家收入减少");
    }

    private void downPosition() {
        System.out.println("官降三级，比自杀还痛苦");
    }
}