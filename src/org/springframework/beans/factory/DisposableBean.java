/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.beans.factory;

/**
 *
 * @author dmalahov
 */
public interface DisposableBean {

    void destroy();

}
