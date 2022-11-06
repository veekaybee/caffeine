package com.vickiboykis.caffeine;

import java.io.IOException;
import java.util.Set;


public class Caffeine
{

    private static String folder = ("../caffeine/src/main/resources/");

    public static void main( String[] args ) throws IOException {

       /*Generate Markdown from HTML files*/
       HTMLGenerator generator = new HTMLGenerator();
       Set<String> files = generator.listFiles(folder);
       generator.convertToHTML(files);

        /*Aggregate HTML files to templates*/
        HTMLAggregator aggregator = new HTMLAggregator();
       aggregator.aggregateHTML();

    }


}
