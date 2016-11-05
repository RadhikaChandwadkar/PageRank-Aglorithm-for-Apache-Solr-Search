import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CreateMap 
{
    public static void main(String[] args)
    {
    	   String csvFile = "mapABCNewsFile.csv";
           String csvFile1 = "mapFoxNewsFile.csv";
        
        
        BufferedReader br = null,br1=null;
        String line = "";
        String cvsSplitBy = ",";
        
        HashMap<String,String> fileurlMap = new HashMap<String,String>();
        
        int c=0;
       try 
       {
            
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) 
            {
                c++;
                String[] perline = line.split(cvsSplitBy);
                String key = perline[0];
                String value = perline[1];

               fileurlMap.put(key, value);
                    
         

            }
       }
       catch (FileNotFoundException e) 
       {
            e.printStackTrace();
       }
       catch (IOException e) 
       {
            e.printStackTrace();
       } 
       finally
       {
        
            if (br != null)
            {
                try
                {
                    br.close();
                } 
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
       }
       
       //end of reading file1
       try 
       {
            
            br1 = new BufferedReader(new FileReader(csvFile1));
            while ((line = br1.readLine()) != null) 
            {
                
                String[] perline = line.split(cvsSplitBy);
                String key = perline[0];
                String value = perline[1];

               fileurlMap.put(key, value);
                    
               c++;

            }
       }
       catch (FileNotFoundException e) 
       {
            e.printStackTrace();
       }
       catch (IOException e) 
       {
            e.printStackTrace();
       } 
       finally
       {
        
            if (br1 != null)
            {
                try
                {
                    br1.close();
                } 
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
       }
       for(Map.Entry<String, String> map : fileurlMap.entrySet())
       {
           System.out.println("key -->"+map.getKey()+"    value:-->"+map.getValue());
       }
   
       System.out.println("count"+c);
    }
    public HashMap<String,String> fileToUrl()
    {
    	   String csvFile = "mapABCNewsFile.csv";
           String csvFile1 = "mapFoxNewsFile.csv";
        
        BufferedReader br = null,br1=null;
        String line = "";
        String cvsSplitBy = ",";
        
        HashMap<String,String> fileurlMap = new HashMap<String,String>();
        
       int c=0;
       try 
       {
            
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) 
            {
                c++;
                String[] perline = line.split(cvsSplitBy);
                String key = perline[0];
                String value = perline[1];

               fileurlMap.put(key, value);
                    
         

            }
       }
       catch (FileNotFoundException e) 
       {
            e.printStackTrace();
       }
       catch (IOException e) 
       {
            e.printStackTrace();
       } 
       finally
       {
        
            if (br != null)
            {
                try
                {
                    br.close();
                } 
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
       }
       
       //end of reading file1
       try 
       {
            
            br1 = new BufferedReader(new FileReader(csvFile1));
            while ((line = br1.readLine()) != null) 
            {
                
                String[] perline = line.split(cvsSplitBy);
                String key = perline[0];
                String value = perline[1];

               fileurlMap.put(key, value);
                    
               c++;

            }
       }
       catch (FileNotFoundException e) 
       {
            e.printStackTrace();
       }
       catch (IOException e) 
       {
            e.printStackTrace();
       } 
       finally
       {
        
            if (br1 != null)
            {
                try
                {
                    br1.close();
                } 
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
       }
       for(Map.Entry<String, String> map : fileurlMap.entrySet())
       {
          // System.out.println("key -->"+map.getKey()+"    value:-->"+map.getValue());
       }
   
       System.out.println("count for file to url"+c);
       return fileurlMap;
    }
    
    public HashMap<String,String> urlToFile()
    {
        String csvFile = "mapABCNewsFile.csv";
        String csvFile1 = "mapFoxNewsFile.csv";
        
        BufferedReader br = null,br1=null;
        String line = "";
        String cvsSplitBy = ",";
        
        HashMap<String,String> fileurlMap = new HashMap<String,String>();
        
        int c=0;
       try 
       {
            
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) 
            {
                c++;
                String[] perline = line.split(cvsSplitBy);
                String key = perline[1];
                String value = perline[0];

               fileurlMap.put(key, value);
                    
         

            }
       }
       catch (FileNotFoundException e) 
       {
            e.printStackTrace();
       }
       catch (IOException e) 
       {
            e.printStackTrace();
       } 
       finally
       {
        
            if (br != null)
            {
                try
                {
                    br.close();
                } 
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
       }
       
       //end of reading file1
       try 
       {
            
            br1 = new BufferedReader(new FileReader(csvFile1));
            while ((line = br1.readLine()) != null) 
            {
                
                String[] perline = line.split(cvsSplitBy);
                String key = perline[1];
                String value = perline[0];

               fileurlMap.put(key, value);
                    
               c++;

            }
       }
       catch (FileNotFoundException e) 
       {
            e.printStackTrace();
       }
       catch (IOException e) 
       {
            e.printStackTrace();
       } 
       finally
       {
        
            if (br1 != null)
            {
                try
                {
                    br1.close();
                } 
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
       }
       for(Map.Entry<String, String> map : fileurlMap.entrySet())
       {
          // System.out.println("key -->"+map.getKey()+"    value:-->"+map.getValue());
       }
   
       System.out.println("count for url to file"+c);
       return fileurlMap;
    }
}