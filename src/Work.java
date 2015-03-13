import java.util.Random;

/**
 * Created by grizzly on 3/13/15.
 */
public class Work {
    private int t_n,v_n,part_cor,part;
    Random random = new Random();
    public int resualtt;
    int[] v1;
    int[] v2;
    int[] parts;
    long starttime;
    Work(int t_n ,int v_n)
    {
        starttime=System.nanoTime();
        this.t_n=t_n;
        this.v_n=v_n;
        VCreate(2,v_n);
        vMult(v_n);
        startwork();
    }
    public void VCreate(int num,int v_n){
        v1 = new int[v_n];
        v2 = new int[v_n];
        for (int i = 0; i < v_n; i++) {
            v1[i] = random.nextInt(1000);
            v2[i] = random.nextInt(1000);
        }
    }
    public void startwork()
    {
        Tread_Work [] tread  = new Tread_Work[t_n];
        for (int i=0;i<t_n;i++)
        {
            tread[i]=new Tread_Work(i);
        }
        long f_time=System.nanoTime();
        float m= (float) ((f_time-starttime) /1000000.0);
        System.out.println("time =" + m);
    }
    public void vMult(int a){
        int num_cor=0;
        parts=new int[t_n];
        part=a/t_n;
        part_cor=a%t_n;
        for (int i=0;i<t_n;i++)
        {
            if (i<part_cor)
            {
                parts[i] = part + 1 + num_cor;
                num_cor=part+1+ num_cor;
            }
            else
            {
                parts[i] = part + num_cor;
                num_cor= num_cor+part;
            }
            //System.out.println("n "+num_cor);
            //System.out.println("p "+parts[i]);
        }
    }
    public class Tread_Work implements Runnable{
        private int ab,ba,res1;
        int resualttt;
        public Thread t;
        Tread_Work(int a) {
            t = new Thread(this);
            this.ab=a;
            if (ab==0)
                ba=0;
            else ba=parts[ab-1];
            t.start();
        }
        @Override
        public void run() {
            /*try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            for (int j=ba;j<parts[ab];j++)
            {
                res1=v1[j]*v2[j];
                resualttt+= res1;
                //System.out.println("v1="+v1[j]+",v2="+v2[j]+",res1="+res1+",res="+resualttt);
            }
            resualtt+=resualttt;
            //System.out.println("ress="+resualtt);
        }

    }
}
