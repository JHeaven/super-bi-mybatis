package com.heaven.main.analyse2017;

import java.util.Date;

/**
 * 
 * 参数生成map和sql
 * 
 * @author jiangyqc
 *
 */
public class AnalyseFormula6 {

	static String sjFlag = "";
	
	static String [] colsL = new String [100];
	static String [] colsH = new String [100];
	
	static String [] colsLName = new String [100];
	static String [] colsHName = new String [100];
	
	static int [] sjNum = new int [100];
 
	public static void main(String[] args) {
		install();
		
		for (int i = 1; i < sjNum.length; i++) {
			
			if (i<10) {
				sjFlag = "0"+i;
			}else {
				sjFlag = "" +i;
			}
			
			if (sjNum[i]!=0 && sjNum[i]>0) {
				//解析MAP
				//getMaps(i);
				System.out.println();
				//解析SQL
				//getSql(i);
				getMapsTips(i);
			}
		}
		
	}
	
	
	
	private static void getSql(int i) {
		String [] colsOfL = colsL[i].split("#");
		String [] colsOfH = colsH[i].split("#");
		String [] colsOfLName = colsLName[i].split("#");
		String [] colsOfHName = colsHName[i].split("#");
		
		if (colsOfL.length ==colsOfLName.length) {
			if (colsOfH.length ==colsOfHName.length) {
				
				//L
				for (int j = 0; j < colsOfL.length; j++) {
					System.out.println("insert into gy_bbcx_shxx_maps  (uuid, bbmc, colname, colmap, colnum, bylx, yxbz) values (sys_guid(), 'SJ"+sjFlag+"', '"+colsOfLName[j]+"','"+colsOfL[j]+"',"+j+",'L','Y');");
				}
				
				//H
				for (int j = 0; j < colsOfH.length; j++) {
					System.out.println("insert into gy_bbcx_shxx_maps  (uuid, bbmc, colname, colmap, colnum, bylx, yxbz) values (sys_guid(), 'SJ"+sjFlag+"', '"+colsOfHName[j]+"','"+colsOfH[j]+"',"+j+",'H','Y');");
				}
				
				
			}else {
				System.out.println(new Date() + "colsOfL.length != colsOfLName.length");
			}
		}else {
			System.out.println(new Date() + "colsOfL.length != colsOfLName.length");
		}
		
		System.out.println("commit;");
	}










	private static void getMaps(int i) {
		String [] colsOfL = colsL[i].split("#");
		String [] colsOfH = colsH[i].split("#");
		for (int j = 0; j < colsOfL.length; j++) {
			System.out.println("demo"+sjFlag+".put(\""+(sjNum[i]+j)+"L\",\""+colsOfL[j]+"\");");
		}
		
		for (int j = 0; j < colsOfH.length; j++) {
			System.out.println("demo"+sjFlag+".put(\""+(1+j)+"H\",\""+colsOfH[j]+"\");");
		}
	}

	
	

	private static void getMapsTips(int i) {
		String [] colsOfL = colsLName[i].split("#");
		String [] colsOfH = colsHName[i].split("#");
		for (int j = 0; j < colsOfL.length; j++) {
			System.out.println("demoTips"+sjFlag+".put(\""+(sjNum[i]+j)+"L\",\""+colsOfL[j]+"\");");
		}
		
		for (int j = 0; j < colsOfH.length; j++) {
			System.out.println("demoTips"+sjFlag+".put(\""+(1+j)+"H\",\""+colsOfH[j]+"\");");
		}
	}




	private static void install() {
		
		sjNum[1] = 3;
		colsL[1] = "HJ#1DZSS#2DZQTSR#3JMSJ#4DJSJ#5ZTSJ#6RKSS#7RKQTSR#8TTSJ#9DCLSSSJ#10SSSJHX#11BGK";
		colsH[1] = "XH#ZJZYKM#ZJZYNCYE#ZJZYQMYE#ZJLYKM#ZJLYKMNCYE#ZJLYKMQMYE";
		colsLName[1] = "合计#1.待征税收#2.待征其他收入#3.减免税金#4.待解税金#5.在途税金#6.入库税收#7.入库其他收入#8.提退税金#9.待处理损失税金#10.损失税金核销#11.保管款";
		colsHName[1] = "序号#资金占用科目#资金占用年初余额#资金占用期末余额#资金来源科目#资金来源年初余额#资金来源期末余额";
		
		sjNum[2] = 4;
		colsL[2] = "ZJ#SSSRHJ#ZZSSR#GNZZS#YBZZS#GZZZS#QZZGTLZGSGZZZSSR#CJRJYZZSTS#RJZZSTS#SGZHLYZZSTS#SDZZSTS#ZYZHLYZZSTS#CPYZZSTS#MDDZZZS#MDDZGZZZS#2JKHWZZS#2XFSSR#GNXFS#QZCPYXFS#JKXFPXFS#QZJKCPYXFS#3YYS#JRBXYYYS#QTYYS#4QYSDS#QZZYGDSR#1YBQYSDS#NZQY1#WZQY1#2FZJGYJSDS#NZQY2#WZQY2#3ZJGYJSDS#NZQY3#WZQY3#4FZJGHSQJSDS#NZQY4#WZQY4#5ZJGHSQJSDS#NZQY5#WZQY5#6QYSDSDFPSR#NZQY6#WZQY6#5GRSDS#LXSDS#QTGRSDS#6ZYS#7GDZCTZFXDJS#8CSWHJSS#9FCS#10YHS#ZQJYYHS#QTYHS#11CZTDSYS#12TDZZS#13CCS#14CLGZS#15YYS#16GDZYS#17QS#18QTSS#ECPYXFSTS#SCKTSHJ#1CKHWTZZS#2GZZZSCKTS#3MDDJZZS#4MDDJGZZZS#5CKXFPTXFS#SFSSRHJ#1JYFFJSR#2DFJYFJ#3WHSYJSFSR#4HSSYKQSYFSR#5SWBMFMSR#6CJRJYBZJJ#7SHBXJJSR#QYZGJBYLBXJJSR#JGSYDWJBYLBXJJSR#SYBXJJSR1#JBYLBXJJSR#GSBXJJSR#SYBXJJSR2#QTSHBXJJSR#8ZFXJJSR#FQDQDZCPCLJJSR#QTZFXJJSR#9GHJFSR#10QTFSSR";
		colsH[2] = "XH#XM#HJ#BNXQRK#20010501HCQRK#20010501QCQRK#ZY#DFXJ1#DFSJ1#DFSJ2#DFXJ2";
		colsLName[2] = "总计#税收收入合计#增值税收入#国内增值税#一般增值税#改征增值税#其中中国铁路总公司改征增值税收入#残疾人就业增值税退税#软件增值税退税#森工综合利用增值税退税#水电增值税退税#资源综合利用增值税退税#成品油增值税退税#免抵调增增值税#免抵调增改征增值税#(2)进口货物增值税#2.消费税收入#国内消费税#其中：成品油消费税#进口消费品消费税#其中：进口成品油消费税#3.营业税#金融保险业营业税#其他营业税#4.企业所得税#其中：中央固定收入#（1）一般企业所得税#内资企业#外资企业#（2）分支机构预缴所得税#内资企业#外资企业#（3）总机构预缴所得税#内资企业#外资企业#（4）分支机构汇算清缴所得税#内资企业#外资企业#（5）总机构汇算清缴所得税#内资企业#外资企业#（6）企业所得税待分配收入#内资企业#外资企业#5.个人所得税#利息所得税#其他个人所得税#6.资源税#7.固定资产投资方向调节税#8.城市维护建设税#9.房产税#10.印花税#证券交易印花税#其他印花税#11.城镇土地使用税#12.土地增值税#13.车船税#14.车辆购置税#15.烟叶税#16.耕地占用税#17.契税#18.其他税收#二、成品油消费税退税#三、出口退税合计#1.出口货物退增值税#2.改征增值税出口退税#3.免抵调减增值税#4.免抵调减改征增值税#5.出口消费品退消费税#四、非税收入合计#1.教育费附加收入#2.地方教育附加#3.文化事业建设费收入#4.海上石油矿区使用费收入#5.税务部门罚没收入#6.残疾人就业保障基金#7.社会保险基金收入#企业职工基本养老保险基金收入#机关事业单位基本养老保险基金收入#失业保险基金收入#基本医疗保险基金收入#工伤保险基金收入#生育保险基金收入#其他社会保险基金收入#8.政府性基金收入#废弃电器电子产品处理基金收入#其他政府性基金收入#9.工会经费收入#10.其他非税收入";
		colsHName[2] = "序号#项目#合计#本年新欠入库#2001年5月1日以后陈欠入库#2001年5月1日以前陈欠入库#中央#地方小计#地方省级#地方市级#地方县级";
		
		sjNum[3] = 3;
		colsL[3] = "ZJ#YSSSRHJ#1ZZSSR#QZGZZZS#2XFSSR#3YYS#4QYSDS#5GRSDS#6ZYS#7GDZCTZFXDJS#8CSWHJSS#9FCS#10YHS#11CZTDSYS#12TDZZS#13CCS#14CLGZS#15YYS#16GDZYS#17QS#18QTSS#EQTSRHJ#QZFQDQDZCPCLJJSR";
		colsH[3] = "XH#XM#NCYE#DNFSEHJ#DNFSEGYQY#DNFSEJTQY#DNFSEGFHZQY#DNFSELYQY#DNFSEQZGYKG1#DNFSEGFGS#DNFSEQZGYKG2#DNFSESYQY#DNFSEGATTZQY#DNFSEQZGYKG3#DNFSEWSTZQY#DNFSEQZGYKG4#DNFSEQTQY#QMYE";
		colsLName[3] = "总计#一、税收收入合计#1.增值税收入#其中：改征增值税#2.消费税收入#3.营业税#4.企业所得税#5.个人所得税#6.资源税#7.固定资产投资方向调节税#8.城市维护建设税#9.房产税#10.印花税#11.城镇土地使用税#12.土地增值税#13.车船税#14.车辆购置税#15.烟叶税#16.耕地占用税#17.契税#18.其他税收#二、其他收入合计#其中：废弃电器电子产品处理基金收入";
		colsHName[3] = "序号#项目#年初余额#当年发生额合计#当年发生额国有企业#当年发生额集体企业#当年发生额股份合作企业#当年发生额联营企业#当年发生额其中：国有控股#当年发生额股份公司#当年发生额其中：国有控股#当年发生额私营企业#当年发生额港澳台投资企业#当年发生额其中：国有控股#当年发生额外商投资企业#当年发生额其中：国有控股#当年发生额其他企业#期末余额";
		
		
		sjNum[4] = 2;
		colsL[4] = "ZJ1#YSSSRHJ2#WDQYJSK3#JPZHZ4#GTJKKQYQS5#WNCQ6#BNXQ7#1GNZZS8#QZGZZZS9#WDQYJSK10#JPZHZ11#GTJKKQYQS12#WNCQ13#BNXQ14#2GNXFS15#WDQYJSK16#JPZHZ17#GTJKKQYQS18#WNCQ19#BNXQ20#3YYS21#WDQYJSK22#JPZHZ23#GTJKKQYQS24#WNCQ25#BNXQ26#4QYSDS27#WDQYJSK28#JPZHZ29#GTJKKQYQS30#WNCQ31#BNXQ32#5GRSDS33#WDQYJSK34#JPZHZ35#GTJKKQYQS36#WNCQ37#BNXQ38#6ZYS39#WDQYJSK40#JPZHZ41#GTJKKQYQS42#WNCQ43#BNXQ44#7CSWHJSS45#WDQYJSK46#JPZHZ47#GTJKKQYQS48#WNCQ49#BNXQ50#8FCS51#WDQYJSK52#JPZHZ53#GTJKKQYQS54#WNCQ55#BNXQ56#9YHS57#WDQYJSK58#JPZHZ59#GTJKKQYQS60#WNCQ61#BNXQ62#10CZTDSYS63#WDQYJSK64#JPZHZ65#GTJKKQYQS66#WNCQ67#BNXQ68#11TDZZS69#WDQYJSK70#JPZHZ71#GTJKKQYQS72#WNCQ73#BNXQ74#12CCS75#WDQYJSK76#JPZHZ77#GTJKKQYQS78#WNCQ79#BNXQ80#13YYS81#WDQYJSK82#JPZHZ83#GTJKKQYQS84#WNCQ85#BNXQ86#14GDZYS87#WDQYJSK88#JPZHZ89#GTJKKQYQS90#WNCQ91#BNXQ92#15QS93#WDQYJSK94#JPZHZ95#GTJKKQYQS96#WNCQ97#BNXQ98#16QTSS99#WDQYJSK100#JPZHZ101#GTJKKQYQS102#WNCQ103#BNXQ104#EQTSRHJ105#QZFQDQDZCPCLJJSR106";
		colsH[4] = "XH#XM#QCYE#BQZJE#BQJSE#QMYE";
		colsLName[4] = "总计#一、税收收入合计#未到期应缴税款#经批准缓征#关、停及空壳企业欠税#往年陈欠#本年新欠#1.国内增值税#其中：改征增值税#未到期应缴税款#经批准缓征#关、停及空壳企业欠税#往年陈欠#本年新欠#2.国内消费税#未到期应缴税款#经批准缓征#关、停及空壳企业欠税#往年陈欠#本年新欠#3.营业税#未到期应缴税款#经批准缓征#关、停及空壳企业欠税#往年陈欠#本年新欠#4.企业所得税#未到期应缴税款#经批准缓征#关、停及空壳企业欠税#往年陈欠#本年新欠#5.个人所得税#未到期应缴税款#经批准缓征#关、停及空壳企业欠税#往年陈欠#本年新欠#6.资源税#未到期应缴税款#经批准缓征#关、停及空壳企业欠税#往年陈欠#本年新欠#7.城市维护建设税#未到期应缴税款#经批准缓征#关、停及空壳企业欠税#往年陈欠#本年新欠#8.房产税#未到期应缴税款#经批准缓征#关、停及空壳企业欠税#往年陈欠#本年新欠#9.印花税#未到期应缴税款#经批准缓征#关、停及空壳企业欠税#往年陈欠#本年新欠#10.城镇土地使用税#未到期应缴税款#经批准缓征#关、停及空壳企业欠税#往年陈欠#本年新欠#11.土地增值税#未到期应缴税款#经批准缓征#关、停及空壳企业欠税#往年陈欠#本年新欠#12.车船税#未到期应缴税款#经批准缓征#关、停及空壳企业欠税#往年陈欠#本年新欠#13.烟叶税#未到期应缴税款#经批准缓征#关、停及空壳企业欠税#往年陈欠#本年新欠#14.耕地占用税#未到期应缴税款#经批准缓征#关、停及空壳企业欠税#往年陈欠#本年新欠#15.契税#未到期应缴税款#经批准缓征#关、停及空壳企业欠税#往年陈欠#本年新欠#16.其他税收#未到期应缴税款#经批准缓征#关、停及空壳企业欠税#往年陈欠#本年新欠#二、其他收入合计#其中：废弃电器电子产品处理基金收入";
		colsHName[4] = "序号#项目#期初余额#本期增加额#本期减少额#期末余额";
		
		
		
		sjNum[5] = 2;
		colsL[5] = "ZJ#YSSSRHJ#1ZZS#QZGZZZS#JXLD#2XFS#QZCPYXFS#3YYS#4QYSDS#5GRSDS#6ZYS#7GDZCTZFXDJS#8CSWHJSS#9FCS#10YHS#11CZTDSYS#12TDZZS#13CCS#14CLGZS#15YYS#16GDZYS#17QS#18QTSS#EQTSRHJ#QZFQDQDZCPCLJJSR#FLZLZZSJXLDSE";
		colsH[5] = "XH#XM#HJ#CKTS#XZHT#JMTS#HSQJJSTS#WSTS#QTTS";
		colsLName[5] = "总计#一、税收收入合计#1.增值税#其中：改征增值税#进项留抵#2.消费税#其中：成品油消费税#3.营业税#4.企业所得税#5.个人所得税#6.资源税#7.固定资产投资方向调节税#8.城市维护建设税#9.房产税#10.印花税#11.城镇土地使用税#12.土地增值税#13.车船税#14.车辆购置税#15.烟叶税#16.耕地占用税#17.契税#18.其他税收#二、其他收入合计#其中：废弃电器电子产品处理基金收入#附列资料：增值税进项留抵税额";
		colsHName[5] = "序号#项 目#合计#出口退税#先征后退#减免退税#汇算清缴结算退税#误收退税#其他退税";
		
		
		sjNum[6] = 3;
		colsL[6] = "ZJ#QZZQJM#TKJM#DDQS#YGSMS#1ZF#2JZJZJ#3JZZY#4ZJYFC#5SHBZ#6TGJMSR#7QT#EGLGXJS#1JSZR#2KJFZ#3ZZCX#4KYJGZZ#5TZCY#6WBFW#7GXJS#8QT#SCJXWQYFZ#1JRSC#2WDQZD#3MZZZSHYYSZC#4QT1#SZZSJ#1QYFZ#2QYZZGZ#3QT#WJNHB#1HJBH#2DLJS#3ZYZHLY#4QT2#LCJQYFZ#1XBKF#2DBFZ#3LAJL#4QT3#QZCWHJYTY#1JY#2TY#3WH#BZCJRZBSC#1ZBSC#2JRSC#JZCSN#1NCJS#2FLSL#3CYSJ#4JRSC#5QT1#SZCQTGXSY#1FJZZ#2JCSSJS#3CPY#4GFJS#5GJF#6YLWS#7JTYS#8WCYZ#9GY#10SPCB#11WJRY#12ZXCZXZJ#13QT#SYXSSSXDDY#1GX#2LX#3TXQSYF#4CCSY#5QT2";
		colsH[6] = "XH#XM#HJ#SSSRXJ#SSSRZZS#SSSRQZ：GZZZS#SSSRXFS#SSSRYYS#SSSRQYSDS#SSSRGRSDS#SSSRZYS#SSSRCSWHJSS#SSSRFCS#SSSRYHS#SSSRCZTDSYS#SSSRTDZZS#SSSRCCS#SSSRCLGZS#SSSRGDZYS#SSSRQS#SSSRQTSS#QTSRHJ#QYSDSYJYJJM";
		colsLName[6] = "总计#其中：征前减免#退库减免#抵顶欠税#一、改善民生#1.住房#2.救灾及重建#3.军转择业#4.再就业扶持#5.社会保障#6.提高居民收入#7.其他#二、鼓励高新技术#1.技术转让#2.科技发展#3.自主创新#4.科研机构转制#5.投资创业#6.外包服务#7.高新技术#8.其他#三、促进小微企业发展#1.金融市场#2.未达起征点#3.免征增值税和营业税政策#4.其他#四、转制升级#1.企业发展#2.企业重组改制#3.其他#五、节能环保#1.环境保护#2.电力建设#3.资源综合利用#4.其他#六、促进区域发展#1.西部开发#2.东部发展#3.两岸交流#4.其他#七、支持文化教育体育#1.教育#2.体育#3.文化#八、支持金融资本市场#1.资本市场#2.金融市场#九、支持三农#1.农村建设#2.肥料饲料#3.产业升级#4.金融市场#5.其他#十、支持其他各项事业#1.飞机制造#2.基础设施建设#3.成品油#4.国防建设#5.公检法#6.医疗卫生#7.交通运输#8.无偿援助#9.公益#10.商品储备#11.外籍人员#12.专项财政性资金#13.其他#十一、享受税收协定待遇#1.股息#2.利息#3.特许权使用费#4.财产收益#5.其他";
		colsHName[6] = "序号#项目#合计#税收收入小计#税收收入增值税#税收收入其中：改征增值税#税收收入消费税#税收收入营业税#税收收入企业所得税#税收收入个人所得税#税收收入资源税#税收收入城市维护建设税#税收收入房产税#税收收入印花税#税收收入城镇土地使用税#税收收入土地增值税#税收收入车船税#税收收入车辆购置税#税收收入耕地占用税#税收收入契税#税收收入其他税收#其他收入合计#企业所得税月（季）预缴减免";
		
		
		sjNum[7] = 3;
		colsL[7] = "ZJ#YSSSRHJ#1ZZSSR#QZGNZZS#2XFSSR#QZGNXFS#3YYS#4QYSDS#5GRSDS#6ZYS#7GDZCTZFXDJS#8CSWHJSS#9FCS#10YHS#11CZTDSYS#12TDZZS#13CCS#14CLGZS#15YYS#16GDZYS#17QS#18QTSS#EQTSRHJ#FQDQDZCPCLJJSR";
		colsH[7] = "XH#XM#DJSJNCYE#DJSJQMYE#ZTSJNCYE#ZTSJQMYE#DJSJNCYE2#DJSJQMYE2#DCLSSSJNCYE#DCLSSSJQMYE#SSSJHXNCYE#SSSJHXQMYE";
		colsLName[7] = "总计#一、税收收入合计#1.增值税收入#其中：国内增值税#2.消费税收入#其中：国内消费税#3.营业税#4.企业所得税#5.个人所得税#6.资源税#7.固定资产投资方向调节税#8.城市维护建设税#9.房产税#10.印花税#11.城镇土地使用税#12.土地增值税#13.车船税#14.车辆购置税#15.烟叶税#16.耕地占用税#17.契税#18.其他税收#二、其他收入合计#废弃电器电子产品处理基金收入";
		colsHName[7] = "序号#项目#多缴税金年初余额年初余额#多缴税金期末余额期末余额#在途税金年初余额年初余额#在途税金期末余额期末余额#待解税金年初余额年初余额#待解税金期末余额期末余额#待处理损失税金年初余额年初余额#待处理损失税金期末余额期末余额#损失税金核销年初余额年初余额#损失税金核销期末余额期末余额";
		
		
		
		sjNum[8] = 5;
		colsL[8] = "ZJ#YSSSRHJ#1ZZS#QZGZZZS#2XFS#3YYS#4QYSDS#5GRSDS#6ZYS#7GDZCTZFXDJS#8CSWHJSS#9FCS#10YHS#11CZTDSYS#12TDZZS#13CCS#14CLGZS#15YYS#16GDZYS#17QS#18QTSS#EQTSRHJ#QZ1JYFFJSR#2WHSYJSFSR#3FQDQDZCPCLJJSR#4QTFMSR";
		colsH[8] = "XH#XM#HJ1#YZCBSJSWJCBMCBSK#YZCBSJSWJCBMCBZNJ#YZCBSJSWJCBMCBFK#YZCBSJSWJCBMCBQZZCBS#YZCBSJSWQTBMCBSK#YZCBSJSWQTBMCBZNJ#YZCBSJSWQTBMCBFK#QZ1TBNSDZ#YZCBSJSWQTBMCB2NSPG#YZCBSJWBMCBSK#YZCBSJWBMCBZNJ#YZCBSJWBMCBFK#HJ2#RKCBSJSWJCBMCBXJ#RKCBSJSWJCBMCBZY#RKCBSJSWJCBMCBXJDF#RKCBSJSWJCBMCBSK#RKCBSJSWJCBMCBZNJ#RKCBSJSWJCBMCBFK#RKCBSJSWJCBMCBQZZCBS#RKCBSJSWQTBMCBSK#RKCBSJSWQTBMCBZNJ#RKCBSJSWQTBMCBFK#RKCBSJSWQTBMCBQZ1TBNSDZ#RKCBSJSWQTBMCB2NSPG#RKCBSJWBMCBSK#RKCBSJWBMCBZNJ#RKCBSJWBMCBFK#RKSKZNJFKSR";
		colsLName[8] = "总计#一、税收收入合计#1.增值税#其中：改征增值税#2.消费税#3.营业税#4.企业所得税#5.个人所得税#6.资源税#7.固定资产投资方向调节税#8.城市维护建设税#9.房产税#10.印花税#11.城镇土地使用税#12.土地增值税#13.车船税#14.车辆购置税#15.烟叶税#16.耕地占用税#17.契税#18.其他税收#二、其他收入合计#其中:1.教育费附加收入#2.文化事业建设费收入#3.废弃电器电子产品处理基金收入#4.其他罚没收入";
		colsHName[8] = "序号#项目#合计1#应征查补税金税务稽查部门查补税款#应征查补税金税务稽查部门查补滞纳金#应征查补税金税务稽查部门查补罚款#应征查补税金税务稽查部门查补其中:自查补税#应征查补税金税务其它部门查补税款#应征查补税金税务其它部门查补滞纳金#应征查补税金税务其它部门查补罚款#其中：1.特别纳税调整#应征查补税金税务其它部门查补2.纳税评估#应征查补税金外部门查补税款#应征查补税金外部门查补滞纳金#应征查补税金外部门查补罚款#合计2#入库查补税金税务稽查部门查补小计#入库查补税金税务稽查部门查补中央#入库查补税金税务稽查部门查补小计地方#入库查补税金税务稽查部门查补税款#入库查补税金税务稽查部门查补滞纳金#入库查补税金税务稽查部门查补罚款#入库查补税金税务稽查部门查补其中:自查补税#入库查补税金税务其它部门查补税款#入库查补税金税务其它部门查补滞纳金#入库查补税金税务其它部门查补罚款#入库查补税金税务其它部门查补其中：1.特别纳税调整#入库查补税金税务其它部门查补2.纳税评估#入库查补税金外部门查补税款#入库查补税金外部门查补滞纳金#入库查补税金外部门查补罚款#入库税款滞纳金、罚款收入";
		
		
		sjNum[9] = 2;
		colsL[9] = "SSSRHJ#1ZZS#QZGZZZS#2XFS#3YYS#4QYSDS#5GRSDS#6ZYS#7GDTZFXDJS#8CSWHJSS#9FCS#10YHS#11CZTDSYS#12TDZZS#13CCS#14CLGZS#15YYS#16GDZYS#17QS#18QTSS";
		colsH[9] = "XH#XM#HJ#RKZNJ#HXZNJ#YJWJZNJ";
		colsLName[9] = "税收收入合计#1.增值税#其中：改征增值税#2.消费税#3.营业税#4.企业所得税#5.个人所得税#6.资源税#7.固定投资方向调节税#8.城市维护建设税#9.房产税#10.印花税#11.城镇土地使用税#12.土地增值税#13.车船税#14.车辆购置税#15.烟叶税#16.耕地占用税#17.契税#18.其他税收";
		colsHName[9] = "序号#项目#合计#入库滞纳金#核销滞纳金#应缴未缴滞纳金";
		
		
		sjNum[10] = 2;
		colsL[10] = "ZJ#YSSSRHJ#1ZZS#QZGZZZS#2XFS#3YYS#4QYSDS#5GRSDS#6ZYS#7GDZCTZFXDJS#8CSWHJSS#9FCS#10YHS#QZZQJYYHS#11CZTDSYS#12TDZZS#13CCS#14CLGZS#15YYS#16GDZYS#17QS#18QTSS#EQTSRHJ#QZJYFFJSR#FQDQDZCPCLJJSR";
		colsH[10] = "XH#XM#HJ#DKDS#WTDZ";
		colsLName[10] = "总计#一、税收收入合计#1.增值税#其中：改征增值税#2.消费税#3.营业税#4.企业所得税#5.个人所得税#6.资源税#7.固定资产投资方向调节税#8.城市维护建设税#9.房产税#10.印花税#其中：证券交易印花税#11.城镇土地使用税#12.土地增值税#13.车船税#14.车辆购置税#15.烟叶税#16.耕地占用税#17.契税#18.其他税收#二、其他收入合计#其中：教育费附加收入#废弃电器电子产品处理基金收入";
		colsHName[10] = "序号#项目#合计#代扣代收#委托代征";
		
		
		sjNum[11] = 3;
		colsL[11] = "HJ#NSBZJ#FPBZJ#NSDBJ#SSBQK#PMBMK#QT";
		colsH[11] = "XH#XM#NCYE#SRBY#SRBNLJ#ZCBY#ZCBNLJ#QMYE";
		colsLName[11] = "合计#纳税保证金#发票保证金#纳税担保金#税收保全款#拍卖变卖款#其他";
		colsHName[11] = "序号#项目#年初余额#收入本月#收入本年累计#支出本月#支出本年累计#期末余额";
		
		
		sjNum[12] = 2;
		colsL[12] = "ZJ#YSSSRHJ#1ZZS#2XFS#3YYS#4QYSDS#5GRSDS#6ZYS#7GDZCTZFXDJS#8CSWHJSS#9FCS#10YHS#11CZTDSYS#12TDZZS#13CCS#14CLGZS#15YYS#16GDZYS#17QS#18QTSS#EQTSRHJ";
		colsH[12] = "XH#XM#HJ#GTQYDZSJ#KKQYDZSJ#ZFZCXDZSJ#QT";
		colsLName[12] = "总计#一、税收收入合计#1.增值税#2.消费税#3.营业税#4.企业所得税#5.个人所得税#6.资源税#7.固定资产投资方向调节税#8.城市维护建设税#9.房产税#10.印花税#11.城镇土地使用税#12.土地增值税#13.车船税#14.车辆购置税#15.烟叶税#16.耕地占用税#17.契税#18.其他税收#二、其他收入合计";
		colsHName[12] = "序号#项目#合计#关、停企业呆帐税金#空壳企业呆帐税金#政府政策性呆帐税金#其他";


		sjNum[13] = 3;
		colsL[13] = "HJ#YJTYSFW#1LLYSFW#2SLYSFW#3HKYSFW#4GDYSFW#EYZFW#1YZPBFW#2YZTSFW#3QTYZFW#SDXFW#1JCDXFW#2ZZDXFW#SJZFW#1GCFW#2AZFW#3XSFW#4ZSFW#5QTJZFW#WJRFW#1DKFW#2ZJSFJRFW#3BXFW#4JRSPZR#LXDFW#1YFHJSFW#2XXJSFW#3WHCYFW#4WLFZFW#5ZLFW#6JZZXFW#7GBYSFW#8SWFZFW#9QTXDFW#QSHFW#1WHTYFW#2JYYLFW#3LYYLFW#4CYZSFW#5JMRCFW#6QTSHFW#BXSWXZC#1ZLHFZLJS#2SBHZZQ#3TDSYQ#4QTZRZYSYQ#5QTQYXWXZC#JXSBDC#1JZW#QZESFJY1#2GZW#QZESFJY2";
		colsH[13] = "XH#XM#RKSJ#YZSJNCYE#YZSJQMYE#DZSJNCYE#DZSJQMYE#TTSJ#JMSJ#DJSJ1#ZTSJ#DJSJ2#DCLSSSJ#SSSJHX";
		colsLName[13] = "合计#一、交通运输服务#1.陆路运输服务#2.水路运输服务#3.航空运输服务#4.管道运输服务#二、邮政服务#1.邮政普遍服务#2.邮政特殊服务#3.其他邮政服务#三、电信服务#1.基础电信服务#2.增值电信服务#四、建筑服务#1.工程服务#2.安装服务#3.修缮服务#4.装饰服务#5.其他建筑服务#五、金融服务#1.贷款服务#2.直接收费金融服务#3.保险服务#4.金融商品转让#六、现代服务#1.研发和技术服务#2.信息技术服务#3.文化创意服务#4.物流辅助服务#5.租赁服务#6.鉴证咨询服务#7.广播影视服务#8.商务辅助服务#9.其他现代服务#七、生活服务#1.文化体育服务#2.教育医疗服务#3.旅游娱乐服务#4.餐饮住宿服务#5.居民日常服务#6.其他生活服务#八、销售无形资产#1.专利或非专利技术#2.商标和著作权#3.土地使用权#4.其他自然资源使用权#5.其他权益性无形资产#九、销售不动产#1.建筑物#其中：二手房交易#2.构筑物#其中：二手房交易";
		colsHName[13] = "序号#项目#入库税金#应征税金年初余额#应征税金期末余额#待征税金年初余额#待征税金期末余额#提退税金#减免税金#多缴税金#在途税金#待解税金#待处理损失税金#损失税金核销";
		
		sjNum[14] = 3;
		colsL[14] = "HJ#QZBNXQ#WNCQ#GTJKKQYQS#1GNZZS#QZGZZZS#2GNXFS#3YYS#4QYSDS#5GRSDS#6ZYS#7GDZCTZFXDJS#8CSWHJSS#9FCS#10YHS#11CZTDSYS#12TDZZS#13CCS#14CLGZS#15YYS#16GDZYS#17QS#18QTSS";
		colsH[14] = "XH#XM#QMYEHJ#DFXQJRK#DFXQJDJ#DFXQJ#DFXQJQMYE#ZFXQJRK#ZFXQJDJ#ZFXQJHX#ZFXQJQMYE#GFXQJRK#GFXQJDJ#GFXQJHX#GFXQJQMYE#GWQJRK#GWQJDJ#GWQJHX#GWQJQMYE";
		colsLName[14] = "合计#其中：本年新欠#往年陈欠#关停及空壳企业欠税#1.国内增值税#其中：改征增值税#2.国内消费税#3.营业税#4.企业所得税#5.个人所得税#6.资源税#7.固定资产投资方向调节税#8.城市维护建设税#9.房产税#10.印花税#11.城镇土地使用税#12.土地增值税#13.车船税#14.车辆购置税#15.烟叶税#16.耕地占用税#17.契税#18.其他税收";
		colsHName[14] = "序号#项目#期末余额合计#低风险欠缴入库#低风险欠缴抵缴#低风险欠缴#低风险欠缴期末余额#中风险欠缴入库#中风险欠缴抵缴#中风险欠缴核销#中风险欠缴期末余额#高风险欠缴入库#高风险欠缴抵缴#高风险欠缴核销#高风险欠缴期末余额#高危欠缴入库#高危欠缴抵缴#高危欠缴核销#高危欠缴期末余额";
		
		
		//15表公式另外处理
		sjNum[15] = 0;
		colsL[15] = "";
		colsH[15] = "";
		colsLName[15] = "";
		colsHName[15] = "";
		
		sjNum[16] = 2;
		colsL[16] = "HJ#YNZQY#YGYQY#EJTQY#SGFHZQY#SLYQY#QZGYKG1#1GYLYQY#2JTLYQY#3GYYJTLYQY#4QTLYQY#WYXZRGS#QZGYKG2#1GYDZQY#2QTYXZRGS#LGFYXGS#QZ:GYKG#QSYQY#1SYDZQY#2SYHHQY#3SYYXZRGS#4SYGFYXGS#BQTQY#EGATSTZQY#QZGYKG3#1HZJYQYGHATZ#2HZJYQYGHATZ#3GATSDZJYQY#4GATSTZGFYXGS#5QTGATSTZQY#SWSTZQY#QZGYKG4#1ZWHZJYQY#2ZWHZJYQY#3WZQY#4WSTZGFYXGS#5QTWSTZQY#SGTJY#1GTH#2GRHH";
		colsH[16] = "XH#XM#SSSRHJ#GNZZS#QZ：YBNSR#GNXFS#YYS#QYSDS#GRSDS#ZYS#CSWHJSS#FCS#YHS#CZTDSYS#TDZZS#CCS#CLGZS#GDZYS#QS#QTSS";
		colsLName[16] = "合计#一、内资企业#(一)国有企业#(二)集体企业#(三)股份合作企业#(四)联营企业#其中:国有控股#1.国有联营企业#2.集体联营企业#3.国有与集体联营企业#4.其他联营企业#(五)有限责任公司#其中:国有控股#1.国有独资企业#2.其他有限责任公司#(六)股份有限公司#其中:国有控股#(七)私营企业#1.私营独资企业#2.私营合伙企业#3.私营有限责任公司#4.私营股份有限公司#(八)其它企业#二、港、澳、台商投资企业#其中:国有控股#1.合资经营企业（港或澳、台资）#2.合作经营企业（港或澳、台资）#3.港、澳、台商独资经营企业#4.港、澳、台商投资股份有限公司#5.其他港、澳、台商投资企业#三、外商投资企业#其中:国有控股#1.中外合资经营企业#2.中外合作经营企业#3.外资企业#4.外商投资股份有限公司#5.其他外商投资企业#四、个体经营#1.个体户#2.个人合伙";
		colsHName[16] = "序号#项目#税收收入合计#国内增值税#其中：一般纳税人#国内消费税#营业税#企业所得税#个人所得税#资源税#城市维护建设税#房产税#印花税#城镇土地使用税#土地增值税#车船税#车辆购置税#耕地占用税#契税#其他税收";
		
		sjNum[17] = 3;
		colsL[17] = "YZZSSRHJ#YGNZZS#1CKY#1MTKCHXXY#2SYHTRQKCY#QZYY#3HSJSKCXY#4YSJSKCXY#5FJSKCXY#6QTCKY#2ZZY#1NFSPJGY#2SPZZY#3JYLHJZCZZY#JDZZ#QZJJ#YLZZ#JZCZZ#4YCZPY#YYFK#JYZZ#QTYCZPZZ#5FZY#6FZFZFSY#QZJZFZZZ#7PGMPYMJQZPHZXY#QZPGMP#8MCJGJMZTZCZPY#9JJZZY#10ZZJZZPY#ZJZZ#ZZ#QZJZZJZBZZ#ZZPZZ#11YSHJLMJFZY#12WJGMTYHYLYPZZY#13SYJGLJHHRLJGY#YYJGJSYZPZZ#QZCPY#RZYYZZ#LJ#HRLJG#14HXYLJHXZPY#FLZZ#NYZZ#ZYHXCPZZ#RYHXCPZZ#QZHZPZZ#QT1#15YYZZY#16HXXWZZY#17XJHSLZPY#QZLTZZ#18FJSKWZPY#SNSHHSGZZ#QZSNZZ#SNJSGZPZZ#BLJBLZPZZ#QT2#19HSJSYLJYYJGY#QZGYYJG#20YSJSYLJYYJGY#21JSZPY#22TYSBZZY#23ZYSBZZY#24QCZZY#QZQCZCZZ#DCZZ#25TLCBHKHTHQTYSSBZZY#QZTLYSSBZZ#CBJXGZZZZ#HKHTJSBZZ#MTCZZ#26DQJXHQCZZY#DJZZ#DXDLGLJDGQCZZ#JYDLQJZZ#QT3#27JSJTXHQTDZSBZZY#JSJZZ#TXSBZZ#GBDSSBZZ#STSBZZ#QT4#28YBYQZZY#29QTZZY#3DLRLRQJSDSCHGYY#1DLRLSCHGYY#DLSC#QZHLFD#SLFD#HLFD#FLFD#TYNFD#DLGY#RLSCHGY#2RQSCHGYY#3SDSCHGYY#4PFHLSY#1PFY#SPYLJYCZPPF#QZYCZPPF#FZFZJJTYPPF#KCPJCJHGCPPF#QZMTJZPPF#SYJZPPF#JCPF#JXSBWJJDJDZCPPF#QZQCPF#MTCJLPJPF#DQSBPF#JSJRJJFZSBPF#QT5#2LSY#5JTYSCCHYZY#1JTYSY#TLYSY#DLYSY#SSYSY#HKYSY#GDYSY#ZXBYHYSDLY#2CCY#3YZY#6ZSHCYY#1ZSY#2CYY#7XXCSRJHXXJSFWY#1DXGBDSHWXCSFWY#QZDX#2HLWHXGFW#3RJHXXJSFWY#8JRY#1HBJRFW#QZYX#JRZL#2ZBSCFW#3BXY#4QTJRY#9FDCY#1FDCKFJYY#2WYGL#3FDCZJFW#4ZYFDCJYHD#5QTFDCY#10ZLHSWFWY#1ZLY#2SWFWY#QZZXYDC#GGY#ZSCQFW#HYJZLFW#11KXYJHJSFWY#1YJHSYFZ#2ZYJSFWY#QZZYHSJFW#3KJTGHYYFWY#12JMFWXLHQTFWY#QZJMFWY#JDCDZCPHRYCPXLY#13JY#14WSHSHGZ#QZWS#15WHTYHYLY#QZXWHCBY#GBDSDYHYSLYZZY#TY#YLY#16GGGLSHBZHSHZZ#17JZY#1FWJZY#2TMGCJZY#3JZAZY#4JZZSHQTJZY#18SLHJHGGSSGLY#QZGGSSGLY#19QTXY#EJKHWZZS#ECKTZZSHJ";
		colsH[17] = "XH#XM#HJ#QZMDDK#NZQYXJ#NZQYGYQY#NZQYJTQY#NZQYGFHZQY#NZQYLYQY#NZQYQZGYKG1#NZQYGFGS#NZQYQZGYKG2#NZQYSYQY#NZQYQTQY#GATTZQY#QZGYKG1#WSTZQY#QZGYKG2#GTJY#FLZLGDZCJXSE#SJDKZZS#DDKGDZCJXSE";
		colsLName[17] = "一、增值税收入合计#(一)国内增值税#1.采矿业#(1)煤炭开采和洗选业#(2)石油和天然气开采业#其中：原油#(3)黑色金属矿采选业#(4)有色金属矿采选业#(5)非金属矿采选业#(6)其他采矿业#2.制造业#(1)农副食品加工业#(2)食品制造业#(3)酒、饮料和精制茶制造业#①酒的制造#其中：酒精#②饮料制造#③精制茶制造#(4)烟草制品业#①烟叶复烤#②卷烟制造#③其他烟草制品制造#(5)纺织业#(6)纺织服装、服饰业#其中：机织服装制造#(7)皮革、毛皮、羽毛及其制品和制鞋业#其中：皮革、毛皮#(8)木材加工及木竹藤棕草制品业#(9)家具制造业#(10)造纸及纸制品业#①纸浆制造#②造纸#其中：机制纸及纸板制造#③纸制品制造#(11)印刷和记录媒介复制业#(12)文教、工美、体育和娱乐用品制造业#(13)石油加工、炼焦和核燃料加工业#①原油加工及石油制品制造#其中：成品油#②人造原油制造#③炼焦#④核燃料加工#(14)化学原料及化学制品业#①肥料制造#②农药制造#③专用化学产品制造#④日用化学产品制造#其中：化妆品制造#⑤其他#(15)医药制造业#(16)化学纤维制造业#(17)橡胶和塑料制品业#其中：轮胎制造#(18)非金属矿物制品业#①水泥、石灰和石膏制造#其中：水泥制造#②水泥及石膏制品制造#③玻璃及玻璃制品制造#④其他#(19)黑色金属冶炼及压延加工业#其中：钢压延加工#(20)有色金属冶炼及压延加工业#(21)金属制品业#(22)通用设备制造业#(23)专用设备制造业#(24)汽车制造业#其中：汽车整车制造#电车制造#(25)铁路、船舶、航空航天和其他运输设备制造业#其中：铁路运输设备制造#船舶及相关装置制造#航空、航天及设备制造#摩托车制造#(26)电气机械和器材制造业#①电机制造#②电线电缆光缆及电工器材制造#③家用电力器具制造#④其他#(27)计算机、通信和其他电子设备制造业#①计算机制造#②通信设备制造#③广播电视设备制造#④视听设备制造#⑤其他#(28)仪表仪器制造业#(29)其他制造业#3.电力、热力、燃气及水的生产和供应业#(1)电力、热力生产和供应业#①电力生产#其中：火力发电#水力发电#核力发电#风力发电#太阳能发电#②电力供应#③热力生产和供应#(2)燃气生产和供应业#(3)水的生产和供应业#4.批发和零售业#(1)批发业#①食品、饮料及烟草制品批发#其中:烟草制品批发#②纺织、服装及家庭用品批发#③矿产品、建材及化工产品批发#其中：煤炭及制品批发#石油及制品批发#建材批发#④机械设备、五金交电及电子产品批发#其中：汽车批发#摩托车及零配件批发#电气设备批发#计算机、软件及辅助设备批发#⑤其他#(2)零售业#5.交通运输、仓储和邮政业#(1)交通运输业#铁路运输业#道路运输业#水上运输业#航空运输业#管道运输业#装卸搬运和运输代理业#(2)仓储业#(3)邮政业#6.住宿和餐饮业#(1)住宿业#(2)餐饮业#7.信息传输、软件和信息技术服务业#(1)电信、广播电视和卫星传输服务业#其中：电信#(2)互联网和相关服务#(3)软件和信息技术服务业#8.金融业#(1)货币金融服务#其中：银行#金融租赁#(2)资本市场服务#(3)保险业#(4)其他金融业#9.房地产业#(1)房地产开发经营业#(2)物业管理#(3)房地产中介服务#(4)自有房地产经营活动#(5)其他房地产业#10.租赁和商务服务业#(1)租赁业#(2)商务服务业#其中：咨询与调查#广告业#知识产权服务#会议及展览服务#11.科学研究和技术服务业#(1)研究和实验发展#(2)专业技术服务业#其中：专业化设计服务#(3)科技推广和应用服务业#12.居民服务、修理和其他服务业#其中：居民服务业#机动车、电子产品和日用产品修理业#13.教育#14.卫生和社会工作#其中：卫生#15.文化、体育和娱乐业#其中：新闻和出版业#广播、电视、电影和影视录音制作业#体育#娱乐业#16.公共管理、社会保障和社会组织#17.建筑业#(1)房屋建筑业#(2)土木工程建筑业#(3)建筑安装业#(4)建筑装饰和其他建筑业#18.水利、环境和公共设施管理业#其中：公共设施管理业#19.其他行业#(二)进口货物增值税#二、出口退增值税合计";
		colsHName[17] = "序号#项目#合计#其中:免抵调库#内资企业小计#内资企业国有企业#内资企业集体企业#内资企业股份合作企业#内资企业联营企业#内资企业其中：国有控股#内资企业股份公司#内资企业其中：国有控股#内资企业私营企业#内资企业其它企业#港澳台投资企业#其中：国有控股#外商投资企业#其中：国有控股#个体经营#附列资料：固定资产进项税额#实际抵扣增值税#待抵扣固定资产进项税额";
		
		sjNum[18] = 3;
		colsL[18] = "YXFSSR#YGNXFS#1JJJJ#1BJ#2HJ#3PJ#4QTJ#5JJ#2Y#1GYJY#QZA56SLZS#A36SLZS#2XQY#3YS#4SYPFJY#3CPY#1QY#2CY#3SNY#4RJY#5RHY#6RLY#7HKMY#4XQC#1CYC#A1SLZS#A3SLZS#A5SLZS#A9SLZS#A12SLZS#A25SLZS#A40SLZS#2ZQXSYKC#3CHHXQC#5MTC#6GEFQJQJ#7QCLT#8GDHZP#9GZSS#10BPYH#11GDSB#12YT#13MZYCXKZ#14SMDB#15DC#16TL#17QT#18SKZNJFKSR#EJKXFPXFS#ECKXFPTXFS";
		colsH[18] = "XH#XM#HJ#NZQYXJ#NZQYGYQY#NZQYJTQY#NZQYGFHZQY#NZQYLYQY#NZQYQZGYKG1#NZQYGFGS#NZQYQZGYKG2#NZQYSYQY#NZQYQTQY#GATTZQY#QZGYKG1#WSTZQY#QZGYKG2#GTJY";
		colsLName[18] = "一、消费税收入#(一)国内消费税#1.酒及酒精#(1)白酒#(2)黄酒#(3)啤酒#(4)其他酒#(5)酒精#2.烟#(1)工业卷烟#其中：按56%税率征收#按36%税率征收#(2)雪茄烟#(3)烟丝#(4)商业批发卷烟#3.成品油#(1)汽油#(2)柴油#(3)石脑油#(4)溶剂油#(5)润滑油#(6)燃料油#(7)航空煤油#4.小汽车#(1)乘用车#按1%税率征收#按3%税率征收#按5%税率征收#按9%税率征收#按12%税率征收#按25%税率征收#按40%税率征收#(2)中轻型商用客车#(3)超豪华小汽车#5.摩托车#6.高尔夫球及球具#7.汽车轮胎#8.高档化妆品#9.贵重首饰#10.鞭炮焰火#11.高档手表#12.游艇#13.木制一次性筷子#14.实木地板#15.电池#16.涂料#17.其他#18.税款滞纳金罚款收入#(二)进口消费品消费税#二、出口消费品退消费税";
		colsHName[18] = "序号#项目#合计#内资企业小计#内资企业国有企业#内资企业集体企业#内资企业股份合作企业#内资企业联营企业#内资企业其中：国有控股#内资企业股份公司#内资企业其中：国有控股#内资企业私营企业#内资企业其它企业#港澳台投资企业#其中：国有控股#外商投资企业#其中：国有控股#个体经营";
		
		
		//19表公式另外处理
		sjNum[19] = 0;
		colsL[19] = "ZJ#YCKY#1MTKCHXXY#2SYHTRQKCY#QZYY#3HSJSKCXY#4YSJSKCXY#5FJSKCXY#6QTCKY#EZZY#1NFSPJGY#2SPZZY#3JYLHJZCZZY#JDZZ#QZJJ#YLZZ#JZCZZ#4YCZPY#YYFK#JYZZ#QTYCZPJG#5FZY#6FZFZFSY#QZFZFZ#7PGMPYMJQZPHZXY#QZPGMP#8MCJGHMZTZCZPY#9JJZZY#10ZZHZZPY#ZJZZ#ZZ#QZJZZJZBZZ#ZZPZZ#11YSHJLMJFZY#12WJGMTYHYLYPZZY#13SYJGLJHHRLJGY#QZCPY#14HXYLHHXZPZZY#FLZZ#NYZZ#ZYHXCPZZ#RYHXCPZZ#QZHZPZZ#QT1#15YYZZY#16HXXWZZY#17XJHSLZPY#QZLTZZ#18FJSKWZPY#SNSHHSGZZ#QZSNZZ#SNJSGZPZZ#BLJBLZPZZ#QT2#19HSJSYLHYYJGY#QZGYYJG#20YSJSYLHYYJGY#21JSZPY#22TYSBZZY#23ZYSBZZY#24QCZZY#25TLCBHKHTHQTYSSBZZY#QZTLYSSBZZ#CBJXGZZZZ#HKHTJSBZZ#MTCZZ#26DQJXHQCZZY#DJZZ#DXDLGLJDGQCZZ#JYDLQJZZ#QT3#27JSJTXHQTDZSBZZY#JSJZZ#TXSBZZ#GBDSSBZZ#STSBZZ#QT#28YBYQZZY#29QTZZY#SDLRLRQJSDSCHGYY#1DLRLSCHGYY#DLSC#QZHLFD#SLFD#HLFD#FLFD#TYNFD#DLGY#RLSCHGYY#2RQSCHGYY#3SDSCHGYY#SJZY#1FWJZY#2TMGCJZY#3JZAZY#4JZZSHQTJZY#WPFHLSY#1PFY#QZYCZPPF#MTJZPPF#SYJQZPPF#QCJLPJPF#2LSY#LJTYSCCHYZY#1JTYSY#2CCY#3YZY#QZSHCYY#1ZSY#2CYY#BXXCSRJHXXJSFWY#1DXGBDSHWXCSFWY#QZDX#2HLWHXGFW#3RJHXXJSFWY#JJRY#1HBJRFW#QZYX#JRZL#2ZBSCFW#3BXY#4QTJRY#SFDCY#SYZLHSWFWY#1ZLY#2SWFWY#SEKXYJHJSFWY#SSJMFWXLHQTFWY#QZJMFWY#JDCDZCPHRYCPXLY#SSJY#SWWSHSHGZ#QZWS#SLWHTYHYLY#QZXWHCBY#GBDSDYHYSLYZZY#TY#YLY#SQGGGLSHBZHSHZZ#SBQTXY";
		colsH[19] = "XH#XM#HJ#NZQYXJ#NZQYGYQY#NZQYJTQY#NZQYGFHZQY#NZQYLYQY#NZQYQZGYKG1#NZQYGFGS#NZQYQZGYKG2#NZQYSYQY#NZQYQTQY#GATTZQY#QZGYKG1#WSTZQY#QZGYKG2";
		colsLName[19] = "总计#(一)采矿业#1.煤炭开采和洗选业#2.石油和天然气开采业#其中:原油#3.黑色金属矿采选业#4.有色金属矿采选业#5.非金属矿采选业#6.其他采矿业#(二)制造业#1.农副食品加工业#2.食品制造业#3.酒、饮料和精制茶制造业#①酒的制造#其中：酒精#②饮料制造#③精制茶制造#4.烟草制品业#烟叶复考#卷烟制造#其他烟草制品加工#5.纺织业#6.纺织服装、服饰业#其中：纺织服装#7.皮革、毛皮、羽毛及其制品和制鞋业#其中：皮革、毛皮#8.木材加工和木竹藤棕草制品业#9.家具制造业#10.造纸和纸制品业#①纸浆制造#②造纸#其中：机制纸及纸板制造#③纸制品制造#11.印刷和记录媒介复制业#12.文教、工美、体育和娱乐用品制造业#13.石油加工、炼焦和核燃料加工业#其中：成品油#14.化学原料和化学制品制造业#①肥料制造#②农药制造#③专用化学产品制造#④日用化学产品制造#其中：化妆品制造#⑤其他#15.医药制造业#16.化学纤维制造业#17.橡胶和塑料制品业#其中：轮胎制造#18.非金属矿物制品业#①水泥、石灰和石膏制造#其中：水泥制造#②水泥及石膏制品制造#③玻璃及玻璃制品制造#④其他#19.黑色金属冶炼和压延加工业#其中：钢压延加工#20.有色金属冶炼和压延加工业#21.金属制品业#22.通用设备制造业#23.专用设备制造业#24.汽车制造业#25.铁路、船舶、航空航天和其他运输设备制造业#其中：铁路运输设备制造#船舶及相关装置制造#航空、航天及设备制造#摩托车制造#26.电气机械和器材制造业#①电机制造#②电线电缆光缆及电工器材制造#③家用电力器具制造#④其他#27.计算机、通信和其他电子设备制造业#①计算机制造#②通信设备制造#③广播电视设备制造#④视听设备制造#⑤其他#28.仪表仪器制造业#29.其他制造业#(三)电力、热力、燃气及水的生产和供应业#1.电力、热力生产和供应业#①电力生产#其中：火力发电#水力发电#核力发电#风力发电#太阳能发电#②电力供应#③热力生产和供应业#2.燃气生产和供应业#3.水的生产和供应业#(四)建筑业#1.房屋建筑业#2.土木工程建筑业#3.建筑安装业#4.建筑装饰和其他建筑业#(五)批发和零售业#1.批发业#其中:烟草制品批发#煤炭及制品批发#石油及其制品批发#汽车及零配件批发#2.零售业#(六)交通运输、仓储和邮政业#1.交通运输业#2.仓储业#3.邮政业#(七)住宿和餐饮业#1.住宿业#2.餐饮业#（八）信息传输、软件和信息技术服务业#1.电信、广播电视和卫星传输服务业#其中：电信#2.互联网和相关服务#3.软件和信息技术服务业#(九)金融业#1.货币金融服务#其中：银行#金融租赁#2.资本市场服务#3.保险业#4.其他金融业#(十)房地产业#(十一)租赁和商务服务业#1.租赁业#2.商务服务业#(十二）科学研究和技术服务业#(十三）居民服务、修理和其他服务业#其中：居民服务业#机动车、电子产品和日用产品修理业#(十四)教育#(十五)卫生和社会工作#其中：卫生#(十六)文化、体育和娱乐业#其中：新闻和出版业#广播、电视、电影和影视录音制作业#体育#娱乐业#(十七)公共管理、社会保障和社会组织#(十八)其他行业";
		colsHName[19] = "序号#项目#合计#内资企业小计#内资企业国有企业#内资企业集体企业#内资企业股份合作企业#内资企业联营企业#内资企业其中：国有控股#内资企业股份公司#内资企业其中：国有控股#内资企业私营企业#内资企业其它企业#港澳台投资企业#其中：国有控股#外商投资企业#其中：国有控股";
		
		
		sjNum[20] = 2;
		colsL[20] = "ZJ#YCKY#1MTKCHXXY#2SYHTRQKCY#QZYY#3HSJSKCXY#4YSJSKCXY#5FJSKCXY#6QTCKY#EZZY#1NFSPJGY#2SPZZY#3JYLHJZCZZY#JDZZ#QZJJ#YLZZ#JZCZZ#4YCZPY#YYFK#JYZZ#QTYCZPJG#5FZY#6FZFZFSY#QZFZFZ#7PGMPYMJQZPHZXY#QZPGMP#8MCJGHMZTZCZPY#9JJZZY#10ZZHZZPY#ZJZZ#ZZ#QZJZZJZBZZ#ZZPZZ#11YSHJLMJFZY#12WJGMTYHYLYPZZY#13SYJGLJHHRLJGY#QZCPY#14HXYLHHXZPZZY#FLZZ#NYZZ#ZYHXCPZZ#RYHXCPZZ#QZHZPZZ#QT1#15YYZZY#16HXXWZZY#17XJHSLZPY#QZLTZZ#18FJSKWZPY#SNSHHSGZZ#QZSNZZ#SNJSGZPZZ#BLJBLZPZZ#QT2#19HSJSYLHYYJGY#QZGYYJG#20YSJSYLHYYJGY#21JSZPY#22TYSBZZY#23ZYSBZZY#24QCZZY#25TLCBHKHTHQTYSSBZZY#QZTLYSSBZZ#CBJXGZZZZ#HKHTJSBZZ#MTCZZ#26DQJXHQCZZY#DJZZ#DXDLGLJDGQCZZ#JYDLQJZZ#QT3#27JSJTXHQTDZSBZZY#JSJZZ#TXSBZZ#GBDSSBZZ#STSBZZ#QT#28YBYQZZY#29QTZZY#SDLRLRQJSDSCHGYY#1DLRLSCHGYY#DLSC#QZHLFD#SLFD#HLFD#FLFD#TYNFD#DLGY#RLSCHGYY#2RQSCHGYY#3SDSCHGYY#SJZY#1FWJZY#2TMGCJZY#3JZAZY#4JZZSHQTJZY#WPFHLSY#1PFY#QZYCZPPF#MTJZPPF#SYJQZPPF#QCJLPJPF#2LSY#LJTYSCCHYZY#1JTYSY#2CCY#3YZY#QZSHCYY#1ZSY#2CYY#BXXCSRJHXXJSFWY#1DXGBDSHWXCSFWY#QZDX#2HLWHXGFW#3RJHXXJSFWY#JJRY#1HBJRFW#QZYX#JRZL#2ZBSCFW#3BXY#4QTJRY#SFDCY#SYZLHSWFWY#1ZLY#2SWFWY#SEKXYJHJSFWY#SSJMFWXLHQTFWY#QZJMFWY#JDCDZCPHRYCPXLY#SSJY#SWWSHSHGZ#QZWS#SLWHTYHYLY#QZXWHCBY#GBDSDYHYSLYZZY#TY#YLY#SQGGGLSHBZHSHZZ#SBQTXY";
		colsH[20] = "XH#XM#HJ#YJ#HSQJ#JNYQNDQS";
		colsLName[20] = "总计#(一)采矿业#1.煤炭开采和洗选业#2.石油和天然气开采业#其中:原油#3.黑色金属矿采选业#4.有色金属矿采选业#5.非金属矿采选业#6.其他采矿业#(二)制造业#1.农副食品加工业#2.食品制造业#3.酒、饮料和精制茶制造业#①酒的制造#其中：酒精#②饮料制造#③精制茶制造#4.烟草制品业#烟叶复考#卷烟制造#其他烟草制品加工#5.纺织业#6.纺织服装、服饰业#其中：纺织服装#7.皮革、毛皮、羽毛及其制品和制鞋业#其中：皮革、毛皮#8.木材加工和木竹藤棕草制品业#9.家具制造业#10.造纸和纸制品业#①纸浆制造#②造纸#其中：机制纸及纸板制造#③纸制品制造#11.印刷和记录媒介复制业#12.文教、工美、体育和娱乐用品制造业#13.石油加工、炼焦和核燃料加工业#其中：成品油#14.化学原料和化学制品制造业#①肥料制造#②农药制造#③专用化学产品制造#④日用化学产品制造#其中：化妆品制造#⑤其他#15.医药制造业#16.化学纤维制造业#17.橡胶和塑料制品业#其中：轮胎制造#18.非金属矿物制品业#①水泥、石灰和石膏制造#其中：水泥制造#②水泥及石膏制品制造#③玻璃及玻璃制品制造#④其他#19.黑色金属冶炼和压延加工业#其中：钢压延加工#20.有色金属冶炼和压延加工业#21.金属制品业#22.通用设备制造业#23.专用设备制造业#24.汽车制造业#25.铁路、船舶、航空航天和其他运输设备制造业#其中：铁路运输设备制造#船舶及相关装置制造#航空、航天及设备制造#摩托车制造#26.电气机械和器材制造业#①电机制造#②电线电缆光缆及电工器材制造#③家用电力器具制造#④其他#27.计算机、通信和其他电子设备制造业#①计算机制造#②通信设备制造#③广播电视设备制造#④视听设备制造#⑤其他#28.仪表仪器制造业#29.其他制造业#(三)电力、热力、燃气及水的生产和供应业#1.电力、热力生产和供应业#①电力生产#其中：火力发电#水力发电#核力发电#风力发电#太阳能发电#②电力供应#③热力生产和供应业#2.燃气生产和供应业#3.水的生产和供应业#(四)建筑业#1.房屋建筑业#2.土木工程建筑业#3.建筑安装业#4.建筑装饰和其他建筑业#(五)批发和零售业#1.批发业#其中:烟草制品批发#煤炭及制品批发#石油及其制品批发#汽车及零配件批发#2.零售业#(六)交通运输、仓储和邮政业#1.交通运输业#2.仓储业#3.邮政业#(七)住宿和餐饮业#1.住宿业#2.餐饮业#（八）信息传输、软件和信息技术服务业#1.电信、广播电视和卫星传输服务业#其中：电信#2.互联网和相关服务#3.软件和信息技术服务业#(九)金融业#1.货币金融服务#其中：银行#金融租赁#2.资本市场服务#3.保险业#4.其他金融业#(十)房地产业#(十一)租赁和商务服务业#1.租赁业#2.商务服务业#(十二）科学研究和技术服务业#（十三）居民服务、修理和其他服务业#其中：居民服务业#机动车、电子产品和日用产品修理业#(十四)教育#（十五）卫生和社会工作#其中：卫生#(十六)文化、体育和娱乐业#其中：新闻和出版业#广播、电视、电影和影视录音制作业#体育#娱乐业#(十七)公共管理、社会保障和社会组织#(十八)其他行业";
		colsHName[20] = "序号#项目#合计#预缴#汇算清缴#缴纳以前年度欠税";
		
		sjNum[21] = 2;
		colsL[21] = "ZJ#1GZXJSD#A3SLZS#A10SLZS1#A20SLZS1#A25SLZS#A30SLZS1#A35SLZS1#A45SLZS#2GTGSHSCJYSD#A5SLZS1#A10SLZS2#A20SLZS2#A30SLZS2#A35SLZS2#HDZS1#3QSYDWCBCZJYSD#A5SLZS#A10SLZS#A20SLZS3#A30SLZS3#A35SLZS#HDZS#4LWBCSD#A20SLZS#A30SLZS#A40SLZS#5GCSD#6TXQSYFSD#7LXGXHLSD#QZCXCKLXSD#8CCZLSD#9CCZRSD#QZXSGZRSD#FWZRSD#10ORSD#11QTSD#12SKZNJFKSR";
		colsH[21] = "XH#XM#HJ#DL#GAT#WG";
		colsLName[21] = "总计#1、工资、薪金所得#按3%税率征收#按10%税率征收#按20%税率征收#按25%税率征收#按30%税率征收#按35%税率征收#按45%税率征收#2、个体工商户生产、经营所得#按5%税率征收#按10%税率征收#按20%税率征收#按30%税率征收#按35%税率征收#核定征收#3、企事业单位承包、承租经营所得#按5%税率征收#按10%税率征收#按20%税率征收#按30%税率征收#按35%税率征收#核定征收#4、劳务报酬所得#按20%税率征收#按30%税率征收#按40%税率征收#5、稿酬所得#6、特许权使用费所得#7、利息、股息、红利所得#其中：储蓄存款利息所得#8、财产租赁所得#9、财产转让所得#其中：限售股转让所得#房屋转让所得#10、偶然所得#11、其他所得#12、税款滞纳金、罚款收入";
		colsHName[21] = "序号#项目#合计#大陆#港澳台#外国";
		
		sjNum[22] = 3;
		colsL[22] = "ZJ#YNYK#1MT#2YY#3TRQ#4MCCQ#5DR#6QTNYK#EJSK#1TK#2JK#3TK#4LTK#5QXK#6NK#7XK#8ZZXTK#9QXTK#10WK#11ZK#12MK#13YK#14QTJSK#SFJSK#1SM#2GZT#3GLT#4YS#5SHS#6LTK#7LK#8LHJ#9LSJ#10ZT#11SS#12JKY#13HY#14HY#15DXLSSZDY#16KQS#17DLY#18HGY#19NHZT#20MX#21QTFJSK#SSZY#1DBS#2DXS#WQT#LSKZNJFKSR";
		colsH[22] = "XH#XM#HJ#NZQYXJ#NZQYGYQY#NZQYJTQY#NZQYGFHZQY#NZQYLYQY#NZQYQZGYKG1#NZQYGFGS#NZQYQZGYKG2#NZQYSYQY#NZQYQTQY#GATTZQY#QZGYKG1#WSTZQY#QZGYKG2#GTJY";
		colsLName[22] = "总计#一、能源矿#1.煤炭#2.原油#3.天然气#4.煤层（成）气#5.地热#6.其他能源矿#二、金属矿#1.铁矿#2.金矿#3.铜矿#4.铝土矿#5.铅锌矿#6.镍矿#7.锡矿#8.中重稀土矿#9.轻稀土矿#10.钨矿#11.钼矿#12.锰矿#13.银矿#14.其他金属矿#三、非金属矿#1.石墨#2.硅藻土#3.高岭土#4.萤石#5.石灰石#6.硫铁矿#7.磷矿#8.氯化钾#9.硫酸钾#10.粘土#11.砂石#12.井矿盐#13.湖盐#14.海盐#15.地下卤水晒制的盐#16.矿泉水#17.大理岩#18.花岗岩#19.耐火粘土#20.芒硝#21.其他非金属矿#四、水资源#1.地表水#2.地下水#五、其他#六、税款滞纳金、罚款收入";
		colsHName[22] = "序号#项目#合计#内资企业小计#内资企业国有企业#内资企业集体企业#内资企业股份合作企业#内资企业联营企业#内资企业其中：国有控股#内资企业股份公司#内资企业其中：国有控股#内资企业私营企业#内资企业其它企业#港澳台投资企业#其中：国有控股#外商投资企业#其中：国有控股#个体经营";
		
		sjNum[23] = 2;
		colsL[23] = "YSWSSSR1#YZWHZJYQY2#1CKY3#2ZZY4#3DLRLRQJSDSCHGYY5#4JZY6#5PFHLSY7#6JTYSCCHYZY8#7ZSHCYY9#8XXCSRJHXXJSFWY10#9JRY11#10FDCY12#11ZLHSWFWY13#12KXYJHJSFWY14#13WHTYHYLY15#14QTXY16#EZWHZJYQY17#1CKY18#2ZZY19#3DLRLRQJSDSCHGYY20#4JZY21#5PFHLSY22#6JTYSCCHYZY23#7ZSHCYY24#8XXCSRJHXXJSFWY25#9JRY26#10FDCY27#11ZLHSWFWY28#12KXYJHJSFWY29#13WHTYHYLY30#14QTXY31#SWZQY32#1CKY33#2ZZY34#3DLRLRQJSDSCHGYY35#4JZY36#5PFHLSY37#6JTYSCCHYZY38#7ZSHCYY39#8XXCSRJHXXJSFWY40#9JRY41#10FDCY42#11ZLHSWFWY43#12KXYJHJSFWY44#13WHTYHYLY45#14QTXY46#SFJMQY47#1WGQYCZDBJG48#2TGLWCBGCZY49#3JRHBX50#4GJYSSR51#5ZFDWKJ52#6QT53#WWJGR54#LJKHWSS55#ECKHWTS56";
		colsH[23] = "XH#XM#HJ#ZZS#XFS#YYS#QYSDS#GRSDS#CSWHJSS#FCS#CZTDSYS#CCS#QTGS";
		colsLName[23] = "一、涉外税收收入#（一）中外合资经营企业#1、采矿业#2、制造业#3、电力、热力、燃气及水的生产和供应业#4、建筑业#5、批发和零售业#6、交通运输、仓储和邮政业#7、住宿和餐饮业#8、信息传输、软件和信息技术服务业#9、金融业#10、房地产业#11、租赁和商务服务业#12、科学研究和技术服务业#13、文化、体育和娱乐业#14、其他行业#(二)中外合作经营企业#1、采矿业#2、制造业#3、电力、热力、燃气及水的生产和供应业#4、建筑业#5、批发和零售业#6、交通运输、仓储和邮政业#7、住宿和餐饮业#8、信息传输、软件和信息技术服务业#9、金融业#10、房地产业#11、租赁和商务服务业#12、科学研究和技术服务业#13、文化、体育和娱乐业#14、其他行业#(三)外资企业#1、采矿业#2、制造业#3、电力、热力、燃气及水的生产和供应业#4、建筑业#5、批发和零售业#6、交通运输、仓储和邮政业#7、住宿和餐饮业#8、信息传输、软件和信息技术服务业#9、金融业#10、房地产业#11、租赁和商务服务业#12、科学研究和技术服务业#13、文化、体育和娱乐业#14、其他行业#(四)非居民企业#1、外国企业常驻代表机构#2、提供劳务、承包工程作业#3、金融和保险#4、国际运输收入#5、支付单位扣缴#6、其他#(五)外籍个人#(六)进口货物税收#二、出口货物退税";
		colsHName[23] = "序号#项目#合计#增值税#消费税#营业税#企业所得税#个人所得税#城市维护建设税#房产税#城镇土地使用税#车船税#其他各税";
		
		sjNum[24] = 2;
		colsL[24] = "ZJ#BNXQ#WNCQ#1GNZZS#1YCZPY#QZJY#2JZZY#3FZY#4YYJGJSYZPZZY#QZCPY#5HXYLHHXZPZZY#6FJSKWZPY#7HSJSYLJYYJGY#QZGPGC#8QCZZY#9MTCZZY#10MTKCHXXY#11YYHTRQKC#QZYY#12DLSCHGYY#13JZY#14JTYSY#QZTLYSFW#LLYSFW#SLYSFW#HKYSFW#GDYSFW#15YZY#16DXY#17JRY#QZHBJRFW#ZBSCFW#BXY#18FDCY#QZFDCKFJYY#19KXYJHJSFWY#2GNXFS#QZ1JJJJ#J#JJ#2Y#JY#XQY#YS#3CPY#4XQC#5MTC#3YYS#4QYSDS#5CSWHJSS#6QTGS";
		colsH[24] = "XH#XM#HJ#GYQY#JTQY#GFHZQY#LYQY#QZGYKG1#GFGS#QZGYKG2#SYQY#GATTZQY#QZGYKG3#WSTZQY#QZGYKG4#QTQY#GTJKKQY";
		colsLName[24] = "总计#本年新欠#往年陈欠#1、国内增值税#（1）烟草制品业#其中卷烟#（2）酒制造业#（3）纺织业#（4）原油加工及石油制品制造业#其中：成品油#（5）化学原料和化学制品制造业#（6）非金属矿物制品业#（7）黑色金属冶炼及压延加工业#其中:钢坯、钢材#(8)汽车制造业#(9)摩托车制造业#(10)煤炭开采和洗选业#(11)原油和天然气开采#其中:原油#(12)电力生产和供应业#（13）建筑业#(14)交通运输业#其中：铁路运输服务#陆路运输服务#水路运输服务#航空运输服务#管道运输服务#(15)邮政业#(16)电信业#(17)金融业#其中：货币金融服务#资本市场服务#保险业#（18）房地产业#其中：房地产开发经营业#(19）科学研究和技术服务业#2、国内消费税#其中：(1)酒及酒精#酒#酒精#（2）烟#卷烟#雪茄烟#烟丝#（3）成品油#(4)小汽车#(5)摩托车#3、营业税#4、企业所得税#5、城市维护建设税#6、其他各税";
		colsHName[24] = "序号#项目#合计#国有企业#集体企业#股份合作企业#联营企业#其中：国有控股#股份公司#其中：国有控股#私营企业#港澳台投资企业#其中：国有控股#外商投资企业#其中：国有控股#其他企业#关、停及空壳企业";
		
		sjNum[25] = 3;
		colsL[25] = "QMYEZJ#QMYE1GNZZS#QMYE2GNXFS#QMYE3YYS#QMYE4QYSDS#QMYE5GRSDS#QMYE6ZYS#QMYE7GDTZFXDJS#QMYE8CSWHJSS#QMYE9FCS#QMYE10YHS#QMYE11CSTDSYS#QMYE12TDZZS#QMYE13CCS#QMYE14CLGZS#QMYE15YYS#QMYE16GDZYS#QMYE17QS#QMYE18QTSS#DNRKZJ#DNRK1GNZZS#DNRK2GNXFS#DNRK3YYS#DNRK4QYSDS#DNRK5GRSDS#DNRK6ZYS#DNRK7GDTZFXDJS#DNRK8CSWHJSS#DNRK9FCS#DNRK10YHS#DNRKCSTDSYS#DNRKTDZZS#DNRKCCS#DNRKCLGZS#DNRKYYS#DNRKGDZYS#DNRKQS#DNRKQTSS";
		colsH[25] = "XH#XM1#XM2#QSHJ#1WNCQXJ#2WNCQ5NYS#3WNCQ2012N#4WNCQ2013N#5WNCQ2014N#6WNCQ2015N#7WNCQ2016N#2BNXQ#3GTJKKQYQSWN#4GTJKKQYQSBN";
		colsLName[25] = "期末余额总计#期末余额1.国内增值税#期末余额2.国内消费税#期末余额3.营业税#期末余额4.企业所得税#期末余额5.个人所得税#期末余额6.资源税#期末余额7.固定投资方向调节税#期末余额8.城市维护建设税#期末余额9.房产税#期末余额10.印花税#期末余额11.城市土地使用税#期末余额12.土地增值税#期末余额13.车船税#期末余额14.车辆购置税#期末余额15.烟叶税#期末余额16.耕地占用税#期末余额17.契税#期末余额18.其他税收#当年入库总计#当年入库1.国内增值税#当年入库2.国内消费税#当年入库3.营业税#当年入库4.企业所得税#当年入库5.个人所得税#当年入库6.资源税#当年入库7.固定投资方向调节税#当年入库8.城市维护建设税#当年入库9.房产税#当年入库10.印花税#当年入库城市土地使用税#当年入库土地增值税#当年入库车船税#当年入库车辆购置税#当年入库烟叶税#当年入库耕地占用税#当年入库契税#当年入库其他税收";
		colsHName[25] = "序号#项目#项目#欠税合计#1.往年陈欠小计#2.往年陈欠5年以上#3.往年陈欠2012年#4.往年陈欠2013年#5.往年陈欠2014年#6.往年陈欠2015年#7.往年陈欠2016年#2.本年新欠#3.关停及空壳企业欠税往年#4.关停及空壳企业欠税本年";
		
		sjNum[26] = 2;
		colsL[26] = "ZJ#QZ1Y#2J#3YJ#4MT#5YY#6CPY#7HG#8DL#9FZP#10QC#11MTC#12JRBX#13JTYS";
		colsH[26] = "XH#XM#HJ#GNZZS#GNXFS#YYS#QYSDS#CSWHJSS#QTGS";
		colsLName[26] = "总计#其中：1、烟#2、酒#3、冶金#4、煤炭#5、原油#6、成品油#7、化工#8、电力#9、纺织品#10、汽车#11、摩托车#12、金融、保险#13、交通运输";
		colsHName[26] = "序号#项目#合计#国内增值税#国内消费税#营业税#企业所得税#城市维护建设税#其他各税";
		
		sjNum[27] = 2;
		colsL[27] = "ZJ#YGSMS#1ZF#2JZJZJ#3JZZY#4ZJYFC#5SHBZ#6TGJMSR#7QT#EGLGXJS#1JSZR#2KJFZ#3ZZCX#4KYJGZZ#5TZCY#6WBFW#7GXJS#8QT#SCJXWQYFZ#1JRSC#2WDQZD#3MZZZSHYYSZC#4QT1#SZZSJ#1QYFZ#2QYZZGZ#3QT#WJNHB#1HJBH#2DLJS#3ZYZHLY#4QT2#LCJQYFZ#1XBKF#2DBFZ#3LAJL#4QT3#QZCWHJYTY#1JY#2TY#3WH#BZCJRZBSC#1ZBSC#2JRSC#JZCSN#1NCJS#2FLSL#3CYSJ#4JRSC#5QT#SZCQTGXSY#1FJZZ#2JCSSJS#3CPY#4GFJS#5GJF#6YLWS#7JTYS#8WCYZ#9GY#10SPCB#11WJRY#12ZXCZXZJ#13XSSSXDDY#GX#LX#TXQSYF#CCSY#QT#14QT";
		colsH[27] = "XH#XM#HJ#CKY#ZZY#DLRQJSDSCHGYY#JZY#JTYSCCJYZY#PFHLSY#JRY#XXCSJSJFWHRJY#ZLHSWFWY#FDCY#QTXY";
		colsLName[27] = "总计#一、改善民生#1.住房#2.救灾及重建#3.军转择业#4.再就业扶持#5.社会保障#6.提高居民收入#7.其他#二、鼓励高新技术#1.技术转让#2.科技发展#3.自主创新#4.科研机构转制#5.投资创业#6.外包服务#7.高新技术#8.其他#三、促进小微企业发展#1.金融市场#2.未达起征点#3.免征增值税和营业税政策#4.其他#四、转制升级#1.企业发展#2.企业重组改制#3.其他#五、节能环保#1.环境保护#2.电力建设#3.资源综合利用#4.其他#六、促进区域发展#1.西部开发#2.东部发展#3.两岸交流#4.其他#七、支持文化教育体育#1.教育#2.体育#3.文化#八、支持金融资本市场#1.资本市场#2.金融市场#九、支持三农#1.农村建设#2.肥料饲料#3.产业升级#4.金融市场#5.其他#十、支持其他各项事业#1.飞机制造#2.基础设施建设#3.成品油#4.国防建设#5.公检法#6.医疗卫生#7.交通运输#8.无偿援助#9.公益#10.商品储备#11.外籍人员#12.专项财政性资金#13.享受税收协定待遇#股息#利息#特许权使用费#财产收益#其他#14.其他";
		colsHName[27] = "序号#项目#合计#采矿业#制造业#电力燃气及水的生产和供应业#建筑业#交通运输仓储及邮政业#批发和零售业#金融业#信息传输计算机服务和软件业#租赁和商务服务业#房地产业#其他行业";
		
		sjNum[28] = 3;
		colsL[28] = "ZJ#YGSMS#1ZF#2JZJZJ#3JZZY#4ZJYFC#5SHBZ#6TGJMSR#7QT#EGLGXJS#1JSZR#2KJFZ#3ZZCX#4KYJGZZ#5TZCY#6WBFW#7GXJS#8QT#SCJXWQYFZ#1JRSC#2WDQZD#3MZZZSHYYSZC#4QT1#SZZSJ#1QYFZ#2QYZZGZ#3QT#WJNHB#1HJBH#2DLJS#3ZYZHLY#4QT2#LCJQYFZ#1XBKF#2DBFZ#3LAJL#4QT3#QZCWHJYTY#1JY#2TY#3WH#BZCJRZBSC#1ZBSC#2JRSC#JZCSN#1NCJS#2FLSL#3CYSJ#4JRSC#5QT#SZCQTGXSY#1FJZZ#2JCSSJS#3CPY#4GFJS#5GJF#6YLWS#7JTYS#8WCYZ#9GY#10SPCB#11WJRY#12ZXCZXZJ#13XSSSXDDY#GX#LX#TXQSYF#CCSY#QT#14QT";
		colsH[28] = "XH#XM#HJ#NZQYXJ#NZQYGYQY#NZQYJTQY#NZQYGFHZQY#NZQYLYQY#NZQYGFGS#NZQYSYQY#NZQYQTNZQY#GATTZQY#WSTZQY#GTJY";
		colsLName[28] = "总计#一、改善民生#1.住房#2.救灾及重建#3.军转择业#4.再就业扶持#5.社会保障#6.提高居民收入#7.其他#二、鼓励高新技术#1.技术转让#2.科技发展#3.自主创新#4.科研机构转制#5.投资创业#6.外包服务#7.高新技术#8.其他#三、促进小微企业发展#1.金融市场#2.未达起征点#3.免征增值税和营业税政策#4.其他#四、转制升级#1.企业发展#2.企业重组改制#3.其他#五、节能环保#1.环境保护#2.电力建设#3.资源综合利用#4.其他#六、促进区域发展#1.西部开发#2.东部发展#3.两岸交流#4.其他#七、支持文化教育体育#1.教育#2.体育#3.文化#八、支持金融资本市场#1.资本市场#2.金融市场#九、支持三农#1.农村建设#2.肥料饲料#3.产业升级#4.金融市场#5.其他#十、支持其他各项事业#1.飞机制造#2.基础设施建设#3.成品油#4.国防建设#5.公检法#6.医疗卫生#7.交通运输#8.无偿援助#9.公益#10.商品储备#11.外籍人员#12.专项财政性资金#13.享受税收协定待遇#股息#利息#特许权使用费#财产收益#其他#14.其他";
		colsHName[28] = "序号#项目#合计#内资企业小计#内资企业国有企业#内资企业集体企业#内资企业股份合作企业#内资企业联营企业#内资企业股份公司#内资企业私营企业#内资企业其它内资企业#港澳台投资企业#外商投资企业#个体经营";
		
		sjNum[29] = 2;
		colsL[29] = "ZJ#YGSMS#1ZF#2JZJZJ#3JZZY#4ZJYFC#5SHBZ#6TGJMSR#7QT#EGLGXJS#1JSZR#2KJFZ#3ZZCX#4KYJGZZ#5TZCY#6WBFW#7GXJS#8QT#SCJXWQYFZ#1JRSC#2WDQZD#3MZZZSHYYSZC#4QT1#SZZSJ#1QYFZ#2QYZZGZ#3QT#WJNHB#1HJBH#2DLJS#3ZYZHLY#4QT2#LCJQYFZ#1XBKF#2DBFZ#3LAJL#4QT3#QZCWHJYTY#1JY#2TY#3WH#BZCJRZBSC#1ZBSC#2JRSC#JZCSN#1NCJS#2FLSL#3CYSJ#4JRSC#5QT#SZCQTGXSY#1FJZZ#2JCSSJS#3CPY#4GFJS#5GJF#6YLWS#7JTYS#8WCYZ#9GY#10SPCB#11WJRY#12ZXCZXZJ#13XSSSXDDY#GX#LX#TXQSYF#CCSY#QT#14QT";
		colsH[29] = "XH#XM#HJ#ZQJM#TKJM#DDQS";
		colsLName[29] = "总计#一、改善民生#1.住房#2.救灾及重建#3.军转择业#4.再就业扶持#5.社会保障#6.提高居民收入#7.其他#二、鼓励高新技术#1.技术转让#2.科技发展#3.自主创新#4.科研机构转制#5.投资创业#6.外包服务#7.高新技术#8.其他#三、促进小微企业发展#1.金融市场#2.未达起征点#3.免征增值税和营业税政策#4.其他#四、转制升级#1.企业发展#2.企业重组改制#3.其他#五、节能环保#1.环境保护#2.电力建设#3.资源综合利用#4.其他#六、促进区域发展#1.西部开发#2.东部发展#3.两岸交流#4.其他#七、支持文化教育体育#1.教育#2.体育#3.文化#八、支持金融资本市场#1.资本市场#2.金融市场#九、支持三农#1.农村建设#2.肥料饲料#3.产业升级#4.金融市场#5.其他#十、支持其他各项事业#1.飞机制造#2.基础设施建设#3.成品油#4.国防建设#5.公检法#6.医疗卫生#7.交通运输#8.无偿援助#9.公益#10.商品储备#11.外籍人员#12.专项财政性资金#13.享受税收协定待遇#股息#利息#特许权使用费#财产收益#其他#14.其他";
		colsHName[29] = "序号#项目#合计#征前减免#退库减免#抵顶欠税";
		
		sjNum[33] = 2;
		colsL[33] = "HJ#YDYCY#EDECY#YCKY#1MTKCHXXY#2SYHTRQKCY#3HSJSKCXY#4YSJSKCXY#5FJSKCXY#6QTCKY#EZZY#1NFSPJGY#2SPZZY#3JYLHJZCZZY#4YCZPY#5FZY#6FZFZFSY#7PGMPYMJQZPHZXY#8MCJGHMZTZCZPY#9JJZZY#10ZZHZZPY#11YSHJLMJFZY#12WJGMTYHYLYPZZY#13SYJGLJHHRLJGY#14HXYLHHXZPZZY#15YYZZY#16HXXWZZY#17XJHSLZPY#18FJSKWZPY#19HSJSYLHYYJGY#20YSJSYLHYYJGY#21JSZPY#22TYSBZZY#23ZYSBZZY#24QCZZY#25TLCBHKHTHQTYSSBZZY#26DQJXHQCZZY#27JSJTXHQTDZSBZZY#28YBYQZZY#29QTZZY#SDLRLRQJSDSCHGYY#1DLRLSCHGYY#2RQSCHGYY#3SDSCHGYY#SJZY#1FWJZY#2TMGCJZY#3JZAZY#4JZZSHQTJZY#SDSCY#YPFHLSY#1PFY#2LSY#EJTYSCCHYZY#1TLYSY#2DLYSY#3SSYSY#4HKYSY#5GDYSY#6ZXBYHYSDLY#7CCY#8YZY#SZSHCYY#1ZSY#2CYY#SXXCSRJHXXJSFWY#1DXGBDSHWXCSFWY#2HLWHXGFW#3RJHXXJSFWY#WJRY#1HBJRFW#2ZBSCFW#3BXY#4QTJRY#LFDCY#1FDCKFJYY#2WYGL#3FDCZJFW#4ZYFDCJYHD#5QTFDCY#QZLHSWFWY#1ZLY#2SWFWY#QZZXYDC#GGY#ZSCQFW#HYZLFW#BKXYJHJSFWY#1YJHSYFZ#2ZYJSFWY#QZZYHSJFW#3KJTGHYYFWY#JSLHJHGGSSGLY#QZGGSSGLY#SJMFWXLHQTFWY#SYJY#SEWSHSHGZ#SSWHTYHYLY#SSGGGLSHBZHSHZZ#SWQTXY";
		colsH[33] = "XH#XM#HJ#YJTYSFW#1LLYSFW#2SLYSFW#3HKYSFW#4GDYSFW#EYZFW#1YZPBFW#2YZTSFW#3QTYZFW#SDXFW#1JCDXFW#2ZZDXFW#SJZFW#1GCFW#2AZFW#3XSFW#4ZSFW#5QTJZFW#WJRFW#1DKFW#2ZJSFJRFW#3BXFW#4JRSPZR#LXDFW#1YFHJSFW#2XXJSFW#3WHCYFW#4WLFZFW#5ZLFW#6JZZXFW#7GBYSFW#8SWFZFW#9QTXDFW#QSHFW#1WHTYFW#2JYYLFW#3LYYLFW#4CYZSFW#5JMRCFW#6QTSHFW#BXSWXZC#1ZLHFZLJS#2SBHZZQ#3TDSYQ#4QTZRZYSYQ#5QTQYXWXZC#JXSBDC#1JZW#QZESFJY1#2GZW#QZESFJY2";
		colsLName[33] = "合计#一、第一产业#二、第二产业#(一)采矿业#1.煤炭开采和洗选业#2.石油和天然气开采业#3.黑色金属矿采选业#4.有色金属矿采选业#5.非金属矿采选业#6.其他采矿业#(二)制造业#1.农副食品加工业#2.食品制造业#3.酒、饮料和精制茶制造业#4.烟草制品业#5.纺织业#6.纺织服装、服饰业#7.皮革、毛皮、羽毛及其制品和制鞋业#8.木材加工和木竹藤棕草制品业#9.家具制造业#10.造纸和纸制品业#11.印刷和记录媒介复制业#12.文教、工美、体育和娱乐用品制造业#13.石油加工、炼焦和核燃料加工业#14.化学原料和化学制品制造业#15.医药制造业#16.化学纤维制造业#17.橡胶和塑料制品业#18.非金属矿物制品业#19.黑色金属冶炼和压延加工业#20.有色金属冶炼和压延加工业#21.金属制品业#22.通用设备制造业#23.专用设备制造业#24.汽车制造业#25.铁路、船舶、航空航天和其他运输设备制造业#26.电气机械和器材制造业#27.计算机、通信和其他电子设备制造业#28.仪表仪器制造业#29.其他制造业#(三)电力、热力、燃气及水的生产和供应业#1.电力、热力生产和供应业#2.燃气生产和供应业#3.水的生产和供应业#(四)建筑业#1.房屋建筑业#2.土木工程建筑业#3.建筑安装业#4.建筑装饰和其他建筑业#三、第三产业#(一)批发和零售业#1.批发业#2.零售业#(二)交通运输、仓储和邮政业#1.铁路运输业#2.道路运输业#3.水上运输业#4.航空运输业#5.管道运输业#6.装卸搬运和运输代理业#7.仓储业#8.邮政业#(三)住宿和餐饮业#1.住宿业#2.餐饮业#(四)信息传输、软件和信息技术服务业#1.电信、广播电视和卫星传输服务业#2.互联网和相关服务#3.软件和信息技术服务业#(五)金融业#1.货币金融服务#2.资本市场服务#3.保险业#4.其他金融业#(六)房地产业#1.房地产开发经营业#2.物业管理#3.房地产中介服务#4.自有房地产经营活动#5.其他房地产业#(七)租赁和商务服务业#1.租赁业#2.商务服务业#其中：咨询与调查#广告业#知识产权服务#会议展览服务#(八)科学研究和技术服务业#1.研究和实验发展#2.专业技术服务业#其中：专业化设计服务#3.科技推广和应用服务业#(九)水利、环境和公共设施管理业#其中：公共设施管理业#(十)居民服务、修理和其他服务业#(十一)教育#(十二)卫生和社会工作#(十三)文化、体育和娱乐业#(十四)公共管理、社会保障和社会组织#(十五)其他行业";
		colsHName[33] = "序号#项目#合计#一、交通运输服务#1、陆路运输服务#2、水路运输服务#3、航空运输服务#4、管道运输服务#二、邮政服务#1.邮政普遍服务#2.邮政特殊服务#3.其他邮政服务#三、电信服务#1.基础电信服务#2.增值电信服务#四、建筑服务#1.工程服务#2.安装服务#3.修缮服务#4.装饰服务#5.其他建筑服务#五、金融服务#1.贷款服务#2.直接收费金融服务#3.保险服务#4.金融商品转让#六、现代服务#1.研发和技术服务#2.信息技术服务#3.文化创意服务#4.物流辅助服务#5.租赁服务#6.鉴证咨询服务#7.广播影视服务#8.商务辅助服务#9.其他现代服务#七、生活服务#1.文化体育服务#2.教育医疗服务#3.旅游娱乐服务#4.餐饮住宿服务#5.居民日常服务#6.其他生活服务#八、销售无形资产#1.专利或非专利技术#2.商标和著作权#3.土地使用权#4.其他自然资源使用权#5.其他权益性无形资产#九、销售不动产#1.建筑物#其中：二手房交易#2.构筑物#其中：二手房交易";
		

		sjNum[34] = 3;
		colsL[34] = "HJ#YDYCY#EDECY#YCKY#1MTKCHXXY#2SYHTRQKCY#3HSJSKCXY#4YSJSKCXY#5FJSKCXY#6QTCKY#EZZY#1NFSPJGY#2SPZZY#3JYLHJZCZZY#4YCZPY#5FZY#6FZFZFSY#7PGMPYMJQZPHZXY#8MCJGHMZTZCZPY#9JJZZY#10ZZHZZPY#11YSHJLMJFZY#12WJGMTYHYLYPZZY#13SYJGLJHHRLJGY#14HXYLHHXZPZZY#15YYZZY#16HXXWZZY#17XJHSLZPY#18FJSKWZPY#19HSJSYLHYYJGY#20YSJSYLHYYJGY#21JSZPY#22TYSBZZY#23ZYSBZZY#24QCZZY#25TLCBHKHTHQTYSSBZZY#26DQJXHQCZZY#27JSJTXHQTDZSBZZY#28YBYQZZY#29QTZZY#SDLRLRQJSDSCHGYY#1DLRLSCHGYY#2RQSCHGYY#3SDSCHGYY#SJZY#1FWJZY#2TMGCJZY#3JZAZY#4JZZSHQTJZY#SDSCY#YPFHLSY#1PFY#2LSY#EJTYSCCHYZY#1TLYSY#2DLYSY#3SSYSY#4HKYSY#5GDYSY#6ZXBYHYSDLY#7CCY#8YZY#SZSHCYY#1ZSY#2CYY#SXXCSRJHXXJSFWY#1DXGBDSHWXCSFWY#2HLWHXGFW#3RJHXXJSFWY#WJRY#1HBJRFW#2ZBSCFW#3BXY#4QTJRY#LFDCY#1FDCKFJYY#2WYGL#3FDCZJFW#4ZYFDCJYHD#5QTFDCY#QZLHSWFWY#1ZLY#2SWFWY#QZZXYDC#GGY#ZSCQFW#HYZLFW#BKXYJHJSFWY#1YJHSYFZ#2ZYJSFWY#QZZYHSJFW#3KJTGHYYFWY#JSLHJHGGSSGLY#QZGGSSGLY#SJMFWXLHQTFWY#1JMFWY#2JDCDZCPHRYCPXLY#3QTFWY#SYJY#SEWSHSHGZ#1WS#2SHGZ#SSWHTYHYLY#1XWHCBY#2GBDSDYHYSLYZZY#3WHYSY#4TY#5YLY#SSGGGLSHBZHSHZZ#SWQTXY";
		colsH[34] = "XH#XM#HJ#QZMDDK#NZQYXJ#NZQYGYQY#NZQYJTQY#NZQYGFHZQY#NZQYLYQY#NZQYQZGYKG1#NZQYGFGS#NZQYQZGYKG2#NZQYSYQY#NZQYQTQY#GATTZQY#QZGYKG1#WSTZQY#QZGYKG2#GTJY";
		colsLName[34] = "合计#一、第一产业#二、第二产业#(一)采矿业#1.煤炭开采和洗选业#2.石油和天然气开采业#3.黑色金属矿采选业#4.有色金属矿采选业#5.非金属矿采选业#6.其他采矿业#(二)制造业#1.农副食品加工业#2.食品制造业#3.酒、饮料和精制茶制造业#4.烟草制品业#5.纺织业#6.纺织服装、服饰业#7.皮革、毛皮、羽毛及其制品和制鞋业#8.木材加工和木竹藤棕草制品业#9.家具制造业#10.造纸和纸制品业#11.印刷和记录媒介复制业#12.文教、工美、体育和娱乐用品制造业#13.石油加工、炼焦和核燃料加工业#14.化学原料和化学制品制造业#15.医药制造业#16.化学纤维制造业#17.橡胶和塑料制品业#18.非金属矿物制品业#19.黑色金属冶炼和压延加工业#20.有色金属冶炼和压延加工业#21.金属制品业#22.通用设备制造业#23.专用设备制造业#24.汽车制造业#25.铁路、船舶、航空航天和其他运输设备制造业#26.电气机械和器材制造业#27.计算机、通信和其他电子设备制造业#28.仪表仪器制造业#29.其他制造业#(三)电力、热力、燃气及水的生产和供应业#1.电力、热力生产和供应业#2.燃气生产和供应业#3.水的生产和供应业#(四)建筑业#1.房屋建筑业#2.土木工程建筑业#3.建筑安装业#4.建筑装饰和其他建筑业#三、第三产业#(一)批发和零售业#1.批发业#2.零售业#(二)交通运输、仓储和邮政业#1.铁路运输业#2.道路运输业#3.水上运输业#4.航空运输业#5.管道运输业#6.装卸搬运和运输代理业#7.仓储业#8.邮政业#(三)住宿和餐饮业#1.住宿业#2.餐饮业#(四)信息传输、软件和信息技术服务业#1.电信、广播电视和卫星传输服务业#2.互联网和相关服务#3.软件和信息技术服务业#(五)金融业#1.货币金融服务#2.资本市场服务#3.保险业#4.其他金融业#(六)房地产业#1.房地产开发经营业#2.物业管理#3.房地产中介服务#4.自有房地产经营活动#5.其他房地产业#(七)租赁和商务服务业#1.租赁业#2.商务服务业#其中：咨询与调查#广告业#知识产权服务#会议展览服务#(八)科学研究和技术服务业#1.研究和实验发展#2.专业技术服务业#其中：专业化设计服务#3.科技推广和应用服务业#(九)水利、环境和公共设施管理业#其中：公共设施管理业#(十)居民服务、修理和其他服务业#1.居民服务业#2.机动车、电子产品和日用产品修理业#3.其他服务业#(十一)教育#(十二)卫生和社会工作#1.卫生#2.社会工作#(十三)文化、体育和娱乐业#1.新闻和出版业#2.广播、电视、电影和影视录音制作业#3.文化艺术业#4.体育#5.娱乐业#(十四)公共管理、社会保障和社会组织#(十五)其他行业";
		colsHName[34] = "序号#项目#合计#其中：免抵调库#内资企业小计#内资企业国有企业#内资企业集体企业#内资企业股份合作企业#内资企业联营企业#内资企业其中：国有控股#内资企业股份公司#内资企业其中：国有控股#内资企业私营企业#内资企业其它企业#港澳台投资企业#其中：国有控股#外商投资企业#其中：国有控股#个体经营";
		

		sjNum[35] = 3;
		colsL[35] = "HJ#YJTYSFW#1LLYSFW#1TLYSFW#2QTLLYSFW#2SLYSFW#3HKYSFW#4GDYSFW#EYZFW#1YZPBFW#2YZTSFW#3QTYZFW#SDXFW#1JCDXFW#2ZZDXFW#SJZFW#1GCFW#2AZFW#3XSFW#4ZSFW#5QTJZFW#WJRFW#1DKFW#2ZJSFJRFW#3BXFW#1RSBXFW#2CCBXFW#4JRSPZR#LXDFW#1YFHJSFW#1YFFW#2HTNYGLFW#3GCKCKTFW#4ZYJSFW#2XXJSFW#1RJFW#2DLSJJCSFW#3XXXTFW#4YWLCGLFW#5XXXTZZFW#3WHCYFW#1SJFW#2ZSCQFW#3GGFW#4HYZLFW#4WLFZFW#1HKFW#2GKMTFW#3HYKYCZFW#4DLJZFW#5ZXBYFW#6CCFW#7SPFW#5ZLFW#1BDCRZZL#2BDCJYZL#3YXDCRZZL#4YXDCJYZL#6JZZXFW#1RZFW#2JZFW#3ZXFW#7GBYSFW#1GBYSJMZPZZFW#2GBYSJMZPFXFW#3GBYSJMZPBYFW#8SWFZFW#1QYGLFW#2JJDLFW#3RLZYFW#4AQBHFW#9QTXDFW#QSHFW#1WHTYFW#1WHFW#2TYFW#2JYYLFW#1JYFW#2YLFW1#3LYYLFW#1LYFW#2YLFW2#4CYZSFW#1CYFW#2ZSFW#5JMRCFW#6QTSHFW#BXSWXZC#1ZLHFZLJS#2SBHZZQ#3TDSYQ#4QTZRZYSYQ#5QTQYXWXZC#JXSBDC#1JZW#QZESFJY1#2GZW#QZESFJY2";
		colsH[35] = "XH#XM#HJ#QZMDDK#NZQYXJ#NZQYGYQY#NZQYJTQY#NZQYGFHZQY#NZQYLYQY#NZQYQZGYKG1#NZQYGFGS#NZQYQZGYKG2#NZQYSYQY#NZQYQTQY#GATTZQY#QZGYKG1#WSTZQY#QZGYKG2#GTJY";
		colsLName[35] = "合计#一、交通运输服务#1.陆路运输服务#（1）铁路运输服务#（2）其他陆路运输服务#2.水路运输服务#3.航空运输服务#4.管道运输服务#二、邮政服务#1.邮政普遍服务#2.邮政特殊服务#3.其他邮政服务#三、电信服务#1.基础电信服务#2.增值电信服务#四、建筑服务#1.工程服务#2.安装服务#3.修缮服务#4.装饰服务#5.其他建筑服务#五、金融服务#1.贷款服务#2.直接收费金融服务#3.保险服务#（1）人身保险服务#（2）财产保险服务#4.金融商品转让#六、现代服务#1.研发和技术服务#(1)研发服务#(2)合同能源管理服务#(3)工程勘察勘探服务#(4)专业技术服务#2.信息技术服务#(1)软件服务#(2)电路设计及测试服务#(3)信息系统服务#(4)业务流程管理服务#(5)信息系统增值服务#3.文化创意服务#(1)设计服务#(2)知识产权服务#(3)广告服务#(4)会议展览服务#4.物流辅助服务#(1)航空服务#(2)港口码头服务#(3)货运客运场站服务#(4)打捞救助服务#(5)装卸搬运服务#(6)仓储服务#(7)收派服务#5.租赁服务#(1)不动产融资租赁#(2)不动产经营租赁#(3)有形动产融资租赁#(4)有形动产经营租赁#6.鉴证咨询服务#(1)认证服务#(2)鉴证服务#(3)咨询服务#7.广播影视服务#(1)广播影视节目（作品）制作服务#(2)广播影视节目（作品）发行服务#(3)广播影视节目（作品）播映服务#8.商务辅助服务#(1)企业管理服务#(2)经纪代理服务#(3)人力资源服务#(4)安全保护服务#9.其他现代服务#七、生活服务#1.文化体育服务#(1)文化服务#(2)体育服务#2.教育医疗服务#(1)教育服务#(2)医疗服务#3.旅游娱乐服务#(1)旅游服务#(2)娱乐服务#4.餐饮住宿服务#(1)餐饮服务#(2)住宿服务#5.居民日常服务#6.其他生活服务#八、销售无形资产#1.专利或非专利技术#2.商标和著作权#3.土地使用权#4.其他自然资源使用权#5.其他权益性无形资产#九、销售不动产#1.建筑物#其中：二手房交易#2.构筑物#其中：二手房交易";
		colsHName[35] = "序号#项目#合计#其中：免抵调库#内资企业小计#内资企业国有企业#内资企业集体企业#内资企业股份合作企业#内资企业联营企业#内资企业其中：国有控股#内资企业股份公司#内资企业其中：国有控股#内资企业私营企业#内资企业其它企业#港澳台投资企业#其中：国有控股#外商投资企业#其中：国有控股#个体经营";
		
		
		sjNum[36] = 5;
		colsL[36] = "GNSSSRHJ#1ZZSSR#QZYBNSR#XGMNSR#2XFSSR#3YYS#4QYSDS#5GRSDS#6ZYS#7GDZCTZFXDJS#8CSWHJSS#9FCS#10YHS#11CZTDSYS#12TDZZS#13CCS#14CLGZS#15YYS#16GDZYS#17QS#18QTGS";
		colsH[36] = "XH#SZ#HJHS#HJSSSR#DXQYHS#DXQYSSSR#ZXQYHS#ZXQYSSSR#XWQYXJHS#XWQYXJSSSR#XWQYXXQYHS#XWQYXXQYSSSR#XWQYWXQYHS#XWQYWXQYSSSR";
		colsLName[36] = "国内税收收入合计#1.增值税收入#其中:一般纳税人#小规模纳税人#2.消费税收入#3.营业税#4.企业所得税#5.个人所得税#6.资源税#7.固定资产投资方向调节税#8.城市维护建设税#9.房产税#10.印花税#11.城镇土地使用税#12.土地增值税#13.车船税#14.车辆购置税#15.烟叶税#16.耕地占用税#17.契税#18.其他各税";
		colsHName[36] = "序号#税种#合计户数#合计税收收入#大型企业户数#大型企业税收收入#中型企业户数#中型企业税收收入#小微企业小计户数#小微企业小计税收收入#小微企业小型企业户数#小微企业小型企业税收收入#小微企业微型企业户数#小微企业微型企业税收收入";
		

		sjNum[37] = 5;
		colsL[37] = "HJ#YDYCY#EDECY#YCKY#EZZY#1NFSPJGY#2SPZZY#3JYLHJZCZZY#4YCZPY#5FZY#6FZFZFSY#7PGMPYMJQZPHZXY#8MCJGHMZTZCZPY#9JJZZY#10ZZHZZPY#11YSHJLMJFZY#12WJGMTYHYLYPZZY#13SYJGLJHHRLJGY#14HXYLHHXZPZZY#15YYZZY#16HXXWZZY#17XJHSLZPY#18FJSKWZPY#19HSJSYLHYYJGY#20YSJSYLHYYJGY#21JSZPY#22TYSBZZY#23ZYSBZZY#24QCZZY#25TLCBHKHTHQTYSSBZZY#26DQJXHQCZZY#27JSJTXHQTDZSBZZY#28YBYQZZY#29QTZZY#SDLRLRQJSDSCHGYY#1DLRLSCHGYY#2RQSCHGYY#3SDSCHGYY#SJZY#1FWJZY#2TMGCJZY#3JZAZY#4JZZSHQTJZY#SDSCY#YPFHLSY#1PFY#2LSY#EJTYSCCHYZY#1JTYSY#x1TLYSY#x2QTJTYSY#2CCY#3YZY#SZSHCYY#1ZSY#2CYY#SXXCSRJHXXJSFWY#1DXGBDSHWXCSFWY#2HLWHXGFW#3RJHXXJSFWY#WJRY#1HBJRFW#2ZBSCFW#3BXY#4QTJRY#LFDCY#1FDCKFJY#2WYGL#3QTFDCY#QZLHSWFWY#1ZLY#2SWFWY#BKXYJHJSFWY#JJMFWXLHQTFWY#SJY#SYWSHSHGZ#SEWHTYHYLY#SSGGGLSHBZHSHZZ#SSQTXY";
		colsH[37] = "XH#XM#HJHS#HJSSSR#DXQYHS#DXQYSSSR#ZXQYHS#ZXQYSSSR#XWQYXJHS#XWQYXJSSSR#XWQYXXQYHS#XWQYXXQYSSSR#XWQYWXQYHS#XWQYWXQYSSSR";
		colsLName[37] = "合计#一、第一产业#二、第二产业#(一)采矿业#(二)制造业#1.农副食品加工业#2.食品制造业#3.酒、饮料和精制茶制造业#4.烟草制品业#5.纺织业#6.纺织服装、服饰业#7.皮革、毛皮、羽毛及其制品和制鞋业#8.木材加工和木竹藤棕草制品业#9.家具制造业#10.造纸和纸制品业#11.印刷和记录媒介复制业#12.文教、工美、体育和娱乐用品制造业#13.石油加工、炼焦和核燃料加工业#14.化学原料和化学制品制造业#15.医药制造业#16.化学纤维制造业#17.橡胶和塑料制品业#18.非金属矿物制品业#19.黑色金属冶炼和压延加工业#20.有色金属冶炼和压延加工业#21.金属制品业#22.通用设备制造业#23.专用设备制造业#24.汽车制造业#25.铁路、船舶、航空航天和其他运输设备制造业#26.电气机械和器材制造业#27.计算机、通信和其他电子设备制造业#28.仪表仪器制造业#29.其他制造业#(三)电力、热力、燃气及水的生产和供应业#1.电力、热力生产和供应业#2.燃气生产和供应业#3.水的生产和供应业#(四)建筑业#1.房屋建筑业#2.土木工程建筑业#3.建筑安装业#4.建筑装饰和其他建筑业#三、第三产业#(一)批发和零售业#1.批发业#2.零售业#(二)交通运输、仓储和邮政业#1.交通运输业#⑴铁路运输业#⑵其他交通运输业#2.仓储业#3.邮政业#(三)住宿和餐饮业#1.住宿业#2.餐饮业#(四)信息传输、软件和信息技术服务业#1.电信、广播电视和卫星传输服务业#2.互联网和相关服务#3.软件和信息技术服务业#(五)金融业#1.货币金融服务#2.资本市场服务#3.保险业#4.其他金融业#(六)房地产业#1.房地产开发经营#2.物业管理#3.其他房地产业#(七)租赁和商务服务业#1.租赁业#2.商务服务业#(八)科学研究和技术服务业#(九)居民服务、修理和其他服务业#(十)教育#(十一)卫生和社会工作#(十二)文化、体育和娱乐业#(十三)公共管理、社会保障和社会组织#(十四)其他行业";
		colsHName[37] = "序号#项目#合计户数#合计税收收入#大型企业户数#大型企业税收收入#中型企业户数#中型企业税收收入#小微企业小计户数#小微企业小计税收收入#小微企业小型企业户数#小微企业小型企业税收收入#小微企业微型企业户数#小微企业微型企业税收收入";
		

		sjNum[38] = 5;
		colsL[38] = "HJ#YNZQYXJ#YNZQY1GYQY#YNZQY2JTQY#YNZQY3GFHZQY#YNZQY4LYQY#YNZQYQZGYKG1#YNZQY5GFGS#YNZQYQZGYKG2#YNZQY6SYQY#YNZQY7QTQY#EGATTZQY#QZGYKG1#SWSTZQY#QZGYKG2#SGTJY";
		colsH[38] = "XH#QYLX1#QYLX2#HJHS#HJSSSR#DXQYHS#DXQYSSSR#ZXQYHS#ZXQYSSSR#XWQYXJHS#XWQYXJSSSR#XWQYXXQYHS#XWQYXXQYSSSR#XWQYWXQYHS#XWQYWXQYSSSR";
		colsLName[38] = "合计#一、内资企业小计#一、内资企业1.国有企业#一、内资企业2.集体企业#一、内资企业3.股份合作企业#一、内资企业4.联营企业#一、内资企业其中：国有控股#一、内资企业5.股份公司#一、内资企业其中：国有控股#一、内资企业6.私营企业#一、内资企业7.其他企业#二、港澳台投资企业#其中：国有控股#三、外商投资企业#其中：国有控股#四、个体经营";
		colsHName[38] = "序号#企业类型#企业类型#合计户数#合计税收收入#大型企业户数#大型企业税收收入#中型企业户数#中型企业税收收入#小微企业小计户数#小微企业小计税收收入#小微企业小型企业户数#小微企业小型企业税收收入#小微企业微型企业户数#小微企业微型企业税收收入";
		

		sjNum[39] = 3;
		colsL[39] = "YXSEHJ#1ASYSLZSHWJLWXSE#2AJYZSBFZSHWXSE#3MDTBFCKHWXSE#4MSHWJLWXSE#EYNSEHJ#1XXSE#2JXSE#SQLDSE#JXSEZC#MDTHWYTSE#ASYSLJSDNSJCYBJSE#3YDKSE#4SJDKSE#5QMLDSE#6JYZSBFJSDYNSE#7YNSEJZE";
		colsH[39] = "XH#XM#HJ#GY#JYDZZ#JDZZ#FZY#YYJGJSYZPZZ#HXYLJHXZPZZY#FJSKWZPY#HSJSYLHYYJGY#QCZZY#MTKCHXXY#SYHTRQKCY#DLRLSCHGYY#PFY#LSY";
		colsLName[39] = "一.销售额合计#1.按适用税率征税货物及劳务销售额#2.按简易征收办法征税货物销售额#3.免.抵.退办法出口货物销售额#4.免税货物及劳务销售额#二.应纳税额合计#1.销项税额#2.进项税额#上期留抵税额#进项税额转出#免抵退货物应退税额#按适用税率计算的纳税检查应补缴税额#3.应抵扣税额#4.实际抵扣税额#5.期末留抵税额#6.简易征收办法计算的应纳税额#7.应纳税额减征额";
		colsHName[39] = "序号#项目#合计#工业#卷烟的制造#酒的制造#纺织业#原油加工及石油制品制造#化学原料及化学制品制造业#非金属矿物制品业#黑色金属冶炼和压延加工业#汽车制造业#煤炭开采和洗选业#石油和天然气开采业#电力、热力生产和供应业#批发业#零售业";
		

		sjNum[40] = 2;
		colsL[40] = "YXSEHJ#1ASYSLZSHWJLWXSE#2AJYZSBFZSHWXSE#3MDTBFCKHWXSE#4MSHWJLWXSE#EYNSEHJ#1XXSE#2JXSE#SQLDSE#JXSEZC#MDTHWYTSE#ASYSLJSDNSJCYBJSE#3YDKSE#4SJDKSE#5QMLDSE#6JYZSBFJSDYNSE#7YNSEJZE#F1XGMNSRXSE#F2XGMNSRYNSE";
		colsH[40] = "XH#XM#HJ#YJTYSFW#1LLYSFW#2SLYSFW#3HKYSFW#4GDYSFW#EYZFW#SDXFW#SJZFW#QZGCFW#WJRFW#1DKFW#2ZJSFJRFW#3BXFW#4JRSPZR#LXDFW#1YFHJSFW#2XXJSFW#3WHCYFW#4WLFZFW#5ZLFW#6JZZXFW#7GBYSFW#8SWFZFW#9QTXDFW#QSHFW#BXSWXZC#JXSBDC#QZESFJY";
		colsLName[40] = "一.销售额合计#1.按适用税率征税货物及劳务销售额#2.按简易征收办法征税货物销售额#3.免.抵.退办法出口货物销售额#4.免税货物及劳务销售额#二.应纳税额合计#1.销项税额#2.进项税额#上期留抵税额#进项税额转出#免抵退货物应退税额#按适用税率计算的纳税检查应补缴税额#3.应抵扣税额#4.实际抵扣税额#5.期末留抵税额#6.简易征收办法计算的应纳税额#7.应纳税额减征额#附1：小规模纳税人销售额#附2：小规模纳税人应纳税额";
		colsHName[40] = "序号#项目#合计#一、交通运输服务#1、陆路运输服务#2、水路运输服务#3、航空运输服务#4、管道运输服务#二、邮政服务#三、电信服务#四、建筑服务#其中：工程服务#五、金融服务#1.贷款服务#2.直接收费金融服务#3.保险服务#4.金融商品转让#六、现代服务#1.研发和技术服务#2.信息技术服务#3.文化创意服务#4.物流辅助服务#5.租赁服务#6.鉴证咨询服务#7.广播影视服务#8.商务辅助服务#9.其他现代服务#七、生活服务#八、销售无形资产#九、销售不动产#其中：二手房交易";


		sjNum[42] = 2;
		colsL[42] = "CZZSASJLREYJYYSR#CZZSASJLREYJYYCB#CZZSASJLREYJLRZE#CZZSASJLREYJTDYWJSDYNSSDE#CZZSASJLREYJBZSSRHSJJMYNSSDE#CZZSASJLREYJGDZCJSZJKCDJE#CZZSASJLREYJMBYQNDKS#CZZSASJLREYJSJLRE#CZZSASJLREYJYNSDSE#CZZSASJLREYJJMSDSE#CZZSASJLREYJQZFHTJDXXWLQYJMSDSE#CZZSASJLREYJSJYNSDSE#CZZSASYNSNDYJSYNDYNSSDE#CZZSASYNSNDYJJZBYJYNSDSE#CZZSAQTFFYJJZBYJQDYJDSDSE#HDZSASRZEHDSRZE#HDZSASRZEHDBZSSR#HDZSASRZEHDMSSR#HDZSASRZEHDYSSRE#HDZSASRZEHDYNSSDE#HDZSASRZEHDYNSDSE#HDZSACBFYHDCBFYZE#HDZSACBFYHDYNSSDE#HDZSACBFYHDYNSDSE#HDZSYSWJGHDYNSEYNSDSE#ZFJGJNQYSDSQKZJGYFTQYSDSE#ZFJGJNQYSDSQKCZJZFPSDSE#ZFJGJNQYSDSQKFZJGYFTQYSDSE#ZFJGJNQYSDSQKQZZJGDLSCJYBMYFTSDSE#ZFJGJNQYSDSQKZJGYCXFZJGYFTSDSE";
		colsH[42] = "XH#XM#HJ#YDYCY#EDECY#YCKY#EZZY#SDLRLRQJSDSCHGYY#SJZY#SDSCY#YPFHLSY#EJTYSCCHYZY#SZSHCYY#SXXCSRJHXXJSFWY#WJRY#LFDCY#QZLHSWFWY#BKXYJHJSFWY#JJMFWXLHQTFWY#SJY#SYWSHSHGZ#SEWHTYHYLY#SSGGGLSHBZHSHZZ#SSQTXY";
		colsLName[42] = "查账征收按实际利润额预缴营业收入#查账征收按实际利润额预缴营业成本#查账征收按实际利润额预缴利润总额#查账征收按实际利润额预缴特定业务计算的应纳税所得额#查账征收按实际利润额预缴不征税收入和税基减免应纳税所得额#查账征收按实际利润额预缴固定资产加速折旧（扣除）调减额#查账征收按实际利润额预缴弥补以前年度亏损#查账征收按实际利润额预缴实际利润额#查账征收按实际利润额预缴应纳所得税额#查账征收按实际利润额预缴减免所得税额#查账征收按实际利润额预缴其中：符合条件的小型微利企业减免所得税额#查账征收按实际利润额预缴实际应纳所得税额#查账征收按上一纳税年度预缴上一年度应纳税所得额#查账征收按上一纳税年度预缴截至本月（季）应纳所得税额#查账征收按其他方法预缴截至本月（季）确定预缴的所得税额#核定征收按收入总额核定收入总额#核定征收按收入总额核定不征税收入#核定征收按收入总额核定免税收入#核定征收按收入总额核定应税收入额#核定征收按收入总额核定应纳税所得额#核定征收按收入总额核定应纳所得税额#核定征收按成本费用核定成本费用总额#核定征收按成本费用核定应纳税所得额#核定征收按成本费用核定应纳所得税额#核定征收由税务机关核定应纳税额应纳所得税额#总分机构缴纳企业所得税情况总机构应分摊企业所得税额#总分机构缴纳企业所得税情况财政集中分配所得税额#总分机构缴纳企业所得税情况分支机构应分摊企业所得税额#总分机构缴纳企业所得税情况其中：总机构独立生产经营部门应分摊所得税额#总分机构缴纳企业所得税情况总机构已撤销分支机构应分摊所得税额";
		colsHName[42] = "序号#项目#合计#一、第一产业#二、第二产业#(一)采矿业#(二)制造业#(三)电力、热力、燃气及水的生产和供应业#(四)建筑业#三、第三产业#(一)批发和零售业#(二)交通运输、仓储和邮政业#(三)住宿和餐饮业#(四）信息传输、软件和信息技术服务业#(五)金融业#(六)房地产业#(七)租赁和商务服务业#(八)科学研究和技术服务业#(九)居民服务、修理和其他服务业#(十)教育#(十一)卫生和社会工作#(十二)文化、体育和娱乐业#(十三)公共管理、社会保障和社会组织#(十四)其他行业";


		sjNum[59] = 2;
		colsL[59] = "HJ#YNYK#1MT#2YY#3TRQ#4MCCQ#5DR#6QTNYK#EJSK#1TK#2JK#3TK#4LTK#5QXK#6NK#7XK#8ZZXTK#9QXTK#10WK#11ZK#12MK#13YK#14QTJSK#SFJSK#1SM#2GZT#3GLT#4YS#5SHS#6LTK#7LK#8LHJ#9LSJ#10ZT#11SS#12JKY#13HY#14HY#15DXLSSZDY#16KQS#17DLY#18HGY#19NHZT#20MX#21QTFJSK#SSZY#1DBS#2DXS#WQT#LSKZNJFKSR";
		colsH[59] = "XH#XM#JLDW#XSL#XSE#BQYNSE1#BQJMSE#BQYNSE2#BQYBTSE";
		colsLName[59] = "合计#一、能源矿#1.煤炭#2.原油#3.天然气#4.煤层（成）气#5.地热#6.其他能源矿#二、金属矿#1.铁矿#2.金矿#3.铜矿#4.铝土矿#5.铅锌矿#6.镍矿#7.锡矿#8.中重稀土矿#9.轻稀土矿#10.钨矿#11.钼矿#12.锰矿#13.银矿#14.其他金属矿#三、非金属矿#1.石墨#2.硅藻土#3.高岭土#4.萤石#5.石灰石#6.硫铁矿#7.磷矿#8.氯化钾#9.硫酸钾#10.粘土#11.砂石#12.井矿盐#13.湖盐#14.海盐#15.地下卤水晒制的盐#16.矿泉水#17.大理岩#18.花岗岩#19.耐火粘土#20.芒硝#21.其他非金属矿#四、水资源#1.地表水#2.地下水#五、其他#六、税款滞纳金、罚款收入";
		colsHName[59] = "序号#项目#计量单位#销售量#销售额#本期应纳税额#本期减免税额#本期已纳税额#本期应补（退）税额";


		sjNum[60] = 3;
		colsL[60] = "HJ#YA1SLZS#EA5SLZS#SA7SLZS#QT";
		colsH[60] = "XH#XM#JSYJHJ#JSYJZZS#JSYJQZYBZZS#JSYJQZMDZZS#JSYJXFS#JSYJYYS#BQYNSE#BQJMSE#BQYJSE#BQYBTSE";
		colsLName[60] = "合计#一、按1%税率征收#二、按5%税率征收#三、按7%税率征收#其他";
		colsHName[60] = "序号#项目#计税依据合计#计税依据增值税#计税依据其中：一般增值税#计税依据其中：免抵增值税#计税依据消费税#计税依据营业税#本期应纳税额#本期减免税额#本期已缴税额#本期应补（退）税额";


		sjNum[61] = 3;
		colsL[61] = "HJ#YCJJZ#1DWNSR#2GRNSR#ECZJZ#1DWNSR#2GRNSR#QZGRCZZF";
		colsH[61] = "XH#XM#FCYZ#QZCZFCYZ#QZJMSFCYZ#FCYZ/BQYZSJSR#BQYNSE#BQJMSE#BQYJSE#BQYBTSE";
		colsLName[61] = "合计#一、从价计征#1、单位纳税人#2、个人纳税人#二、从租计征#1、单位纳税人#2、个人纳税人#其中：个人出租住房";
		colsHName[61] = "序号#项目#房产原值#其中：出租房产原值#其中：减免税房产原值#房产原值本期应租税金收入#本期应纳税额#本期减免税额#本期已缴税额#本期应补（退）税额";


		sjNum[62] = 2;
		colsL[62] = "HJ#YGXHT#EJGCLHT#SJSGCKCSJHT#SJZAZGCCBHT#WCCZLHT#LHWYSHT#QCCBGHT#BJKHT#JCCBXHT#SJSHT#SYCQZYSJ#SEYYZBJZZJ#SSYYZBQT#SSQLXKZZ";
		colsH[62] = "XH#XM#JSJEHJS#HDZSDHDYJ#BQYNSE#BQYJSE#BQJMSE#BQYBTSE";
		colsLName[62] = "合计#一、购销合同#二、加工承揽合同#三、建设工程勘察设计合同#四、建筑安装工程承包合同#五、财产租赁合同#六、货物运输合同#七、仓储保管合同#八、借款合同#九、财产保险合同#十、技术合同#十一、产权转移书据#十二、营业帐簿（记载资金）#十三、营业帐簿（其他）#十四、权利、许可证照";
		colsHName[62] = "序号#项目#计税金额或件数#核定征收的核定依据#本期应纳税额#本期已缴税额#本期减免税额#本期应补（退）税额";


		sjNum[63] = 2;
		colsL[63] = "HJ#YFSETJ#103Y#236Y#3612Y#41218Y#51824Y#62430Y#730YYS#EFYTTJ#1GY#2SY#3JZ#4ZH#5FDCKFQYKFYD#6QT";
		colsH[63] = "XH#XM#TDZMJWPFM#QZJMSZMJWPFM#BQYNSE#BQJMSE#BQYJSE#BQYBTSE";
		colsLName[63] = "合计#一、分税额统计#1、0-3元#2、3-6元#3、6-12元#4、12-18元#5、18-24元#6、24-30元#7、30元以上#二、分用途统计#1.工业#2、商业#3、居住#4、综合#5、房地产开发企业开发用地#6、其它";
		colsHName[63] = "序号#项目#土地总面积（万平方米）#其中：减免税总面积（万平方米）#本期应纳税额#本期减免税额#本期已缴税额#本期应补（退）税额";


		sjNum[64] = 3;
		colsL[64] = "HJ#YPTZZ#PTZZ11YX#PTZZ212#PTZZ323#PTZZ43YS#EFPTZZ#FPTZZ12YX#FPTZZ224#FPTZZ346#FPTZZ46YS#SQTLXFDC#QTLXFDC12YX#QTLXFDC224#QTLXFDC346#QTLXFDC46YS";
		colsH[64] = "XH#XM#YSSRHJ#YSSRHBSR#YSSRSWSRJQTSR#YSSRSTXSSR#YNSE#SKJNBQYJSK1#SKJNBQYJSK2";
		colsLName[64] = "合计#一、普通住宅#1、1%以下#2、1%-2%#3、2%-3%#4、3%以上#二、非普通住宅#1、2%以下#2、2%-4%#3、4%-6%#4、6%以上#三、其他类型房地产#1、2%以下#2、2%-4%#3、4%-6%#4、6%以上";
		colsHName[64] = "序号#项目#应税收入合计#应税收入货币收入#应税收入实物收入及其他收入#应税收入视同销售收入#应纳税额#税款缴纳本期已缴税款#税款缴纳本期应缴税款";


		sjNum[65] = 2;
		colsL[65] = "YZRFDCSRZE#EKCXMJE#1QDTDSYQSZFDJE#2FDCKFCB#TDZYJCQBCF#QQGCF#JZAZGCF#JCSSF#GGPTSSF#KFJJFY#3FDCKFFY#LXZC#QTFDCKFFY#4YZRFDCYGDSJD#YYS#CSWHJSS#JYFFJ#5CZBGDDQTKCXM#SZZE#SYJTDZZSSE#WJMSE#LYJTDZZSSE#QYBTTDZZSSE";
		colsH[65] = "XH#XM#HJ#PTZZ#FPTZZ#QTLXFDC";
		colsLName[65] = "一、转让房地产收入总额#二、扣除项目金额#1.取得土地使用权所支付的金额#2.房地产开发成本#土地征用及拆迁补偿费#前期工程费#建筑安装工程费#基础设施费#公共配套设施费#开发间接费用#3.房地产开发费用#利息支出#其他房地产开发费用#4.与转让房地产有关的税金等#营业税#城市维护建设税#教育费附加#5.财政部规定的其他扣除项目#三、增值额#四、应缴土地增值税税额#五、减免税额#六、已缴土地增值税税额#七、应补（退）土地增值税税额";
		colsHName[65] = "序号#项目#合计#普通住宅#非普通住宅#其他类型房地产";


		sjNum[66] = 3;
		colsL[66] = "YZRFDCSRZE#EKCXMJE#1FDCCBAPGJGJSQDTDSYQSZFDJE#2FDCCBAPGJGJSJFJJZWDPGJG#3FDCCBAPGJGJSPGFY#4FDCCBAGFFPJSGFFPJE#5FDCCBAGFFPJSFPJJKCJE#6FDCCBAGFFPJSGFQS#2YZRFDCYGDSJYYS#3YZRFDCYGDSJCSWHJSS#4YZRFDCYGDSJYHS#5YZRFDCYGDSJJYFFJ#SZZE#SYJTDZZSSE#WJMSE#LYJTDZZSSE#QYBTTDZZSSE";
		colsH[66] = "XH#XM1#XM2#XM3#HJ#GRZZ#GRQTLXFDC#FGR";
		colsLName[66] = "一、转让房地产收入总额#二、扣除项目金额#1、房地产成本按评估价格计算取得土地使用权所支付的金额#2、房地产成本按评估价格计算旧房及建筑物的评估价格#3、房地产成本按评估价格计算评估费用#4、房地产成本按购房发票计算购房发票金额#5、房地产成本按购房发票计算发票加计扣除金额#6、房地产成本按购房发票计算购房契税#2、与转让房地产有关的税金营业税#3、与转让房地产有关的税金城市维护建设税#4、与转让房地产有关的税金印花税#5、与转让房地产有关的税金教育费附加#三、增值额#四、应缴土地增值税税额#五、减免税额#六、已缴土地增值税税额#七、应补（退）土地增值税税额";
		colsHName[66] = "序号#项目#项目#项目#合计#个人住宅#个人其他类型房地产#非个人";


		sjNum[67] = 2;
		colsL[67] = "HJ#YCYC#10SYX#10D16S#16D20S#20D25S#25D30S#30D40S#40SYS#ESYC#1KC#2HC#SGC#SMTC#WQTCL#1ZYZYC#2LSZYJXC#LCB#1JDCB#200DYX#200D2000D#2000D10000D#10000DYS#2YT#10MYX#10D18M#18D30M#30MYS";
		colsH[67] = "XH#XM#CLSHJL#CBSHJS#NYJSE#BNJMSE#BNYJSE#BNYBTSE";
		colsLName[67] = "合计#一、乘用车#1.0升以下#1.0-1.6升#1.6-2.0升#2.0-2.5升#2.5-3.0升#3.0-4.0升#4.0升以上#二、商用车#1、客车#2、货车#三、挂车#四、摩托车#五、其他车辆#1、专用作业车#2、轮式专用机械车#六、船舶#1、机动船舶#200吨以下#200-2000吨#2000-10000吨#10000吨以上#2、游艇#10米以下#10-18米#18-30米#30米以上";
		colsHName[67] = "序号#项目#车辆数合计（辆）#船舶数合计（艘）#年应缴税额#本年减免税额#本年已缴税额#本年应补（退）税额";


		sjNum[68] = 2;
		colsL[68] = "HJ#YYSG#YYGM";
		colsH[68] = "XH#XM#SGGMJE#YNSE1#YNSE2#YRKSE";
		colsLName[68] = "合计#烟叶收购#烟叶购买";
		colsHName[68] = "序号#项目#收购购买金额#应纳税额#已纳税额#应入库税额";


		sjNum[69] = 2;
		colsL[69] = "HJ#YTDCB#EJTJCSSJS#SGYJS#SSYJS#WZZJS#LNCJMJF#QJSSS#BXX#JYEY#SYY#SYYLY#SEQT";
		colsH[69] = "XH#XM#JSMJWPFM#QZJMSMJWPFM#JZSE#JMSE#YJSE1#YJSE2";
		colsLName[69] = "合计#一、土地储备#二、交通基础设施建设#三、工业建设#四、商业建设#五、住宅建设#六、农村居民建房#七、军事设施#八、学校#九、幼儿园#十、医院#十一、养老院#十二、其他";
		colsHName[69] = "序号#项目#计税面积(万平方米)#其中：减免税面积(万平方米)#计征税额#减免税额#已缴税额#应缴税额";
		

		//70表炸了
		

		sjNum[71] = 2;
		colsL[71] = "HJ#YTDQSZYHJ#YTDSYQCR#TDSYQCR1JZYD#TDSYQCR2SYYD#TDSYQCR3GYYD#TDSYQCR4ZHYD#TDSYQCR5QTYD#ETDSYQZR#TDSYQZR1JZYD#TDSYQZR2SYYD#TDSYQZR3GYYD#TDSYQZR4ZHYD#TDSYQZR5QTYD#EFWQSZYHJ#YZLF#ZLFQZ1JTWYZF#ZLFQZ90PMYS#ZLF90PMJYX1#ZLF2JTDETZF#ZLF90PMYS#ZLF90PMJYX2#ZLF3FZF#ECLF#CLFQZ1JTWYZF#CLFQZ90PMYS#CLF90PMJYX1#CLF2JTDETZF#CLF90PMYS#CLF90PMJYX2#CLF3FZF";
		colsH[71] = "XH#XM#QSZYMJWPFM#JZSE#JMSE#YNSE";
		colsLName[71] = "合计#一、土地权属转移合计#（一）土地使用权出让#1.居住用地#2.商业用地#3.工业用地#4.综合用地#5.其他用地#（二）土地使用权转让#1.居住用地#2.商业用地#3.工业用地#4.综合用地#5.其他用地#二、房屋权属转移合计#（一）增量房#其中：1.家庭唯一住房#其中：90平米以上#90平米及以下#2.家庭第二套住房#90平米以上#90平米及以下#3.非住房#（二）存量房#其中：1.家庭唯一住房#其中：90平米以上#90平米及以下#2.家庭第二套住房#90平米以上#90平米及以下#3.非住房";
		colsHName[71] = "序号#项目#权属转移面积（万平方米）#计征税额#减免税额#应纳税额";
		

		sjNum[72] = 2;
		colsL[72] = "JSSBYYSR#JSSBYYCB#JSSBLRKSE#JSSBAGDKMBDYQNDKSE#JSSBYNSSDE#JSSBSJYNQYSDSE#JSSBJMQYSDSE#ASRZEHDSRZE#ASRZEHDYNSSDE#ASRZEHDSJYNQYSDSE#ASRZEHDJMQYSDSE#AJFZCHDJFZCZE#AJFZCHDHSDSRE#AJFZCHDYNSSDE#AJFZCHDSJYNQYSDSE#AJFZCHDJMQYSDSE#ACBFYHDCBFYZE#ACBFYHDHSDSRE#ACBFYHDYNSSDE#ACBFYHDSJYNQYSDSE#ACBFYHDJMQYSDSE";
		colsH[72] = "XH#XM#XM#HJ#XG#TW#AM#HG#RB#MG#XJP#JND#ADLY#YG#ELS#DG#FG#BLS#QTGJ";
		colsLName[72] = "据实申报营业收入#据实申报营业成本#据实申报利润（亏损）额#据实申报按规定可弥补的以前年度亏损额#据实申报应纳税所得额#据实申报实际应纳企业所得税额#据实申报减（免）企业所得税额#按收入总额核定收入总额#按收入总额核定应纳税所得额#按收入总额核定实际应纳企业所得税额#按收入总额核定减（免）企业所得税额#按经费支出核定经费支出总额#按经费支出核定换算的收入额#按经费支出核定应纳税所得额#按经费支出核定实际应纳企业所得税额#按经费支出核定减（免）企业所得税额#按成本费用核定成本费用总额#按成本费用核定换算的收入额#按成本费用核定应纳税所得额#按成本费用核定实际应纳企业所得税额#按成本费用核定减（免）企业所得税额";
		colsHName[72] = "序号#项目#项目#合计#香港#台湾#澳门#韩国#日本#美国#新加坡#加拿大#澳大利亚#英国#俄罗斯#德国#法国#比利时#其他国家";
		

		sjNum[76] = 3;
		colsL[76] = "YZZSNSR#1YBNSR#2XGMNSR#EXFSNSR#SYYSNSR#SQYSDSNSR#1JMQYSDSNSR#1NZQY#2WZQY#2FJMQYSDSNSR#WGRSDSNSR#LZYSNSR#QGDZCTZFXDJSNSR#BCSWHJSSNSR#JFCSNSR#SYHSNSR#SYCZTDSYSNSR#SETDZZSNSR#SSCCSNSR#SSCLGZSNSR#SWYYSNSR#SLGDZYSNSR#SQQSNSR#SBQTSSNSR#FLZLDJHS#QZQYNSR#GTNSR";
		colsH[76] = "XH#XM#BQXZHHJ#QZ1ZCH1#2FZCH1#QMDJHHJ#QZ1ZCH2#2FZCH2#BQZXHHJ#QZBQDJBQZX#F1QMZJGHS#QMFZJGHS#F2QMLSNSRDJHS";
		colsLName[76] = "一、增值税纳税人#1.一般纳税人#2.小规模纳税人#二、消费税纳税人#三、营业税纳税人#四、企业所得税纳税人#1.居民企业所得税纳税人#（1）内资企业#（2）外资企业#2.非居民企业所得税纳税人#五、个人所得税纳税人#六、资源税纳税人#七、固定资产投资方向调节税纳税人#八、城市维护建设税纳税人#九、房产税纳税人#十、印花税纳税人#十一、城镇土地使用税纳税人#十二、土地增值税纳税人#十三、车船税纳税人#十四、车辆购置税纳税人#十五、烟叶税纳税人#十六、耕地占用税纳税人#十七、契税纳税人#十八、其他税收纳税人#附列资料：登记户数#其中：企业纳税人#个体纳税人";
		colsHName[76] = "序号#项目#本期新增户合计#其中：1.正常户#2.非正常户#期末登记户合计#其中：1.正常户#2.非正常户#本期注销户合计#其中：本期登记本期注销#附1：期末总机构户数#期末分支机构户数#附2：期末临时纳税人登记户数";
		

		sjNum[77] = 4;
		colsL[77] = "YZZSNSR#1YBNSR#2XGMNSR#EXFSNSR#SYYSNSR#SQYSDSNSR#1JMQYSDSNSR#1NZQY#2WZQY#2FJMQYSDSNSR#WGRSDSNSR#LZYSNSR#QGDZCTZFXDJSNSR#BCSWHJSSNSR#JFCSNSR#SYHSNSR#SYCZTDSYSNSR#SETDZZSNSR#SSCCSNSR#SSCLGZSNSR#SWYYSNSR#SLGDZYSNSR#SQQSNSR#SBQTSSNSR#FLZLQYSDSNDHSQJ";
		colsH[77] = "XH#XM#YYSBHSHJ#1YSBHSXJ#QZZQSBHS#QZYQSBHS#2WSBHS#EYFKBSBHS#QZWDQZD";
		colsLName[77] = "一、增值税纳税人#1.一般纳税人#2.小规模纳税人#二、消费税纳税人#三、营业税纳税人#四、企业所得税纳税人#1.居民企业所得税纳税人#（1）内资企业#（2）外资企业#2.非居民企业所得税纳税人#五、个人所得税纳税人#六、资源税纳税人#七、固定资产投资方向调节税纳税人#八、城市维护建设税纳税人#九、房产税纳税人#十、印花税纳税人#十一、城镇土地使用税纳税人#十二、土地增值税纳税人#十三、车船税纳税人#十四、车辆购置税纳税人#十五、烟叶税纳税人#十六、耕地占用税纳税人#十七、契税纳税人#十八、其他税收纳税人#附列资料：企业所得税年度汇算清缴";
		colsHName[77] = "序号#项目#一、应申报户数合计#1.已申报户数小计#其中：准期申报户数#其中：逾期申报户数#2.未申报户数#二、依法可不申报户数#其中：未达起征点";
		

		sjNum[78] = 3;
		colsL[78] = "HJ#YDYCY#EDECY#YCKY#1MTKCHXXY#2SYHTRQKCY#3HSJSKCXY#4YSJSKCXY#5FJSKCXY#6QTCKY#EZZY#1NFSPJGY#2SPZZY#3JYLHJZCZZY#4YCZPY#5FZY#6FZFZFSY#7PGMPYMJQZPHZXY#8MCJGHMZTZCZPY#9JJZZY#10ZZHZZPY#11YSHJLMJFZY#12WJGMTYHYLYPZZY#13SYJGLJHHRLJGY#14HXYLHHXZPZZY#15YYZZY#16HXXWZZY#17XJHSLZPY#18FJSKWZPY#19HSJSYLHYYJGY#20YSJSYLHYYJGY#21JSZPY#22TYSBZZY#23ZYSBZZY#24QCZZY#25TLCBHKHTHQTYSSBZZY#26DQJXHQCZZY#27JSJTXHQTDZSBZZY#28YBYQZZY#29QTZZY#SDLRLRQJSDSCHGYY#1DLRLDSCHGYY#2RQSCHGYY#3SDSCHGYY#SJZY#1FWJZY#2TMGCJZY#3JZAZY#4JZZSHQTJZY#SDSCY#YPFHLSY#1PFY#2LSY#EJTYSCCHYZY#1JTYSY#2CCY#3YZY#SZSHCYY#1ZSY#2CYY#SXXCSRJHXXJSFWY#1DXGBDSHWXCSFWY#2HLWHXGFW#3RJHXXJSFWY#WJRY#1HBJRFW#2ZBSCFW#3BXY#4QTJRY#LFDCY#QZLHSWFWY#1ZLY#2SWFWY#BKXYJHJSFWY#JJMFWXLHQTFWY#SJY#YWSHSHGZ#SEWHTYHYLY#SSGGGLSHBZHSHZZ#SSQTXY";
		colsH[78] = "XH#XM#GNZZS#QZYBNSRZZS#GNXFS#YYS#QYSDSNZQY#QYSDSWZQY#GRSDS#CSWHJSS#FCS#YHS#CZTDSYS#TDZZS#CLGZS#CCS#GDZYS#QS#QTGS#FLZLNSHS#DJHS#FZJGHS1#FZJGHS2";
		colsLName[78] = "合计#一、第一产业#二、第二产业#(一)采矿业#1.煤炭开采和洗选业#2.石油和天然气开采业#3.黑色金属矿采选业#4.有色金属矿采选业#5.非金属矿采选业#6.其他采矿业#(二)制造业#1.农副食品加工业#2.食品制造业#3.酒、饮料和精制茶制造业#4.烟草制品业#5.纺织业#6.纺织服装、服饰业#7.皮革、毛皮、羽毛及其制品和制鞋业#8.木材加工和木竹藤棕草制品业#9.家具制造业#10.造纸和纸制品业#11.印刷和记录媒介复制业#12.文教、工美、体育和娱乐用品制造业#13.石油加工、炼焦和核燃料加工业#14.化学原料和化学制品制造业#15.医药制造业#16.化学纤维制造业#17.橡胶和塑料制品业#18.非金属矿物制品业#19.黑色金属冶炼和压延加工业#20.有色金属冶炼和压延加工业#21.金属制品业#22.通用设备制造业#23.专用设备制造业#24.汽车制造业#25.铁路、船舶、航空航天和其他运输设备制造业#26.电气机械和器材制造业#27.计算机、通信和其他电子设备制造业#28.仪表仪器制造业#29.其他制造业#(三)电力、热力、燃气及水的生产和供应业#1.电力、热力的生产和供应业#2.燃气生产和供应业#3.水的生产和供应业#(四)建筑业#1.房屋建筑业#2.土木工程建筑业#3.建筑安装业#4.建筑装饰和其他建筑业#三、第三产业#(一)批发和零售业#1.批发业#2.零售业#(二)交通运输、仓储和邮政业#1.交通运输业#2.仓储业#3.邮政业#(三)住宿和餐饮业#1.住宿业#2.餐饮业#(四)信息传输、软件和信息技术服务业#1.电信、广播电视和卫星传输服务业#2.互联网和相关服务#3.软件和信息技术服务业#(五)金融业#1.货币金融服务#2.资本市场服务#3.保险业#4.其他金融业#(六)房地产业#(七)租赁和商务服务业#1.租赁业#2.商务服务业#(八)科学研究和技术服务业#(九)居民服务、修理和其他服务业#(十)教育#(一)卫生和社会工作#(十二)文化、体育和娱乐业#(十三)公共管理、社会保障和社会组织#(十四)其他行业";
		colsHName[78] = "序号#项目#国内增值税#其中:一般纳税人增值税#国内消费税#营业税#企业所得税内资企业#企业所得税外资企业#个人所得税#城市维护建设税#房产税#印花税#城镇土地使用税#土地增值税#车辆购置税#车船税#耕地占用税#契税#其他各税#附列资料：纳税户数#登记户数#附：总机构户数#分支机构户数";
		

		sjNum[79] = 3;
		colsL[79] = "1ZZS#YBNSR#XGMNSR#2XFS#3YYS#4QYSDS#5GRSDS#6ZYS#7GDZCTZFXDJS#8CSWHJSS#9FCS#10YHS#11CZTDSYS#12TDZZS#13CCS#14CLGZS#15YYS#16GDZYS#17QS#18QTSS#FLZLNSHS#DJHS";
		colsH[79] = "XH#XM#HJ#NZQYXJ#NZQYGYQY#NZQYJTQY#NZQYGFHZQY#NZQYLYQY#NZQYQZGYKG1#NZQYGFGS#NZQYQZGYKG2#NZQYSYQY#NZQYQTQY#GATTZQY#QZGYKG1#WSTZQY#QZGYKG2#GTJY#FZJGHS1#FZJGHS2";
		colsLName[79] = "1.增值税#一般纳税人#小规模纳税人#2.消费税#3.营业税#4.企业所得税#5.个人所得税#6.资源税#7.固定资产投资方向调节税#8.城市维护建设税#9.房产税#10.印花税#11.城镇土地使用税#12.土地增值税#13.车船税#14.车辆购置税#15.烟叶税#16.耕地占用税#17.契税#18.其他税收#附列资料：纳税户数#登记户数";
		colsHName[79] = "序号#项目#合计#内资企业小计#内资企业国有企业#内资企业集体企业#内资企业股份合作企业#内资企业联营企业#内资企业其中：国有控股#内资企业股份公司#内资企业其中：国有控股#内资企业私营企业#内资企业其他企业#港澳台投资企业#其中：国有控股#外商投资企业#其中：国有控股#个体经营#附：总机构户数#分支机构户数";
		

		sjNum[0] = 0;
		colsL[0] = "";
		colsH[0] = "";
		colsLName[0] = "";
		colsHName[0] = "";
		

		
		
	}
	

}
