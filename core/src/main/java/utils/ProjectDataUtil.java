package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.regex.Pattern;

/** Read Project data
 * @author Nandish Siddaiah
 * @version 1.0
 * @since 1.0
 */
public class ProjectDataUtil {

    /**
     * Get user specified Environment. If not specified via debug return default
     * @return String
     */
    public String getEnvironment(){
        if (System.getProperty("env") == null) {
            return "QA";
        } else {
            return System.getProperty("env");
        }
    }

    /**
     * Get Project root folder name
     * @return String
     */
    public String getModule() {
        String pattern = Pattern.quote(System.getProperty("file.separator"));
        String[] folders = System.getProperty("user.dir").split(pattern);
        return folders[folders.length - 1];
    }

    /**
     * Get Application Url. Depends on Environment set
     * @return
     * @throws IOException
     */
    public String getUrl() throws IOException {
        return getUrlpath().getProperty(getModule() + "_Env_" + getEnvironment().toUpperCase());
    }

    /**
     * Get path of *-url.properties in every runnable project
     * @return Properties
     * @throws IOException
     */
    public Properties getUrlpath() throws IOException {
        Properties urlpath = new Properties();
        InputStream urlResourceStream = ProjectDataUtil.class.getResourceAsStream("/" + getModule()+ "-url.properties");
        urlpath.load(urlResourceStream);
        return urlpath;
    }

    /**
     * Get path of *-data.properties in every runnable project
     * @return Properties
     * @throws IOException
     */
    public Properties getProjectData() throws IOException {
        Properties projectData = new Properties();
        InputStream urlResourceStream = ProjectDataUtil.class.getResourceAsStream("/" + getModule()+ "-data.properties");
        projectData.load(urlResourceStream);
        return projectData;
    }

}
