package com.booboil.springbootinit.service.pdf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jinbing.tong
 */
public interface BaseExportPdfTemplate {

	void exportPdf(HttpServletRequest request, HttpServletResponse response);

}
