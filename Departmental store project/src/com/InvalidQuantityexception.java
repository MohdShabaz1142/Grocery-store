package com;

public class InvalidQuantityexception  extends RuntimeException
{
private String message;




public InvalidQuantityexception(String message)
{
	this.message=message;
}

public String getMessage()
{
	return message;
}



}
