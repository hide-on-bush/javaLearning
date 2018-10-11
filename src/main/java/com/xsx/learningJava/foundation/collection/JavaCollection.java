package com.xsx.learningJava.foundation.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * java集合框架：
 *      collection---list存储有序可重复数据
 *                       ---ArrayList:动态数组，适用于少量的插入和删除，大量的遍历，线程不安全
 *                       ---LinkedList:链表，适用于频繁的插入和删除，少量的遍历
 *                ---Set存储无序不可重复
 *                       ---HashSet
 *                       ---LinkedHashSet
 *                       ---TreeSet
 * 
 *      map       ---HashMap：key-value键值对，key相当于set集合，value相当于list，key不可重复，value可重复，
 *                           一个key-value键值对为一个entry，线程不安全
 *                ---TreeMap：可定制排序，也可自然排序
 *                ---HashTable：古老的实现类，线程安全，但效率低
 *                ---Properties：常用作配置文件
 *
 */
public class JavaCollection {

	  public static void main(String[] args) {
		  //List存储有序可重复的数据
		    List<Object> list = new ArrayList<>();
		    list.add(1);
		    list.add(1);
		    list.add("hello world");
		    for (Object o: list) {
		    	System.out.println(o);
		    }
		    for (int i = 0; i < list.size(); i++) {
		    	System.out.println(list.get(i));
		    }
		  //Set存储无序不可重复数据
		    Set<Object> set = new HashSet<>();
		    set.add("hello world");
		    set.add(1);
		    set.add(2);
		    Iterator<Object> it = set.iterator();
		    while (it.hasNext()) {
		      Object obj = it.next();
		      System.out.println(obj);
		    }
		    
	}
}
