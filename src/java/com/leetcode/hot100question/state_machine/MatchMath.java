package com.leetcode.hot100question.state_machine;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jiang
 */
public class MatchMath {
    //配置有效状态机，每一个位置可能的类型
    Map[] machine = {new HashMap(){
        {
            put(' ',0);
            put('d',1);
        }
    }};

    public boolean isNumber(String s) {
        return false;
    }
}
