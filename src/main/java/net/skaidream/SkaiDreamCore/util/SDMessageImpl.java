package net.skaidream.SkaiDreamCore.util;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import net.skaidream.SkaiDreamCore.plugin.SkaiDreamPlugin;

public class SDMessageImpl extends SDAbstractSender implements Prefix
{
	/**
	 * 
	 */
	protected final String REPLACE_VALUE;
	/**
	 * If the type null of the last argument to the method, 
	 * It pass individual arguments of type Object for a varargs invocation.
	 */
	protected final String NO_ARGUMENT_TYPE;
	
	//protected final String PREFIX_FORMAT;
	
	public SDMessageImpl()
	{
		this.REPLACE_VALUE = "\\<v\\>";
		this.NO_ARGUMENT_TYPE = "NULL";
	}
	
	public SDMessageImpl(String rel)
	{
		this.REPLACE_VALUE = rel;
		this.NO_ARGUMENT_TYPE = "NULL";
	}
	
	public SDMessageImpl(String rel, String nullType)
	{
		this.REPLACE_VALUE = rel;
		this.NO_ARGUMENT_TYPE = nullType;
		
	}
	
	public SDMessageImpl(Class<? extends SkaiDreamPlugin> clazz)
	{
		this.REPLACE_VALUE = "\\<v\\>";
		this.NO_ARGUMENT_TYPE = "NULL";
	}
	
	public SDMessageImpl(String rel, String nullType, Class<? extends SkaiDreamPlugin> clazz)
	{
		this.REPLACE_VALUE = rel;
		this.NO_ARGUMENT_TYPE = nullType;
	}

	@Override
	public MessageType sendMessage(Player player, String message)
	{
		return this.sendFixedMessage(player, message, NO_ARGUMENT_TYPE);
	}

	@Override
	public MessageType sendMessage(CommandSender sender, String message)
	{
		return this.sendFixedMessage(sender, message, NO_ARGUMENT_TYPE);
	}

	@Override
	public MessageType sendMessage(ConsoleCommandSender sender, String message)
	{
		return this.sendFixedMessage(sender, message, NO_ARGUMENT_TYPE);
	}

	@Override
	public MessageType sendFixedMessage(Object obj, String message)
	{
		return this.sendFixedMessage(obj, message, NO_ARGUMENT_TYPE);
	}

	@Override
	public MessageType sendFixedMessage(Object obj, String message, Object... args)
	{
		if(!(obj instanceof CommandSender)) throw new NullPointerException("Please check the object sender type");
		if(obj instanceof Player)
		{
			Player mediator =  (Player)obj;
			ArrayList<Object> mList = new ArrayList<Object>(Arrays.asList(args));
			if(! (args.length == 1 && args[0] instanceof String 
					&& ((String) args[0]).equalsIgnoreCase(this.NO_ARGUMENT_TYPE)))
			{
				while(message.matches(REPLACE_VALUE))
				{
					Object value = mList.get(0);
					if(value instanceof Number)
					{
						String valueStr = String.valueOf((Number)value);
						message = message.replaceFirst(REPLACE_VALUE, valueStr);
					}
					else if(value instanceof String)
					{
						String valueStr = (String)value;
						message = message.replaceFirst(REPLACE_VALUE, valueStr);
					}
					mList.remove(0);
					args = mList.toArray();
				}
				mediator.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
				return new MessageType(obj, message);
			}
		}
		else if(obj instanceof ConsoleCommandSender)
		{
			ConsoleCommandSender mediator = (ConsoleCommandSender) obj;
			ArrayList<Object> mList = new ArrayList<Object>(Arrays.asList(args));
			if(! (args.length == 1 && args[0] instanceof String 
					&& ((String) args[0]).equalsIgnoreCase(this.NO_ARGUMENT_TYPE)))
			{
				while(message.matches(REPLACE_VALUE))
				{
					Object value = mList.get(0);
					if(value instanceof Number)
					{
						String valueStr = String.valueOf((Number)value);
						message = message.replaceFirst(REPLACE_VALUE, valueStr);
					}
					else if(value instanceof String)
					{
						String valueStr = (String)value;
						message = message.replaceFirst(REPLACE_VALUE, valueStr);
					}
					mList.remove(0);
					args = mList.toArray();
				}
			}
			mediator.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
			return new MessageType(obj, message);
		}
		throw new NullPointerException("Unsupported sender type");
	}

	@Override
	public MessageType sendGeneralMessage(Player sender, String message) 
	{
		return this.sendFixedMessage(sender, message, NO_ARGUMENT_TYPE);
	}

	@Override
	public MessageType sendGeneralMessage(CommandSender sender, String message) 
	{
		return this.sendFixedMessage(sender, message, NO_ARGUMENT_TYPE);
	}

	@Override
	public MessageType sendGeneralMessage(ConsoleCommandSender sender, String message) 
	{
		return this.sendFixedMessage(sender, message, NO_ARGUMENT_TYPE);
	}

	@Override
	public MessageType sendGeneralFixedMessage(Object obj, String message)
	{
		return this.sendFixedMessage(obj, message, NO_ARGUMENT_TYPE);
	}

	@Override
	public MessageType sendGeneralFixedMessage(Object arg0, String arg1, Object... args)
	{
		return null;
	}

	@Override
	public MessageType sendLogMessage(String arg0, Object... args)
	{
		return null;
	}
}
