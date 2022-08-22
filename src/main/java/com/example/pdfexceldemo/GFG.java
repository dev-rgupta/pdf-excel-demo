package com.example.pdfexceldemo;
// Java Program to Extract Content from a PDF

// Importing java input/output classes

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;
import  com.aspose.cells.Workbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

// Class
public class GFG {

    // Main driver method
    public static void main(String[] args) throws Exception
    {

        String text = extractedFromPdf();
        writeUsingFiles(text);
        Workbook workbook = new Workbook("/Users/ratngupta/Downloads/files.txt");
        workbook.save("/Users/ratngupta/Downloads/Output.xlsx");

    }

    private static String extractedFromPdf() throws IOException, SAXException, TikaException {
        // Create a content handler
        BodyContentHandler contenthandler
                = new BodyContentHandler();

        // Create a file in local directory
        File f = new File("/Users/ratngupta/Downloads/abhi.pdf");

        // Create a file input stream
        // on specified path with the created file
        FileInputStream fstream = new FileInputStream(f);

        // Create an object of type Metadata to use
        Metadata data = new Metadata();

        // Create a context parser for the pdf document
        ParseContext context = new ParseContext();

        // PDF document can be parsed using the PDFparser
        // class
        PDFParser pdfparser = new PDFParser();

        // Method parse invoked on PDFParser class
        pdfparser.parse(fstream, contenthandler, data,
                context);
        // Printing the contents of the pdf document
        // using toString() method in java
        System.out.println("Extracting contents :"
                + contenthandler.toString());
        return contenthandler.toString();
    }

    /**
     * Use Files class from Java 1.7 to write files, internally uses OutputStream
     * @param data
     */
    private static void writeUsingFiles(String data) {
        try {
            Files.write(Paths.get("/Users/ratngupta/Downloads/files.txt"), data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

