/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demalah;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author dmalahov
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, URISyntaxException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, ReflectiveOperationException {
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.addPostProcessor(new CustomPostProcessor());
        beanFactory.instantiate("com.demalah");
        beanFactory.populateProperties();
        beanFactory.injectBeanNames();
        beanFactory.initializeBeans();
        ProductService productService = (ProductService) beanFactory.getBean("productService");
        System.out.println(productService);
        PromotionsService promotionsService = productService.getPromotionsService();
        System.out.println(promotionsService);
        System.out.println("Bean name = " + promotionsService.getBeanName());

        testContext();
    }

    private static void testContext() throws ReflectiveOperationException, IOException, URISyntaxException {
        System.out.println("----------------------------------------------------------------");
        ApplicationContext applicationContext = new ApplicationContext("com.demalah");
        applicationContext.close();
    }
}
