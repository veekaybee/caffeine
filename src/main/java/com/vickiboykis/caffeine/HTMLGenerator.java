package com.vickiboykis.caffeine;

import java.io.*;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.commonmark.node.*;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

public class HTMLGenerator {

    private static final Logger logger = Logger.getLogger(HTMLGenerator.class.getName());
    /*
    List all the files in a given directory for processing
    and only process markdown files
     */
    public Set<String> listFiles(String dir, String fileType) {

        Set<String> result = null;

        try {
        Set<String> results = Stream.of(new File(dir).listFiles())
                .filter(file -> !file.isDirectory())
                .filter(file -> file.toString().contains(fileType))
                .map(File::getAbsolutePath)
                .collect(Collectors.toSet());

            result = results;
            }
            catch (Exception e) {
                logger.warning("No" + fileType + " files found in dir");
            }

        return result;
    }

    /*
    Helper method to change filenames from markdown to HTML
     */
    public String replaceFileName(String filename){

        String mdFilename = filename.replace(".md",".html");
        return mdFilename;
    }


    /*
    Convert all Markdown files in a given directory to HTML
     */
    public void convertToHTML(Set<String> fileList) throws IOException {

        for (String file:fileList) {

            try {
                File inputFile = new File(file);
                File outputFile  = new File(replaceFileName(file));

                String stylesheet = "<link rel=\"stylesheet\" href=\"https://unpkg.com/mvp.css@1.12/mvp.css\">";

                Parser parser = Parser.builder().build();
                Node document = parser.parseReader(new FileReader(inputFile));
                HtmlRenderer renderer = HtmlRenderer.builder().build();
                PrintWriter writer = new PrintWriter(outputFile);
                writer.write("<!DOCTYPE html>\n" +
                        "\n" +
                        "<meta charset=\"UTF-8\">\n" +
                        "<html>\n" +
                        "<head>\n" +
                         stylesheet +
                        "</head>\n" +
                        "<body><main> " );
                writer.write(renderer.render(document));
                writer.write("</main></body></html>" );
                writer.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
