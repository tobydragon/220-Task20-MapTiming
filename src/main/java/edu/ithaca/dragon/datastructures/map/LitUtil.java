package edu.ithaca.dragon.datastructures.map;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

import bridges.data_src_dependent.GutenbergBook;

public class LitUtil {
    public static List<String> retrieveBookTexts(List<GutenbergBook> gutenbergMetadata){ 
        return gutenbergMetadata.stream().parallel().map((work)-> work.getURL()).map((url)-> url.replace("https://www.gutenberg.org/ebooks/", ""))
            .map((bookId)-> "https://www.gutenberg.org/files/"+bookId+"/"+bookId+"-0.txt" ).map((contentUrl)-> {
                try{
                    return new BufferedReader(new InputStreamReader(new URL(contentUrl).openStream())).lines().collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
                }
                catch(Exception e){return "";}
            }).collect(Collectors.toList());
    }
}
