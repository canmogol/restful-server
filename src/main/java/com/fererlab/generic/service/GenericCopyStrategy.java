package com.fererlab.generic.service;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.lang.reflect.InvocationTargetException;

@Stateless(name = "GenericCopyStrategy", mappedName = "GenericCopyStrategy")
@LocalBean
public class GenericCopyStrategy {

    private Log log = LogFactory.getLog(GenericCopyStrategy.class);

    public void copy(Object from, Object to) {
        try {
            BeanUtils.copyProperties(to, from);
        } catch (IllegalAccessException | InvocationTargetException e) {
            log.error("could not copy from: " + from + " to: " + to + " exception: " + e.getMessage());
        }
    }

}
