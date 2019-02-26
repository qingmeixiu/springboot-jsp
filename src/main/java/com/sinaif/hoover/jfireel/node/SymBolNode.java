package com.sinaif.hoover.jfireel.node;

import java.util.Map;
import com.sinaif.hoover.jfireel.CalculateType;
import com.sinaif.hoover.jfireel.Symbol;
import com.sinaif.hoover.jfireel.CalculateType;

public class SymBolNode implements CalculateNode
{
	
	private Symbol symbol;
	
	public SymBolNode(Symbol symbol)
	{
		this.symbol = symbol;
	}
	
	// 符号节点没有参数计算
	@Override
	public Object calculate(Map<String, Object> variables)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public CalculateType type()
	{
		return symbol;
	}
	
	@Override
	public String toString()
	{
		return "SymBolNode [symbol=" + symbol + "]";
	}
	
}
