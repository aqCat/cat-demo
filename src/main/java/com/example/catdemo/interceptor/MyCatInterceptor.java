package com.example.catdemo.interceptor;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Event;
import com.dianping.cat.message.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
@Slf4j
public class MyCatInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //请求的方法
        return true;
    }

    /**
     * 支持 Transaction、Event、Heartbeat、Metric 四种消息模型。
     *
     *     Transaction 适合记录跨越系统边界的程序访问行为,比如远程调用，数据库调用，也适合执行时间较长的业务逻辑监控，Transaction用来记录一段代码的执行时间和次数
     *     Event 用来记录一件事发生的次数，比如记录系统异常，它和transaction相比缺少了时间的统计，开销比transaction要小
     *     Heartbeat 表示程序内定期产生的统计信息, 如CPU利用率, 内存利用率, 连接池状态, 系统负载等
     *     Metric 用于记录业务指标、指标可能包含对一个指标记录次数、记录平均值、记录总和，业务指标最低统计粒度为1分钟
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Transaction t = Cat.newTransaction("URL", "pageName");
        try {
            //记录一个事件
            Cat.logEvent("URL.Server", "serverIp", Event.SUCCESS, "ip=${serverIp}");
            //记录一个业务指标，记录次数
            Cat.logMetricForCount("metric.key");
            //记录一个业务指标，记录支付金额
            Cat.logMetricForDuration("metric.key", 5);
            //你的业务
            log.info("cat拦截器拦截***********************");
            t.setStatus(Transaction.SUCCESS);
        } catch (Exception e) {
            t.setStatus(e);
            Cat.logError(e);
        } finally {
            t.complete();
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
