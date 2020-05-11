package cn.bruce.java3;

/**
 * @author bruce
 * @project_name JavaSenior
 * @package_name cn.bruce.java3
 * @create 2020-05-08 10:19
 */
public class Boy {
    private Girl girl;

    public Boy() {
    }

    public Boy(Girl girl) {
        this.girl = girl;
    }

    public Girl getGirl() {
        return girl;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "girl=" + girl +
                '}';
    }
}
