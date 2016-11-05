# PageRank-Aglorithm-for-Apache-Solr-Search

**Tasks and Tools Description:**

•	Initial task was to install Apache Solr and perform indexing.
•	For this task I created ‘newsexample’ core inside the Solr directory and indexed pages from the ABCNews site and FoxNews site. (as assigned for input)
•	For indexing the managed-schema file where changed to remove the exceptions like NumberFormat, Invalid Date, etc.
•	The next task was to create the external page rank file. For this purpose JSOUP library was used to loop over each file in the input directory containing html files. jsoup is a Java library for working with real-world HTML. It provides a very convenient API for extracting and manipulating data, using the best of DOM, CSS, and jquery-like methods. 
•	A java program using JSOUP generated edge list of files which is used by used networkx to generate PageRank for each data.  I called pageRank method of networkx to generate pageRank values for documents and wrote these values to ‘external_PageRank.txt’ file using python code. 
•	The parameters used for creating graph are ( alpha=0.85, personalization=None, max_iter=30, tol=1e-06, nstart=None, weight='weight',dangling=None ).
•	The IDEs used for java was Eclipse and PyDev for Python.
•	The output “external_PageRankFile” is then inserted inside the data folder of my core ‘newesexample’.
•	The next task was create Web server for querying the solr. The Web server is Apache server and uses PHP file named “homepage.php” for developing webpages. The PHP file calls the Solr PHP Client for querying the solr.
•	There are two options on the php page along with the search box. These radio buttons are used to specify if the user wants inbuilt search or the page rank results for the solr search.
•	For pagerank results the query to the solr is sent along with parameter “sort=pageRankFile desc” to indicate the Solr that it should use the external pagerank file for the search.
•	When the results are displayed, each record contains four fields, viz. , Id, url, description and title of the indexed page.

**Analysis of PageRank (PR) Algorithm:**

•	The PR of each page depends on the PR of the pages pointing to it and the outgoing links the page has. What that means to us is that we can just go ahead and calculate a page’s PR without knowing the final value of the PR of the other pages. That seems strange but, basically, each time we run the calculation we’re getting a closer estimate of the final value. 
•	As we add more internal links in a site, the PR will be spread out more evenly between the pages. Important, high-quality sites receive a higher PageRank.
•	 From the results it is observed that the PR algorithm returns pages with high rank but are not so relevant to the search query.
•	It’s probably better to get lots (perhaps thousands) of links from sites with small PR than to spend any time or money desperately trying to get just the one link from a high PR page. Of course, important pages mean nothing to you if they don’t match your query.

**Overlapping:**

As we can see there is not much overlapping between the two algorithms. This is because some pages having high page rank are irrelevant to the query.


Queries					    Overlap <br>
NATO	         				2<br>
Dow Jones					    0<br>
Rio Olympics				  0<br>
Pokemon Go				    0<br>
California Wild Fires	2<br>
Donald Trump				  1<br>
Harry Potter					0<br>
Brazil							  3<br>
