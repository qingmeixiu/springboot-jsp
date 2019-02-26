package com.sinaif.hoover.jfireel.node;

import java.util.Map;
import com.sinaif.hoover.jfireel.CalculateType;
import com.sinaif.hoover.jfireel.DefaultKeyWord;
import com.sinaif.hoover.jfireel.KeyWord;

public class KeywordNode implements CalculateNode
{
	private Object	keywordValue;
	private KeyWord	keyWord;
	
	public KeywordNode(String literals)
	{
		keyWord = DefaultKeyWord.getDefaultKeyWord(literals);
		if (literals.equalsIgnoreCase("true"))
		{
			keywordValue = Boolean.TRUE;
		}
		else if (literals.equalsIgnoreCase("false"))
		{
			keywordValue = Boolean.FALSE;
		}
		else if (literals.equalsIgnoreCase("null"))
		{
			keywordValue = null;
		}
		else
		{
			throw new IllegalArgumentException();
		}
	}
	
	@Override
	public Object calculate(Map<String, Object> variables)
	{
		return keywordValue;
	}
	
	@Override
	public CalculateType type()
	{
		return keyWord;
	}
	
	@Override
	public String toString()
	{
		return "KeywordNode [keywordValue=" + keywordValue + ", keyWord=" + keyWord + "]";
	}
	
}
