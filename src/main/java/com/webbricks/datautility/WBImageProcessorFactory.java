package com.webbricks.datautility;

import com.webbricks.utility.WBConfiguration;
import com.webbricks.utility.WBConfigurationFactory;
import com.webbricks.utility.WBConfiguration.SECTION;

public class WBImageProcessorFactory {

	private static WBImageProcessor instance;
	private static final Object lock = new Object();

	public static WBImageProcessor getInstance()
	{
		if (instance == null) 
		{
			synchronized (lock) {
				WBConfiguration config = WBConfigurationFactory.getConfiguration();
				String factoryClass = "";
				if (config!=null)
				{
					factoryClass = config.getSectionClassFactory(SECTION.SECTION_IMAGEPROCESSOR);
				}
				try
				{
					instance = (WBImageProcessor) Class.forName(factoryClass).newInstance();
					return instance;
				} 
				
				catch (Exception e)
				{
					return null;
				}				
			}
		}
		return instance;
	}
	
}