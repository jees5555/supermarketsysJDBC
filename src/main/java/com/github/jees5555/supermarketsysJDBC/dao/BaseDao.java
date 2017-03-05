package com.github.jees5555.supermarketsysJDBC.dao;

import java.util.List;

public interface BaseDao<T> {
 public List<T> getObjectList(String arg1,String arg2);
 
 public T getObject(String id);
 
 public String isObjectExistById(String id);
 
 public void addObject(T t);
 
 public void updateObject(String id,T t);
 
 public void deleteObject(String id);



}
