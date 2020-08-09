package pk.cross_zone.facade_vs_mediator.mediator;

/**
 * 中介者模式 mediator
 * <p>
 * Created by Nelson on 2020/8/9.
 */
public class Client {

    public static void main(String[] args) {
        // 定义中介者
        Mediator mediator = new Mediator();
        // 定义各个同事类
        IPosition position = new Position(mediator);
        ISalary salary = new Salary(mediator);
        ITax tax = new Tax(mediator);
        // 职位提升了
        System.out.println("====职位提升===");
        position.promote();
    }
}