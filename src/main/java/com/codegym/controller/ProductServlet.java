package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import com.codegym.service.ProductServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    private final ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";

        switch (action) {
            case "create":
                request.getRequestDispatcher("/product/create.jsp").forward(request, response);
                break;
            case "edit":
                showProduct(request, response, "/product/edit.jsp");
                break;
            case "delete":
                showProduct(request, response, "/product/delete.jsp");
                break;
            case "view":
                showProduct(request, response, "/product/view.jsp");
                break;
            case "search":
                searchProducts(request, response);
                break;
            default:
                listProducts(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if (action == null) action = "";

        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "edit":
                updateProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            default:
                response.sendRedirect(request.getContextPath() + "/products");
        }
    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("products", productService.findAll());
        request.getRequestDispatcher("/product/list.jsp").forward(request, response);
    }

    private void searchProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("name");
        List<Product> products = productService.findByName(keyword);
        request.setAttribute("products", products);
        request.setAttribute("keyword", keyword);
        request.getRequestDispatcher("/product/list.jsp").forward(request, response);
    }

    private void showProduct(HttpServletRequest request, HttpServletResponse response, String page)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);

        if (product == null) {
            request.getRequestDispatcher("/error-404.jsp").forward(request, response);
            return;
        }

        request.setAttribute("product", product);
        request.getRequestDispatcher(page).forward(request, response);
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Product product = new Product(
                0,
                request.getParameter("name"),
                Double.parseDouble(request.getParameter("price")),
                request.getParameter("description"),
                request.getParameter("manufacturer")
        );

        productService.save(product);
        response.sendRedirect(request.getContextPath() + "/products");
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        if (productService.findById(id) == null) {
            request.getRequestDispatcher("/error-404.jsp").forward(request, response);
            return;
        }

        Product product = new Product(
                id,
                request.getParameter("name"),
                Double.parseDouble(request.getParameter("price")),
                request.getParameter("description"),
                request.getParameter("manufacturer")
        );

        productService.update(id, product);
        response.sendRedirect(request.getContextPath() + "/products");
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        if (productService.findById(id) == null) {
            request.getRequestDispatcher("/error-404.jsp").forward(request, response);
            return;
        }

        productService.remove(id);
        response.sendRedirect(request.getContextPath() + "/products");
    }
}
