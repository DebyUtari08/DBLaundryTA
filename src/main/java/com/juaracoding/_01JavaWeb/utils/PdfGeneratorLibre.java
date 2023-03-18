package com.juaracoding._01JavaWeb.utils;/*
Created By IntelliJ IDEA 2022.2.3 (Community Edition)
IntelliJ IDEA 2022.3.2 (Community Edition)
Build #IC-223.8617.56, built on January 26, 2023
@Author USER a.k.a. Deby Utari
Java Developer
Created on 15/03/2023 21:22
@Last Modified 15/03/2023 21:22
Version 1.0
*/

import javax.servlet.http.HttpServletResponse;

import com.juaracoding._01JavaWeb.configuration.OtherConfig;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import java.awt.*;

public class PdfGeneratorLibre {

    private String [] strExceptionArr = new String[2];

    public PdfGeneratorLibre() {
        strExceptionArr[0] = "PdfGeneratorLibre";
    }

    public void generate(String strTitle,String[] strHeader, String[][] strBody , HttpServletResponse response)  {
        try
        {
            Document document = new Document(PageSize.A4);

            Rectangle footer = new Rectangle(30f, 30f, PageSize.A4.getRight(30f), 140f);
            footer.setBorder(Rectangle.BOX);
            footer.setBorderColor(Color.black);
            footer.setBorderWidth(2f);

            Rectangle header = new Rectangle(30f, 30f, PageSize.A4.getRight(30f), 140f);
            header.setBorder(Rectangle.BOX);
            header.setBorderColor(Color.BLUE);
            header.setBorderWidth(1f);
            header.setTop(PageSize.A4.getTop(30f));
            header.setBottom(PageSize.A4.getTop(180f));

            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();
            Image image = Image.getInstance("https://www.samsung.com/etc.clientlibs/samsung/clientlibs/consumer/global/clientlib-common/resources/images/gnb-desktop-120x32.png");// INI DIGANTI BIAR GAK SAMA
            image.scaleAbsolute(100f,100f);
            document.add(image);

            Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
            fontTiltle.setSize(20);
            Paragraph paragraph = new Paragraph(strTitle, fontTiltle);
            paragraph.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(paragraph);
            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100f);
            table.setWidths(new int[] {3,3,3,3});
            table.setSpacingBefore(5);
            PdfPCell cell = new PdfPCell();
            cell.setBackgroundColor(CMYKColor.BLUE);// INI DIGANTI BIAR GAK SAMA
            cell.setPadding(5);
            Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
            font.setColor(CMYKColor.WHITE);
            for(int i=0;i<strHeader.length;i++)
            {
                cell.setPhrase(new Phrase(strHeader[i], font));
//                cell.setBackgroundColor(Color.LIGHT_GRAY);// INI DIGANTI BIAR GAK SAMA
                cell.setBackgroundColor(Color.BLUE);// INI DIGANTI BIAR GAK SAMA
                table.addCell(cell);
            }

            // Iterating the list of students
            for(int i=0;i<strBody.length;i++)
            {
                for(int j=0;j<strBody[i].length;j++)
                {
                    table.addCell(strBody[i][j]);
                }
            }

            document.add(table);
            document.close();
        }
        catch(Exception e)
        {
            strExceptionArr[1] = "generate(String[] strHeader,String[][] strBody ,HttpServletResponse response) --- LINE 59";
            LoggingFile.exceptionStringz(strExceptionArr, e, OtherConfig.getFlagLogging());
        }
    }
}
