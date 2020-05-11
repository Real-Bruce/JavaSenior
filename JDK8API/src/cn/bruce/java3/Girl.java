package cn.bruce.java3;

/**
 * @author bruce
 * @project_name JavaSenior
 * @package_name cn.bruce.java3
 * @create 2020-05-08 10:18
 */
public class Girl {
    private String name;

    public Girl() {
    }

    public Girl(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                '}';
    }
}
