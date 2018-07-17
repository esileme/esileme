package com.yl.spider;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * =================================
 * <p>
 * Created by yl on 2018-7-16.
 * <p>
 * 描述:
 */

public class Main {

    public  static  final  String url = "https://mosaic.re.taobao.com/search?clk1=&p4pTags=&ismall=&buckid=&refpos=&refpid=mm_14507511_3485205_11375261&keyword=%E9%9E%8B%E5%AD%90&_input_charset=utf-8&isinner=0";

    public static void main(String[] args) throws Exception {
        Document doc = Jsoup.connect(url).get();
        Element body = doc.body();
        /*Elements container = body.getElementsByAttribute("bx-container");
        Element element = container.get(0);
        Elements contian = element.getElementsByClass("p4p-search-layout");
        Elements result = contian.get(0).getElementsByClass("p4p-search-result");
        result.get(0).getElementsByClass("");*/

        List<Object> datas = new ArrayList<>();
        Element searchResult = body.getElementById("searchResult");
        Elements item = searchResult.getElementsByClass("item");
        for (Element element : item) {
            //System.out.println(element.toString());
            Map<String, String> data = new HashMap<>();
            Elements a = element.getElementsByTag("a");
            String href = a.get(0).attr("href");
            String title = a.get(0).getElementsByClass("title").text();
            String price = a.get(0).getElementsByTag("strong").get(0).text();
            String payNum = a.get(0).getElementsByClass("payNum").text();
            data.put("title",title);
            data.put("price",price);
            data.put("payNum",payNum);
            data.put("href",href);
            datas.add(data);
        }
        System.out.println(datas.size());


    }


}
