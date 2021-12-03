import helpers.Git
import org.gradle.api.GradleException


class BuildSettings{

    private Properties properties
    private File propertiesFile

    //props
    private Integer buildNumber
    private String versionName
    private Integer versionCode
    private String branchName
    private Boolean onDebug


    BuildSettings(String path) {
        readProps(path)
        initializeProps()
    }

    private def readProps(String path) {
        properties = new Properties()
        propertiesFile = new File(path)
        if (propertiesFile.canRead()) {
            properties.load(propertiesFile.newReader())

        } else {
            throw new GradleException("Could not read version.properties!")
        }
    }

    private initializeProps() {
        buildNumber = properties['BUILD_NUMBER'].toInteger()
        versionName = properties['VERSION_NAME'].toString()
        versionCode  = properties['VERSION_CODE'].toInteger()
        onDebug  = properties['ON_DEBUG'].toBoolean()
        branchName = Git.getCurrentBranch()

        StringBuilder stringBuilder = new StringBuilder(versionName)
        stringBuilder.append("." + buildNumber.toString())

        if (!branchName.equals("master")) {
            stringBuilder.append("." + branchName)
        }

        versionName = stringBuilder.toString()
    }

    def incrementing() {
        properties['BUILD_NUMBER'] = (getVersionCode() + 1).toString()
        properties.store(propertiesFile.newWriter(), null)
    }

    Integer getBuildNumber(){
        return this.buildNumber
    }

    String getVersionName() {
        return this.versionName
    }

    Integer getVersionCode() {
        return this.versionCode
    }

    String getBranchName() {
        return this.branchName
    }

    Boolean onDebug() {
        return this.onDebug
    }

}