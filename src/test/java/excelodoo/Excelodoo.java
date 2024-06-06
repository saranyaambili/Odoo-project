package excelodoo;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelodoo {
	public static String setcellvalue(String excel,String sheet,int r,int c) throws IOException {
		try {
			FileInputStream f= new FileInputStream(excel);
			XSSFWorkbook wb = new XSSFWorkbook(f) ;
				XSSFCell cell=wb.getSheet(sheet).getRow(r).getCell(c);
				if(cell.getCellType()==CellType.STRING) {
					return cell.getStringCellValue();
				}
				else {
					return cell.getRawValue();
				}
			
		} catch (Exception e) {
				
		return "";
		}}
	public static int getrowcount(String excel,String sheet) throws IOException {
		FileInputStream f=new FileInputStream(excel);
		XSSFWorkbook wb=new XSSFWorkbook(f);
		return wb.getSheet(sheet).getLastRowNum();
	}
	 

}
