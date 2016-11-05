import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ExtractLinks
{
    public static void main(String[] args) throws IOException
    {
        /*String path = "/Users/mac/Documents/FALL2016/CSCI572/Assignment/Assignment3/NYTimesBBCNewsDownlaodData/sinnglefolder";
        File file  = new File("/Users/mac/Documents/FALL2016/CSCI572/abc.html");
        String h = path +"/720c608b-8301-4b9c-9487-e0215d078527.html";
        File f = new File("abc.com");
        //Document doc = Jsoup.parse(f,"UTF-8","http://www.nytimes.com/");
        Document doc = Jsoup.parse(file,"UTF-8","http://www.abcnews.go.com/");
        
        Elements links = doc.select("a[href]");
        Elements media = doc.select("[src]");
        Elements imports = doc.select("link[href]");
        
        
        System.out.println("Media size "+media.size());
        
        for(Element src : media)
        {
            if(src.tagName().equals("img"))
                System.out.println(src.tagName() +"  "+src.attr("abs:src")+"  "+ src.attr("width")+"  "+src.attr("height"));
            else
                System.out.println(src.tagName() +"  "+src.attr("abs:src"));
                
        }
        System.out.println("\n \n \nLinks size "+links.size());
        for(Element link: links)
            System.out.println(link.attr("abs:href")+"  "+link.text());
        
        System.out.println("\n\n\nImports size "+imports.size());
        for(Element link: imports)
            System.out.println(link.tagName()+"  "+link.attr("abs:href")+"  "+link.attr("rel"));*/
        
        CreateMap cm = new CreateMap();
        HashMap<String,String> fileUrlMap,urlFileMap;
        fileUrlMap = cm.fileToUrl();
        urlFileMap = cm.urlToFile();
        
        
        String dirPath = "f:/crawl_data";
        File dir = new File(dirPath);
        Set<String> edges =  new HashSet<String>();
        
        for(File file :dir.listFiles())
        {
        	System.out.println("reading "+file.getName());
            if(fileUrlMap.get(file.getName()) !=null)
            {
                Document doc = Jsoup.parse(file,"UTF-8",fileUrlMap.get(file.getName()));
                Elements links = doc.select("a[href]");
                Elements png = doc.select("[src]");
                
                for(Element link : links)
                {
                    String url = link.attr("href").trim();
                    if(urlFileMap.containsKey(url))
                    {
                        edges.add(file.getName()+"   "+ urlFileMap.get(url));
                    }
                }
            }
        }
        
        FileWriter f1 = new FileWriter("edgeList.txt");
        for(String s:edges)
        {
        	System.out.println("Writing "+s);
            f1.append(s);
            f1.append("\n");
        }
        f1.close();
        
    }
    
  
}