package com.codecool.shop.controller;

import com.codecool.shop.dao.CartDao;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.UserInfoDao;
import com.codecool.shop.dao.implementation.CartDaoMem;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.implementation.UserInfoDaoMem;
import com.codecool.shop.data.DbConnection;
import com.codecool.shop.model.Cart;
import com.codecool.shop.model.UserInfo;
import com.codecool.shop.util.Util;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "confirmation", urlPatterns = {"/confirmation"})
public class ConfirmationController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        DbConnection dataSource = DbConnection.getInstance();
        UserInfoDaoMem userInfoDataStore = null;
        try {
            userInfoDataStore = UserInfoDaoMem.getInstance(dataSource.connect());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

//        UserInfo thisUser = userInfoDaoDataStore.find(1);
        CartDao orderDataStore = CartDaoMem.getInstance();
        Cart thisCart = orderDataStore.find(1);


//        context.setVariable("userFname", thisUser.getFirstName());
//        context.setVariable("userLname", thisUser.getLastName());
//        context.setVariable("phone", thisUser.getPhoneNumber());
//        context.setVariable("bAddress", thisUser.getBilingAddress());
//        context.setVariable("sAddress", thisUser.getShippingAddress());
//        context.setVariable("email", thisUser.getEmail());

        context.setVariable("cart", thisCart.getItems());
        context.setVariable("total", thisCart.getTotal());
        context.setVariable("date", Util.getDate());


        engine.process("payment/confirmation.html", context, resp.getWriter());

    }
}