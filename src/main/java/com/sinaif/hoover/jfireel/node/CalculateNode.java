package com.sinaif.hoover.jfireel.node;

import java.util.Map;
import com.sinaif.hoover.jfireel.CalculateType;

public interface CalculateNode
{
    
    Object calculate(Map <String, Object> variables);
    
    CalculateType type();
}
