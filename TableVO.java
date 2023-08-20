package day0817;

public class TableVO {
	private String columnName;
	private	String dataType;
	private	String dataLength;
	private String nullable;
	private	String dataPrecision;
	private String dataDefualt;
	
	
	
	public TableVO() {
	
	}

	public TableVO(String columnName, String dataType, String dataLength, String dataPrecision, String nullable,
			String dataDefualt) {
		this.columnName = columnName;
		this.dataType = dataType;
		this.dataLength = dataLength;
		this.dataPrecision = dataPrecision;
		this.nullable = nullable;
		this.dataDefualt = dataDefualt;
	}

	public String getDataDefualt() {
		return dataDefualt;
	}

	public String getColumnName() {
		return columnName;
	}


	public String getDataType() {
		return dataType;
	}


	public String getDataLength() {
		return dataLength;
	}


	public String getNullable() {
		return nullable;
	}


	public String getDataPrecision() {
		return dataPrecision;
	}


	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}


	public void setDataType(String dataType) {
		this.dataType = dataType;
	}


	public void setDataLength(String dataLength) {
		this.dataLength = dataLength;
	}


	public void setNullable(String nullable) {
		this.nullable = nullable;
	}


	public void setDataPrecision(String dataPrecision) {
		this.dataPrecision = dataPrecision;
	}


	public void setDataDefualt(String dataDefualt) {
		this.dataDefualt = dataDefualt;
	}



	@Override
	public String toString() {
		return "TableVO [columnName=" + columnName + ", dataType=" + dataType + ", dataLength=" + dataLength
				+ ", nullable=" + nullable + ", dataPrecision=" + dataPrecision + ", dataDefualt=" + dataDefualt + "]";
	}
	
	
}
