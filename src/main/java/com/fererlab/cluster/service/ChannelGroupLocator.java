package com.fererlab.cluster.service;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.naming.InitialContext;
import java.util.Set;

@LocalBean
@Stateless(name = "ChannelGroupLocator", mappedName = "ChannelGroupLocator")
public class ChannelGroupLocator {

    @Inject
    BeanManager beanManager;

    public Object getChannelGroup() {
        org.wildfly.clustering.group.Group channelGroup = null;
        try {
            InitialContext context = new InitialContext();
            channelGroup = (org.wildfly.clustering.group.Group) context.lookup("java:jboss/clustering/group/web");
        } catch (Exception e) {
            // here we could not find the Group via lookup, will try with class name
            try {
                Set<Bean<?>> beans = beanManager.getBeans(org.wildfly.clustering.group.Group.class);
                if (beans.size() > 0) {
                    Bean<org.wildfly.clustering.group.Group> bean = (Bean<org.wildfly.clustering.group.Group>) beanManager.getBeans(org.wildfly.clustering.group.Group.class).iterator().next();
                    CreationalContext<org.wildfly.clustering.group.Group> ctx = beanManager.createCreationalContext(bean);
                    channelGroup = (org.wildfly.clustering.group.Group) beanManager.getReference(bean, org.wildfly.clustering.group.Group.class, ctx);
                }
            } catch (Exception ex) {
                // there is no group available, this means application not running on cluster
            }
        }
        return channelGroup;
    }
}
