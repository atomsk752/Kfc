package org.atomsk.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class KeywordService {

    private static KeywordService ourInstance = new KeywordService();

    public static KeywordService getInstance() {
        return ourInstance;
    }

    private KeywordService() {
    }

    public List<String> find() throws Exception{
        List<String> result = new ArrayList<String>();


//    public void find() throws Exception {

        String path = "C:\\zzz\\menu.html";

        Document doc = Jsoup.connect(path).get();
        System.out.println(doc);
        Elements els = doc.select("img");
        System.out.println(els);
//        Elements elsSpan = doc.select("span");
//        ArrayList<String> arrayList = new ArrayList<String>();
////        for (Element element : elsSpan){
////            if (element.className().equals("title"))
////            System.out.println(element.ownText());
//            arrayList.add(element.ownText());
//        }
        int idx = 0;
        for (Element el:els
             ) {
            Element span = el.select("span").first();
//            System.out.println(span.ownText());
            String text = span.ownText();

            if (text.trim().length()==0){
                continue;
            }

            result.add(text);

            if (idx == 19){
                break;
            }
            idx++;
        }
        return result;



    }

    public static void main(String[] args) throws Exception {
        List<String> list = KeywordService.getInstance().find();

    }


}
