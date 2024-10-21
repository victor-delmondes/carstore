package br.com.carstore.servlet;

import br.com.carstore.dao.CarDao;
import br.com.carstore.model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-car")
public class CreateCarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String carName = request.getParameter("car-name");
        String carId = request.getParameter("id");

        CarDao carDao = new CarDao();
        Car car = new Car(carName, carId);

        if (carId.isBlank()) {

            carDao.createCar(car);
            System.out.println(carName);

        } else {

            carDao.updateCar(car);

        }

        response.sendRedirect("/find-all-cars");
    }
}
