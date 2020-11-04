package com.github.lyrric.test;

import com.github.lyrric.spider.parser.HtmlParser;
import com.github.lyrric.spider.util.HttpUtil;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2020-11-02.
 *
 * @author wangxiaodong
 */
public class SpiderTest {

    public static void main(String[] args) throws IOException {

        HtmlParser.parseHtml(" " +
                "<!DOCTYPE html> " +
                "<html> " +
                " <head lang=\"ch\"> " +
                "<meta charset=\"UTF-8\"> " +
                "<meta name=\"viewport\" content=\"initial-scale=1, maximum-scale=1, user-scalable=no\"> " +
                "<meta name=\"format-detection\" content=\"telephone=no\"> " +
                "<meta content=\"no-transform\" http-equiv=\"Cache-Control\" /> " +
                "<meta content=\"no-siteapp\" http-equiv=\"Cache-Control\" /> " +
                "<meta name=\"applicable-device\" content=\"mobile\"> " +
                "<title>广东彩艳股份有限公司_邱德亮_工商注册信息_红盾查询网</title> " +
                "<meta name=\"keywords\" content=\"广东彩艳股份有限公司,营业执照,工商信息,注册信息,信用信息,公示查询,信用报告,联系方式,统一社会信用代码,股东,注册号,注册地址,法人代表,经营范围,企业类型,注册资本,成立时间\" /> " +
                "<meta name=\"description\" content=\"红盾查询网提供广东彩艳股份有限公司工商注册信息查询,营业执照,联系方式,企业信用信息公示,统一社会信用代码,股东,注册号,注册地址,法人代表,经营范围,企业类型,注册资本,成立时间。\" /> " +
                "<link rel=\"canonical\" href=\"https://www.ubaike.cn/show_3214.html\" > " +
                "<link rel=\"stylesheet\" href=\"https://cdn.ubaike.cn/static/css/fronze/css/frozen.css?v=1.8\"> " +
                "<link rel=\"stylesheet\" href=\"https://cdn.ubaike.cn/static/css/fronze/css/main.css?v=13.2\"> " +
                "<link rel=\"stylesheet\" media=\"all\" href=\"https://cdn.ubaike.cn/static/css/fronze/css/green.css?v=8.9\" /> " +
                "<link rel=\"stylesheet\" media=\"all\" href=\"https://cdn.ubaike.cn/static/css/fronze/js/lib/swiper.min.css\" /> " +
                "<script src=\"https://cdn.ubaike.cn/static/css/fronze/js/lib/swiper.min.js\" type=\"text/javascript\"></script> " +
                "<script src=\"https://cdn.ubaike.cn/static/css/fronze/lib/zepto.min.js\" type=\"text/javascript\"></script> " +
                "<link href=\"https://cdn.ubaike.cn/static/css/static/css/font-awesome/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\" /> " +
                "<script src=\"https://cdn.ubaike.cn/static/css/fronze/js/frozen.js?v=1.2\" type=\"text/javascript\"></script> " +
                "<script src=\"https://cdn.ubaike.cn/static/css/fronze/js/ad2018.js?v=3.79\" type=\"text/javascript\"></script><script src=\"https://cdn.ubaike.cn/static/js/nativeShare.js?v=1.1\" type=\"text/javascript\"></script> " +
                " " +
                "        <script type=\"text/javascript\"> " +
                "            var g_site_url = \"https://m.ubaike.cn/\"; " +
                "            var query = '?'; " +
                "            var g_site_name = \"红盾查询网\"; " +
                "            var g_prefix = \"\"; " +
                "            var g_suffix = \".html\"; " +
                "            var g_uid = 0; " +
                "            </script> " +
                "    <script type=\"application/ld+json\"> " +
                "        { " +
                "            \"@context\": \"https://ziyuan.baidu.com/contexts/cambrian.jsonld\", " +
                "            \"@id\": \"https://m.ubaike.cn/show_3214.html\", " +
                "            \"appid\": \"1607466439237179\", " +
                "            \"title\": \"广东彩艳股份有限公司_邱德亮_工商注册信息_红盾查询网\", " +
                "            \"description\": \"红盾查询网提供广东彩艳股份有限公司工商注册信息查询,营业执照,联系方式,企业信用信息公示,统一社会信用代码,股东,注册号,注册地址,法人代表,经营范围,企业类型,注册资本,成立时间。\", " +
                "            \"upDate\": \"2019-07-01T10:43:30\" " +
                "        } " +
                "    </script></head> " +
                "<body ontouchstart> " +
                "<section class=\"ui-container articlebg\"> " +
                "<div class=\"ws_header\"> " +
                "<i class=\"fa fa-angle-left\" onclick=\"javascript:history.back(-1);\"></i> " +
                "<div class=\"ws_h_title\"><a href=\"/\"><img class=\"expand\" src=\"https://cdn.ubaike.cn/img/m_logo.png\" alt=\"红盾查询\" width=\"130\"></a></div> " +
                "<i class=\"fa fa-search\" onclick=\"window.location.href='https://m.ubaike.cn/question/searchkey.html'\"></i> " +
                "</div> " +
                "<ul class=\"tab-head\"> " +
                "                      <li class=\"tab-head-item \"><a href=\"/\" title=\"首页\">首页</a></li>     " +
                "                      <li class=\"tab-head-item \"><a href=\"https://m.ubaike.cn/p/club/\" title=\"说说\">说说</a></li>  " +
                "                      <li class=\"tab-head-item \"><a href=\"https://m.ubaike.cn/new/\" title=\"问答\">问答</a></li> " +
                "                      <li class=\"tab-head-item \"><a href=\"https://m.ubaike.cn/expert/\" title=\"咨询\">咨询</a></li> " +
                "                      <li class=\"tab-head-item\" id=\"user_con\"><a onclick=\"window.location.href='https://m.ubaike.cn/user/login.html'\">我的</a></li> " +
                "</ul><div class=\"htop\"></div> <script> " +
                "var _topictitle=\"广东彩艳股份有限公司\";                                    var topicdescription=\"\"; " +
                "var topiclink=\"https://m.ubaike.cn/show_3214.html\"; " +
                "</script> " +
                "<section> " +
                "<article class=\"article\"> " +
                "    <h1 class=\"title\">广东彩艳股份有限公司</h1> " +
                "<div class=\"new-style-test-article-author\"> " +
                "<span style=\"display:inline-block;\"> " +
                "<div>法定代表人：<a href=\"https://m.ubaike.cn/person_5828777.html\"> " +
                "<span class=\"new-style-test-article-author-name tname\">邱德亮</span> " +
                "</a></div> " +
                "<div> " +
                "<span class=\"new-style-test-article-publish-time wztime\">查询时间：2019-07-01 10:43</span> " +
                "</div> " +
                "</span> " +
                "<!-- 更新按钮 --> " +
                "<a class=\"new-style-test-favor-btn button_followed wzbtn\" href=\"https://m.ubaike.cn/inform/add/3214.html\"><span>更新</span></a> " +
                "</div> " +
                "    <div class=\"article-content art-content\"> " +
                "                   <p id=\"login_tel\"><span>联系电话：0750-631***</span><a onclick=\"login()\" class=\"small\"> 查看号码&nbsp;</a></p>                                                 " +
                "             " +
                "             " +
                "      <div class=\"gud\">高新企业</div> " +
                "<div id=\"partners\" class=\"content-block\"> " +
                "<div> " +
                "    <table class=\"stable\"> " +
                "      <thead><tr><th width=\"40%\">证书编号</th><th width=\"30%\">发证时间</th><th>截止时间</th></tr></thead> " +
                "      <tbody> " +
                "        <tr><td>GR201844000654</td><td>2018-11-28</td><td>2021-11-28</td></tr> " +
                "      </tbody></table> " +
                "  </div> " +
                " </div> " +
                "             " +
                "      <div class=\"gud\">企业年报</div> " +
                "<div id=\"partners\" class=\"content-block\"> " +
                "<span class=\"block-num\">6</span> " +
                "<div> " +
                "    <table class=\"stable\"> " +
                "      <thead><tr><th class=\"sort-col\">序号</th><th width=\"\">年报</th><th class=\"doing-col\">查看</th></tr></thead> " +
                "      <tbody> " +
                "                <tr><td class=\"text-center\">1</td><td>2018年度年报信息</td><td><a class=\"link-click\" href=\"https://m.ubaike.cn/report_3214/2018.html\" target=\"_blank\">详情</a></td></tr> " +
                "                <tr><td class=\"text-center\">2</td><td>2017年度年报信息</td><td><a class=\"link-click\" href=\"https://m.ubaike.cn/report_3214/2017.html\" target=\"_blank\">详情</a></td></tr> " +
                "                <tr><td class=\"text-center\">3</td><td>2016年度年报信息</td><td><a class=\"link-click\" href=\"https://m.ubaike.cn/report_3214/2016.html\" target=\"_blank\">详情</a></td></tr> " +
                "                <tr><td class=\"text-center\">4</td><td>2015年度年报信息</td><td><a class=\"link-click\" href=\"https://m.ubaike.cn/report_3214/2015.html\" target=\"_blank\">详情</a></td></tr> " +
                "                <tr><td class=\"text-center\">5</td><td>2014年度年报信息</td><td><a class=\"link-click\" href=\"https://m.ubaike.cn/report_3214/2014.html\" target=\"_blank\">详情</a></td></tr> " +
                "                <tr><td class=\"text-center\">6</td><td>2013年度年报信息</td><td><a class=\"link-click\" href=\"https://m.ubaike.cn/report_3214/2013.html\" target=\"_blank\">详情</a></td></tr> " +
                "              </tbody></table> " +
                "  </div> " +
                " </div> " +
                "             " +
                "      <div class=\"gud\">法律诉讼</div> " +
                "<div id=\"partners\" class=\"content-block\"> " +
                "<span class=\"block-num\">4</span> " +
                "<div> " +
                "    <table class=\"ntable fn15\"> " +
                "      <thead><tr><th class=\"sort-col\">序号</th><th width=\"\">案件名称</th></tr></thead> " +
                "      <tbody> " +
                "                <tr><td class=\"text-center\">1</td><td><a class=\"link-click\" href=\"https://m.ubaike.cn/wenshu_393990.html\" target=\"_blank\">广东彩艳股份有限公司与上海安沛实业有限公司买卖合同纠纷一审民事判决书</a></td></tr> " +
                "                <tr><td class=\"text-center\">2</td><td><a class=\"link-click\" href=\"https://m.ubaike.cn/wenshu_1906431.html\" target=\"_blank\">江门市彩信化工有限公司与赵俊峰劳动合同纠纷一案民事一审判决书</a></td></tr> " +
                "                <tr><td class=\"text-center\">3</td><td><a class=\"link-click\" href=\"https://m.ubaike.cn/wenshu_1906453.html\" target=\"_blank\">江门市彩信化工有限公司与万朝会劳动合同纠纷一案民事一审判决书</a></td></tr> " +
                "                <tr><td class=\"text-center\">4</td><td><a class=\"link-click\" href=\"https://m.ubaike.cn/wenshu_2074501.html\" target=\"_blank\">广东彩艳股份有限公司与衡水宝秋数码科技有限公司买卖合同纠纷一审民事裁定书</a></td></tr> " +
                "              </tbody></table> " +
                "  </div> " +
                "   </div> " +
                "             " +
                "      <div class=\"gud\">分支机构</div> " +
                "<div id=\"partners\" class=\"content-block\"> " +
                "<span class=\"block-num\">2</span> " +
                "<div> " +
                "    <table class=\"stable fn15\"> " +
                "      <thead><tr><th class=\"sort-col\">序号</th><th width=\"\">企业名称</th></tr></thead> " +
                "      <tbody> " +
                "                <tr><td class=\"text-center\">1</td><td><a class=\"link-click\" href=\"https://m.ubaike.cn/show_13056174.html\" target=\"_blank\">广东彩艳股份有限公司新会分公司</a></td></tr> " +
                "                <tr><td class=\"text-center\">2</td><td><a class=\"link-click\" href=\"https://m.ubaike.cn/show_18951417.html\" target=\"_blank\">广东彩艳股份有限公司禅城分公司</a></td></tr> " +
                "              </tbody></table> " +
                "  </div> " +
                "   </div> " +
                "             " +
                "             " +
                "    </div> " +
                "    </article> " +
                " " +
                "<div id=\"shareTotal\"> " +
                "<div id=\"nativeShare\" class=\"padb0\"></div> " +
                " " +
                "<div class=\"show-tfoot\"><a class=\"notebook\">地区 > </a> " +
                "                <a class=\"notebook\" href=\"https://m.ubaike.cn/class_7.html\" data-toggle=\"tooltip\" data-html=\"true\" data-original-title=\"广东\"> " +
                "                    <span>广东</span> " +
                "                </a> " +
                "<div class=\"modal-wrap\" data-report-note=\"\"> " +
                "<a href=\"https://m.ubaike.cn/favorite/scadd/3214.html\">收藏企业</a> " +
                "</div> " +
                "</div> " +
                " " +
                "</div> " +
                "<div id='after_login'> " +
                "    <div class=\"ui-btn-wrap\"> " +
                "    <button onclick=\"window.location.href='https://m.ubaike.cn/user/login.html'\" class=\"ui-btn-lg ui-btn-danger\"> " +
                "        登录发布评论 " +
                "    </button> " +
                "</div> " +
                "  </div> " +
                "<div id='c-con'> " +
                "    </div> " +
                "   " +
                "<div class=\"clxxl\"> " +
                "<div class=\"feedtit\">猜你喜欢</div> " +
                "<div class=\"margin94\"><script>news_sy_01();</script></div> " +
                "</div> " +
                "   " +
                "<div class=\"qzoushi\"> " +
                "<div class=\"feedtit\">相关推荐</div> " +
                "<ul class=\"clist la-list\">          <li class=\"list\"> " +
                "    <div class=\"cls-point icls-point\"> " +
                "            <div class=\"meta fl marb12\"> " +
                "            <p class=\"btn-icon color-text3\"> " +
                "              <span class=\"avatar\"> " +
                "                    <img src=\"//cdn.ubaike.cn/ubaike/static/css/default/avatar.gif\"> " +
                "              </span> " +
                "             <span class=\"fdname\">chenjieli0929</span> " +
                "            </p> " +
                "            </div> " +
                "   <a href=\"https://m.ubaike.cn/q_10578.html\"> " +
                "              <div class=\"text-wrap width100\"> " +
                "<h1 class=\"marb5\">公司公户上的钱，怎么才能提出来？</h1> " +
                "</div> " +
                "<div class=\"desc left65\">想提钱出来又想少交税，你一定是老板吧，不然的话也轮不到你想这个问题!请参考以下方法： " +
                "一、简单粗...</div>            <div class=\"text-img\"> " +
                "<img src=\"https://img.ubaike.cn/data/imgouter/MmGrFGQ697.jpg?x-oss-process=image/resize,m_fill,h_200,w_300\"> " +
                "            </div> " +
                "                        </a> " +
                "            <div class=\"meta clear\"> " +
                "            <p class=\"btn-icon color-text3\"> " +
                "             <span class=\"collection-tag\"><a class=\"collection-tag\" target=\"_self\"  href=\"/c_390.html\"><i class=\"fa fa-map-marker\"></i> 企业问答</a> </span><span> 976阅读 · 1评论</span> " +
                "            </p> " +
                "            </div> " +
                "            </div> " +
                " </li><li class=\"listad\"><div class=\"cls-point\"><script>duotu();</script></div></li>              <li class=\"list\"> " +
                "    <div class=\"cls-point icls-point\"> " +
                "            <div class=\"meta fl marb12\"> " +
                "            <p class=\"btn-icon color-text3\"> " +
                "              <span class=\"avatar\"> " +
                "                    <img src=\"https://m.ubaike.cn/data/avatar/000/12/25/small_000122555.jpg\"> " +
                "              </span> " +
                "             <span class=\"fdname\">一鹿货色 " +
                "</span> " +
                "            </p> " +
                "            </div> " +
                "   <a href=\"https://m.ubaike.cn/p/10572\"> " +
                "              <div class=\"text-wrap width100\"> " +
                "<h1 class=\"marb5\">中国近10年首富排名，他们都是谁？</h1> " +
                "</div> " +
                "<div class=\"desc left65\">2020年，马云，阿里巴巴集团，5601亿元2019年，马云，阿里巴巴集团，2750亿元2018年，马化腾，...</div>            <div class=\"text-img\"> " +
                "<img src=\"https://img.ubaike.cn/data/attach/2010/FR4EQ73D.jpg?x-oss-process=image/resize,m_fill,h_200,w_300\"> " +
                "            </div> " +
                "                        </a> " +
                "            <div class=\"meta clear\"> " +
                "            <p class=\"btn-icon color-text3\"> " +
                "             <span class=\"collection-tag\"><a class=\"collection-tag\" target=\"_self\"  href=\"/c_3810.html\"><i class=\"fa fa-map-marker\"></i> 行业资讯</a> </span><span> 2108阅读</span> " +
                "            </p> " +
                "            </div> " +
                "            </div> " +
                " </li>              <li class=\"list\"> " +
                "    <div class=\"cls-point icls-point\"> " +
                "            <div class=\"meta fl marb12\"> " +
                "            <p class=\"btn-icon color-text3\"> " +
                "              <span class=\"avatar\"> " +
                "                    <img src=\"https://m.ubaike.cn/data/avatar/000/00/01/small_000000137.jpg\"> " +
                "              </span> " +
                "             <span class=\"fdname\">好像看雪</span> " +
                "            </p> " +
                "            </div> " +
                "   <a href=\"https://m.ubaike.cn/p/10571\"> " +
                "              <div class=\"text-wrap width100\"> " +
                "<h1 class=\"marb5\">蚂蚁集团上市的四重意义</h1> " +
                "</div> " +
                "<div class=\"desc left65\">蚂蚁上市，是A股市场迄今为止最为震撼的一幕，具有历史性的四重意义。第一，从中国经济层面来讲...</div>            <div class=\"text-img\"> " +
                "<img src=\"https://img.ubaike.cn/data/attach/2010/eFagq0hi.jpg?x-oss-process=image/resize,m_fill,h_200,w_300\"> " +
                "            </div> " +
                "                        </a> " +
                "            <div class=\"meta clear\"> " +
                "            <p class=\"btn-icon color-text3\"> " +
                "             <span class=\"collection-tag\"><a class=\"collection-tag\" target=\"_self\"  href=\"/c_383.html\"><i class=\"fa fa-map-marker\"></i> 科技行业</a> </span><span> 1490阅读 · 6评论</span> " +
                "            </p> " +
                "            </div> " +
                "            </div> " +
                " </li>              <li class=\"list\"> " +
                "    <div class=\"cls-point icls-point\"> " +
                "            <div class=\"meta fl marb12\"> " +
                "            <p class=\"btn-icon color-text3\"> " +
                "              <span class=\"avatar\"> " +
                "                    <img src=\"https://m.ubaike.cn/data/avatar/000/12/25/small_000122556.jpg\"> " +
                "              </span> " +
                "             <span class=\"fdname\">研习社 " +
                "</span> " +
                "            </p> " +
                "            </div> " +
                "   <a href=\"https://m.ubaike.cn/p/10569\"> " +
                "              <div class=\"text-wrap width100\"> " +
                "<h1 class=\"marb5\">微软的盈利能力，才叫一个华山绝顶！</h1> " +
                "</div> " +
                "<div class=\"desc left65\">微软公布2021财年第一季度财报，营业收入371.54亿美元，同比增长12%，分业务看，个人计算业务收...</div>            <div class=\"text-img\"> " +
                "<img src=\"https://img.ubaike.cn/data/attach/2010/N3LmS5ph.png?x-oss-process=image/resize,m_fill,h_200,w_300\"> " +
                "            </div> " +
                "                        </a> " +
                "            <div class=\"meta clear\"> " +
                "            <p class=\"btn-icon color-text3\"> " +
                "             <span class=\"collection-tag\"><a class=\"collection-tag\" target=\"_self\"  href=\"/c_383.html\"><i class=\"fa fa-map-marker\"></i> 科技行业</a> </span><span> 1055阅读 · 5评论</span> " +
                "            </p> " +
                "            </div> " +
                "            </div> " +
                " </li>              <li class=\"list\"> " +
                "    <div class=\"cls-point icls-point\"> " +
                "            <div class=\"meta fl marb12\"> " +
                "            <p class=\"btn-icon color-text3\"> " +
                "              <span class=\"avatar\"> " +
                "                    <img src=\"https://m.ubaike.cn/data/avatar/000/00/72/small_000007284.jpg\"> " +
                "              </span> " +
                "             <span class=\"fdname\">麻辣婊</span> " +
                "            </p> " +
                "            </div> " +
                "   <a href=\"https://m.ubaike.cn/p/10566\"> " +
                "              <div class=\"text-wrap width100\"> " +
                "<h1 class=\"marb5\">2020我国最富有的100人财富合计高达10万亿元</h1> " +
                "</div> " +
                "<div class=\"desc left65\">2020年我国最富有排名前100人财富合计高达102510亿元，财富资产高达10万亿元，同比2019年大幅增...</div>            <div class=\"text-img\"> " +
                "<img src=\"https://img.ubaike.cn/data/attach/2010/MU0d8Ab2.jpg?x-oss-process=image/resize,m_fill,h_200,w_300\"> " +
                "            </div> " +
                "                        </a> " +
                "            <div class=\"meta clear\"> " +
                "            <p class=\"btn-icon color-text3\"> " +
                "             <span class=\"collection-tag\"><a class=\"collection-tag\" target=\"_self\"  href=\"/c_3810.html\"><i class=\"fa fa-map-marker\"></i> 行业资讯</a> </span><span> 2863阅读</span> " +
                "            </p> " +
                "            </div> " +
                "            </div> " +
                " </li><li class=\"listad\"><div class=\"cls-point\"><script>duotu();</script></div></li>              <li class=\"list\"> " +
                "    <div class=\"cls-point icls-point\"> " +
                "            <div class=\"meta fl marb12\"> " +
                "            <p class=\"btn-icon color-text3\"> " +
                "              <span class=\"avatar\"> " +
                "                    <img src=\"https://m.ubaike.cn/data/avatar/000/12/25/small_000122554.jpg\"> " +
                "              </span> " +
                "             <span class=\"fdname\">一点方圆 " +
                "</span> " +
                "            </p> " +
                "            </div> " +
                "   <a href=\"https://m.ubaike.cn/p/10564\"> " +
                "              <div class=\"text-wrap width100\"> " +
                "<h1 class=\"marb5\">在公司里，老板越来越不敢说话了，为什么？</h1> " +
                "</div> " +
                "<div class=\"desc left65\">有个老板对秘书说，中午帮我买肯德基，30分钟后，秘书回来了，说肯德基买好了，一共4.6亿美元。...</div>            <div class=\"text-img\"> " +
                "<img src=\"https://img.ubaike.cn/data/attach/2010/2o2Grm5w.jpg?x-oss-process=image/resize,m_fill,h_200,w_300\"> " +
                "            </div> " +
                "                        </a> " +
                "            <div class=\"meta clear\"> " +
                "            <p class=\"btn-icon color-text3\"> " +
                "             <span class=\"collection-tag\"><a class=\"collection-tag\" target=\"_self\"  href=\"/c_352.html\"><i class=\"fa fa-map-marker\"></i> 经营管理</a> </span><span> 2375阅读 · 7评论</span> " +
                "            </p> " +
                "            </div> " +
                "            </div> " +
                " </li>              <li class=\"list\"> " +
                "    <div class=\"cls-point icls-point\"> " +
                "            <div class=\"meta fl marb12\"> " +
                "            <p class=\"btn-icon color-text3\"> " +
                "              <span class=\"avatar\"> " +
                "                    <img src=\"//cdn.ubaike.cn/ubaike/static/css/default/avatar.gif\"> " +
                "              </span> " +
                "             <span class=\"fdname\">anzhuanan</span> " +
                "            </p> " +
                "            </div> " +
                "   <a href=\"https://m.ubaike.cn/q_10562.html\"> " +
                "              <div class=\"text-wrap width100\"> " +
                "<h1 class=\"marb5\">请代账公司做账报税会面临哪些风险？</h1> " +
                "</div> " +
                "<div class=\"desc left65\">几乎每天都会接到代账公司的电话，问需不需要帮做账，有的时候甚至一天好几个，偶尔还在中午休息的时...</div>            <div class=\"text-img\"> " +
                "<img src=\"https://img.ubaike.cn/data/attach/2010/rkNoQdk3.jpg?x-oss-process=image/resize,m_fill,h_200,w_300\"> " +
                "            </div> " +
                "                        </a> " +
                "            <div class=\"meta clear\"> " +
                "            <p class=\"btn-icon color-text3\"> " +
                "             <span class=\"collection-tag\"><a class=\"collection-tag\" target=\"_self\"  href=\"/c_3809.html\"><i class=\"fa fa-map-marker\"></i> 财税知识</a> </span><span> 548阅读 · 3评论</span> " +
                "            </p> " +
                "            </div> " +
                "            </div> " +
                " </li>              <li class=\"list\"> " +
                "    <div class=\"cls-point icls-point\"> " +
                "            <div class=\"meta fl marb12\"> " +
                "            <p class=\"btn-icon color-text3\"> " +
                "              <span class=\"avatar\"> " +
                "                    <img src=\"https://m.ubaike.cn/data/avatar/000/00/97/small_000009780.jpg\"> " +
                "              </span> " +
                "             <span class=\"fdname\">黑白格调</span> " +
                "            </p> " +
                "            </div> " +
                "   <a href=\"https://m.ubaike.cn/p/10561\"> " +
                "              <div class=\"text-wrap width100\"> " +
                "<h1 class=\"marb5\">注销公司的时候是先注销工商还是先注销银行账户？</h1> " +
                "</div> " +
                "<div class=\"desc left65\">公司注销工作，大部分工作都是由会计来完成的，比如注销税务是公司注销环节的重中之重，税务注销...</div>            <div class=\"text-img\"> " +
                "<img src=\"https://img.ubaike.cn/data/attach/2010/buR6676i.png?x-oss-process=image/resize,m_fill,h_200,w_300\"> " +
                "            </div> " +
                "                        </a> " +
                "            <div class=\"meta clear\"> " +
                "            <p class=\"btn-icon color-text3\"> " +
                "             <span class=\"collection-tag\"><a class=\"collection-tag\" target=\"_self\"  href=\"/c_390.html\"><i class=\"fa fa-map-marker\"></i> 企业问答</a> </span><span> 2914阅读 · 3评论</span> " +
                "            </p> " +
                "            </div> " +
                "            </div> " +
                " </li>    </ul> " +
                "<div id=\"getmorebtn1\" class=\"cmore imore\"><>加载更多<i class=\"fa fa-more\"></i></div> " +
                "</div> " +
                "<div class=\"clxxl\"><script>news_sy_02();</script></div> " +
                "<div class=\"elib-class\"> " +
                "  <div class=\"class-group elib-class-group elib-class\"> " +
                "    <a class=\"class-group-item\" href=\"https://m.ubaike.cn/list_1\"><i class=\"fa fa-th-list\"></i><h2>上市公司</h2></a> " +
                "    <a class=\"class-group-item\" href=\"https://m.ubaike.cn/list_7\"><i class=\"fa fa-book\"></i><h2>裁判文书</h2></a> " +
                "    <a class=\"class-group-item\" href=\"https://m.ubaike.cn/list_6\"><i class=\"fa fa-exclamation-triangle\"></i><h2>经营异常</h2></a> " +
                "    <a class=\"class-group-item\" href=\"https://m.ubaike.cn/list_5\"><i class=\"fa fa-address-card\"></i><h2>失信信息</h2></a> " +
                "    <a class=\"class-group-item\" href=\"https://m.ubaike.cn/list_4\"><i class=\"fa fa-file-text-o\"></i><h2>企业年报</h2></a> " +
                "    <a class=\"class-group-item\" href=\"https://m.ubaike.cn/list_8\"><i class=\"fa fa-window-maximize\"></i><h2>社会组织</h2></a> " +
                "    <a class=\"class-group-item\" href=\"https://m.ubaike.cn/list_9\"><i class=\"fa fa-money\"></i><h2>融资信息</h2></a> " +
                "    <a class=\"class-group-item\" href=\"https://m.ubaike.cn/list_10\"><i class=\"fa fa-newspaper-o\"></i><h2>被执行人</h2></a> " +
                "  </div> " +
                "  </div><!-- 举报 --> " +
                "<script> " +
                " " +
                "function getmorec(page) " +
                "{ " +
                " $.ajax({ " +
                "     url: \"https://m.ubaike.cn/index.php?index/getmorecs\", " +
                "     async:false, " +
                "     type : 'POST', " +
                "      data :{ " +
                "        page:page, " +
                "      }, " +
                "      success:function(data) " +
                "      { " +
                "        console.log(data); " +
                "        $('.clist').append(data); " +
                "      } " +
                "    });  " +
                "} " +
                " " +
                "var page =0; " +
                "$(window).scroll(function(){ " +
                "var imore_height = $(\".cmore\").offset().top; " +
                "     if($(window).scrollTop()>= imore_height - $(window).height() - 50){ " +
                "       page++; " +
                "       if(page<6){ " +
                "         getmorec(page); " +
                "       }else{ " +
                "         document.getElementById(\"getmorebtn1\").innerHTML = \"没有更多了\"; " +
                "       } " +
                "     } " +
                "}); " +
                " " +
                "//顶部异步登录 " +
                "function checkLogin() " +
                "{ " +
                "$.ajax({ " +
                "      url: \"https://m.ubaike.cn/index.php?index/c_loginwap\", " +
                "      success:function(data) " +
                "      { " +
                "        if(data!=1) " +
                "        { " +
                "          $('#user_con').html(data); " +
                "        } " +
                "      } " +
                "    });  " +
                "} " +
                "  //登录后查看 " +
                "function login_tel() " +
                "{ " +
                "  var topic_id=3214; " +
                "$.ajax({ " +
                "      url: \"https://m.ubaike.cn/index.php?index/login_tel\", " +
                "      cache: false, " +
                "      data:{ " +
                "              'topic_id':topic_id " +
                "            }, " +
                "     type : 'POST', " +
                "      success:function(result) " +
                "      { " +
                "        console.log(result); " +
                "        if(result!=1) " +
                "        { " +
                "          $('#login_tel').html(result); " +
                "        } " +
                "      } " +
                "    });  " +
                "} " +
                "login_tel();   " +
                "   " +
                "function getguid() " +
                "{ " +
                "$.ajax({ " +
                "      url: \"https://m.ubaike.cn/index.php?index/getguid\", " +
                "     type : 'POST', " +
                "      success:function(data) " +
                "      { " +
                "          window.g_uid=data; " +
                "        if(data>0){ " +
                "          checkLogin(); " +
                "          afterlogin(); " +
                "          checkLoginfooter(); " +
                "        } " +
                "      } " +
                "    });  " +
                "} " +
                "getguid(); " +
                "  " +
                "function getzb() " +
                "{ " +
                "  var topic_id=3214; " +
                "$.ajax({ " +
                "      url: \"https://m.ubaike.cn/index.php?index/zcziben\", " +
                "      type : 'POST', " +
                "      data:{ " +
                "              'topic_id':topic_id " +
                "            }, " +
                "      cache: false, " +
                "      success:function(result) " +
                "      { " +
                "        console.log(result); " +
                "        $('#getzb').html(result); " +
                "      } " +
                "    });  " +
                "} " +
                "getzb(); " +
                " " +
                "//登录后评论 " +
                "function afterlogin() " +
                "{ " +
                "  var topic_id=3214; " +
                "$.ajax({ " +
                "      url: \"https://m.ubaike.cn/index.php?index/afterloginwap\", " +
                "       data:{ " +
                "              'topic_id':topic_id " +
                "            }, " +
                "       type : 'POST', " +
                "      dataType:'JSON', " +
                "      success:function(data) " +
                "      { " +
                "        var data=eval('('+data+')'); " +
                "        " +
                "          $('#after_login').html(data.after_login); " +
                "         " +
                "      } " +
                "    });  " +
                "} " +
                " " +
                "GetComments(1); " +
                "function GetComments(page) " +
                "{ " +
                "  $(\"#c-con .pages\").remove(); " +
                "  var topic_id=3214; " +
                "  $.ajax({ " +
                "            url:'https://m.ubaike.cn/index.php?index/get_pl', " +
                "            data:{ " +
                "              'tid':topic_id, " +
                "              'page':page " +
                "            }, " +
                "            type : 'POST', " +
                "            dataType : 'text', " +
                "            success : function(result) " +
                "            { " +
                "              console.log(result); " +
                "                  " +
                "                    $('#c-con').append(result); " +
                "           " +
                "                " +
                "            }, " +
                "            error : function(XMLHttpRequest, textStatus, errorThrown) " +
                "            { " +
                "              alert(textStatus); " +
                "            } " +
                "          }); " +
                "} " +
                " " +
                " " +
                "$(\"#c-con\").on('click','.button_agree',function(){ " +
                "    var supportobj = $(this); " +
                "            var tid = $(this).attr(\"id\"); " +
                "            $.ajax({ " +
                "            type: \"GET\", " +
                "                    url:\"https://m.ubaike.cn/index.php?index/ajaxhassupport/\" + tid, " +
                "                    cache: false, " +
                "                    success: function(hassupport){ " +
                "                    if (hassupport != '1'){ " +
                "                            $.ajax({ " +
                "                            type: \"GET\", " +
                "                                    cache:false, " +
                "                                    url: \"https://m.ubaike.cn/index.php?index/ajaxaddsupport/\" + tid, " +
                "                                    success: function(comments) { " +
                " " +
                "                                    supportobj.find(\"span\").html(comments+\"人赞\"); " +
                "                                    } " +
                "                            }); " +
                "                    }else{ " +
                "                     alert(\"您已经赞过\"); " +
                "                    } " +
                "                    } " +
                "            }); " +
                "    }); " +
                " " +
                "    function viewtopic(paymoney,_answerid){ " +
                "   var dia=$.dialog({ " +
                "        title:'<center>温馨提示</center>', " +
                "        select:0, " +
                "        content:'<center><p style=\"color:red;margin-top:5px;\">查看需要支付'+paymoney+'积分</p></center>', " +
                "        button:[\"确认支付\",\"取消\"] " +
                "    }); " +
                "    dia.on(\"dialog:action\",function(e){ " +
                "     if(e.index==1){ " +
                "      return false; " +
                "     } " +
                "      var _tid=_answerid; " +
                "   $.ajax({ " +
                "        //提交数据的类型 POST GET " +
                "        type:\"POST\", " +
                "        //提交的网址 " +
                "        url:\"https://m.ubaike.cn/rule/postreward.html\", " +
                "        //提交的数据 " +
                "        data:{tid:_tid}, " +
                "        //返回数据的格式 " +
                "        datatype: \"text\",//\"xml\", \"html\", \"script\", \"json\", \"jsonp\", \"text\". " +
                " " +
                "        //成功返回之后调用的函数 " +
                "        success:function(data){ " +
                " " +
                "         data=$.trim(data); " +
                "         if(data==-2){ " +
                "          alert('游客先登录!'); " +
                "         } " +
                "         if(data==-3){ " +
                "          alert('本人无需支付积分查看!'); " +
                "         } " +
                "         if(data==-4){ " +
                "          alert('查看失败!'); " +
                "         } " +
                "         if(data==-1){ " +
                "          alert('不需要支付积分查看!'); " +
                "         } " +
                "         if(data==2){ " +
                "           " +
                "         } " +
                "         if(data==0){ " +
                "          alert('积分不足，先充值或者去赚积分!'); " +
                "          window.location.href = \"https://m.ubaike.cn/user/creditrecharge.html\"; " +
                "         } " +
                "         if(data==1){ " +
                "          window.location.reload(); " +
                "         } " +
                "        }   , " +
                " " +
                "        //调用出错执行的函数 " +
                "        error: function(){ " +
                "            //请求出错处理 " +
                "        } " +
                "    }); " +
                "       // console.log(e.index) " +
                "    }); " +
                "    dia.on(\"dialog:hide\",function(e){ " +
                "       // console.log(\"dialog hide\") " +
                "    }); " +
                "} " +
                "</script></section> " +
                "<script> " +
                "//底部异步登录 " +
                "function checkLoginfooter() " +
                "{ " +
                "$.ajax({ " +
                "      url: \"https://m.ubaike.cn/index.php?index/c_footer\", " +
                "      success:function(data) " +
                "      { " +
                "        if(data!=1) " +
                "        { " +
                "          $('#footer_ajax').html(data); " +
                "          load_message_sowenda(); " +
                "        } " +
                "      } " +
                "    });  " +
                "} " +
                "</script> " +
                "<div class=\"share-mask share-mask-show\"> " +
                "<div class=\"share-guide\"></div> " +
                "</div> " +
                "<script type=\"text/javascript\"> " +
                "var config = { " +
                "    url: window.location.href, " +
                "    title: \"广东彩艳股份有限公司\", " +
                "    desc: \"红盾查询提供广东彩艳股份有限公司工商注册信息查询\", " +
                "    img: \"\", " +
                "    img_title: \"广东彩艳股份有限公司\", " +
                "    from: \"红盾查询\" " +
                "}; " +
                "var share_obj = new nativeShare('nativeShare', config); " +
                " " +
                "var i = navigator.userAgent.toLowerCase(); " +
                "var app = { " +
                " " +
                "    device: { " +
                "        os: { " +
                "            version: 0, " +
                "            isiOS: i.indexOf(\"iphone\") > -1 || i.indexOf(\"ipad\") > -1 || i.indexOf(\"ios\") > -1, " +
                "            isAndroid: i.indexOf(\"android\") > -1 || i.indexOf(\"adr\") > -1 || i.indexOf(\"linux;\") > -1 " +
                "        }, " +
                "        browser: { " +
                "            version: 0, " +
                "            isQQ: i.indexOf(\"mqqbrowser/\") > -1, " +
                "            isQQAPP: i.indexOf(\"qq/\") > -1, " +
                "            isUC: i.indexOf(\"ucbrowser/\") > -1, " +
                "            isWechat: i.indexOf(\"micromessenger\") > -1, " +
                "            isSamsung: i.indexOf(\"samsungbrowser/\") > -1, " +
                "            isSogou: i.indexOf(\"sogoumobilebrowser/\") > -1, " +
                "            isPinganWifi: i.indexOf(\"pawifi\") > -1 " +
                "        } " +
                "    } " +
                "} " +
                " " +
                "var h = $(document).height(); " +
                "$(\".share-mask\").height(h); " +
                "$(\"#nativeShare\").click(function() { " +
                "    if (app.device.browser.isWechat || app.device.browser.isQQAPP) { " +
                "        //alert($(document).scrollTop()); " +
                "        $(\".share-guide\").css({ " +
                "            \"top\": $(document).scrollTop() + 10 " +
                "        }); " +
                "        $(\".share-slogan\").css({ " +
                "            \"top\": $(document).scrollTop() + 200 " +
                "        }); " +
                " " +
                "        $(\".share-mask\").css({ " +
                "            \"height\": $(document).height() " +
                "        }).show(); " +
                "    } " +
                "}); " +
                " " +
                " " +
                "if (!app.device.browser.isWechat && !app.device.browser.isQQ && !app.device.browser.isQQAPP && !app.device.browser.isUC) { " +
                "    $(\"#nativeShare\").hide(); " +
                "}else{ " +
                "$(\".show-tfoot\").hide(); " +
                "} " +
                "if (app.device.browser.isWechat || app.device.browser.isQQAPP) { " +
                "    $(\".nativeShare.weibo\").hide(); " +
                "} " +
                "//alert(app.device.browser.isWechat) " +
                "$(\".share-mask\").click(function() { " +
                "    $(this).hide(); " +
                "}); " +
                " " +
                "</script> " +
                " " +
                "<div class=\"cpfoot\">Copyright 2018 ubaike.cn</div> " +
                "</section> " +
                "<script src=\"https://cdn.ubaike.cn/static/css/fronze/js/main.js?v=8\" type=\"text/javascript\"></script> " +
                "<div id='footer_ajax'></div> " +
                "<div id=\"to_top\"></div> " +
                "<script> " +
                "$(document).ready(function(){   " +
                "    var p=0,t=0;   " +
                "    var oTop = document.getElementById(\"to_top\"); " +
                "    var screenw = document.documentElement.clientWidth || document.body.clientWidth; " +
                "    var screenh = document.documentElement.clientHeight || document.body.clientHeight; " +
                "    $(window).scroll(function(e){   " +
                "            p = $(this).scrollTop();   " +
                "            var scrolltop = document.documentElement.scrollTop || document.body.scrollTop; " +
                "            if(scrolltop<=screenh){ " +
                "             oTop.style.display=\"none\"; " +
                "            }else{ " +
                "             oTop.style.display=\"block\"; " +
                "            } " +
                "            if(t<=p){//下滚   " +
                "             if(scrolltop>50){ " +
                "               $(\".nav_top\").hide(); " +
                "             } " +
                "            }   " +
                "            else{//上滚   " +
                "             $(\".nav_top\").show(); " +
                "            }   " +
                "            setTimeout(function(){t = p;},0);          " +
                "    });   " +
                "    oTop.onclick = function(){ " +
                "        document.documentElement.scrollTop = document.body.scrollTop =0; " +
                "      } " +
                "});   " +
                "</script> " +
                "</body> " +
                "</html>");

    }
    private static List<Header> getDefaultHeader(){
        List<Header> headers = new ArrayList<>();
        headers.add(new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36"));
        headers.add(new BasicHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3"));
        headers.add(new BasicHeader("accept-encoding","gzip, deflate, br"));
        headers.add(new BasicHeader("accept-language","zh-CN,zh;q=0.9,en;q=0.8,ja;q=0.7,zh-TW;q=0.6,la;q=0.5"));
        headers.add(new BasicHeader(":authority","m.ubaike.cn"));
        headers.add(new BasicHeader(":path:","/show_20343794.html"));
        headers.add(new BasicHeader(":scheme","https"));
        headers.add(new BasicHeader("referer","https://m.ubaike.cn/list_1"));
        return headers;
    }

}
