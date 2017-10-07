/**
 * 
 */
package com.dkrenkel.webcrawler.facade;

import java.io.IOException;
import java.util.Set;

/**
 * @author David Krenkel <david.melo1992@gmail.com>
 *
 */
public interface WebCrawlerFacade {

	void searchForTerm(String searchTerm) throws IOException;
	
	Set<String> getMostUsedLibs();

}
