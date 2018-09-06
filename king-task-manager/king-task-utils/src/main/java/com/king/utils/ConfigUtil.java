
package com.king.utils;

import org.apache.log4j.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * @author Administrator
 */
public class ConfigUtil {
    private static Logger logger = Logger.getLogger(ConfigUtil.class);

    private final static ConfigUtil INSTANCE = new ConfigUtil();

    // private static final String YLSERVERPROPERTIESFILE =
    // "YLserver.properties";

    public static ConfigUtil getInstance() {
        return INSTANCE;
    }

    public static final String TRUE = "true";
    public static final String IMAGESERVER_URL = "imageserver.url";
    public static final String MEMCACHE_SERVER = "memcache.server";
    public static final String SERVER_NAME_URL = "server.name.url";
    public static final String SERVER_NAME_URL_AUTO = "server.name.url.auto";
    public static final String SERVER_NAME_URL_HTTPS = "server.name.url.https";
    public static final String PAGE_CACHE_ENABLED = "page.cache.enabled";
    public static final String BANK_RATE = "bank.rate";
    public static final String FTPSERVER_URL = "ftp.server";

    //银行卡号密匙
    public static final String BANK_KEY = "1DF6BF44DACD4216B0B5A168";
    public static final String BANK_VAL = "1DF6BF16";

    private static final String IMAGESERVER_URL_MIN = "imageserver.url.min";
    private static final String ADMIN_SERVER_URL = "admin.server.url";

    private static final String SMS_SOFTWARESERIALNO = "sms.softwareserialno";
    private static final String SMS_KEY = "sms.key";
    private static final String SMS_PATH = "ssms.path";
    private static final String VOICE_SMS_SOFTWARESERIALNO = "voice.sms.softwareserialno";
    private static final String VOICE_SMS_KEY = "voice.sms.key";
    private static final String VOICE_SMS_URI = "voice.sms.uri";

    //
    private static final String PANAN_IP = "pingan.ip";
    private static final String PANAN_PORT = "pingan.port";
    private static final String PINGAN_SALE_SUCCESS = "pinan.sale.success";
    private static final String PINGAN_SUPERVISE_SUCCESS = "pinan.supervise.success";
    private static final String PINGAN_MACKEY = "pingan.mackey";
    private static final String TRAN_CODE = "tran.code";
    private static final String TRAN_SALE_CODE = "tran.sale.code";
    private static final String TRAN_SCOUNTER = "tran.scounter";
    private static final String TRAN_CODE_SIGN = "tran.code.sign";
    private static final String TRAN_CODE_CANCEL = "tran.code.cancel";
    private static final String TRAN_CODE_FUND_BUY = "tran.code.fund.buy";
    private static final String TRAN_CODE_VALI_CARD = "tran.code.vali.card";
    private static final String TRAN_CODE_FUND_REDEEM = "tran.code.fund.redeem";
    private static final String TRAN_CODE_RESCIND = "tran.code.rescind";
    private static final String DISTRIBUTOR_CODE = "distributor.code";
    private static final String TRAN_SESSIONID = "tran.sessionid";
    private static final String BANK_TELL_NO = "bank.tell.no";
    private static final String CODE_SIGN_ACTIVE = "code.sign.active";

    private static final String TRAN_CODE_MODIFY = "tran.code.modify";

    private static final String TRAN_CODE_CARD_MODIFY = "tran.code.card.modify";

    private static final String TRAN_CODE_FUND_CANCEL = "tran.code.fund.cancel";

    private static final String BK_CODE_BANKINFO_SEARCH = "code.bankinfo.search";

    private static final String BK_TRAN_CODE_FUND_CHANGE = "tran.code.fund.change";

    private static final String BK_TRAN_CODE_BONUS_TYPE_CHANGE = "tran.code.bonus.type.change";

    private static final String BK_TRAN_CODE_FUND_INFO_SEARCH = "tran.code.fund.info.search";

    private static final String BK_TRAN_CODE_FUND_HISTORY_SEARCH = "tran.code.fund.history.search";

    private static final String BK_TRAN_CODE_FUND_TA_INFO_SEARCH = "tran.code.fund.ta.info.search";
    private static final String BK_TRAN_CODE_ACCOUNT_INFO_SEARCH = "tran.code.account.info.search";
    private static final String BK_TRAN_CODE_FUND_CHANGE_SEARCH = "tran.code.fund.change.search";

    private static final String BK_TRAN_CODE_ACCOUNT_FUNDS_SEARCH = "tran.code.account.funds.search";

    private static final String BK_TRAN_CODE_FUND_RISK_TEST = "tran.code.fund.risk.test";

    private static final String BK_TRAN_CODE_FUND_RISK_SEARCH = "tran.code.fund.risk.search";

    private static final String BK_TRAN_CODE_FUND_TRANSFER_IN = "tran.code.fund.transfer.in";
    private static final String BK_TRAN_CODE_FUND_TRANSFER_OUT = "tran.code.fund.transfer.out";

    private static final String BK_TRAN_CODE_FUND_HISTORY_SEARCH_8779 = "tran.code.fund.history.search.8779";
    private static final String BK_TRAN_CODE_ACCOUNT_FUNDS_SEARCH_8780 = "tran.code.account.funds.search.8780";

    private static final String BK_TRAN_CODE_FUND_TRADING_SEARCH = "tran.code.fund.trading.search";
    private static final String BK_TRAN_CODE_ACCOUNT_HISTORY_FUNDS_SEARCH = "tran.code.account.history.funds.search";
    private static final String BK_TRAN_CODE_FUND_CHANGE_SEARCH_8783 = "tran.code.fund.change.search.8783";

    private static final String BK_TRAN_CODE_FUND_DAY_COMMISSION_SEARCH = "tran.code.fund.day.commission.search";
    private static final String BK_TRAN_CODE_AUTO_INVEST = "tran.code.auto.invest";
    private static final String BK_TRAN_CODE_AUTO_INVEST_CHANGE = "tran.code.auto.invest.change";
    private static final String PINGAN_FTPFILE_BASEPATH = "pingan.ftpfile.basepath";
    private static final String PINGAN_FTPFILE_CHBASEPATH = "pingan.ftpfile.chbasepath";
    private static final String PINGAN_FUNDINFO_FILEPATH = "pingan.fundinfo.filepath";
    private static final String PINGAN_FUNDLIMIT_FILEPATH = "pingan.fundlimit.filepath";
    private static final String PINGAN_FUNDNAV_FILEPATH = "pingan.fundnav.filepath";
    private static final String PINGAN_TAINFO_FILEPATH = "pingan.tainfo.filepath";
    private static final String PINGAN_ACCTCUST_FILEPATH = "pingan.acctcust.filepath";
    private static final String PINGAN_APPTRANS_FILEPATH = "pingan.apptrans.filepath";
    private static final String PINGAN_ACKTRANS_FILEPATH = "pingan.acktrans.filepath";
    private static final String PINGAN_BALFUND_FILEPATH = "pingan.balfund.filepath";
    private static final String PINGAN_DAYENDRECONCILIATION_FILEPATH = "pingan.dayendreconciliation.filepath";
    private static final String PINGAN_INVESTORPAYTRANSFER_FILEPATH = "pingan.investorpaytransfer.filepath";
    private static final String PINGAN_PAYTRANSFER_FILEPATH = "pingan.paytransfer.filepath";
    private static final String PINGAN_PAYTRANSFERRESULT_FILEPATH = "pingan.paytransferresult.filepath";
    private static final String PINGAN_CUSTMAINTENANCECOST_FILEPATH = "pingan.custmaintenancecost.filepath";
    private static final String PINGAN_PRERECONCILIATION_FILEPATH = "pingan.prereconciliation.filepath";
    private static final String PINGAN_BATCHDEDUCTIONRESULT_FILEPATH = "pingan.batchdeductionresult.filepath";

    private static final String PINGAN_REMOTE_SERVER_IP = "pingan.remote.server.ip";
    private static final String PINGAN_REMOTE_SERVER_NAME = "pingan.remote.server.name";
    private static final String PINGAN_REMOTE_SERVER_PASSWORD = "pingan.remote.server.password";
    private static final String PINGAN_REMOTE_SERVER_PATH = "pingan.remote.server.path";

    private static final String PINGAN_COMBINATION_FILEPATH = "pingan.combination.filepath";
    private static final String DES_KEY = "des.key";
    private static final String DES_IV = "des.iv";
    private static final String BK_TRAN_ACCOUNT_CARD_ENCRYPT = "bk.tran.account.card.encrypt";

    private static final String BK_TRAN_VALI_CARD_STATUS_SEARCH = "bk.tran.vali.card.status.search";

    private static final String BK_TRAN_QUICK_TRANSFER = "bk.tran.quick.transfer";

    private static final String JUHE_BANK_APPKEY = "juhe.bank.appkey";

    private static final String DAOQIBAO_UNIT_NET = "daoqibao.unitnet";
    private static final String DAOQIBAO_ACCUM_NET = "daoqibao.accumnet";


    // 超级网银异常交易时发送预警邮件
    private static final String warnEmail = "superbank.warnEmail";

    public static String getWarnEmail() {
        return getProperties().getProperty(warnEmail);
    }

    // 基金开户银联通道相关参数
    private static final String posturl = "unionpay.posturl";
    private static final String returnurl = "unionpay.returnurl";
    private static final String masterid = "unionpay.masterid";
    private static final String thirdCustId = "unionpay.thirdCustId";
    private static final String idType = "unionpay.idType";
    private static final String remark = "unionpay.remark";
    private static final String type = "unionpay.type";


    public static String getPosturl() {
        return getProperties().getProperty(posturl);
    }

    public static String getReturnurl() {
        return getProperties().getProperty(returnurl);
    }

    public static String getMasterid() {
        return getProperties().getProperty(masterid);
    }

    public static String getThirdCustId() {
        return getProperties().getProperty(thirdCustId);
    }

    public static String getIdType() {
        return getProperties().getProperty(idType);
    }

    public static String getRemark() {
        return getProperties().getProperty(remark);
    }

    public static String getType() {
        return getProperties().getProperty(type);
    }


    public static final String LXHL_DOWNLINK = "lxhl.sms.path";
    public static final String LXHL_CORP = "lxhl.sms.corpID";
    public static final String LXHL_PWD = "lxhl.sms.pswd";

    public static final String backpath = "wxxq.data.back";
    public static final String incomepath = "wxxq.data.incomepath";
    public static final String chargepath = "wxxq.data.charge";
    public static final String withdrawpath = "wxxq.data.withdraw";

    private static final String InsuranceChunYan = "insurance.chunyan.login";
    private static final String InsurancePid = "insurance.partnerid";

    private static final String InsuranceQiXinPid = "insurance.qixin.partnerid";
    private static final String InsuranceQiXinKey = "insurance.qixin.key";
    private static final String QiXinInsureUrl = "insurance.qixin.insure.url";
    private static final String QiXinDefaultTrialUrl = "insurance.qixin.defaultTrial.url";
    private static final String QiXinOnlinePayUrl = "insurance.qixin.onlinePay.url";
    private static final String QiXinSurrenderPolicyUrl = "insurance.qixin.surrenderPolicy.url";
    private static final String QiXinHealthNotifyQuesUrl = "insurance.qixin.healthStatement.url";
    private static final String QiXinSubmitHealthStateUrl = "insurance.qixin.submitHealthState.url";

    private static final String QiXinPropertyAddressUrl = "insurance.qixin.propertyAddress.url";
    private static final String QiXinProductDestinationUrl = "insurance.qixin.productDestination.url";
    private static final String QiXinInsuranceproductDetailsUrl = "insurance.qixin.productDetail.url";

    private static final String QiXinProductAreaUrl = "insurance.qixin.productInsuredArea.url";
    private static final String QiXinProductInsuredAttr = "insurance.qixin.productInsuredAttr.url";
    private static final String QiXinProductInsuredJob = "insurance.qixin.productInsuredJob.url";

    private static final String QiXinInsuranceOrderCancelUrl = "insurance.qixin.surrenderPolicy.url";
    private static final String QiXinProductPropertyAreaUrl = "insurance.qixin.propertyAddress.url";
    private static final String QinXinOrderTrialUrl = "insurance.qixin.orderTrial.url";
    private static final String QiXinInsuranceDownloadUrl = "insurance.qixin.downloadUrl.url";

    private static final String QiXinInsuranceCallBackUrl = "insurance.qixin.callbackurl";


    private static final String InsurancePath = "insurance.filepath";
    private static final String InsuranceWebPath = "insurance.webpath";
    private static final String InsuranceKey = "insurance.key";
    private static final String OrderApplyUrl = "insurance.orderaplly.url";
    private static final String HealthSubmoitUrl = "insurance.healthsubmit.url";
    private static final String HealthSubmoitV1Url = "insurance.healthsubmit.v1.url";
    private static final String OrderApplyV1Url = "insurance.orderaplly.v1.url";
    private static final String OrderCancel = "insurance.ordercancel.url";
    private static final String ProductPay = "insurance.productPay.url";
    private static final String OrderCancelV1 = "insurance.ordercancel.v1.url";
    private static final String orderDownLoad = "insurance.orderdownloan.url";
    private static final String orderDownLoadV1 = "insurance.orderdownloan.v1.url";
    private static final String productArea = "insurance.productarea.url";
    private static final String productPropertyArea = "insurance.productPropertyArea.url";
    private static final String productproductDetails = "insurance.productDetails.url";


    private static final String productDestination = "insurance.productdestination.url";
    private static final String productDestinations = "insurance.productDestinations.url";
    private static final String DefaultTrial = "insurance.defaulttrial.url";
    private static final String OrdertTrial = "insurance.orderttrial.url";
    private static final String NoticeUrl = "insurance.noticeUrl.url";
    private static final String HealthNotifyQuesUrl = "insurance.healthnotifyques.url";
    private static final String GetProductJobUrl = "insurance.getproductjob.url";
    private static final String YLMF_KEY = "ylmf.key";
    private static final String YLMF_URl = "ylmf.url";

    public static String getNotifyUrl() {
        return getProperties().getProperty(notify_url);
    }

    public static String getReturnUrl() {
        return getProperties().getProperty(return_url);
    }

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static final String notify_url = "insurance.alipay.notify.url";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static final String return_url = "insurance.alipay.return.url";

    public String getbackpath() {
        return getProperties().getProperty(backpath);
    }

    public String getincomepath() {
        return getProperties().getProperty(incomepath);
    }

    public String getchargepath() {
        return getProperties().getProperty(chargepath);
    }

    public String getwithdrawpath() {
        return getProperties().getProperty(withdrawpath);
    }


    public static String getJuheBankAppkey() {
        return getProperties().getProperty(JUHE_BANK_APPKEY);
    }

    /**
     * 基金经理离职时发送邮件收件人名单
     */
    private static final String FUND_MANAGER_QUIT_RECEIVERS = "fund_manager_quit_receivers";
    /**
     * 网站注册异常时发送邮件收件人名单
     */
    private static final String WEB_REG_EXCEPTION_RECEIVERS = "web_reg_exception_receivers";
    /**
     * 邮件发送测试名单
     */
    private static final String EMAIL_TEST_RECEIVERS = "email_test_receivers";
    /**
     * p2p两天后到期邮件收件人名单
     */
    private static final String P2P_EXPIRE_AFTER_TWO_DAYS_RECEIVERS = "p2p_expire_after_two_days_receivers";
    /**
     * 发送者
     */
    private static final String SYSTEM_MAIL_SENDER = "system.mail.sender";
    /**
     * 密码
     */
    private static final String SYSTEM_MAIL_PASSWORD = "system.mail.password";
    /**
     * 显示名称
     */
    private static final String SYSTEM_MAIL_SIGNNAME = "system.mail.signname";
    /**
     * 代发地址
     */
    private static final String SYSTEM_MAIL_ADDRESS = "system.mail.address";
    /**
     * host
     */
    private static final String SYSTEM_MAIL_SMTP_HOST = "system.mail.smtp.host";
    /**
     * 安全是否验证
     */
    private static final String SYSTEM_MAIL_SMTP_AUTH = "system.mail.smtp.auth";

    private static final String PINGAN_API_ENCRYPTION_LIST = "pingan.api.encryption.list";
    /**
     * 平安签约成功返回码
     */
    private static final String PINGAN_SIGN_SUCCESS_CODE = "pingan.sign.success.code";

    /**
     * 活动基金代码
     */
    private static final String EVENTS_2014_FUNDCODE = "events.2014.fundcode";
    /**
     * 每日发码数
     */
    private static final String EVENTS_2014_EVERYDAY_SENDCODE_COUNT = "events.2014.everyday.sendcode.count";
    /**
     * 官方发码用户id
     */
    private static final String EVENTS_2014_SENDUID = "events.2014.senduid";

    private static final String EVENTS_2014_MAX_MONEY = "events.2014.max.money";
    private static final String HTTPS_SERVER_URL = "https.server.url";
    private static final String VERSION = "version";

    private static final String LL_OID_PARTNER = "ll.oid.partner";
    private static final String LL_MD5_KEY = "ll.md5.key";
    private static final String LL_URL_RETURN = "ll.url.return";
    private static final String LL_URL_RETURN_API = "ll.url.return.api";

    private static final String LL_DAOQIBAO_NOTIFY_URL = "ll.daoqibao.notify.url";
    private static final String LL_DAOQIBAO_URL_RETURN_API = "ll.daoqibao.url.return.api";
    private static final String LL_OPENTHIRD_DAOQIBAO_NOTIFY_URL = "ll.openthird.daoqibao.notify.url";
    private static final String LL_OPENTHIRD_DAOQIBAO_URL_RETURN_API = "ll.openthird.daoqibao.url.return.api";
    private static final String LL_URL_RETURN_ICAIFUGOODS = "ll.url.return.icaifuGoods";
    private static final String LL_URL_RETURN_RELIBAO = "ll.url.return.relibao";

    private static final String LL_NOTIFY_URL_RELIBAO = "ll.notify.url.relibao";

    private static final String LL_NOTIFY_URL = "ll.notify.url";
    private static final String LL_NOTIFY_URL_ICAIFUGOODS = "ll.notify.url.icaifuGoods";

    private static final String LL_NOTIFY_URL_YINGPAY = "ll.notify.url.yingpay";
    private static final String LL_URL_RETURN_YINGPAY = "ll.url.return.yingpay";

    private static final String LL_NOTIFY_URL_API2_YINGPAY = "ll.notify.url.api2.yingpay";
    private static final String LL_URL_RETURN_API2_YINGPAY = "ll.url.return.api2.yingpay";

    private static final String LL_RETURN_LINE_URL = "ll.return.line.url";

    private static final String LL_RETURN_WT_URL = "ll.return.wt.url";

    private static final String CHINAPAYAPP_SYS_ID = "chinapay.app.sys.id";
    private static final String CHINAPAYMERID = "chinapay.merid";
    private static final String CHINAPAYKEY = "chinapay.paykey";

    private static final String FUYOU_MCHNT_CD = "fuyou.mchntcd";
    private static final String FUYOU_PRI_KEY = "fuyou.prikey";
    private static final String FUYOU_PUBLICKEY = "fuyou.publicKey";
    private static final String FUYOU_MCHNT_KEY = "fuyou.mchntKey";
    private static final String FUYOU_FUKUAN_MCHNT_KEY = "fuyou.fukuanmchntKey";

    private static final String WEIXINAPPID = "weixin.app.id";
    private static final String WEIXINSECRET = "weixin.app.secret";


    private static final String BK_TRAN_QUICK_PAY = "tran.code.quick.pay";

    private static final String BK_TRAN_VALICARD_COUNT_RESET = "tran.valicard.count.reset";

    private static final String IOSMASTERSECRET = "iosMasterSecret";
    private static final String IOSAPPKEY = "iosAppKey";
    private static final String ANDROIDMASTERSECRET = "androidMasterSecret";
    private static final String ANDROIDAPPKEY = "androidAppKey";

    private static final String FUNDPAY_FUNDCODE = "fundpay.fundcode";// 货基过户基金
    // 000730
    private static final String FUNDPAY_TARGETBRANCHCODE = "fundpay.targetbranchcode";// 博时网点号：205
    private static final String FUNDPAY_TARGETDISTRIBUTORCODE = "fundpay.targetdistributorcode";// 205
    private static final String FUNDPAY_TARGETTRANSACTIONACCOUNTID = "fundpay.targettransactionaccountid";// 一路财富交易帐号
    // 006562903
    private static final String FUNDPAY_TARGETTAACCOUNTID = "fundpay.targettaaccountid";// 056000203376
    // TA帐号

    // 基金购买的时间间隔，超过这个时间购买时重复记录数据
    private static final String BUYFUND_LIMITMINUTES = "buyfund_limitminutes";


    private static final String FTP_SERVER = "ftp.server";
    private static final String FTP_PORT = "ftp.port";
    private static final String FTP_USERNAME = "ftp.username";
    private static final String FTP_PASSWORD = "ftp.password";

    private static List<String> pinganApiList = new ArrayList<String>();

    public String getImageserver_url_min() {
        return getProperties().getProperty(IMAGESERVER_URL_MIN);
    }

    //富友
    public static String getFuyoumchntcd() {
        return getProperties().getProperty(FUYOU_MCHNT_CD);
    }

    public static String getFuyouprikey() {
        return getProperties().getProperty(FUYOU_PRI_KEY);
    }

    public static String getFuyoupublickey() {
        return getProperties().getProperty(FUYOU_PUBLICKEY);
    }

    public static String getFuyoumchntkey() {
        return getProperties().getProperty(FUYOU_MCHNT_KEY);
    }

    public static String getFuyoufukuanmchntkey() {
        return getProperties().getProperty(FUYOU_FUKUAN_MCHNT_KEY);
    }

    /**
     * FTP地址
     *
     * @return
     */
    public String getFtp_server_url() {
        return getProperties().getProperty(FTPSERVER_URL);
    }

    /**
     * @return the imageserver_url
     */
    public String getImageserver_url() {
        return getProperties().getProperty(IMAGESERVER_URL);
    }

    public static String getPageCahceStatus() {
        return getProperties().getProperty(PAGE_CACHE_ENABLED);
    }


    /**
     * @return the memcache_server
     */
    public String getMemcache_server(String defaultValue) {
        return getProperties().getProperty(MEMCACHE_SERVER);
    }

    /**
     * @return the server_name_url
     */
    public String getServer_name_url() {
        return getProperties().getProperty(SERVER_NAME_URL);
    }

    public String getServer_name_url_auto() {
        return getProperties().getProperty(SERVER_NAME_URL_AUTO);
    }

    public String getServer_name_url_https() {
        return getProperties().getProperty(SERVER_NAME_URL_HTTPS);
    }


    /**
     * @return the bank_rate
     */
    public String getBank_rate() {
        return getProperties().getProperty(BANK_RATE);
    }

    /**
     * 获得基金经理离职时发送邮件收件人邮箱
     *
     * @return
     */
    public static String getReceiversEmail() {
        return getProperties().getProperty(PANAN_IP);
    }

    /**
     * 获得平安接口ip地址
     *
     * @return
     */
    public static String getPinganIp() {
        return getProperties().getProperty(PANAN_IP);
    }

    /**
     * 获得平安接口端口号
     *
     * @return
     */
    public static int getPinganPort() {
        int port = 0;
        try {
            port = Integer.parseInt(getProperties().getProperty(PANAN_PORT));
        } catch (NumberFormatException e) {
            logger.fatal("平安接口端口转换错误： ", e);
        }
        return port;
    }

    /**
     * 平安销售系统报文成功返回代码
     *
     * @return
     */

    public static String getPinganSaleSuccess() {
        return getProperties().getProperty(PINGAN_SALE_SUCCESS);
    }

    /**
     * 监督端成功代码标示
     *
     * @return
     */
    public static String getPinganSuperviseSuccess() {
        return getProperties().getProperty(PINGAN_SUPERVISE_SUCCESS);
    }

    /**
     * 平安销售系统报文头中交易码
     *
     * @return
     */
    public static String getTranCode() {
        return getProperties().getProperty(TRAN_CODE);
    }

    /**
     * 销售商代码
     *
     * @return
     */
    public static String getTranSaleCode() {
        return getProperties().getProperty(TRAN_SALE_CODE);
    }

    /**
     * 销售系统交易柜员
     *
     * @return
     */
    public static String getTranScounter() {
        return getProperties().getProperty(TRAN_SCOUNTER);
    }

    /**
     * 客户签约交易码
     *
     * @return
     */
    public static String getTranCodeSign() {
        return getProperties().getProperty(TRAN_CODE_SIGN);
    }

    /**
     * 客户解约交易码
     *
     * @return
     */
    public static String getTranCodeRescind() {
        return getProperties().getProperty(TRAN_CODE_RESCIND);
    }

    /**
     * 基金买入交易码
     *
     * @return
     */
    public static String getTranCodeFundBuy() {
        return getProperties().getProperty(TRAN_CODE_FUND_BUY);
    }

    /**
     * 基金赎回交易码
     *
     * @return
     */
    public static String getTranCodeFundRedeem() {
        return getProperties().getProperty(TRAN_CODE_FUND_REDEEM);
    }

    /**
     * 验卡交易码
     *
     * @return
     */
    public static String getTranCodeValiCard() {
        return getProperties().getProperty(TRAN_CODE_VALI_CARD);
    }

    /**
     * 经销商代码
     *
     * @return
     */
    public static String getDistributorCode() {
        return getProperties().getProperty(DISTRIBUTOR_CODE);
    }

    /**
     * 获得回话id
     *
     * @return
     */
    public static String getTranSessionid() {
        return getProperties().getProperty(TRAN_SESSIONID);
    }

    /**
     * 获得 柜员号
     *
     * @return
     */
    public static String getBankTellNo() {
        return getProperties().getProperty(BANK_TELL_NO);
    }

    /**
     * 账户销号
     *
     * @return
     */
    public static String getTranCodeCancel() {
        return getProperties().getProperty(TRAN_CODE_CANCEL);
    }

    /**
     * 在线签约账号激活
     *
     * @return
     */
    public static String getCodeSignActive() {
        return getProperties().getProperty(CODE_SIGN_ACTIVE);
    }

    public static String getTranCodeModify() {
        return getProperties().getProperty(TRAN_CODE_MODIFY);
    }

    /**
     * 修改银行卡代码
     *
     * @return
     */
    public static String getTranCodeCardModify() {
        return getProperties().getProperty(TRAN_CODE_CARD_MODIFY);
    }

    /**
     * 基金撤销交易码
     *
     * @return
     */
    public static String getTranCodeFundCancel() {
        return getProperties().getProperty(TRAN_CODE_FUND_CANCEL);
    }

    /**
     * 联网行号查询
     */
    public static String getCodeBankinfoSearch() {
        return getProperties().getProperty(BK_CODE_BANKINFO_SEARCH);
    }

    /**
     * 基金转换代码
     *
     * @return
     */
    public static String getCodeFundChange() {
        return getProperties().getProperty(BK_TRAN_CODE_FUND_CHANGE);
    }

    /**
     * 分红方式变更
     *
     * @return
     */

    public static String getCodeBonusTypeChange() {
        return getProperties().getProperty(BK_TRAN_CODE_BONUS_TYPE_CHANGE);
    }

    /**
     * 基金信息查询
     *
     * @return
     */

    public static String getTranCodeFundInfoSearch() {
        return getProperties().getProperty(BK_TRAN_CODE_FUND_INFO_SEARCH);
    }

    /**
     * 历史交易查询（ 8584）
     *
     * @return
     */
    public static String getTranCodeFundHistorySearch() {
        return getProperties().getProperty(BK_TRAN_CODE_FUND_HISTORY_SEARCH);
    }

    /**
     * TA账户信息查询（8586）
     *
     * @return
     */
    public static String getTranCodeFundTaInfoSearch() {
        return getProperties().getProperty(BK_TRAN_CODE_FUND_TA_INFO_SEARCH);
    }

    /**
     * 客户信息查询（ 8587）
     *
     * @return
     */
    public static String getTranCodeAccountInfoSearch() {
        return getProperties().getProperty(BK_TRAN_CODE_ACCOUNT_INFO_SEARCH);
    }

    /**
     * 基金转换查询（ 8599）
     *
     * @return
     */
    public static String getTranCodeFundChangeSearch() {
        return getProperties().getProperty(BK_TRAN_CODE_FUND_CHANGE_SEARCH);
    }

    /**
     * 基金份额市值查询（ 8581 ）//某个客户拥有的基金的详情
     *
     * @return
     */
    public static String getCodeAccountFundSearch() {
        return getProperties().getProperty(BK_TRAN_CODE_ACCOUNT_FUNDS_SEARCH);
    }

    public static String getSmsSoftwareserialno() {
        return getProperties().getProperty(SMS_SOFTWARESERIALNO);
    }

    public static String getSmsKey() {
        return getProperties().getProperty(SMS_KEY);
    }

    /**
     * 客户风险等级评估信息插入或更新
     *
     * @return
     */
    public static String getTranCodeRiskTest() {
        return getProperties().getProperty(BK_TRAN_CODE_FUND_RISK_TEST);
    }

    /**
     * 客户风险等级查询
     *
     * @return
     */

    public static String getTranCodeRiskSearch() {
        return getProperties().getProperty(BK_TRAN_CODE_FUND_RISK_SEARCH);
    }

    /**
     * 当日委托交易查询
     *
     * @return
     */

    public static String getTranCodeFundDayCommissionSearch() {
        return getProperties().getProperty(
                BK_TRAN_CODE_FUND_DAY_COMMISSION_SEARCH);
    }

    /**
     * 获得平安Fundinfo文件地址
     *
     * @return
     */
    public static String getPinganFundinfoFilepath() {
        return getPinganFtpfileBasepath()
                + getProperties().getProperty(PINGAN_FUNDINFO_FILEPATH);
    }

    /**
     * 获得AcctCust（客户文件）文件地址
     *
     * @return
     */
    public static String getAcctCustFilepath() {
        return getPinganFtpfileBasepath()
                + getProperties().getProperty(PINGAN_ACCTCUST_FILEPATH);
    }

    /**
     * 获得AppTrans文件地址
     *
     * @return
     */
    public static String getAppTransFilepath() {
        return getPinganFtpfileBasepath()
                + getProperties().getProperty(PINGAN_APPTRANS_FILEPATH);
    }

    /**
     * 获得AckTrans文件地址
     *
     * @return
     */
    public static String getAckTransFilepath() {
        return getPinganFtpfileBasepath()
                + getProperties().getProperty(PINGAN_ACKTRANS_FILEPATH);
    }

    /**
     * 获得BalFund文件地址
     *
     * @return
     */
    public static String getBalFundFilepath() {
        return getPinganFtpfileBasepath()
                + getProperties().getProperty(PINGAN_BALFUND_FILEPATH);
    }

    /**
     * 获得DayEndReconciliation文件地址
     *
     * @return
     */
    public static String getDayEndReconciliationFilepath() {
        return getPinganFtpfileBasepath()
                + getProperties().getProperty(
                PINGAN_DAYENDRECONCILIATION_FILEPATH);
    }

    /**
     * 获得InvestorPayTransfer文件地址
     *
     * @return
     */
    public static String getInvestorPayTransferFilepath() {
        return getPinganFtpfileBasepath()
                + getProperties().getProperty(
                PINGAN_INVESTORPAYTRANSFER_FILEPATH);
    }

    /**
     * 获得PayTransfer文件地址
     *
     * @return
     */
    public static String getPayTransferFilepath() {
        return getPinganFtpfileBasepath()
                + getProperties().getProperty(PINGAN_PAYTRANSFER_FILEPATH);
    }

    /**
     * 获得PayTransferResult文件地址
     *
     * @return
     */
    public static String getPayTransferResultFilepath() {
        return getPinganFtpfileBasepath()
                + getProperties()
                .getProperty(PINGAN_PAYTRANSFERRESULT_FILEPATH);
    }

    /**
     * 获得CustMaintenanceCost文件地址
     *
     * @return
     */
    public static String getCustMaintenanceCostFilepath() {
        return getPinganFtpfileBasepath()
                + getProperties().getProperty(
                PINGAN_CUSTMAINTENANCECOST_FILEPATH);
    }

    /**
     * 获得PreReconciliation文件地址
     *
     * @return
     */
    public static String getPreReconciliationFilepath() {
        return getPinganFtpfileBasepath()
                + getProperties()
                .getProperty(PINGAN_PRERECONCILIATION_FILEPATH);
    }

    /**
     * 获得BatchDeductionResult文件地址
     *
     * @return
     */
    public static String getBatchDeductionResultFilepath() {
        return getPinganFtpfileBasepath()
                + getProperties().getProperty(
                PINGAN_BATCHDEDUCTIONRESULT_FILEPATH);
    }

    /**
     * 获得平安Fundlimit文件地址
     *
     * @return
     */
    public static String getPinganFundlimitFilepath() {
        return getPinganFtpfileBasepath()
                + getProperties().getProperty(PINGAN_FUNDLIMIT_FILEPATH);
    }

    /**
     * 获得平安Fundnav文件地址
     *
     * @return
     */
    public static String getPinganFundnavFilepath() {
        return getPinganFtpfileBasepath()
                + getProperties().getProperty(PINGAN_FUNDNAV_FILEPATH);
    }

    /**
     * 获得平安组合文件地址
     *
     * @return
     */
    public static String getPinganCombinationFilepath() {
        return getPinganFtpfileBasepath()
                + getProperties().getProperty(PINGAN_COMBINATION_FILEPATH);
    }

    /**
     * 获得平安Tainfo文件地址
     *
     * @return
     */
    public static String getPinganTainfoFilepath() {
        return getPinganFtpfileBasepath()
                + getProperties().getProperty(PINGAN_TAINFO_FILEPATH);
    }

    /**
     * 获得AcctCust（客户文件）文件名称
     *
     * @return
     */
    public static String getAcctCustFileName() {
        return getProperties().getProperty(PINGAN_ACCTCUST_FILEPATH);
    }

    /**
     * 获得AppTrans文件名称
     *
     * @return
     */
    public static String getAppTransFileName() {
        return getProperties().getProperty(PINGAN_APPTRANS_FILEPATH);
    }

    /**
     * 获得AckTrans文件名称
     *
     * @return
     */
    public static String getAckTransFileName() {
        return getProperties().getProperty(PINGAN_ACKTRANS_FILEPATH);
    }

    /**
     * 获得BalFund文件名称
     *
     * @return
     */
    public static String getBalFundFileName() {
        return getProperties().getProperty(PINGAN_BALFUND_FILEPATH);
    }

    /**
     * 获得DayEndReconciliation文件名称
     *
     * @return
     */
    public static String getDayEndReconciliationFileName() {
        return getProperties()
                .getProperty(PINGAN_DAYENDRECONCILIATION_FILEPATH);
    }

    /**
     * 获得InvestorPayTransfer文件名称
     *
     * @return
     */
    public static String getInvestorPayTransferFileName() {
        return getProperties().getProperty(PINGAN_INVESTORPAYTRANSFER_FILEPATH);
    }

    /**
     * 获得PayTransfer文件名称
     *
     * @return
     */
    public static String getPayTransferFileName() {
        return getProperties().getProperty(PINGAN_PAYTRANSFER_FILEPATH);
    }

    /**
     * 获得PayTransferResult文件名称
     *
     * @return
     */
    public static String getPayTransferResultFileName() {
        return getProperties().getProperty(PINGAN_PAYTRANSFERRESULT_FILEPATH);
    }

    /**
     * 获得CustMaintenanceCost文件名称
     *
     * @return
     */
    public static String getCustMaintenanceCostFileName() {
        return getProperties().getProperty(PINGAN_CUSTMAINTENANCECOST_FILEPATH);
    }

    /**
     * 获得PreReconciliation文件名称
     *
     * @return
     */
    public static String getPreReconciliationFileName() {
        return getProperties().getProperty(PINGAN_PRERECONCILIATION_FILEPATH);
    }

    /**
     * 获得BatchDeductionResult文件名称
     *
     * @return
     */
    public static String getBatchDeductionResultFileName() {
        return getProperties()
                .getProperty(PINGAN_BATCHDEDUCTIONRESULT_FILEPATH);
    }

    /**
     * 获得远程服务器IP
     *
     * @return
     */
    public static String getConnectIp() {
        return getProperties().getProperty(PINGAN_REMOTE_SERVER_IP);
    }

    /**
     * 获得连接服务器的用户的姓名
     *
     * @return
     */
    public static String getConnectName() {
        return getProperties().getProperty(PINGAN_REMOTE_SERVER_NAME);
    }

    /**
     * 获得连接服务器的用户的密码
     *
     * @return
     */
    public static String getConnectPassword() {
        return getProperties().getProperty(PINGAN_REMOTE_SERVER_PASSWORD);
    }

    /**
     * 获得远程服务器的读取文件的路径
     *
     * @return
     */
    public static String getConnectPath() {
        return getProperties().getProperty(PINGAN_REMOTE_SERVER_PATH);
    }

    /**
     * 获得ftp文件跟路径
     *
     * @return
     */
    public static String getPinganFtpfileBasepath() {
        return getProperties().getProperty(PINGAN_FTPFILE_BASEPATH);
    }

    /**
     * 获得渠道ftp文件跟路径
     *
     * @return
     */
    public static String getChPinganFtpfileBasepath() {
        return getProperties().getProperty(PINGAN_FTPFILE_CHBASEPATH);
    }

    /**
     * 转托管转入
     *
     * @return
     */
    public static String getTranCodeFundTransferIn() {
        return getProperties().getProperty(BK_TRAN_CODE_FUND_TRANSFER_IN);
    }

    /**
     * 转托管转出
     *
     * @return
     */
    public static String getTranCodeFundTransferOut() {
        return getProperties().getProperty(BK_TRAN_CODE_FUND_TRANSFER_OUT);
    }

    public static String getServerNameUrl() {
        return getProperties().getProperty(SERVER_NAME_URL);
    }

    public static String getFundManagerQuitReceivers() {
        return getProperties().getProperty(FUND_MANAGER_QUIT_RECEIVERS);
    }

    public static String getWebRegExceptionReceivers() {
        return getProperties().getProperty(WEB_REG_EXCEPTION_RECEIVERS);
    }

    public static String getEmailTestReceivers() {
        return getProperties().getProperty(EMAIL_TEST_RECEIVERS);
    }

    public static String getP2pExpireAfterTwoDaysReceivers() {
        return getProperties().getProperty(P2P_EXPIRE_AFTER_TWO_DAYS_RECEIVERS);
    }

    /**
     * 发送者
     *
     * @return
     */
    public static String getSystemMailSender() {
        return getProperties().getProperty(SYSTEM_MAIL_SENDER);
    }

    /**
     * 密码
     *
     * @return
     */
    public static String getSystemMailPassword() {
        return getProperties().getProperty(SYSTEM_MAIL_PASSWORD);
    }

    /**
     * 显示名称
     *
     * @return
     */
    public static String getSystemMailSignname() {
        return getProperties().getProperty(SYSTEM_MAIL_SIGNNAME);
    }

    /**
     * 代发地址
     *
     * @return
     */
    public static String getSystemMailAddress() {
        return getProperties().getProperty(SYSTEM_MAIL_ADDRESS);
    }

    /**
     * host
     *
     * @return
     */
    public static String getSystemMailSmtpHost() {
        return getProperties().getProperty(SYSTEM_MAIL_SMTP_HOST);
    }

    /**
     * * 安全是否验证
     *
     * @return
     */
    public static String getSystemMailSmtpAuth() {
        return getProperties().getProperty(SYSTEM_MAIL_SMTP_AUTH);
    }

    /**
     * 获得平安mac加密key
     *
     * @return
     */
    public static String getPinganMackey() {
        return getProperties().getProperty(PINGAN_MACKEY);
    }

    /**
     * 获得平安徐加密列表
     *
     * @return
     */
    public static List<String> getPinganApiList() {
        if (pinganApiList.size() == 0) {
            String pinganApiListStr = getProperties().getProperty(
                    PINGAN_API_ENCRYPTION_LIST);
            if (!StringUtil.isEmpty(pinganApiListStr)) {
                String[] apiList = pinganApiListStr.split(",");
                pinganApiList = Arrays.asList(apiList);
            }
        }
        return pinganApiList;
    }

    public static String getPinganSignSuccessCode() {
        return getProperties().getProperty(PINGAN_SIGN_SUCCESS_CODE);
    }

    /**
     * 获得端加密key
     *
     * @return
     */
    public static String getDESKey() {
        return getProperties().getProperty(DES_KEY);
    }

    public static String getDESIv() {
        return getProperties().getProperty(DES_IV);
    }

    /**
     * @return the admin_server_url
     */
    public String getAdmin_server_url() {
        return getProperties().getProperty(ADMIN_SERVER_URL);
    }

    public static String getCodeAutoInvest() {
        return getProperties().getProperty(BK_TRAN_CODE_AUTO_INVEST);
    }

    public static String getCodeAutoInvestChange() {
        return getProperties().getProperty(BK_TRAN_CODE_AUTO_INVEST_CHANGE);
    }

    public static String getEvents_2014_Fundcode() {
        return getProperties().getProperty(EVENTS_2014_FUNDCODE);
    }

    public static String getCodeFundHistorySearch8779() {
        return getProperties().getProperty(
                BK_TRAN_CODE_FUND_HISTORY_SEARCH_8779);
    }

    public static String getCodeAccountFundsSearch8780() {
        return getProperties().getProperty(
                BK_TRAN_CODE_ACCOUNT_FUNDS_SEARCH_8780);
    }

    public static String getCodeFundTradingSearch() {
        return getProperties().getProperty(BK_TRAN_CODE_FUND_TRADING_SEARCH);
    }

    public static String getCodeAccountHistoryFundsSearch() {
        return getProperties().getProperty(
                BK_TRAN_CODE_ACCOUNT_HISTORY_FUNDS_SEARCH);
    }

    public static String getCodeFundChangeSearch8783() {
        return getProperties()
                .getProperty(BK_TRAN_CODE_FUND_CHANGE_SEARCH_8783);
    }

    /**
     * 每日发码数
     *
     * @return
     */
    public static String getEvents_2014_Everyday_Eendcode_Count() {
        return getProperties().getProperty(EVENTS_2014_EVERYDAY_SENDCODE_COUNT);
    }

    /**
     * 发码者
     *
     * @return
     */
    public static String getEvents_014_Senduid() {
        return getProperties().getProperty(EVENTS_2014_SENDUID);
    }

    /**
     * @return
     */
    public static String getEvents_2014_Everyday_Sendcode_Start_Hour() {
        return getProperties().getProperty(EVENTS_2014_EVERYDAY_SENDCODE_COUNT);
    }

    public static String getEvents_2014_Max_Money() {
        return getProperties().getProperty(EVENTS_2014_MAX_MONEY);
    }

    public static String getTranCodeAccountCardEncrypt() {
        return getProperties().getProperty(BK_TRAN_ACCOUNT_CARD_ENCRYPT);
    }

    public static String getValiCardStatusSearch() {
        return getProperties().getProperty(BK_TRAN_VALI_CARD_STATUS_SEARCH);
    }

    public static Properties props2 = null;

    public static Properties getMessageProperties() {

        if (props2 == null) {
            props2 = new Properties();
            // String path = Thread.currentThread().getContextClassLoader()
            // .getResource("").getPath();
            String path = "/app/ylcf/application/yilucaifu/WEB-INF/classes/";
            try {
                props2.load(new FileInputStream(path
                        + "constellation.properties"));
                // props2.load(new FileInputStream(path
                // + "constellation.properties"));
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return props2;
    }

    public static Properties props = null;

    public static Properties getProperties() {

        if (props == null) {
            props = new Properties();
            InputStream fileStream = null;
            Context env = null;
            String path = null;

            try {
                // Get a handle to the JNDI environment naming context
                env = (Context) new InitialContext().lookup("java:comp/env");
                path = (String) env.lookup("KINGConfigs");

                File file = new File(path);
                file = file.getAbsoluteFile();
                fileStream = new FileInputStream(file);

                if (logger.isDebugEnabled()) {
                    logger.debug("Opened config file <" + path
                            + "> successfully.");
                }
            } catch (FileNotFoundException e1) {
                logger.error(path
                        + " is not found in local environment.  Trying the classpath....");
                // do nothing yet
            } catch (NamingException e) {
                logger.error(path + " pathname is erroneous.  ", e);
            }

            try {

                if (fileStream == null) {
                    props.load(ConfigUtil.class.getClassLoader()
                            .getResourceAsStream(path));

                } else {
                    // HOSTSFILE was found
                    props.load(fileStream);
                }
            } catch (IOException e) {
                logger.fatal("Cannot find and load " + path
                        + "!! Make sure it is available!", e);
            }
        }
        return props;
    }

    /**
     * @return the httpServerUrl
     */
    public static String getHttpsServerUrl() {
        return getProperties().getProperty(HTTPS_SERVER_URL);
    }

    public static String getVersion() {
        return getProperties().getProperty(VERSION);
    }

    public static String getCodeQuickTransfer() {
        return getProperties().getProperty(BK_TRAN_QUICK_TRANSFER);
    }

    public static String getLL_OID_PARTNER() {
        return getProperties().getProperty(LL_OID_PARTNER);
    }

    public static String getLL_MD5_KEY() {
        return getProperties().getProperty(LL_MD5_KEY);
    }

    public static String getLL_URL_RETURN() {
        return getProperties().getProperty(LL_URL_RETURN);
    }

    public static String getLL_URL_RETURN_RELIBAO() {
        return getProperties().getProperty(LL_URL_RETURN_RELIBAO);
    }

    public static String getLL_URL_RETURN_API() {
        return getProperties().getProperty(LL_URL_RETURN_API);
    }

    public static String getLL_API2_URL_RETURN_API() {
        return getProperties().getProperty(LL_URL_RETURN_API2_YINGPAY);
    }

    public static String getLL_NOTIFY_URL() {
        return getProperties().getProperty(LL_NOTIFY_URL);
    }

    public static String getLL_API2_NOTIFY_URL() {
        return getProperties().getProperty(LL_NOTIFY_URL_API2_YINGPAY);
    }


    public static String getLL_RETURN_LINE_URL() {
        return getProperties().getProperty(LL_RETURN_LINE_URL);
    }

    public static String getLL_RETURN_WT_URL() {
        return getProperties().getProperty(LL_RETURN_WT_URL);
    }

    /**
     * @return the chinapayappSysId
     */
    public static String getChinapayappSysId() {
        return getProperties().getProperty(CHINAPAYAPP_SYS_ID);
    }

    /**
     * @return the chinapaymerid
     */
    public static String getChinapaymerid() {
        return getProperties().getProperty(CHINAPAYMERID);
    }

    /**
     * @return the chinapaykey
     */
    public static String getChinapaykey() {
        return getProperties().getProperty(CHINAPAYKEY);
    }

    /**
     * @return the weixinappid
     */
    public static String getWeixinappid() {
        return getProperties().getProperty(WEIXINAPPID);
    }

    /**
     * @return the weixinsecret
     */
    public static String getWeixinsecret() {
        return getProperties().getProperty(WEIXINSECRET);
    }

    public static String getCodeQuickPay() {
        return getProperties().getProperty(BK_TRAN_QUICK_PAY);
    }

    public static String getDaoqibaoUnitNet() {
        return getProperties().getProperty(DAOQIBAO_UNIT_NET);
    }

    public static String getDaoqibaoAccumNet() {
        return getProperties().getProperty(DAOQIBAO_ACCUM_NET);
    }

    public static String getCodeValiCardCountReset() {
        return getProperties().getProperty(BK_TRAN_VALICARD_COUNT_RESET);
    }

    public static String getIosMasterSecret() {
        return getProperties().getProperty(IOSMASTERSECRET);
    }

    public static String getIosAppKey() {
        return getProperties().getProperty(IOSAPPKEY);
    }

    public static String getAndroidMasterSecret() {
        return getProperties().getProperty(ANDROIDMASTERSECRET);
    }

    public static String getAndroidAppKey() {
        return getProperties().getProperty(ANDROIDAPPKEY);
    }

    public static String getLL_URL_RETURN_ICAIFUGOODS() {
        return getProperties().getProperty(LL_URL_RETURN_ICAIFUGOODS);
    }

    public static String getLL_NOTIFY_URL_ICAIFUGOODS() {
        return getProperties().getProperty(LL_NOTIFY_URL_ICAIFUGOODS);
    }

    // 货基支付基金代码
    public static String getFundpayFundcode() {
        return getProperties().getProperty(FUNDPAY_FUNDCODE);
    }

    // 博时网点号：
    public static String getFundpayTargetbranchcode() {
        return getProperties().getProperty(FUNDPAY_TARGETBRANCHCODE);
    }

    // 博时网点号：
    public static String getFundpayTargetdistributorcode() {
        return getProperties().getProperty(FUNDPAY_TARGETDISTRIBUTORCODE);
    }

    // 一路财富交易帐号
    public static String getFundpayTargettransactionaccountid() {
        return getProperties().getProperty(FUNDPAY_TARGETTRANSACTIONACCOUNTID);
    }

    // 一路财富TA帐号
    public static String getFundpayTargettaaccountid() {
        return getProperties().getProperty(FUNDPAY_TARGETTAACCOUNTID);
    }

    // 基金购买的时间间隔，大于这个时间重新记录一条数据
    public static String getBuyFundLimitMinutes() {
        return getProperties().getProperty(BUYFUND_LIMITMINUTES);
    }


    public static String getLL_NOTIFY_URL_YINGPAY() {
        return getProperties().getProperty(LL_NOTIFY_URL_YINGPAY);
    }

    public static String getLL_URL_RETURN_YINGPAY() {
        return getProperties().getProperty(LL_URL_RETURN_YINGPAY);
    }

    public static String getLL_NOTIFY_URL_RELIBAO() {
        return getProperties().getProperty(LL_NOTIFY_URL_RELIBAO);
    }

    public static String getLL_DAOQIBAO_NOTIFY_URL() {
        return getProperties().getProperty(LL_DAOQIBAO_NOTIFY_URL);
    }

    public static String getLL_DAOQIBAO_URL_RETURN_API() {
        return getProperties().getProperty(LL_DAOQIBAO_URL_RETURN_API);
    }

    public static String getSmsPath() {
        return getProperties().getProperty(SMS_PATH);
    }

    public static String getLxhlDownlink() {
        return getProperties().getProperty(LXHL_DOWNLINK);
    }

    public static String getLxhlCorp() {
        return getProperties().getProperty(LXHL_CORP);
    }

    public static String getLxhlPwd() {
        return getProperties().getProperty(LXHL_PWD);
    }

    public static String getVoiceSmsSoftwareserialno() {
        return getProperties().getProperty(VOICE_SMS_SOFTWARESERIALNO);
    }

    public static String getVoiceSmsKey() {
        return getProperties().getProperty(VOICE_SMS_KEY);
    }

    public static String getVoiceSmsUri() {
        return getProperties().getProperty(VOICE_SMS_URI);
    }


    public static String getLL_OPENTHIRD_DAOQIBAO_NOTIFY_URL() {
        return getProperties().getProperty(LL_OPENTHIRD_DAOQIBAO_NOTIFY_URL);
    }

    public static String getLL_OPENTHIRD_DAOQIBAO_URL_RETURN_API() {
        return getProperties().getProperty(LL_OPENTHIRD_DAOQIBAO_URL_RETURN_API);
    }

    /**
     * @return the memcacheServer
     */
    public static String getMemcacheServer() {
        return getProperties().getProperty(MEMCACHE_SERVER);
    }


    public static String getInsurancePartnerId() {
        return getProperties().getProperty(InsurancePid);
    }


    public static String getInsuranceQiXinPid() {
        return getProperties().getProperty(InsuranceQiXinPid);
    }

    public static String getInsuranceQiXinKey() {
        return getProperties().getProperty(InsuranceQiXinKey);
    }

    public static String getQiXinDefaultTrialUrl() {
        return getProperties().getProperty(QiXinDefaultTrialUrl);
    }

    public static String getQiXinInsureUrl() {
        return getProperties().getProperty(QiXinInsureUrl);
    }

    public static String getQiXinOnlinePayUrl() {
        return getProperties().getProperty(QiXinOnlinePayUrl);
    }

    public static String getQiXinSurrenderPolicyUrl() {
        return getProperties().getProperty(QiXinSurrenderPolicyUrl);
    }

    public static String getQiXinHealthNotifyQuesUrl() {
        return getProperties().getProperty(QiXinHealthNotifyQuesUrl);
    }

    public static String getQiXinSubmitHealthStateUrl() {
        return getProperties().getProperty(QiXinSubmitHealthStateUrl);
    }

    public static String getQiXinPropertyAddressUrl() {
        return getProperties().getProperty(QiXinPropertyAddressUrl);
    }

    public static String getQiXinProductDestinationUrl() {
        return getProperties().getProperty(QiXinProductDestinationUrl);
    }

    public static String getQiXinInsuranceproductDetailsUrl() {
        return getProperties().getProperty(QiXinInsuranceproductDetailsUrl);
    }

    public static String getQiXinProductAreaUrl() {
        return getProperties().getProperty(QiXinProductAreaUrl);
    }

    public static String getQiXinProductInsuredAttr() {
        return getProperties().getProperty(QiXinProductInsuredAttr);
    }

    public static String getQiXinProductInsuredJob() {
        return getProperties().getProperty(QiXinProductInsuredJob);
    }

    public static String getQiXinInsuranceOrderCancelUrl() {
        return getProperties().getProperty(QiXinInsuranceOrderCancelUrl);
    }

    public static String getQiXinProductPropertyAreaUrl() {
        return getProperties().getProperty(QiXinProductPropertyAreaUrl);
    }

    public static String getQiXinOrderTrialUrl() {
        return getProperties().getProperty(QinXinOrderTrialUrl);
    }

    public static String getQiXinInsuranceCallBackUrl() {
        return getProperties().getProperty(QiXinInsuranceCallBackUrl);
    }

    public static String getQiXinInsuranceDownloadUrl() {
        return getProperties().getProperty(QiXinInsuranceDownloadUrl);
    }


    public static String getInsuranceKey() {
        return getProperties().getProperty(InsuranceKey);
    }

    public static String getInsuranceOrderApplyUrl() {
        return getProperties().getProperty(OrderApplyUrl);
    }

    public static String getInsuranceNoticeUrlUrl() {
        return getProperties().getProperty(NoticeUrl);
    }

    public static String getInsuranceHealthSubmitUrl() {
        return getProperties().getProperty(HealthSubmoitUrl);
    }

    public static String getInsuranceHealthSubmitV1Url() {
        return getProperties().getProperty(HealthSubmoitV1Url);
    }

    public static String getInsuranceOrderApplyV1Url() {
        return getProperties().getProperty(OrderApplyV1Url);
    }

    public static String getInsuranceOrderCancelUrl() {
        return getProperties().getProperty(OrderCancel);
    }

    public static String getInsuranceProductPayUrl() {
        return getProperties().getProperty(ProductPay);
    }

    public static String getInsuranceOrderCancelV1Url() {
        return getProperties().getProperty(OrderCancelV1);
    }

    public static String getProductAreaUrl() {
        return getProperties().getProperty(productArea);
    }

    public static String getProductPropertyAreaUrl() {
        return getProperties().getProperty(productPropertyArea);
    }

    public static String getProductproductDetails() {
        return getProperties().getProperty(productproductDetails);
    }

    public static String getProductDestinationUrl() {
        return getProperties().getProperty(productDestination);
    }

    public static String getProductDestinationsUrl() {
        return getProperties().getProperty(productDestinations);
    }

    public static String getInsuranceDownloadUrl() {
        return getProperties().getProperty(orderDownLoad);
    }

    public static String getInsuranceDownloadUrlV1() {
        return getProperties().getProperty(orderDownLoadV1);
    }

    public static String getInsurancePath() {
        return getProperties().getProperty(InsurancePath);
    }

    public static String getInsuranceChunYan() {
        return getProperties().getProperty(InsuranceChunYan);
    }

    public static String getInsuranceWebPath() {
        return getProperties().getProperty(InsuranceWebPath);
    }

    public static String getDefaultTrialUrl() {
        return getProperties().getProperty(DefaultTrial);
    }

    public static String getOrderTrialUrl() {
        return getProperties().getProperty(OrdertTrial);
    }

    public static String getHealthNotifyQuesUrl() {
        return getProperties().getProperty(HealthNotifyQuesUrl);
    }


    public static String getProductJobUrl() {
        return getProperties().getProperty(GetProductJobUrl);
    }


    //京东支付相关配置  wanghaitao  20161122 添加

    private static final String CHINABANK_VERSION = "chinabank.version";
    private static final String CHINABANK_MERCHANT = "chinabank.merchant";
    private static final String CHINABANK_TERMINAL = "chinabank.terminal";
    private static final String CHINABANK_URL = "chinabank.url";
    private static final String CHINABANK_DES = "chinabank.des";
    private static final String CHINABANK_MD5 = "chinabank.md5";
    private static final String CHINABANK_FILEPATH = "chinabank.filepath";
    private static final String CHINABANK_ORDER_NOTICE = "chinabank.order.notice";

    public static String getChinabankOrderNotice() {
        return getProperties().getProperty(CHINABANK_ORDER_NOTICE);
    }

    public static String getChinabankVersion() {
        return getProperties().getProperty(CHINABANK_VERSION);
    }

    public static String getChinabankMerchant() {
        return getProperties().getProperty(CHINABANK_MERCHANT);
    }

    public static String getChinabankTerminal() {
        return getProperties().getProperty(CHINABANK_TERMINAL);
    }

    public static String getChinabankUrl() {
        return getProperties().getProperty(CHINABANK_URL);
    }

    public static String getChinabankDes() {
        return getProperties().getProperty(CHINABANK_DES);
    }

    public static String getChinabankMd5() {
        return getProperties().getProperty(CHINABANK_MD5);
    }

    public static String getChinabankFilepath() {
        return getProperties().getProperty(CHINABANK_FILEPATH);
    }

    /**
     * @return seckey
     */
    public static String getYlmf_key() {
        return getProperties().getProperty(YLMF_KEY);
    }

    /**
     * @return 企业钱包域名
     */
    public static String getYlmf_url() {
        return getProperties().getProperty(YLMF_URl);
    }
//	private static final String  = "ll.daoqibao.notify.url";
//	private static final String  = "ll.daoqibao.url.return.api";

    public static String getFtpServer() {
        return getProperties().getProperty(FTP_SERVER);
    }

    public static String getFtpServerUrl() {
        return "http://" + getProperties().getProperty(FTP_SERVER) + "/";
    }

    public static int getFtpPort() {
        return Integer.parseInt(getProperties().getProperty(FTP_PORT));
    }

    public static String getFtpUsername() {
        return getProperties().getProperty(FTP_USERNAME);
    }

    public static String getFtpPassword() {
        return getProperties().getProperty(FTP_PASSWORD);
    }

    //企业材料审核邮箱模版
    private static final String EMAIL_OPEN_ACCOUNT_FTL = "email/openAccount.ftl";
    //余额购买完产品通知模版
    public static final String BALANCE_BUY_FTL = "balanceBuyMsg.ftl";
    //企业材料审核人
    public static final String EMAIL_OPEN_ACCOUNT_MAN = "email.openAccountMan";
    //信息收集查看人邮箱
    public static final String EMAIL_GATHER_INFO = "email.gatherinfo";
    //信息收集查看人手机号
    public static final String PHONE_GATHER_INFO = "phone.gatherinfo";
    //余额购买完产品后通知人邮箱
    private static final String EMAIL_BALANCE_BUY_MAN = "email.balaceBuy";
    //余额购买完产品后通知人手机号
    private static final String PHONE_BALANCE_BUY_MAN = "phone.balaceBuy";

    private static final String WX_LINKUSERIDS = "wx.linkUserIds";
    //等待开户页
    private static final String OPEN_ACCOUNT_PAGE = "/passport/userInfoSuccess.html";
    //平台交易密码
    private static final String SET_TRANSPASSWD_PAGE = "/user/setTradePwd.html";
    //风险测评
    private static final String FUND_RISK_PAGE = "/fundRisk/content.html";
    //注册流程
    private static final String REGISTER_PAGE = "/passport/reg.html";
    //徽商设置交易密码
    private static final String HS_PASSWD_SETURL = "/user/passwdSetUrl.html?userId=";
    //上传合格投资者证明
    private static final String UPLOAD_USER_QFII = "/passport/toUpQfiiPage.html";

    public static String getEmailBalanceBuyMan() {
        return getProperties().getProperty(EMAIL_BALANCE_BUY_MAN);
    }

    public static String getPhoneBalanceBuyMan() {
        return getProperties().getProperty(PHONE_BALANCE_BUY_MAN);
    }

    public static String getEmailOpenAccountFTL() {
        return EMAIL_OPEN_ACCOUNT_FTL;
    }

    public static String getEmailOpenAccountMAN() {
        return getProperties().getProperty(EMAIL_OPEN_ACCOUNT_MAN);
    }

    public static String getOpenAccountPage() {
        return OPEN_ACCOUNT_PAGE;
    }

    public static String getUploadByUserQfii() {
        return UPLOAD_USER_QFII;
    }

    public static String getSetTranspasswdPage() {
        return SET_TRANSPASSWD_PAGE;
    }

    public static String getFundRiskPage() {
        return FUND_RISK_PAGE;
    }

    public static String getRegisterPage() {
        return REGISTER_PAGE;
    }

    public static String getHsPasswdSeturl() {
        return HS_PASSWD_SETURL;
    }

    public static String getEmailGatherInfo() {
        return getProperties().getProperty(EMAIL_GATHER_INFO);
    }

    public static String getPhoneGatherInfo() {
        return getProperties().getProperty(PHONE_GATHER_INFO);
    }

    public static String getWxLinkUserIds() {
        return getProperties().getProperty(WX_LINKUSERIDS);
    }


    // 平安募集户信息--募集户名称
    private static final String ACCOUNT_NAME = "一路财富（北京）信息科技有限公司基金销售归集总账户";
    // 平安募集户信息--募集户银行卡号
    private static final String USER_NAME = "11014539159004";
    // 平安募集户信息--募集户开户行
    private static final String BANK_NAME = "平安银行北京知春路支行";
    // 平安募集户信息--募集户联行号
    private static final String NETLINE_NO = "307100003109";
    // 平安募集户信息--募集户银行编号
    private static final String BANK_NO = "307";

    public static String getAccountName() {
        return ACCOUNT_NAME;
    }

    public static String getUserName() {
        return USER_NAME;
    }

    public static String getBankName() {
        return BANK_NAME;
    }

    public static String getNetlineno() {
        return NETLINE_NO;
    }

    public static String getBankno() {
        return BANK_NO;
    }


}
