package org.atomsk.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.io.IOException;
import java.util.*;

public class Smoothie {

    private static Smoothie ourInstance = new Smoothie();

    public static Smoothie getInstance() {
        return ourInstance;
    }

    private Smoothie() {
    }

    public Map<String, String> getProductSmoothie(String table) throws Exception{

        ArrayList<String> smoothieNameList = new ArrayList<String>();
        ArrayList<String> arrayList = new ArrayList<String>();
        ArrayList<String> smoothieKcalList = new ArrayList<String>();

//    public void find() throws Exception {

        String path = "http://www.smoothieking.co.kr/product/product_nutrition_facts_01.do";

        Document doc = Jsoup.connect(path).get();
//        System.out.println(doc);
        Elements els = doc.select("tr");
//        System.out.println(els);
        Elements name = els.select("[rowspan]");

        Elements all = doc.select("td");



        for (Element element :all){
            arrayList.add(element.ownText());
        }
        for (int i = 1; i < arrayList.size()-213; i=i+34) {
            smoothieNameList.add(arrayList.get(i));
        }
        for (int i = 1; i < arrayList.size()-213; i=i+34) {
            smoothieKcalList.add(arrayList.get(i+14));
        }


        Map<String, String> smoothieMap = new HashMap<>();

        for (int i = 0; i < smoothieNameList.size(); i++) {
            smoothieMap.put(smoothieKcalList.get(i), smoothieNameList.get(i));
        }
        System.out.println(smoothieMap);


//        Elements elsSpan = doc.select("span");
//        ArrayList<String> arrayList = new ArrayList<String>();
////        for (Element element : elsSpan){
////            if (element.className().equals("title"))
////            System.out.println(element.ownText());
//            arrayList.add(element.ownText());
//        }
//        int idx = 0;
//        for (Element el:els
//             ) {
//            Element span = el.select("span").first();
////            System.out.println(span.ownText());
//            String text = span.ownText();
//
//            if (text.trim().length()==0){
//                continue;
//            }
//
//            result.add(text);
//
//            if (idx == 19){
//                break;
//            }
//            idx++;
//        }

        return smoothieMap;



    }

    public static void main(String[] args) throws Exception {
        Smoothie obj = Smoothie.getInstance();
        obj.getProductSmoothie("table"); //없어두됨 톰캣에서 처리


    }


}
