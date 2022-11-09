package com.vickiboykis.caffeine;

import java.io.IOException;
import java.util.Set;


public class Caffeine
{

    private static String folder = ("../caffeine/src/main/resources/");

    public static void main( String[] args ) throws IOException {

       /*Generate Markdown from HTML files*/
       HTMLGenerator generator = new HTMLGenerator();
       Set<String> mdFiles = generator.listFiles(folder,".md");
       generator.convertToHTML(mdFiles);

        /*Aggregate HTML files to templates*/
        HTMLTemplateGenerator aggregator = new HTMLTemplateGenerator();
        Set<String> htmlFiles = generator.listFiles(folder,".html");
        aggregator.generateHTMLFiles(htmlFiles);

    }


}
