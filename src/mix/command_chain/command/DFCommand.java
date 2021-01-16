package mix.command_chain.command;

import mix.command_chain.CommandVO;
import mix.command_chain.command_name.df.AbstractDF;

/**
 * @author cbf4Life cbf4life@126.com
 * I'm glad to share my knowledge with you all.
 */
public class DFCommand extends Command {

    public String execute(CommandVO vo) {
        return super.buildChain(AbstractDF.class).get(0).handleMessage(vo);
    }

}