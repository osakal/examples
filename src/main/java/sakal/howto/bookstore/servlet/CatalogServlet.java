package sakal.howto.bookstore.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import sakal.howto.bookstore.model.Book;

@WebServlet("/catalog")
public class CatalogServlet extends HttpServlet {

    private static final long serialVersionUID = 9098026784951785853L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println(request);

        Book book = new Book();

        String bookId = UUID.randomUUID().toString();
        book.setId(bookId);

        BigDecimal price = new BigDecimal(10.99);
        book.setPrice(price);
        book.setTitle("The Art of Java");

        String json = new Gson().toJson(book);
        response.getWriter().write(json);

    }

}
