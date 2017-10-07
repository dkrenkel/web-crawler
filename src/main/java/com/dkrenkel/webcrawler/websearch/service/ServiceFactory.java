/**
 * 
 */
package com.dkrenkel.webcrawler.websearch.service;

import com.dkrenkel.webcrawler.websearch.service.impl.GoogleSearchService;
import com.dkrenkel.webcrawler.websearch.service.impl.HtmlWebPageService;

/**
 * @author David Krenkel <david.melo1992@gmail.com>
 *
 */
public class ServiceFactory {

	private static WebSearchService webSearchService;
	private static WebPageService webPageService;
	
	public static WebSearchService getWebSearchService() {
		if (webSearchService == null) {
			webSearchService = new GoogleSearchService();
		}
		return webSearchService;
	}
	
	public static WebPageService getWebPageService() {
		if (webPageService == null) {
			webPageService = new HtmlWebPageService();
		}
		return webPageService;
	}
}
