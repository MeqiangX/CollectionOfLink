package com.defin.dao;

import java.util.List;

import com.defin.bean.Bean;

public interface CollecDao {
      public void save(Bean bean);
      
      public void delete(String[] s);
      
      public void update(Bean bean);
      
      public List list();
      
      public Bean getfromid(int id);
}
