package com.juaracoding._01JavaWeb.utils;/*
Created By IntelliJ IDEA 2022.2.3 (Community Edition)
IntelliJ IDEA 2022.3.2 (Community Edition)
Build #IC-223.8617.56, built on January 26, 2023
@Author USER a.k.a. Deby Utari
Java Developer
Created on 16/03/2023 12:53
@Last Modified 16/03/2023 12:53
Version 1.0
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

@Component
public class PdfGenaratorUtil {

    @Autowired
    TemplateEngine templateEngine;

    private StringBuilder sBuild = new StringBuilder();
    public File createPdf(String templateName, Map<String, Object> map,String fileName) throws Exception {

        Context ctx = new Context();
        Iterator itMap = map.entrySet().iterator();
        File outputFile = null;
        while (itMap.hasNext()) {
            Map.Entry pair = (Map.Entry) itMap.next();
            ctx.setVariable(pair.getKey().toString(), pair.getValue());
        }

        String processedHtml = templateEngine.process(templateName, ctx);
        FileOutputStream os = null;

        try {
            outputFile = new File(fileName);
//                    append(fileName).append(".pdf").toString());
            os = new FileOutputStream(outputFile);

            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(processedHtml);
            renderer.layout();
            renderer.createPDF(os, false);

            renderer.finishPDF();

        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) { /*ignore*/ }
            }
        }
        return outputFile;
    }
}
