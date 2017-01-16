package com.zapper.dbFeed.util;

import com.zapper.dbFeed.model.PHC;
import com.zapper.dbFeed.model.SNCU;

import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Satyarth on 16/1/17.
 */
public class SncuUtilTest {

  @Test
  @Ignore
  public void list() {
    List<SNCU> sncus = new SncuUtil().list();
    for(SNCU sncu : sncus) {
      System.out.println(sncu.getName());
      System.out.println(sncu.getDistrict());
    }
  }
}