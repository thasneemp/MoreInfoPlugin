public class WikipediaSearch extends SearchAction {
    @Override
    protected String getSite() {
        return "https://en.wikipedia.org/w/index.php?search=";
    }
}
