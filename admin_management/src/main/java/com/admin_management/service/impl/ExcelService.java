package com.admin_management.service.impl;

import com.admin_management.model.bo.MessageExcels;
import com.admin_management.model.request.EvaluationRequestDetail;
import com.admin_management.model.response.EvaluationDetail;
import com.admin_management.model.response.EvaluationDetails;
import com.admin_management.model.response.EvaluationResponse;
import com.admin_management.model.response.EvaluationResponseDetail;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ExcelService {

    private final Logger logger = LogManager.getLogger(getClass());

    @Value("${app.server.upload.folder.path}")
    private String folderSaving;

    @SneakyThrows
    public <T> XSSFWorkbook exportExcelsEvaluation(EvaluationDetail evaluations, EvaluationRequestDetail request, List<String> fields, String template) throws IOException, IllegalAccessException {
        List<EvaluationResponse> data = evaluations.getEvaluationResponses();
        File file = new File(template);
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file));
        XSSFSheet sheet = workbook.getSheetAt(0);
        CellStyle headerStyle = getCellStyleHeader(workbook, getXssfFontHeader(workbook));
        String timeDisplay = String.format(MessageExcels.TIME_DISPLAY, DateTimeFormatter.ofPattern("dd/MM/yyyy").format(request.getDateFrom()),
                DateTimeFormatter.ofPattern("dd/MM/yyyy").format(request.getDateTo()));

        Row header = sheet.createRow(5);
        createASingleCell(header, workbook, timeDisplay, 4);
        writeDataBody(fields, data, workbook, sheet, 7, new EvaluationResponse());
        header = sheet.createRow(8 + data.size());
        createTotal(header, headerStyle, workbook, evaluations);
        return workbook;
    }

    private CellStyle getCellStyleHeader(XSSFWorkbook workbook, XSSFFont font) {
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFont(font);
        return headerStyle;
    }

    private XSSFFont getXssfFontHeader(XSSFWorkbook workbook) {
        XSSFFont font = workbook.createFont();
        font.setFontName("Arial");
        font.setFontHeightInPoints((short) 10);
        font.setBold(true);
        return font;
    }

    private static void createASingleCell(Row row, XSSFWorkbook workbook, String name, int cellNumber) {
        Cell cell = row.createCell(cellNumber);
        cell.setCellValue(name);
        CellStyle cellStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        font.setFontHeightInPoints((short) 13);
        font.setBold(true);
        cellStyle.setFont(font);
        cell.setCellStyle(cellStyle);
    }

    private <T> void writeDataBody(List<String> fields, List<T> data, XSSFWorkbook workbook, XSSFSheet sheet, int start, Object
            typeDataInput)
            throws IllegalAccessException {
        Map<String, Field> fieldMap = new HashMap<>();
        setReflectionNFieldMap(fields, fieldMap, typeDataInput);

        for (int j = start; j < data.size() + start; j++) {
            Row body = sheet.createRow(j + 1);
//            createASingleCell(body, j - start + 1);
            for (int i = 0; i < fields.size(); i++) {
                Object fieldValue = fieldMap.get(fields.get(i)).get(data.get(j - start));
                createASingleCellFinal(body, fieldValue, workbook, i);
            }
        }
    }

    /**
     * Get workbook
     *
     * @param <T> <T>
     * @return <T> XSSFWorkbook
     * @throws IllegalAccessException IllegalAccessException
     */
    public <T> XSSFWorkbook exportExcels(EvaluationResponseDetail data, EvaluationRequestDetail request, List<String> fields, String template) throws IOException, IllegalAccessException {

        List<EvaluationDetails> responseDetails = data.getEvaluationDetails();
        EvaluationDetails response = responseDetails.get(0);
        File file = new File(template);
        // Create workbook blank.
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file));

        //Create a blank sheet
        XSSFSheet sheet = workbook.getSheetAt(0);
        String employeeInfo = String.format(MessageExcels.EMPLOYEE_INFO, response.getCodeEmployee(), response.getNameEmployee(), response.getStationName());

        String timeDisplay = String.format(MessageExcels.TIME_DISPLAY, DateTimeFormatter.ofPattern("dd/MM/yyyy").format(request.getDateFrom()),
                DateTimeFormatter.ofPattern("dd/MM/yyyy").format(request.getDateTo()));
        Row header = sheet.createRow(4);
        createASingleCell(header, workbook, employeeInfo, 1);
        header = sheet.createRow(5);
        createASingleCell(header, workbook, timeDisplay, 1);
        writeDataBody(fields, data.getEvaluationDetails(), workbook, sheet, 7, new EvaluationDetails());

        // write file
        return workbook;
    }

    private void setReflectionNFieldMap(List<String> fields, Map<String, Field> fieldMap, Object object) {
        Class<?> aClass = getAClass(object);
        fields.forEach(it -> {
            try {
                Field privateNameField = aClass.getDeclaredField(it);
                privateNameField.setAccessible(true);
                fieldMap.put(it, privateNameField);
            } catch (NoSuchFieldException e) {
                logger.error(e);
            }
        });
    }

    private Class<?> getAClass(Object t) {
        if (t instanceof EvaluationResponse)
            return EvaluationResponse.class;
        if (t instanceof EvaluationDetails)
            return EvaluationDetails.class;
        return Object.class;
    }

    private static void createTotal(Row header, CellStyle headerStyle, XSSFWorkbook workbook, EvaluationDetail evaluations) {
        createASingleCellFinal1(header, headerStyle, workbook, "", 0);
        createASingleCellFinal1(header, headerStyle, workbook, "TỔNG", 1);
        createASingleCellFinal1(header, headerStyle, workbook, evaluations.getQuantityFiveStar(), 2);
        createASingleCellFinal1(header, headerStyle, workbook, evaluations.getQuantityFourStar(), 3);
        createASingleCellFinal1(header, headerStyle, workbook, evaluations.getQuantityThreeStar(), 4);
        createASingleCellFinal1(header, headerStyle, workbook, evaluations.getQuantityTwoStar(), 5);
        createASingleCellFinal1(header, headerStyle, workbook, evaluations.getQuantityOneStar(), 6);
        createASingleCellFinal1(header, headerStyle, workbook, evaluations.getQuantityMedium(), 7);
        createASingleCellFinal1(header, headerStyle, workbook, "", 8);
    }

    private static void createASingleCellFinal1(Row row, CellStyle style, XSSFWorkbook workbook, Object object, int cellNumber) {
        Cell cell = row.createCell(cellNumber);
        Font font = workbook.createFont();
        font.setBold(true);
        style.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.index);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setFont(font);
        style.setBorderTop(BorderStyle.HAIR);
        style.setBorderBottom(BorderStyle.HAIR);
        style.setBorderLeft(BorderStyle.HAIR);
        style.setBorderRight(BorderStyle.HAIR);
        cell.setCellStyle(style);

        if (object instanceof Integer || object instanceof BigDecimal || object instanceof Double) {
            cell.setCellValue(((Number) object).doubleValue());
        } else {
            if (object != null)
                cell.setCellValue(object.toString());
        }
    }

    private static void createASingleCellFinal(Row row, Object name, XSSFWorkbook workbook, int cellNumber) {
        Cell cell = row.createCell(cellNumber);
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setBorderTop(BorderStyle.HAIR);
        cellStyle.setBorderBottom(BorderStyle.HAIR);
        cellStyle.setBorderLeft(BorderStyle.HAIR);
        cellStyle.setBorderRight(BorderStyle.HAIR);
        if (name instanceof Integer || name instanceof BigDecimal || name instanceof Double) {
            cell.setCellValue(((Number) name).doubleValue());
        } else {
            if (name != null)
                cell.setCellValue(name.toString());
        }

        cell.setCellStyle(cellStyle);
    }

    public String writeFileExcel(XSSFWorkbook workbook, String name) throws IOException {
        Path uploadPath = Paths.get(folderSaving);

        if (!Files.exists(uploadPath))
            Files.createDirectories(uploadPath);

        LocalDate folderName = LocalDate.now();
        Path uploadPathFolder = Paths.get(folderSaving + "/" + folderName);

        if (!Files.exists(uploadPathFolder))
            Files.createDirectories(uploadPathFolder);

        //Write the workbook in file system
        String path = uploadPathFolder + "/" + name;
        FileOutputStream out = new FileOutputStream(path);
        workbook.write(out);
        out.close();
        logger.info(path, " written successfully on disk: " + name);
        return folderName + "/" + name;
    }

}
