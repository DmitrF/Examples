package ua.dfedorenko.simplemaven;

import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Hello {
    private String s;
    
    public Hello(String str){
        s = str;
    }
    
    public void sayHi(){
        System.out.println(s);
    }
    
    public static void main(String []args){
    	ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(new String[] {"config.xml"});
         Hello h = (Hello) ac.getBean("hello");
         h.sayHi();
    }
}