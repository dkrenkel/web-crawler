package com.dkrenkel.webcrawler.app;

import java.io.IOException;

import com.dkrenkel.webcrawler.facade.FacadeFactory;
import com.dkrenkel.webcrawler.facade.WebCrawlerFacade;

/**
 * Application Main Class
 * 
 * @author David Krenkel <david.melo1992@gmail.com>
 *
 */
public class App {
	
	private static WebCrawlerFacade webCrawlerFacade = FacadeFactory.getWebCrawlerFacade();
	
	public static void main(String[] args) throws IOException {
		String searchTerm = String.join("+", args);
		webCrawlerFacade.searchForTerm(searchTerm);
		
		System.out.println(webCrawlerFacade.getMostUsedLibs());
	}
}
