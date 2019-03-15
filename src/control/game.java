package control;

import logic.Result;
import logic.Robot;
import logic.Stat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class game extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Result lastResult = new Result(Integer.parseInt(request.getParameter("choice")), Robot.getRobot().newChoice());
        request.setAttribute("robotChoice", lastResult.getRobotChoice());
        request.setAttribute("yourChoice", lastResult.getHumanChoice());
        request.setAttribute("winner", lastResult.getWinner());

        Stat.getInstance(request.getSession()).addResult(lastResult);
        Stat.getInstance(request.getSession()).countStat();

        request.setAttribute("statList", Stat.getInstance(request.getSession()).getList());
        request.setAttribute("statistics", "Human wins: " + Stat.getInstance(request.getSession()).getHumanWins() + "% games<br>Robot Wins: " + Stat.getInstance(request.getSession()).getRobotWins() + "% games");

        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
        dispatcher.forward(request, response);
    }
}
