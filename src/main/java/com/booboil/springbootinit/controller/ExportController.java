package com.booboil.springbootinit.controller;

import com.booboil.springbootinit.model.dto.excel.TimeConditionRange;
import com.booboil.springbootinit.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author booboil
 * @description 导出接口
 */
@Api(tags = "项目大表盘相关接口")
@RestController
@RequestMapping("/export")
@Slf4j

public class ExportController {

    @Resource
    private UserService userService;

    @ApiOperation(value = "导出系统日志")
    @GetMapping("/exportSystemLog")
    public void exportLog(TimeConditionRange timeConditionRange, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            userService.exportLog(timeConditionRange, request, response);
        } catch (Exception e) {
            log.error("导出系统日志数据发生错误：", e);
        }
    }

}
