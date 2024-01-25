package com.booboil.springbootinit.controller;

import com.booboil.springbootinit.common.BaseResponse;

import com.booboil.springbootinit.service.pdf.ExportPdfService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


@Slf4j
@Api(tags = "通用接口")
@RestController
@RequestMapping("common/pdf")
public class ExportPdfController {

    @Autowired
    Map<String, ExportPdfService> exportPdfServiceMap;
    /**
     * 导出PDF
     * @param request
     * @param response
     */
    @ApiOperation("导出PDF")
    @GetMapping("/export")
    public BaseResponse exportPdf(HttpServletRequest request, HttpServletResponse response) throws Exception {
        log.info("exportPdfServiceMap:{}",exportPdfServiceMap);
        log.info("operation:{}, exportPdfServiceMapResult:{}", StringUtils.isEmpty(request.getParameter("operation")),
                !exportPdfServiceMap.containsKey(request.getParameter("operation")));

        if (StringUtils.isEmpty(request.getParameter("operation")) ||
                !exportPdfServiceMap.containsKey(request.getParameter("operation"))) {

            String msg = String.format("操作参数为空或错误，导出失败！[operation]：%s", request.getParameter("operation"));
            log.warn(msg);
            return null;
        }

        exportPdfServiceMap.get(request.getParameter("operation")).export(request, response);
        return null;
    }
}
