package com.booboil.springbootinit.service.pdf.impl;

import com.booboil.springbootinit.model.enums.PortfolioExportPdfEnum;
import com.booboil.springbootinit.service.pdf.BaseExportPdfTemplate;
import com.booboil.springbootinit.service.pdf.ExportPdfService;
import com.thoughtworks.xstream.converters.ConversionException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class ExportServiceImpl implements ExportPdfService {

    /**
     * 导出PDF
     * @param request 请求
     * @param response 响应
     * @throws Exception
     */
    @Override
    public void export(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer reportId = Integer.parseInt(request.getParameter("reportID"));
        PortfolioExportPdfEnum pdfEnum = PortfolioExportPdfEnum.getEnumByCode(reportId);
        if (pdfEnum == null) {
            throw new Exception("传入的报表id错误!!!");
        }
        try {
            BaseExportPdfTemplate template = (BaseExportPdfTemplate) Class.forName(pdfEnum.getClassName()).newInstance();
            template.exportPdf(request,response);
        } catch (Exception e) {
            throw new ConversionException("Exception in conversion: " + e.getMessage(), e);
        }
    }
}
