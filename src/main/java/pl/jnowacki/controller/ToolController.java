package pl.jnowacki.controller;

import pl.jnowacki.dao.ToolDao;
import pl.jnowacki.dao.ToolDaoImpl;
import pl.jnowacki.service.ToolService;
import pl.jnowacki.service.ToolServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ToolServlet", value = "/")
public class ToolController extends HttpServlet {

    private final ToolService toolService = new ToolServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("tools", toolService.getAllTools());
        getServletContext().getRequestDispatcher("/tools.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        long id = Long.parseLong(req.getParameter("id"));

        switch (action) {
            case "take":
                toolService.setAvailability(false, id);
                break;
            case "return":
                toolService.setAvailability(true, id);
                break;
        }

        resp.sendRedirect(getServletContext().getContextPath() + "/");

        req.getSession().invalidate();
    }
}
