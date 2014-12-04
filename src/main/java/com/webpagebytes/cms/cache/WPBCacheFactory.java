/*
 *   Copyright 2014 Webpagebytes
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

package com.webpagebytes.cms.cache;

import com.webpagebytes.cms.appinterfaces.WPBArticlesCache;
import com.webpagebytes.cms.appinterfaces.WPBFilesCache;
import com.webpagebytes.cms.appinterfaces.WPBMessagesCache;
import com.webpagebytes.cms.appinterfaces.WPBParametersCache;
import com.webpagebytes.cms.appinterfaces.WPBProjectCache;
import com.webpagebytes.cms.appinterfaces.WPBUrisCache;
import com.webpagebytes.cms.appinterfaces.WPBPageModulesCache;
import com.webpagebytes.cms.appinterfaces.WPBWebPagesCache;

public interface WPBCacheFactory {
	public WPBUrisCache getUrisCacheInstance();
	public WPBWebPagesCache getWebPagesCacheInstance();
	public WPBPageModulesCache getPageModulesCacheInstance();
	public WPBParametersCache getParametersCacheInstance();
	public WPBFilesCache getFilesCacheInstance();
	public WPBArticlesCache getArticlesCacheInstance();
	public WPBMessagesCache getMessagesCacheInstance();
	public WPBProjectCache getProjectCacheInstance();
	
}
