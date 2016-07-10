package com.jwd.net.model;

import java.util.Date;

public class DevEventUpdate
{
	private	Integer	id;
	private	String	text;
	private	Date	added;
	
	public DevEventUpdate(String text)
	{
		this.text = text;
	}
	
	public DevEventUpdate(String text, Date added)
	{
		this.text = text;
		this.added = added;
	}

	public Integer getId()
	{
		return id;
	}
	
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public String getText()
	{
		return text;
	}
	
	public void setText(String text)
	{
		this.text = text;
	}
	
	public Date getAdded()
	{
		return added;
	}
	
	public void setAdded(Date added)
	{
		this.added = added;
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((added == null) ? 0 : added.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DevEventUpdate other = (DevEventUpdate) obj;
		if (added == null)
		{
			if (other.added != null)
				return false;
		} else if (!added.equals(other.added))
			return false;
		if (id == null)
		{
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (text == null)
		{
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}
}
