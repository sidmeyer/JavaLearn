package sidmeyer.stepikweb.startserver.servlets;

import sidmeyer.stepikweb.startserver.templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Mirror extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {


        Map<String, Object> parametersMap = new HashMap<>();
        Map<String, String[]> stringData = request.getParameterMap();
        stringData.forEach((k,v) -> parametersMap.put(k, v[0]));

        String result = PageGenerator.instance().getPage("mirrorTemplate.html", parametersMap);
        response.getWriter().write(result);
//        response.getWriter().write(parametersMap.get("key").toString());
    }

    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

    }

}

