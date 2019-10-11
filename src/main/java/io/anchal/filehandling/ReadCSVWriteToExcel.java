package io.anchal.filehandling;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadCSVWriteToExcel {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		String fileName="D://sample.csv";
		
		@SuppressWarnings("deprecation")
		XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Java Books");
		
		BufferedReader csvReader = new BufferedReader(new FileReader(fileName));
		String row;
		int rowCount = 0;
		
		while ((row = csvReader.readLine()) != null) {
		    String[] data = row.split(",");
		    //for(String word:data) {System.out.println(word);}
		    Row row1 = sheet.createRow(rowCount++);
		    
		    int columnCount = 0;
            
            for (Object field : data) {
                Cell cell = row1.createCell(columnCount++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
		   
		}
		
        try (FileOutputStream outputStream = new FileOutputStream("D://JavaBooks.xlsx")) {
            workbook.write(outputStream);
        }
        csvReader.close();
	}

}
