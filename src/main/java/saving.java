import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class saving {

    //saving the employe in the database
    public static int save(Emp e) {
        int status = 0;
        try {
            Connection connection = databaseconnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO users VALUES (?,?,?,?,?,?,?,?,?)");

            statement.setInt(1, e.getId());
            statement.setString(2, e.getName());
            statement.setString(3, e.getPassword());
            statement.setString(4, e.getEmail());
            statement.setString(5, e.getCountry());
            statement.setString(6,e.getAddress());
            statement.setString(7, e.getPhone());
            statement.setString(8, e.getDepartment());
            statement.setString(9, e.getJobTitle());
            status = statement.executeUpdate();


        } catch (Exception io) {
            System.out.println(io.getMessage());
        }
        return status;
    }

    //updating the user and employe database using mysql and java

    public static int update(Emp e){
        int status = 0;
        try{
            Connection connection = databaseconnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("Update users set name=?,password=?,email=?,country=? where id=?");
            statement.setString(1, e.getName());
            statement.setString(2, e.getPassword());
            statement.setString(3, e.getEmail());
            statement.setString(4, e.getCountry());
            statement.setInt(5, e.getId());

            status = statement.executeUpdate();

        }catch (Exception io){
            System.out.println(io.getMessage());
        }
        return status;
    }


    //getting employe by id

    public static Emp findById(int id){
        Emp e = new Emp();

        try{
            Connection connection = databaseconnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users where id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                e.setId(resultSet.getInt(1));
                e.setName(resultSet.getString(2));
                e.setPassword(resultSet.getString(3));
                e.setEmail(resultSet.getString(4));
                e.setCountry(resultSet.getString(5));
            }


        }catch(Exception eo){
            System.out.println(eo.getMessage());
        }
        return e;

    }

    public static List<Emp> getAllEmployees(){
        List<Emp> list=new ArrayList<Emp>();

        try{
            Connection con=databaseconnection.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from users");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Emp e=new Emp();
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setPassword(rs.getString(3));
                e.setEmail(rs.getString(4));
                e.setCountry(rs.getString(5));
                e.setAddress(rs.getString(6));
                e.setPhone(rs.getString(7));
                e.setDepartment(rs.getString(8));
                e.setJobTitle(rs.getString(9));
                list.add(e);
            }

        }catch(Exception e){e.printStackTrace();}

        return list;
    }


    //making the delete operation using the java in the databse mysql in the crud in the using the intelij idea which is free for useed sorry i have used community version soit becoom free for me to use

    public static int delele(int id){
        int status = 0;
        try{
            Connection connection = databaseconnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("delete from users where id = ?");
            statement.setInt(1, id);
            status = statement.executeUpdate();

        }catch (Exception ed){
            System.out.println(ed.getMessage());
        }
        return status;
    }




}
