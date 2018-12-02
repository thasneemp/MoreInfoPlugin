public class GitHubSearch extends SearchAction {
    @Override
    protected String getSite() {
        return "https://github.com/search?q=";
    }
}
