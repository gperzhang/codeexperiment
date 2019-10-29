package pattern.template;


public class BigDataCourse extends NetworkCourse {
    private boolean flag = false;
    @Override
    protected void checkHomework() {
        System.out.println("检查大数据课程作业");
    }

    public BigDataCourse(boolean flag) {
        this.flag = flag;
    }

    @Override
    protected boolean needHomework() {
        return flag;
    }
}
