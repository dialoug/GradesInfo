package com.study.gradesInfo.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.gradesInfo.entity.Student;
import com.study.gradesInfo.entity.utils.Result;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileUtil {
    private Workbook workbook;
    private Map<Integer, String> columnMap = new HashMap<>();
    private FileInputStream fis;

    public Sheet setFirstRow(String url) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(url);
            String filePath = jsonNode.get("url").asText();
            System.out.println(filePath);
            // 创建 FileInputStream 对象
            fis = new FileInputStream(filePath);
            // 创建 Workbook 对象，打开 Excel 文件
            workbook = WorkbookFactory.create(fis);
            // 获取第一个 Sheet
            Sheet sheet = workbook.getSheetAt(0);
            Row firstRow = sheet.getRow(0);
            for (
                    Cell cell : firstRow) {
                // 读取单元格中的数据
                int columnIndex = cell.getColumnIndex();
                String columnHeader = cell.getStringCellValue();
                columnMap.put(columnIndex, columnHeader);
            }
            return sheet;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("无法打开文件");
        }
        return null;
    }

    public String getColumnHeader(Cell cell) {
        int columnIndex = cell.getColumnIndex();
        return columnMap.get(columnIndex);
    }

    public String getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf((int) cell.getNumericCellValue());
            case BOOLEAN:
                return ("Boolean Type\t");
            default:
                return ("Unknown Type\t");
        }
    }

    public void closeFile() {
        try {
            // 关闭 Workbook 和 FileInputStream
            workbook.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("无法关闭文件");
        }
    }
}
