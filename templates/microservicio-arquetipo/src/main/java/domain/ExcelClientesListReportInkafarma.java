package ${project_package}.domain;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Map;

public class ExcelClientesListReportInkafarma extends AbstractXlsView {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse response) throws Exception {

        response.setHeader("Content-disposition", "attachment; filename=\"ReporteClientesInkafarma.xls\"");

        @SuppressWarnings("unchecked")
        List<Cliente> list = (List<Cliente>) map.get("clientsList");

        Sheet sheet = workbook.createSheet("Lista de Clientes Inkafarma");
        sheet.setDefaultColumnWidth(30);

        // create font and style for TITLE cells
        Font fontTitulo = workbook.createFont();
        fontTitulo.setFontName("Lucida Sans Unicode");
        fontTitulo.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        fontTitulo.setColor(IndexedColors.RED.getIndex());
        fontTitulo.setBold(true);
        fontTitulo.setFontHeight((short) (14*20));

        CellStyle styleTitulo = workbook.createCellStyle();
        styleTitulo.setFont(fontTitulo);
        styleTitulo.setVerticalAlignment(VerticalAlignment.CENTER);
        styleTitulo.setAlignment(HorizontalAlignment.CENTER);

        Row titulo = sheet.createRow(0);
        titulo.setHeight((short) (30*20));
        titulo.setRowStyle(styleTitulo);
        titulo.createCell(0).setCellValue("");
        titulo.createCell(2).setCellValue("REPORTE LISTADO DE CLIENTES INKAFARMA");
        titulo.getCell(2).setCellStyle(styleTitulo);

        /***************************************************************/
        // create font and style for HEADERS cells
        Font fontHeader = workbook.createFont();
        fontHeader.setFontName("Lucida Sans Unicode");
        fontHeader.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        fontHeader.setColor(HSSFColor.WHITE.index);

        CellStyle styleHeader = workbook.createCellStyle();
        styleHeader.setFont(fontHeader);
        styleHeader.setFillForegroundColor(HSSFColor.RED.index);
        styleHeader.setFillPattern(CellStyle.SOLID_FOREGROUND);
        styleHeader.setAlignment(HorizontalAlignment.CENTER);
        styleHeader.setVerticalAlignment(VerticalAlignment.CENTER);

        styleHeader.setBorderRight(BorderStyle.THIN);
        styleHeader.setRightBorderColor(IndexedColors.DARK_RED.getIndex());
        styleHeader.setBorderLeft(BorderStyle.THIN);
        styleHeader.setLeftBorderColor(IndexedColors.DARK_RED.getIndex());
        styleHeader.setBorderTop(BorderStyle.THIN);
        styleHeader.setTopBorderColor(IndexedColors.DARK_RED.getIndex());
        styleHeader.setBorderBottom(BorderStyle.THIN);
        styleHeader.setBottomBorderColor(IndexedColors.DARK_RED.getIndex());

        Row header = sheet.createRow(1);
        header.setHeightInPoints(25);
        //header.setRowStyle(style);
        header.createCell(0).setCellValue("FECHA REGISTRO");
        header.getCell(0).setCellStyle(styleHeader);
        header.createCell(1).setCellValue("NOMBRES");
        header.getCell(1).setCellStyle(styleHeader);
        header.createCell(2).setCellValue("APELLIDO PATERNO");
        header.getCell(2).setCellStyle(styleHeader);
        header.createCell(3).setCellValue("APELLIDO MATERNO");
        header.getCell(3).setCellStyle(styleHeader);
        header.createCell(4).setCellValue("CELULAR");
        header.getCell(4).setCellStyle(styleHeader);
        header.createCell(5).setCellValue("COMPROBANTE");
        header.getCell(5).setCellStyle(styleHeader);
        header.createCell(6).setCellValue("CORREO");
        header.getCell(6).setCellStyle(styleHeader);
        header.createCell(7).setCellValue("DNI");
        header.getCell(7).setCellStyle(styleHeader);
        header.createCell(8).setCellValue("EMPRESA");
        header.getCell(8).setCellStyle(styleHeader);
        header.createCell(9).setCellValue("PROVEEDOR");
        header.getCell(9).setCellStyle(styleHeader);
        header.createCell(10).setCellValue("SEXO");
        header.getCell(10).setCellStyle(styleHeader);
        header.createCell(11).setCellValue("RECIBIR PROMOCIONES");
        header.getCell(11).setCellStyle(styleHeader);

        /***************************************************************/
        // create font and style for ROWS cells
        Font fontRow = workbook.createFont();
        fontRow.setFontName("Lucida Sans Unicode");
        fontRow.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        fontRow.setColor(IndexedColors.BLACK.getIndex());

        CellStyle styleRow = workbook.createCellStyle();
        styleRow.setFont(fontRow);
        styleRow.setBorderRight(BorderStyle.THIN);
        styleRow.setRightBorderColor(IndexedColors.RED.getIndex());
        styleRow.setBorderLeft(BorderStyle.THIN);
        styleRow.setLeftBorderColor(IndexedColors.RED.getIndex());
        styleRow.setBorderTop(BorderStyle.THIN);
        styleRow.setTopBorderColor(IndexedColors.RED.getIndex());
        styleRow.setBorderBottom(BorderStyle.THIN);
        styleRow.setBottomBorderColor(IndexedColors.RED.getIndex());

        int rowNum = 2;
        String proveedor = "";
        String recibir_promociones = "";
        for(Cliente cliente : list) {
            if (cliente.getId_proveedor() == 1 ){
                proveedor = "ROCHEPOSAY";
            }else{
                proveedor = (cliente.getId_proveedor() == 2) ? "ABBOTT": "INKAFARMA";
            }
            recibir_promociones = (cliente.isCheck_recibir() == true) ? "SI":"NO";
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(cliente.getFecha_registro()+"");
            row.getCell(0).setCellStyle(styleRow);
            row.createCell(1).setCellValue(cliente.getNombres());
            row.getCell(1).setCellStyle(styleRow);
            row.createCell(2).setCellValue(cliente.getApePaterno());
            row.getCell(2).setCellStyle(styleRow);
            row.createCell(3).setCellValue(cliente.getApeMaterno());
            row.getCell(3).setCellStyle(styleRow);
            row.createCell(4).setCellValue(cliente.getCelular());
            row.getCell(4).setCellStyle(styleRow);
            row.createCell(5).setCellValue(cliente.getComprobante());
            row.getCell(5).setCellStyle(styleRow);
            row.createCell(6).setCellValue(cliente.getCorreo());
            row.getCell(6).setCellStyle(styleRow);
            row.createCell(7).setCellValue(cliente.getDni());
            row.getCell(7).setCellStyle(styleRow);
            row.createCell(8).setCellValue("INKAFARMA");
            row.getCell(8).setCellStyle(styleRow);
            row.createCell(9).setCellValue(proveedor);
            row.getCell(9).setCellStyle(styleRow);
            row.createCell(10).setCellValue(cliente.getSexo());
            row.getCell(10).setCellStyle(styleRow);
            row.createCell(11).setCellValue(recibir_promociones);
            row.getCell(11).setCellStyle(styleRow);
        }

    }
}
