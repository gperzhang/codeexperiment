package pattern.template;

public class Test {
    public static void main(String[] args) {
//        NetworkCourse java = new JavaCourse();
//        java.createCourse();

        NetworkCourse bigData = new BigDataCourse(true);
        bigData.createCourse();
    }
}
