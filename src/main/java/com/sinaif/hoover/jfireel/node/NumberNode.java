package com.sinaif.hoover.jfireel.node;

import java.util.Map;
import com.sinaif.hoover.jfireel.CalculateType;
import com.sinaif.hoover.jfireel.Expression;
import com.sinaif.hoover.jfireel.CalculateType;

public class NumberNode implements CalculateNode
{
	private Number value;
	
	public NumberNode(String literals)
	{
		if (literals.indexOf('.') > -1)
		{
			value = Double.valueOf(literals);
		}
		else
		{
			value = Long.valueOf(literals);
		}
	}
	
	@Override
	public Object calculate(Map<String, Object> variables)
	{
		return value;
	}
	
	@Override
	public CalculateType type()
	{
		return Expression.NUMBER;
	}

	@Override
	public String toString()
	{
		return "NumberNode [value=" + value + "]";
	}
	
}
