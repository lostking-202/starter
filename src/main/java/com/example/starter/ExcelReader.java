package com.example.starter;

import com.google.common.base.Strings;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import org.apache.commons.math3.util.Pair;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

  public static void main(String[] args) throws IOException {
    var workBook=new XSSFWorkbook(Files.newInputStream(Paths.get("C:\\N-21AJPF3SS51N-Data\\j32zhang\\Downloads\\BusinessService_Application Mapping_1124.xlsx")));
    var sheet=workBook.getSheet("service catalogue");
    System.out.println(sheet);

    //var row=sheet.getRow(1);
    /*for(int j=1;j<10;j++){
      System.out.println(row.getCell(j).getStringCellValue());
    }*/
    var tier1Map=new LinkedHashMap<>();
    var tier2Map=new LinkedHashMap<String,Integer>();

    {var ss=new LinkedHashSet<String>();
    for(int i=1;i<148;i++){
      var row=sheet.getRow(i);
      ss.add(row.getCell(2).getStringCellValue());
    }
    System.out.println(ss);
    var sqlTemple="insert into business_service(id,tier1_name)values({0},''{1}'');";

    var sss=new LinkedList<>(ss);
    System.out.println(sss.size());
    for(int i=0;i<sss.size();i++){
      tier1Map.put(sss.get(i),i+1);
      Files.writeString(Path.of("C:\\Users\\j32zhang\\workspace\\java\\starter\\output\\tier1.sql"),MessageFormat.format(sqlTemple,i+1,sss.get(i))+System.lineSeparator(), StandardOpenOption.APPEND);
    }}

    {var tier2=new LinkedHashSet<Pair<String,String>>();
    for(int i=1;i<148;i++){
      var row=sheet.getRow(i);
      tier2.add(new Pair<>(row.getCell(2).getStringCellValue(),row.getCell(3).getStringCellValue()));
    }
    System.out.println(tier2);
    var sqlTemple2="insert into it_service_offering(id,tier1_id,tier2_name)values({0},{1},''{2}'');";

    var tier2List=new LinkedList<>(tier2);
    System.out.println(tier2List.size());
    for(int i=0;i<tier2List.size();i++){
      tier2Map.put(tier2List.get(i).getValue(),i+1);
      Files.writeString(Path.of("C:\\Users\\j32zhang\\workspace\\java\\starter\\output\\tier2.sql"),MessageFormat.format(sqlTemple2,i+1,tier1Map.get(tier2List.get(i).getKey()),tier2List.get(i).getValue())+System.lineSeparator(), StandardOpenOption.APPEND);
    }}

    {var tier3=new LinkedHashSet<Pair<String,String>>();
    for(int i=1;i<148;i++){
      var row=sheet.getRow(i);
      System.out.println(i);
      System.out.println(row);
      System.out.println(row.getCell(4));
      if(row.getCell(4)!=null&&!Strings.isNullOrEmpty(row.getCell(4).getStringCellValue())){
        tier3.add(new Pair<>(row.getCell(3).getStringCellValue(),row.getCell(4).getStringCellValue()));
      }
    }
    System.out.println(tier3);
    var sqlTemple3="insert into it_service_offering_module(id,tier2_id,tier3_name)values({0},{1},''{2}'');";
    var tier3Map=new LinkedHashMap<String,Integer>();
    var tier3List=new LinkedList<>(tier3);
    System.out.println(tier3List.size());
    for(int i=0;i<tier3List.size();i++){
      tier3Map.put(tier3List.get(i).getValue(),i+1);
      Files.writeString(Path.of("C:\\Users\\j32zhang\\workspace\\java\\starter\\output\\tier3.sql"),MessageFormat.format(sqlTemple3,i+1,tier2Map.get(tier3List.get(i).getKey()),tier3List.get(i).getValue())+System.lineSeparator(), StandardOpenOption.APPEND);
    }}



    /*var row=sheet.getRow(1);
    for(int j=1;j<10;j++){
      System.out.println(row.getCell(j).getStringCellValue());
    }*/
    /*for(int i=1;i<sheet.getPhysicalNumberOfRows();i++){

    }*/
  }
}
