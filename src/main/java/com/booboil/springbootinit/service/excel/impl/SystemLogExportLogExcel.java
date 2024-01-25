package com.booboil.springbootinit.service.excel.impl;

import com.booboil.springbootinit.model.dto.excel.ExcelField;
import com.booboil.springbootinit.model.entity.User;
import com.booboil.springbootinit.service.excel.BaseExcelTemplate;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.core.io.ClassPathResource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class SystemLogExportLogExcel implements BaseExcelTemplate {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private List<User> datas;

    public SystemLogExportLogExcel(List<User> datas) {
        this.datas = datas;
    }

    @Override
    public ExcelField[] getFields(HttpServletRequest request, Locale locale) {
        return new ExcelField[0];
    }


    @Override
    public Workbook generateExcel(HttpServletRequest request) throws Exception {
        ClassPathResource classPathResource = new ClassPathResource("/userLog_template.xlsx");
        InputStream inputStream = classPathResource.getInputStream();
        // 读取源文件
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);

        // 设置统一样式
        XSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER); // 居中
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        ; // 居中
        XSSFFont font = workbook.createFont();
        font.setFontName("微软雅黑");
        font.setFontHeightInPoints((short) 10);//设置字体大小
        cellStyle.setFont(font);//选择需要用到的字体格式
        cellStyle.setBorderBottom(BorderStyle.THIN); //下边框
        cellStyle.setBorderLeft(BorderStyle.THIN);//左边框
        cellStyle.setBorderTop(BorderStyle.THIN);//上边框
        cellStyle.setBorderRight(BorderStyle.THIN);//右边框
        cellStyle.setWrapText(true);

        int rowNum = 1;
        for (User data : datas) {
            XSSFRow row = sheet.getRow(rowNum);
            if (row == null) {
                row = sheet.createRow(rowNum);
            }
            for (int i = 0; i < 5; i++) {
                XSSFCell cell = row.getCell(i);
                if (cell == null) {
                    cell = row.createCell(i);
                }
                cell.setCellStyle(cellStyle);
            }
            row.getCell(0).setCellValue(rowNum);
            row.getCell(1).setCellValue(sdf.format(data.getCreateTime()));
            row.getCell(2).setCellValue(data.getUserName());
            row.getCell(3).setCellValue(data.getUserAccount());
            row.getCell(4).setCellValue(data.getUserRole());

            rowNum++;
        }
        return workbook;
    }

    @Override
    public void injectTitle(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("excelTitle", "用户导出日志");
    }

}