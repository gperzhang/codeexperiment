package pattern.template;

public class JavaCourse extends NetworkCourse {
    @Override
    protected void checkHomework() {
        System.out.println("检查java架构课程作业");
    }
}
