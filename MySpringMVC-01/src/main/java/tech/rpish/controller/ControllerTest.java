package tech.rpish.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//实现controller接口
public class ControllerTest implements Controller {
    @Override
//    实现controller接口handleRequest方法:ControllerTest类会调用该方法处理请求,然后返回一个包含视图名或视图名与模型的model and view 对象
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
//        创建model and view 对象
        ModelAndView modelAndView = new ModelAndView();
//        向模型添加一个名称的msg的字符串对象
        modelAndView.addObject("msg", "This is my first spring mvc application");
//        设置视图名,将请求转发到welcome.jsp页面 (渲染模板)
        modelAndView.setViewName("/WEB-INF/jsp/welcome.jsp");
        return modelAndView;
    }
}
