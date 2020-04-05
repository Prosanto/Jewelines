package com.Jewelines.app.utils;

import android.os.Environment;
import android.util.Log;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class CreatePdf {
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);

    private CreatePdf() {

    }


    public static void createDocument() {
        try {

            String root = Environment
                    .getExternalStorageDirectory().toString();
            File myDir = new File(root + "/Jewelines_pdf");
            myDir.mkdirs();
            String fname = "Jewelines" + ".pdf";
            File filePDD = new File(myDir, fname);
            String pdfFilename = filePDD.getAbsolutePath();
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(pdfFilename));
            document.open();
            addMetaData(document);
//            addTitlePage(document);
            addApplicationInfromation(document);
            addLocationInfromation(document);
            addCoastelInfromation(document);
            addLossInfromation(document);
            addGeneralInfromation(document);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // iText allows to add metadata to the PDF which can be viewed in your Adobe
    // Reader
    // under File -> Properties
    public static void addMetaData(Document document) {
        document.addTitle("My first PDF");
        document.addSubject("Using iText");
        document.addKeywords("Java, PDF, iText");
        document.addAuthor("Lars Vogel");
        document.addCreator("Lars Vogel");
    }

    public static void addTitlePage(Document document)
            throws DocumentException {
        Paragraph preface = new Paragraph();
        // We add one empty line
        addEmptyLine(preface, 1);
        // Lets write a big header
        preface.add(new Paragraph("Apploicant Information", catFont));


        document.add(preface);
        // Start a new page
        document.newPage();
    }

    public static void addApplicationInfromation(Document document) throws DocumentException {

        Paragraph subPara = new Paragraph("Applicant Information", subFont);
        addEmptyLine(subPara, 1);
        document.add(subPara);
        createTable(document, AppConstant.appInfo, 2);
        addEmptyLine(subPara, 1);

    }

    public static void addLocationInfromation(Document document) throws DocumentException {

        Paragraph subPara = new Paragraph("Location Information", subFont);
        addEmptyLine(subPara, 1);
        document.add(subPara);
        createTable(document, AppConstant.locationInfo_1, 2);
        Paragraph paraGraph = new Paragraph("", subFont);
        addEmptyLine(paraGraph, 1);
        document.add(paraGraph);
        createTable(document, AppConstant.locationInfo_2, 3);

    }

    public static void addCoastelInfromation(Document document) throws DocumentException {

        Paragraph subPara = new Paragraph("For Coastal Locations", subFont);
        addEmptyLine(subPara, 1);
        document.add(subPara);
        createTable(document, AppConstant.coastal_location, 3);

    }

    public static void addGeneralInfromation(Document document) throws DocumentException {

        Paragraph subPara = new Paragraph("General Information", subFont);
        addEmptyLine(subPara, 1);
        document.add(subPara);
        createTable(document, AppConstant.general_inifo, 2);
        addEmptyLine(subPara, 1);

    }

    public static void addLossInfromation(Document document) throws DocumentException {

        Paragraph subPara = new Paragraph("Loss History", subFont);
        addEmptyLine(subPara, 1);
        document.add(subPara);
        createTable(document, AppConstant.loss_historydate, 4);
        addEmptyLine(subPara, 1);

    }
    public static void createTable(Document subCatPart, ArrayList<String> myList, int tableRow)
            throws DocumentException {
        PdfPTable table = new PdfPTable(tableRow);

        // t.setBorderColor(BaseColor.GRAY);
        // t.setPadding(4);
        // t.setSpacing(4);
        // t.setBorderWidth(1);
        table.setWidthPercentage(100);

        /*PdfPCell c1 = new PdfPCell(new Phrase("Header"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        c1.setPadding(5.0f);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Information"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        c1.setPadding(5.0f);
        table.addCell(c1);*/
        if (tableRow == 2) {
            for (int i = 0; i < myList.size(); i++) {
                Log.i("Mylist", "" + myList.get(i));
                table.addCell(StringUtility.getFirst(myList.get(i),";"));
                table.addCell(StringUtility.getSecond(myList.get(i),";"));
            }
        } else if(tableRow == 3){
            for (int i = 0; i < myList.size(); i++) {
                Log.i("Mylist", "" + myList.get(i));
                table.addCell(StringUtility.getFirst(myList.get(i),";"));
                table.addCell(StringUtility.getSecond(myList.get(i),";"));
                table.addCell(StringUtility.getThird(myList.get(i),";"));
            }
        }else {
            for (int i = 0; i < myList.size(); i++) {
                Log.i("Mylist", "" + myList.get(i));
                table.addCell(StringUtility.getFirst(myList.get(i),";"));
                table.addCell(StringUtility.getSecond(myList.get(i),";"));
                table.addCell(StringUtility.getThird(myList.get(i),";"));
                table.addCell(StringUtility.getFourth(myList.get(i),";"));
            }
        }


        try {
            subCatPart.add(table);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }

    public static PdfPCell getRowCell(String text) {
        PdfPCell cell = new PdfPCell(new Paragraph(text));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(5.0f);
        cell.setBorderWidthBottom(0);
        cell.setBorderWidthTop(0);
        return cell;
    }

    public static void createList(Paragraph subCatPart) {
        List list = new List(true, false, 10);
        list.add(new ListItem("Applicant’s First Name:  Musafir Ali"));
        list.add(new ListItem("Applicant’s Last Name: Sakandar Ali"));
        list.add(new ListItem("DOB: 02 Feb 1988"));
        subCatPart.add(list);
    }

    public static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }



}
