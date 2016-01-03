package com.fererlab.core.model;


import com.fererlab.core.session.UserBean;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;
import java.util.Set;

public class AuditModelListener {

    @PrePersist
    public void auditCreation(AuditModel auditModel) {

        UserBean userSessionBean = getUserBean();
        String username = userSessionBean.getUserName();

        auditModel.setCreatedBy(username);
        auditModel.setCreationDate(new Date());
    }

    @PreUpdate
    public void auditUpdate(AuditModel auditModel) {

        UserBean userSessionBean = getUserBean();
        String username = userSessionBean.getUserName();
        if (auditModel.isDeleted()) {
            // this entity was previously available,
            // right now a user trying to delete it
            auditModel.setDeletedBy(username);
            auditModel.setDeleteDate(new Date());
        } else {
            auditModel.setUpdatedBy(username);
            auditModel.setUpdateDate(new Date());
        }
    }


    // JPA 2.1 supports @Inject in javax.persistence.EntityListeners
    // Please Refer to "JSR-000338 JavaTM Persistence 2.1 Final Release" document's "3.5.1 Entity Listeners"
    // we could inject the UserBean here like below sample code line
    // @Inject UserBean userSessionBean;
    //
    // But because of the below bugs, we could not use the JPA Spec's recommended way
    // https://hibernate.atlassian.net/browse/HHH-8706
    // https://issues.jboss.org/browse/WFLY-2387
    //
    // So we applied the workaround suggested at the https://issues.jboss.org/browse/WFLY-2387?focusedCommentId=13007351
    @Inject
    BeanManager beanManager; //Workaround WFLY-2387 HHH-8706

    @SuppressWarnings("unchecked") //Workaround WFLY-2387 HHH-8706
    public UserBean getUserBean() {
        UserBean userSessionBean = null;
        Set<Bean<?>> beans = beanManager.getBeans(UserBean.class);
        if (beans.size() > 0) {
            Bean<UserBean> bean = (Bean<UserBean>) beanManager.getBeans(UserBean.class).iterator().next();
            CreationalContext<UserBean> ctx = beanManager.createCreationalContext(bean);
            userSessionBean = (UserBean) beanManager.getReference(bean, UserBean.class, ctx);
        }
        return userSessionBean;
    }

}