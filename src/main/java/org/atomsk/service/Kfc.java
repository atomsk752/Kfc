package org.atomsk.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Kfc {

    private static Kfc ourInstance = new Kfc();

    public static Kfc getInstance() {
        return ourInstance;
    }

    public Kfc() {


    }

    public TreeMap<String,String> getProductById(String id) throws IOException {

        ArrayList<String> arrayList = new ArrayList<String>();
        ArrayList<String> resultArrayList = new ArrayList<String>();
        ArrayList<String> nameArrayList = new ArrayList<String>();

        File input = new File("C:\\zzz\\kfc.html");
        Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
        //       System.out.println(doc);


        //칼로리
        Element el = doc.select("#" + id).first();

        //   System.out.println(el);

        Elements labels = el.select("tbody");

        System.out.println(el);

        Elements buger = labels.select("td");

        System.out.println(buger);


        for (Element element : buger){
            arrayList.add(element.ownText());
            System.out.println(element.ownText());
        }
        //1,8,15 출력
        for(int i=1; i< arrayList.size(); i=i+7){
            resultArrayList.add(arrayList.get(i));
        }
        System.out.println(resultArrayList);

        //칼로리

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        //버거 이름
        Element el1 = doc.select("#" + id).first();

        //   System.out.println(el);

        Elements labels1 = el1.select("tbody");

        //  System.out.println(el);

        Elements buger1 = labels1.select("th");
        //  System.out.println(buger1);



        for (Element element : buger1){
            nameArrayList.add(element.ownText());
            System.out.println(element.ownText());
        }

        Map<String, String> listMap = new HashMap<>();
        for(int i =0; i<resultArrayList.size();i++){
            listMap.put(resultArrayList.get(i),nameArrayList.get(i));
        }

        //오름차순
        TreeMap<String,String> key = new TreeMap<String,String>(listMap);

        Set<String>keyset = listMap.keySet();
        Iterator<String> keyiterator = key.keySet().iterator();




        System.out.println(resultArrayList);
        System.out.println(nameArrayList);
        System.out.println(listMap);
        System.out.println(key);


        return key;
    }

    public static void main(String[] args) throws Exception {
       Kfc obj = Kfc.getInstance();
        obj.getProductById("begrBox");

        // System.out.println(Arrays.toString(ResultArrayList));

    }

}