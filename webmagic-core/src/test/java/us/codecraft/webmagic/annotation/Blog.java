package us.codecraft.webmagic.annotation;

/**
 * @author yihua.huang@dianping.com <br>
 * @date: 13-8-1 <br>
 * Time: 下午10:18 <br>
 */
@TargetUrl("http://djjchobits.iteye.com/blog/\\d+")
public class Blog {

    @Fetcher("//title")
    private String title;

    @Fetcher(value = "div#main",type = Fetcher.Type.Css)
    private String content;

    @Override
    public String toString() {
        return "Blog{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
