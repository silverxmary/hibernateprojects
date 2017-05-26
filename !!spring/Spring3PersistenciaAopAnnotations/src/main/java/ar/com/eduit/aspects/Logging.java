package ar.com.eduit.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component()
public class Logging {
	

	
	@Before("execution( public * ar.com.eduit.dao.*.save(..))")
	public void logParameters(JoinPoint joinPoint){
		System.out.print(joinPoint.getSignature().toShortString() +  "logging values ");
		Object[] args =  joinPoint.getArgs();
		for (Object arg : args) {
	      System.out.print(arg);			
		}
		System.out.println();
		
	}
	
	
	@AfterReturning(pointcut = "execution( public * ar.com.eduit.dao.*.save(..))",returning="retVal")
	public void logReturnValue(final JoinPoint joinPoint,Object retVal){
		System.out.println( joinPoint.getSignature().getName() +  " returning " + retVal);
	}
	
	@AfterThrowing(pointcut = "execution( public * ar.com.eduit.dao.*.save(..))", throwing = "ex")
	public void logException(Throwable ex){
		ex.printStackTrace();
	}

}
