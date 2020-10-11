package assignments;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		//printing to the console to show when the page is created
		System.out.println("This is init..............");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		
		//printing to the console to show when the page is destroyed
		System.out.println("This is destroy...........");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//read parameters for first name and last name
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		
		//if first name or last name is null or empty forward to TestError.jsp
		if(firstName == null || lastName == null || lastName.isEmpty() || firstName.isEmpty()) 
		{
			request.getRequestDispatcher("TestError.jsp").forward(request, response);
		}
		else 
		{
			request.setAttribute("firstname", firstName);
			request.setAttribute("lastname", lastName);
			
			//forward request to JSP and pass it data
			request.getRequestDispatcher("TestResponse.jsp").forward(request, response);
		}  
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
