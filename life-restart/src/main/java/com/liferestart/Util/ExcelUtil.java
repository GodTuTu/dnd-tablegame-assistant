package com.liferestart.Util;


import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferestart.entity.form.response.EventResponse;
import com.liferestart.entity.po.Event;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: 灵枢
 * Date: 2018/12/05
 * Time: 17:21
 * Description:读取Excel数据
 */
public class ExcelUtil {
    private XSSFSheet sheet;

    /**
     * 构造函数，初始化excel数据
     *
     * @param filePath  excel路径
     * @param sheetName sheet表名
     */
    ExcelUtil(String filePath, String sheetName) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            XSSFWorkbook sheets = new XSSFWorkbook(fileInputStream);
            //获取sheet
            sheet = sheets.getSheet(sheetName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据行和列的索引获取单元格的数据
     *
     * @param row
     * @param column
     * @return
     */
    public String getExcelDateByIndex(int row, int column) {
        XSSFRow row1 = sheet.getRow(row);
        String cell = row1.getCell(column).toString();
        return cell;
    }

    /**
     * 根据某一列值为“******”的这一行，来获取该行第x列的值
     *
     * @param caseName
     * @param currentColumn 当前单元格列的索引
     * @param targetColumn  目标单元格列的索引
     * @return
     */
    public String getCellByCaseName(String caseName, int currentColumn, int targetColumn) {
        String operateSteps = "";
        //获取行数
        int rows = sheet.getPhysicalNumberOfRows();
        for (int i = 0; i < rows; i++) {
            XSSFRow row = sheet.getRow(i);
            String cell = row.getCell(currentColumn).toString();
            if (cell.equals(caseName)) {
                operateSteps = row.getCell(targetColumn).toString();
                break;
            }
        }
        return operateSteps;
    }

    //打印excel数据
    public void readExcelData() {
        //获取行数
        JSONObject beanJson = new JSONObject();
        List<Event> events = new ArrayList<>();
        Map<Integer, String> keys = new HashMap<>();
        int rows = sheet.getPhysicalNumberOfRows();
        for (int i = 1; i < rows; i++) {
            //获取列数
            XSSFRow row = sheet.getRow(i);
            int columns = row.getPhysicalNumberOfCells();
            for (int j = 0; j < columns; j++) {
                String cell = row.getCell(j).toString();
                System.out.println(cell + "-----------" + i);
                if (i < 2) {
                    keys.put(j, cell);
                } else {
                    try {

                        Integer cell1 = Integer.valueOf((int) Double.parseDouble(cell));
                        beanJson.put(keys.get(j), cell1);
                        System.out.println(cell + "进来了" + cell1);
                    } catch (NumberFormatException e) {
                        System.out.println(cell + "没进来");
                        beanJson.put(keys.get(j), cell);
                        continue;
                    }

                }
            }
            if (i >= 2) {
                ObjectMapper mapper = new ObjectMapper();
                Event event = new Event();
                try {
                    event = mapper.readValue(beanJson.toString(), Event.class);
                    events.add(event);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


        System.out.println(events);
    }


    //测试方法
    public static void main(String[] args) {
        ExcelUtil sheet1 = new ExcelUtil("C:\\Users\\12611\\Downloads\\liferestart.xlsx", "事件");
//        //获取第二行第4列
//        String cell2 = sheet1.getExcelDateByIndex(1, 3);
//        //根据第3列值为“customer23”的这一行，来获取该行第2列的值
//        String cell3 = sheet1.getCellByCaseName("customer23", 2, 1);
//        System.out.println(cell2);
//        System.out.println(cell3);
        sheet1.readExcelData();
    }

}