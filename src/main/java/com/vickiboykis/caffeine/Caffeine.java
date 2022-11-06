package com.vickiboykis.caffeine;

import java.io.IOException;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class SiteBuilder
{

    private static String folder = ("../caffeine/src/main/resources/");

    public static void main( String[] args ) throws IOException {
       HTMLGenerator generator = new HTMLGenerator();
       Set<String> files = generator.listFiles(folder);
       generator.convertToHTML(files);

    }


}
