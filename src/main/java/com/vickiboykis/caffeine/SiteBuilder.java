package com.vickiboykis.caffeine;

import java.io.IOException;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class SiteBuilder
{

    private static String folder = ("/Users/vicki/caffeine/src/main/java/com/vickiboykis/caffeine/resources/content/");

    public static void main( String[] args ) throws IOException {
       HTMLGenerator generator = new HTMLGenerator();
       Set<String> files = generator.listFiles(folder);
       generator.convertToHTML(files);
       System.out.println(files);

    }


}
