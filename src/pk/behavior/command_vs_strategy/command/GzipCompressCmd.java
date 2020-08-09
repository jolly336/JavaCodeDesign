package pk.behavior.command_vs_strategy.command;

/**
 * @author cbf4Life cbf4life@126.com
 * I'm glad to share my knowledge with you all.
 */
public class GzipCompressCmd extends AbstractCmd {

    @Override
    public boolean execute(String source, String to) {
        return super.compress.gzipExec(source, to);
    }
}

