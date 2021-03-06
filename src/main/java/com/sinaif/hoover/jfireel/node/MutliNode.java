package com.sinaif.hoover.jfireel.node;

import java.util.Map;
import com.sinaif.hoover.jfireel.Operator;

public class MutliNode extends OperatorResultNode
{
	
	public MutliNode()
	{
		super(Operator.MULTI);
	}
	
	@Override
	public Object calculate(Map<String, Object> variables)
	{
		Object leftValue = leftOperand.calculate(variables);
		if (leftValue == null)
		{
			return null;
		}
		Object rightValue = rightOperand.calculate(variables);
		if (rightValue == null)
		{
			return null;
		}
		if (leftValue instanceof Double || rightValue instanceof Double)
		{
			return ((Number) leftValue).doubleValue() * ((Number) rightValue).doubleValue();
		}
		else
		{
			return ((Number) leftValue).longValue() * ((Number) rightValue).longValue();
		}
	}
	
}
