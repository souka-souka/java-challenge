package jp.co.axa.apidemo.common;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WebUtils
{
    /**
     * Render the string to the client
     *
     * @param response 
     * @param string 
     * @return null
     */
    public static String renderString(HttpServletResponse response, String string) {
        try
        {
            response.setStatus(200);
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(string);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
