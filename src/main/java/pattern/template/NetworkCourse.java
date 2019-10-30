package pattern.template;

public abstract class NetworkCourse {
    protected final void createCourse(){
        //1.发布预习资料
        this.postPreResource();
        //2.制作ppt课件
        this.createPPT();
        //3.在线直播
        this.liveVideo();
        //4.提交课件
        this.postNote();
        //5.提交源码
        this.postSource();
        //6.布置作业  如果有作业需要检查作业，没有作业的话整个流程就结束了
        if (needHomework()){
            checkHomework();
        }
    }

    protected abstract void checkHomework();

    //钩子方法，实现微调
    protected  boolean needHomework(){
        return false;
    }

    final void postSource(){
        System.out.println("提交源码");
    }

    final void postNote(){
        System.out.println("提交笔记");
    }

    final void liveVideo(){
        System.out.println("在线直播");
    }

    final  void createPPT(){
        System.out.println("制作ppt");
    }

    final void postPreResource(){
        System.out.println("分发预习资料");
    }
}
