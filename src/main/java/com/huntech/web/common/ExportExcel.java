package com.huntech.web.common;
import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 * 利用开源组件POI3.0.2动态导出EXCEL文档 转载时请保留以下信息，注明出处！
 *
 * @author leno
 * @version v1.0
 * @param <T>
 *            应用泛型，代表任意一个符合javabean风格的类
 *            注意这里为了简单起见，boolean型的属性xxx的get器方式为getXxx(),而不是isXxx()
 *            byte[]表jpg格式的图片数据
 */
public class ExportExcel<T> {

    public void exportExcel(Collection<T> dataset, OutputStream out) {
        exportExcel("测试POI导出EXCEL文档", null, dataset, out, "yyyy-MM-dd");
    }

    public void exportExcel(String[] headers, Collection<T> dataset,
                            OutputStream out) {
        exportExcel("测试POI导出EXCEL文档", headers, dataset, out, "yyyy-MM-dd");
    }

    public void exportExcel(String[] headers, Collection<T> dataset,
                            OutputStream out, String pattern) {
        exportExcel("测试POI导出EXCEL文档", headers, dataset, out, pattern);
    }

    /**
     * 这是一个通用的方法，利用了JAVA的反射机制，可以将放置在JAVA集合中并且符号一定条件的数据以EXCEL 的形式输出到指定IO设备上
     *
     * @param title
     *            表格标题名
     * @param headers
     *            表格属性列名数组
     * @param dataset
     *            需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象。此方法支持的
     *            javabean属性的数据类型有基本数据类型及String,Date,byte[](图片数据)
     * @param out
     *            与输出设备关联的流对象，可以将EXCEL文档导出到本地文件或者网络中
     * @param pattern
     *            如果有时间数据，设定输出格式。默认为"yyy-MM-dd"
     */
    @SuppressWarnings("unchecked")
    public void exportExcel(String title, String[] headers,
                            Collection<T> dataset, OutputStream out, String pattern) {
        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet(title);
        // 设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth((short) 15);

        //////////////////////////////////////
        // 1 生成一个样式 表头样式
        HSSFCellStyle style0 = workbook.createCellStyle();
        // 设置这些样式
        //style0.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
        style0.setFillForegroundColor(HSSFColor.WHITE.index);//表格颜色
        style0.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style0.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style0.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style0.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style0.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style0.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 生成一个字体
        HSSFFont font0 = workbook.createFont();
        //font.setColor(HSSFColor.VIOLET.index);//字体颜色
        font0.setFontHeightInPoints((short) 12);
        font0.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 把字体应用到当前的样式
        style0.setFont(font0);
        /////////////////////////////////////

        // 1 生成一个样式 表头样式
        HSSFCellStyle style = workbook.createCellStyle();
        // 设置这些样式
        //style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
        style.setFillForegroundColor(HSSFColor.WHITE.index);//表格颜色
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 生成一个字体
        HSSFFont font = workbook.createFont();
        //font.setColor(HSSFColor.VIOLET.index);//字体颜色
        font.setFontHeightInPoints((short) 12);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 把字体应用到当前的样式
        style.setFont(font);


        // 2 生成并设置另一个样式 表格内容样式
        HSSFCellStyle style2 = workbook.createCellStyle();
        //style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
        style2.setFillForegroundColor(HSSFColor.WHITE.index);
        style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        // 生成另一个字体
        HSSFFont font2 = workbook.createFont();
        font2.setColor(HSSFColor.BLACK.index);
        font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        // 把字体应用到当前的样式
        style2.setFont(font2);

        // 声明一个画图的顶级管理器
        HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
        // 定义注释的大小和位置,详见文档
        HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0,
                0, 0, 0, (short) 4, 2, (short) 6, 5));
        // 设置注释内容
        comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));
        // 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
        comment.setAuthor("web");

        // 产生表格标题行
        HSSFRow row = sheet.createRow(0);
        row.createCell(0);
        for (short i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        if(dataset==null){
            //return;
        }
        if(dataset!=null){
            // 遍历集合数据，产生数据行
            Iterator<T> it = dataset.iterator();
            int index = 0;
            //alter
            HSSFFont font3 = workbook.createFont();
            font3.setColor(HSSFColor.BLUE.index);
            while (it.hasNext()) {
                index++;
                row = sheet.createRow(index);
                T t = (T) it.next();
                // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
                Field[] fields = t.getClass().getDeclaredFields();
                for (short i = 0; i < fields.length; i++) {
                    HSSFCell cell = row.createCell(i);
                    cell.setCellStyle(style2);
                    Field field = fields[i];
                    String fieldName = field.getName();
                    String getMethodName = "get"
                            + fieldName.substring(0, 1).toUpperCase()
                            + fieldName.substring(1);
                    try {
                        Class tCls = t.getClass();
                        Method getMethod = tCls.getMethod(getMethodName,
                                new Class[] {});
                        Object value = getMethod.invoke(t, new Object[] {});
                        // 判断值的类型后进行强制类型转换
                        String textValue = null;
                        // if (value instanceof Integer) {
                        // int intValue = (Integer) value;
                        // cell.setCellValue(intValue);
                        // } else if (value instanceof Float) {
                        // float fValue = (Float) value;
                        // textValue = new HSSFRichTextString(
                        // String.valueOf(fValue));
                        // cell.setCellValue(textValue);
                        // } else if (value instanceof Double) {
                        // double dValue = (Double) value;
                        // textValue = new HSSFRichTextString(
                        // String.valueOf(dValue));
                        // cell.setCellValue(textValue);
                        // } else if (value instanceof Long) {
                        // long longValue = (Long) value;
                        // cell.setCellValue(longValue);
                        // }
                        if (value instanceof Boolean) {
                            boolean bValue = (Boolean) value;
                            textValue = "男";
                            if (!bValue) {
                                textValue = "女";
                            }
                        } else if (value instanceof Date) {
                            Date date = (Date) value;
                            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                            textValue = sdf.format(date);
                        } else if (value instanceof byte[]) {
                            // 有图片时，设置行高为60px;
                            row.setHeightInPoints(60);
                            // 设置图片所在列宽度为80px,注意这里单位的一个换算
                            sheet.setColumnWidth(i, (short) (35.7 * 80));
                            // sheet.autoSizeColumn(i);
                            byte[] bsValue = (byte[]) value;
                            HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0,
                                    1023, 255, (short) 6, index, (short) 6, index);
                            anchor.setAnchorType(2);
                            patriarch.createPicture(anchor, workbook.addPicture(
                                    bsValue, HSSFWorkbook.PICTURE_TYPE_JPEG));
                        } else {
                            // 其它数据类型都当作字符串简单处理
                            textValue = value==null?"":value.toString();
                        }
                        // 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
                        if (textValue != null) {
                            Pattern p = Pattern.compile("^//d+(//.//d+)?$");
                            Matcher matcher = p.matcher(textValue);
                            if (matcher.matches()) {
                                // 是数字当作double处理
                                cell.setCellValue(Double.parseDouble(textValue));
                            } else {
                                HSSFRichTextString richString = new HSSFRichTextString(
                                        textValue);
                                //移出循环外
                                //HSSFFont font3 = workbook.createFont();
                                //font3.setColor(HSSFColor.BLUE.index);
                                richString.applyFont(font3);
                                cell.setCellValue(richString);
                            }
                        }
                    } catch (SecurityException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IllegalArgumentException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } finally {
                        // 清理资源
                    }
                }

            }
        }

        try {
            workbook.write(out);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     *
     * @param sheetTitle 表格sheet名称
     * @param headers 表头标题 <th> <th/>
     * @param dataset 数据集合
     * @param out 输出流
     * @param pattern 日期格式
     * @param tableTile 表标题
     */
    public void exportExcel(String sheetTitle, String[] headers,
                            Collection<T> dataset, OutputStream out, String pattern,String tableTile,String logoTitle,String logoPath) throws IOException {
        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet(sheetTitle);
        // 设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth((short) 15);
        // 声明一个画图的顶级管理器
        HSSFPatriarch logoPatriarch = sheet.createDrawingPatriarch();
        //设置表格logo
        //String path33 ="e://qhldlogo.png";//= request.getSession().getServletContext().getRealPath("/");
        BufferedImage bufferImg =null;



        File file=new File(logoPath);
        ByteArrayOutputStream byteArrayOut = null;
        if(file.exists()){
            bufferImg = ImageIO.read(file);
            byteArrayOut = new ByteArrayOutputStream();
            ImageIO.write(bufferImg, "jpg", byteArrayOut);
        }
        if(null != byteArrayOut){
            HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
            HSSFClientAnchor anchor = new HSSFClientAnchor(30, 40, 350, 250,(short) 0, 0, (short) 0, 0);
            anchor.setAnchorType(3);
            patriarch.createPicture(anchor, workbook.addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));
        }





//        bufferImg = ImageIO.read(new File(logoPath));
//        ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
//        if(bufferImg!=null){
//            ImageIO.write(bufferImg, "jpg", byteArrayOut);
//        }
//
//
//        HSSFClientAnchor logAnchor = new HSSFClientAnchor(30, 40, 350, 250,(short) 0, 0, (short) 0, 0);
//        logAnchor.setAnchorType(3);
//        //插入logo图片
//        logoPatriarch.createPicture(logAnchor, workbook.addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));
//        //////////////////////////////////////

        // 1 生成一个样式 表格标题
        HSSFCellStyle logoStyle = workbook.createCellStyle();
        // 设置这些样式
        logoStyle.setFillForegroundColor(HSSFColor.WHITE.index);//表格颜色
        logoStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        logoStyle.setBorderBottom(HSSFCellStyle.BORDER_NONE);
        logoStyle.setBorderLeft(HSSFCellStyle.BORDER_NONE);
        logoStyle.setBorderRight(HSSFCellStyle.BORDER_NONE);
        logoStyle.setBorderTop(HSSFCellStyle.BORDER_NONE);
        logoStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
        logoStyle.setVerticalAlignment(HSSFCellStyle.ALIGN_LEFT);
        // 生成一个字体
        HSSFFont logoFont = workbook.createFont();
        logoFont.setFontName("宋体");
        //font.setColor(HSSFColor.VIOLET.index);//字体颜色
        logoFont.setFontHeightInPoints((short) 9);
        logoFont.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        // 把字体应用到当前的样式
        logoStyle.setFont(logoFont);

        // 1 生成一个样式 表格标题
        HSSFCellStyle titleStyle = workbook.createCellStyle();
        // 设置这些样式
        titleStyle.setFillForegroundColor(HSSFColor.WHITE.index);//表格颜色
        titleStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        titleStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        titleStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        titleStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        titleStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        titleStyle.setAlignment(HSSFCellStyle.VERTICAL_BOTTOM);
        // 生成一个字体
        HSSFFont titleFont = workbook.createFont();
        titleFont.setFontName("黑体");
        //font.setColor(HSSFColor.VIOLET.index);//字体颜色
        titleFont.setFontHeightInPoints((short) 16);
        titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 把字体应用到当前的样式
        titleStyle.setFont(titleFont);
        /////////////////////////////////////

        //////////////////////////////////////
        // 1 生成一个样式 表头样式
        HSSFCellStyle tableTh = workbook.createCellStyle();
        // 设置这些样式
        tableTh.setFillForegroundColor(HSSFColor.WHITE.index);//表格颜色
        tableTh.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        tableTh.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        tableTh.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        tableTh.setBorderRight(HSSFCellStyle.BORDER_THIN);
        tableTh.setBorderTop(HSSFCellStyle.BORDER_THIN);
        tableTh.setAlignment(HSSFCellStyle.ALIGN_LEFT);
        // 生成一个字体
        HSSFFont fontTh = workbook.createFont();
        //font.setColor(HSSFColor.VIOLET.index);//字体颜色
        fontTh.setFontHeightInPoints((short) 12);
        fontTh.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 把字体应用到当前的样式
        tableTh.setFont(fontTh);
        /////////////////////////////////////

        // 1 生成一个样式 表头样式
        HSSFCellStyle thStyle = workbook.createCellStyle();
        // 设置这些样式
        thStyle.setFillForegroundColor(HSSFColor.WHITE.index);//表格颜色
        thStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        thStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        thStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        thStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        thStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        thStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 生成一个字体
        HSSFFont thFont = workbook.createFont();
        //font.setColor(HSSFColor.VIOLET.index);//字体颜色
        thFont.setFontHeightInPoints((short) 12);
        thFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 把字体应用到当前的样式
        thStyle.setFont(thFont);


        // 2 生成并设置另一个样式 表格内容样式
        HSSFCellStyle contentStyle = workbook.createCellStyle();
        contentStyle.setFillForegroundColor(HSSFColor.WHITE.index);
        contentStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        contentStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        contentStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        contentStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        contentStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        contentStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        contentStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        // 生成另一个字体
        HSSFFont contentFont = workbook.createFont();
        contentFont.setColor(HSSFColor.BLACK.index);


        contentFont.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        // 把字体应用到当前的样式
        contentStyle.setFont(contentFont);

        // 声明一个画图的顶级管理器
        HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
        // 定义注释的大小和位置,详见文档
        /*HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0,
                0, 0, 0, (short) 4, 2, (short) 6, 5));
        // 设置注释内容
        comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));
        // 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
        comment.setAuthor("web");*/

        HSSFRow rowLogo = sheet.createRow(0);
        HSSFCell logoCell= rowLogo.createCell(0);
        for(int i=0;i<headers.length;i++){
            logoCell=rowLogo.createCell(i);
            logoCell.setCellStyle(logoStyle);
        }
        logoCell=rowLogo.createCell(0);
        CellRangeAddress logoCRA=new CellRangeAddress(0,0,0,headers.length-1);
        sheet.addMergedRegion(logoCRA);
        logoCell.setCellStyle(logoStyle);
        //logoCell.setCellValue("        青海绿电电力运维技术有限公司");
        logoCell.setCellValue(logoTitle);


        HSSFRow rowTitle = sheet.createRow(1);
        HSSFCell titleCell= rowTitle.createCell(0);
        for(int i=0;i<headers.length;i++){
            titleCell=rowTitle.createCell(i);
            titleCell.setCellStyle(contentStyle);
        }
        titleCell= rowTitle.createCell(0);
        CellRangeAddress titleCRA=new CellRangeAddress(1,1,0,headers.length-1);
        sheet.addMergedRegion(titleCRA);
        titleCell.setCellStyle(titleStyle);
        titleCell.setCellValue(tableTile);
        // 产生表格标题行
        HSSFRow row = sheet.createRow(2);
        row.createCell(0);
        for (short i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellStyle(thStyle);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

        if(dataset!=null){
            // 遍历集合数据，产生数据行
            Iterator<T> it = dataset.iterator();
            int index = 2;
            HSSFFont font3 = workbook.createFont();
            while (it.hasNext()) {
                index++;
                row = sheet.createRow(index);
                T t = (T) it.next();
                // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
                Field[] fields = t.getClass().getDeclaredFields();
                for (short i = 0; i < fields.length; i++) {
                    HSSFCell cell = row.createCell(i);
                    cell.setCellStyle(contentStyle);
                    Field field = fields[i];
                    String fieldName = field.getName();
                    String getMethodName = "get"
                            + fieldName.substring(0, 1).toUpperCase()
                            + fieldName.substring(1);
                    try {
                        Class tCls = t.getClass();
                        Method getMethod = tCls.getMethod(getMethodName,
                                new Class[] {});
                        Object value = getMethod.invoke(t, new Object[] {});
                        // 判断值的类型后进行强制类型转换
                        String textValue = null;
                        if (value instanceof Boolean) {
                            boolean bValue = (Boolean) value;
                            textValue = "男";
                            if (!bValue) {
                                textValue = "女";
                            }
                        } else if (value instanceof Date) {
                            Date date = (Date) value;
                            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                            textValue = sdf.format(date);
                        } else if (value instanceof byte[]) {
                            // 有图片时，设置行高为60px;
                            row.setHeightInPoints(60);
                            // 设置图片所在列宽度为80px,注意这里单位的一个换算
                            sheet.setColumnWidth(i, (short) (35.7 * 80));
                            // sheet.autoSizeColumn(i);
                            byte[] bsValue = (byte[]) value;
                            HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0,
                                    1023, 255, (short) 6, index, (short) 6, index);
                            anchor.setAnchorType(2);
                            patriarch.createPicture(anchor, workbook.addPicture(
                                    bsValue, HSSFWorkbook.PICTURE_TYPE_JPEG));
                        } else {
                            // 其它数据类型都当作字符串简单处理
                            textValue = value==null?"":value.toString();
                        }
                        // 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
                        if (textValue != null) {
                            Pattern p = Pattern.compile("^//d+(//.//d+)?$");
                            Matcher matcher = p.matcher(textValue);
                            if (matcher.matches()) {
                                // 是数字当作double处理
                                cell.setCellValue(Double.parseDouble(textValue));
                            } else {
                                HSSFRichTextString richString = new HSSFRichTextString(
                                        textValue);

                                //font3.setColor(HSSFColor.BLUE.index);
                                richString.applyFont(font3);
                                cell.setCellValue(richString);
                            }
                        }
                    } catch (SecurityException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IllegalArgumentException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } finally {
                    }
                }

            }
        }

        try {
            workbook.write(out);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        // 测试学生
        ExportExcel<Student> ex = new ExportExcel<Student>();
        String[] headers = { "学号", "姓名", "年龄", "性别", "出生日期" };
        List<Student> dataset = new ArrayList<Student>();
        dataset.add(new Student(10000001, "张三", 20, true, new Date()));
        dataset.add(new Student(20000002, "李四", 24, false, new Date()));
        dataset.add(new Student(30000003, "王五", 22, true, new Date()));
        // 测试图书

        try {
            BufferedInputStream bis = new BufferedInputStream(
                    new FileInputStream("e://book.png"));
            byte[] buf = new byte[bis.available()];
            while ((bis.read(buf)) != -1) {
                //
            }


            OutputStream out = new FileOutputStream("E://a.xls");
            OutputStream out2 = new FileOutputStream("E://b.xls");
            ex.exportExcel(headers, dataset, out);
            //ex.exportExcel("student", headers, dataset, out, "yyyy-MM-dd","xxx");
            out.close();
            JOptionPane.showMessageDialog(null, "导出成功!");
            System.out.println("excel导出成功！");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
