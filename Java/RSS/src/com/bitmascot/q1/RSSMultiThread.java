package com.bitmascot.q1;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

class FetchRSSFromCNN extends Thread {
    public void run(){
        getDataAndWriteToFile();
    }

    public void getDataAndWriteToFile(){
        while (true) {
            try {
                String url = "http://rss.cnn.com/rss/edition.rss";
                Document document = Jsoup.connect(url).get();
                BufferedWriter writer = new BufferedWriter(new FileWriter("a.rss"));
                writer.write(document.toString());
                writer.close();

                System.out.println(" FetchRSSFromCNN Thread #" + Thread.currentThread().getId() + " has completed writing");
                this.sleep(20000);

            } catch (Exception e) {
                System.out.println("Exception " + e + "caught");
            }
        }
    }
}


class FetchMediaUrlFromFile extends Thread {
    public void run(){
        getDataAndWriteToTerminal();
    }

    public void getDataAndWriteToTerminal(){
        while (true) {
            try {
                this.sleep(15000);
                File input = new File("a.rss");
                Document document = Jsoup.parse(input, "UTF-8");

                Elements media_urls = document.getElementsByAttribute("url");
                for (Element media_url : media_urls) {
                    if(media_url.attr("url").endsWith(".jpg"));
                    System.out.println(media_url.attr("url"));
                }
                System.out.println(" FetchMediaUrlFromFile Thread #" + Thread.currentThread().getId() + " has completed writing to terminal");

            } catch (Exception e) {
                System.out.println("Exception " + e + "caught");
            }
        }
    }
}

class RSSMultiThread {
    public static void main(String args[]) {

        FetchRSSFromCNN fetchrssfromcnn = new FetchRSSFromCNN();
        fetchrssfromcnn.start();

        FetchMediaUrlFromFile fetchmediaurlfromfile = new FetchMediaUrlFromFile();
        fetchmediaurlfromfile.start();

        System.out.println("Main thread exits.");
    }
}