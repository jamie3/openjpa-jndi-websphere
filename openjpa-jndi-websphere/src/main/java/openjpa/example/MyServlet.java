package openjpa.example;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import openjpa.example.model.SampleTable;

public class MyServlet extends HttpServlet {

	private EntityManagerFactory emf;

	public void init() throws ServletException {
		super.init();

		System.out.println("Initializing servlet");
		
		this.emf = Persistence.createEntityManagerFactory("openjpa-jndi-websphere");
	}
	
	@Override
	public void destroy() {
		if (this.emf != null) {
			this.emf.close();
			this.emf = null;
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {

		try {
			EntityManager em = emf.createEntityManager();

			System.out.println("Fetching data from database");

			List<SampleTable> results = em.createNamedQuery("SampleTable.findAll", SampleTable.class).getResultList();

			response.getWriter().write("Results: " + results.size());
			
		} catch (Throwable t) {
			t.printStackTrace();
		}
		
	}
}
