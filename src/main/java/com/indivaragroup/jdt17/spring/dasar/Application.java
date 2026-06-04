package com.indivaragroup.jdt17.spring.dasar;

import com.indivaragroup.jdt17.spring.dasar.configuration.*;
import com.indivaragroup.jdt17.spring.dasar.dependency.injection.HelloWorldInjection;
import com.indivaragroup.jdt17.spring.dasar.dependency.injection.HelloWorldWithInjection;
import com.indivaragroup.jdt17.spring.dasar.dependency.injection.dto.HelloInjection;
import com.indivaragroup.jdt17.spring.dasar.dependency.injection.dto.WorldInjection;
import com.indivaragroup.jdt17.spring.dasar.dto.HelloDTO;
import com.indivaragroup.jdt17.spring.dasar.dto.WorldDTO;
import com.indivaragroup.jdt17.spring.dasar.exam.DistributionService;
import com.indivaragroup.jdt17.spring.dasar.exam.configuration.ConfigurationFactory;
import com.indivaragroup.jdt17.spring.dasar.exam.configuration.ConfigurationSales;
import com.indivaragroup.jdt17.spring.dasar.exam.configuration.ConfigurationDistribution;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(
                JDTConfiguration.class
        );

        System.out.println(context.getBean("getInitialConfiguration"));

        context.close();




        /* EXAMPLE SINGLETON */
        var db1 = DatabaseConfiguration.getInstance();
        var db2 = DatabaseConfiguration.getInstance();

        System.out.println("DATABASE - 1 ---" + db1);
        System.out.println("DATABASE - 2 ---" + db2);

        var contextBean = new AnnotationConfigApplicationContext(
                BeanConfiguration.class
        );

        HelloDTO helloDTO = contextBean.getBean(HelloDTO.class);
        System.out.println(helloDTO);

        var contextBeanWorld = new AnnotationConfigApplicationContext(
                WorldDTO.class
        );

        WorldDTO worldDTO = contextBeanWorld.getBean(WorldDTO.class);
        System.out.println(worldDTO);

        contextBean.close();
        contextBeanWorld.close();

        // duplicate bean akses
        var contextBeanDuplicate = new AnnotationConfigApplicationContext(
                DuplicateBeanConfiguration.class
        );


        HelloDTO hello1 = contextBeanDuplicate.getBean("hello1", HelloDTO.class);
        HelloDTO hello2 = contextBeanDuplicate.getBean("hello2", HelloDTO.class);

        System.out.println(hello1);
        System.out.println(hello2);

        contextBeanDuplicate.close();

        // primary
        var contextBeanPrimary = new AnnotationConfigApplicationContext(
                PrimaryBeanConfiguration.class
        );

        WorldDTO world = contextBeanPrimary.getBean(WorldDTO.class);
        WorldDTO dunia1 = contextBeanPrimary.getBean("dunia1", WorldDTO.class);
        WorldDTO dunia2 = contextBeanPrimary.getBean("dunia2", WorldDTO.class);

        System.out.println(world);
        System.out.println(dunia1);
        System.out.println(dunia2);

        contextBeanPrimary.close();

        // BeanNAme
        var contextBeanName = new AnnotationConfigApplicationContext(
                BeanNameConfiguration.class
        );

        HelloDTO helloDTO1 = contextBeanName.getBean("HelloSatuKacang", HelloDTO.class);
        System.out.println(helloDTO1);

        // tanpa dependenccies injection
        HelloInjection helloInjection = new HelloInjection();
        WorldInjection worldInjection = new WorldInjection();

        HelloWorldInjection helloWorldInjection = new HelloWorldInjection(
                helloInjection, worldInjection
        );

        // with injection
        var helloWorldWithInjectionContext = new AnnotationConfigApplicationContext(
                HelloWorldWithInjection.class
        );

        HelloWorldWithInjection helloWorldWithInjection = helloWorldWithInjectionContext.getBean(HelloWorldWithInjection.class);
        System.out.println(helloWorldWithInjection.foo().name());
        System.out.println(helloWorldWithInjection.bar().name());


        // depens on
        var depensOnContext = new AnnotationConfigApplicationContext(
                DependsOnConfiguration.class
        );

        System.out.println("CALL THE DEPENDS ON FOO " + depensOnContext.getBean("foo"));
        System.out.println("CALL DEPENS ON BAR " + depensOnContext.getBean("bar"));

        /*
               TUGAS / TASK

         */

        // membuat context yang berisi semua configutration
        var contextTaskOne = new AnnotationConfigApplicationContext(
                ConfigurationFactory.class,
                ConfigurationSales.class,
                ConfigurationDistribution.class
        );

        // mengambil bean dari service
        DistributionService serviceTask = contextTaskOne.getBean(DistributionService.class);

        serviceTask.stockDistribution();

        contextTaskOne.close();

        SpringApplication.run(Application.class, args);
    }

}
