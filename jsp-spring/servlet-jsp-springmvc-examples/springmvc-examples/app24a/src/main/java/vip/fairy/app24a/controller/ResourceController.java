package vip.fairy.app24a.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import vip.fairy.app24a.domain.Login;

@Controller

public class ResourceController {

  private static final Log logger = LogFactory.getLog(ResourceController.class);

  @RequestMapping(value = "/login")
  public String login(@ModelAttribute Login login, HttpSession session, Model model) {
    model.addAttribute("login", new Login());
    if ("paul".equals(login.getUserName()) && "secret".equals(login.getPassword())) {
      session.setAttribute("loggedIn", Boolean.TRUE);
      return "Main";
    } else {
      return "LoginForm";
    }
  }

  @RequestMapping(value = "/resource_download")
  public String downloadResource(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
    if (session == null || session.getAttribute("loggedIn") == null) {
      return "LoginForm";
    }
    String dataDirectory = request.getServletContext().getRealPath("/WEB-INF/data");
    File file = new File(dataDirectory, "secret.pdf");
    if (file.exists()) {
      response.setContentType("application/pdf");
      response.addHeader("Content-Disposition", "attachment; filename=secret.pdf");
      byte[] buffer = new byte[1024];
      // if using Java 7, use try-with-resources
      try (FileInputStream fis = new FileInputStream(file); BufferedInputStream bis = new BufferedInputStream(fis)) {
        OutputStream os = response.getOutputStream();
        int i = bis.read(buffer);
        while (i != -1) {
          os.write(buffer, 0, i);
          i = bis.read(buffer);
        }
      } catch (IOException ex) {
        // do something,
        // probably forward to an Error page
      }
    }
    return null;
  }

}
