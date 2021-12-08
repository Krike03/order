package be.christophe.order.item.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(Aspect.class);

    @Pointcut("execution(public String be.christophe.order.item.services.*.*(..))")
    public void allServices(){}

    @AfterThrowing(pointcut = "allServices()",
        throwing = "exception")
    public void log(JoinPoint joinPoint, Throwable exception){
        String message = exception.getMessage();
        String method = joinPoint.getSignature().toString();
        logger.warn(message.concat("|Method: ").concat(method));
    }
}