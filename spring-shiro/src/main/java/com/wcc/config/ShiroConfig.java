package com.wcc.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.wcc.service.UserService;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro 的配置类
 * @author wcc
 */
@Configuration
public class ShiroConfig {
    /**
     * 创建ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager manager) {
        ShiroFilterFactoryBean filterBean = new ShiroFilterFactoryBean();
        /**
         * Shiro 内置过滤器，可以实现权相关的拦截器
         * 常用的过滤器：
         * anon: 无需认证（登录）可以访问
         * authc：必需认证才可以访问
         * user: 如果使用 rememberMe的功能可以直接访问
         * perms: 该资源必须得到资源权限可以访问
         * role: 该资源必须得到角色权限才可以访问
         *
         */
        // 设置安全管理器
        filterBean.setSecurityManager(manager);
        Map<String, String> map = new LinkedHashMap<>();
//        map.put("/add", "authc");
//        map.put("/update", "authc");
        map.put("/test", "anon");
        map.put("/login", "anon");

        // 授权过滤器
        // 注意：当前授权拦截后， shiro会自动跳转到未授权页面
        map.put("/add", "perms[user:add]");
        map.put("/update", "perms[user:update]");

        map.put("/*", "authc");
        filterBean.setFilterChainDefinitionMap(map);

        // 修改调整登录页面
        filterBean.setLoginUrl("/toLogin");
        // 设置未授权页面
        filterBean.setUnauthorizedUrl("/noAuth");

        return filterBean;
    }
    /**
     * 创建DefaultWebSecurityManager
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        // 关联 realm
        manager.setRealm(userRealm);
        return manager;
    }
    /**
     * 创建Realm
     */
    @Bean(name = "userRealm")
    public UserRealm getRealm() {
        return new UserRealm();
    }

    @Bean
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }
}
