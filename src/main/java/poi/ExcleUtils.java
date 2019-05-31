package poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import poi.pojo.CarBaseInfo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ExcleUtils {



    public  static void createSheet(){
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("新建sheet1");
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("第一個cell");
        try {
            FileOutputStream fos = new FileOutputStream("D:\\工作簿.xlsx");
             workbook.write(fos);
             fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> readExcleCarData(String filePath){
        List<CarBaseInfo> carBaseInfoList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(fis);

            Sheet sheetAt = workbook.getSheetAt(0);

            int lastRowNum = sheetAt.getPhysicalNumberOfRows();

            Row topRow = sheetAt.getRow(0);
            int cellNum = topRow.getPhysicalNumberOfCells();
            for(int i=1;i<lastRowNum;i++){
                CarBaseInfo carBaseInfo = new CarBaseInfo();
                Row row = sheetAt.getRow(i);
                for(int j=0;j<cellNum;j++){
                    setValues(topRow.getCell(j),row.getCell(j),carBaseInfo);
                }
                carBaseInfoList.add(carBaseInfo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private void setValues(Cell topCell, Cell cell, CarBaseInfo carBaseInfo) {
        String topCellValue = topCell.getStringCellValue();
        String stringCellValue = null;
        if (cell !=null){
             stringCellValue = cell.getStringCellValue();
        }
        Field[] declaredFields = carBaseInfo.getClass().getDeclaredFields();
        for(int i=0;i<declaredFields.length;i++){
            String name = declaredFields[i].getName();
            if (topCell.equals(name)){
                try {
                    String methodName = "set"+name.substring(0,1).toUpperCase()+name.substring(1);
                    Method method = carBaseInfo.getClass().getDeclaredMethod(methodName,declaredFields[i].getType());
                    method.invoke(carBaseInfo,stringCellValue);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
       /*ExcleUtils.createSheet();
        String s= "vinlist";
        System.out.println(s.substring(0,1).toUpperCase()+s.substring(1));*/

       ExcleUtils excleUtils = new ExcleUtils();
       excleUtils.readExcleCarData("D:\\副本GE11互博车造车信息0530.xlsx");
    }

}
