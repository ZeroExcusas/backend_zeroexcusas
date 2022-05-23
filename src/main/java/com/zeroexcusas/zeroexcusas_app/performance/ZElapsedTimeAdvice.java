package com.zeroexcusas.zeroexcusas_app.performance;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ZElapsedTimeAdvice {
    Logger logger= LoggerFactory.getLogger(ZElapsedTimeAdvice.class);

    @Around("@annotation(com.zeroexcusas.zeroexcusas_app.performance.ZElapsedTime)")
    public Object watchElapsedTime(ProceedingJoinPoint targetMethod) throws Throwable {
        long stratTime=System.currentTimeMillis();
        Object methodObject = targetMethod.proceed();
        long endTime = System.currentTimeMillis();
        logger.info("Time taken for "+targetMethod.getSignature()+" -> "+(endTime-stratTime)+"ms");
        return methodObject;
    }



}
