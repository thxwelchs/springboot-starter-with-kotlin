package com.example.demo.config

import com.fasterxml.jackson.databind.ObjectMapper
import mu.KotlinLogging
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.springframework.beans.factory.annotation.Autowire
import org.springframework.beans.factory.annotation.Configurable
import org.springframework.context.annotation.DependsOn
import org.springframework.context.annotation.EnableAspectJAutoProxy
import org.springframework.context.annotation.Lazy
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import java.util.*
import javax.annotation.PostConstruct


@Component
@Aspect
class RequestLoggerAspect {

    private val logger = KotlinLogging.logger{}

    // 해당 패키지 하위에 있는 컨트롤러의 모든 메소드에 적용
    @Pointcut("execution(* com.example.demo..controller.*.*(..))")
    fun requestPointCut() {}

    @Around("requestPointCut()")
    @Throws(Throwable::class)
    fun requestLogger(joinPoint: ProceedingJoinPoint): Any {
        val result = joinPoint.proceed()
        val request = (RequestContextHolder.currentRequestAttributes() as ServletRequestAttributes).request

        val mapper = ObjectMapper()

        val logMap: MutableMap<String, Any> = HashMap()
        logMap["sessionID"] = request.requestedSessionId?: ""
        logMap["requestURI"] = request.requestURI
        logMap["requestMethod"] = request.method
        logMap["sourceMethod"] = joinPoint.signature.declaringType.simpleName + "." + joinPoint.signature.name
        logMap["params"] = request.parameterMap

        logger.info(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(logMap))

        return joinPoint.proceed()
    }
}