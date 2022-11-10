package com.vickiboykis.caffeine;

import java.io.File;
import java.io.IOException;
import java.util.Set;


public class Caffeine
{

    private static String folder = ("../caffeine/src/main/resources/");

    public static void main( String[] args ) throws IOException {

        /* Delete all existing HTML files for a clean start */
        HTMLGenerator generator = new HTMLGenerator();
        Set<String> htmlFiles = generator.listFiles(folder,".html");

        for (String fileString : htmlFiles) {
            File file = new File(fileString);
            String pes = file.getName();
            if (pes.endsWith("." + ".html")) {
                file.delete();
            }
        }

       /*Generate HTML from Markdown files*/

       Set<String> mdFiles = generator.listFiles(folder,".md");
       generator.convertToHTML(mdFiles);

        /*Aggregate updated HTML files to templates*/
        HTMLTemplateGenerator aggregator = new HTMLTemplateGenerator();
        Set<String> updatedHTMLFiles = generator.listFiles(folder,".html");
        aggregator.generateHTMLFiles(updatedHTMLFiles);

    }


}
