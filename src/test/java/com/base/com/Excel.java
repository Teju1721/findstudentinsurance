package com.base.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
    public String Destination;
    public String MobileNo;
    public String Name;
    public String Email;
    public String Mobileno2;
    

    public void readData() throws IOException {
    	
    	 String currentDir = System.getProperty("user.dir");

         // Define the relative path to the file
         String relativePath = "\\src\\test\\resources\\TestData\\Traveldata.xlsx";

         // Join the current directory with the relative path
         String filePath = currentDir + relativePath;
   
        // Create a FileInputStream to read the Excel file
        FileInputStream fis = new FileInputStream(new File(filePath));

        // Create a Workbook instance for .xlsx file
        Workbook workbook = new XSSFWorkbook(fis);

        // Get the first sheet
        Sheet sheet = workbook.getSheetAt(0);

        // Get the row containing user id and password (assuming they are in the first row)
        Row row = sheet.getRow(1);

        // Get the cell containing the destination
        Cell destinationCell = row.getCell(0);
        if (destinationCell.getCellType() == CellType.STRING) {
            Destination = destinationCell.getStringCellValue();
        } else {
            Destination = String.valueOf(destinationCell.getNumericCellValue());
        }

        // Get the cell containing the mobile number
        Cell mobileNoCell = row.getCell(1);
        if (mobileNoCell.getCellType() == CellType.STRING) {
            MobileNo = mobileNoCell.getStringCellValue();
        } else {
            double mobileNoValue = mobileNoCell.getNumericCellValue();
            DecimalFormat decimalFormat = new DecimalFormat("#");
            MobileNo = decimalFormat.format(mobileNoValue);
        }
        
        Sheet sheet2= workbook.getSheetAt(1); // taking data from sheet 2
        Row row1= sheet2.getRow(1);
        
         //Name=row1.getCell(0);
         Cell NameCell = row1.getCell(0);
         if (NameCell.getCellType() == CellType.STRING) {
             Name = NameCell.getStringCellValue();
         } else {
             Name = String.valueOf(NameCell.getNumericCellValue());
         }
         //Email= row1.getCell(1);
         Cell EmailCell = row1.getCell(1);
         if (EmailCell.getCellType() == CellType.STRING) {
             Email = EmailCell.getStringCellValue();
         } else {
             Email = String.valueOf(EmailCell.getNumericCellValue());
         }
//         Mobileno2=row1.getCell(3);
         Cell mobileNoCell2 = row1.getCell(2);
         if (mobileNoCell2 != null) {
             if (mobileNoCell2.getCellType() == CellType.STRING) {
                 Mobileno2 = mobileNoCell2.getStringCellValue();
             } else {
                 double mobileNoValue = mobileNoCell2.getNumericCellValue();
                 DecimalFormat decimalFormat = new DecimalFormat("#");
                 Mobileno2 = decimalFormat.format(mobileNoValue);
             }
             
         } else {
             
         }
         
         

        // Close the workbook and file stream
        workbook.close();
        fis.close();
    }
}
