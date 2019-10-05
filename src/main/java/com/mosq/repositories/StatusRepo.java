package com.mosq.repositories;

import com.mosq.entities.Status;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class StatusRepo implements GenericCRUD<Status> {
    private DataSource dataSource = MySqlDataSource.getDataSource();

    private static final String READ_ALL_STATUS="Select id,title from statuses";
    private static final String CREATE_STATUS ="Insert into statuses(title) values(?)";
    private static final String READ_STATUS="Select id, title from statuses where id=?";


    private List<Status>parseData(ResultSet rs){
        List<Status>statuses=new ArrayList<>();
        try {
            while (rs.next()){
                byte id=rs.getByte("id");
                String status=rs.getNString("title");
                statuses.add(new Status(id,status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statuses;
    }


    @Override
    public Status create(Status status) {
        try(Connection connection=dataSource.getConnection();
            PreparedStatement stmt=connection.prepareStatement(CREATE_STATUS,Statement.RETURN_GENERATED_KEYS))  {
            stmt.setString(1,status.getTitle());
            stmt.executeUpdate();
            try(ResultSet rs=stmt.getGeneratedKeys()){
                boolean isGeneratedKey=rs.next();
                if(isGeneratedKey){
                    System.out.println("isGeneretedKey: "+isGeneratedKey);
                    //in rs that was created by getGeneratedKeys has a name GENERATED_KEY
                    //but not id like in DB. The rs has only one column and we can use rs.getLong(1)
                    long key=rs.getLong(1);
                    System.out.println(rs.getMetaData().getColumnName(1)+" count: "
                            +rs.getMetaData().getColumnCount());
                    System.out.println("KeyGenerated: " +key );
                    return read(key);
                }
            }catch(Exception ex){
                System.err.println("Error get key genereted: " + ex);
            }

        }catch(SQLException ex){
            System.err.println("Error create status: " + ex);
        }
        return null;
    }

    @Override
    public Status read(Long id) {
        System.out.println("read Status id=: " + id);
        try(Connection connection=dataSource.getConnection();
            PreparedStatement stmt=connection.prepareStatement(READ_STATUS)){
            stmt.setLong(1,id);
            List<Status> statuses=parseData(stmt.executeQuery());

            return statuses.get(0);
        }catch(SQLException ex){
            System.err.println("Error read status: " + ex);
        }

        return null;
    }

    @Override
    public Status update(Status status) {

        return null;
    }

    @Override
    public void delete(Status status) {

    }

    @Override
    public List<Status> readAll() {
        try(Connection conn=dataSource.getConnection();
            PreparedStatement stmt=conn.prepareStatement(READ_ALL_STATUS)){
            return parseData(stmt.executeQuery());
        }catch (SQLException ex){
            System.err.println("Read all statuses: "+ex);
        }

        return null;
    }


}
