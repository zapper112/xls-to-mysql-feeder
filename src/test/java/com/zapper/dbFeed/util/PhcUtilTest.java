package com.zapper.dbFeed.util;

import com.zapper.dbFeed.model.PHC;

import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Satyarth on 16/1/17.
 */
public class PhcUtilTest {

  @Test
  @Ignore
  public void list() {
    List<PHC> phcs = new PhcUtil().list();
    for(PHC phc : phcs) {
      System.out.println(phc.getName());
      System.out.println(phc.getDistrict());
    }
  }
}