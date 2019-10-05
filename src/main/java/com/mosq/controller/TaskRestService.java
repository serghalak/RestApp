package com.mosq.controller;

import com.mosq.entities.Status;
import com.mosq.services.StatusService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Serg on 30.09.2019.
 */
@Path("/tasks")
public class TaskRestService {

    private StatusService service=new StatusService();

    @GET
    //@Produces("text/plain")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Status> getTask(){
        StatusService service=new StatusService();
        List<Status> statuses = service.readAll();
        //System.out.println(statuses);
                
        
//        List<Status>statuses=new ArrayList<>();
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        try(Connection connection= DriverManager.getConnection(
//                "jdbc:mysql://localhost:3306/sql7234875"
//                ,"mosq","mosq");
//            PreparedStatement stmt=connection.prepareStatement(
//                    "Select id,title from statuses");
//            ResultSet rs=stmt.executeQuery();){
//            while(rs.next()){
//                Byte id=rs.getByte("id");
//                String title=rs.getString("title");
//                System.out.println("id="+id);
//                System.out.println("title="+title);
//                Status status=new Status(id,title);
//                System.out.println("--->"+status);
//                statuses.add(status);
//            }
//
//
//        }catch (SQLException ex){
//            System.out.println("Error create connection: " + ex);
//        }
//        return statuses.toString();
        //return "start project some  +++";
        return statuses;
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Status createStatus(Status status){
        System.out.println(status);
        return service.createStatus(status);
    }



}
