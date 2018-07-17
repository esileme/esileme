package com.yl.spider;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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


        Element searchResult = body.getElementById("searchResult");
        Elements item = searchResult.getElementsByClass("item");
        for (Element element : item) {
            System.out.println(element.toString());
        }


    }


}
