package edu.ithaca.dragon.datastructures.map;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import bridges.connect.Bridges;
import bridges.connect.DataSource;
import bridges.data_src_dependent.GutenbergBook;

public class LitAnalysisUtilTest {

    public List<String> getBookTexts(int numberOfTexts) throws Exception{
        Bridges bridges = new Bridges(1, "tdragon", "YOUR_API_KEY");
        DataSource ds = bridges.getDataSource();
        List<GutenbergBook> booklist = ds.getGutenbergBookMetaData().subList(0, numberOfTexts);
        return  LitUtil.retrieveBookTexts(booklist);
    }

    @Test
    public void checkSomeWordCounts() throws Exception{
        List<String> bookTexts = getBookTexts(20);
        Map<String, Integer> wordCountMap = null; //Here you choose your Map implementation
        LitAnalysisUtil.addBookTextsToWordCountMap(bookTexts, wordCountMap);

        //use your wordCountMap
    }
    
    @Test
    public void testWordCountWithManyBooks() throws Exception{
        List<String> bookTexts = getBookTexts(20);

        Map<String, Integer> map1 = null; //Here you choose your Map implementation
        Map<String, Integer> map2 = null; //Here you choose your Map implementation
        testWordCountMapTiming(bookTexts, map1);
        testWordCountMapTiming(bookTexts, map2);
        testfindMostFrequentWordTiming( map1);
        testfindMostFrequentWordTiming( map2);
    }

    public void testWordCountMapTiming(List<String> bookTexts, Map<String, Integer> wordCountMap){
        //prints the name of the class that the map belongs to
        System.out.println(wordCountMap.getClass().getSimpleName());
    }

    public void testfindMostFrequentWordTiming(Map<String, Integer> wordCountMap){
        //prints the name of the class that the map belongs to (showing tree or hash)
        System.out.println(wordCountMap.getClass().getSimpleName());
    }
    
}
