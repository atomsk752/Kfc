package org.atomsk.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProductService {

    private static ProductService ourInstance = new ProductService();

    public static ProductService getInstance() {
        return ourInstance;
    }

    public ProductService() {


    }

    public Map<String, String> getProductById(String id) throws IOException {

        ArrayList<String> arrayList = new ArrayList<String>();
        ArrayList<String> kcalList = new ArrayList<String>();
        ArrayList<String> bugerList = new ArrayList<String>();

        File input = new File("C:\\zzz\\kfc.html");
        Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
 //       System.out.println(doc);

        Element el = doc.select("#" + id).first();

     //   System.out.println(el);

        Elements labels = el.select("tbody");


        Elements kcal = labels.select("td");


        Elements buger = labels.select("th");

        for (Element element : buger){
            bugerList.add(element.ownText());
        }
        System.out.println(bugerList);

       for (Element element : kcal){
           arrayList.add(element.ownText());
        }

        for (int i = 1; i < arrayList.size(); i=i+7) {
            kcalList.add(arrayList.get(i));
        }

        System.out.println(kcalList);

        Map<String, String> listMap = new HashMap<>();

        for (int i = 0; i < kcalList.size(); i++) {
            listMap.put(kcalList.get(i), bugerList.get(i));
        }

        System.out.println(listMap);



        return listMap;
    }

    public static void main(String[] args) throws Exception {
        ProductService obj = ProductService.getInstance();
        obj.getProductById("begrBox");

    }

}
