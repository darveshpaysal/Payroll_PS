package com.base.biz.report;

import com.base.common.util.StringUtil;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDJpeg;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDXObjectImage;
import org.apache.pdfbox.pdmodel.interactive.action.type.PDActionURI;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary;

/**
 *
 * @author PS
 */
public class CreatePdfReport {

    private int defaultTitleFont = 11;
    private int defaultMargin = 20;
    private int marginLeft = defaultMargin;
    private int marginRight = defaultMargin;
    private int marginTop = defaultMargin;
    private int marginBottom = defaultMargin;

    private PDDocument document = null;
    private PDFont fontBold = PDType1Font.TIMES_BOLD;
    private PDFont fontNormal = PDType1Font.TIMES_ROMAN;
    private PDPage page = null;
    private int fontSize = 8;
    private PDRectangle pageSize = null;
    private PDPageContentStream contentStream = null;
    private float pageWidth = 0;
    private float pageHeight = 0;
    private float currentCursorX = 0;
    private float currentCursorY = 0;
    private String pdfOrientation = null;
    private int totalColumn = 0;
    private int defaultLineSpace = 1;
    List<String> wrappedTexts = null;
    public static Color blackColor = Color.BLACK;    
    public static Color redColor = Color.RED;
    private Color fontColor = Color.BLACK;

    public CreatePdfReport(String pdfOrientation, int totalColumn) {
        this.pdfOrientation = pdfOrientation;
        this.totalColumn = totalColumn;
        this.document = new PDDocument();
        wrappedTexts = new ArrayList<String>(totalColumn);
        try {
            InputStream fontStream = CreatePdfReport.class.getResourceAsStream("/org/apache/pdfbox/resources/ttf/ArialMT.ttf");
            fontNormal = PDTrueTypeFont.loadTTF(document, fontStream);
            fontStream = CreatePdfReport.class.getResourceAsStream("/org/apache/pdfbox/resources/ttf/Arial-BoldMT.ttf");
            fontBold = PDTrueTypeFont.loadTTF(document, fontStream);

            // fontNormal = PDTrueTypeFont.loadTTF(document, "Arial.ttf");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public int getDefaultMargin() {
        return defaultMargin;
    }

    public void setDefaultMargin(int defaultMargin) {
        this.defaultMargin = defaultMargin;
    }

    public int getMarginLeft() {
        return marginLeft;
    }

    public void setMarginLeft(int marginLeft) {
        this.marginLeft = marginLeft;
    }

    public int getMarginRight() {
        return marginRight;
    }

    public void setMarginRight(int marginRight) {
        this.marginRight = marginRight;
    }

    public int getMarginTop() {
        return marginTop;
    }

    public void setMarginTop(int marginTop) {
        this.marginTop = marginTop;
    }

    public int getMarginBottom() {
        return marginBottom;
    }

    public void setMarginBottom(int marginBottom) {
        this.marginBottom = marginBottom;
    }

    public PDDocument getDocument() {
        return document;
    }

    public void setDocument(PDDocument document) {
        this.document = document;
    }

    public PDFont getFontBold() {
        return fontBold;
    }

    public void setFontBold(PDFont fontBold) {
        this.fontBold = fontBold;
    }

    public PDFont getFontNormal() {
        return fontNormal;
    }

    public void setFontNormal(PDFont fontNormal) {
        this.fontNormal = fontNormal;
    }

    public PDPage getPage() {
        return page;
    }

    public void setPage(PDPage page) {
        this.page = page;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public PDRectangle getPageSize() {
        return pageSize;
    }

    public void setPageSize(PDRectangle pageSize) {
        this.pageSize = pageSize;
    }

    public PDPageContentStream getContentStream() {
        return contentStream;
    }

    public void setContentStream(PDPageContentStream contentStream) {
        this.contentStream = contentStream;
    }

    public float getPageWidth() {
        return pageWidth;
    }

    public void setPageWidth(float pageWidth) {
        this.pageWidth = pageWidth;
    }

    public float getPageHeight() {
        return pageHeight;
    }

    public void setPageHeight(float pageHeight) {
        this.pageHeight = pageHeight;
    }

    public float getCurrentCursorX() {
        return currentCursorX;
    }

    public void setCurrentCursorX(float currentCursorX) {
        this.currentCursorX = currentCursorX;
    }

    public float getCurrentCursorY() {
        return currentCursorY;
    }

    public void setCurrentCursorY(float currentCursorY) {
        this.currentCursorY = currentCursorY;
    }

    public String getPdfOrientation() {
        return pdfOrientation;
    }

    public void setPdfOrientation(String pdfOrientation) {
        this.pdfOrientation = pdfOrientation;
    }

    public int getTotalColumn() {
        return totalColumn;
    }

    public void setTotalColumn(int totalColumn) {
        this.totalColumn = totalColumn;
    }

    public int getDefaultTitleFont() {
        return defaultTitleFont;
    }

    public void setDefaultTitleFont(int defaultTitleFont) {
        this.defaultTitleFont = defaultTitleFont;
    }

    private void writeRowText(String content, int fontSize, PDFont fontType, float locationX, float locationY, boolean isRow) throws IOException {
        if (fontSize == 0) {
            fontSize = this.fontSize;
        }
        if (fontType == null) {
            fontType = this.fontNormal;
        }
        if (currentCursorY < marginBottom + fontSize) {
            closeContentStream();
            page = new PDPage(PDPage.PAGE_SIZE_A4);
            document.addPage(page);
            pageSize = page.findMediaBox();
            contentStream = new PDPageContentStream(document, page);
           if ("landscape".equalsIgnoreCase(pdfOrientation)) {
                pageWidth = pageSize.getWidth();
                page.setRotation(90);
                contentStream.concatenate2CTM(0, 1, -1, 0, pageWidth, 0);
                pageWidth = pageSize.getHeight();
                pageHeight = pageSize.getWidth();
            } else {
                pageWidth = pageSize.getWidth();
                pageHeight = pageSize.getHeight();
            }
            setCursorX(locationX);
            currentCursorY = pageHeight - marginTop - fontSize - defaultLineSpace;
        }

        contentStream.beginText();
        contentStream.setNonStrokingColor(getFontColor());
        contentStream.setFont(fontType, fontSize);
        setCursorX(locationX);
        setCursorY(locationY, isRow);
        contentStream.moveTextPositionByAmount(currentCursorX, currentCursorY);

        contentStream.drawString(content);
        contentStream.endText();
    }

    private void setCursorX(float locationX) {
        if (locationX > 0) {
            currentCursorX = locationX;
        } else {
            currentCursorX = marginLeft;
        }
    }

    private void setCursorY(float locationY, boolean isRow) {
        if (locationY > 0) {
            currentCursorY = locationY;
        } else if (isRow) {
            currentCursorY = currentCursorY - fontSize - defaultLineSpace;
        }
    }

    public void writeRowText(String content) {
        writeRowText(content, 0);
    }

    public void writeRowText(String content, int fontSize) {
        writeRowText(content, fontSize, null);
    }

    public void writeRowText(String content, int fontSize, PDFont fontType) {
        writeRowText(content, fontSize, fontType, 0, 0);
    }

    public void writeRowText(String content, int fontSize, PDFont fontType, float locationX, float locationY) {
        try {
            setRowHeight();
            writeRowText(content, fontSize, fontType, locationX, locationY, true);
        } catch (IOException exc) {

        }
    }

    public void writeColumnText(String content, int columnNumber) {
        writeColumnText(content, columnNumber, 0, null);
    }

    /*
    public void writeColumnText(String content, int columnNumber, int fontSize) {
        writeColumnText(content, columnNumber, fontSize, null, false, false);
    }
     */
    public void writeColumnText(String content, int columnNumber, int fontSize, PDFont fontType) {
        writeColumnText(content, columnNumber, fontSize, fontType, false);
    }

    private void writeColumnText(String content, int columnNumber, int fontSize, PDFont fontType, boolean isRight, boolean isUnderline) {
        try {
            float columnX = 0;
            if (isRight) {
                columnX = getColumnLocationX(columnNumber + 1) - getStringWidth(content, fontType, fontSize) - 2;
            } else {
                columnX = getColumnLocationX(columnNumber);
            }
            writeRowText(content, fontSize, fontType, columnX, 0, false);
            if (isUnderline) {
                float stringWidth = getStringWidth(content, fontType, fontSize);
                addLine(columnX, currentCursorY - 3, columnX + stringWidth, currentCursorY - 3);
            }
        } catch (IOException exc) {

        }
    }

    public void writeColumnText(String content, int columnNumber, boolean isRight) {
        writeColumnText(content, columnNumber, 0, null, isRight);
    }

    public void writeColumnHeader(String content, int columnNumber) {
        writeColumnHeader(content, columnNumber, false);
    }

    public void writeColumnHeader(String content, int columnNumber, boolean isRight) {
        writeColumnHeader(content, columnNumber, 0, null, isRight);
    }

    public void writeColumnText(String content, int columnNumber, int fontSize, PDFont fontType, boolean isRight) {
        writeColumnText(content, columnNumber, fontSize, fontType, isRight, false, 1);
    }

    public void writeColumnCaptionAndValueText(String captionName, int columnNumber, int fontSize, PDFont fontType, String valueText) {
        /*Write caption name*/
        try {
            float columnX = getColumnLocationX(columnNumber);
            writeRowText(captionName, fontSize, fontType, columnX, 0, false);
            float stringWidth = getStringWidth(captionName, fontType, fontSize);
            /*Write caption value*/
            writeRowText(valueText, fontSize, fontNormal, columnX + stringWidth, 0, false);
        } catch (IOException exc) {

        }
    }

    public void writeColumnHeader(String content, int columnNumber, int fontSize, PDFont fontType) {
        writeColumnHeader(content, columnNumber, fontSize, fontType, false);
    }

    public void writeColumnHeader(String content, int columnNumber, int fontSize, PDFont fontType, boolean isRight) {
        writeColumnText(content, columnNumber, fontSize, fontType, isRight, false, 1);
    }

    public void writeColumnHeaderAndUnderline(String content, int columnNumber) {
        writeColumnHeaderAndUnderline(content, columnNumber, false);
    }

    public void writeColumnHeaderAndUnderline(String content, int columnNumber, boolean isRight) {
        writeColumnHeaderAndUnderline(content, columnNumber, 0, null, isRight);
    }

    public void writeColumnHeaderAndUnderline(String content, int columnNumber, int fontSize, PDFont fontType) {
        writeColumnHeaderAndUnderline(content, columnNumber, fontSize, fontType, false);
    }

    public void writeColumnHeaderAndUnderline(String content, int columnNumber, int fontSize, PDFont fontType, boolean isRight) {
        writeColumnText(content, columnNumber, fontSize, fontType, isRight, true, 1);
    }

    public void writeTitle(String content) {
        writeTitle(content, defaultTitleFont, fontBold);
    }

    public void writeTitle(String content, int fontSize, PDFont fontType) {
        writeTitle(content, fontSize, fontType, true);
    }

    private void writeTitle(String content, int fontSize, PDFont fontType, boolean isUnderline) {
        try {
            setRowHeight();
            float stringWidth = getStringWidth(content, fontType, fontSize);
            float columnX = (pageWidth - stringWidth) / 2;
            writeRowText(content, fontSize, fontType, columnX, currentCursorY, true);
            if (isUnderline) {
                addLine(columnX, currentCursorY - 3, columnX + stringWidth, currentCursorY - 3);
                addBlankRow();
                addBlankRow();
                addBlankRow();
            }
        } catch (IOException exc) {

        }
    }

    public void writeCenterText(String content) {
        writeTitle(content, fontSize, fontBold, false);
    }

    public void writeCenterText(String content, int fontSize, PDFont fontType) {
        fontSize = fontSize > 0 ? fontSize : this.fontSize;
        currentCursorY = currentCursorY - 2;
        writeTitle(content, fontSize, fontType, false);
    }

    public void addBlankRow() {
        try {
            setRowHeight();
            currentCursorY = currentCursorY - fontSize;
            if (contentStream == null) {
                initializeDocument();
            }
            contentStream.beginText();
            contentStream.setNonStrokingColor(getFontColor());
            contentStream.moveTextPositionByAmount(0, -fontSize);
            contentStream.endText();
        } catch (IOException exc) {

        }
    }

    public void addLine(float startX, float startY, float endX, float endY) {
        try {
            contentStream.drawLine(startX, startY, endX, endY);
        } catch (IOException exc) {

        }
    }

    public void addLine() {
        setRowHeight();
        currentCursorY = currentCursorY - fontSize;
        addLine(marginLeft, currentCursorY, pageWidth - marginRight, currentCursorY);
        currentCursorY = currentCursorY - fontSize;
    }

    public float getStringWidth(String stringValue, PDFont fontType) {
        return getStringWidth(stringValue, fontType, fontSize);
    }

    public float getStringWidth(String stringValue, PDFont fontType, int fontSize) {
        float stringWidth = 0;
        try {
            initializeDocument();
            fontType = fontType != null ? fontType : fontNormal;
            fontSize = fontSize > 0 ? fontSize : this.fontSize;
            stringWidth = fontType.getStringWidth(StringUtil.nullToEmpty(stringValue)) * fontSize / 1000f;
        } catch (IOException exc) {

        }
        return stringWidth;
    }

    public float getColumnLocationX(int columnNumber) {
        return (marginLeft + ((pageWidth - marginLeft - marginRight) / totalColumn) * (columnNumber - 1));
    }

    public void closeContentStream() {
        try {
            if (contentStream != null) {
                contentStream.close();
            }
        } catch (IOException exc) {

        }
    }

    public void createPdfFile(String filename) {
        try {
            closeContentStream();
            document.save(filename);
            document.close();
        } catch (IOException exc) {

        } catch (COSVisitorException ex) {
        }
    }

    public void createPdfFile(File file) {
        try {
            closeContentStream();
            document.save(file);
            document.close();
        } catch (IOException exc) {

        } catch (COSVisitorException ex) {
        }
    }

    public byte[] getBytes() {
        try {
            closeContentStream();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            document.save(out);
            document.close();
            return out.toByteArray();
        } catch (IOException exc) {
            return null;
        } catch (COSVisitorException ex) {
            return null;
        }
    }

    public void initializeDocument() throws IOException {
        if (page == null) {
            page = new PDPage(PDPage.PAGE_SIZE_A4);
            document.addPage(page);
            pageSize = page.findMediaBox();
            contentStream = new PDPageContentStream(document, page);
            if (!"portrait".equalsIgnoreCase(pdfOrientation)) {
                pageWidth = pageSize.getWidth();
                page.setRotation(90);
                contentStream.concatenate2CTM(0, 1, -1, 0, pageWidth, 0);
                pageWidth = pageSize.getHeight();
                pageHeight = pageSize.getWidth();
            } else {
                pageWidth = pageSize.getWidth();
                pageHeight = pageSize.getHeight();
            }
            currentCursorX = marginLeft;
            currentCursorY = pageHeight - marginTop - fontSize;
        }
    }

    public void addNewPage() {
        try {
            closeContentStream();
            page = null;
            initializeDocument();
        } catch (IOException exc) {

        }
    }

    public void addLink(String url) {
        try {
            PDBorderStyleDictionary borderULine = new PDBorderStyleDictionary();
            borderULine.setStyle(PDBorderStyleDictionary.STYLE_UNDERLINE);
            PDAnnotationLink txtLink = new PDAnnotationLink();
            txtLink.setBorderStyle(borderULine);
            // txtLink.setColour(colourBlue);

            PDActionURI action = new PDActionURI();
            action.setURI(url);
            txtLink.setAction(action);
            this.page.getAnnotations().add(txtLink);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    //Text wrap

    public void writeColumnHeader(String content, int columnNumber, int columns) {
        writeColumnHeader(content, columnNumber, 0, null, columns);
    }

    public void writeColumnHeader(String content, int columnNumber, boolean isRight, int columns) {
        writeColumnHeader(content, columnNumber, 0, null, isRight, columns);
    }

    public void writeColumnHeader(String content, int columnNumber, int fontSize, PDFont fontType, int columns) {
        writeColumnHeader(content, columnNumber, fontSize, fontType, false, columns);
    }

    public void writeColumnHeader(String content, int columnNumber, int fontSize, PDFont fontType, boolean isRight, int columns) {
        writeColumnText(content, columnNumber, fontSize, fontType, isRight, false, columns);
    }

    public void writeColumnHeaderAndUnderline(String content, int columnNumber, int columns) {
        writeColumnHeaderAndUnderline(content, columnNumber, 0, null, columns);
    }

    public void writeColumnHeaderAndUnderline(String content, int columnNumber, boolean isRight, int columns) {
        writeColumnHeaderAndUnderline(content, columnNumber, 0, null, isRight, columns);
    }

    public void writeColumnHeaderAndUnderline(String content, int columnNumber, int fontSize, PDFont fontType, int columns) {
        writeColumnHeaderAndUnderline(content, columnNumber, fontSize, fontType, false, columns);
    }

    public void writeColumnHeaderAndUnderline(String content, int columnNumber, int fontSize, PDFont fontType, boolean isRight, int columns) {
        writeColumnText(content, columnNumber, fontSize, fontType, isRight, true, columns);
    }

    public void writeColumnText(String content, int columnNumber, int columns) {
        writeColumnText(content, columnNumber, 0, null, columns);
    }

    public void writeColumnText(String content, int columnNumber, int fontSize, PDFont fontType, int columns) {
        writeColumnText(content, columnNumber, fontSize, fontType, false, columns);
    }

    public void writeColumnText(String content, int columnNumber, boolean isRight, int columns) {
        writeColumnText(content, columnNumber, 0, null, isRight, columns);
    }

    public void writeColumnText(String content, int columnNumber, int fontSize, PDFont fontType, boolean isRight, int columns) {
        writeColumnText(content, columnNumber, fontSize, fontType, isRight, false, columns);
    }

    public void writeColumnCaptionAndValueText(String captionName, int columnNumber, int fontSize, PDFont fontType, String valueText, int columns) {
        writeColumnCaptionAndValueText(captionName, columnNumber, fontSize, fontType, valueText);
    }

    public void addLine(String lineColor) {
        setRowHeight();
        addLine();
    }

    public CreatePdfReport() {
        this.document = new PDDocument();
    }

    public PDFont getPdfFont(String fontFace, int fontStyle) {

        PDFont pdFont = null;
        if (fontFace != null) {
            fontFace = fontFace.toUpperCase();
            if (fontFace.startsWith("TIMES")) {
                if (fontStyle == 0) {
                    pdFont = PDType1Font.TIMES_ROMAN;
                } else if (fontStyle == 1) {
                    pdFont = PDType1Font.TIMES_BOLD;
                } else {
                    pdFont = PDType1Font.TIMES_ITALIC;
                }
            } else if (fontFace.startsWith("COURIER")) {
                if (fontStyle == 0) {
                    pdFont = PDType1Font.COURIER;
                } else if (fontStyle == 1) {
                    pdFont = PDType1Font.COURIER_BOLD;
                } else {
                    pdFont = PDType1Font.COURIER_OBLIQUE;
                }
            } else if (fontFace.startsWith("HELVETICA")) {
                if (fontStyle == 0) {
                    pdFont = PDType1Font.HELVETICA;
                } else if (fontStyle == 1) {
                    pdFont = PDType1Font.HELVETICA_BOLD;
                } else {
                    pdFont = PDType1Font.HELVETICA_OBLIQUE;
                }
            } else {
                pdFont = getArialPDFont(fontStyle);
            }
        } else {
            pdFont = getArialPDFont(fontStyle);
        }
        return pdFont;
    }

    private PDFont getArialPDFont(int fontStyle) {
        PDFont pdFont = null;
        try {
            InputStream fontStream = null;
            if (fontStyle == 0) {
                fontStream = CreatePdfReport.class.getResourceAsStream("/org/apache/pdfbox/resources/ttf/ArialMT.ttf");
            } else if (fontStyle == 1) {
                fontStream = CreatePdfReport.class.getResourceAsStream("/org/apache/pdfbox/resources/ttf/Arial-BoldMT.ttf");
            } else {
                fontStream = CreatePdfReport.class.getResourceAsStream("/org/apache/pdfbox/resources/ttf/Arial-ArialMT.ttf");
            }
            pdFont = PDTrueTypeFont.loadTTF(document, fontStream);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return pdFont;
    }

    private void writeFormText(String content, int fontSize, PDFont fontType, float locationX, float locationY) throws IOException {

        /*  System.out.print(" -- locationX,locationY -" + locationX + ", " + locationY);
        System.out.print(" -- content -" + content);*/
        if (content != null) {
            if (fontSize == 0) {
                fontSize = this.fontSize;
            }
            if (fontType == null) {
                fontType = this.fontNormal;
            }
            contentStream.beginText();
            contentStream.setNonStrokingColor(getFontColor());
            contentStream.setFont(fontType, fontSize);
            contentStream.moveTextPositionByAmount(locationX, locationY);
            contentStream.drawString(content);
            contentStream.endText();
        }

    }

    private void initializePage() throws IOException {
        if (page == null || contentStream == null) {
            closeContentStream();
            page = new PDPage(PDPage.PAGE_SIZE_LETTER);
            document.addPage(page);
            pageSize = page.findMediaBox();
            pageWidth = pageSize.getWidth();
            pageHeight = pageSize.getHeight();
            contentStream = new PDPageContentStream(document, page);

        }
    }

    public void writeFormTextRight(String content, int fontSize, PDFont fontType, float locationX, float locationY) {
        try {
            initializePage();
            locationX = marginLeft + locationX;
            locationY = pageHeight - (marginTop + locationY);
            float contentLength = getStringWidth(content, fontType, fontSize);
            writeFormText(content, fontSize, fontType, locationX - contentLength, locationY);
            moveTo(locationX, locationY);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void writeFormTextLeft(String content, int fontSize, PDFont fontType, float locationX, float locationY) {
        try {
            initializePage();
            locationX = marginLeft + locationX;
            locationY = pageHeight - (marginTop + locationY);
            writeFormText(content, fontSize, fontType, locationX, locationY);
            moveTo(locationX, locationY);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void writeFormTextCenter(String content, int fontSize, PDFont fontType, float locationX, float locationY) {
        try {
            initializePage();
            locationX = marginLeft + locationX;
            locationY = pageHeight - (marginTop + locationY);
            float contentLength = getStringWidth(content, fontType, fontSize);
            writeFormText(content, fontSize, fontType, locationX - contentLength / 2, locationY);
            moveTo(locationX, locationY);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private float prevX = 0;
    private float prevY = 0;

    public float getPrevX() {
        return prevX;
    }

    public void setPrevX(float prevX) {
        this.prevX = prevX;
    }

    public float getPrevY() {
        return prevY;
    }

    public void setPrevY(float prevY) {
        this.prevY = prevY;
    }

    private void moveTo(float locationX, float locationY) {
        prevX = locationX - marginLeft;
        prevY = pageHeight - locationY;
    }

    public void addNewFormPage() {
        prevX = 0;
        prevY = 0;
        setPage(null);
    }

    public void initFormPage() {
        addNewFormPage();
    }

    public Color getFontColor() {
        return fontColor;
    }

    public void setFontColor(Color fontColor) {
        this.fontColor = fontColor;
    }

    /*---------------*/
    private float columnSize = 0;
    private float maxRowHeight = 0;

    private void writeColumnText(String content, int columnNumber, int fontSize, PDFont fontType, boolean isRight, boolean isUnderline, int columns) {
        float contentWidth = getStringWidth(content, fontType, fontSize);
        float columnWidth = getColumnSize() * columns;
        if (contentWidth > columnWidth) {
            getColumnText(content, contentWidth, fontSize, fontType, columnWidth);
            fontSize = fontSize == 0 ? this.fontSize : fontSize;
            fontType = fontType == null ? this.fontNormal : fontType;
            float columnHeight = 0;
            //System.out.println("-- Start -this.currentCursorY -" + this.currentCursorY);
            for (String value : wrappedTexts) {
                // System.out.println("---value -" + value);
                if (value != null) {
                    addRowHeight(columnHeight);
                    columnHeight = columnHeight + fontSize;
                    writeColumnText(value, columnNumber, fontSize, fontType, isRight, isUnderline);
                    this.currentCursorY = this.currentCursorY - fontSize;
                }
            }
            this.currentCursorY = this.currentCursorY + columnHeight;
            // System.out.println("-- columnHeight -" + columnHeight);
            // System.out.println("-- End -this.currentCursorY -" + this.currentCursorY);
        } else {
            writeColumnText(content, columnNumber, fontSize, fontType, isRight, isUnderline);
        }

    }

    private void addRowHeight(float wrappedRowHeight) {
        if (maxRowHeight < wrappedRowHeight) {
            maxRowHeight = wrappedRowHeight;
        }
    }

    private List<String> getColumnText(String content, float contentWidth, int fontSize, PDFont fontType, float columnWidth) {

        String[] values = content.split(" ");
        wrappedTexts.clear();
        StringBuilder columnText = null;
        String temp = null;
        for (String value : values) {
            if (columnText == null) {
                columnText = new StringBuilder(value);
            } else {
                temp = columnText.toString();
                columnText.append(" ");
                columnText.append(value);
                float columnTextWidth = getStringWidth(columnText.toString(), fontType, fontSize);
                if (columnTextWidth > columnWidth) {
                    columnText = new StringBuilder(value);
                    wrappedTexts.add(temp);
                }
            }
        }
        if (columnText != null) {
            wrappedTexts.add(columnText.toString());
        }
        return wrappedTexts;

    }

    public float getColumnSize() {
        if (columnSize < 1) {
            columnSize = (pageWidth - marginLeft - marginRight) / totalColumn;
        }
        return columnSize;
    }

    private void setRowHeight() {
        this.currentCursorY = this.currentCursorY - maxRowHeight;
        maxRowHeight = 0;
    }

    public void drawTableHeader(int columnNumber, int columns, int heightSpace) {
        float startX = marginLeft + (columnNumber - 1) * columnSize;
        float startY = currentCursorY - heightSpace;
        float endX = startX + columns * columnSize;
        float endY = startY;
        addLine(startX, startY, endX, endY);
        setCurrentCursorX(startX);
        setCurrentCursorY(startY);
    }

    public void drawTableRowBottomLine(int columnNumber, int columns, int heightSpace) {
        addBlankRow();
        float startX = marginLeft + (columnNumber - 1) * columnSize;
        float startY = currentCursorY - heightSpace;
        float endX = startX + columns * columnSize;
        float endY = startY;
        addLine(startX, startY, endX, endY);
        setCurrentCursorX(startX);
        setCurrentCursorY(startY);
    }
    
    public void drawTableColumnBottomLine(int columnNumber, int columns, int heightSpace) {
        float startX = marginLeft + (columnNumber - 1) * columnSize;
        float startY = currentCursorY - heightSpace;
        float endX = startX + columns * columnSize;
        float endY = startY;
        addLine(startX, startY, endX, endY);
        setCurrentCursorX(startX);
        setCurrentCursorY(startY);
    }

    public void drawTableColumnLine(int columnNumber, int heightSpace) {
        float startX = marginLeft + (columnNumber - 1) * columnSize;
        float startY = currentCursorY;
        float endX = startX;
        float endY = startY + fontSize + heightSpace;
        addLine(startX, startY, endX, endY);
        setCurrentCursorX(startX);
        setCurrentCursorY(startY);
    }

    public void drawTableRowTopLine(int columnNumber, int columns) {
        float startX = marginLeft + (columnNumber - 1) * columnSize;
        addLine(startX, currentCursorY, startX + columns * columnSize, currentCursorY);
    }
    
    public void writeColumnCenterText(String content, int columnNumber, int columns) {
        writeColumnCenterText(content, columnNumber, 0, null, columns);
    }
    
    public void writeColumnCenterText(String content, int columnNumber, int fontSize, PDFont fontType, int columns) {
        try {
            float contentWidth = getStringWidth(content, fontType, fontSize);
            float columnWidth = getColumnSize() * columns;
            float startColumnX = getColumnLocationX(columnNumber);
            float columnX;
            if (contentWidth > columnWidth) {
                getColumnText(content, contentWidth, fontSize, fontType, columnWidth);
                fontSize = fontSize == 0 ? this.fontSize : fontSize;
                fontType = fontType == null ? this.fontNormal : fontType;
                float columnHeight = 0;
                for (String value : wrappedTexts) {
                    if (value != null) {
                        addRowHeight(columnHeight);
                        columnHeight = columnHeight + fontSize;
                        contentWidth = getStringWidth(content, fontType, fontSize);
                        columnX = startColumnX + (columnWidth - contentWidth) / 2;
                        writeRowText(value, fontSize, fontType, columnX, 0, false);
                        this.currentCursorY = this.currentCursorY - fontSize;
                    }
                }
                this.currentCursorY = this.currentCursorY + columnHeight;
            } else {
                columnX = startColumnX + (columnWidth - contentWidth) / 2;
                writeRowText(content, fontSize, fontType, columnX, 0, false);
            }
        } catch (IOException exc) {

        }
    }  
    
    public void addImageJpeg(byte[] imageContent, int columnNumber) {
        addImageJpeg(imageContent, columnNumber, 0, 0);
    }
    public void addImageJpeg(byte[] imageContent, int columnNumber, int height, int width) {
        try {
            if (imageContent != null) {                
                PDXObjectImage image =  new PDJpeg(document, new ByteArrayInputStream(imageContent));
                if (height > 0 && width > 0) {
                    image.setHeight(height);
                    image.setWidth(width);
                }
                float columnX = getColumnLocationX(columnNumber);
                contentStream.drawImage(image, columnX, currentCursorY);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }  
    public void addImageJpeg(BufferedImage image, int columnNumber) {
        addImageJpeg(image, columnNumber, 0, 0);
    }
    public void addImageJpeg(BufferedImage bufImage, int columnNumber, int height, int width) {
        try {
            if (bufImage != null) {                
                PDXObjectImage image =  new PDJpeg(document, bufImage);
                if (height > 0 && width > 0) {
                    image.setHeight(height);
                    image.setWidth(width);
                }
                float columnX = getColumnLocationX(columnNumber);
                contentStream.drawImage(image, columnX, currentCursorY);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }  
   
}
