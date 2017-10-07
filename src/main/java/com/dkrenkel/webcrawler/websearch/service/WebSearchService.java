/**
 * 
 */
package com.dkrenkel.webcrawler.websearch.service;

import java.io.IOException;
import java.util.List;

/**
 * @author David Krenkel <david.melo1992@gmail.com>
 *
 */
public interface WebSearchService {

	List<String> searchPagesForTerm(String searchTerm) throws IOException;
	
}
