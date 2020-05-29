package com.maven.aware;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Spring的依赖注入的最大亮点是所有的Bean对Spring容器的存在是没有意识的，我们可以将Spring容器换成其他的容器，
 * Spring容器中的Bean的耦合度因此也是极低的。但是我们在实际的开发中，我们却经常要用到Spring容器本身的功能资源，
 * 所以Spring容器中的Bean此时就要意识到Spring容器的存在才能调用Spring所提供的资源。
 * 我们通过Spring提供的一系列接口Spring Aware来实现具体的功能。
 *     BeanNameAware                    :    获得到容器中Bean的名称
 *     BeanFactoryAware                 :    获得当前bean Factory,从而调用容器的服务
 *     ApplicationContextAware          :    获得当前的application context从而调用容器的服务
 *     MessageSourceAware               :    得到message source从而得到文本信息
 *     ApplicationEventPublisherAware   :    应用时间发布器,用于发布事件
 *     ResourceLoaderAware              :    获取资源加载器,可以获得外部资源文件
 *     Spring Aware的目的是为了让Bean获得Spring容器的服务。
 * 因为ApplicationContext接口集成了MessageSource接口、ApplicationEventPublisher接口和ResourceLoader接口，
 * 因此当Bean继承自ApplicationContextAware的时候就可以得到Spring容器的所有服务。
 */
@Service
public class AwareService implements BeanNameAware, ResourceLoaderAware {

    private String beanName;
    private ResourceLoader loader; //获取资源加载器,可以获得外部资源文件

    @Override
    public void setBeanName(String s) {
        this.beanName = s;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.loader = resourceLoader;
    }

    public void outputResult() {
        System.out.println("Bean的名称=" + this.beanName);
        Resource resource = loader.getResource("classpath:bean/value.txt");
        try {
            System.out.println("ResourceLoader 加载的文件内容为：" + IOUtils.toString(resource.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}