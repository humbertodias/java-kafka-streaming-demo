import java.io.Serializable;
import java.util.Date;

public class XPojo implements Serializable {
    private int a;
    private String b;
    private Date c;


    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public Date getC() {
        return c;
    }

    public void setC(Date c) {
        this.c = c;
    }


    @Override
    public String toString() {
        return "XPojo{" +
                "a=" + a +
                ", b='" + b + '\'' +
                ", c=" + c +
                '}';
    }
}
