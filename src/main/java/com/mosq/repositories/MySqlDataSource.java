package com.mosq.repositories;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Created by Serg on 04.10.2019.
 */
public class MySqlDataSource {

    //@Resource(name="jdbc/mosqDB")
    private  static DataSource dataSource=null;
//    @Resource(name="jdbc/mosqDB")
//    private DataSource dataSource;

    static{
        try{
            Context context=new InitialContext();
            dataSource= (DataSource) context.lookup("java:comp/env/jdbc/mosqDB");
        }catch(NamingException e){
            System.err.println("DataSource error: " + e);
        }
    }

    public static DataSource getDataSource(){
        return dataSource;
    }

}
