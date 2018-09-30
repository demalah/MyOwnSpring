/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demalah;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.stereotype.Component;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

/**
 *
 * @author dmalahov
 */
@Component
public class PromotionsService implements BeanNameAware, ApplicationListener<ContextClosedEvent> {

    private String beanName;

    @Override
    public void setBeanName(String name) {
        beanName = name;
    }

    public String getBeanName() {
        return beanName;
    }

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println(">> ContextClosed EVENT");
    }
}
