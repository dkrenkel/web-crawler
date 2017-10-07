/**
 * 
 */
package com.dkrenkel.webcrawler.facade;

import com.dkrenkel.webcrawler.facade.impl.GoogleWebCrawlerFacade;

/**
 * @author David Krenkel <david.melo1992@gmail.com>
 *
 */
public class FacadeFactory {
	
	private static WebCrawlerFacade webCrawlerFacade;

	public static WebCrawlerFacade getWebCrawlerFacade() {
		if (webCrawlerFacade == null) {
			webCrawlerFacade = new GoogleWebCrawlerFacade();
		}
		return webCrawlerFacade; 
	}
}
