package us.codecraft.spider.samples;

import us.codecraft.spider.Page;
import us.codecraft.spider.Site;
import us.codecraft.spider.processor.PageProcessor;

import java.util.List;

/**
 * User: cairne
 * Date: 13-4-21
 * Time: 下午8:08
 */
public class QzoneBlogProcessor implements PageProcessor {
    @Override
    public void process(Page page) {
        //http://progressdaily.diandian.com/post/2013-01-24/40046867275

        //http://b1.cnc.qzone.qq.com/cgi-bin/blognew/get_abs?hostUin=233017404&uin=233017404&blogType=0&statYear=2013&source=0&statYear=2013&g_tk=291639571&g_tk=291639571&reqInfo=7&pos=0&num=15&source=0&rand=0.46480297949165106
        // &cateName=&cateHex=&statYear=2013&reqInfo=7&pos=0&num=15&sortType=0&source=0&rand=0.46480297949165106&g_tk=291639571&verbose=1&ref=qzone
        List<String> requests = page.getHtml().rs("<a[^<>]*href=[\"']{1}(http://17dujingdian\\.com/post/[^#]*?)[\"']{1}").toStrings();
        page.addTargetRequests(requests);
        page.putField("title",page.getHtml().x("//div[@id='content']//h2/a"));
        page.putField("content",page.getHtml().sc());
    }

    @Override
    public Site getSite() {
        return Site.me().setDomain("www.diandian.com").setStartUrl("http://17dujingdian.com/").
                setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");
    }
}
