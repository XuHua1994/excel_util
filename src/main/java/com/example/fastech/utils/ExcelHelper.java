package com.example.fastech.utils;


import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;


/**
 * excel导入导出工具类
 */

public class ExcelHelper {

    /**
     * @param inputStream      excel输入流
     * @param startRowIndex    开始行号
     * @param lastOfInvalidRow 忽略最后几行
     * @author hahaha
     * @Description
     * @since 2018/12/25 17:28
     **/
    public static List<List<Object>> importExcel(InputStream inputStream, int startRowIndex, int lastOfInvalidRow) {
        ExcelReader reader = ExcelUtil.getReader(inputStream);
        List<List<Object>> read = reader.read(startRowIndex);
        return read.subList(0, read.size() - lastOfInvalidRow);
    }


    /**
     * @param title     excel名称
     * @param sheetName sheet名称
     * @Description 根据Map导出excel
     * @since 2018/12/24 10:18
     **/
    public static void exportExcel(HttpServletResponse response, String title, String sheetName, Class clazz, List list) throws IOException {
        downloadSetting(response, title);
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(title, sheetName), clazz, list);
        workbook.write(response.getOutputStream());
    }

    /**
     * @param response 响应对象
     * @Description 设置excel下载响应对象
     * @since 2018/12/18 17:20
     **/
    private static void downloadSetting(HttpServletResponse response, String title) throws UnsupportedEncodingException {
        // 告诉浏览器用什么软件可以打开此文件
        response.setHeader("content-Type", "application/vnd.ms-excel");
        // 下载文件的默认名称
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(title.replaceAll(StrUtil.SPACE, StrUtil.EMPTY), "UTF-8") + ".xlsx");
        //编码
        response.setCharacterEncoding("UTF-8");

    }

}
