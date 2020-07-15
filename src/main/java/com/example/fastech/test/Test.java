package com.example.fastech.test;

import com.example.fastech.entity.TPtnRingLineEntity;
import com.example.fastech.utils.ExcelHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * @author xh
 * @since 2020-04-17
 */
public class Test {

    /**
     *
     * @param inputStrea
     *  TPtnRingLineEntity:任意自己创建存放数据的实体类
     * @return
     */
    public boolean importXNumber(InputStream inputStream) {
        List<List<Object>> list = ExcelHelper.importExcel(inputStream, 0, 0);
        List<TPtnRingLineEntity> tPtnRingLineEntities = new ArrayList<>();
        //处理所导入的excel表格的列名
        if (list != null && list.size() > 1) {
            list.remove(0);

            list.stream().forEach(list1 -> {
                int size = list1.size();
                TPtnRingLineEntity tPtnRingLineEntity = new TPtnRingLineEntity();
                tPtnRingLineEntity.setDeviceLevel(list1.get(0).toString());
                tPtnRingLineEntity.setPtnNames(list1.get(1).toString());
                tPtnRingLineEntity.setRingLine(list1.get(2).toString());
                tPtnRingLineEntities.add(tPtnRingLineEntity);
            });
        }
        //存库
//        tPtnRingLineRepository.deleteAll();
//        tPtnRingLineRepository.saveAll(tPtnRingLineEntities);
        return true;

    }

    public static void main(String[] args) {
        File file =new File("C:/Users/admin/Desktop/x.xlsx");
        try {

            InputStream in = new FileInputStream(file);
            Test test=new Test();
            test.importXNumber(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
