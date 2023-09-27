import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class WindowsCondition implements Condition {
    /**
     * 这个方法实际上就是一个匹配方法，如果这个方法返回true表示匹配成功 返回false表示匹配失败
     *
     * @param context
     * @param metadata
     * @return
     */

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //获取当前操作系统的名字
        String osName = context.getEnvironment().getProperty("os.name");
        return osName.toLowerCase().contains("window");
    }
}
