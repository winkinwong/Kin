package com.kin.test.springboot.dao;

import java.util.List;

public interface BaseDao<T> {
	/**
	 * 根据主键(id)查询指定的一条记录
	 * @param value
	 * @return
	 */
	T selectByPrimaryKey(String value);
	
	/**
	 * 根据若干个主键(id)查询若干条记录
	 * 注:要在业务层先判断入参中是否有元素，如果没有就不能在业务组件的相关方法中调用此Dao方法，否则会报错
	 * @param ids
	 * @return
	 */
	List<T> selectByPrimaryKeys(List<Integer> ids);
	
	/**
	 * 插入一条记录(带主键)
	 * @param t
	 * @return
	 */
	Integer insert(T t);
	
	/**
	 * 插入一条记录(不带主键,主键自增)
	 * @param t
	 * @return
	 */
	Integer insertSelective(T t);
	
	/**
	 * 根据主键(id)删除一条记录
	 * @param value
	 * @return
	 */
	Integer deleteByPrimaryKey(String value);
	
	/**
	 * 根据若干个主键(id)删除若干条记录
	 * 注:要在业务层先判断入参中是否有元素，如果没有就不能在业务组件的相关方法中调用此Dao方法，否则会报错
	 * @param ids
	 * @return
	 */
	Integer deleteByPrimaryKeys(List<Integer> ids);
	
	/**
	 * 根据指定的实体类对象的若干属性值,来删除符合条件的若干条记录
	 * @param t
	 * @return
	 */
	Integer deleteByExample(T t);
	
	/**
	 * 根据指定的实体类对象的若干属性值,来修改符合条件的若干条记录的若干字段的值
	 * @param t
	 * @return
	 */
	Integer updateByPrimaryKeySelective(T t);
	
	/**
	 * 根据指定的实体类对象的若干属性值,来查询符合条件的若干条记录
	 * @param t
	 * @return
	 */
	List<T> selectByExample(T t);
	
	/**
	 * 根据指定的实体类对象的若干属性值,来查询符合条件的记录总数
	 * @param t
	 * @return
	 */
	Integer countByExample(T t);
	
	/**
	 * 根据指定的实体类对象的若干属性值,来分页查询符合条件的若干条记录(分页所用的字段已经封装在实体类对象的相应属性中了)
	 * @param t
	 * @return
	 */
	List<T> selectByPage(T t);
	
}
