package com.booboil.springbootinit.service.pdf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ExportPdfService {

    void export(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
