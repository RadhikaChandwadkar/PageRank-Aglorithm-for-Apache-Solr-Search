import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Example program to list links from a URL.
 */
public class ListLinks {
   
   public static  Map<String,String> webpageURLMapping=new HashMap<>();
   public static  Map<String,String> URLwebpageMapping=new HashMap<>();
   public static void main(String[] args) throws IOException {
       
   	   // Validate.isTrue(args.length == 1, "usage: supply url to fetch");
		File files[]=new File("f:/crawl_data").listFiles();
		
		loadMappingFile();
		FileWriter edges=new FileWriter(new File("edges.txt"));
		for(File file:files)
		{
			String name=file.getName();
			if(name.endsWith(".txt"))
				continue;
     		String url = webpageURLMapping.get(name);
            print("Fetching %s...", url);

        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select("a[href]");
        Elements media = doc.select("[src]");
        Elements imports = doc.select("link[href]");

        print("\nMedia: (%d)", media.size());
        String filename;
        for (Element src : media) 
        {
            if (src.tagName().equals("img"))
			{
				continue;
			}
            else
			{
			    //print(" * %s: <%s>", src.tagName(), );
				String linkURL=src.attr("abs:src");
				if((filename=searchOutGoingLinks(linkURL))!=null)
				{
						edges.write(url+" "+filename);
						edges.write("\r\n");
				}
			}
            
        }

        print("\nImports: (%d)", imports.size());
        for (Element link : imports)
        {
   
		   String linkURL=link.attr("abs:href");
		  
				if((filename=searchOutGoingLinks(linkURL))!=null)
				{

					edges.write(url+" "+filename);
					edges.write("\r\n");
				
				}

		   //print(" * %s <%s> (%s)", link.tagName(),link.attr("abs:href"), link.attr("rel"));
       

	   }

        print("\nLinks: (%d)", links.size());
        for (Element link : links) 
		{
           // print(" * a: <%s>  (%s)", link.attr("abs:href"), trim(link.text(), 35));
		     String linkURL=link.attr("abs:href");
				if((filename=searchOutGoingLinks(linkURL))!=null)
				{
				

					edges.write(url+" "+filename);
					edges.write("\r\n");
				}
		   
        }
	}
  }

    private static void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }

	
	public static String searchOutGoingLinks(String link)
	{
	
			if(URLwebpageMapping.containsKey(link))
			{
					return URLwebpageMapping.get(link);
			}
			else
				return null;
	}
	
	
	public static void loadMappingFile() throws IOException
	{
	            BufferedReader br = new BufferedReader(new FileReader("mapABCNewsFile.csv"));
	            //br.readLine();
	            String line;
	            while ((line = br.readLine()) != null) 
				{
					String cols[]=line.split(",");
					webpageURLMapping.put(cols[0],cols[1]);
					
					URLwebpageMapping.put(cols[1],cols[0]);
					
				}
				br = new BufferedReader(new FileReader("mapFoxNewsFile.csv"));
	            //br.readLine();
	            while ((line = br.readLine()) != null) 
				{
					String cols[]=line.split(",");
					webpageURLMapping.put(cols[0],cols[1]);
					
					URLwebpageMapping.put(cols[1],cols[0]);
				}
	}
	

}