package com.booboil.springbootinit.model.enums;

import lombok.Getter;

/**
 * @author jinbing.tong
 */
@Getter
public enum PortfolioExportPdfEnum {

    exportPdfTaskDistributing(1501,"com.tcl.rd.tpm.service.etcommon.framework.report.exportTemplate.ExportPdfTaskDistributing"),
    exportPdfProjectStatus(401,"com.tcl.rd.tpm.service.etcommon.framework.report.exportTemplate.ExportPdfProjectStatus"),
    exportPdfPortfolioIssueDistribution(403,"com.tcl.rd.tpm.service.etcommon.framework.report.exportTemplate.ExportPdfPortfolioIssueDistribution"),
    exportPdfProjectWorkProduct(410,"com.tcl.rd.tpm.service.etcommon.framework.report.exportTemplate.ExportPdfProjectWorkProduct"),
    exportPdfProjectTaskDistributing(304,"com.tcl.rd.tpm.service.etcommon.framework.report.exportTemplate.ExportPdfTaskDistributing"),
    exportPdfScheduleContrastReport(302,"com.tcl.rd.tpm.service.etcommon.framework.report.exportTemplate.ExportPdfScheduleContrastReport"),
    exportPdfScheduleCostReport(307,"com.tcl.rd.tpm.service.etcommon.framework.report.exportTemplate.ExportPdfScheduleCostReport"),
    exportPdfEVAReport(306,"com.tcl.rd.tpm.service.etcommon.framework.report.exportTemplate.ExportPdfEVAReport"),
    exportPdfIssueTrend(312,"com.tcl.rd.tpm.service.etcommon.framework.report.exportTemplate.ExportPdfIssueTrend"),
    exportPdfIssueDuration(313,"com.tcl.rd.tpm.service.etcommon.framework.report.exportTemplate.ExportPdfIssueDuration"),
    exportPdfIssueDistributing(309,"com.tcl.rd.tpm.service.etcommon.framework.report.exportTemplate.ExportPdfIssueDistributing"),
    exportPdfMilestoneBudgetHourReport(334,"com.tcl.rd.tpm.service.etcommon.framework.report.exportTemplate.ExportPdfMilestoneBudgetHourReport"),
    exportPdfWorkDistributing(303,"com.tcl.rd.tpm.service.etcommon.framework.report.exportTemplate.ExportPdfWorkDistributing");

    Integer code;

    String className;

    PortfolioExportPdfEnum(Integer code, String className) {
        this.code = code;
        this.className = className;
    }

    public static PortfolioExportPdfEnum getEnumByCode(Integer code) {
        for (PortfolioExportPdfEnum freeEnum : PortfolioExportPdfEnum.values()) {
            if (freeEnum.getCode().equals(code)) {
                return freeEnum;
            }
        }
        return null;
    }
}
