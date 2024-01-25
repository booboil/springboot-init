package com.booboil.springbootinit.model.dto.excel;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

public class ExcelField {
	private String value;
	private String name;

	private boolean isSelected;

	private short align;
	private short width;

	private String unit;

	public static HorizontalAlignment getHorizontalAlignment(short align) {
		return HorizontalAlignment.forInt(align);
	}

	public static BorderStyle getBorderStyle(short styleValue) {
		return BorderStyle.valueOf(styleValue);
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSelected() {
		return this.isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

	public short getAlign() {
		return this.align;
	}

	public void setAlign(short align) {
		this.align = align;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public short getWidth() {
		return this.width;
	}

	public void setWidth(short width) {
		this.width = width;
	}
}
