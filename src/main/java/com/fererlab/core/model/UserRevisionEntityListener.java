package com.fererlab.core.model;

import com.fererlab.core.session.UserBean;
import org.hibernate.envers.RevisionListener;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.CDI;
import java.util.Set;

public class UserRevisionEntityListener implements RevisionListener {

    public void newRevision(Object object) {
        if (object instanceof UserRevisionEntity) {
            UserRevisionEntity userRevisionEntity = (UserRevisionEntity) object;
            String username = getUserName();
            userRevisionEntity.setUsername(username);
        } else {
            // cannot handle this type
        }
    }

    @SuppressWarnings("unchecked")
    public String getUserName() {
        String username = null;
        if (CDI.current() != null
                && CDI.current().getBeanManager() != null) {
            UserBean userSessionBean = null;
            BeanManager beanManager = CDI.current().getBeanManager();
            Set<Bean<?>> beans = beanManager.getBeans(UserBean.class);
            if (beans != null && beans.size() > 0) {
                Bean<UserBean> bean = (Bean<UserBean>) beanManager.getBeans(UserBean.class).iterator().next();
                CreationalContext<UserBean> ctx = beanManager.createCreationalContext(bean);
                userSessionBean = (UserBean) beanManager.getReference(bean, UserBean.class, ctx);
                username = userSessionBean.getUserName();
            }
        }
        return username;
    }

}
