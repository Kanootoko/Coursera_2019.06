package space.kanootoko.courseraWeek4;

public class SearchSystem {

    private enum SSystem {google, bing, yandex}

    private SSystem mSystem;

    public SearchSystem(String name) {
        switch (name.toLowerCase()) {
            case "google":
                mSystem = SSystem.google;
                break;
            case "bing":
                mSystem = SSystem.bing;
                break;
            case "yandex":
                mSystem = SSystem.yandex;
                break;
            default:
                throw new IllegalArgumentException(String.format("%s is not a search system", name));
        }
    }

    public String search(String text) {
        switch(mSystem) {
            case google:
                return String.format("https://google.com/search?q=%s", text);
            case bing:
                return String.format("https://bing.com/search?q=%s", text);
            case yandex:
                return String.format("https://yandex.ru/search?text=%s", text);
            default:
                return "";
        }
    }

    @Override
    public String toString() {
        return mSystem.name();
    }
}
