package com.booboil.springbootinit.service.excel;

import com.booboil.springbootinit.model.dto.excel.ExcelField;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public interface BaseExcelTemplate {

    ExcelField[] getFields(HttpServletRequest request, Locale locale);

    Workbook generateExcel(HttpServletRequest request) throws Exception;

    void injectTitle(HttpServletRequest request);

    default void init(List<Map<String, Object>> modes) {}

    default void init1(List<Object> modes) {}
}
