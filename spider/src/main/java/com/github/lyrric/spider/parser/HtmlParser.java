package com.github.lyrric.spider.parser;

import com.github.lyrric.common.exception.ParseHtmlException;
import com.github.lyrric.common.model.CompanyInfoModel;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created on 2020-10-30.
 *
 * @author wangxiaodong
 */
@Slf4j
public class HtmlParser {

    /**
     * 解析html内容，返回实体
     * @param html
     * @return
     */
    public static CompanyInfoModel parseHtml(String html){
        try {
            Document doc = Jsoup.parse(html);
            return parseCompanyBasicInfo(doc);
        }catch (Exception e){
            log.error("解析html时发生异常", e);
            throw new ParseHtmlException("解析html时发生异常");
        }

    }

    private static CompanyInfoModel parseCompanyBasicInfo(Document doc){
        CompanyInfoModel companyInfoModel = new CompanyInfoModel();
        String companyName = doc.selectFirst("h1[class=title]").childNodes().get(0).attr("#text");
        companyInfoModel.setCompanyName(companyName);

        if(doc.toString().contains("class=\"hdtit\"")){
            //情况1 https://m.ubaike.cn/show_1188.html
            Element element = doc.selectFirst("div[class=article-content art-content]");
            List<Node> subNodes = element.childNodes();
            for (Node subNode : subNodes) {
                String key;
                String value = null;
                if(!subNode.toString().contains("class=\"hdtit\"")){
                    continue;
                }
                if(subNode instanceof Element){
                    key = subNode.childNode(0).childNode(0).attr("#text");
                    key = key.replace("：", "");
                    value = subNode.childNode(1).childNode(0).attr("#text");
                    setData(companyInfoModel, key, value);
                }
            }
        }else{
            Element element = doc.selectFirst("div[id=partners]");
            List<Node> subNodes = element.childNodes();
            for (int i = 0; i < subNodes.size(); i++) {
                String key;
                String value = null;
                Node node = subNodes.get(i);
                if(node instanceof Element){
                    final String classAttr = node.attr("class");
                    if(classAttr.contains("basic-item-left")){
                        //有时候描述和属性会出现并排，这里进行特殊处理
                        key = node.childNode(0).attr("#text");
                        for (int j = ++i; j < subNodes.size(); j++) {
                            node = subNodes.get(j);
                            if(node instanceof Element){
                                value = subNodes.get(j).childNode(0).attr("#text");
                                setData(companyInfoModel, key, value);
                                i=j;
                                break;
                            }
                        }
                    }else if(!classAttr.contains("basic-item-right")){
                        if(((Element) node).selectFirst("div[class=basic-item-left]") != null){
                            List<Node> tNodes = ((Element) node).selectFirst("div[class=basic-item-left]").childNodes();
                            if(!tNodes.isEmpty()){
                                key = tNodes.get(0).attributes().asList().get(0).getValue();
                                tNodes = ((Element) node).selectFirst("div[class=basic-item-right]").childNodes();
                                if(!tNodes.isEmpty()){
                                    value = tNodes.get(0).attributes().asList().get(0).getValue();
                                }
                                setData(companyInfoModel, key, value);
                            }
                        }
                    }
                }
            }
        }
        return companyInfoModel;
    }

    private static void setData(CompanyInfoModel companyInfoModel, String key, String value){
        switch (key){
            case "法定代表人":
            case "法人代表":
                companyInfoModel.setLegalRepresentative(value);break;
            case "注册号":
                companyInfoModel.setRegisterNumber(value);break;
            case "统一社会信用代码":
                companyInfoModel.setCreditCode(value);break;
            case "注册资本":
                //这里的注册资本是不准确的，需要调用接口重新获取
                //companyInfo.setRegisterAmount(value);
                break;
            case "成立日期":
                //无效数据判定
                if(value != null && !value.startsWith("0")){
                    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = null;
                    try {
                        date = format.parse(value);
                    } catch (ParseException e) {
                        log.error("尝试将字符串:{} 转换为Date类型时失败, company name is {}",value, companyInfoModel.getCompanyName());
                    }
                    companyInfoModel.setRegisterDate(date);break;
                }
            case "企业类型":
                companyInfoModel.setCompanyType(value);break;
            case "经营范围":
                companyInfoModel.setScopeOfBusiness(value);break;
            case "公司住所":
            case "注册地址":
            case "企业地址":
                companyInfoModel.setRegisterAddress(value);break;
            case "营业期限":
            case "经营期限":
                companyInfoModel.setTermOfBusiness(value);break;
            case "登记机关":
                companyInfoModel.setRegisterAgency(value);break;
            case "经营状态":
            case "企业状态":
                companyInfoModel.setStatus(value);break;
            default:
        }
    }
}
