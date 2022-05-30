package utils;

import Hook.Hook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ExcelUtility {



    public static List<List<String>> readExcel(String file, String pageName) throws IOException {

        List<List<String>> listofValues=new LinkedList<>();

        InputStream input= new FileInputStream(file);

        Workbook workbook = WorkbookFactory.create(input);
        Sheet sheet = workbook.getSheet(pageName);
        int rowNum=sheet.getPhysicalNumberOfRows();
        for (int i = 0; i < rowNum; i++) {
            Row row = sheet.getRow(i);
            int cellNum=row.getPhysicalNumberOfCells();
            List<String>listOfCells=new LinkedList<>();
            for (int j = 0; j < cellNum; j++) {
                Cell cell = row.getCell(j);
                String cellValue=cell==null ? "" : cell.toString();
                listOfCells.add(cellValue);
            }
            listofValues.add(listOfCells);
        }
        return listofValues;
    }
    public static void writeToExcel (String...datas){
        List<String>data=new ArrayList<>();
        for (String s : datas) {
            data.add(s);
        }
        writeToExcel(Hook.path+Hook.fileName,Hook.sheet,data);
    }

    public static void writeToExcel (List<String> data){

        writeToExcel(Hook.path+Hook.fileName,Hook.sheet,data);
    }

    public static void writeToExcel(String path, String sheetName, List<String> data) {

        File f = new File(path);

        if (!f.exists()) {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet(sheetName);


            Row row = sheet.createRow(0);
            for (int i = 0; i < data.size(); i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(data.get(i));
            }
            FileOutputStream out = null;
            try {
                out = new FileOutputStream(path);
                workbook.write(out);
                workbook.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            FileInputStream input = null;
            Workbook workbook=null;
            Sheet sheet = null;
            try {
                input = new FileInputStream(path);
                workbook = WorkbookFactory.create(input);
                sheet = workbook.getSheet(sheetName);
                if (sheet==null){
                    sheet=workbook.createSheet(sheetName);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            int numOfRows = sheet.getPhysicalNumberOfRows();

            Row row = sheet.createRow(numOfRows);
            for (int i = 0; i < data.size(); i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(data.get(i));
            }

            FileOutputStream output=null;

            try {
                input.close();
                output=new FileOutputStream(path);
                workbook.write(output);
                workbook.close();
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getCurrentTime(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    }
}
