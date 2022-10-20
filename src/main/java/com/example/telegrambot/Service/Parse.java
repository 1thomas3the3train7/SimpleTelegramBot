package com.example.telegrambot.Service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Parse {
    private final String url = "https://f-mkpo.udsu.ru/class_times";
    private final String subUrl = "https://f-mkpo.udsu.ru";
    private final RestTemplate restTemplate = new RestTemplate();

    public String getCourses(){
        try {
            final String res = restTemplate.getForObject(url, String.class);
            final Document html = Jsoup.parse(res);
            final String var1 = "1 смена псо, пд";
            final String var2 = "1 смена псо,пд";
            Elements span = html.getElementsByClass("download");
            for(Element e : span){
                final String thisText = e.text().toLowerCase();
                if(thisText.equals(var1) || thisText.equals(var2)){
                    return subUrl + e.select("span.download > a").attr("href");
                }
            }
            return "Элемент не найден, походу додики верстку поменяли или текст";
        } catch (Exception e){
            System.out.println("exc in parse");
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }
}
