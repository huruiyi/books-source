package vip.fairy.initializer.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsefulServlet extends HttpServlet {

  private static final long serialVersionUID = -6045338L;

  private String name = "我是你大爷";

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");
    PrintWriter writer = response.getWriter();
    writer.println("<html><head><title>First servlet" + "</title></head><body>" + name);
    writer.println("</body></head>");
  }

  public void setName(String name) {
    this.name = name;
  }
}
