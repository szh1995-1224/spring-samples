import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

public class JavaConfig {

    /**
     * 这两个bean实际上只需要像spring容器中注册一个即可
     *
     * @return
     * @Conditional() 是一个条件注解 ，它里面需要一个条件 如果条件为true则当前bean就会被注册到spring容器中 否则当前Bean不会被注册到spring容器中
     */
    @Bean
    @Conditional(WindowsCondition.class)
    ShowCmd windowsCmd() {
        return new WindowsCmd();
    }

    @Bean
    @Conditional(LinuxCondition.class)
    ShowCmd linuxCmd() {
        return new LinuxCmd();
    }


}
