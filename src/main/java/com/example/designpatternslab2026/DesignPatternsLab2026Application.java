package com.example.designpatternslab2026;

import com.example.designpatternslab2026.difexample.ClientComponent;
import com.example.designpatternslab2026.difexample.SingletonComponent;
import com.example.designpatternslab2026.difexample.TransientComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.servlet.context.ServletComponentScan;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@ServletComponentScan
public class DesignPatternsLab2026Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DesignPatternsLab2026Application.class, args);

        System.out.println("\n--- Testing Transient Beans ---");
        TransientComponent transientBean = context.getBean(TransientComponent.class);
        transientBean.operation();

        transientBean = context.getBean(TransientComponent.class);
        transientBean.operation();

        System.out.println("\n--- Testing Singleton Beans ---");
        SingletonComponent singletonBean = context.getBean(SingletonComponent.class);
        singletonBean.operation();

        singletonBean = context.getBean(SingletonComponent.class);
        singletonBean.operation();

        System.out.println("\n--- Testing ClientComponent ---");
        ClientComponent c = context.getBean(ClientComponent.class);
        c.operation();

        c = (ClientComponent) context.getBean("clientComponent");
        c.operation();
    }
}