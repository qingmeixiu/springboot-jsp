package com.sinaif.hoover.jfireel.node;

import com.sinaif.hoover.jfireel.CalculateType;
import com.sinaif.hoover.jfireel.Expression;

import java.util.Map;

public class StringNode implements CalculateNode
{
	private String literals;
	
	public StringNode(String literals)
	{
		this.literals = literals;
	}
	
	@Override
	public Object calculate(Map<String, Object> variables)
	{
		return literals;
	}
	
	@Override
	public CalculateType type()
	{
		return Expression.STRING;
	}
	
	@Override
	public String toString()
	{
		return "StringNode [literals=" + literals + "]";
	}
	
}
