package com.base.biz.report;

import com.base.biz.dto.BaseDTO;
import com.base.common.util.StringUtil;
import java.awt.image.BufferedImage;
import java.io.File;

import java.math.BigDecimal;
import java.net.URL;
import java.nio.file.Files;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.imageio.ImageIO;

/**
 * 
 * @author PS
 */
public class BaseReport extends Object {

    public static final String HTML = "html";
    public static final String PDF_PORTRAIT = "pdf_portrait";
    public static final String PDF_LANDSCAPE = "pdf_landscape";
    public static final String EMPTY = "";
    public static final String SPACE = " ";
    protected boolean initialized = false;

    private String reportFormat = null;
    private byte[] content = null;

    private String id = null;
    private String title = null;
    private String name = null;
    private String view = null;
    private String header = null;
    private String footer = null;
    private int recordsPerPage = 0;

    protected String defaultAlign = "left";
    protected boolean defaultNowrap = true;
    protected int defaultFontSize = 2;
    protected String defaultFontFace = "Arial";
    protected DecimalFormat moneyFormatter = new DecimalFormat("#,##0.00");
    protected SimpleDateFormat dateFormatter = new SimpleDateFormat(
            "dd/MM/yyyy");
    protected SimpleDateFormat timeFormatter = new SimpleDateFormat(
            "hh:mm:ss a");
    protected SimpleDateFormat timeFormatter24 = new SimpleDateFormat(
            "HH:mm:ss");
    protected SimpleDateFormat dateTimeFormatter = new SimpleDateFormat(
            "dd/MM/yyyy hh:mm:ss a");
    protected SimpleDateFormat dateTimeFormatter24 = new SimpleDateFormat(
            "dd/MM/yyyy HH:mm:ss");

    private List<? extends BaseDTO> reportData;
    private String locale;

    public String getReportFormat() {
        if (reportFormat == null) {
            reportFormat = "html";
        }
        return reportFormat;
    }

    public void setReportFormat(String reportFormat) {
        this.reportFormat = reportFormat;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getContentFileType() {
        String contentFileType = getReportFormat();
        if (contentFileType != null && contentFileType.startsWith("pdf")) {
            contentFileType = "pdf";
        } else {
            contentFileType = "html";
        }
        return contentFileType;
    }

    /**
     * Sets the id property which is the unique identifier of this report.
     *
     * @param value id of this report
     */
    public void setId(String value) {
        id = value;
    }

    /**
     * Gets the id property which is the unique identifier of this report.
     *
     * @return id of this report
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the title property which is the title of this report.
     *
     * @param value title of this report
     */
    public void setTitle(String value) {
        title = value;
    }

    /**
     * Gets the title property which is the title of this report.
     *
     * @return title of this report
     */
    public String getTitle() {
        return StringUtil.nullToEmpty(title);
    }

    /**
     * Sets the name property which is the name of this report. The name is
     * actually the name of the old Crystal report .RPT file.
     *
     * @param value name of this report
     */
    public void setName(String value) {
        name = value;
    }

    /**
     * Gets the name property which is the title of this report. The name is
     * actually the name of the old Crystal report .RPT file.
     *
     * @return name of this report
     */
    public String getName() {
        return StringUtil.nullToEmpty(name);
    }

    /**
     * Sets the header property which is the html content for the header of this
     * report.
     *
     * @param value html content for the header of this report
     */
    public void setHeader(String value) {
        header = value;
    }

    /**
     * Gets the header property which is the html content for the header of this
     * report.
     *
     * @return html content for the header of this report
     */
    public String getHeader() {
        return StringUtil.nullToEmpty(header);
    }

    /**
     * Sets the footer property which is the html content for the footer of this
     * report.
     *
     * @param value html content for the footer of this report
     */
    public void setFooter(String value) {
        footer = value;
    }

    /**
     * Gets the footer property which is the html content for the footer of this
     * report.
     *
     * @return html content for the footer of this report
     */
    public String getFooter() {
        return StringUtil.nullToEmpty(footer);
    }

    /**
     * Sets the records per page property which is how many records should be
     * displayed before creating a page break.
     *
     * @param value number of records per page
     */
    public void setRecordsPerPage(int value) {
        recordsPerPage = value;
    }

    /**
     * Gets the records per page property which is how many records should be
     * displayed before creating a page break.
     *
     * @return number of records per page
     */
    public int getRecordsPerPage() {
        return recordsPerPage;
    }

    /**
     * Checks if the initialize method has been successfully called on this
     * report. If it hasn't then a ReportException is thrown to indicate so.
     *
     * @throws ReportException
     * @see ReportException
     */
    protected void checkInitialized()
            throws ReportException {
        if (!initialized) {
            throw new ReportException(
                    "report object '" + getClass().getName() + "' not initialized");
        }
    }

    /**
     * Convenience method for formatting variables representing dollar amounts.
     * The resulting format is $#,##0.00
     *
     * @param value BigDecimal holding the dollar amount
     */
    protected String formatMoney(BigDecimal value) {
        if (value == null) {
            value = new BigDecimal("0.0");
        }

        return moneyFormatter.format(value);
    }
    
    protected String formatMoney(Double value) {
        if (value == null) {
            value = 0.00;
        }
        return moneyFormatter.format(value);
    }
    
    protected String formatMoney(Float value) {
        if (value == null) {
            value = 0f;
        }
        return moneyFormatter.format(value);
    }

    /**
     * Convenience method for formatting variables representing dates. The
     * resulting format is MM/DD/YYYY
     *
     * @param value Date holding the date
     */
    protected String formatDate(Date value) {
        if (value == null) {
            return "";
        } else {
            return dateFormatter.format(value);
        }
    }

    /**
     * Convenience method for formatting variables representing times. The
     * resulting format is 24 hour time, HH:MM:SS
     *
     * @param value Date holding the time
     */
    protected String formatTime24(Date value) {
        if (value == null) {
            return "";
        } else {
            return timeFormatter24.format(value);
        }
    }

    /**
     * Convenience method for formatting variables representing times. The
     * resulting format is 12 hour time, HH:MM:SS AM/PM
     *
     * @param value Date holding the time
     */
    protected String formatTime(Date value) {
        if (value == null) {
            return "";
        } else {
            return timeFormatter.format(value);
        }
    }

    /**
     * Convenience method for formatting variables representing date and times.
     * The resulting format is 24 hour time, MM/DD/YYYY HH:MM:SS
     *
     * @param value Date holding the date and time
     */
    protected String formatDateTime24(Date value) {
        if (value == null) {
            return "";
        } else {
            return dateTimeFormatter24.format(value);
        }
    }

    /**
     * Convenience method for formatting variables representing date and times.
     * The resulting format is 12 hour time, MM/DD/YYYY HH:MM:SS AM/PM
     *
     * @param value Date holding the date and time
     */
    protected String formatDateTime(Date value) {
        if (value == null) {
            return "";
        } else {
            return dateTimeFormatter.format(value);
        }
    }

    /**
     * Convenience method that generates the html for a report cell.
     * <li>Defaults colspan to 1 <li>Defaults align to defaultAlign <li>Defaults
     * nowrap to defaultNowrap <li>Defaults font size to defaultFontSize
     * <li>Defaults font face to defaultFontFace
     *
     * @param content text to put in the cell
     *
     * @return the html content for the cell including the beginning (TD) and
     * ending tags (/TD)
     */
    protected String makeCell(String content) {
        return makeCell(content, 1, defaultAlign, defaultNowrap, defaultFontSize,
                defaultFontFace);
    }

    /**
     * Convenience method that generates the html for a report cell.
     * <li>Defaults align to defaultAlign <li>Defaults nowrap to defaultNowrap
     * <li>Defaults font size to defaultFontSize <li>Defaults font face to
     * defaultFontFace
     *
     * @param content text to put in the cell
     * @param colspan colspan attribute
     *
     * @return the html content for the cell including the beginning (TD) and
     * ending tags (/TD)
     */
    protected String makeCell(String content, int colspan) {
        return makeCell(content, colspan, defaultAlign, defaultNowrap,
                defaultFontSize, defaultFontFace);
    }

    /**
     * Convenience method that generates the html for a report cell.
     * <li>Defaults colspan to 1 <li>Defaults nowrap to defaultNowrap
     * <li>Defaults font size to defaultFontSize <li>Defaults font face to
     * defaultFontFace
     *
     * @param content text to put in the cell
     * @param align align attribute
     *
     * @return the html content for the cell including the beginning (TD) and
     * ending tags (/TD)
     */
    protected String makeCell(String content, String align) {
        return makeCell(content, 1, align, defaultNowrap, defaultFontSize,
                defaultFontFace);
    }

    /**
     * Convenience method that generates the html for a report cell.
     * <li>Defaults nowrap to defaultNowrap <li>Defaults font size to
     * defaultFontSize
     * <li>Defaults font face to defaultFontFace
     *
     * @param content text to put in the cell
     * @param colspan colspan attribute
     * @param align align attribute
     *
     * @return the html content for the cell including the beginning (TD) and
     * ending tags (/TD)
     */
    protected String makeCell(String content, int colspan, String align) {
        return makeCell(content, colspan, align, defaultNowrap, defaultFontSize,
                defaultFontFace);
    }

    /**
     * Convenience method that generates the html for a report cell.
     * <li>Defaults font size to defaultFontSize <li>Defaults font face to
     * defaultFontFace
     *
     * @param content text to put in the cell
     * @param colspan colspan attribute
     * @param align align attribute
     * @param nowrap nowrap attribute
     *
     * @return the html content for the cell including the beginning (TD) and
     * ending tags (/TD)
     */
    protected String makeCell(String content,
            int colspan,
            String align,
            boolean nowrap) {
        return makeCell(content, colspan, align, nowrap, defaultFontSize,
                defaultFontFace);
    }

    /**
     * Convenience method that generates the html for a report cell.
     * <li>Defaults font face to defaultFontFace
     *
     * @param content text to put in the cell
     * @param colspan colspan attribute
     * @param align align attribute
     * @param nowrap nowrap attribute
     * @param fontSize size attribute of the enclosing font tag
     *
     * @return the html content for the cell including the beginning (TD) and
     * ending tags (/TD)
     */
    protected String makeCell(String content,
            int colspan,
            String align,
            boolean nowrap,
            int fontSize) {
        return makeCell(content, colspan, align, nowrap, fontSize,
                defaultFontFace);
    }

    /**
     * Convenience method that generates the html for a report cell
     *
     * @param content text to put in the cell
     * @param colspan colspan attribute
     * @param align align attribute
     * @param nowrap nowrap attribute
     * @param fontSize size attribute of the enclosing font tag
     * @param fontFace face attribute of the enclosing font tag
     *
     * @return the html content for the cell including the beginning (TD) and
     * ending tags (/TD)
     */
    protected String makeCell(String content,
            int colspan,
            String align,
            boolean nowrap,
            int fontSize,
            String fontFace) {
        if (colspan < 1) {
            colspan = 1;
        }

        String nowrapString = "";
        if (nowrap) {
            nowrapString = "nowrap";
        }

        if (fontSize < 1) {
            fontSize = 1;
        }

        return "<td " + nowrapString + " align='" + align + "' colspan=" + colspan
                + "><font size=" + fontSize + " face='" + fontFace + "'>"
                + ((content == null || content.length() == 0) ? "<br>" : content) + "</font></td>";
    }

    private File outputFile = null;
    private String orientation = null;

    public File getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(File outputFile) {
        this.outputFile = outputFile;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public List<? extends BaseDTO> getReportData() {
        return reportData;
    }

    public void setReportData(List<? extends BaseDTO> reportData) {
        this.reportData = reportData;
    }

    public String getLocale() {
        if(locale == null) {
            locale = "en";
        }
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }
    
    protected byte[] getLogoByteContent() {
        byte[] content = null;
        try {
            File file = new File("C:\\work\\tomcat-8.5.23\\webapps\\universal\\images\\logo_original.jpg");
           content = Files.readAllBytes(file.toPath());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return content;
    }
    protected BufferedImage getLogoBufferedImage() {
        BufferedImage image = null;
        try {
           URL url = new URL("http://localhost:8080/universal/images/logo_original.jpg");
            image = ImageIO.read(url);            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return image;
    }

}
