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
        Element element = doc.selectFirst("div[id=partners]");
        CompanyInfoModel companyInfoModel = new CompanyInfoModel();
        List<Node> subNodes = element.childNodes();
        subNodes.forEach(node -> {
            if(node instanceof Element){
                String key ;
                String value;
                key = ((Element) node).selectFirst("div[class=basic-item-left]").childNode(0).attributes().asList().get(0).getValue();
                value = ((Element) node).selectFirst("div[class=basic-item-right]").childNode(0).attributes().asList().get(0).getValue();
                switch (key){
                    case "企业名称":
                        companyInfoModel.setCompanyName(value);break;
                    case "法定代表人":
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
                        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                        Date date = null;
                        try {
                            date = format.parse(value);
                        } catch (ParseException e) {
                            log.error("尝试将字符串:{} 转换为Date类型时失败, company name is {}",value, companyInfoModel.getCompanyName());
                        }
                        companyInfoModel.setRegisterDate(date);break;
                    case "企业类型":
                        companyInfoModel.setCompanyType(value);break;
                    case "经营范围":
                        companyInfoModel.setScopeOfBusiness(value);break;
                    case "注册地址":
                        companyInfoModel.setRegisterAddress(value);break;
                    case "营业期限":
                        companyInfoModel.setTermOfBusiness(value);break;
                    case "登记机关":
                        companyInfoModel.setRegisterAgency(value);break;
                    case "经营状态":
                        companyInfoModel.setStatus(value);break;
                    default:
                }
            }
        });
        return companyInfoModel;
    }

}
