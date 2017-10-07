/**
 * 
 */
package com.dkrenkel.webcrawler.facade.impl;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.dkrenkel.webcrawler.facade.WebCrawlerFacade;
import com.dkrenkel.webcrawler.websearch.service.ServiceFactory;
import com.dkrenkel.webcrawler.websearch.service.WebPageService;
import com.dkrenkel.webcrawler.websearch.service.WebSearchService;

/**
 * @author David Krenkel <david.melo1992@gmail.com>
 *
 */
public class GoogleWebCrawlerFacade implements WebCrawlerFacade {
	
	private WebSearchService webSearchService = ServiceFactory.getWebSearchService();
	private WebPageService webPageService = ServiceFactory.getWebPageService();
	private Set<String> libraries = new HashSet<String>();

	public void searchForTerm(String searchTerm) throws IOException {
		List<String> resultPages = webSearchService.searchPagesForTerm(searchTerm);
		for (String urlPage : resultPages) {
			libraries.addAll(webPageService.getJsLibraries(urlPage));
		}
	}

	public Set<String> getMostUsedLibs() {
		return libraries;
	}
	
}

