package pk.behavior.command_vs_strategy.strategy;

/**
 * @author cbf4Life cbf4life@126.com
 * I'm glad to share my knowledge with you all.
 */
public class Zip implements Algorithm {

    //zip格式的压缩算法
    @Override
    public boolean compress(String source, String to) {
        System.out.println(source + " --> " + to + " ZIP压缩成功!");
        return true;
    }

    //zip格式的解压缩算法
    @Override
    public boolean uncompress(String source, String to) {
        System.out.println(source + " --> " + to + " ZIP解压缩成功!");
        return true;
    }
}
