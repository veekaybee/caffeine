package com.vickiboykis.caffeine;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class HTMLAggregator {

    public void aggregateHTML(Set<String> fileList) throws IOException {

        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache m = mf.compile("index.mustache");

        File outputFile = new File("index.html");

        Map context = Map.of("titles", fileList.stream().map(file -> new HTMLFields(file))
                .collect(Collectors.toSet()));

        StringWriter writer = new StringWriter();
        m.execute(writer,context).flush();

        String html = writer.toString();

        PrintWriter fileWriter = new PrintWriter(outputFile);
        fileWriter.write(html);
        fileWriter.close();



        }



    }



