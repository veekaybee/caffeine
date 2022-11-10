package com.vickiboykis.caffeine;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTMLTemplateGenerator {

    public HTMLElement processFile(String file) throws IOException {


        File inputFile = new File(file);
        Document doc = Jsoup.parse(inputFile);
        Element link = doc.selectFirst("h2");

        HTMLElement htmlElement  = new HTMLElement(" "," "," ");

        /*Generate title element from HTML */
        Pattern pattern = Pattern.compile("[^<h2>title: ].+?(?=date)");
        Matcher matcher = pattern.matcher(link.toString());
        if (matcher.find()){
            htmlElement.setTitle(matcher.group(0));
        }

        /*Generate date element from HTML*/
        Pattern pattern2 = Pattern.compile("(?<=date: ).(?:(?!<).)*");
        Matcher matcher2 = pattern2.matcher( link.toString());
        if (matcher2.find()){
            htmlElement.setDate(matcher2.group(0));
        }

        File f = new File(file);
        String fileName = f.getName();
        htmlElement.setUrl("src/main/resources/" + fileName);

        return htmlElement;

    }

    public void generateHTMLFiles(Set<String> fileList) throws IOException {

        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache m = mf.compile("index.mustache");
        File outputFile = new File("index.html");

        List<HTMLElement> elements = new ArrayList<HTMLElement>();


        Set<String> sortedFileList = new TreeSet<String>(fileList);


        for (String file:sortedFileList) {
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



