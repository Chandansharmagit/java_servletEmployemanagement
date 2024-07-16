import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;

public class SaveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try{
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String country = request.getParameter("country");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            String Department = request.getParameter("department");
            String jobtitle = request.getParameter("jobTitle");


            Emp e = new Emp();
            e.setName(name);
            e.setEmail(email);
            e.setPassword(password);
            e.setCountry(country);
            e.setAddress(address);
            e.setPhone(phone);
            e.setDepartment(Department);
            e.setJobTitle(jobtitle);

            int status = saving.save(e);
            if(status>0){
                out.print("<p>Record saved successfully!</p>");
                request.getRequestDispatcher("index.html").include(request, response);
            }else{
                out.println("Sorry! unable to save record");
            }

        }catch(Exception io){
            System.out.println(io.getMessage());
        }
    }
}
