package com.vickiboykis.caffeine;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

import java.io.*;

public class HTMLAggregator {

    public void aggregateHTML() throws IOException {
        File outputFile = new File("index.html");

        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache m = mf.compile("index.mustache");

        Index todo = new Index("Todo 1", "Description", true);
        StringWriter writer = new StringWriter();


        m.execute(writer, todo).flush();
        String html = writer.toString();
        PrintWriter fileWriter = new PrintWriter(outputFile);

        fileWriter.write(html);
        fileWriter.close();

    }


}
