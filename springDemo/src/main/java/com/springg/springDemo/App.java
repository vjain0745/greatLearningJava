package com.springg.springDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springg.springDemo.entity.Author;
import com.springg.springDemo.entity.Book;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
        ApplicationContext context = 
        		new ClassPathXmlApplicationContext("spring.xml");
        
        Author a1 = context.getBean(Author.class);
        System.out.println(a1);
        
        Book b1 = context.getBean(Book.class);
        System.out.println(b1);    
        }
}
