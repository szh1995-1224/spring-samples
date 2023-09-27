import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        ShowCmd bean = ctx.getBean(ShowCmd.class);

        System.out.println("bean.showCmd() = " + bean.showCmd());

    }
}
