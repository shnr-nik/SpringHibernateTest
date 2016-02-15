package com.shnarevich.util;

import com.shnarevich.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ExcelParser {
    private static final int CODE  = 0;
    private static final int NAME  = 1;
    private static final int PRICE = 2;
    private static final int DATE  = 3;

    public static List<Product> getProductsList(MultipartFile file) throws Exception {

        List<Product> products = new ArrayList<>();

        Workbook workbook;

        if (file.getOriginalFilename().endsWith(".xls")) workbook  = new HSSFWorkbook(file.getInputStream());
        else {
            if (file.getOriginalFilename().endsWith(".xlsx")) workbook = new XSSFWorkbook(file.getInputStream());
            else {
                throw new IllegalArgumentException("Incorrect file type: expected .xls or .xlsx");
            }
        }

        Sheet firstSheet = workbook.getSheetAt(0);

        for (Row nextRow : firstSheet) {
            Product product = new Product();
            try {
                product.setCode((int) nextRow.getCell(CODE).getNumericCellValue());
                product.setName(nextRow.getCell(NAME).getStringCellValue());
                product.setPrice(nextRow.getCell(PRICE).getNumericCellValue());
                product.setDate(nextRow.getCell(DATE).getDateCellValue());
            } catch (Exception e) {
                log.error(e.toString());
                throw new Exception("Incorrect data");
            }
            products.add(product);
        }
        return products;
    }
}