package com.sinaif.hoover.jfireel.node;

import com.sinaif.hoover.jfireel.CalculateType;
import com.sinaif.hoover.jfireel.Operator;

import java.util.Map;

public class OperatorNode implements CalculateNode
{
	private Operator operatorType;
	
	public OperatorNode(Operator operatorType)
	{
		this.operatorType = operatorType;
	}
	
	// 操作符节点不会有计算动作
	@Override
	public Object calculate(Map<String, Object> variables)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public CalculateType type()
	{
		return operatorType;
	}
	
}
