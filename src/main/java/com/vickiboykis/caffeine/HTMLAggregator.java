package com.vickiboykis.caffeine;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.*;

public class HTMLAggregator {

    public HTMLElement processFile(String file) throws IOException {


        File inputFile = new File(file);
        Document doc = Jsoup.parse(inputFile);
        Element link = doc.selectFirst("h2");

        HTMLElement htmlElement  = new HTMLElement(null, null, null);

        htmlElement.setTitle(link.text());
        htmlElement.setDate(link.text());
        htmlElement.setUrl(file);


        return htmlElement;

    }

    public void aggregateHTML(Set<String> fileList) throws IOException {

        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache m = mf.compile("index.mustache");
        File outputFile = new File("index.html");

        List<HTMLElement> elements = Arrays.asList();

        for (String file:fileList) {
            elements.add(this.processFile(file));
        }

        Map<String, Object> context = new HashMap<>();
        context.put("titles", elements);

        StringWriter writer = new StringWriter();
        m.execute(writer,context).flush();

        String html = writer.toString();

        PrintWriter fileWriter = new PrintWriter(outputFile);
        fileWriter.write(html);
        fileWriter.close();



        }



    }



