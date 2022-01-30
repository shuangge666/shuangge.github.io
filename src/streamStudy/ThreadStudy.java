package streamStudy;

public class ThreadStudy {

    static class Data{
        int id;
        public int flag;
        public Data(int flag){
            this.flag=flag;
        }
        public synchronized void  jishu() throws InterruptedException {
            while(this.flag==1)
                this.wait();
            for(int i=1;i<100;i+=2){
                System.out.println(i);
                this.flag=1;
                this.notifyAll();
                this.wait();
            }
        }
        public synchronized void oushu() throws InterruptedException {
            while(this.flag==0)
                this.wait();
            for(int i=2;i<100;i+=2){
                System.out.println(i);
                this.flag=0;
                this.notifyAll();

                this.wait();

            }
        }
    }


    public static void main(String[] args) {
        ThreadStudy s=new ThreadStudy();
        ThreadStudy.Data data=new ThreadStudy.Data(0);
        Thread t1=new Thread(new Thread1(data));
        Thread t2=new Thread(new Thread2(data));
        t1.start();
        t2.start();
    }
}
class Thread1 implements Runnable{
    private ThreadStudy.Data data;
    public Thread1(ThreadStudy.Data data){
        this.data=data;
    }

    @Override
    public void run() {
        try {
            this.data.jishu();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Thread2 implements Runnable{
    private ThreadStudy.Data data;
    public Thread2(ThreadStudy.Data data){
        this.data=data;
    }

    @Override
    public void run() {
        try {
            this.data.oushu();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}