package com.zapper.dbFeed.launch;

import com.zapper.dbFeed.model.DistrictCode;
import com.zapper.dbFeed.model.Dump;
import com.zapper.dbFeed.model.InstitutionCode;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Satyarth on 11/1/17.
 */
public class LaunchFeed {

  public void launch() {
    try {
      FileInputStream fis =  new FileInputStream(new File(System.getProperty("user.home") + "/sourceFile.xls"));
      Workbook workbook = WorkbookFactory.create(fis);
      Sheet sheet = workbook.getSheetAt(0);
      Iterator<Row> rowIterator = sheet.rowIterator();
      List<Dump> dumps = new ArrayList<>();
      while (rowIterator.hasNext()) {
        Boolean firstRow = false;
        Row row = rowIterator.next();
        if(row.getCell(0).getCellType() == Cell.CELL_TYPE_STRING) {
          firstRow = true;
        }
        if(!firstRow) {
          Dump dump = new Dump();
          Iterator<Cell> cellIterator = row.cellIterator();
          List<Cell> cells = new ArrayList<>();
          while (cellIterator.hasNext()) {
            cells.add(cellIterator.next());
          }
          //dump.setCode(cells.get(1).getStringCellValue());
          //dump.setDistrict(cells.get(2).getStringCellValue());
          //dump.setInstitutionCode(cells.get(3).getStringCellValue());
          //dump.setInstitutionType(cells.get(4).getStringCellValue());
          dump.setHospitalSerialNo((cells.get(5).getStringCellValue()));
          //dump.setName(cells.get(6).getStringCellValue());
          //dump.setUHC(cells.get(7).getStringCellValue());
          dumps.add(dump);
        }
      }
      saveToDb(dumps);
    } catch (IOException ie) {
      ie.printStackTrace();
    } catch (InvalidFormatException e) {
      e.printStackTrace();
    }
  }

  private <T> void saveToDb(List<T> list) {
    Configuration configuration = new Configuration().configure();
    SessionFactory sessionFactory = configuration.buildSessionFactory();
    Session session = sessionFactory.openSession();
    Transaction tx = session.beginTransaction();
    for(Object o : list) {
      session.save(o);
    }
    tx.commit();
    session.close();
  }

  public void feedDistricts() {
    try {
      FileInputStream fileInputStream = new FileInputStream(new File(System.getProperty("user.home") + "/sourceFile.xls"));
      Workbook workbook = WorkbookFactory.create(fileInputStream);
      Sheet sheet = workbook.getSheetAt(2);
      Iterator<Row> rowIterator = sheet.rowIterator();
      List<DistrictCode> districtCodes = new ArrayList<>();
      while (rowIterator.hasNext()) {
        Row row = rowIterator.next();
        Boolean firstRow = false;
        if(row.getCell(2).getCellType() == Cell.CELL_TYPE_STRING) {
          firstRow = true;
        }
        if(!firstRow) {
         Iterator<Cell> cellIterator = row.cellIterator();
          List<Cell> cells = new ArrayList<>();
          while (cellIterator.hasNext()) {
            cells.add(cellIterator.next());
          }
          DistrictCode districtCode = new DistrictCode();
          districtCode.setDistrict(cells.get(1).getStringCellValue());
          districtCode.setCode((int) cells.get(2).getNumericCellValue());
          districtCodes.add(districtCode);
        }
      }
      saveToDb(districtCodes);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InvalidFormatException e) {
      e.printStackTrace();
    }
  }

  public void feedInstitutions() {
    try {
      FileInputStream fileInputStream = new FileInputStream(new File(System.getProperty("user.home") + "/sourceFile.xls"));
      Workbook workbook = WorkbookFactory.create(fileInputStream);
      Sheet sheet = workbook.getSheetAt(2);
      Iterator<Row> rowIterator = sheet.rowIterator();
      List<InstitutionCode> institutionCodes = new ArrayList<>();
      while (rowIterator.hasNext()) {
        Row row = rowIterator.next();
        if(row.getRowNum() > 8) {
          break;
        }
        Boolean firstRow = false;
        if(row.getCell(7).getCellType() == Cell.CELL_TYPE_STRING) {
          firstRow = true;
        }
        if(!firstRow) {
          InstitutionCode institutionCode = new InstitutionCode();
          institutionCode.setInstiCode((int) row.getCell(7).getNumericCellValue());
          institutionCode.setInstiType(row.getCell(5).getStringCellValue());
          institutionCodes.add(institutionCode);
        }
      }
      saveToDb(institutionCodes);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InvalidFormatException e) {
      e.printStackTrace();
    }
  }

}
