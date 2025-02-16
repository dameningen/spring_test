package zzz.yyy.xxx.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.HandlerInterceptor;

import lombok.extern.slf4j.Slf4j;
import zzz.yyy.xxx.demo.application.resource.TestBean;

@Slf4j
@Component
public class PathParameterInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // リクエストのパスを取得
        // リクエストのURIを取得
        String uri = request.getRequestURI();
        log.debug("★uri:" + uri);
        if (uri.matches("\\/.*\\.pdf")) {
            // パスパラメータに基づいて処理を行う
            TestBean bean = new TestBean();
            bean.setFileName("aaaaaaaaaa");
            log.debug("bean:" + bean);
            Model model = (Model) request.getAttribute("org.springframework.web.servlet.ModelAndView");
            if (model != null) {
                // 必要に応じてリクエストにオブジェクトを設定
                model.addAttribute("bean", bean);
            }
            //request.setAttribute("bean", model);

        }

        return true;
    }
}
