package com.vickiboykis.caffeine;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.w3c.dom.html.HTMLOptGroupElement;

import java.io.File;
import java.io.IOException;

/**
 * Unit test for simple App.
 */
public class SiteGeneratorTest
{

    File file1, file2;

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    /* executed before every test: create temporary files */
    @Before
    public void setUp() {
        try {
            file1 = folder.newFile( "testfile1.txt" );
            file2 = folder.newFile( "testfile2.txt" );
        }
        catch( IOException ioe ) {
            System.err.println(
                    "error creating temporary test file in " +
                            this.getClass().getSimpleName() );
        }
    }


    @Test(expected = RuntimeException.class)
    public void testEmptyMarkdownDir()
    {

        String folder = System.getProperty("java.io.tmpdir");
        HTMLGenerator  html = new HTMLGenerator();
        html.listFiles(folder);

    }
}
