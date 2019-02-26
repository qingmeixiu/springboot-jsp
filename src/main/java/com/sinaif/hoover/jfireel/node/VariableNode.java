package com.sinaif.hoover.jfireel.node;

import com.sinaif.hoover.jfireel.CalculateType;
import com.sinaif.hoover.jfireel.Expression;

import java.util.Map;

public class VariableNode implements CalculateNode
{
	private String literals;
	
	public VariableNode(String literals)
	{
		this.literals = literals;
	}
	
	@Override
	public Object calculate(Map<String, Object> variables)
	{
		return variables.get(literals);
	}
	
	@Override
	public CalculateType type()
	{
		return Expression.VARIABLE;
	}
	
	@Override
	public String toString()
	{
		return "VariableNode [literals=" + literals + "]";
	}
	
}
