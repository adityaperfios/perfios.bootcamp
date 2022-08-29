package filehandling;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ReadWrite {
    public static void main(String[] args) {
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sh = wb.createSheet("Player Details");
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("1", new Object[]{"ID","Name","Lastname"});
        data.put("2", new Object[]{"101","Saurav","Suman"});
        data.put("3", new Object[]{"102","Deepak","Hooda"});
        data.put("4", new Object[]{"103","KL","Rahul"});
        data.put("5", new Object[]{"105","S","Iyer"});

        Set<String> keyset = data.keySet();
        int r = 0;
        for(String key: keyset){
            Row row = sh.createRow(r++);
            Object[] objArr = data.get(key);

            int cellnum = 0;
            for(Object obj:objArr){
                Cell cell = row.createCell(cellnum++);
                if(obj instanceof String)
                    cell.setCellValue((String)obj);
                else if(obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
            }
        }
        try{
            FileOutputStream out = new FileOutputStream(new File("/home/aditya/perfios.bootcamp/MavenProj/maven.xlsx"));
            wb.write(out);
            out.close();
            System.out.println("Done");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}