package com.study.gradesInfo;

import com.study.gradesInfo.entity.Student;
import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class openExcel {
    @Test
    public void main() {
        try {
            // 指定 Excel 文件路径
            String filePath = "C:\\Users\\Dicloug\\Desktop\\student.xlsx";

            // 创建 FileInputStream 对象
            FileInputStream fis = new FileInputStream(new File(filePath));
            // 创建 Workbook 对象，打开 Excel 文件
            Workbook workbook = WorkbookFactory.create(fis);

            // 获取第一个 Sheet
            Sheet sheet = workbook.getSheetAt(0);
            Row firstRow = sheet.getRow(0);
            Map<Integer, String> columnMap = new HashMap<>();
            for (Cell cell : firstRow) {
                // 读取单元格中的数据
                int columnIndex = cell.getColumnIndex();
                String columnHeader = cell.getStringCellValue();
                columnMap.put(columnIndex, columnHeader);
            }

            // 遍历 Sheet 中的每一行
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);

                Student student = new Student();
                String academyId = "";
                String classId = "";
                // 遍历当前行中的每一列
                for (Cell cell : row) {
                    int columnIndex = cell.getColumnIndex();
                    String columnHeader = columnMap.get(columnIndex);

                    // 根据列的含义进行相应的处理
                    switch (columnHeader) {
                        case "ID":
                            // 处理 ID 列
                            break;
                        case "studentId":
                            switch (cell.getCellType()) {
                                case STRING:
                                    student.setStudentId(cell.getStringCellValue());
                                    break;
                                case NUMERIC:
                                    student.setStudentId(String.valueOf(cell.getNumericCellValue()));
                                    break;
                                case BOOLEAN:
                                    System.out.print("Boolean Type\t");
                                    break;
                                default:
                                    System.out.print("Unknown Type\t");
                            }
                            break;
                        case "studentName":
                            switch (cell.getCellType()) {
                                case STRING:
                                    student.setStudentName(cell.getStringCellValue());
                                    break;
                                case NUMERIC:
                                    student.setStudentName(String.valueOf(cell.getNumericCellValue()));
                                    break;
                                case BOOLEAN:
                                    System.out.print("Boolean Type\t");
                                    break;
                                default:
                                    System.out.print("Unknown Type\t");
                            }
                            break;
                        case "gender":
                            switch (cell.getCellType()) {
                                case STRING:
                                    student.setGender(cell.getStringCellValue());
                                    break;
                                case NUMERIC:
                                    student.setGender(String.valueOf(cell.getNumericCellValue()));
                                    break;
                                case BOOLEAN:
                                    System.out.print("Boolean Type\t");
                                    break;
                                default:
                                    System.out.print("Unknown Type\t");
                            }
                            break;
                        case "age":
                            switch (cell.getCellType()) {
                                case STRING:
                                    student.setAge(Integer.valueOf(cell.getStringCellValue()));
                                    break;
                                case NUMERIC:
                                    student.setAge((int) cell.getNumericCellValue());
                                    break;
                                case BOOLEAN:
                                    System.out.print("Boolean Type\t");
                                    break;
                                default:
                                    System.out.print("Unknown Type\t");
                            }
                            break;
                        case "academyId":
                            switch (cell.getCellType()) {
                                case STRING:
                                    academyId = cell.getStringCellValue();
                                    break;
                                case NUMERIC:
                                    academyId = String.valueOf(cell.getNumericCellValue());
                                    break;
                                case BOOLEAN:
                                    System.out.print("Boolean Type\t");
                                    break;
                                default:
                                    System.out.print("Unknown Type\t");
                            }
                            break;
                        case "classId":
                            switch (cell.getCellType()) {
                                case STRING:
                                    classId = cell.getStringCellValue();
                                    break;
                                case NUMERIC:
                                    classId = String.valueOf(cell.getNumericCellValue());
                                    break;
                                case BOOLEAN:
                                    System.out.print("Boolean Type\t");
                                    break;
                                default:
                                    System.out.print("Unknown Type\t");
                            }
                            break;
                    }

                }
                System.out.println(student);
                System.out.println(academyId);
                System.out.println(classId);
            }

            // 关闭 Workbook 和 FileInputStream
            workbook.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
