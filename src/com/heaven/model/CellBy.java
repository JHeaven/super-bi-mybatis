package com.heaven.model;

public class CellBy {
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

    private String byCell;

    private String byFloat;

    private String byFloatrange;

    private String byFloattype;

    private String byFixcaption;

    private String byCondition;

    private Long h;

    private Long l;

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

    public String getByCell() {
        return byCell;
    }

    public void setByCell(String byCell) {
        this.byCell = byCell == null ? null : byCell.trim();
    }

    public String getByFloat() {
        return byFloat;
    }

    public void setByFloat(String byFloat) {
        this.byFloat = byFloat == null ? null : byFloat.trim();
    }

    public String getByFloatrange() {
        return byFloatrange;
    }

    public void setByFloatrange(String byFloatrange) {
        this.byFloatrange = byFloatrange == null ? null : byFloatrange.trim();
    }

    public String getByFloattype() {
        return byFloattype;
    }

    public void setByFloattype(String byFloattype) {
        this.byFloattype = byFloattype == null ? null : byFloattype.trim();
    }

    public String getByFixcaption() {
        return byFixcaption;
    }

    public void setByFixcaption(String byFixcaption) {
        this.byFixcaption = byFixcaption == null ? null : byFixcaption.trim();
    }

    public String getByCondition() {
        return byCondition;
    }

    public void setByCondition(String byCondition) {
        this.byCondition = byCondition == null ? null : byCondition.trim();
    }

    public Long getH() {
        return h;
    }

    public void setH(Long h) {
        this.h = h;
    }

    public Long getL() {
        return l;
    }

    public void setL(Long l) {
        this.l = l;
    }

	@Override
	public String toString() {
		return "CellBy [id=" + id + ", rowsnum=" + rowsnum + ", colsnum=" + colsnum + ", text=" + text + ", fixcaption="
				+ fixcaption + ", expzz=" + expzz + ", displayexp=" + displayexp + ", condition=" + condition
				+ ", filterzz=" + filterzz + ", url=" + url + ", detailname=" + detailname + ", reportName="
				+ reportName + ", reportAlias=" + reportAlias + ", reportCaption=" + reportCaption + ", reportId="
				+ reportId + ", reportTaskid=" + reportTaskid + ", reportType=" + reportType + ", byCell=" + byCell
				+ ", byFloat=" + byFloat + ", byFloatrange=" + byFloatrange + ", byFloattype=" + byFloattype
				+ ", byFixcaption=" + byFixcaption + ", byCondition=" + byCondition + ", h=" + h + ", l=" + l + "]";
	}
    
    
}