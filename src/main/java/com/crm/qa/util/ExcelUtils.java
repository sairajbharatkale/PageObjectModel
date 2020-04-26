package com.crm.qa.util;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	static XSSFWorkbook workbook;

	static XSSFSheet sheet;

	public static XSSFRow row = null;

	public static XSSFCell cell = null;

	public ExcelUtils(String excelPath, String sheetName)
	{
		try
		{
			FileInputStream fis = new FileInputStream(excelPath);

			workbook = new XSSFWorkbook(fis);

			sheet = workbook.getSheet(sheetName);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static int getRowCount()
	{
		int rowCount = 0;

		try
		{
			rowCount = sheet.getPhysicalNumberOfRows();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rowCount;
	}

	public static int getColCount()
	{
		int colCount = 0;

		try
		{
			colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return colCount;
	}

	public static String getCellData(int rowNum, int colNum)
	{
		try
		{
			row = sheet.getRow(rowNum);

			cell = row.getCell(colNum);

			if(cell == null || cell.getCellType() == CellType.BLANK)
			{
				return"";
			}
			else if(cell.getCellType() == CellType.STRING)
			{
				return cell.getStringCellValue();
			}
			else if((cell.getCellType() == CellType.NUMERIC)|| (cell.getCellType() == CellType.FORMULA))
			{
				String cellValue = new BigDecimal(cell.getNumericCellValue()).toPlainString();

				if(HSSFDateUtil.isCellDateFormatted(cell))
				{
					SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yy");

					Date date = cell.getDateCellValue();

					cellValue = dt.format(date);

				}
				return cellValue;
			}
			else 
			{
				return String.valueOf(cell.getBooleanCellValue());
			}

		}
		catch(Exception e)
		{
			//e.printStackTrace();

			return "Please enter correct row no and col no";


		}
	}



	public static Object[][] testData(String excelPath, String sheetName)
	{
		ExcelUtils obj = new ExcelUtils(excelPath, sheetName);

		int rowCount = obj.getRowCount();

		int colCount = obj.getColCount();

		Object data[][] = new Object[rowCount - 1][colCount];

		for(int i = 1; i < rowCount; i++)
		{
			for(int j = 0; j < colCount; j++)
			{
				String cellData = obj.getCellData(i, j);

				//System.out.print(cellData + "   |   ");

				data[i-1][j] = cellData;
			}

	

		}
		return data;


	}

	

	 



}

