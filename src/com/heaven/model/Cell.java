package com.heaven.model;

public class Cell {
    private Long id;

    private Long rowsnum;

    private Long colsnum;

    private String text;

    private String fixcaption;

    private String expzz;

    private String displayexp;

    private String condition;

    private String filterzz;

    private String url;

    private String detailname;

    private String reportName;

    private String reportAlias;

    private String reportCaption;

    private String reportId;

    private String reportTaskid;

    private String reportType;

    private String qcName;

    private String qcList;

    private String isZq;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRowsnum() {
        return rowsnum;
    }

    public void setRowsnum(Long rowsnum) {
        this.rowsnum = rowsnum;
    }

    public Long getColsnum() {
        return colsnum;
    }

    public void setColsnum(Long colsnum) {
        this.colsnum = colsnum;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public String getFixcaption() {
        return fixcaption;
    }

    public void setFixcaption(String fixcaption) {
        this.fixcaption = fixcaption == null ? null : fixcaption.trim();
    }

    public String getExpzz() {
        return expzz;
    }

    public void setExpzz(String expzz) {
        this.expzz = expzz == null ? null : expzz.trim();
    }

    public String getDisplayexp() {
        return displayexp;
    }

    public void setDisplayexp(String displayexp) {
        this.displayexp = displayexp == null ? null : displayexp.trim();
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition == null ? null : condition.trim();
    }

    public String getFilterzz() {
        return filterzz;
    }

    public void setFilterzz(String filterzz) {
        this.filterzz = filterzz == null ? null : filterzz.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getDetailname() {
        return detailname;
    }

    public void setDetailname(String detailname) {
        this.detailname = detailname == null ? null : detailname.trim();
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName == null ? null : reportName.trim();
    }

    public String getReportAlias() {
        return reportAlias;
    }

    public void setReportAlias(String reportAlias) {
        this.reportAlias = reportAlias == null ? null : reportAlias.trim();
    }

    public String getReportCaption() {
        return reportCaption;
    }

    public void setReportCaption(String reportCaption) {
        this.reportCaption = reportCaption == null ? null : reportCaption.trim();
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId == null ? null : reportId.trim();
    }

    public String getReportTaskid() {
        return reportTaskid;
    }

    public void setReportTaskid(String reportTaskid) {
        this.reportTaskid = reportTaskid == null ? null : reportTaskid.trim();
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType == null ? null : reportType.trim();
    }

    public String getQcName() {
        return qcName;
    }

    public void setQcName(String qcName) {
        this.qcName = qcName == null ? null : qcName.trim();
    }

    public String getQcList() {
        return qcList;
    }

    public void setQcList(String qcList) {
        this.qcList = qcList == null ? null : qcList.trim();
    }

    public String getIsZq() {
        return isZq;
    }

    public void setIsZq(String isZq) {
        this.isZq = isZq == null ? null : isZq.trim();
    }

	@Override
	public String toString() {
		return "Cell [id=" + id + ", rowsnum=" + rowsnum + ", colsnum=" + colsnum + ", text=" + text + ", fixcaption="
				+ fixcaption + ", expzz=" + expzz + ", displayexp=" + displayexp + ", condition=" + condition
				+ ", filterzz=" + filterzz + ", url=" + url + ", detailname=" + detailname + ", reportName="
				+ reportName + ", reportAlias=" + reportAlias + ", reportCaption=" + reportCaption + ", reportId="
				+ reportId + ", reportTaskid=" + reportTaskid + ", reportType=" + reportType + ", qcName=" + qcName
				+ ", qcList=" + qcList + ", isZq=" + isZq + "]";
	}
    
    
}