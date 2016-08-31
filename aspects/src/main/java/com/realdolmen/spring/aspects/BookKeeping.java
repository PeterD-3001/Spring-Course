package com.realdolmen.spring.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// TODO: Turn this class into a Spring Bean and an Aspect
@Component // Added (oefening 1)
@Aspect
public class BookKeeping {
    // TODO: Add an advice that advises the Zoo.accept(Visitor) method
    // TODO: Make sure the advice uses the return value of the the adviced method to keep track of happy and unhappy visitors
    private int HappyVCount;
    private int UnHappyVCount;

    public int getHappyVisitorCount() {
        return HappyVCount;
    }
    public int getUnhappyVisitorCount() {
        return UnHappyVCount;
    }

   /*
    @Pointcut( "execution (*  *.accept(..)) " )
    public void bla(){
        // NOP
    }
   */

    @Before(value="execution (*  *.accept(..)) ")
    public void vooraf(){
        System.out.println("Aspect VOORAF aangeroepen !");
    }

    @AfterReturning(value="execution(boolean  accept(..))", returning="goodTimeBadTime")
    public void achteraf(boolean goodTimeBadTime){
        System.out.println("Aspect ACHTERAF aangeroepen !");
        if (goodTimeBadTime == true) {
            HappyVCount++;
            System.out.println("HappyVCount opgehoogd naar:"+ HappyVCount);
        }
        else{
            UnHappyVCount++;
            System.out.println("==== UNUNUN-HappyVCount opgehoogd naar:"+ UnHappyVCount);
        }
    }



    /*
    @After("bla()")
    public void achteraf(){
        System.out.println("Aspect ACHTERAF aangeroepen !");
    */


}
