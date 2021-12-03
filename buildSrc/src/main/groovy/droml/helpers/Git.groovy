package helpers

class Git {
    static String getCurrentBranch() {
        def branch = 'git symbolic-ref --short HEAD'.execute().text.trim()
        return branch
    }
}