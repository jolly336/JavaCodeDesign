package com.nelson.design.command_chain.command_name.df;

import com.nelson.design.command_chain.CommandVO;
import com.nelson.design.command_chain.command_name.os.DiskManager;

/**
 * @author cbf4Life cbf4life@126.com
 * I'm glad to share my knowledge with you all.
 */
public class DF_K extends AbstractDF {
    //定义一下自己能处理什么参数
    protected String getOperateParam() {
        return super.K_PARAM;
    }

    //命令处理
    protected String echo(CommandVO vo) {
        return DiskManager.df_k();
    }
}