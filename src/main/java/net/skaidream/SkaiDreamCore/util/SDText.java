package net.skaidream.SkaiDreamCore.util;

public class SDText
{
	protected static SDMessage message;
	public SDText()
	{
		message = new SDMessageImpl();
	}
	
	public static MessageType send(Object obj, String msg, Object... args)
	{
		return message.sendFixedMessage(obj, msg, args);
	}
	
	public static MessageType sendGlobal(Object obj, String msg, Object... args)
	{
		return message.sendGeneralFixedMessage(obj, msg, args);
	}
}
