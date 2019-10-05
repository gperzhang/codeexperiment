package pattern.proxy.staticproxy;

public class Parent implements Person {
    private Son son;

    public Parent(Son son){
        this.son = son;
    }
    @Override
    public void findLove(){
        System.out.println("先替儿子物色");
        son.findLove();
        System.out.println("办理后续事情");
    }
}
