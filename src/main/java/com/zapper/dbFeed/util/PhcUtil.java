package com.zapper.dbFeed.util;

import com.zapper.dbFeed.model.PHC;
import com.zapper.dbFeed.model.SNCU;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by Satyarth on 16/1/17.
 */
public class PhcUtil {

  public List<PHC> list() {
    Configuration configuration = new Configuration().configure();
    SessionFactory sessionFactory = configuration.buildSessionFactory();
    Session session = sessionFactory.openSession();
    Transaction tx = session.beginTransaction();
    Criteria criteria = session.createCriteria(PHC.class);
    List<PHC> results = (List<PHC>) criteria.list();
    tx.commit();
    session.close();
    return results;
  }
}
