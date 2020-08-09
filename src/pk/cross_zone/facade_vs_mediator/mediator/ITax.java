package pk.cross_zone.facade_vs_mediator.mediator;

/**
 * Created by Nelson on 2020/8/9.
 */
public interface ITax {

    // 税收上升
    public void raise();

    // 税收下降
    public void drop();
}