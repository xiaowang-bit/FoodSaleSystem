package com.hubu.controller;


import com.hubu.Enum.ResponseEnum;
import com.hubu.model.Cart;
import com.hubu.model.CartItem;
import com.hubu.model.Food;
import com.hubu.service.FoodService;
import com.hubu.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class CartCotroller {
    private static final long serialVersionUID = 1L;

    /**
     * 添加购物 条目
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @Autowired
    private FoodService fs;
    @RequestMapping("/addCartItem")
    @ResponseBody
    public Response add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         * 1.得到session中的车（只有登陆的用户才有车）
         * 2.得到购买的图书和数量
         * 3.创建条目（条目包含图书和数量属性），并对条目设置图书和购买数
         * 4.添加条目到车中
         */
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        //得到条目，先得到图书的id,通过id查询数据库，得到book
        String cid = request.getParameter("cid");
        Food food= fs.queryfoodbyId(cid);
        //得到用户购买数量
        int count = Integer.parseInt(request.getParameter("count"));

        //创建条目，并对条目设置图书和购买数
        CartItem cartItem = new CartItem();
        cartItem.setFood(food);
        cartItem.setCount(count);

        cart.add(cartItem);
        return Response.response(ResponseEnum.Success).add("data",null);
    }

    /**
     * 删除购物条目
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/delCartItem")
    @ResponseBody
    public Response delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         * 1.得到车
         * 2.得到要清空的条目ID
         * 3.根据ID删除条目
         */
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        String cid = request.getParameter("cid");
        cart.delete(cid);

        return Response.response(ResponseEnum.Success).add("data",null);
    }

    /**
     * 清空购物条目
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/clearCart")
    @ResponseBody
    public Response clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         * 1.得到车
         * 2.清空车
         */
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        cart.clear();
        return Response.response(ResponseEnum.Success).add("data",null);
    }
}
