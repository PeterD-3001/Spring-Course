package com.realdolmen.spring_course.domain;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by cerseilannister on 30/08/16.
 */
@Aspect
@Component
public class Minstrel {

    // === BEFORE ====

    @Pointcut("execution (*  *.embarkOnQuest())")
    public void bla(){
       // NOP
    }

    @Before("bla()")
    public void vooraf(){
        System.out.println("BEFORE: The Minstrel is going to perform an Advice-song BEFORE");
    }

    // === AFTER ====
    /*
    @Pointcut("execution (*  *.embark()")
    public void bli(){
        // NOP
    }
    */

    /*
    @After("bli()")
    // Non-Conditional: Wordt altijd uitgevoerd !
    public void naderhand(){
        System.out.println("AFTER ALWAYS: The Minstrel is going to perform an Advice-song AFTER");
    }
    */

    @AfterReturning(value= "execution(* *.embark(java.lang.String)) && args (who)" , returning ="spoils")
    // Conditional: Wordt bij succes uitgevoerd !
    public void naderhandSuccess(String spoils,String who){
        System.out.println("AFTER RETURN: The Minstrel is cooking dinner for the Knight AFTER");
        System.out.println("Minstrel say's result of quest is:"+ spoils);
        System.out.println("Minstrels says who is : "+ who);
    }

    @AfterThrowing(value= "execution(* *.embark(java.lang.String))" , throwing="error")
    // Conditional: Wordt bij faillure uitgevoerd !
    public void naderhandFailed(RuntimeException error){
        System.out.println("AFTER THROW: The Minstrel is going to perform a funeral for the Knight AFTER");
        System.out.println("Reason for quest faillure is: "+error);
    }

}
