package gfour.zucc.com.wanglema.model;

/**
 * Created by Administrator on 2017/5/28.
 */

public class BeanProject {

    private int projectId;
    private String projectName;
    private String projectContext;

    @Override
    public String toString() {
        return "BeanProject{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", projectContext='" + projectContext + '\'' +
                '}';
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectContext() {
        return projectContext;
    }

    public void setProjectContext(String projectContext) {
        this.projectContext = projectContext;
    }
}
