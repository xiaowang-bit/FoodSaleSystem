package com.hubu.controller;

import com.hubu.Enum.ResponseEnum;
import com.hubu.model.*;
import com.hubu.service.OrderService;

import com.hubu.utils.Response;
import com.hubu.utils.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {

    private static final long serialVersionUID = 1L;
    @Autowired
    private OrderService orderService;

    /**
     * 添加订单
     * 用session中的公务车生成订单
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */

    @RequestMapping("/addOrder")
    @ResponseBody
    public Response add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         * 1.从session中得到cart
         * 2.使用cart生成Order对象
         * 3.调用service方法完成添加订单
         * 4.保存order到request中，转发到/jsps/order/desc.jsp
         */
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        /* 2.
         * 使用cart生成Order对象
         * 并手动生成cart中没有的(order中需要的)相关属性
         *
         * Cart --> Order
         *
         */
        OrderInfo order = new OrderInfo();
        order.setId(UuidUtil.getUuid()); //设置订单编号
        order.setStatus(1);  // 设置状态为1，表示未付款
        //得到当前用户，设置订单所有者
        User user = (User) request.getSession().getAttribute("user");
        order.setUser_id(user.getId());  //设置订单所有者
        order.setPrice(cart.getTotal());  //设置订单合计，从cart中获取

        //创建订单条目(集合)
        //cartItemList --> orderItemList

        List<OrderItem> orderItemList = new ArrayList<OrderItem>();
        //需要通过遍历cart条目，对每个订单条目属性赋值)
        for (CartItem cartItem : cart.getCartItems()) {
            OrderItem oi = new OrderItem();  //创建订单条目
            oi.setId(UuidUtil.getUuid()); //设置条目ID
            oi.setNum(cartItem.getCount());  //设置条目数量
            oi.setFood_id(cartItem.getFood().getId());   //设置条目的图书
            oi.setOrderInfo_id(order.getId());  //设置所属订单

            orderItemList.add(oi);  //把订单条目添加到订单条目集合中
        }
        //把所有订单条目添加到订单中
        order.setList(orderItemList);
        //清空购物车
        cart.clear();

        /*
         * 3.调用orderService完成添加订单
         */
        orderService.addOrder(order);

        //4.保存order到request域，转发
        request.setAttribute("order", order);

        return Response.response(ResponseEnum.Success);
    }

    /**
     * 我的订单
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/findOrder")
    @ResponseBody
    public Response myOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         * 1.从session中得到当前用户.
         * 2.使用当前用户uid调用orderService#myOrders(uid),
         * 		--得到该用户的所有订单List<Order>
         * 3.把订单列表保存到request域中
         * 4.转发到/jsps/order/list.jsp
         */
        //得到当前用户
        User user = (User) request.getSession().getAttribute("user");

        //得到该用户的所有订单List<Order>
        List<OrderInfo> orderList = orderService.queryOrderById(user.getId());

        return Response.response(ResponseEnum.Success).add("list", orderList);
    }

    /**
     * 加载订单
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public Response load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         * 1.得到oid参数
         * 2.使用oid调用service方法得到Order
         * 3.保存Order到request，转发
         */
        String oid = request.getParameter("oid");
        /*request.setAttribute("order", orderService.load(oid));*/
        return Response.response(ResponseEnum.Success).add("list", null);
    }

    /**
     * 确认收货
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/payOrder")
    @ResponseBody
    public Response confirm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         * 1.获取oid参数
         * 2.调用service方法
         * 		异常：保存异常信息，转发到msg.jsp
         * 3.保存成功信息，转发到msg.jsp
         */
        String oid = request.getParameter("oid");
        try {
            orderService.payOrder(oid);
        } catch (Exception e) {
            Response.response(ResponseEnum.Fail).add("msg", e.getMessage());
        }
        return Response.response(ResponseEnum.Success).add("data", null);

    }
}
