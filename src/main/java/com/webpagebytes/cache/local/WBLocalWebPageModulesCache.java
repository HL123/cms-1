package com.webpagebytes.cache.local;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.webpagebytes.cache.WBWebPageModulesCache;
import com.webpagebytes.cmsdata.WBArticle;
import com.webpagebytes.cmsdata.WBWebPageModule;
import com.webpagebytes.datautility.AdminDataStorage;
import com.webpagebytes.datautility.AdminDataStorageFactory;
import com.webpagebytes.exception.WBIOException;

public class WBLocalWebPageModulesCache implements WBWebPageModulesCache {
	
	private AdminDataStorage dataStorage;
	private Map<String, WBWebPageModule> localCacheByID;
	private Map<String, WBWebPageModule> localCacheByName;
	private static final Object lock = new Object();
	public WBLocalWebPageModulesCache()
	{
		dataStorage = AdminDataStorageFactory.getInstance();
		try
		{
			if (dataStorage != null)
			{
				Refresh();
			}
		} catch (WBIOException e)
		{
			
		}
	}
	public WBWebPageModule getByExternalKey(String externalKey) throws WBIOException
	{
		if (localCacheByID != null)
		{
			return localCacheByID.get(externalKey);
		}
		return null;
	}

	@Override
	public void Refresh() throws WBIOException {
		synchronized (lock)
		{
			Map<String, WBWebPageModule> tempMapByID = new HashMap<String, WBWebPageModule>();
			Map<String, WBWebPageModule> tempMapByName = new HashMap<String, WBWebPageModule>();
			
			List<WBWebPageModule> recList = dataStorage.getAllRecords(WBWebPageModule.class);
			for(WBWebPageModule item: recList)
			{
				tempMapByID.put(item.getExternalKey(), item);
				tempMapByName.put(item.getName(), item);
			}
			localCacheByID = tempMapByID;
			localCacheByName = tempMapByName;
		}
		
	}

		
	public WBWebPageModule get(String moduleName) throws WBIOException
	{
		if (localCacheByName != null)
		{
			return localCacheByName.get(moduleName);
		}
		return null;
	}
	
}