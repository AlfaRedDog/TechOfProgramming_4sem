/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2004-8 LearningPatterns Inc.
 */

package com.javatunes.util;

import java.sql.*;
import java.util.Collection;
import java.util.ArrayList;
import java.math.BigDecimal;

public class ItemDAO
{
   // connection to the database (assumed to be open)
   private Connection m_conn = null;
   
   //// PreparedStatement Lab ////
   //-- declare the PreparedStatement for searchByKeyword --//
   
   
   //// Update Lab ////
   //-- declare the PreparedStatement for create --//
   
   
   
   // constructor
   public ItemDAO(Connection conn)
   throws SQLException
   {
      // store the connection
      m_conn = conn;
      
      //// PreparedStatement Lab ////
      //-- define the ?-SQL for searchByKeyword --//
      
      
      //-- prepare the ?-SQL with the DBMS and initialize the PreparedStatement --//
      
      
      //// Update Lab ////
      //-- define the ?-SQL for create --//
      
      
      //-- prepare the ?-SQL with the DBMS and initialize the PreparedStatement --//
      
   }
   
   
   //// DAO Lab ////
   public MusicItem searchById(Long id)
   throws SQLException
   {
      // declare return value
      MusicItem result = null;
      // declare JDBC objects
      Statement stmt = null;
      //-- build the SQL statement --//
      String sql = "SELECT * from Item WHERE ITEM_ID = " + id;
      try
      {
         //-- initialize the Statement object --//
         stmt = m_conn.createStatement();
         //-- execute the SQL statement, get a ResultSet back --//
         ResultSet rs = stmt.executeQuery(sql);
         //-- if ID found, extract data from the ResultSet and initialize the ItemValue return value --//
         if(rs != null){
            //-- if ID found, extract data from the ResultSet and initialize the ItemValue return value --//
            rs.next();
            result = new MusicItem(id, rs.getString(2), rs.getString(3),
                                       rs.getDate(4), rs.getBigDecimal(5),
                                       rs.getBigDecimal(6));
         }
         else
            //-- if ID not found, the return value remains null --//
            return null;
         
      }
      finally
      {
         //-- close the Statement - this closes its ResultSet --//
         assert stmt != null;
         stmt.close();
      }
      // return the value object
      return result;
   }
   
   
   //// PreparedStaement Lab ////
   public Collection<MusicItem> searchByKeyword(String keyword)
   throws SQLException
   {
      // create storage for the results
      Collection<MusicItem> result = new ArrayList<MusicItem>();
      
      // create the %keyword% wildcard syntax used in SQL LIKE operator
      String wildcarded = "%" + keyword + "%";
      String sql = "SELECT * from Item WHERE TITLE LIKE ?";
      //-- set the ? parameters on the PreparedStatement --//
      PreparedStatement pstmt = m_conn.prepareStatement(sql);
      pstmt.setString(1, wildcarded);
      System.out.println(pstmt);
      //-- execute the PreparedStatement, get a ResultSet back --//
      ResultSet rs = pstmt.executeQuery();
      while(rs.next()){
         result.add(new MusicItem(rs.getLong(1), rs.getString(2), rs.getString(3),
                 rs.getDate(4), rs.getBigDecimal(5),
                 rs.getBigDecimal(6)));
         System.out.println(rs.getString(2));
      }
      //-- iterate through the ResultSet, extracting data from each row and creating an ItemValue from it --//
      //-- add the ItemValue to the Collection via Collection's add method --//
      // return the Collection
      return result;
   }
   
   
   //// Update Lab ////
   public void create(MusicItem item)
   throws SQLException
   {
	  // Use the following releaseDate value in the  prepared statement for setDate
	  java.sql.Date releaseDate = new java.sql.Date(item.getReleaseDate().getTime());
	  String sql = "INSERT INTO Item (TITLE, ARTIST, RELEASEDATE, LISTPRICE, PRICE, VERSION) VALUES (?, ?, ?, ?, ?, ?)";
      //-- set the ? parameters on the PreparedStatement --//
      PreparedStatement pstmt = m_conn.prepareStatement(sql);
      pstmt.setString(1, item.getTitle());
      pstmt.setString(2, item.getArtist());
      pstmt.setString(3, releaseDate.toString());
      pstmt.setString(4, item.getListPrice().toString());
      pstmt.setString(5, item.getPrice().toString());
      pstmt.setString(6, "1");
      pstmt.executeUpdate();
      m_conn.commit();
      //-- execute the PreparedStatement - ignore the update count --//
      
   }
   
   
   //// PreparedStatement and Update Labs ////
   public void close()
   {
      /*
      REMOVE this comment in PreparedStatement Lab
      try
      {
         //// PreparedStatement Lab ////
         //-- close the PreparedStatement for searchByKeyword --//
         
         
         //// Update Lab ////
         //-- close the PreparedStatement for create --//
         
      }
      catch (SQLException sqle)
      {
         JDBCUtilities.printSQLException(sqle);
      }
      REMOVE this comment in the PreparedStatement Lab
      */
   }
}
