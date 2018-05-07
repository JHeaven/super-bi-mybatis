package com.heaven.main.analyse2018;

/**
 * 2018版本
 * 参数生成map和sql
 * 
 * @author jiangyqc
 *
 */
public class AnalyseFormula6 {

	static String sjFlag = "";
	
	static String [] colsL = new String [10000];
	static String [] colsH = new String [10000];
	
	static String [] colsLName = new String [10000];
	static String [] colsHName = new String [10000];
	
	static int [] sjNum = new int [10000];
 
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
				getMaps(i);
				System.out.println();
				//解析SQL
				//getSql(i);
				//getMapsTips(i);
				//checkRep(i);
			}
		}
		
	}
	
	
	
	private static void checkRep(int i) {
		// TODO Auto-generated method stub
		String [] colsOfL = colsL[i].split("#");
		String [] colsOfH = colsH[i].split("#");
		
		for (int j = 0; j < colsOfH.length; j++) {
			for (int j2 = j+1; j2 < colsOfH.length; j2++) {
				if (colsOfH[j].equals(colsOfH[j2])) {
					System.out.println("WARING-H:rep-["+sjFlag+"]-["+colsOfH[j]+"]");
				}
			}
		}
		
		
		for (int j = 0; j < colsOfL.length; j++) {
			for (int j2 = j+1; j2 < colsOfL.length; j2++) {
				if (colsOfL[j].equals(colsOfL[j2])) {
					System.out.println("WARING-L:rep-["+sjFlag+"]-["+colsOfL[j]+"]");
				}
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
					System.out.println("insert into gy_bbcx_shxx_maps  (uuid, bbmc, colname, colmap, colnum, bylx, yxbz,NFSQ) values (sys_guid(), 'SJ"+sjFlag+"', '"+colsOfLName[j]+"','"+colsOfL[j]+"',"+j+",'L','Y',2018);");
				}
				
				//H
				for (int j = 0; j < colsOfH.length; j++) {
					System.out.println("insert into gy_bbcx_shxx_maps  (uuid, bbmc, colname, colmap, colnum, bylx, yxbz,NFSQ) values (sys_guid(), 'SJ"+sjFlag+"', '"+colsOfHName[j]+"','"+colsOfH[j]+"',"+j+",'H','Y',2018);");
				}
				
				
			}else {
				System.out.println(i + "-->colsOfL.length != colsOfLName.length");
			}
		}else {
			System.out.println(i + "--->colsOfL.length != colsOfLName.length");
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
		colsH[1] = "XH#ZJZYKM#ZJZYNCYE#ZJZYQMYE#ZJLYKM#ZJLYNCYE#ZJLYQMYE";
		colsLName[1] = "合计#1.待征税收#2.待征其他收入#3.减免税金#4.待解税金#5.在途税金#6.入库税收#7.入库其他收入#8.提退税金#9.待处理损失税金#10.损失税金核销#11.保管款";
		colsHName[1] = "序号#资金占用科目#资金占用年初余额#资金占用期末余额#资金来源科目#资金来源年初余额#资金来源期末余额";

		sjNum[2] = 4;
		colsL[2] = "1ZJ#2YSSSRHJ#31ZZSSR#41GNZZS#5YBZZS#6GZZZS#7QZZGTLZGSGZZZSSR#8CJRJYZZSTS#9RJZZSTS#10SGZHLYZZSTS#11SDZZSTS#12ZYZHLYZZSTS#13CPYZZSTS#14MDDZZZS#15MDDZGZZZS#162JKHWZZS#172XFSSR#18GNXFS#19QZCPYXFS#20JKXFPXFS#21QZJKCPYXFS#223YYS#23JRBXYYYS#24QTYYS#254QYSDS#26QZZYGDSR#271YBQYSDS#28NZQY#29WZQY#302FZJGYJSDS#31NZQY#32WZQY#333ZJGYJSDS#34NZQY#35WZQY#364FZJGHSQJSDS#37NZQY#38WZQY#395ZJGHSQJSDS#40NZQY#41WZQY#426QYSDSDFPSR#43NZQY#44WZQY#455GRSDS#46LXSDS#47QTGRSDS#486ZYS#497CSWHJSS#508FCS#519YHS#52ZQJYYHS#53QTYHS#5410CZTDSYS#5511TDZZS#5612CCS#5713CLGZS#5814YYS#5915GDZYS#6016QS#6117HJBHS#6218QTSS#63ECPYXFSTS#64SCKTSHJ#651CKHWTZZS#662GZZZSCKTS#673MDDJZZS#684MDDJGZZZS#695CKXFPTXFS#70SFSSRHJ#711JYFFJSR#722DFJYFJ#733WHSYJSFSR#744HSSYKQSYFSR#755SWBMFMSR#766CJRJYBZJJ#777SHBXJJSR#78QYZGJBYLBXJJSR#79SYBXJJSR#80ZGJBYLBXJJSR#81GSBXJJSR#82SYBXJJSR#83XXNCHZYLJJSR#84CZJMJBYLBXJJSR#85CXJMJBYLBXJJSR#86JGSYDWJBYLBXJJSR#87CXJMJBYLBXJJSR#88QTSHBXJJSR#898ZFXJJSR#90FQDQDZCPCLJJSR#91QTZFXJJSR#929GHJFSR#9310QTFSSR";
		colsH[2] = "XH#XM#HJ#BNXQRK#2001N5Y1RYHCQRK#2001N5Y1RYQCQRK#ZY#DFXJ1#DFSJ1#DFSJ2#DFXJ2";
		colsLName[2] = "总计#一、税收收入合计#1.增值税收入#(1)国内增值税#一般增值税#改征增值税#其中：中国铁路总公司改征增值税收入#残疾人就业增值税退税#软件增值税退税#森工综合利用增值税退税#水电增值税退税#资源综合利用增值税退税#成品油增值税退税#免抵调增增值税#免抵调增改征增值税#(2)进口货物增值税#2.消费税收入#国内消费税#其中：成品油消费税#进口消费品消费税#其中：进口成品油消费税#3.营业税#金融保险业营业税#其他营业税#4.企业所得税#其中：中央固定收入#（1）一般企业所得税#内资企业#外资企业#（2）分支机构预缴所得税#内资企业#外资企业#（3）总机构预缴所得税#内资企业#外资企业#（4）分支机构汇算清缴所得税#内资企业#外资企业#（5）总机构汇算清缴所得税#内资企业#外资企业#（6）企业所得税待分配收入#内资企业#外资企业#5.个人所得税#利息所得税#其他个人所得税#6.资源税#7.城市维护建设税#8.房产税#9.印花税#证券交易印花税#其他印花税#10.城镇土地使用税#11.土地增值税#12.车船税#13.车辆购置税#14.烟叶税#15.耕地占用税#16.契税#17.环境保护税#18.其他税收#二、成品油消费税退税#三、出口退税合计#1.出口货物退增值税#2.改征增值税出口退税#3.免抵调减增值税#4.免抵调减改征增值税#5.出口消费品退消费税#四、非税收入合计#1.教育费附加收入#2.地方教育附加#3.文化事业建设费收入#4.海上石油矿区使用费收入#5.税务部门罚没收入#6.残疾人就业保障基金#7.社会保险基金收入#企业职工基本养老保险基金收入#失业保险基金收入#职工基本医疗保险基金收入#工伤保险基金收入#生育保险基金收入#新型农村合作医疗基金收入#城镇居民基本医疗保险基金收入#城乡居民基本养老保险基金收入#机关事业单位基本养老保险基金收入#城乡居民基本医疗保险基金收入#其他社会保险基金收入#8.政府性基金收入#废弃电器电子产品处理基金收入#其他政府性基金收入#9.工会经费收入#10.其他非税收入";
		colsHName[2] = "序号#项目#合计#本年新欠入库#2001年5月1日以后陈欠入库#2001年5月1日以前陈欠入#中央#地方小计#地方省级#地方市级#地方县级";


		sjNum[3] = 3 ;
		colsL[3] = "ZJ#YSSSRHJ#1ZZSSR#QZGZZZS#2XFSSR#3YYS#4QYSDS#5GRSDS#6ZYS#7CSWHJSS#8FCS#9YHS#10CZTDSYS#11TDZZS#12CCS#13CLGZS#14YYS#15GDZYS#16QS#17HJBHS#18QTSS#EQTSRHJ#QZFQDQDZCPCLJJSR";
		colsH[3] = "XH#XM#NCYE#DNFSEHJ#DNFSEGYQY#DNFSEJTQY#DNFSEGFHZQY#DNFSELYQY#DNFSEQZGYKG1#DNFSEGFGS#DNFSEQZGYKG2#DNFSESYQY#DNFSEGATTZQY#DNFSEQZGYKG3#DNFSEWSTZQY#DNFSEQZGYKG4#DNFSEQTQY#QMYE";
		colsLName[3] = "总计#一、税收收入合计#1.增值税收入#其中：改征增值税#2.消费税收入#3.营业税#4.企业所得税#5.个人所得税#6.资源税#7.城市维护建设税#8.房产税#9.印花税#10.城镇土地使用税#11.土地增值税#12.车船税#13.车辆购置税#14.烟叶税#15.耕地占用税#16.契税#17.环境保护税#18.其他税收#二、其他收入合计#其中：废弃电器电子产品处理基金收入";
		colsHName[3] = "序号#项目#年初余额#当年发生额合计#当年发生额国有企业#当年发生额集体企业#当年发生额股份合作企业#当年发生额联营企业#当年发生额其中国有控股#当年发生额股份公司#当年发生额其中国有控股#当年发生额私营企业#当年发生额港澳台投资企业#当年发生额其中国有控股#当年发生额外商投资企业#当年发生额其中国有控股#当年发生额其他企业#期末余额";



		sjNum[4] = 2;
		colsL[4] = "1ZJ#2YSSSRHJ#3WDQYJSK#4JPZHZ#5GTJKKQYQS#6WNCQ#7BNXQ#81GNZZS#9QZGZZZS#10WDQYJSK#11JPZHZ#12GTJKKQYQS#13WNCQ#14BNXQ#152GNXFS#16WDQYJSK#17JPZHZ#18GTJKKQYQS#19WNCQ#20BNXQ#213YYS#22WDQYJSK#23JPZHZ#24GTJKKQYQS#25WNCQ#26BNXQ#274QYSDS#28WDQYJSK#29JPZHZ#30GTJKKQYQS#31WNCQ#32BNXQ#335GRSDS#34WDQYJSK#35JPZHZ#36GTJKKQYQS#37WNCQ#38BNXQ#396ZYS#40WDQYJSK#41JPZHZ#42GTJKKQYQS#43WNCQ#44BNXQ#457CSWHJSS#46WDQYJSK#47JPZHZ#48GTJKKQYQS#49WNCQ#50BNXQ#518FCS#52WDQYJSK#53JPZHZ#54GTJKKQYQS#55WNCQ#56BNXQ#579YHS#58WDQYJSK#59JPZHZ#60GTJKKQYQS#61WNCQ#62BNXQ#6310CZTDSYS#64WDQYJSK#65JPZHZ#66GTJKKQYQS#67WNCQ#68BNXQ#6911TDZZS#70WDQYJSK#71JPZHZ#72GTJKKQYQS#73WNCQ#74BNXQ#7512CCS#76WDQYJSK#77JPZHZ#78GTJKKQYQS#79WNCQ#80BNXQ#8113YYS#82WDQYJSK#83JPZHZ#84GTJKKQYQS#85WNCQ#86BNXQ#8714GDZYS#88WDQYJSK#89JPZHZ#90GTJKKQYQS#91WNCQ#92BNXQ#9315QS#94WDQYJSK#95JPZHZ#96GTJKKQYQS#97WNCQ#98BNXQ#9916HJBHS#100WDQYJSK#101JPZHZ#102GTJKKQYQS#103WNCQ#104BNXQ#10517QTSS#106WDQYJSK#107JPZHZ#108GTJKKQYQS#109WNCQ#110BNXQ#111EQTSRHJ#112QZFQDQDZCPCLJJSR";
		colsH[4] = "XH#XM#QCYE#BQZJE#BQJSE#QMYE";
		colsLName[4] = "总计#一、税收收入合计#未到期应缴税款#经批准缓征#关、停及空壳企业欠税#往年陈欠#本年新欠#1.国内增值税#其中：改征增值税#未到期应缴税款#经批准缓征#关、停及空壳企业欠税#往年陈欠#本年新欠#2.国内消费税#未到期应缴税款#经批准缓征#关、停及空壳企业欠税#往年陈欠#本年新欠#3.营业税#未到期应缴税款#经批准缓征#关、停及空壳企业欠税#往年陈欠#本年新欠#4.企业所得税#未到期应缴税款#经批准缓征#关、停及空壳企业欠税#往年陈欠#本年新欠#5.个人所得税#未到期应缴税款#经批准缓征#关、停及空壳企业欠税#往年陈欠#本年新欠#6.资源税#未到期应缴税款#经批准缓征#关、停及空壳企业欠税#往年陈欠#本年新欠#7.城市维护建设税#未到期应缴税款#经批准缓征#关、停及空壳企业欠税#往年陈欠#本年新欠#8.房产税#未到期应缴税款#经批准缓征#关、停及空壳企业欠税#往年陈欠#本年新欠#9.印花税#未到期应缴税款#经批准缓征#关、停及空壳企业欠税#往年陈欠#本年新欠#10.城镇土地使用税#未到期应缴税款#经批准缓征#关、停及空壳企业欠税#往年陈欠#本年新欠#11.土地增值税#未到期应缴税款#经批准缓征#关、停及空壳企业欠税#往年陈欠#本年新欠#12.车船税#未到期应缴税款#经批准缓征#关、停及空壳企业欠税#往年陈欠#本年新欠#13.烟叶税#未到期应缴税款#经批准缓征#关、停及空壳企业欠税#往年陈欠#本年新欠#14.耕地占用税#未到期应缴税款#经批准缓征#关、停及空壳企业欠税#往年陈欠#本年新欠#15.契税#未到期应缴税款#经批准缓征#关、停及空壳企业欠税#往年陈欠#本年新欠#16.环境保护税#未到期应缴税款#经批准缓征#关、停及空壳企业欠税#往年陈欠#本年新欠#17.其他税收#未到期应缴税款#经批准缓征#关、停及空壳企业欠税#往年陈欠#本年新欠#二、其他收入合计#其中：废弃电器电子产品处理基金收入";
		colsHName[4] = "序号#项目#期初余额#本期增加额#本期减少额#期末余额";



		sjNum[5] = 2;
		colsL[5] = "ZJ#YSSSRHJ#1ZZS#QZGZZZS#JXLD#2XFS#QZCPYXFS#3YYS#4QYSDS#5GRSDS#6ZYS#7CSWHJSS#8FCS#9YHS#10CZTDSYS#11TDZZS#12CCS#13CLGZS#14YYS#15GDZYS#16QS#17HJBHS#18QTSS#EQTSRHJ#QZFQDQDZCPCLJJSR#FLZLZZSJXLDSE";
		colsH[5] = "XH#XM#HJ#CKTS#XZHT#JMTS#HSQJJSTS#WSTS#QTTS";
		colsLName[5] = "总计#一、税收收入合计#1.增值税#其中：改征增值税#进项留抵#2.消费税#其中：成品油消费税#3.营业税#4.企业所得税#5.个人所得税#6.资源税#7.城市维护建设税#8.房产税#9.印花税#10.城镇土地使用税#11.土地增值税#12.车船税#13.车辆购置税#14.烟叶税#15.耕地占用税#16.契税#17.环境保护税#18.其他税收#二、其他收入合计#其中：废弃电器电子产品处理基金收入#附列资料：增值税进项留抵税额";
		colsHName[5] = "序号#项目#合计#出口退税#先征后退#减免退税#汇算清缴结算退税#误收退税#其他退税";


		sjNum[6] = 3 ;
		colsL[6] = "ZJ#QZZQJM#TKJM#DDQS#YGSMS#1ZF#2JZJZJ#3JZZY#4ZJYFC#5SHBZ#6TGJMSR#7QT#EGLGXJS#1JSZR#2KJFZ#3ZZCX#4KYJGZZ#5TZCY#6WBFW#7GXJS#8QT#SCJXWQYFZ#1JRSC#2WDQZD#3MZZZSHYYSZC#4QT1#SZZSJ#1QYFZ#2QYZZGZ#3QT#WJNHB#1HJBH#2DLJS#3ZYZHLY#4QT2#LCJQYFZ#1XBKF#2DBFZ#3LAJL#4QT3#QZCWHJYTY#1JY#2TY#3WH#BZCJRZBSC#1ZBSC#2JRSC#JZCSN#1NCJS#2FLSL#3CYSJ#4JRSC#5QT1#SZCQTGXSY#1FJZZ#2JCSSJS#3CPY#4GFJS#5GJF#6YLWS#7JTYS#8WCYZ#9GY#10SPCB#11WJRY#12ZXCZXZJ#13QT2#SYXSSSXDDY#1GX#2LX#3TXQSYF#4CCSY#5QT3";
		colsH[6] = "XH#XM#HJ#SSSRXJ#SSSRZZS#SSSRQZGZZZS#SSSRXFS#SSSRYYS#SSSRQYSDS#SSSRGRSDS#SSSRZYS#SSSRCSWHJSS#SSSRFCS#SSSRYHS#SSSRCZTDSYS#SSSRTDZZS#SSSRCCS#SSSRCLGZS#SSSRGDZYS#SSSRQS#SSSRHJBHS#SSSRQTSS#QTSRHJ#QYSDSYJYJJM";
		colsLName[6] = "总计#其中：征前减免#退库减免#抵顶欠税#一、改善民生#1.住房#2.救灾及重建#3.军转择业#4.再就业扶持#5.社会保障#6.提高居民收入#7.其他#二、鼓励高新技术#1.技术转让#2.科技发展#3.自主创新#4.科研机构转制#5.投资创业#6.外包服务#7.高新技术#8.其他#三、促进小微企业发展#1.金融市场#2.未达起征点#3.免征增值税和营业税政策#4.其他#四、转制升级#1.企业发展#2.企业重组改制#3.其他#五、节能环保#1.环境保护#2.电力建设#3.资源综合利用#4.其他#六、促进区域发展#1.西部开发#2.东部发展#3.两岸交流#4.其他#七、支持文化教育体育#1.教育#2.体育#3.文化#八、支持金融资本市场#1.资本市场#2.金融市场#九、支持三农#1.农村建设#2.肥料饲料#3.产业升级#4.金融市场#5.其他#十、支持其他各项事业#1.飞机制造#2.基础设施建设#3.成品油#4.国防建设#5.公检法#6.医疗卫生#7.交通运输#8.无偿援助#9.公益#10.商品储备#11.外籍人员#12.专项财政性资金#13.其他#十一、享受税收协定待遇#1.股息#2.利息#3.特许权使用费#4.财产收益#5.其他";
		colsHName[6] = "序号#项目#合计#税收收入小计#税收收入增值税#税收收入其中：改征增值税#税收收入消费税#税收收入营业税#税收收入企业所得税#税收收入个人所得税#税收收入资源税#税收收入城市维护建设税#税收收入房产税#税收收入印花税#税收收入城镇土地使用税#税收收入土地增值税#税收收入车船税#税收收入车辆购置税#税收收入耕地占用税#税收收入契税#税收收入环境保护税#税收收入其他税收#其他收入合计#企业所得税月（季）预缴减免";

		sjNum[7] = 3;
		colsL[7] = "ZJ#YSSSRHJ#1ZZSSR#QZGNZZS#2XFSSR#QZGNXFS#3YYS#4QYSDS#5GRSDS#6ZYS#7CSWHJSS#8FCS#9YHS#10CZTDSYS#11TDZZS#12CCS#13CLGZS#14YYS#15GDZYS#16QS#17HJBHS#18QTSS#EQTSRHJ#FQDQDZCPCLJJSR";
		colsH[7] = "XH#XM#DJSJNCYE1#DJSJQMYE2#ZTSJNCYE#ZTSJQMYE#DJSJNCYE#DJSJQMYE3#DCLSSSJNCYE#DCLSSSJQMYE#SSSJHXNCYE#SSSJHXQMYE";
		colsLName[7] = "总计#一、税收收入合计#1.增值税收入#其中：国内增值税#2.消费税收入#其中：国内消费税#3.营业税#4.企业所得税#5.个人所得税#6.资源税#7.城市维护建设税#8.房产税#9.印花税#10.城镇土地使用税#11.土地增值税#12.车船税#13.车辆购置税#14.烟叶税#15.耕地占用税#16.契税#17.环境保护税#18.其他税收#二、其他收入合计#废弃电器电子产品处理基金收入";
		colsHName[7] = "序号#项目#多缴税金年初余额#多缴税金期末余额#在途税金年初余额#在途税金期末余额#待解税金年初余额#待解税金期末余额#待处理损失税金年初余额#待处理损失税金期末余额#损失税金核销年初余额#损失税金核销期末余额";

		sjNum[8] = 5;
		colsL[8] = "ZJ#YSSSRHJ#1ZZS#QZGZZZS#2XFS#3YYS#4QYSDS#5GRSDS#6ZYS#7CSWHJSS#8FCS#9YHS#10CZTDSYS#11TDZZS#12CCS#13CLGZS#14YYS#15GDZYS#16QS#17HJBHS#18QTSS#EQTSRHJ#QZ1JYFFJSR#2WHSYJSFSR#3FQDQDZCPCLJJSR#4QTFMSR";
		colsH[8] = "XH#XM#YZCBSJHJ#YZCBSJSWJCBMCBSK#YZCBSJSWJCBMCBZNJ#YZCBSJSWJCBMCBFK#YZCBSJSWJCBMCBQZZCBS#YZCBSJSWQTBMCBSK#YZCBSJSWQTBMCBZNJ#YZCBSJSWQTBMCBFK#YZCBSJSWQTBMCBQZ1TBNSDZ#YZCBSJSWQTBMCB2NSPG#YZCBSJWBMCBSK#YZCBSJWBMCBZNJ#YZCBSJWBMCBFK#RKCBSJHJ#RKCBSJSWJCBMCBXJXJ#RKCBSJSWJCBMCBXJZY#RKCBSJSWJCBMCBXJDF#RKCBSJSWJCBMCBSK#RKCBSJSWJCBMCBZNJ#RKCBSJSWJCBMCBFK#RKCBSJSWJCBMCBQZZCBS#RKCBSJSWQTBMCBSK#RKCBSJSWQTBMCBZNJ#RKCBSJSWQTBMCBFK#RKCBSJSWQTBMCBQZ1TBNSDZ#RKCBSJSWQTBMCB2NSPG#RKCBSJWBMCBSK#RKCBSJWBMCBZNJ#RKCBSJWBMCBFK#RKSKZNJFKSR";
		colsLName[8] = "总计#一、税收收入合计#1.增值税#其中：改征增值税#2.消费税#3.营业税#4.企业所得税#5.个人所得税#6.资源税#7.城市维护建设税#8.房产税#9.印花税#10.城镇土地使用税#11.土地增值税#12.车船税#13.车辆购置税#14.烟叶税#15.耕地占用税#16.契税#17.环境保护税#18.其他税收#二、其他收入合计#其中:1.教育费附加收入#2.文化事业建设费收入#3.废弃电器电子产品处理基金收入#4.其他罚没收入";
		colsHName[8] = "序号#项目#应征查补税金合计#应征查补税金税务稽查部门查补税款#应征查补税金税务稽查部门查补滞纳金#应征查补税金税务稽查部门查补罚款#应征查补税金税务稽查部门查补其中:自查补税#应征查补税金税务其它部门查补税款#应征查补税金税务其它部门查补滞纳金#应征查补税金税务其它部门查补罚款#应征查补税金税务其它部门查补其中：1.特别纳税调整#应征查补税金税务其它部门查补2.纳税评估#应征查补税金外部门查补税款#应征查补税金外部门查补滞纳金#应征查补税金外部门查补罚款#入库查补税金合计#入库查补税金税务稽查部门查补小计小计#入库查补税金税务稽查部门查补小计中央#入库查补税金税务稽查部门查补小计地方#入库查补税金税务稽查部门查补税款#入库查补税金税务稽查部门查补滞纳金#入库查补税金税务稽查部门查补罚款#入库查补税金税务稽查部门查补其中:自查补税#入库查补税金税务其它部门查补税款#入库查补税金税务其它部门查补滞纳金#入库查补税金税务其它部门查补罚款#入库查补税金税务其它部门查补其中：1.特别纳税调整#入库查补税金税务其它部门查补2.纳税评估#入库查补税金外部门查补税款#入库查补税金外部门查补滞纳金#入库查补税金外部门查补罚款#入库税款滞纳金、罚款收入";

		sjNum[9] =2 ;
		colsL[9] = "SSSRHJ#1ZZS#QZGZZZS#2XFS#3YYS#4QYSDS#5GRSDS#6ZYS#7CSWHJSS#8FCS#9YHS#10CZTDSYS#11TDZZS#12CCS#13CLGZS#14YYS#15GDZYS#16QS#17HJBHS#18QTSS";
		colsH[9] = "XH#XM#HJ#RKZNJ#HXZNJ#YJWJZNJ";
		colsLName[9] = "税收收入合计#1.增值税#其中：改征增值税#2.消费税#3.营业税#4.企业所得税#5.个人所得税#6.资源税#7.城市维护建设税#8.房产税#9.印花税#10.城镇土地使用税#11.土地增值税#12.车船税#13.车辆购置税#14.烟叶税#15.耕地占用税#16.契税#17.环境保护税#18.其他税收";
		colsHName[9] = "序号#项目#合计#入库滞纳金#核销滞纳金#应缴未缴滞纳金";

		sjNum[10] = 2;
		colsL[10] = "ZJ#YSSSRHJ#1ZZS#QZGZZZS#2XFS#3YYS#4QYSDS#5GRSDS#6ZYS#7CSWHJSS#8FCS#9YHS#QZZQJYYHS#10CZTDSYS#11TDZZS#12CCS#13CLGZS#14YYS#15GDZYS#16QS#17HJBHS#18QTSS#EQTSRHJ#QZJYFFJSR#FQDQDZCPCLJJSR";
		colsH[10] = "XH#XM#HJ#DKDS#WTDZ";
		colsLName[10] = "总计#一、税收收入合计#1.增值税#其中：改征增值税#2.消费税#3.营业税#4.企业所得税#5.个人所得税#6.资源税#7.城市维护建设税#8.房产税#9.印花税#其中：证券交易印花税#10.城镇土地使用税#11.土地增值税#12.车船税#13.车辆购置税#14.烟叶税#15.耕地占用税#16.契税#17.环境保护税#18.其他税收#二、其他收入合计#其中：教育费附加收入#废弃电器电子产品处理基金收入";
		colsHName[10] = "序号#项目#合计#代扣代收#委托代征";

		sjNum[11] =3 ;
		colsL[11] = "HJ#NSBZJ#FPBZJ#NSDBJ#SSBQK#PMBMK#QT";
		colsH[11] = "XH#XM#NCYE#SRBY#SRBNLJ#ZCBY#ZCBNLJ#QMYE";
		colsLName[11] = "合计#纳税保证金#发票保证金#纳税担保金#税收保全款#拍卖变卖款#其他";
		colsHName[11] = "序号#项目#年初余额#收入本月#收入本年累计#支出本月#支出本年累计#期末余额";

		sjNum[12] =2 ;
		colsL[12] = "ZJ#YSSSRHJ#1ZZS#2XFS#3YYS#4QYSDS#5GRSDS#6ZYS#7CSWHJSS#8FCS#9YHS#10CZTDSYS#11TDZZS#12CCS#13CLGZS#14YYS#15GDZYS#16QS#17HJBHS#18QTSS#EQTSRHJ";
		colsH[12] = "XH#XM#HJ#GTQYDZSJ#KKQYDZSJ#ZFZCXDZSJ#QT";
		colsLName[12] = "总计#一、税收收入合计#1.增值税#2.消费税#3.营业税#4.企业所得税#5.个人所得税#6.资源税#7.城市维护建设税#8.房产税#9.印花税#10.城镇土地使用税#11.土地增值税#12.车船税#13.车辆购置税#14.烟叶税#15.耕地占用税#16.契税#17.环境保护税#18.其他税收#二、其他收入合计";
		colsHName[12] = "序号#项目#合计#关、停企业呆帐税金#空壳企业呆帐税金#政府政策性呆帐税金#其他";

		sjNum[13] = 3;
		colsL[13] = "HJ#YJTYSFW#1LLYSFW#2SLYSFW#3HKYSFW#4GDYSFW#EYZFW#1YZPBFW#2YZTSFW#3QTYZFW#SDXFW#1JCDXFW#2ZZDXFW#SJZFW#1GCFW#2AZFW#3XSFW#4ZSFW#5QTJZFW#WJRFW#1DKFW#2ZJSFJRFW#3BXFW#4JRSPZR#LXDFW#1YFHJSFW#2XXJSFW#3WHCYFW#4WLFZFW#5ZLFW#6JZZXFW#7GBYSFW#8SWFZFW#9QTXDFW#QSHFW#1WHTYFW#2JYYLFW#3LYYLFW#4CYZSFW#5JMRCFW#6QTSHFW#BXSWXZC#1ZLHFZLJS#2SBHZZQ#3TDSYQ#4QTZRZYSYQ#5QTQYXWXZC#JXSBDC#1JZW#QZESFJY1#2GZW#QZESFJY2";
		colsH[13] = "XH#XM#RKSJ#YZSJNCYE#YZSJQMYE#DZSJNCYE#DZSJQMYE#TTSJ#JMSJ#DJSJ1#ZTSJ#DJSJ#DCLSSSJ#SSSJHX";
		colsLName[13] = "合计#一、交通运输服务#1.陆路运输服务#2.水路运输服务#3.航空运输服务#4.管道运输服务#二、邮政服务#1.邮政普遍服务#2.邮政特殊服务#3.其他邮政服务#三、电信服务#1.基础电信服务#2.增值电信服务#四、建筑服务#1.工程服务#2.安装服务#3.修缮服务#4.装饰服务#5.其他建筑服务#五、金融服务#1.贷款服务#2.直接收费金融服务#3.保险服务#4.金融商品转让#六、现代服务#1.研发和技术服务#2.信息技术服务#3.文化创意服务#4.物流辅助服务#5.租赁服务#6.鉴证咨询服务#7.广播影视服务#8.商务辅助服务#9.其他现代服务#七、生活服务#1.文化体育服务#2.教育医疗服务#3.旅游娱乐服务#4.餐饮住宿服务#5.居民日常服务#6.其他生活服务#八、销售无形资产#1.专利或非专利技术#2.商标和著作权#3.土地使用权#4.其他自然资源使用权#5.其他权益性无形资产#九、销售不动产#1.建筑物#其中：二手房交易#2.构筑物#其中：二手房交易";
		colsHName[13] = "序号#项目#入库税金#应征税金年初余额#应征税金期末余额#待征税金年初余额#待征税金期末余额#提退税金#减免税金#多缴税金#在途税金#待解税金#待处理损失税金#损失税金核销";

		sjNum[14] = 3;
		colsL[14] = "HJ#QZBNXQ#WNCQ#GTJKKQYQS#1GNZZS#QZGZZZS#2GNXFS#3YYS#4QYSDS#5GRSDS#6ZYS#7CSWHJSS#8FCS#9YHS#10CZTDSYS#11TDZZS#12CCS#13CLGZS#14YYS#15GDZYS#16QS#17HJBHS#18QTSS";
		colsH[14] = "XH#XM#QMYEHJ#DFXQJRK#DFXQJDJ#DFXQJHX#DFXQJQMYE#ZFXQJRK#ZFXQJDJ#ZFXQJHX#ZFXQJQMYE#GFXQJRK#GFXQJDJ#GFXQJHX#GFXQJQMYE#GWQJRK#GWQJDJ#GWQJHX#GWQJQMYE1#GWQJQMYE2";
		colsLName[14] = "合计#其中：本年新欠#往年陈欠#关停及空壳企业欠税#1.国内增值税#其中：改征增值税#2.国内消费税#3.营业税#4.企业所得税#5.个人所得税#6.资源税#7.城市维护建设税#8.房产税#9.印花税#10.城镇土地使用税#11.土地增值税#12.车船税#13.车辆购置税#14.烟叶税#15.耕地占用税#16.契税#17.环境保护税#18.其他税收";
		colsHName[14] = "序号#项目#期末余额合计#低风险欠缴入库#低风险欠缴抵缴#低风险欠缴核销#低风险欠缴期末余额#中风险欠缴入库#中风险欠缴抵缴#中风险欠缴核销#中风险欠缴期末余额#高风险欠缴入库#高风险欠缴抵缴#高风险欠缴核销#高风险欠缴期末余额#高危欠缴入库#高危欠缴抵缴#高危欠缴核销#高危欠缴期末余额#高危欠缴期末余额";


		sjNum[1501] =3;
		colsL[1501] = "1HJ#2YNLMYY#3ECKY#41MTKCHXXY#5YMHWYMKCXX#6HMKCXX#7QT#82SYHTRQKCY#9SYKC#10TRQKC#113HSJSKCXY#12TKCX#13MKGKCX#14QT#154YSJSKCXY#16CYYSJSKCX#17GJSKCX#18XYXTJSKCX#195FJSKCXY#20TSSKC#21HXKKC#22CY#23SMJQT#246KCZYJFZXHD#25MTKCHXXZYJFZXHD#26SYHTRQKCZYJFZXHD#27QT#287QTCKY#29SZZY#301NFSPJGY#31GWMZ#32SLJG#33ZWYJG#34ZTY#35TZJRLJG#36SCPJG#37⑦SCJLSGHJGJG#38⑧QT#392SPZZY#40BKSPZZ#41TGQKLJMJZZ#42FBSPZZ#43RZPZZ#44GTSPZZ#45DWPFJZPZZ#46⑦QT#473JYLHJZCZZY#48JDZZ#49JJZZ#50BJZZ#51PJZZ#52HJZZ#53PTJZZ#54QT#55YLZZ#56JZCJG#574YCZPY#58YYFK#59JYZZ#60QT#615FZY#62MFZJYRJJG#63MFZJRZJJG#64MFZJRZJJG#65SJFZJYRJJG#66HXZZJYRJJG#67ZZHGZBZWJQZPZZ#68⑦JYFZZCPZZ#69⑧CYYFZZCPZZ#706FZFZFSY#71JZFZZZ#72ZZHGZBZFZZZ#73FSZZ#747PGMPYMJQZPHZXY#75PGZZJG#76PGZPZZ#77MPZZJZPJG#78YMRJGJZPZZ#79ZXY";
		colsH[1501] = "XH#XM#SSSRHJ#GNZZS#QZYBNSRZZS#GNXFS#YYS#QYSDSNZQY#QYSDSWZQY#GRSDS#ZYS#CSWHJSS#FCS#YHS#CZTDSYS#TDZZS#CLGZS#CCS#GDZYS#QS#HJBHS#QTGS";
		colsLName[1501] = "合计#一、农、林、牧、渔业#二、采矿业#1.煤炭开采和洗选业#①烟煤和无烟煤开采洗选#②褐煤开采洗选#③其他#2.石油和天然气开采业#①石油开采#②天然气开采#3.黑色金属矿采选业#①铁矿采选#②锰矿、铬矿采选#③其他#4.有色金属矿采选业#①常用有色金属矿采选#②贵金属矿采选#③稀有稀土金属矿采选#5.非金属矿采选业#①土砂石开采#②化学矿开采#③采盐#④石棉及其他#6.开采专业及辅助性活动#①煤炭开采和洗选专业及辅助性活动#②石油和天然气开采专业及辅助性活动#③其他#7.其他采矿业#三、制造业#1.农副食品加工业#①谷物磨制#②饲料加工#③植物油加工#④制糖业#⑤屠宰及肉类加工#⑥水产品加工#⑦蔬菜、菌类、水果和坚果加工#⑧其他#2.食品制造业#①焙烤食品制造#②糖果、巧克力及蜜饯制造#③方便食品制造#④乳制品制造#⑤罐头食品制造#⑥调味品、发酵制品制造#⑦其他#3.酒、饮料和精制茶制造业#①酒的制造#酒精制造#白酒制造#啤酒制造#黄酒制造#葡萄酒制造#其他#②饮料制造#③精制茶加工#4.烟草制品业#①烟叶复烤#②卷烟制造#③其他#5.纺织业#①棉纺织及印染精加工#②毛纺织及染整精加工#③麻纺织及染整精加工#④丝绢纺织及印染精加工#⑤化纤织造及印染精加工#⑥针织或钩针编织物及其制品制造#⑦家用纺织制成品制造#⑧产业用纺织制成品制造#6.纺织服装、服饰业#①机织服装制造#②针织或钩针编织服装制造#③服饰制造#7.皮革、毛皮、羽毛及其制品和制鞋业#①皮革鞣制加工#②皮革制品制造#③毛皮鞣制及制品加工#④羽毛(绒)加工及制品制造#⑤制鞋业";
		colsHName[1501] = "序号#项目#税收收入合计#国内增值税#其中：一般纳税人增值税#国内消费税#营业税#企业所得税内资企业#企业所得税外资企业#个人所得税#资源税#城市维护建设税#房产税#印花税#城镇土地使用税#土地增值税#车辆购置税#车船税#耕地占用税#契税#环境保护税#其他各税";




		sjNum[1502] =3;
		colsL[1502] = "8MCJGHMZTZCZPY#MCJG#RZBZZ#MZZPZZ#ZTZCDZPZZ#9JJZZY#MZJJZZ#ZTJJZZ#JSJJZZ#SLJJZZ#QT#10ZZHZZPY#ZJZZ#ZZ#ZZPZZ#11YSHJLMJFZY#YS#ZDJYSXGFW#JLMJFZ#12WJGMTYHYLYPZZY#WJBGYPZZ#LQZZ#GYMSJLYYPZZ#TYYPZZ#WJZZ#YYQCJYLYPZZ#13SYMTJQTRLJGY#JLSYCPZZ#QZYYJGJSYZPZZ#MTJG#HRLJG#SWZRLJG#14HXYLHHXZPZZY#JCHXYLZZ#FLZZ#NYZZ#TLYMYLJLSCPZZ#HCCLZZ#ZYHXCPZZ#QZWHYXXHXPZZ#YXSCYXXHXPZZ#ZYHGJYHCPZZ#RYHXCPZZ#15YYZZY#HXYPYLYZZ#HXYPZJZZ#ZYYPJG#ZCYSC#SYYPZZ#SWYPZPZZ#QZSWYPZZ#JYGCYWHYMZZ#WSCLJYYYPZZ#YYFLJBZCL#16HXXWZZY#XWSXWYLJXWZZ#HCXWZZ#SWJCLZZ#17XJHSLZPY#XJZPY#SLZPY#18FJSKWZPY#SNSHHSGZZ#SNZZ#SHHSGZZ#SGSNZPJLSZPZZ#QZSNZPZZ#ZWSCDJZCLZZ#BLZZ#BLZPZZ#BLXWHBLXWZQSLZPZZ#TCZPZZ#NHCLZPZZ#SMJQT#19HSJSYLHYYJGY#LT#LG#GYYJG#THJYL#20YSJSYLHYYJGY#CYYSJSYL#GJSYL#XYXTJSYL#YSJSHJZZ#YSJSYYJG";
		colsH[1502] = "XH#XM#SSSRHJ#GNZZS#QZYBNSRZZS#GNXFS#YYS#QYSDSNZQY#QYSDSWZQY#GRSDS#ZYS#CSWHJSS#FCS#YHS#CZTDSYS#TDZZS#CLGZS#CCS#GDZYS#QS#HJBHS#QTGS";
		colsLName[1502] = "8.木材加工和木竹藤棕草制品业#①木材加工#②人造板制造#③木质制品制造#④竹、藤、棕、草等制品制造#9.家具制造业#①木质家具制造#②竹、藤家具制造#③金属家具制造#④塑料家具制造#⑤其他#10.造纸和纸制品业#①纸浆制造#②造纸#③纸制品制造#11.印刷和记录媒介复制业#①印刷#②装订及印刷相关服务#③记录媒介复制#12.文教、工美、体育和娱乐用品制造业#①文教办公用品制造#②乐器制造#③工艺美术及礼仪用品制造#④体育用品制造#⑤玩具制造#⑥游艺器材及娱乐用品制造#13.石油、煤炭及其他燃料加工业#①精炼石油产品制造#其中:原油加工及石油制品制造#②煤炭加工#③核燃料加工#④生物质燃料加工#14.化学原料和化学制品制造业#①基础化学原料制造#②肥料制造#③农药制造#④涂料、油墨、颜料及类似产品制造#⑤合成材料制造#⑥专用化学产品制造#其中：文化用信息化学品制造#医学生产用信息化学品制造#⑦炸药、火工及焰火产品制造#⑧日用化学产品制造#15.医药制造业#①化学药品原料药制造#②化学药品制剂制造#③中药饮片加工#④中成药生产#⑤兽用药品制造#⑥生物药品制品制造#其中：生物药品制造#基因工程药物和疫苗制造#⑦卫生材料及医药用品制造#⑧药用辅料及包装材料#16.化学纤维制造业#①纤维素纤维原料及纤维制造#②合成纤维制造#③生物基材料制造#17.橡胶和塑料制品业#①橡胶制品业#②塑料制品业#18.非金属矿物制品业#①水泥、石灰和石膏制造#水泥制造#石灰和石膏制造#②石膏、水泥制品及类似制品制造#其中:水泥制品制造#③砖瓦、石材等建筑材料制造#④玻璃制造#⑤玻璃制品制造#⑥玻璃纤维和玻璃纤维增强塑料制品制造#⑦陶瓷制品制造#⑧耐火材料制品制造#⑨石墨及其他#19.黑色金属冶炼和压延加工业#①炼铁#②炼钢#③钢压延加工#④铁合金冶炼#20.有色金属冶炼和压延加工业#①常用有色金属冶炼#②贵金属冶炼#③稀有稀土金属冶炼#④有色金属合金制造#⑤有色金属压延加工";
		colsHName[1502] = "序号#项目#税收收入合计#国内增值税#其中：一般纳税人增值税#国内消费税#营业税#企业所得税内资企业#企业所得税外资企业#个人所得税#资源税#城市维护建设税#房产税#印花税#城镇土地使用税#土地增值税#车辆购置税#车船税#耕地占用税#契税#环境保护税#其他各税";




		sjNum[1503] =3;
		colsL[1503] = "16521JSZPY#166JGXJSZPZZ#167JSGJZZ#168JZXJJSBZRQZZ#169JSSSJQZPZZ#170JZAQYJSZPZZ#171JSBMCLJRCLJG#172TCZPZZ#173JSZRYPZZ#174ZZJQTJSZPZZ#175QZHSJSZZ#176YSJSZZ#17722TYSBZZY#178GLJYDSBZZ#179JSJGJXZZ#180WLBYSBZZ#181BFMYSJJLSJXZZ#182ZCCLHCDBJZZ#183HLFJBZDSBZZ#184WHBGYJXZZ#185QZFYHJYSBZZ#186JSQJHBZYSBZZ#187TYLBJZZ#188QT#189QZGYJQRZZ#190TSZYJQRZZ#19123ZYSBZZY#192CKYJJZZYSBZZ#193HGMCFJSJGZYSBZZ#194SPYLYCJSLSCZYSBZZ#195YSZYRHJRYPSCZYSBZZ#196FZFZHPGJGZYSBZZ#197DZHDGJXZYSBZZ#198QZBDTQJZYSBZZ#199DZYQJYJDZJSBZZ#200QTDZZYSBZZ#201NLMYZYJXZZ#202YLYQSBJQXZZ#203HBYZSHGGFWJQTZYSBZZ#20424QCZZY#205QCZCZZ#206QZXNYCZCZZ#207QCYFDJZZ#208GZQCZZ#209DSQCZZ#210DCZZ#211QCCSGCZZ#212QCLBJJPJZZ#21325TLCBHKHTHQTYSSBZZY#214TLYSSBZZ#215QZGTCZZZ#216GTSBPJZZ#217CSGDJTSBZZ#218CBJXGZZZZ#219HKHTQJSBZZ#220FJZZ#221HTQJYZHJZZ#222HTXGSBZZ#223HKXGSBZZ#224QTHKHTQZZ#225MTCZZ#226ZXCHCJRZCZZ#227ZLCZZ#228FGLXXCJLPJZZ#229QSJLJQT#23026DQJXHQCZZY#231DJZZ#232FDJJFDJZZZ#233DDJZZ#234WTDJJZJZZ#235QTDJZZ#236SPDJKZSBZZ#237BYQZLQHDGQZZ#238DRQJQPTSBZZ#239PDKGKZSBZZ#240DLDZYQJZZ#241GFSBJYQJZZ#242QT#243DXDLGLJDGQCZZ#244DXDLZZ#245GXZZ#246GLZZ#247JYZPZZ#248QT#249DCZZ#250QZZLZDCZZ#251JYDLQJZZ#252FDLJYQJZZ#253ZMQJZZ#254QZZNZMQJZZ#255QT#25627JSJTXHQTDZSBZZY#257JSJZZ#258JSJZJZZ#259JSJLBJZZ#260JSJWWSBZZ#261GYKZJSJJXTZZ#262XXAQSBZZ#263QT";
		colsH[1503] = "XH#XM#SSSRHJ#GNZZS#QZYBNSRZZS#GNXFS#YYS#QYSDSNZQY#QYSDSWZQY#GRSDS#ZYS#CSWHJSS#FCS#YHS#CZTDSYS#TDZZS#CLGZS#CCS#GDZYS#QS#HJBHS#QTGS";
		colsLName[1503] = "21.金属制品业#①结构性金属制品制造#②金属工具制造#③集装箱及金属包装容器制造#④金属丝绳及其制品制造#⑤建筑、安全用金属制品制造#⑥金属表面处理及热处理加工#⑦搪瓷制品制造#⑧金属制日用品制造#⑨铸造及其他金属制品制造#其中：黑色金属铸造#有色金属铸造#22.通用设备制造业#①锅炉及原动设备制造#②金属加工机械制造#③物料搬运设备制造#④泵、阀门、压缩机及类似机械制造#⑤轴承、齿轮和传动部件制造#⑥烘炉、风机、包装等设备制造#⑦文化、办公用机械制造#其中：复印和胶印设备制造#计算器及货币专用设备制造#⑧通用零部件制造#⑨其他#其中：工业机器人制造#特殊作业机器人制造#23.专用设备制造业#①采矿、冶金、建筑专用设备制造#②化工、木材、非金属加工专用设备制造#③食品、饮料、烟草及饲料生产专用设备制造#④印刷、制药、日化及日用品生产专用设备制造#⑤纺织、服装和皮革加工专用设备制造#⑥电子和电工机械专用设备制造#其中：半导体器件专用设备制造#电子元器件与机电组件设备制造#其他电子专用设备制造#⑦农、林、牧、渔专用机械制造#⑧医疗仪器设备及器械制造#⑨环保、邮政、社会公共服务及其他专用设备制造#24.汽车制造业#①汽车整车制造#其中：新能源车整车制造#②汽车用发动机制造#③改装汽车制造#④低速汽车制造#⑤电车制造#⑥汽车车身、挂车制造#⑦汽车零部件及配件制造#25.铁路、船舶、航空航天和其他运输设备制造业#①铁路运输设备制造#其中:高铁车组制造#高铁设备、配件制造#②城市轨道交通设备制造#③船舶及相关装置制造#④航空、航天器及设备制造#飞机制造#航天器及运载火箭制造#航天相关设备制造#航空相关设备制造#其他航空航天器制造#⑤摩托车制造#⑥自行车和残疾人座车制造#⑦助力车制造#⑧非公路休闲车及零配件制造#⑨潜水救捞及其他#26.电气机械和器材制造业#①电机制造#发电机及发电机组制造#电动机制造#微特电机及组件制造#其他电机制造#②输配电及控制设备制造#变压器、整流器和电感器制造#电容器及其配套设备制造#配电开关控制设备制造#电力电子元器件制造#光伏设备及元器件制造#其他#③电线、电缆、光缆及电工器材制造#电线、电缆制造#光纤制造#光缆制造#绝缘制品制造#其他#④电池制造#其中：锂离子电池制造#⑤家用电力器具制造#⑥非电力家用器具制造#⑦照明器具制造#其中：智能照明器具制造#⑧其他#27.计算机、通信和其他电子设备制造业#①计算机制造#计算机整机制造#计算机零部件制造#计算机外围设备制造#工业控制计算机及系统制造#信息安全设备制造#其他";
		colsHName[1503] = "序号#项目#税收收入合计#国内增值税#其中：一般纳税人增值税#国内消费税#营业税#企业所得税内资企业#企业所得税外资企业#个人所得税#资源税#城市维护建设税#房产税#印花税#城镇土地使用税#土地增值税#车辆购置税#车船税#耕地占用税#契税#环境保护税#其他各税";

		sjNum[1504] =3;
		colsL[1504] = "264TXSBZZ#265TXXTSBZZ#266TXZDSBZZ#267GBDSSBZZ#268LDJPTSBZZ#269FZYSTSBZZ#270ZNXFSBZZ#271QZKCDZNSBZZ#272ZNCZSBZZ#273ZNWRFXQZZ#274FWXFJQRZZ#275QTZNXFSBZZ#276DZQJZZ#277DZYJJDZZYCLZZ#278QT#27928YBYQZZY#280TYYQYBZZ#281ZYYQYBZZ#282ZBYJSYQZZ#283GXYQZZ#284HQZZ#285QT#28629QTZZY#287RYZPZZ#288HFSJG#289QT#29030FQZYZHLYY#291JSFLHSXJGCL#292FJSFLHSXJGCL#29331JSZPJXHSBXLY#294JSZPXL#295TYSBXL#296ZYSBXL#297TLCBHKHTDYSSBXL#298QZHKHTQXL#299DQSBXL#300YQYBXL#301QT#302SDLRLRQJSDSCHGYY#3031DLRLSCHGYY#304DLSC#305HLFD#306RDLC#307SLFD#308HLFD#309FLFD#310TYNFD#311SWZNFD#312QT#313DLGY#314RLSCHGYY#3152RQSCHGYY#3163SDSCHGYY#317ZLSSCHGY#318WSCLJQZSLY#319HSDHCL#320QT#321WJZY#3221FWJZY#323ZZFWJZ#324TYCGJZ#325QTFWJZY#3262TMGCJZY#327TLDLSDHQLGCJZ#328TLGCJZ#329GLGCJZ#330SZDLGCJZ#331CSGDJTGCJZ#332QT#333SLHSYGCJZ#334SYJGSSSGCJZ#335HHZLJFHSSGCJZ#336GKJHYSSGCJZ#337HYGCJZ#338GKGCJZ#339JXHGDGCJZ#340JNHBGCSG#341DLGCSG#342QT#3433JZAZY#344DQAZ#345GDHSBAZ#346QT#3474JZZSZXHQTJZY#348JZZSHZXY#349JZWCCHCDZBHD#350TGSGSBFW#351QT#352LPFHLSY#3531PFY#354NLMYCPPF#355SPYLJYCZPPF#356QZYCZPPF";
		colsH[1504] = "XH#XM#SSSRHJ#GNZZS#QZYBNSRZZS#GNXFS#YYS#QYSDSNZQY#QYSDSWZQY#GRSDS#ZYS#CSWHJSS#FCS#YHS#CZTDSYS#TDZZS#CLGZS#CCS#GDZYS#QS#HJBHS#QTGS";
		colsLName[1504] = "②通信设备制造#通信系统设备制造#通信终端设备制造#③广播电视设备制造#④雷达及配套设备制造#⑤非专业视听设备制造#⑥智能消费设备制造#其中:可穿戴智能设备制造#智能车载设备制造#智能无人飞行器制造#服务消费机器人制造#其他智能消费设备制造#⑦电子器件制造#⑧电子元件及电子专用材料制造#⑨其他#28.仪表仪器制造业#①通用仪器仪表制造#②专用仪器仪表制造#③钟表与计时仪器制造#④光学仪器制造#⑤衡器制造#⑥其他#29.其他制造业#①日用杂品制造#②核辐射加工#③其他#30.废弃资源综合利用业#①金属废料和碎屑加工处理#②非金属废料和碎屑加工处理#31.金属制品、机械和设备修理业#①金属制品修理#②通用设备修理#③专用设备修理#④铁路、船舶、航空航天等运输设备修理#其中：航空航天器修理#⑤电气设备修理#⑥仪器仪表修理#⑦其他#四、电力、热力、燃气及水的生产和供应业#1.电力、热力生产和供应业#①电力生产#火力发电#热电联产#水力发电#核力发电#风力发电#太阳能发电#生物质能发电#其他#②电力供应#③热力生产和供应业#2.燃气生产和供应业#3.水的生产和供应业#①自来水生产和供应#②污水处理及其再生利用#③海水淡化处理#④其他#五、建筑业#1.房屋建筑业#①住宅房屋建筑#②体育场馆建筑#③其他房屋建筑业#2.土木工程建筑业#①铁路、道路、隧道和桥梁工程建筑#铁路工程建筑#公路工程建筑#市政道路工程建筑#城市轨道交通工程建筑#其他#②水利和水运工程建筑#水源及供水设施工程建筑#河湖治理及防洪设施工程建筑#港口及航运设施工程建筑#③海洋工程建筑#④工矿工程建筑#⑤架线和管道工程建筑#⑥节能环保工程施工#⑦电力工程施工#⑧其他#3.建筑安装业#①电气安装#②管道和设备安装#③其他#4.建筑装饰、装修和其他建筑业#①建筑装饰和装修业#②建筑物拆除和场地准备活动#③提供施工设备服务#④其他#六、批发和零售业#1.批发业#①农、林、牧、渔产品批发#②食品、饮料及烟草制品批发#其中:烟草制品批发";
		colsHName[1504] = "序号#项目#税收收入合计#国内增值税#其中：一般纳税人增值税#国内消费税#营业税#企业所得税内资企业#企业所得税外资企业#个人所得税#资源税#城市维护建设税#房产税#印花税#城镇土地使用税#土地增值税#车辆购置税#车船税#耕地占用税#契税#环境保护税#其他各税";


		sjNum[1505] =3;
		colsL[1505] = "357FZFZJJTYPPF#358WHTYYPJQCPF#359YYJYLQCPF#360KCPJCJHGCPPF#361MTJZPPF#362SYJQZPPF#363FJSKJZPPF#364JSJJSKPF#365JCPF#366HFPF#367NYPF#368NYBMPF#369QT#370JXSBWJCPJDZCPPF#371NYJXPF#372QCJLPJPF#373MTCJLPJPF#374WJCPPF#375DQSBPF#376JSJRJJFZSBPF#377TXSBPF#378GBYSSBPF#379QT#380MYJJYDL#381QTPFY#382QZZSWZHSYPF#383HLWPF#3842LSY#385ZHLS#386SPYLJYCZPZMLS#387FZFZJRYPZMLS#388WHTYYPJQCZMLS#389YYJYLQCZMLS#390QCMTCRLJLPJZMLS#391QCXCLS#392QCJCLS#393QCLPJLS#394MTCJLPJLS#395JDCRYLS#396JDCRQLS#397JDCCDXS#398JYDQJDZCPZMLS#399JYSTSBLS#400RYJDLS#401JSJRJJFZSBLS#402TXSBLS#403QT#404WJJJJSNZSCLZMLS#405HTWDPJQTLSY#406QZHLWLS#407QJTYSCCHYZY#4081TLYSY#409TLLKYS#410TLHWYS#411TLYSFZHD#4122DLYSY#413CSGGJTYS#414GLLKYS#415DLHWYS#416DLYSFZHD#4173SSYSY#418SSLKYS#419HSLKYS#420NHLKYS#421KYLDYS#422SSHWYS#423YYHWYS#424YHHWYS#425NHHWYS#426SSYSFZHD#4274HKYSY#428HKKHYS#429HKLKYS#430HKHWYS#431TYHKFW#432HKYSFZHD#4335GDYSY#4346DSLYHYSDLY#435DSLY#436YSDLY#4377ZXBYHCCY#438QZZXBY#4398YZY#440YZJBFW#441KDFW";
		colsH[1505] = "XH#XM#SSSRHJ#GNZZS#QZYBNSRZZS#GNXFS#YYS#QYSDSNZQY#QYSDSWZQY#GRSDS#ZYS#CSWHJSS#FCS#YHS#CZTDSYS#TDZZS#CLGZS#CCS#GDZYS#QS#HJBHS#QTGS";
		colsLName[1505] = "③纺织、服装及家庭用品批发#④文化、体育用品及器材批发#⑤医药及医疗器材批发#⑥矿产品、建材及化工产品批发#煤炭及制品批发#石油及其制品批发#非金属矿及制品批发#金属及金属矿批发#建材批发#化肥批发#农药批发#农用薄膜批发#其他#⑦机械设备、五金产品及电子产品批发#农业机械批发#汽车及零配件批发#摩托车及零配件批发#五金产品批发#电气设备批发#计算机、软件及辅助设备批发#通讯设备批发#广播影视设备批发#其他#⑧贸易经纪与代理#⑨其他批发业#其中:再生物资回收与批发#互联网批发#2.零售业#①综合零售#②食品、饮料及烟草制品专门零售#③纺织、服装及日用品专门零售#④文化、体育用品及器材专门零售#⑤医药及医疗器材专门零售#⑥汽车、摩托车、燃料及零配件专门零售#汽车新车零售#汽车旧车零售#汽车零配件零售#摩托车及零配件零售#机动车燃油零售#机动车燃气零售#机动车充电销售#⑦家用电器及电子产品专门零售#家用视听设备零售#日用家电零售#计算机、软件及辅助设备零售#通信设备零售#其他#⑧五金、家具及室内装饰材料专门零售#⑨货摊、无店铺及其他零售业#其中:互联网零售#七、交通运输、仓储和邮政业#1.铁路运输业#①铁路旅客运输#②铁路货物运输#③铁路运输辅助活动#2.道路运输业#①城市公共交通运输#②公路旅客运输#③道路货物运输#④道路运输辅助活动#3.水上运输业#①水上旅客运输#海上旅客运输#内河旅客运输#客运轮渡运输#②水上货物运输#远洋货物运输#沿海货物运输#内河货物运输#③水上运输辅助活动#4.航空运输业#①航空客货运输#航空旅客运输#航空货物运输#②通用航空服务#③航空运输辅助活动#5.管道运输业#6.多式联运和运输代理业#①多式联运#②运输代理业#7.装卸搬运和仓储业#其中：装卸搬运#8.邮政业#①邮政基本服务#②快递服务";
		colsHName[1505] = "序号#项目#税收收入合计#国内增值税#其中：一般纳税人增值税#国内消费税#营业税#企业所得税内资企业#企业所得税外资企业#个人所得税#资源税#城市维护建设税#房产税#印花税#城镇土地使用税#土地增值税#车辆购置税#车船税#耕地占用税#契税#环境保护税#其他各税";


		sjNum[1506] =3;
		colsL[1506] = "442BZSHCYY#4431ZSY#444LYFD#445YBLG#446MSFW#447LYDFW#448QT#4492CYY#450ZCFW#451KCFW#452YLJLYFW#453CYPSJWMSCFW#454QT#455JXXCSRJHXXJSFWY#4561DXGBDSHWXCSFW#457DX#458GDDXFW#459YDDXFW#460QT#461GBDSCSFW#462WXCSFW#4632HLWHXGFW#464HLWJRJXGFW#465HLWXXFW#466HLWPT#467QZHLWSCFWPT#468HLWSHFWPT#469HLWKJCXPT#470HLWGGFWPT#471QTHLWPT#472HLWAQFW#473HLWSJFW#474QT#4753RJHXXJSFWY#476RJKF#477JCDLSJ#478XXXTJCHWLWJSFW#479QZXXXTJCFW#480WLWJSFW#481YXWHFW#482XXCLHCCZCFW#483XXJSZXFW#484SZNRFW#485QTXXJSFWY#486SJRY#4871HBJRFW#488ZYYXFW#489HBYXFW#490FHBYXFW#491RZZLFW#492CWGS#493DD#494QCJRGSFW#495XEDKGSFW#496XFJRGSFW#497WLJDFW#498QT#499YXLCFW#500YXJGFW#5012ZBSCFW#502ZQSCFW#503ZQSCGLFW#504ZQJJJYFW#505GKMJZQTZJJ#506FGKMJZQTZJJ#507QZ；CYTZJJ#508TSTZ#509QHSCFW#510ZQQHJGFW#511ZBTZFW#512QT#5133BXY#514RSBX#515CCBX#516ZBX#517SYYLJ#518BXZJFW#519BXZCGL#520BXJGFW#521QT#5224QTJRY#523JRXTYGLFW#524KGGSFW#525FJRJGZFFW#526JRXXFW#527JRZCGLGS#528QT#529SYFDCY#5301FDCKFJY#5312WYGL#5323FDCZJFW#5334FDCZLJY#5345QTFDCY";
		colsH[1506] = "XH#XM#SSSRHJ#GNZZS#QZYBNSRZZS#GNXFS#YYS#QYSDSNZQY#QYSDSWZQY#GRSDS#ZYS#CSWHJSS#FCS#YHS#CZTDSYS#TDZZS#CLGZS#CCS#GDZYS#QS#HJBHS#QTGS";
		colsLName[1506] = "八、住宿和餐饮业#1.住宿业#①旅游饭店#②一般旅馆#③民宿服务#④露营地服务#⑤其他#2.餐饮业#①正餐服务#②快餐服务#③饮料及冷饮服务#④餐饮配送及外卖送餐服务#⑤其他#九、信息传输、软件和信息技术服务业#1.电信、广播电视和卫星传输服务#①电信#固定电信服务#移动电信服务#其他#②广播电视传输服务#③卫星传输服务#2.互联网和相关服务#①互联网接入及相关服务#②互联网信息服务#③互联网平台#其中：互联网生产服务平台#互联网生活服务平台#互联网科技创新平台#互联网公共服务平台#其他互联网平台#④互联网安全服务#⑤互联网数据服务#⑥其他#3.软件和信息技术服务业#①软件开发#②集成电路设计#③信息系统集成和物联网技术服务#其中：信息系统集成服务#物联网技术服务#④运行维护服务#⑤信息处理和存储支持服务#⑥信息技术咨询服务#⑦数字内容服务#⑧其他信息技术服务业#十、金融业#1.货币金融服务#①中央银行服务#②货币银行服务#③非货币银行服务#融资租赁服务#财务公司#典当#汽车金融公司服务#小额贷款公司服务#消费金融公司服务#网络借贷服务#其他#④银行理财服务#⑤银行监管服务#2.资本市场服务#①证券市场服务#证券市场管理服务#证券经纪交易服务#②公开募集证券投资基金#③非公开募集证券投资基金#其中；创业投资基金#天使投资#④期货市场服务#⑤证券期货监管服务#⑥资本投资服务#⑦其他#3.保险业#①人身保险#②财产保险#③再保险#④商业养老金#⑤保险中介服务#⑥保险资产管理#⑦保险监管服务#⑧其他#4.其他金融业#①金融信托与管理服务#②控股公司服务#③非金融机构支付服务#④金融信息服务#⑤金融资产管理公司#⑥其他#十一、房地产业#1.房地产开发经营#2.物业管理#3.房地产中介服务#4.房地产租赁经营#5.其他房地产业";
		colsHName[1506] = "序号#项目#税收收入合计#国内增值税#其中：一般纳税人增值税#国内消费税#营业税#企业所得税内资企业#企业所得税外资企业#个人所得税#资源税#城市维护建设税#房产税#印花税#城镇土地使用税#土地增值税#车辆购置税#车船税#耕地占用税#契税#环境保护税#其他各税";


		sjNum[1507] =3;
		colsL[1507] = "535SEZLHSWFWY#5361ZLY#537JXSBZL#538QCZL#539NYJXZL#540JZGCJXYSBZL#541JSJJTXSBZL#542YYSBJYZL#543QT#544WTSBHYPCZ#545RYPCZ#5462SWFWY#547ZZGLFW#548QYZBGL#549TZYZCGL#550ZYYCQJYFW#551DWHQGLFW#552NCJTJJZZGL#553QT#554ZHGLFW#555FLFW#556LSJXGFLFW#557GZFW#558QT#559ZXYDC#560QZHJSJJSWFW#561SCDC#562GGY#563QZHLWGG#564RLZYFW#565AQBHFW#566HYZLJXGFW#567QZKJHZFW#568QT#569LXSJXGFW#570BZFW#571BGFW#572FYFW#573XYFW#574FRZDBFW#575SWDLDBFW#576PWDLFW#577QT#578SSKXYJHJSFWY#5791YJHSYFZ#580ZRKXYJHSYFZ#581GCHJSYJHSYFZ#582NYKXYJHSYFZ#583YXYJHSYFZ#584SHRWKXYJ#5852ZYJSFWY#586QXFW#587DZFW#588HYFW#589CHDLXXFW#590ZJJSFW#591HJYSTJCJCFW#592DZKC#593GCJSYSJFW#594GYYZYSJJQT#5953KJTGHYYFWY#596JSTGFW#597QZSWJSTGFW#598XCLJSTGFW#599JNJSTGFW#600XNYJSTGFW#601HBJSTGFW#602SW3DDYJSTGFW#603QT#604ZSCQFW#605KJZJFW#606CYKJFW#607QT#608SSSLHJHGGSSGLY#6091SLGLY#610QZSZYGL#6112STBHHHJZLY#612STBH#613HJZLY#6143GGSSGLY#615SZSSGL#616HJWSGL#617CXSRGL#618LHGL#619CSGYGL#620YLJQGL#6214TDGLY#622TDZZFW#623TDDCPGFW#624TDDJFW#625TDDJDLFW#626QTTDGLFW";
		colsH[1507] = "XH#XM#SSSRHJ#GNZZS#QZYBNSRZZS#GNXFS#YYS#QYSDSNZQY#QYSDSWZQY#GRSDS#ZYS#CSWHJSS#FCS#YHS#CZTDSYS#TDZZS#CLGZS#CCS#GDZYS#QS#HJBHS#QTGS";
		colsLName[1507] = "十二、租赁和商务服务业#1.租赁业#①机械设备租赁#汽车租赁#农业机械租赁#建筑工程机械与设备租赁#计算机及通讯设备租赁#医药设备经营租赁#其他#②文体设备和用品出租#③日用品出租#2.商务服务业#①组织管理服务#企业总部管理#投资与资产管理#资源与产权交易服务#单位后勤管理服务#农村集体经济组织管理#其他#②综合管理服务#③法律服务#律师及相关法律服务#公证服务#其他#④咨询与调查#其中:会计、审计及税务服务#市场调查#⑤广告业#其中：互联网广告#⑥人力资源服务#⑦安全保护服务#⑧会议、展览及相关服务#其中：科技会展服务#⑨其他#旅行社及相关服务#包装服务#办公服务#翻译服务#信用服务#非融资担保服务#商务代理代办服务#票务代理服务#其他#十三、科学研究和技术服务业#1.研究和试验发展#①自然科学研究和试验发展#②工程和技术研究和试验发展#③农业科学研究和试验发展#④医学研究和试验发展#⑤社会人文科学研究#2.专业技术服务业#①气象服务#②地震服务#③海洋服务#④测绘地理信息服务#⑤质检技术服务#⑥环境与生态监测检测服务#⑦地质勘查#⑧工程技术与设计服务#⑨工业与专业设计及其他#3.科技推广和应用服务业#①技术推广服务#其中：生物技术推广服务#新材料技术推广服务#节能技术推广服务#新能源技术推广服务#环保技术推广服务#三维（3D）打印技术推广服务#其他#②知识产权服务#③科技中介服务#④创业空间服务#⑤其他#十四、水利、环境和公共设施管理业#1.水利管理业#其中:水资源管理#2.生态保护和环境治理业#①生态保护#②环境治理业#3.公共设施管理业#①市政设施管理#②环境卫生管理#③城乡市容管理#④绿化管理#⑤城市公园管理#⑥游览景区管理#4.土地管理业#①土地整治服务#②土地调查评估服务#③土地登记服务#④土地登记代理服务#⑤其他土地管理服务";
		colsHName[1507] = "序号#项目#税收收入合计#国内增值税#其中：一般纳税人增值税#国内消费税#营业税#企业所得税内资企业#企业所得税外资企业#个人所得税#资源税#城市维护建设税#房产税#印花税#城镇土地使用税#土地增值税#车辆购置税#车船税#耕地占用税#契税#环境保护税#其他各税";


		sjNum[1508] =3;
		colsL[1508] = "627SWJMFWXLHQTFWY#6281JMFWY#629JTFW#630TESFW#631XRFW#632LFJMRFW#633XYHBJYSFW#634SYKYFW#635HYFW#636ZZFW#637QT#6382JDCDZCPHRYCPXLY#639QCMTCXLYWH#640QCXLYWH#641MTCXLYWH#642JSJHBGSBWX#643JYDQXL#644QT#6453QTFWY#646QJFW#647CWFW#648QT#649SLJY#6501XQJY#6512CDJY#6523ZDJY#653QZZYCZJY#654ZDZYXXJY#6554GDJY#656QZPTGDJY#6575TSJY#6586JNPXJYFZJQT#659QZZYJNPX#660SQWSHSHGZ#6611WS#662YY#663ZHYY#664ZYYY#665ZXYJHYY#666MZYY#667ZKYY#668LYY#669JCYLWSFW#670ZYGGWSFW#671QZJBYFKZZX#672ZKJBFZYSZ#673FYBJYSZ#674JHSYJSFWHD#675QT#6762SHGZ#677SBWHTYHYLY#6781XWHCBY#679XWY#680CBY#6812GBDSDYHYSLYZZY#682GB#683DS#684YSJMZZ#685GBDSJCBK#686DYHYSJMFX#687DYFY#688LYZZ#6893WHYSY#690WYCZYBY#691YSBYCG#692TSGYDAG#693WWJFWZWHYCBH#694BWG#695LSLYJNG#696QZWHHD#697QT#6984TY#699TYZZ#700TYCDSSGL#701JSXXHD#702QTTY#7035YLY#704SNYLHD#705YLY#706XXGGHD#707CPHD#708WHYLTYHDHJJDLFW#709QT#710SJGGGLSHBZHSHZZ#711ESQTXY";
		colsH[1508] = "XH#XM#SSSRHJ#GNZZS#QZYBNSRZZS#GNXFS#YYS#QYSDSNZQY#QYSDSWZQY#GRSDS#ZYS#CSWHJSS#FCS#YHS#CZTDSYS#TDZZS#CLGZS#CCS#GDZYS#QS#HJBHS#QTGS";
		colsLName[1508] = "十五、居民服务、修理和其他服务业#1.居民服务业#①家庭服务#②托儿所服务#③洗染服务#④理发及美容服务#⑤洗浴和保健养生服务#⑥摄影扩印服务#⑦婚姻服务#⑧殡葬服务#⑨其他#2.机动车、电子产品和日用产品修理业#①汽车、摩托车修理与维护#汽车修理与维护#摩托车修理与维护#②计算机和办公设备维修#③家用电器修理#④其他#3.其他服务业#①清洁服务#②宠物服务#③其他#十六、教育#1.学前教育#2.初等教育#3.中等教育#其中：职业初中教育#中等职业学校教育#4.高等教育#其中：普通高等教育#5.特殊教育#6.技能培训、教育辅助及其他#其中：职业技能培训#十七、卫生和社会工作#1.卫生#①医院#综合医院#中医医院#中西医结合医院#民族医院#专科医院#疗养院#②基层医疗卫生服务#③专业公共卫生服务#其中：疾病预防控制中心#专科疾病防治院（所、站）#妇幼保健院（所、站）#计划生育技术服务活动#④其他#2.社会工作#十八、文化、体育和娱乐业#1.新闻和出版业#①新闻业#②出版业#2.广播、电视、电影和影视录音制作业#①广播#②电视#③影视节目制作#④广播电视集成播控#⑤电影和影视节目发行#⑥电影放映#⑦录音制作#3.文化艺术业#①文艺创作与表演#②艺术表演场馆#③图书馆与档案馆#④文物及非物质文化遗产保护#⑤博物馆#⑥烈士陵园、纪念馆#⑦群众文化活动#⑧其他#4.体育#①体育组织#②体育场地设施管理#③健身休闲活动#④其他体育#5.娱乐业#①室内娱乐活动#②游乐园#③休闲观光活动#④彩票活动#⑤文化娱乐体育活动和经纪代理服务#⑥其他#十九、公共管理、社会保障和社会组织#二十、其他行业";
		colsHName[1508] = "序号#项目#税收收入合计#国内增值税#其中：一般纳税人增值税#国内消费税#营业税#企业所得税内资企业#企业所得税外资企业#个人所得税#资源税#城市维护建设税#房产税#印花税#城镇土地使用税#土地增值税#车辆购置税#车船税#耕地占用税#契税#环境保护税#其他各税";


		sjNum[16] = 2;
		colsL[16] = "HJ#YNZQY#YGYQY#EJTQY#SGFHZQY#SLYQY#QZGYKG1#1GYLYQY#2JTLYQY#3GYYJTLYQY#4QTLYQY#WYXZRGS#QZGYKG2#1GYDZQY#2QTYXZRGS#LGFYXGS#QZGYKG3#QSYQY#1SYDZQY#2SYHHQY#3SYYXZRGS#4SYGFYXGS#BQTQY#EGATSTZQY#QZGYKG4#1HZJYQYGHATZ#2HZJYQYGHATZ#3GATSDZJYQY#4GATSTZGFYXGS#5QTGATSTZQY#SWSTZQY#QZGYKG5#1ZWHZJYQY#2ZWHZJYQY#3WZQY#4WSTZGFYXGS#5QTWSTZQY#SGTJY#1GTH#2GRHH";
		colsH[16] = "XH#XM#SSSRHJ#GNZZS#QZYBNSR#GNXFS#YYS#QYSDS#GRSDS#ZYS#CSWHJSS#FCS#YHS#CZTDSYS#TDZZS#CCS#CLGZS#GDZYS#QS#HJBHS#QTSS";
		colsLName[16] = "合计#一、内资企业#(一)国有企业#(二)集体企业#(三)股份合作企业#(四)联营企业#其中:国有控股#1.国有联营企业#2.集体联营企业#3.国有与集体联营企业#4.其他联营企业#(五)有限责任公司#其中:国有控股#1.国有独资企业#2.其他有限责任公司#(六)股份有限公司#其中:国有控股#(七)私营企业#1.私营独资企业#2.私营合伙企业#3.私营有限责任公司#4.私营股份有限公司#(八)其它企业#二、港、澳、台商投资企业#其中:国有控股#1.合资经营企业（港或澳、台资）#2.合作经营企业（港或澳、台资）#3.港、澳、台商独资经营企业#4.港、澳、台商投资股份有限公司#5.其他港、澳、台商投资企业#三、外商投资企业#其中:国有控股#1.中外合资经营企业#2.中外合作经营企业#3.外资企业#4.外商投资股份有限公司#5.其他外商投资企业#四、个体经营#1.个体户#2.个人合伙";
		colsHName[16] = "序号#项目#税收收入合计#国内增值税#其中：一般纳税人#国内消费税#营业税#企业所得税#个人所得税#资源税#城市维护建设税#房产税#印花税#城镇土地使用税#土地增值税#车船税#车辆购置税#耕地占用税#契税#环境保护税#其他税收";

		sjNum[1701] = 3;
		colsL[1701] = "YZZSSRHJ#YGNZZS#1CKY#1MTKCHXXY#2SYHTRQKCY#QZYY#3HSJSKCXY#4YSJSKCXY#5FJSKCXY#6QTCKY#2ZZY#1NFSPJGY#2SPZZY#3JYLHJZCZZY#JDZZ#QZJJ#YLZZ#JZCZZ#4YCZPY#YYFK#JYZZ#QTYCZPZZ#5FZY#6FZFZFSY#QZJZFZZZ#7PGMPYMJQZPHZXY#QZPGMP#8MCJGJMZTZCZPY#9JJZZY#10ZZJZZPY#ZJZZ#ZZ#QZJZZJZBZZ#ZZPZZ#11YSHJLMJFZY#12WJGMTYHYLYPZZY#13SYMTJQTRLJGY#JLSYCPZZ#QZCPY#MTJG#HRLJG#SWZRLJG#14HXYLJHXZPY#FLZZ#NYZZ#ZYHXCPZZ#RYHXCPZZ#QZHZPZZ#QT1#15YYZZY#16HXXWZZY#17XJHSLZPY#QZLTZZ#18FJSKWZPY#SNSHHSGZZ#QZSNZZ#SNJSGZPZZ#BLJBLZPZZ#QT2#19HSJSYLJYYJGY#QZGYYJG#20YSJSYLJYYJGY#21JSZPY#22TYSBZZY#23ZYSBZZY#24QCZZY#QZQCZCZZ#DCZZ#25TLCBHKHTHQTYSSBZZY#QZTLYSSBZZ#CBJXGZZZZ#HKHTJSBZZ#MTCZZ#26DQJXHQCZZY#DJZZ#DXDLGLJDGQCZZ#JYDLQJZZ#QT#27JSJTXHQTDZSBZZY#JSJZZ#TXSBZZ#GBDSSBZZ#FZYSTSBZZ#ZNXFSBZZ#QT3#28YBYQZZY#29QTZZY";
		colsH[1701] = "XH#XM#HJ#QZMDDK#NZQYXJ#NZQYGYQY#NZQYJTQY#NZQYGFHZQY#NZQYLYQY#NZQYQZGYKG1#NZQYGFGS#NZQYQZGYKG#NZQYSYQY#NZQYQTQY#GATTZQY#QZGYKG11#WSTZQY#QZGYKG#GTJY";
		colsLName[1701] = "一、增值税收入合计#(一)国内增值税#1.采矿业#（1）煤炭开采和洗选业#（2）石油和天然气开采业#其中：原油#（3）黑色金属矿采选业#（4）有色金属矿采选业#（5）非金属矿采选业#（6）其他采矿业#2.制造业#（1）农副食品加工业#（2）食品制造业#（3）酒、饮料和精制茶制造业#①酒的制造#其中：酒精#②饮料制造#③精制茶制造#（4）烟草制品业#①烟叶复考#②卷烟制造#③其他烟草制品制造#（5）纺织业#（6）纺织服装、服饰业#其中：机织服装制造#（7）皮革、毛皮、羽毛及其制品和制鞋业#其中：皮革、毛皮#（8）木材加工及木竹藤棕草制品业#（9）家具制造业#（10）造纸及纸制品业#①纸浆制造#②造纸#其中：机制纸及纸板制造#③纸制品制造#（11）印刷和记录媒介复制业#（12）文教、工美、体育和娱乐用品制造业#（13）石油、煤炭及其他燃料加工业#①精炼石油产品制造#其中：成品油#②煤炭加工#③核燃料加工#④生物质燃料加工#（14）化学原料及化学制品业#①肥料制造#②农药制造#③专用化学产品制造#④日用化学产品制造#其中：化妆品制造#⑤其他#（15）医药制造业#（16）化学纤维制造业#（17）橡胶和塑料制品业#其中：轮胎制造#（18）非金属矿物制品业#①水泥、石灰和石膏制造#其中：水泥制造#②水泥及石膏制品制造#③玻璃及玻璃制品制造#④其他#（19）黑色金属冶炼及压延加工业#其中：钢压延加工#（20）有色金属冶炼及压延加工业#（21）金属制品业#（22）通用设备制造业#（23）专用设备制造业#（24）汽车制造业#其中：汽车整车制造#电车制造#（25）铁路、船舶、航空航天和其他运输设备制造业#其中：铁路运输设备制造#船舶及相关装置制造#航空、航天及设备制造#摩托车制造#（26）电气机械和器材制造业#①电机制造#②电线电缆光缆及电工器材制造#③家用电力器具制造#④其他#（27）计算机、通信和其他电子设备制造业#①计算机制造#②通信设备制造#③广播电视设备制造#④非专业视听设备制造#⑤智能消费设备制造#⑥其他#（28）仪表仪器制造业#（29）其他制造业";
		colsHName[1701] = "序号#项目#合计#其中:免抵调库#内资企业小计#内资企业国有企业#内资企业集体企业#内资企业股份合作企业#内资企业联营企业#内资企业其中：国有控股#内资企业股份公司#内资企业其中：国有控股#内资企业私营企业#内资企业其它企业#港澳台投资企业#其中：国有控股#外商投资企业#其中：国有控股#个体经营";

		sjNum[1702] = 3;
		colsL[1702] = "3DLRLRQJSDSCHGYY#1DLRLSCHGYY#DLSC#QZHLFD#RDLC#SLFD#HLFD#FLFD#TYNFD#DLGY#RLSCHGY#2RQSCHGYY#3SDSCHGYY#4PFHLSY#1PFY#SPYLJYCZPPF#QZYCZPPF#FZFZJJTYPPF#KCPJCJHGCPPF#QZMTJZPPF#SYJZPPF#JCPF#JXSBWJJDJDZCPPF#QZQCPFJLPJPF#MTCJLPJPF#DQSBPF#JSJRJJFZSBPF#QT12#2LSY#5JTYSCCHYZY#1TLYSY#2DLYSY#3SSYSY#4HKYSY#5GDYSY#6DSLYHYSDLY#7ZXBYHCCY#8YZY#6ZSHCYY#1ZSY#2CYY#7XXCSRJHXXJSFWY#1DXGBDSHWXCSFWY#QZDX#2HLWHXGFW#3RJHXXJSFWY#8JRY#1HBJRFW#QZYX#JRZL#2ZBSCFW#3BXY#4QTJRY#9FDCY#1FDCKFJYY#2WYGL#3FDCZJFW#4FDCZLJY#5QTFDCY#10ZLHSWFWY#1ZLY#2SWFWY#QZZXYDC#GGY#11KXYJHJSFWY#1YJHSYFZ#2ZYJSFWY#3KJTGHYYFWY#12JMFWXLHQTFWY#QZJMFWY#JDCDZCPHRYCPXLY#13JY#14WSHSHGZ#QZWS#15WHTYHYLY#QZXWHCBY#GBDSDYHYSLYZZY#TY#YLY#16GGGLSHBZHSHZZ#17JZY#1FWJZY#2TMGCJZY#3JZAZY#4JZZSZXHQTJZY#18SLHJHGGSSGLY#QZGGSSGLY#19QTXY#EJKHWZZS#ECKTZZSH#";
		colsH[1702] = "XH#XM#HJ#QZMDDK#NZQYXJ#NZQYGYQY#NZQYJTQY#NZQYGFHZQY#NZQYLYQY#NZQYQZGYKG1#NZQYGFGS#NZQYQZGYKG#NZQYSYQY#NZQYQTQY#GATTZQY#QZGYKG11#WSTZQY#QZGYKG#GTJY";
		colsLName[1702] = "3.电力、热力、燃气及水的生产和供应业#（1）电力、热力生产和供应业#①电力生产#其中：火力发电#热电联产#水力发电#核力发电#风力发电#太阳能发电#②电力供应#③热力生产和供应#（2）燃气生产和供应业#（3）水的生产和供应业#4.批发和零售业#(1)批发业#①食品、饮料及烟草制品批发#其中:烟草制品批发#②纺织、服装及家庭用品批发#③矿产品、建材及化工产品批发#其中：煤炭及制品批发#石油及制品批发#建材批发#④机械设备、五金交电及电子产品批发#其中：汽车批发及零配件批发#摩托车及零配件批发#电气设备批发#计算机、软件及辅助设备批发#⑤其他#（2)零售业#5.交通运输、仓储和邮政业#1.铁路运输业#2.道路运输业#3.水上运输业#4.航空运输业#5.管道运输业#6.多式联运和运输代理业#7.装卸搬运和仓储业#8.邮政业#6.住宿和餐饮业#（1）住宿业#（2）餐饮业#7.信息传输、软件和信息技术服务业#（1）电信、广播电视和卫星传输服务业#其中：电信#（2）互联网和相关服务#（3）软件和信息技术服务业#8.金融业#（1）货币金融服务#其中：银行#金融租赁#（2）资本市场服务#（3）保险业#（4）其他金融业#9.房地产业#（1）房地产开发经营业#（2）物业管理#（3）房地产中介服务#（4）房地产租赁经营#（5）其他房地产业#10.租赁和商务服务业#（1）租赁业#（2）商务服务业#其中：咨询与调查#广告业#11.科学研究和技术服务业#（1）研究和实验发展#（2）专业技术服务业#（3）科技推广和应用服务业#12.居民服务、修理和其他服务业#其中：居民服务业#机动车、电子产品和日用产品修理业#13.教育#14.卫生和社会工作#其中：卫生#15.文化、体育和娱乐业#其中：新闻和出版业#广播、电视、电影和影视录音制作业#体育#娱乐业#16.公共管理、社会保障和社会组织#17.建筑业#（1）房屋建筑业#（2）土木工程建筑业#（3）建筑安装业#（4）建筑装饰、装修和其他建筑业#18.水利、环境和公共设施管理业#其中：公共设施管理业#19.其他行业#（二）进口货物增值税#二、出口退增值税合计";
		colsHName[1702] = "序号#项目#合计#其中:免抵调库#内资企业小计#内资企业国有企业#内资企业集体企业#内资企业股份合作企业#内资企业联营企业#内资企业其中：国有控股#内资企业股份公司#内资企业其中：国有控股#内资企业私营企业#内资企业其它企业#港澳台投资企业#其中：国有控股#外商投资企业#其中：国有控股#个体经营";

		sjNum[18] = 3;
		colsL[18]="YXFSSR#YGNXFS#1JJJJ#1BJ#2HJ#3PJ#4QTJ#5JJ#2Y#1GYJY#QZA56SLZS#A36SLZS#2XQY#3YS#4SYPFJY#3CPY#1QY#2CY#3SNY#4RJY#5RHY#6RLY#7HKMY#4XQC#1CYC#A1SLZS#A3SLZS#A5SLZS#A9SLZS#A12SLZS#A25SLZS#A40SLZS#2ZQXSYKC#3CHHXQC#5MTC#6GEFQJQJ#7QCLT#8GDHZP#9GZSS#10BPYH#11GDSB#12YT#13MZYCXKZ#14SMDB#15DC#16TL#17QT#18SKZNJFKSR#EJKXFPXFS#ECKXFPTXF";
		colsH[18]="XH#XM#HJ#NZQYXJ#NZQYGYQY#NZQYJTQY#NZQYGFHZQY#NZQYLYQY#NZQYQZGYKG1#NZQYGFGS#NZQYQZGYKG2#NZQYSYQY#NZQYQTQY#GATTZQY#QZGYKG1#WSTZQY#QZGYKG2#GTJY";
		colsLName[18] = "一、消费税收入#(一)国内消费税#1.酒及酒精#(1)白酒#(2)黄酒#(3)啤酒#(4)其他酒#(5)酒精#2.烟#(1)工业卷烟#其中：按56%税率征收#按36%税率征收#(2)雪茄烟#(3)烟丝#(4)商业批发卷烟#3.成品油#(1)汽油#(2)柴油#(3)石脑油#(4)溶剂油#(5)润滑油#(6)燃料油#(7)航空煤油#4.小汽车#(1)乘用车#按1%税率征收#按3%税率征收#按5%税率征收#按9%税率征收#按12%税率征收#按25%税率征收#按40%税率征收#(2)中轻型商用客车#(3)超豪华小汽车#5.摩托车#6.高尔夫球及球具#7.汽车轮胎#8.高档化妆品#9.贵重首饰#10.鞭炮焰火#11.高档手表#12.游艇#13.木制一次性筷子#14.实木地板#15.电池#16.涂料#17.其他#18.税款滞纳金罚款收入#(二)进口消费品消费税#二、出口消费品退消费税";
		colsHName[18] = "序号#项目#合计#内资企业小计#内资企业国有企业#内资企业集体企业#内资企业股份合作企业#内资企业联营企业#内资企业其中：国有控股#内资企业股份公司#内资企业其中：国有控股#内资企业私营企业#内资企业其它企业#港澳台投资企业#其中：国有控股#外商投资企业#其中：国有控股#个体经营";

		sjNum[1901] = 3;
		colsL[1901] = "HJ#YCKY#1MTKCHXXY#2SYHTRQKCY#QZYY#3HSJSKCXY#4YSJSKCXY#5FJSKCXY#6QTCKY#EZZY#1NFSPJGY#2SPZZY#3JYLHJZCZZY#JDZZ#QZJJ#YLZZ#JZCZZ#4YCZPY#YYFK#JYZZ#QTYCZPJG#5FZY#6FZFZFSY#QZFZFZ#7PGMPYMJQZPHZXY#QZPGMP#8MCJGHMZTZCZPY#9JJZZY#10ZZHZZPY#ZJZZ#ZZ#QZJZZJZBZZ#ZZPZZ#11YSHJLMJFZY#12WJGMTYHYLYPZZY#13SYMTJQTRLJGY#QZCPY#14HXYLHHXZPZZY#FLZZ#NYZZ#ZYHXCPZZ#RYHXCPZZ#QZHZPZZ#QT1#15YYZZY#16HXXWZZY#17XJHSLZPY#QZLTZZ#18FJSKWZPY#SNSHHSGZZ#QZSNZZ#SNJSGZPZZ#BLJBLZPZZ#QT2#19HSJSYLHYYJGY#QZGYYJG#20YSJSYLHYYJGY#21JSZPY#22TYSBZZY#23ZYSBZZY#24QCZZY#25TLCBHKHTHQTYSSBZZY#QZTLYSSBZZ#CBJXGZZZZ#HKHTJSBZZ#MTCZZ#26DQJXHQCZZY#DJZZ#DXDLGLJDGQCZZ#JYDLQJZZ#QT3#27JSJTXHQTDZSBZZY#JSJZZ#TXSBZZ#GBDSSBZZ#FZYSTSBZZ#ZNXFSBZZ#QT4#28YBYQZZY#29QTZZY#SDLRLRQJSDSCHGYY#1DLRLSCHGYY#DLSC#QZHLFD#RDLC#SLFD#HLFD#FLFD#TYNFD#DLGY#RLSCHGYY#2RQSCHGYY#3SDSCHGYY";
		colsH[1901] = "XH#XM#HJ#NZQYXJ#NZQYGYQY#NZQYJTQY#NZQYGFHZQY#NZQYLYQY#NZQYQZGYKG1#NZQYGFGS#NZQYQZGYKG2#NZQYSYQY#NZQYQTQY#GATTZQY#QZGYKG1#WSTZQY#QZGYKG2";
		colsLName[1901] = "合计#(一)采矿业#1.煤炭开采和洗选业#2.石油和天然气开采业#其中:原油#3.黑色金属矿采选业#4.有色金属矿采选业#5.非金属矿采选业#6.其他采矿业#(二)制造业#1.农副食品加工业#2.食品制造业#3.酒、饮料和精制茶制造业#①酒的制造#其中：酒精#②饮料制造#③精制茶制造#4.烟草制品业#烟叶复考#卷烟制造#其他烟草制品加工#5.纺织业#6.纺织服装、服饰业#其中：纺织服装#7.皮革、毛皮、羽毛及其制品和制鞋业#其中：皮革、毛皮#8.木材加工和木竹藤棕草制品业#9.家具制造业#10.造纸和纸制品业#①纸浆制造#②造纸#其中：机制纸及纸板制造#③纸制品制造#11.印刷和记录媒介复制业#12.文教、工美、体育和娱乐用品制造业#13.石油、煤炭及其他燃料加工业#其中：成品油#14.化学原料和化学制品制造业#①肥料制造#②农药制造#③专用化学产品制造#④日用化学产品制造#其中：化妆品制造#⑤其他#15.医药制造业#16.化学纤维制造业#17.橡胶和塑料制品业#其中：轮胎制造#18.非金属矿物制品业#①水泥、石灰和石膏制造#其中：水泥制造#②水泥及石膏制品制造#③玻璃及玻璃制品制造#④其他#19.黑色金属冶炼和压延加工业#其中：钢压延加工#20.有色金属冶炼和压延加工业#21.金属制品业#22.通用设备制造业#23.专用设备制造业#24.汽车制造业#25.铁路、船舶、航空航天和其他运输设备制造业#其中：铁路运输设备制造#船舶及相关装置制造#航空、航天及设备制造#摩托车制造#26.电气机械和器材制造业#①电机制造#②电线电缆光缆及电工器材制造#③家用电力器具制造#④其他#27.计算机、通信和其他电子设备制造业#①计算机制造#②通信设备制造#③广播电视设备制造#④非专业视听设备制造#⑤智能消费设备制造#⑥其他#28.仪表仪器制造业#29.其他制造业#(三)电力、热力、燃气及水的生产和供应业#1.电力、热力生产和供应业#①电力生产#其中：火力发电#热电联产#水力发电#核力发电#风力发电#太阳能发电#②电力供应#③热力生产和供应业#2.燃气生产和供应业#3.水的生产和供应业";
		colsHName[1901] = "序号#项目#合计#内资企业小计#内资企业国有企业#内资企业集体企业#内资企业股份合作企业#内资企业联营企业#内资企业其中：国有控股#内资企业股份公司#内资企业其中：国有控股#内资企业私营企业#内资企业其它企业#港澳台投资企业#其中：国有控股#外商投资企业#其中：国有控股";

		sjNum[1902] = 3;
		colsL[1902] = "SJZY#1FWJZY#2TMGCJZY#3JZAZY#4JZZSZXHQTJZY#WPFHLSY#1PFY#QZYCZPPF#MTJZPPF#SYJQZPPF#QCJLPJPF#2LSY#LJTYSCCHYZY#1TLYSY#2DLYSY#3SSYSY#4HKYSY#5GDYSY#6DSLYHYSDLY#7ZXBYHCCY#8YZY#QZSHCYY#1ZSY#2CYY#BXXCSRJHXXJSFWY#1DXGBDSHWXCSFWY#QZDX#2HLWHXGFW#3RJHXXJSFWY#JJRY#1HBJRFW#QZYX#JRZL#2ZBSCFW#3BXY#4QTJRY#SFDCY#SYZLHSWFWY#1ZLY#2SWFWY#SEKXYJHJSFWY#SSJMFWXLHQTFWY#QZJMFWY#JDCDZCPHRYCPXLY#SSJY#SWWSHSHGZ#QZWS#SLWHTYHYLY#QZXWHCBY#GBDSDYHYSLYZZY#TY#YLY#SQGGGLSHBZHSHZZ#SBQTXY";
		colsH[1902] = "XH#XM#HJ#NZQYXJ#NZQYGYQY#NZQYJTQY#NZQYGFHZQY#NZQYLYQY#NZQYQZGYKG1#NZQYGFGS#NZQYQZGYKG2#NZQYSYQY#NZQYQTQY#GATTZQY#QZGYKG1#WSTZQY#QZGYKG2";
		colsLName[1902] = "(四)建筑业#1.房屋建筑业#2.土木工程建筑业#3.建筑安装业#4.建筑装饰、装修和其他建筑业#(五)批发和零售业#1.批发业#其中:烟草制品批发#煤炭及制品批发#石油及其制品批发#汽车及零配件批发#2.零售业#(六)交通运输、仓储和邮政业#1.铁路运输业#2.道路运输业#3.水上运输业#4.航空运输业#5.管道运输业#6.多式联运和运输代理业#7.装卸搬运和仓储业#8.邮政业#(七)住宿和餐饮业#1.住宿业#2.餐饮业#（八）信息传输、软件和信息技术服务业#1.电信、广播电视和卫星传输服务业#其中：电信#2.互联网和相关服务#3.软件和信息技术服务业#(九)金融业#1.货币金融服务#其中：银行#金融租赁#2.资本市场服务#3.保险业#4.其他金融业#(十)房地产业#(十一)租赁和商务服务业#1.租赁业#2.商务服务业#(十二）科学研究和技术服务业#（十三）居民服务、修理和其他服务业#其中：居民服务业#机动车、电子产品和日用产品修理业#(十四)教育#（十五）卫生和社会工作#其中：卫生#(十六)文化、体育和娱乐业#其中：新闻和出版业#广播、电视、电影和影视录音制作业#体育#娱乐业#(十七)公共管理、社会保障和社会组织#(十八)其他行业";
		colsHName[1902] = "序号#项目#合计#内资企业小计#内资企业国有企业#内资企业集体企业#内资企业股份合作企业#内资企业联营企业#内资企业其中：国有控股#内资企业股份公司#内资企业其中：国有控股#内资企业私营企业#内资企业其它企业#港澳台投资企业#其中：国有控股#外商投资企业#其中：国有控股";

		sjNum[20] = 2;
		colsL[20] = "HJ#YCKY#1MTKCHXXY#2SYHTRQKCY#QZYY#3HSJSKCXY#4YSJSKCXY#5FJSKCXY#6QTCKY#EZZY#1NFSPJGY#2SPZZY#3JYLHJZCZZY#JDZZ#QZJJ#YLZZ#JZCZZ#4YCZPY#YYFK#JYZZ#QTYCZPJG#5FZY#6FZFZFSY#QZFZFZ#7PGMPYMJQZPHZXY#QZPGMP#8MCJGHMZTZCZPY#9JJZZY#10ZZHZZPY#ZJZZ#ZZ#QZJZZJZBZZ#ZZPZZ#11YSHJLMJFZY#12WJGMTYHYLYPZZY#13SYMTJQTRLJGY#QZCPY#14HXYLHHXZPZZY#FLZZ#NYZZ#ZYHXCPZZ#RYHXCPZZ#QZHZPZZ#QT1#15YYZZY#16HXXWZZY#17XJHSLZPY#QZLTZZ#18FJSKWZPY#SNSHHSGZZ#QZSNZZ#SNJSGZPZZ#BLJBLZPZZ#QT2#19HSJSYLHYYJGY#QZGYYJG#20YSJSYLHYYJGY#21JSZPY#22TYSBZZY#23ZYSBZZY#24QCZZY#25TLCBHKHTHQTYSSBZZY#QZTLYSSBZZ#CBJXGZZZZ#HKHTJSBZZ#MTCZZ#26DQJXHQCZZY#DJZZ#DXDLGLJDGQCZZ#JYDLQJZZ#QT3#27JSJTXHQTDZSBZZY#JSJZZ#TXSBZZ#GBDSSBZZ#FZYSTSBZZ#ZNXFSBZZ#QT4#28YBYQZZY#29QTZZY#SDLRLRQJSDSCHGYY#1DLRLSCHGYY#DLSC#QZHLFD#RDLC#SLFD#HLFD#FLFD#TYNFD#DLGY#RLSCHGYY#2RQSCHGYY#3SDSCHGYY#SJZY#1FWJZY#2TMGCJZY#3JZAZY#4JZZSZXHQTJZY#WPFHLSY#1PFY#QZYCZPPF#MTJZPPF#SYJQZPPF#QCJLPJPF#2LSY#LJTYSCCHYZY#1TLYSY#2DLYSY#3SSYSY#4HKYSY#5GDYSY#6DSLYHYSDLY#7ZXBYHCCY#8YZY#QZSHCYY#1ZSY#2CYY#BXXCSRJHXXJSFWY#1DXGBDSHWXCSFWY#QZDX#2HLWHXGFW#3RJHXXJSFWY#JJRY#1HBJRFW#QZYX#JRZL#2ZBSCFW#3BXY#4QTJRY#SFDCY#SYZLHSWFWY#1ZLY#2SWFWY#SEKXYJHJSFWY#SSJMFWXLHQTFWY#QZJMFWY#JDCDZCPHRYCPXLY#SSJY#SWWSHSHGZ#QZWS#SLWHTYHYLY#QZXWHCBY#GBDSDYHYSLYZZY#TY#YLY#SQGGGLSHBZHSHZZ#SBQTXY";
		colsH[20] = "XH#XM#HJ#YJ#HSQJ#JNYQNDQS";
		colsLName[20] = "合计#(一)采矿业#1.煤炭开采和洗选业#2.石油和天然气开采业#其中:原油#3.黑色金属矿采选业#4.有色金属矿采选业#5.非金属矿采选业#6.其他采矿业#(二)制造业#1.农副食品加工业#2.食品制造业#3.酒、饮料和精制茶制造业#①酒的制造#其中：酒精#②饮料制造#③精制茶制造#4.烟草制品业#烟叶复考#卷烟制造#其他烟草制品加工#5.纺织业#6.纺织服装、服饰业#其中：纺织服装#7.皮革、毛皮、羽毛及其制品和制鞋业#其中：皮革、毛皮#8.木材加工和木竹藤棕草制品业#9.家具制造业#10.造纸和纸制品业#①纸浆制造#②造纸#其中：机制纸及纸板制造#③纸制品制造#11.印刷和记录媒介复制业#12.文教、工美、体育和娱乐用品制造业#13.石油、煤炭及其他燃料加工业#其中：成品油#14.化学原料和化学制品制造业#①肥料制造#②农药制造#③专用化学产品制造#④日用化学产品制造#其中：化妆品制造#⑤其他#15.医药制造业#16.化学纤维制造业#17.橡胶和塑料制品业#其中：轮胎制造#18.非金属矿物制品业#①水泥、石灰和石膏制造#其中：水泥制造#②水泥及石膏制品制造#③玻璃及玻璃制品制造#④其他#19.黑色金属冶炼和压延加工业#其中：钢压延加工#20.有色金属冶炼和压延加工业#21.金属制品业#22.通用设备制造业#23.专用设备制造业#24.汽车制造业#25.铁路、船舶、航空航天和其他运输设备制造业#其中：铁路运输设备制造#船舶及相关装置制造#航空、航天及设备制造#摩托车制造#26.电气机械和器材制造业#①电机制造#②电线电缆光缆及电工器材制造#③家用电力器具制造#④其他#27.计算机、通信和其他电子设备制造业#①计算机制造#②通信设备制造#③广播电视设备制造#④非专业视听设备制造#⑤智能消费设备制造#⑥其他#28.仪表仪器制造业#29.其他制造业#(三)电力、热力、燃气及水的生产和供应业#1.电力、热力生产和供应业#①电力生产#其中：火力发电#热电联产#水力发电#核力发电#风力发电#太阳能发电#②电力供应#③热力生产和供应业#2.燃气生产和供应业#3.水的生产和供应业#(四)建筑业#1.房屋建筑业#2.土木工程建筑业#3.建筑安装业#4.建筑装饰、装修和其他建筑业#(五)批发和零售业#1.批发业#其中:烟草制品批发#煤炭及制品批发#石油及其制品批发#汽车及零配件批发#2.零售业#(六)交通运输、仓储和邮政业#1.铁路运输业#2.道路运输业#3.水上运输业#4.航空运输业#5.管道运输业#6.多式联运和运输代理业#7.装卸搬运和仓储业#8.邮政业#(七)住宿和餐饮业#1.住宿业#2.餐饮业#（八）信息传输、软件和信息技术服务业#1.电信、广播电视和卫星传输服务业#其中：电信#2.互联网和相关服务#3.软件和信息技术服务业#(九)金融业#1.货币金融服务#其中：银行#金融租赁#2.资本市场服务#3.保险业#4.其他金融业#(十)房地产业#(十一)租赁和商务服务业#1.租赁业#2.商务服务业#(十二）科学研究和技术服务业#（十三）居民服务、修理和其他服务业#其中：居民服务业#机动车、电子产品和日用产品修理业#(十四)教育#（十五）卫生和社会工作#其中：卫生#(十六)文化、体育和娱乐业#其中：新闻和出版业#广播、电视、电影和影视录音制作业#体育#娱乐业#(十七)公共管理、社会保障和社会组织#(十八)其他行业";
		colsHName[20] = "序号#项目#合计#预缴#汇算清缴#缴纳以前年度欠税";



		sjNum[21] = 2;
		colsL[21] = "HJ#1GZXJSD#A3SLZS1#A10SLZS2#A20SLZS3#A25SLZS4#A30SLZS5#A35SLZS6#A45SLZS7#2GTGSHSCJYSD#A5SLZS1#A10SLZS11#A20SLZS21#A30SLZS13#A35SLZS14#HDZS12#3QSYDWCBCZJYSD#A5SLZS#A10SLZS#A20SLZS14#A30SLZS15#A35SLZS#HDZS#4LWBCSD#A20SLZS#A30SLZS#A40SLZS#5GCSD#6TXQSYFSD#7LXGXHLSD#QZCXCKLXSD#8CCZLSD#9CCZRSD#QZXSGZRSD#FWZRSD#10ORSD#11QTSD#12SKZNJFKSR";
		colsH[21] = "XH#XM#HJ#DL#GAT#WG";
		colsLName[21] = "合计#1、工资、薪金所得#按3%税率征收#按10%税率征收#按20%税率征收#按25%税率征收#按30%税率征收#按35%税率征收#按45%税率征收#2、个体工商户生产、经营所得#按5%税率征收#按10%税率征收#按20%税率征收#按30%税率征收#按35%税率征收#核定征收#3、企事业单位承包、承租经营所得#按5%税率征收#按10%税率征收#按20%税率征收#按30%税率征收#按35%税率征收#核定征收#4、劳务报酬所得#按20%税率征收#按30%税率征收#按40%税率征收#5、稿酬所得#6、特许权使用费所得#7、利息、股息、红利所得#其中：储蓄存款利息所得#8、财产租赁所得#9、财产转让所得#其中：限售股转让所得#房屋转让所得#10、偶然所得#11、其他所得#12、税款滞纳金、罚款收入";
		colsHName[21] = "序号#项目#合计#大陆#港澳台#外国";

		sjNum[22] =3 ;
		colsL[22] = "HJ#YNYK#1MT#2YY#3TRQ#4MCCQ#5DR#6QTNYK#EJSK#1TK#2JK#3TK#4LTK#5QXK#6NK#7XK#8ZZXTK#9QXTK#10WK#11ZK#12MK#13YK#14QTJSK#SFJSK#1SM#2GZT#3GLT#4YS#5SHS#6LTK#7LK#8LHJ#9LSJ#10ZT#11SS#12JKY#13HY#14HY#15DXLSSZDY#16KQS#17DLY#18HGY#19NHZT#20MX#21QTFJSK#SSZY#1DBS#2DXS#3ZLS#WQT#LSKZNJFKSR";
		colsH[22] = "XH#XM#HJ#NZQYXJ#NZQYGYQY#NZQYJTQY#NZQYGFHZQY#NZQYLYQY#NZQYQZGYKG1#NZQYGFGS#NZQYQZGYKG2#NZQYSYQY#NZQYQTQY#GATTZQY#QZGYKG3#WSTZQY#QZGYKG4#GTJY";
		colsLName[22] = "合计#一、能源矿#1.煤炭#2.原油#3.天然气#4.煤层（成）气#5.地热#6.其他能源矿#二、金属矿#1.铁矿#2.金矿#3.铜矿#4.铝土矿#5.铅锌矿#6.镍矿#7.锡矿#8.中重稀土矿#9.轻稀土矿#10.钨矿#11.钼矿#12.锰矿#13.银矿#14.其他金属矿#三、非金属矿#1.石墨#2.硅藻土#3.高岭土#4.萤石#5.石灰石#6.硫铁矿#7.磷矿#8.氯化钾#9.硫酸钾#10.粘土#11.砂石#12.井矿盐#13.湖盐#14.海盐#15.地下卤水晒制的盐#16.矿泉水#17.大理岩#18.花岗岩#19.耐火粘土#20.芒硝#21.其他非金属矿#四、水资源#1.地表水#2.地下水#3.自来水#五、其他#六、税款滞纳金、罚款收入";
		colsHName[22] = "序号#项目#合计#内资企业小计#内资企业国有企业#内资企业集体企业#内资企业股份合作企业#内资企业联营企业#内资企业其中：国有控股#内资企业股份公司#内资企业其中：国有控股#内资企业私营企业#内资企业其它企业#港澳台投资企业#其中：国有控股#外商投资企业#其中：国有控股#个体经营";

		sjNum[2301] = 3;
		colsL[2301] = "HJ#YDQWRW#QZHYGC#YEYHL#EDYHW#SYYHT#SLQ#WLHQ#LFHW#QQHQ#BLSW#JGSW#SGJQHHW#SYYBXFC#SESMC#SSBLMC#SSTHC#SWQJQHHW#SLZJQHHW#SQZJQHHW#SBNJQHHW#SJXJQHHW#ESYC#ESYB#ESEJB#ESSEJB#ESSBBaZ#ESWJQ#ESLYQ#ESQBXQ#ESBJC#ESJFL#SSLQY#SSYBAL#SSELBL#SSSXJB#SSSBXZ#SSWLYX#SSLGQ#SSQLHQ#SSBA#SSJSJA#SSJLC#SSYJLM#SSEEJEL#SSSBYX#SSSELHT#SSWQT#ESWRW#QZHYGC1#YDYLSWRW#1ZG#2ZZ#3ZG#4LJG#5ZS#6ZQ#7ZN#8BBaZ#9ZZ#10ZYS#EDELSWRW#1XFWSS#2SHXYLBOD5#3HXXYLCODcr#4ZYJTTOC#5SYL#6DZWY#7HFF#8ZQHW#9LHW#10AD#11FHW#12JQ#13BAL";
		colsH[2301] = "XH#XM#HJ#NZQYXJ#NZQYGYQY1#NZQYJTQY#NZQYGFHZQY#NZQYLYQY#NZQYQZGYKG1#NZQYGFGS#NZQYQZGYKG#NZQYSYQY#NZQYQTQY#GATTZQY#QZGYKG#WSTZQY#QZGYKG1#GTJY";
		colsLName[2301] = "合计#一、大气污染物#其中：海洋工程#（一）二氧化硫#（二）氮氧化物#（三）一氧化碳#（四）氯气#（五）氯化氢#（六）氟化物#（七）氰化氢#（八）硫酸雾#（九）铬酸雾#（十）汞及其化合物#（十一）一般性粉尘#（十二）石棉尘#（十三）玻璃棉尘#（十四）碳黑尘#（十五）铅及其化合物#（十六）镉及其化合物#（十七）铍及其化合物#（十八）镍及其化合物#（十九）锡及其化合物#（二十）烟尘#（二十一）苯#（二十二）甲苯#（二十三）二甲苯#（二十四）苯并(a)芘#（二十五）甲醛#（二十六）乙醛#（二十七）丙烯醛#（二十八）甲醇#（二十九）酚类#（三十）沥青烟#（三十一）苯胺类#（三十二）氯苯类#（三十三）硝基苯#（三十四）丙烯腈#（三十五）氯乙烯#（三十六）光气#（三十七）硫化氢#（三十八）氨#（三十九）三甲胺#（四十）甲硫醇#（四十一）甲硫醚#（四十二）二甲二硫#（四十三）苯乙烯#（四十四）二硫化碳#（四十五）其他#二、水污染物#其中：海洋工程#（一）第一类水污染物#1.总汞#2.总镉#3.总铬#4.六价铬#5.总砷#6.总铅#7.总镍#8.苯并(a)芘#9.总铍#10.总银（水）#（二）第二类水污染物#1.悬浮物(SS)#2.生化需氧量(BOD5)#3.化学需氧量(CODcr)#4.总有机碳（TOC）#5.石油类#6.动植物油#7.挥发酚#8.总氰化物#9.硫化物#10.氨氮#11.氟化物#12.甲醛#13.苯胺类";
		colsHName[2301] = "序号#项目#合计#内资企业小计#内资企业国有企业#内资企业集体企业#内资企业股份合作企业#内资企业联营企业#内资企业其中：国有控股#内资企业股份公司#内资企业其中：国有控股#内资企业私营企业#内资企业其它企业#港澳台投资企业#其中：国有控股#外商投资企业#其中：国有控股#个体经营";

		sjNum[2302] = 3;
		colsL[2302] = "14XJBL#15YLZBMHXJLAS#16ZT#17ZX#18ZM#19CSXYJCD2#20ZL#21DZLYPJ#22YJLNYYPJ#23LG#24JJDLL#25MLLL#26DLL#27WLFJWLFNYWLFJ#28SLJW#29KXFYJLHWAOXYClJ#30SLHT#31SLYX#32SLYX#33B#34JB#35YB#36LEJB#37DEJB#38JEJB#39LB#40LELB#41DELB#42DXJLB#4324EXJLB#44BF#45JJF#4624ELF#47246SLF#48LBEJSEDZ#49LBEJSEXZ#50BXZ#51ZX#SpHZSDDCJQSYLL#1pHZ#2SD#3DCJQSCB#4YLLYLXDDYYFS#SQXYZYXXQYHDSCY#1QXYZCN#2QXYZCZ#3QXYZCJYDJQ#4XXQY#5YSYLFWY#6YYXDC#7YYXDWS#8YYBXDC#9YYBXDWS#10QTXXPW#SGTFW#QZHYGC#YMZS#EWK#SWXFW#SYLZ#WFMH#LLZ#QHYGCSHLJ#BQTGTFWHBGTYTFW#SZS#YCB13FB#ECB46FB#SCB79FB#SCB1012FB#WCB1315FB#LCB16FBYS#WSKZNJFKSR";
		colsH[2302] = "XH#XM#HJ#NZQYXJ#NZQYGYQY1#NZQYJTQY#NZQYGFHZQY#NZQYLYQY#NZQYQZGYKG1#NZQYGFGS#NZQYQZGYKG#NZQYSYQY#NZQYQTQY#GATTZQY#QZGYKG#WSTZQY#QZGYKG1#GTJY";
		colsLName[2302] = "14.硝基苯类#15.阴离子表面活性剂(LAS)#16.总铜#17.总锌#18.总锰#19.彩色显影剂(CD-2)#20.总磷#21.单质磷(以P计)#22.有机磷农药(以P计)#23.乐果#24.甲基对硫磷#25.马拉硫磷#26.对硫磷#27.五氯酚及五氯酚钠(以五氯酚计)#28.三氯甲烷#29.可吸附有机卤化物(AOX)(以Cl计)#30.四氯化碳#31.三氯乙烯#32.四氯乙烯#33.苯#34.甲苯#35.乙苯#36.邻－二甲苯#37.对－二甲苯#38.间－二甲苯#39.氯苯#40.邻二氯苯#41.对二氯苯#42.对硝基氯苯#43.2,4－二硝基氯苯#44.苯酚#45.间－甲酚#46.2,4－二氯酚#47.2,4,6-三氯酚#48.邻苯二甲酸二丁脂#49.邻苯二甲酸二辛脂#50.丙烯腈#51.总硒#（三）pH值、色度、大肠菌群数、余氯量#1.pH值#2.色度#3.大肠菌群数(超标)#4.余氯量(用氯消毒的医院废水)#（四）禽畜养殖业、小型企业和第三产业#1.禽畜养殖场(牛)#2.禽畜养殖场(猪)#3.禽畜养殖场(鸡、鸭等家禽)#4.小型企业#5.饮食娱乐服务业#6.医院(消毒-床)#7.医院(消毒-污水)#8.医院(不消毒-床)#9.医院(不消毒-污水)#10.其他小型排污#三、固体废物#其中：海洋工程#（一）煤矸石#（二）尾矿#（三）危险废物#（四）冶炼渣#（五）粉煤灰#（六）炉渣#（七）海洋工程生活垃圾#（八）其他固体废物（含半固态、液态废物）#四、噪声#（一）超标1-3分贝#（二）超标4-6分贝#（三）超标7-9分贝#（四）超标10-12分贝#（五）超标13-15分贝#（六）超标16分贝以上#五、税款滞纳金、罚款收入";
		colsHName[2302] = "序号#项目#合计#内资企业小计#内资企业国有企业#内资企业集体企业#内资企业股份合作企业#内资企业联营企业#内资企业其中：国有控股#内资企业股份公司#内资企业其中：国有控股#内资企业私营企业#内资企业其它企业#港澳台投资企业#其中：国有控股#外商投资企业#其中：国有控股#个体经营";

		
		sjNum[24] = 2;
		colsL[24] = "YSWSSSR1#YZWHZJYQY2#1CKY3#2ZZY4#3DLRLRQJSDSCHGYY5#4JZY6#5PFHLSY7#6JTYSCCHYZY8#7ZSHCYY9#8XXCSRJHXXJSFWY10#9JRY11#10FDCY12#11ZLHSWFWY13#12KXYJHJSFWY14#13WHTYHYLY15#14QTXY16#EZWHZJYQY17#1CKY18#2ZZY19#3DLRLRQJSDSCHGYY20#4JZY21#5PFHLSY22#6JTYSCCHYZY23#7ZSHCYY24#8XXCSRJHXXJSFWY25#9JRY26#10FDCY27#11ZLHSWFWY28#12KXYJHJSFWY29#13WHTYHYLY30#14QTXY31#SWZQY32#1CKY33#2ZZY34#3DLRLRQJSDSCHGYY35#4JZY36#5PFHLSY37#6JTYSCCHYZY38#7ZSHCYY39#8XXCSRJHXXJSFWY40#9JRY41#10FDCY42#11ZLHSWFWY43#12KXYJHJSFWY44#13WHTYHYLY45#14QTXY46#SFJMQY47#1WGQYCZDBJG48#2TGLWCBGCZY49#3JRHBX50#4GJYSSR51#5ZFDWKJ52#6QT53#WWJGR54#LJKHWSS55#ECKHWTS56";
		colsH[24] = "XH#XM#HJ#ZZS#XFS#YYS#QYSDS#GRSDS#CSWHJSS#FCS#CZTDSYS#CCS#QTGS";
		colsLName[24] = "一、涉外税收收入#(一)中外合资经营企业#1、采矿业#2、制造业#3、电力、热力、燃气及水的生产和供应业#4、建筑业#5、批发和零售业#6、交通运输、仓储和邮政业#7、住宿和餐饮业#8、信息传输、软件和信息技术服务业#9、金融业#10、房地产业#11、租赁和商务服务业#12、科学研究和技术服务业#13、文化、体育和娱乐业#14、其他行业#(二)中外合作经营企业#1、采矿业#2、制造业#3、电力、热力、燃气及水的生产和供应业#4、建筑业#5、批发和零售业#6、交通运输、仓储和邮政业#7、住宿和餐饮业#8、信息传输、软件和信息技术服务业#9、金融业#10、房地产业#11、租赁和商务服务业#12、科学研究和技术服务业#13、文化、体育和娱乐业#14、其他行业#(三)外资企业#1、采矿业#2、制造业#3、电力、热力、燃气及水的生产和供应业#4、建筑业#5、批发和零售业#6、交通运输、仓储和邮政业#7、住宿和餐饮业#8、信息传输、软件和信息技术服务业#9、金融业#10、房地产业#11、租赁和商务服务业#12、科学研究和技术服务业#13、文化、体育和娱乐业#14、其他行业#(四)非居民企业#1、外国企业常驻代表机构#2、提供劳务、承包工程作业#3、金融和保险#4、国际运输收入#5、支付单位扣缴#6、其他#(五)外籍个人#(六)进口货物税收#二、出口货物退税";
		colsHName[24] = "序号#项目#合计#增值税#消费税#营业税#企业所得税#个人所得税#城市维护建设税#房产税#城镇土地使用税#车船税#其他各税";
		

		sjNum[25] = 2;
		colsL[25] = "HJ#QZBNXQ#WNCQ#1GNZZS#1YCZPY#QZJY#2JZZY#3FZY#4YYJGJSYZPZZY#QZCPY#5HXYLHHXZPZZY#6FJSKWZPY#7HSJSYLJYYJGY#QZGPGC#8QCZZY#9MTCZZY#10MTKCHXXY#11YYHTRQKC#QZYY#12DLSCHGYY#13JZY#14JTYSY#QZTLYSFW#LLYSFW#SLYSFW#HKYSFW#GDYSFW#15YZY#16DXY#17JRY#QZHBJRFW#ZBSCFW#BXY#18FDCY#QZFDCKFJYY#19KXYJHJSFWY#2GNXFS#QZ1JJJJ#J#JJ#2Y#JY#XQY#YS#3CPY#4XQC#5MTC#3YYS#4QYSDS#5CSWHJSS#6QTGS";
		colsH[25] = "XH#XM#HJ#GYQY#JTQY#GFHZQY#LYQY#QZGYKG1#GFGS#QZGYKG2#SYQY#GATTZQY#QZGYKG3#WSTZQY#QZGYKG4#QTQY#GTJKKQY";
		colsLName[25] = "合计#其中:本年新欠#往年陈欠#1、国内增值税#(1)烟草制品业#其中:卷烟#(2)酒制造业#(3)纺织业#(4)原油加工及石油制品制造业#其中:成品油#(5)化学原料和化学制品制造业#(6)非金属矿物制品业#(7)黑色金属冶炼及压延加工业#其中:钢坯、钢材#(8)汽车制造业#(9)摩托车制造业#(10)煤炭开采和洗选业#(11)原油和天然气开采#其中:原油#(12)电力生产和供应业#(13)建筑业#(14)交通运输业#其中：铁路运输服务#陆路运输服务#水路运输服务#航空运输服务#管道运输服务#(15)邮政业#(16)电信业#(17)金融业#其中：货币金融服务#资本市场服务#保险业#(18)房地产业#其中：房地产开发经营业#(19)科学研究和技术服务业#2、国内消费税#其中：(1)酒及酒精#酒#酒精#(2)烟#卷烟#雪茄烟#烟丝#(3)成品油#(4)小汽车#(5)摩托车#3、营业税#4、企业所得税#5、城市维护建设税#6、其他各税";
		colsHName[25] = "序号#项目#合计#国有企业#集体企业#股份合作企业#联营企业#其中：国有控股#股份公司#其中：国有控股#私营企业#港澳台投资企业#其中：国有控股#外商投资企业#其中：国有控股#其他企业#关、停及空壳企业";

		sjNum[26] = 3;
		colsL[26] = "QMYEHJ#QMYE1GNZZS#QMYE2GNXFS#QMYE3YYS#QMYE4QYSDS#QMYE5GRSDS#QMYE6ZYS#QMYE7CSWHJSS#QMYE8FCS#QMYE9YHS#QMYE10CZTDSYS#QMYE11TDZZS#QMYE12CCS#QMYE13CLGZS#QMYE14YYS#QMYE15GDZYS#QMYE16QS#QMYE17HJBHS#QMYE18QTSS#DNRKHJ#DNRK1GNZZS#DNRK2GNXFS#DNRK3YYS#DNRK4QYSDS#DNRK5GRSDS#DNRK6ZYS#DNRK7CSWHJSS#DNRK8FCS#DNRK9YHS#DNRK10CZTDSYS#DNRK11TDZZS#DNRK12CCS#DNRK13CLGZS#DNRK14YYS#DNRK15GDZYS#DNRK16QS#DNRK17HJBHS#DNRK18QTSS";
		colsH[26] = "XH#XM1#XM2#QSHJ#1WNCQXJ#1WNCQ5NYS#1WNCQ2013N#1WNCQ2014N#1WNCQ2015N#1WNCQ2016N#1WNCQ2017N#2BNXQ#3GTJKKQYQSWN#3GTJKKQYQSBN";
		colsLName[26] = "期末余额合计#期末余额1.国内增值税#期末余额2.国内消费税#期末余额3.营业税#期末余额4.企业所得税#期末余额5.个人所得税#期末余额6.资源税#期末余额7.城市维护建设税#期末余额8.房产税#期末余额9.印花税#期末余额10.城镇土地使用税#期末余额11.土地增值税#期末余额12.车船税#期末余额13.车辆购置税#期末余额14.烟叶税#期末余额15.耕地占用税#期末余额16.契税#期末余额17.环境保护税#期末余额18.其他税收#当年入库合计#当年入库1.国内增值税#当年入库2.国内消费税#当年入库3.营业税#当年入库4.企业所得税#当年入库5.个人所得税#当年入库6.资源税#当年入库7.城市维护建设税#当年入库8.房产税#当年入库9.印花税#当年入库10.城镇土地使用税#当年入库11.土地增值税#当年入库12.车船税#当年入库13.车辆购置税#当年入库14.烟叶税#当年入库15.耕地占用税#当年入库16.契税#当年入库17.环境保护税#当年入库18.其他税收";
		colsHName[26] = "序号#项目#项目#欠税合计#1.往年陈欠小计#1.往年陈欠5年以上#1.往年陈欠2013年#1.往年陈欠2014年#1.往年陈欠2015年#1.往年陈欠2016年#1.往年陈欠2017年#2.本年新欠#3.关停及空壳企业欠税往年#3.关停及空壳企业欠税本年";

		sjNum[27] = 2;
		colsL[27] = "HJ#QZ1Y#2J#3YJ#4MT#5YY#6CPY#7HG#8DL#9FZP#10QC#11MTC#12JRBX#13JTYS";
		colsH[27] = "XH#XM#HJ#GNZZS#GNXFS#YYS#QYSDS#CSWHJSS#QTGS";
		colsLName[27] = "合计#其中：1、烟#2、酒#3、冶金#4、煤炭#5、原油#6、成品油#7、化工#8、电力#9、纺织品#10、汽车#11、摩托车#12、金融、保险#13、交通运输";
		colsHName[27] = "序号#项目#合计#国内增值税#国内消费税#营业税#企业所得税#城市维护建设税#其他各税";

		sjNum[28] = 2;
		colsL[28] = "ZJ#YGSMS#1ZF#2JZJZJ#3JZZY#4ZJYFC#5SHBZ#6TGJMSR#7QT1#EGLGXJS#1JSZR#2KJFZ#3ZZCX#4KYJGZZ#5TZCY#6WBFW#7GXJS#8QT2#SCJXWQYFZ#1JRSC#2WDQZD#3MZZZSHYYSZC#4QT3#SZZSJ#1QYFZ#2QYZZGZ#3QT#WJNHB#1HJBH#2DLJS#3ZYZHLY#4QT5#LCJQYFZ#1XBKF#2DBFZ#3LAJL#4QT4#QZCWHJYTY#1JY#2TY#3WH#BZCJRZBSC#1ZBSC#2JRSC#JZCSN#1NCJS#2FLSL#3CYSJ#4JRSC#5QT6#SZCQTGXSY#1FJZZ#2JCSSJS#3CPY#4GFJS#5GJF#6YLWS#7JTYS#8WCYZ#9GY#10SPCB#11WJRY#12ZXCZXZJ#13QT7#SYXSSSXDDY#1GX#2LX#3TXQSYF#4CCSY#5QT8";
		colsH[28] = "XH#XM#HJ#CKY#ZZY#DLRQJSDSCHGYY#JZY#JTYSCCJYZY#PFHLSY#JRY#XXCSJSJFWHRJY#ZLHSWFWY#FDCY#QTXY";
		colsLName[28] = "总计#一、改善民生#1.住房#2.救灾及重建#3.军转择业#4.再就业扶持#5.社会保障#6.提高居民收入#7.其他#二、鼓励高新技术#1.技术转让#2.科技发展#3.自主创新#4.科研机构转制#5.投资创业#6.外包服务#7.高新技术#8.其他#三、促进小微企业发展#1.金融市场#2.未达起征点#3.免征增值税和营业税政策#4.其他#四、转制升级#1.企业发展#2.企业重组改制#3.其他#五、节能环保#1.环境保护#2.电力建设#3.资源综合利用#4.其他#六、促进区域发展#1.西部开发#2.东部发展#3.两岸交流#4.其他#七、支持文化教育体育#1.教育#2.体育#3.文化#八、支持金融资本市场#1.资本市场#2.金融市场#九、支持三农#1.农村建设#2.肥料饲料#3.产业升级#4.金融市场#5.其他#十、支持其他各项事业#1.飞机制造#2.基础设施建设#3.成品油#4.国防建设#5.公检法#6.医疗卫生#7.交通运输#8.无偿援助#9.公益#10.商品储备#11.外籍人员#12.专项财政性资金#13.其他#十一、享受税收协定待遇#1.股息#2.利息#3.特许权使用费#4.财产收益#5.其他";
		colsHName[28] = "序号#项目#合计#采矿业#制造业#电力燃气及水的生产和供应业#建筑业#交通运输仓储及邮政业#批发和零售业#金融业#信息传输计算机服务和软件业#租赁和商务服务业#房地产业#其他行业";

		sjNum[29] = 3;
		colsL[29] = "ZJ#YGSMS#1ZF#2JZJZJ#3JZZY#4ZJYFC#5SHBZ#6TGJMSR#7QT1#EGLGXJS#1JSZR#2KJFZ#3ZZCX#4KYJGZZ#5TZCY#6WBFW#7GXJS#8QT2#SCJXWQYFZ#1JRSC#2WDQZD#3MZZZSHYYSZC#4QT3#SZZSJ#1QYFZ#2QYZZGZ#3QT4#WJNHB#1HJBH#2DLJS#3ZYZHLY#4QT5#LCJQYFZ#1XBKF#2DBFZ#3LAJL#4QT6#QZCWHJYTY#1JY#2TY#3WH#BZCJRZBSC#1ZBSC#2JRSC#JZCSN#1NCJS#2FLSL#3CYSJ#4JRSC#5QT7#SZCQTGXSY#1FJZZ#2JCSSJS#3CPY#4GFJS#5GJF#6YLWS#7JTYS#8WCYZ#9GY#10SPCB#11WJRY#12ZXCZXZJ#13QT8#SYXSSSXDDY#1GX#2LX#3TXQSYF#4CCSY#5QT9";
		colsH[29] = "XH#XM#HJ#NZQYXJ#NZQYGYQY#NZQYJTQY#NZQYGFHZQY#NZQYLYQY#NZQYGFGS#NZQYSYQY#NZQYQTNZQY#GATTZQY#WSTZQY#GTJY";
		colsLName[29] = "总计#一、改善民生#1.住房#2.救灾及重建#3.军转择业#4.再就业扶持#5.社会保障#6.提高居民收入#7.其他#二、鼓励高新技术#1.技术转让#2.科技发展#3.自主创新#4.科研机构转制#5.投资创业#6.外包服务#7.高新技术#8.其他#三、促进小微企业发展#1.金融市场#2.未达起征点#3.免征增值税和营业税政策#4.其他#四、转制升级#1.企业发展#2.企业重组改制#3.其他#五、节能环保#1.环境保护#2.电力建设#3.资源综合利用#4.其他#六、促进区域发展#1.西部开发#2.东部发展#3.两岸交流#4.其他#七、支持文化教育体育#1.教育#2.体育#3.文化#八、支持金融资本市场#1.资本市场#2.金融市场#九、支持三农#1.农村建设#2.肥料饲料#3.产业升级#4.金融市场#5.其他#十、支持其他各项事业#1.飞机制造#2.基础设施建设#3.成品油#4.国防建设#5.公检法#6.医疗卫生#7.交通运输#8.无偿援助#9.公益#10.商品储备#11.外籍人员#12.专项财政性资金#13.其他#十一、享受税收协定待遇#1.股息#2.利息#3.特许权使用费#4.财产收益#5.其他";
		colsHName[29] = "序号#项目#合计#内资企业小计#内资企业国有企业#内资企业集体企业#内资企业股份合作企业#内资企业联营企业#内资企业股份公司#内资企业私营企业#内资企业其他内资企业#港澳台投资企业#外商投资企业#个体经营";

		sjNum[30] =2 ;
		colsL[30] = "ZJ#YGSMS#1ZF#2JZJZJ#3JZZY#4ZJYFC#5SHBZ#6TGJMSR#7QT1#EGLGXJS#1JSZR#2KJFZ#3ZZCX#4KYJGZZ#5TZCY#6WBFW#7GXJS#8QT3#SCJXWQYFZ#1JRSC#2WDQZD#3MZZZSHYYSZC#4QT4#SZZSJ#1QYFZ#2QYZZGZ#3QT4#WJNHB#1HJBH#2DLJS#3ZYZHLY#4QT12#LCJQYFZ#1XBKF#2DBFZ#3LAJL#4QT5#QZCWHJYTY#1JY#2TY#3WH#BZCJRZBSC#1ZBSC#2JRSC#JZCSN#1NCJS#2FLSL#3CYSJ#4JRSC#5QT6#SZCQTGXSY#1FJZZ#2JCSSJS#3CPY#4GFJS#5GJF#6YLWS#7JTYS#8WCYZ#9GY#10SPCB#11WJRY#12ZXCZXZJ#13QT7#SYXSSSXDDY#1GX#2LX#3TXQSYF#4CCSY#5QT19";
		colsH[30] = "XH#XM#HJ#ZQJM#TKJM#DDQS";
		colsLName[30] = "总计#一、改善民生#1.住房#2.救灾及重建#3.军转择业#4.再就业扶持#5.社会保障#6.提高居民收入#7.其他#二、鼓励高新技术#1.技术转让#2.科技发展#3.自主创新#4.科研机构转制#5.投资创业#6.外包服务#7.高新技术#8.其他#三、促进小微企业发展#1.金融市场#2.未达起征点#3.免征增值税和营业税政策#4.其他#四、转制升级#1.企业发展#2.企业重组改制#3.其他#五、节能环保#1.环境保护#2.电力建设#3.资源综合利用#4.其他#六、促进区域发展#1.西部开发#2.东部发展#3.两岸交流#4.其他#七、支持文化教育体育#1.教育#2.体育#3.文化#八、支持金融资本市场#1.资本市场#2.金融市场#九、支持三农#1.农村建设#2.肥料饲料#3.产业升级#4.金融市场#5.其他#十、支持其他各项事业#1.飞机制造#2.基础设施建设#3.成品油#4.国防建设#5.公检法#6.医疗卫生#7.交通运输#8.无偿援助#9.公益#10.商品储备#11.外籍人员#12.专项财政性资金#13.其他#十一、享受税收协定待遇#1.股息#2.利息#3.特许权使用费#4.财产收益#5.其他";
		colsHName[30] = "序号#项目#合计#征前减免#退库减免#抵顶欠税";

		sjNum[3401] = 2;
		colsL[3401] = "HJ#YDYCY#EDECY#YCKY#1MTKCHXXY#2SYHTRQKCY#3HSJSKCXY#4YSJSKCXY#5FJSKCXY#6QTCKY#EZZY#1NFSPJGY#2SPZZY#3JYLHJZCZZY#4YCZPY#5FZY#6FZFZFSY#7PGMPYMJQZPHZXY#8MCJGHMZTZCZPY#9JJZZY#10ZZHZZPY#11YSHJLMJFZY#12WJGMTYHYLYPZZY#13SYMTJQTRLJGY#14HXYLHHXZPZZY#15YYZZY#16HXXWZZY#17XJHSLZPY#18FJSKWZPY#19HSJSYLHYYJGY#20YSJSYLHYYJGY#21JSZPY#22TYSBZZY#23ZYSBZZY";
		colsH[3401] = "XH#XM#HJ#YJTYSFW#1LLYSFW#2SLYSFW#3HKYSFW#4GDYSFW#EYZFW#1YZPBFW#2YZTSFW#3QTYZFW#SDXFW#1JCDXFW#2ZZDXFW#SJZFW#1GCFW#2AZFW#3XSFW#4ZSFW#5QTJZFW#WJRFW#1DKFW#2ZJSFJRFW#3BXFW#4JRSPZR#LXDFW#1YFHJSFW#2XXJSFW#3WHCYFW#4WLFZFW#5ZLFW#6JZZXFW#7GBYSFW#8SWFZFW#9QTXDFW#QSHFW#1WHTYFW#2JYYLFW#3LYYLFW#4CYZSFW#5JMRCFW#6QTSHFW#BXSWXZC#1ZLHFZLJS#2SBHZZQ#3TDSYQ#4QTZRZYSYQ#5QTQYXWXZC#JXSBDC#1JZW#QZESFJY1#2GZW#QZESFJY2";
		colsLName[3401] = "合计#一、第一产业#二、第二产业#(一)采矿业#1.煤炭开采和洗选业#2.石油和天然气开采业#3.黑色金属矿采选业#4.有色金属矿采选业#5.非金属矿采选业#6.其他采矿业#(二)制造业#1.农副食品加工业#2.食品制造业#3.酒、饮料和精制茶制造业#4.烟草制品业#5.纺织业#6.纺织服装、服饰业#7.皮革、毛皮、羽毛及其制品和制鞋业#8.木材加工和木竹藤棕草制品业#9.家具制造业#10.造纸和纸制品业#11.印刷和记录媒介复制业#12.文教、工美、体育和娱乐用品制造业#13.石油、煤炭及其他燃料加工业#14.化学原料和化学制品制造业#15.医药制造业#16.化学纤维制造业#17.橡胶和塑料制品业#18.非金属矿物制品业#19.黑色金属冶炼和压延加工业#20.有色金属冶炼和压延加工业#21.金属制品业#22.通用设备制造业#23.专用设备制造业";
		colsHName[3401] = "序号#项目#合计#一、交通运输服务#1.陆路运输服务#2.水路运输服务#3.航空运输服务#4.管道运输服务#二、邮政服务#1.邮政普遍服务#2.邮政特殊服务#3.其他邮政服务#三、电信服务#1.基础电信服务#2.增值电信服务#四、建筑服务#1.工程服务#2.安装服务#3.修缮服务#4.装饰服务#5.其他建筑服务#五、金融服务#1.贷款服务#2.直接收费金融服务#3.保险服务#4.金融商品转让#六、现代服务#1.研发和技术服务#2.信息技术服务#3.文化创意服务#4.物流辅助服务#5.租赁服务#6.鉴证咨询服务#7.广播影视服务#8.商务辅助服务#9.其他现代服务#七、生活服务#1.文化体育服务#2.教育医疗服务#3.旅游娱乐服务#4.餐饮住宿服务#5.居民日常服务#6.其他生活服务#八、销售无形资产#1.专利或非专利技术#2.商标和著作权#3.土地使用权#4.其他自然资源使用权#5.其他权益性无形资产#九、销售不动产#1.建筑物#其中：二手房交易#2.构筑物#其中:二手房交易";
		
		
		
		sjNum[3402] = 2;
		colsL[3402] = "24QCZZY#25TLCBHKHTHQTYSSBZZY#26DQJXHQCZZY#27JSJTXHQTDZSBZZY#28YBYQZZY#29QTZZY#SDLRLRQJSDSCHGYY#1DLRLSCHGYY#2RQSCHGYY#3SDSCHGYY#SJZY#1FWJZY#2TMGCJZY#3JZAZY#4JZZSZXHQTJZY#SDSCY#YPFHLSY#1PFY#2LSY#EJTYSCCHYZY#1TLYSY#2DLYSY#3SSYSY#4HKYSY#5GDYSY#6DSLYHYSDLY#7ZXBYHCCY#8YZY#SZSHCYY#1ZSY#2CYY#SXXCSRJHXXJSFWY#1DXGBDSHWXCSFWY#2HLWHXGFW#3RJHXXJSFWY";
		colsH[3402] = "XH#XM#HJ#YJTYSFW#1LLYSFW#2SLYSFW#3HKYSFW#4GDYSFW#EYZFW#1YZPBFW#2YZTSFW#3QTYZFW#SDXFW#1JCDXFW#2ZZDXFW#SJZFW#1GCFW#2AZFW#3XSFW#4ZSFW#5QTJZFW#WJRFW#1DKFW#2ZJSFJRFW#3BXFW#4JRSPZR#LXDFW#1YFHJSFW#2XXJSFW#3WHCYFW#4WLFZFW#5ZLFW#6JZZXFW#7GBYSFW#8SWFZFW#9QTXDFW#QSHFW#1WHTYFW#2JYYLFW#3LYYLFW#4CYZSFW#5JMRCFW#6QTSHFW#BXSWXZC#1ZLHFZLJS#2SBHZZQ#3TDSYQ#4QTZRZYSYQ#5QTQYXWXZC#JXSBDC#1JZW#QZESFJY1#2GZW#QZESFJY2";
		colsLName[3402] = "24.汽车制造业#25.铁路、船舶、航空航天和其他运输设备制造业#26.电气机械和器材制造业#27.计算机、通信和其他电子设备制造业#28.仪表仪器制造业#29.其他制造业#(三)电力、热力、燃气及水的生产和供应业#1.电力、热力生产和供应业#2.燃气生产和供应业#3.水的生产和供应业#(四)建筑业#1.房屋建筑业#2.土木工程建筑业#3.建筑安装业#4.建筑装饰、装修和其他建筑业#三、第三产业#(一)批发和零售业#1.批发业#2.零售业#(二)交通运输、仓储和邮政业#1.铁路运输业#2.道路运输业#3.水上运输业#4.航空运输业#5.管道运输业#6.多式联运和运输代理业#7.装卸搬运和仓储业#8.邮政业#(三)住宿和餐饮业#1.住宿业#2.餐饮业#（四）信息传输、软件和信息技术服务业#1.电信、广播电视和卫星传输服务业#2.互联网和相关服务#3.软件和信息技术服务业";
		colsHName[3402] = "序号#项目#合计#一、交通运输服务#1.陆路运输服务#2.水路运输服务#3.航空运输服务#4.管道运输服务#二、邮政服务#1.邮政普遍服务#2.邮政特殊服务#3.其他邮政服务#三、电信服务#1.基础电信服务#2.增值电信服务#四、建筑服务#1.工程服务#2.安装服务#3.修缮服务#4.装饰服务#5.其他建筑服务#五、金融服务#1.贷款服务#2.直接收费金融服务#3.保险服务#4.金融商品转让#六、现代服务#1.研发和技术服务#2.信息技术服务#3.文化创意服务#4.物流辅助服务#5.租赁服务#6.鉴证咨询服务#7.广播影视服务#8.商务辅助服务#9.其他现代服务#七、生活服务#1.文化体育服务#2.教育医疗服务#3.旅游娱乐服务#4.餐饮住宿服务#5.居民日常服务#6.其他生活服务#八、销售无形资产#1.专利或非专利技术#2.商标和著作权#3.土地使用权#4.其他自然资源使用权#5.其他权益性无形资产#九、销售不动产#1.建筑物#其中：二手房交易#2.构筑物#其中:二手房交易";
		
		
		sjNum[3403] = 2;
		colsL[3403] = "WJRY#1HBJRFW#2ZBSCFW#3BXY#4QTJRY#LFDCY#1FDCKFJYY#2WYGL#3FDCZJFW#4FDCZLJY#5QTFDCY#QZLHSWFWY#1ZLY#2SWFWY#QZZXYDC#GGY#BKXYJHJSFWY#1YJHSYFZ#2ZYJSFWY#3KJTGHYYFWY#JSLHJHGGSSGLY#QZGGSSGLY#SJMFWXLHQTFWY#SYJY#SEWSHSHGZ#SSWHTYHYLY#SSGGGLSHBZHSHZZ#SWQTXY";
		colsH[3403] = "XH#XM#HJ#YJTYSFW#1LLYSFW#2SLYSFW#3HKYSFW#4GDYSFW#EYZFW#1YZPBFW#2YZTSFW#3QTYZFW#SDXFW#1JCDXFW#2ZZDXFW#SJZFW#1GCFW#2AZFW#3XSFW#4ZSFW#5QTJZFW#WJRFW#1DKFW#2ZJSFJRFW#3BXFW#4JRSPZR#LXDFW#1YFHJSFW#2XXJSFW#3WHCYFW#4WLFZFW#5ZLFW#6JZZXFW#7GBYSFW#8SWFZFW#9QTXDFW#QSHFW#1WHTYFW#2JYYLFW#3LYYLFW#4CYZSFW#5JMRCFW#6QTSHFW#BXSWXZC#1ZLHFZLJS#2SBHZZQ#3TDSYQ#4QTZRZYSYQ#5QTQYXWXZC#JXSBDC#1JZW#QZESFJY1#2GZW#QZESFJY2";
		colsLName[3403] = "(五)金融业#1.货币金融服务#2.资本市场服务#3.保险业#4.其他金融业#(六)房地产业#1.房地产开发经营业#2.物业管理#3.房地产中介服务#4.房地产租赁经营#5.其他房地产业#(七)租赁和商务服务业#1.租赁业#2.商务服务业#其中：咨询与调查#广告业#(八）科学研究和技术服务业#1.研究和实验发展#2.专业技术服务业#3.科技推广和应用服务业#（九）水利、环境和公共设施管理业#其中：公共设施管理业#（十）居民服务、修理和其他服务业#(十一)教育#（十二)卫生和社会工作#(十三)文化、体育和娱乐业#(十四)公共管理、社会保障和社会组织#(十五)其他行业";
		colsHName[3403] = "序号#项目#合计#一、交通运输服务#1.陆路运输服务#2.水路运输服务#3.航空运输服务#4.管道运输服务#二、邮政服务#1.邮政普遍服务#2.邮政特殊服务#3.其他邮政服务#三、电信服务#1.基础电信服务#2.增值电信服务#四、建筑服务#1.工程服务#2.安装服务#3.修缮服务#4.装饰服务#5.其他建筑服务#五、金融服务#1.贷款服务#2.直接收费金融服务#3.保险服务#4.金融商品转让#六、现代服务#1.研发和技术服务#2.信息技术服务#3.文化创意服务#4.物流辅助服务#5.租赁服务#6.鉴证咨询服务#7.广播影视服务#8.商务辅助服务#9.其他现代服务#七、生活服务#1.文化体育服务#2.教育医疗服务#3.旅游娱乐服务#4.餐饮住宿服务#5.居民日常服务#6.其他生活服务#八、销售无形资产#1.专利或非专利技术#2.商标和著作权#3.土地使用权#4.其他自然资源使用权#5.其他权益性无形资产#九、销售不动产#1.建筑物#其中：二手房交易#2.构筑物#其中:二手房交易";
		
		
		
		sjNum[35] = 3;
		colsL[35] = "HJ#YDYCY#EDECY#YCKY#1MTKCHXXY#2SYHTRQKCY#3HSJSKCXY#4YSJSKCXY#5FJSKCXY#6QTCKY#EZZY#1NFSPJGY#2SPZZY#3JYLHJZCZZY#4YCZPY#5FZY#6FZFZFSY#7PGMPYMJQZPHZXY#8MCJGHMZTZCZPY#9JJZZY#10ZZHZZPY#11YSHJLMJFZY#12WJGMTYHYLYPZZY#13SYMTJQTRLJGY#14HXYLHHXZPZZY#15YYZZY#16HXXWZZY#17XJHSLZPY#18FJSKWZPY#19HSJSYLHYYJGY#20YSJSYLHYYJGY#21JSZPY#22TYSBZZY#23ZYSBZZY#24QCZZY#25TLCBHKHTHQTYSSBZZY#26DQJXHQCZZY#27JSJTXHQTDZSBZZY#28YBYQZZY#29QTZZY#SDLRLRQJSDSCHGYY#1DLRLSCHGYY#2RQSCHGYY#3SDSCHGYY#SJZY#1FWJZY#2TMGCJZY#3JZAZY#4JZZSZXHQTJZY#SDSCY#YPFHLSY#1PFY#2LSY#EJTYSCCHYZY#1TLYSY#2DLYSY#3SSYSY#4HKYSY#5GDYSY#6DSLYHYSDLY#7ZXBYHCCY#8YZY#SZSHCYY#1ZSY#2CYY#SXXCSRJHXXJSFWY#1DXGBDSHWXCSFWY#2HLWHXGFW#3RJHXXJSFWY#WJRY#1HBJRFW#2ZBSCFW#3BXY#4QTJRY#LFDCY#1FDCKFJYY#2WYGL#3FDCZJFW#4FDCZLJY#5QTFDCY#QZLHSWFWY#1ZLY#2SWFWY#QZZXYDC#GGY#BKXYJHJSFWY#1YJHSYFZ#2ZYJSFWY#3KJTGHYYFWY#JSLHJHGGSSGLY#QZGGSSGLY#SJMFWXLHQTFWY#1JMFWY#2JDCDZCPHRYCPXLY#3QTFWY#SYJY#SEWSHSHGZ#1WS#2SHGZ#SSWHTYHYLY#1XWHCBY#2GBDSDYHYSLYZZY#3WHYSY#4TY#5YLY#SSGGGLSHBZHSHZZ#SWQTXY";
		colsH[35] = "XH#XM#HJ#QZMDDK#NZQYXJ#NZQYGYQY#NZQYJTQY#NZQYGFHZQY#NZQYLYQY#NZQYQZGYKG1#NZQYGFGS#NZQYQZGYKG2#NZQYSYQY#NZQYQTQY#GATTZQY#QZGYKG1#WSTZQY#QZGYKG2#GTJY";
		colsLName[35] = "合计#一、第一产业#二、第二产业#(一)采矿业#1.煤炭开采和洗选业#2.石油和天然气开采业#3.黑色金属矿采选业#4.有色金属矿采选业#5.非金属矿采选业#6.其他采矿业#(二)制造业#1.农副食品加工业#2.食品制造业#3.酒、饮料和精制茶制造业#4.烟草制品业#5.纺织业#6.纺织服装、服饰业#7.皮革、毛皮、羽毛及其制品和制鞋业#8.木材加工和木竹藤棕草制品业#9.家具制造业#10.造纸和纸制品业#11.印刷和记录媒介复制业#12.文教、工美、体育和娱乐用品制造业#13.石油、煤炭及其他燃料加工业#14.化学原料和化学制品制造业#15.医药制造业#16.化学纤维制造业#17.橡胶和塑料制品业#18.非金属矿物制品业#19.黑色金属冶炼和压延加工业#20.有色金属冶炼和压延加工业#21.金属制品业#22.通用设备制造业#23.专用设备制造业#24.汽车制造业#25.铁路、船舶、航空航天和其他运输设备制造业#26.电气机械和器材制造业#27.计算机、通信和其他电子设备制造业#28.仪表仪器制造业#29.其他制造业#(三)电力、热力、燃气及水的生产和供应业#1.电力、热力生产和供应业#2.燃气生产和供应业#3.水的生产和供应业#(四)建筑业#1.房屋建筑业#2.土木工程建筑业#3.建筑安装业#4.建筑装饰、装修和其他建筑业#三、第三产业#(一)批发和零售业#1.批发业#2.零售业#(二)交通运输、仓储和邮政业#1.铁路运输业#2.道路运输业#3.水上运输业#4.航空运输业#5.管道运输业#6.多式联运和运输代理业#7.装卸搬运和仓储业#8.邮政业#(三)住宿和餐饮业#1.住宿业#2.餐饮业#（四）信息传输、软件和信息技术服务业#1.电信、广播电视和卫星传输服务业#2.互联网和相关服务#3.软件和信息技术服务业#(五)金融业#1.货币金融服务#2.资本市场服务#3.保险业#4.其他金融业#(六)房地产业#1.房地产开发经营业#2.物业管理#3.房地产中介服务#4.房地产租赁经营#5.其他房地产业#(七)租赁和商务服务业#1.租赁业#2.商务服务业#其中：咨询与调查#广告业#(八）科学研究和技术服务业#1.研究和实验发展#2.专业技术服务业#3.科技推广和应用服务业#（九）水利、环境和公共设施管理业#其中：公共设施管理业#（十）居民服务、修理和其他服务业#1.居民服务业#2.机动车、电子产品和日用产品修理业#3.其他服务业#(十一)教育#（十二）卫生和社会工作#1.卫生#2.社会工作#(十三)文化、体育和娱乐业#1.新闻和出版业#2.广播、电视、电影和影视录音制作业#3.文化艺术业#4.体育#5.娱乐业#(十四)公共管理、社会保障和社会组织#(十五)其他行业";
		colsHName[35] = "序号#项目#合计#其中：免抵调库#内资企业小计#内资企业国有企业#内资企业集体企业#内资企业股份合作企业#内资企业联营企业#内资企业其中：国有控股#内资企业股份公司#内资企业其中：国有控股#内资企业私营企业#内资企业其它企业#港澳台投资企业#其中：国有控股#外商投资企业#其中：国有控股#个体经营";
		
		
		sjNum[36] = 3;
		colsL[36] = "HJ#YJTYSFW#1LLYSFW#1TLYSFW#2QTLLYSFW#2SLYSFW#3HKYSFW#4GDYSFW#EYZFW#1YZPBFW#2YZTSFW#3QTYZFW#SDXFW#1JCDXFW#2ZZDXFW#SJZFW#1GCFW#2AZFW#3XSFW#4ZSFW#5QTJZFW#WJRFW#1DKFW#2ZJSFJRFW#3BXFW#1RSBXFW#2CCBXFW#4JRSPZR#LXDFW#1YFHJSFW#1YFFW#2HTNYGLFW#3GCKCKTFW#4ZYJSFW#2XXJSFW#1RJFW#2DLSJJCSFW#3XXXTFW#4YWLCGLFW#5XXXTZZFW#3WHCYFW#1SJFW#2ZSCQFW#3GGFW#4HYZLFW#4WLFZFW#1HKFW#2GKMTFW#3HYKYCZFW#4DLJZFW#5ZXBYFW#6CCFW#7SPFW#5ZLFW#1BDCRZZL#2BDCJYZL#3YXDCRZZL#4YXDCJYZL#6JZZXFW#1RZFW#2JZFW#3ZXFW#7GBYSFW#1GBYSJMZPZZFW#2GBYSJMZPFXFW#3GBYSJMZPBYFW#8SWFZFW#1QYGLFW#2JJDLFW#3RLZYFW#4AQBHFW#9QTXDFW#QSHFW#1WHTYFW#1WHFW#2TYFW#2JYYLFW#1JYFW#2YLFW1#3LYYLFW#1LYFW#2YLFW2#4CYZSFW#1CYFW#2ZSFW#5JMRCFW#6QTSHFW#BXSWXZC#1ZLHFZLJS#2SBHZZQ#3TDSYQ#4QTZRZYSYQ#5QTQYXWXZC#JXSBDC#1JZW#QZESFJY1#2GZW#QZESFJY2";
		colsH[36] = "XH#XM#HJ#QZMDDK#NZQYXJ#NZQYGYQY#NZQYJTQY#NZQYGFHZQY#NZQYLYQY#NZQYQZGYKG1#NZQYGFGS#NZQYQZGYKG2#NZQYSYQY#NZQYQTQY#GATTZQY#QZGYKG1#WSTZQY#QZGYKG2#GTJY";
		colsLName[36] = "合计#一、交通运输服务#1.陆路运输服务#(1)铁路运输服务#(2)其他陆路运输服务#2.水路运输服务#3.航空运输服务#4.管道运输服务#二、邮政服务#1.邮政普遍服务#2.邮政特殊服务#3.其他邮政服务#三、电信服务#1.基础电信服务#2.增值电信服务#四、建筑服务#1.工程服务#2.安装服务#3.修缮服务#4.装饰服务#5.其他建筑服务#五、金融服务#1.贷款服务#2.直接收费金融服务#3.保险服务#(1)人身保险服务#(2)财产保险服务#4.金融商品转让#六、现代服务#1.研发和技术服务#(1)研发服务#(2)合同能源管理服务#(3)工程勘察勘探服务#(4)专业技术服务#2.信息技术服务#(1)软件服务#(2)电路设计及测试服务#(3)信息系统服务#(4)业务流程管理服务#(5)信息系统增值服务#3.文化创意服务#(1)设计服务#(2)知识产权服务#(3)广告服务#(4)会议展览服务#4.物流辅助服务#(1)航空服务#(2)港口码头服务#(3)货运客运场站服务#(4)打捞救助服务#(5)装卸搬运服务#(6)仓储服务#(7)收派服务#5.租赁服务#(1)不动产融资租赁#(2)不动产经营租赁#(3)有形动产融资租赁#(4)有形动产经营租赁#6.鉴证咨询服务#(1)认证服务#(2)鉴证服务#(3)咨询服务#7.广播影视服务#(1)广播影视节目（作品）制作服务#(2)广播影视节目（作品）发行服务#(3)广播影视节目（作品）播映服务#8.商务辅助服务#(1)企业管理服务#(2)经纪代理服务#(3)人力资源服务#(4)安全保护服务#9.其他现代服务#七、生活服务#1.文化体育服务#(1)文化服务#(2)体育服务#2.教育医疗服务#(1)教育服务#(2)医疗服务#3.旅游娱乐服务#(1)旅游服务#(2)娱乐服务#4.餐饮住宿服务#(1)餐饮服务#(2)住宿服务#5.居民日常服务#6.其他生活服务#八、销售无形资产#1.专利或非专利技术#2.商标和著作权#3.土地使用权#4.其他自然资源使用权#5.其他权益性无形资产#九、销售不动产#1.建筑物#其中：二手房交易#2.构筑物#其中：二手房交易";
		colsHName[36] = "序号#项目#合计#其中：免抵调库#内资企业小计#内资企业国有企业#内资企业集体企业#内资企业股份合作企业#内资企业联营企业#内资企业其中：国有控股#内资企业股份公司#内资企业其中：国有控股#内资企业私营企业#内资企业其它企业#港澳台投资企业#其中：国有控股#外商投资企业#其中：国有控股#个体经营";
		
		
		sjNum[37] = 4;
		colsL[37] = "SSSRHJ#1ZZSSR#QZYBNSR#XGMNSR#2XFSSR#3YYS#4QYSDS#5GRSDS#6ZYS#7CSWHJSS#8FCS#9YHS#10CZTDSYS#11TDZZS#12CCS#13CLGZS#14YYS#15GDZYS#16QS#17HJBHS#18QTSS";
		colsH[37] = "XH#SZ1#SZ2#HJHS#HJSSSR#DXQYHS#DXQYSSSR#ZXQYHS#ZXQYSSSR#XWQYXJHS#XWQYXJSSSR#XWQYXXQYHS#XWQYXXQYSSSR#XWQYWXQYHS#XWQYWXQYSSSR";
		colsLName[37] = "税收收入合计#1.增值税收入#其中：一般纳税人#小规模纳税人#2.消费税收入#3.营业税#4.企业所得税#5.个人所得税#6.资源税#7.城市维护建设税#8.房产税#9.印花税#10.城镇土地使用税#11.土地增值税#12.车船税#13.车辆购置税#14.烟叶税#15.耕地占用税#16.契税#17.环境保护税#18.其他税收";
		colsHName[37] = "序号#税种#税种#合计户数#合计税收收入#大型企业户数#大型企业税收收入#中型企业户数#中型企业税收收入#小微企业小计户数#小微企业小计税收收入#小微企业小型企业户数#小微企业小型企业税收收入#小微企业微型企业户数#小微企业微型企业税收收入";
		
		sjNum[38] = 4;
		colsL[38] = "HJ#YDYCY#EDECY#YCKY#EZZY#1NFSPJGY#2SPZZY#3JYLHJZCZZY#4YCZPY#5FZY#6FZFZFSY#7PGMPYMJQZPHZXY#8MCJGHMZTZCZPY#9JJZZY#10ZZHZZPY#11YSHJLMJFZY#12WJGMTYHYLYPZZY#13SYMTJQTRLJGY#14HXYLHHXZPZZY#15YYZZY#16HXXWZZY#17XJHSLZPY#18FJSKWZPY#19HSJSYLHYYJGY#20YSJSYLHYYJGY#21JSZPY#22TYSBZZY#23ZYSBZZY#24QCZZY#25TLCBHKHTHQTYSSBZZY#26DQJXHQCZZY#27JSJTXHQTDZSBZZY#28YBYQZZY#29QTZZY#SDLRLRQJSDSCHGYY#1DLRLSCHGYY#2RQSCHGYY#3SDSCHGYY#SJZY#1FWJZY#2TMGCJZY#3JZAZY#4JZZSZXHQTJZY#SDSCY#YPFHLSY#1PFY#2LSY#EJTYSCCHYZY#1TLYSY#2DLYSY#3SSYSY#4HKYSY#5GDYSY#6DSLYHYSDLY#7ZXBYHCCY#8YZY#SZSHCYY#1ZSY#2CYY#SXXCSRJHXXJSFWY#1DXGBDSHWXCSFWY#2HLWHXGFW#3RJHXXJSFWY#WJRY#1HBJRFW#2ZBSCFW#3BXY#4QTJRY#LFDCY#1FDCKFJY#2WYGL#3QTFDCY#QZLHSWFWY#1ZLY#2SWFWY#BKXYJHJSFWY#JJMFWXLHQTFWY#SJY#SYWSHSHGZ#SEWHTYHYLY#SSGGGLSHBZHSHZZ#SSQTXY";
		colsH[38] = "XH#XM1#XM2#HJHS#HJSSSR#DXQYHS#DXQYSSSR#ZXQYHS#ZXQYSSSR#XWQYXJHS#XWQYXJSSSR#XWQYXXQYHS#XWQYXXQYSSSR#XWQYWXQYHS#XWQYWXQYSSSR";
		colsLName[38] = "合计#一、第一产业#二、第二产业#(一)采矿业#(二)制造业#1.农副食品加工业#2.食品制造业#3.酒、饮料和精制茶制造业#4.烟草制品业#5.纺织业#6.纺织服装、服饰业#7.皮革、毛皮、羽毛及其制品和制鞋业#8.木材加工和木竹藤棕草制品业#9.家具制造业#10.造纸和纸制品业#11.印刷和记录媒介复制业#12.文教、工美、体育和娱乐用品制造业#13.石油、煤炭及其他燃料加工业#14.化学原料和化学制品制造业#15.医药制造业#16.化学纤维制造业#17.橡胶和塑料制品业#18.非金属矿物制品业#19.黑色金属冶炼和压延加工业#20.有色金属冶炼和压延加工业#21.金属制品业#22.通用设备制造业#23.专用设备制造业#24.汽车制造业#25.铁路、船舶、航空航天和其他运输设备制造业#26.电气机械和器材制造业#27.计算机、通信和其他电子设备制造业#28.仪表仪器制造业#29.其他制造业#(三)电力、热力、燃气及水的生产和供应业#1.电力、热力生产和供应业#2.燃气生产和供应业#3.水的生产和供应业#(四)建筑业#1.房屋建筑业#2.土木工程建筑业#3.建筑安装业#4.建筑装饰、装修和其他建筑业#三、第三产业#(一)批发和零售业#1.批发业#2.零售业#(二)交通运输、仓储和邮政业#1.铁路运输业#2.道路运输业#3.水上运输业#4.航空运输业#5.管道运输业#6.多式联运和运输代理业#7.装卸搬运和仓储业#8.邮政业#(三)住宿和餐饮业#1.住宿业#2.餐饮业#（四）信息传输、软件和信息技术服务业#1.电信、广播电视和卫星传输服务业#2.互联网和相关服务#3.软件和信息技术服务业#(五)金融业#1.货币金融服务#2.资本市场服务#3.保险业#4.其他金融业#(六)房地产业#1.房地产开发经营#2.物业管理#3.其他房地产业#(七)租赁和商务服务业#1.租赁业#2.商务服务业#(八）科学研究和技术服务业#（九）居民服务、修理和其他服务业#(十)教育#（十一）卫生和社会工作#(十二)文化、体育和娱乐业#(十三)公共管理、社会保障和社会组织#(十四)其他行业";
		colsHName[38] = "序号#项目#项目#合计户数#合计税收收入#大型企业户数#大型企业税收收入#中型企业户数#中型企业税收收入#小微企业小计户数#小微企业小计税收收入#小微企业小型企业户数#小微企业小型企业税收收入#小微企业微型企业户数#小微企业微型企业税收收入";
		

		sjNum[39] = 4;
		colsL[39] = "HJ#YNZQYXJ#YNZQY1GYQY#YNZQY2JTQY#YNZQY3GFHZQY#YNZQY4LYQY#YNZQYQZGYKG1#YNZQY5GFGS#YNZQYQZGYKG2#YNZQY6SYQY#YNZQY7QTQY#EGATTZQY#QZGYKG1#SWSTZQY#QZGYKG2#SGTJY";
		colsH[39] = "XH#QYLX1#QYLX2#HJHS#HJSSSR#DXQYHS#DXQYSSSR#ZXQYHS#ZXQYSSSR#XWQYXJHS#XWQYXJSSSR#XWQYXXQYHS#XWQYXXQYSSSR#XWQYWXQYHS#XWQYWXQYSSSR";
		colsLName[39] = "合计#一、内资企业小计#一、内资企业1.国有企业#一、内资企业2.集体企业#一、内资企业3.股份合作企业#一、内资企业4.联营企业#一、内资企业其中：国有控股#一、内资企业5.股份公司#一、内资企业其中：国有控股#一、内资企业6.私营企业#一、内资企业7.其他企业#二、港澳台投资企业#其中：国有控股#三、外商投资企业#其中：国有控股#四、个体经营";
		colsHName[39] = "序号#企业类型#企业类型#合计户数#合计税收收入#大型企业户数#大型企业税收收入#中型企业户数#中型企业税收收入#小微企业小计户数#小微企业小计税收收入#小微企业小型企业户数#小微企业小型企业税收收入#小微企业微型企业户数#小微企业微型企业税收收入";
		
		
		sjNum[40] = 3;
		colsL[40] = "YXSEHJ#1ASYSLZSHWJLWXSE#2AJYZSBFZSHWXSE#3MDTBFCKHWXSE#4MSHWJLWXSE#EYNSEHJ#1XXSE#2JXSE#SQLDSE#JXSEZC#MDTHWYTSE#ASYSLJSDNSJCYBJSE#3YDKSE#4SJDKSE#5QMLDSE#6JYZSBFJSDYNSE#7YNSEJZE";
		colsH[40] = "XH#XM#HJ#GY#JYDZZ#JDZZ#FZY#YYJGJSYZPZZ#HXYLJHXZPZZY#FJSKWZPY#HSJSYLHYYJGY#QCZZY#MTKCHXXY#SYHTRQKCY#DLRLSCHGYY#PFY#LSY";
		colsLName[40] = "一.销售额合计#1.按适用税率征税货物及劳务销售额#2.按简易征收办法征税货物销售额#3.免.抵.退办法出口货物销售额#4.免税货物及劳务销售额#二.应纳税额合计#1.销项税额#2.进项税额#上期留抵税额#进项税额转出#免抵退货物应退税额#按适用税率计算的纳税检查应补缴税额#3.应抵扣税额#4.实际抵扣税额#5.期末留抵税额#6.简易征收办法计算的应纳税额#7.应纳税额减征额";
		colsHName[40] = "序号#项目#合计#工业#卷烟的制造#酒的制造#纺织业#原油加工及石油制品制造#化学原料及化学制品制造业#非金属矿物制品业#黑色金属冶炼和压延加工业#汽车制造业#煤炭开采和洗选业#石油和天然气开采业#电力、热力生产和供应业#批发业#零售业";
		
		
		sjNum[41] = 2;
		colsL[41] = "YXSEHJ#1ASYSLZSHWJLWXSE#2AJYZSBFZSHWXSE#3MDTBFCKHWXSE#4MSHWJLWXSE#EYNSEHJ#1XXSE#2JXSE#SQLDSE#JXSEZC#MDTHWYTSE#ASYSLJSDNSJCYBJSE#3YDKSE#4SJDKSE#5QMLDSE#6JYZSBFJSDYNSE#7YNSEJZE#F1XGMNSRXSE#F2XGMNSRYNSE";
		colsH[41] = "XH#XM#HJ#YJTYSFW#1LLYSFW#2SLYSFW#3HKYSFW#4GDYSFW#EYZFW#SDXFW#SJZFW#QZGCFW#WJRFW#1DKFW#2ZJSFJRFW#3BXFW#4JRSPZR#LXDFW#1YFHJSFW#2XXJSFW#3WHCYFW#4WLFZFW#5ZLFW#6JZZXFW#7GBYSFW#8SWFZFW#9QTXDFW#QSHFW#BXSWXZC#JXSBDC#QZESFJY";
		colsLName[41] = "一.销售额合计#1.按适用税率征税货物及劳务销售额#2.按简易征收办法征税货物销售额#3.免.抵.退办法出口货物销售额#4.免税货物及劳务销售额#二.应纳税额合计#1.销项税额#2.进项税额#上期留抵税额#进项税额转出#免抵退货物应退税额#按适用税率计算的纳税检查应补缴税额#3.应抵扣税额#4.实际抵扣税额#5.期末留抵税额#6.简易征收办法计算的应纳税额#7.应纳税额减征额#附1：小规模纳税人销售额#附2：小规模纳税人应纳税额";
		colsHName[41] = "序号#项目#合计#一、交通运输服务#1、陆路运输服务#2、水路运输服务#3、航空运输服务#4、管道运输服务#二、邮政服务#三、电信服务#四、建筑服务#其中：工程服务#五、金融服务#1.贷款服务#2.直接收费金融服务#3.保险服务#4.金融商品转让#六、现代服务#1.研发和技术服务#2.信息技术服务#3.文化创意服务#4.物流辅助服务#5.租赁服务#6.鉴证咨询服务#7.广播影视服务#8.商务辅助服务#9.其他现代服务#七、生活服务#八、销售无形资产#九、销售不动产#其中：二手房交易";
		
		
		//无
		sjNum[42] = 0;
		colsL[42] = "";
		colsH[42] = "";
		colsLName[42] = "";
		colsHName[42] = "";

		
		
		sjNum[43] = 2;
		colsL[43] = "CZZSASJLREYJYYSR#CZZSASJLREYJYYCB#CZZSASJLREYJLRZE#CZZSASJLREYJTDYWJSDYNSSDE#CZZSASJLREYJBZSSRHSJJMYNSSDE#CZZSASJLREYJGDZCJSZJKCDJE#CZZSASJLREYJMBYQNDKS#CZZSASJLREYJSJLRE#CZZSASJLREYJYNSDSE#CZZSASJLREYJJMSDSE#CZZSASJLREYJQZFHTJDXXWLQYJMSDSE#CZZSASJLREYJSJYNSDSE#CZZSASYNDYJSYNDYNSSDE#CZZSASYNDYJJZBYJYNSDSE#CZZSAQTFFYJJZBYJQDYJDSDSE#HDZSASRZEHDSRZE#HDZSASRZEHDBZSSR#HDZSASRZEHDMSSR#HDZSASRZEHDYSSRE#HDZSASRZEHDYNSSDE#HDZSASRZEHDYNSDSE#HDZSACBFYHDCBFYZE#HDZSACBFYHDYNSSDE#HDZSACBFYHDYNSDSE#HDZSHDYNSEYNSDSE#ZFJGJNQYSDSQKZJGYFTQYSDSE#ZFJGJNQYSDSQKCZJZFPSDSE#ZFJGJNQYSDSQKFZJGYFTQYSDSE#ZFJGJNQYSDSQKQZZJGDLSCJYBMYFTSDSE#ZFJGJNQYSDSQKZJGYCXFZJGYFTSDSE";
		colsH[43] = "XH#XM1#XM2#XM3#HJ#YDYCY#EDECY#YCKY#EZZY#SDLRLRQJSDSCHGYY#SJZY#SDSCY#YPFHLSY#EJTYSCCHYZY#SZSHCYY#SXXCSRJHXXJSFWY#WJRY#LFDCY#QZLHSWFWY#BKXYJHJSFWY#JJMFWXLHQTFWY#SJY#SYWSHSHGZ#SEWHTYHYLY#SSGGGLSHBZHSHZZ#SSQTXY";
		colsLName[43] = "查账征收按实际利润额预缴营业收入#查账征收按实际利润额预缴营业成本#查账征收按实际利润额预缴利润总额#查账征收按实际利润额预缴特定业务计算的应纳税所得额#查账征收按实际利润额预缴不征税收入和税基减免应纳税所得额#查账征收按实际利润额预缴固定资产加速折旧（扣除）调减额#查账征收按实际利润额预缴弥补以前年度亏损#查账征收按实际利润额预缴实际利润额#查账征收按实际利润额预缴应纳所得税额#查账征收按实际利润额预缴减免所得税额#查账征收按实际利润额预缴其中：符合条件的小型微利企业减免所得税额#查账征收按实际利润额预缴实际应纳所得税额#查账征收按上一年度预缴上一年度应纳税所得额#查账征收按上一年度预缴截至本月（季）应纳所得税额#查账征收按其他方法预缴截至本月（季）确定预缴的所得税额#核定征收按收入总额核定收入总额#核定征收按收入总额核定不征税收入#核定征收按收入总额核定免税收入#核定征收按收入总额核定应税收入额#核定征收按收入总额核定应纳税所得额#核定征收按收入总额核定应纳所得税额#核定征收按成本费用核定成本费用总额#核定征收按成本费用核定应纳税所得额#核定征收按成本费用核定应纳所得税额#核定征收核定应纳税额应纳所得税额#总分机构缴纳企业所得税情况总机构应分摊企业所得税额#总分机构缴纳企业所得税情况财政集中分配所得税额#总分机构缴纳企业所得税情况分支机构应分摊企业所得税额#总分机构缴纳企业所得税情况其中：总机构独立生产经营部门应分摊所得税额#总分机构缴纳企业所得税情况总机构已撤销分支机构应分摊所得税额";
		colsHName[43] = "序号#项目#项目#项目#合计#一、第一产业#二、第二产业#(一)采矿业#(二)制造业#(三)电力、热力、燃气及水的生产和供应业#(四)建筑业#三、第三产业#(一)批发和零售业#(二)交通运输、仓储和邮政业#(三)住宿和餐饮业#（四）信息传输、软件和信息技术服务业#(五)金融业#(六)房地产业#(七)租赁和商务服务业#(八）科学研究和技术服务业#（九）居民服务、修理和其他服务业#(十)教育#（十一）卫生和社会工作#(十二)文化、体育和娱乐业#(十三)公共管理、社会保障和社会组织#(十四)其他行业";
		
		
		
		//44-57都没有
		sjNum[44] = 0;
		colsL[44] = "";
		colsH[44] = "";
		colsLName[44] = "";
		colsHName[44] = "";
		

		sjNum[57] = 0;
		colsL[57] = "";
		colsH[57] = "";
		colsLName[57] = "";
		colsHName[57] = "";
		
		
		sjNum[58] = 2;
		colsL[58] = "HJ#YGZXJSD#EGTGSHDSCJYSD#SQSYDWDCBJYCZJYSD#SLWBCSD#WGCSD#LTXQSYFSD#QLXGXHLSD#BCCZLSD#JCCZRSD#QZXSGZRSD#FWZRSD#SORSD#SYQTSD";
		colsH[58] = "XH#XM#NSDE#NYNSSDE#NYNSE#YJKSE#DKSE#YBTSE#NSJRKSE";
		colsLName[58] = "合计#一、工资、薪金所得#二、个体工商户的生产、经营所得#三、企事业单位的承包经营、承租经营所得#四、劳务报酬所得#五、稿酬所得#六、特许权使用费所得#七、利息、股息、红利所得#八、财产租赁所得#九、财产转让所得#其中：限售股转让所得#房屋转让所得#十、偶然所得#十一、其他所得";
		colsHName[58] = "序号#项目#年所得额#年应纳税所得额#年应纳税额#已缴（扣）税额#抵扣税额#应补（退）税额#年实际入库税额";

		
		//无
		sjNum[59] = 0;
		colsL[59] = "";
		colsH[59] = "";
		colsLName[59] = "";
		colsHName[59] = "";


		sjNum[60] = 2;
		colsL[60] = "HJ#YNYK#1MTD#2YYD#3TRQQLFM#4MCCQQLFM#5DRD/LFM#6QTNYK#EJSK#1TKD#2JKQK#3TKD#4LTKD#5QXKD#6NKD#7XKD#8ZZXTKD#9QXTKD#10WKD#11ZKD#12MKD#13YKD#14QTJSK#SFJSK#1SMD#2GZTD#3GLTD#4YSD#5SHSD#6LTKD#7LKD#8LHJD#9LSJD#10ZTLFM#11SSLFM#12JKYD#13HYD#14HYD#15DXLSSZDYD#16KQSD/LFM#17DLYD#18HGYD#19NHZTD#20MXD#21QTFJSK#SSZY#1DBSLFM#2DXSLFM#3ZLSLFM#WQT#LSKZNJFKSR";
		colsH[60] = "XH#XM#JLDW#XSL#XSE#BQYNSE1#BQJMSE#BQYNSE2#BQYBTSE";
		colsLName[60] = "合计#一、能源矿#1.煤炭#2.原油#3.天然气#4.煤层（成）气#5.地热#6.其他能源矿#二、金属矿#1.铁矿#2.金矿#3.铜矿#4.铝土矿#5.铅锌矿#6.镍矿#7.锡矿#8.中重稀土矿#9.轻稀土矿#10.钨矿#11.钼矿#12.锰矿#13.银矿#14.其他金属矿#三、非金属矿#1.石墨#2.硅藻土#3.高岭土#4.萤石#5.石灰石#6.硫铁矿#7.磷矿#8.氯化钾#9.硫酸钾#10.粘土#11.砂石#12.井矿盐#13.湖盐#14.海盐#15.地下卤水晒制的盐#16.矿泉水#17.大理岩#18.花岗岩#19.耐火粘土#20.芒硝#21.其他非金属矿#四、水资源#1.地表水#2.地下水#3.自来水#五、其他#六、税款滞纳金、罚款收入";
		colsHName[60] = "序号#项目#计量单位#销售量#销售额#本期应纳税额#本期减免税额#本期已纳税额#本期应补（退）税额";


		sjNum[61] = 3;
		colsL[61] = "HJ#YA1SLZS#EA5SLZS#SA7SLZS#QT";
		colsH[61] = "XH#XM#JSYJHJ#JSYJZZS#JSYJQZYBZZS#JSYJQZMDZZS#JSYJXFS#JSYJYYS#BQYNSE#BQJMSE#BQYJSE#BQYBTSE";
		colsLName[61] = "合计#一、按1%税率征收#二、按5%税率征收#三、按7%税率征收#其他";
		colsHName[61] = "序号#项目#计税依据合计#计税依据增值税#计税依据其中：一般增值税#计税依据其中：免抵增值税#计税依据消费税#计税依据营业税#本期应纳税额#本期减免税额#本期已缴税额#本期应补（退）税额";


		sjNum[62] = 3;
		colsL[62] = "HJ#YCJJZ#1DWNSR1#2GRNSR1#ECZJZ#1DWNSR2#2GRNSR2#QZGRCZZF";
		colsH[62] = "XH#XM#FCYZ#QZCZFCYZ#QZJMSFCYZ#FCYZ/BQYZSJSR#BQYNSE#BQJMSE#BQYJSE#BQYBTSE";
		colsLName[62] = "合计#一、从价计征#1.单位纳税人#2.个人纳税人#二、从租计征#1.单位纳税人#2.个人纳税人#其中：个人出租住房";
		colsHName[62] = "序号#项目#房产原值#其中：出租房产原值#其中：减免税房产原值#房产原值本期应租税金收入#本期应纳税额#本期减免税额#本期已缴税额#本期应补（退）税额";


		sjNum[63] = 2;
		colsL[63] = "HJ#YGXHT#EJGCLHT#SJSGCKCSJHT#SJZAZGCCBHT#WCCZLHT#LHWYSHT#QCCBGHT#BJKHT#JCCBXHT#SJSHT#SYCQZYSJ#SEYYZBJZZJ#SSYYZBQT#SSQLXKZZ";
		colsH[63] = "XH#XM#JSJEHJS#HDZSDHDYJ#BQYNSE#BQYJSE#BQJMSE#BQYBTSE";
		colsLName[63] = "合计#一、购销合同#二、加工承揽合同#三、建设工程勘察设计合同#四、建筑安装工程承包合同#五、财产租赁合同#六、货物运输合同#七、仓储保管合同#八、借款合同#九、财产保险合同#十、技术合同#十一、产权转移书据#十二、营业帐簿（记载资金）#十三、营业帐簿（其他）#十四、权利、许可证照";
		colsHName[63] = "序号#项目#计税金额或件数#核定征收的核定依据#本期应纳税额#本期已缴税额#本期减免税额#本期应补（退）税额";


		sjNum[64] = 2;
		colsL[64] = "YFSETJ#103Y#236Y#3612Y#41218Y#51824Y#62430Y#730YYS#EFYTTJ#1GY#2SY#3JZ#4ZH#5FDCKFQYKFYD#6QT";
		colsH[64] = "XH#XM#TDZMJWPFM#QZJMSZMJWPFM#BQYNSE#BQJMSE#BQYJSE#BQYBTSE";
		colsLName[64] = "一、分税额统计#1、0-3元#2、3-6元#3、6-12元#4、12-18元#5、18-24元#6、24-30元#7、30元以上#二、分用途统计#1.工业#2、商业#3、居住#4、综合#5、房地产开发企业开发用地#6、其它";
		colsHName[64] = "序号#项目#土地总面积（万平方米）#其中：减免税总面积（万平方米）#本期应纳税额#本期减免税额#本期已缴税额#本期应补（退）税额";


		sjNum[65] = 3;
		colsL[65] = "HJ#YPTZZ#PTZZ11YX#PTZZ212#PTZZ323#PTZZ43YS#EFPTZZ#FPTZZ12YX#FPTZZ224#FPTZZ346#FPTZZ46YS#SQTLXFDC#QTLXFDC12YX#QTLXFDC224#QTLXFDC346#QTLXFDC46YS";
		colsH[65] = "XH#XM#YSSRHJ#YSSRHBSR#YSSRSWSRJQTSR#YSSRSTXSSR#YNSE#SKJNBQYJSK1#SKJNBQYJSK2";
		colsLName[65] = "合计#一、普通住宅#1.1%及以下#2.1%-2%（含2%）#3.2%-3%（含3%）#4.3%以上#二、非普通住宅#1.2%及以下#2.2%-4%（含4%）#3.4%-6%（含6%）#4.6%以上#三、其他类型房地产#1.2%及以下#2.2%-4%（含4%）#3.4%-6%（含6%）#4.6%以上";
		colsHName[65] = "序号#项目#应税收入合计#应税收入货币收入#应税收入实物收入及其他收入#应税收入视同销售收入#应纳税额#税款缴纳本期已缴税款#税款缴纳本期应缴税款";


		sjNum[66] = 2;
		colsL[66] = "YZRFDCSRZE#EKCXMJE#1QDTDSYQSZFDJE#2FDCKFCB#TDZYJCQBCF#QQGCF#JZAZGCF#JCSSF#GGPTSSF#KFJJFY#3FDCKFFY#LXZC#QTFDCKFFY#4YZRFDCYGDSJD#YYS#CSWHJSS#JYFFJ#5CZBGDDQTKCXM#SZZE#SYJTDZZSSE#WJMSE#LYJTDZZSSE#QYBTTDZZSSE";
		colsH[66] = "XH#XM#HJ#PTZZ#FPTZZ#QTLXFDC";
		colsLName[66] = "一、转让房地产收入总额#二、扣除项目金额#1.取得土地使用权所支付的金额#2.房地产开发成本#土地征用及拆迁补偿费#前期工程费#建筑安装工程费#基础设施费#公共配套设施费#开发间接费用#3.房地产开发费用#利息支出#其他房地产开发费用#4.与转让房地产有关的税金等#营业税#城市维护建设税#教育费附加#5.财政部规定的其他扣除项目#三、增值额#四、应缴土地增值税税额#五、减免税额#六、已缴土地增值税税额#七、应补（退）土地增值税税额";
		colsHName[66] = "序号#项目#合计#普通住宅#非普通住宅#其他类型房地产";


		sjNum[67] = 3;
		colsL[67] = "YZRFDCSRZE#EKCXMJE#1FDCCBAPGJGJSQDTDSYQSZFDJE#2FDCCBAPGJGJSJFJJZWDPGJG#3FDCCBAPGJGJSPGFY#4FDCCBAGFFPJSGFFPJE#5FDCCBAGFFPJSFPJJKCJE#6FDCCBAGFFPJSGFQS#2YZRFDCYGDSJYYS#3YZRFDCYGDSJCSWHJSS#4YZRFDCYGDSJYHS#5YZRFDCYGDSJJYFFJ#SZZE#SYJTDZZSSE#WJMSE#LYJTDZZSSE#QYBTTDZZSSE";
		colsH[67] = "XH#XM1#XM2#XM3#HJ#GRZZ#GRQTLXFDC#FGR";
		colsLName[67] = "一、转让房地产收入总额#二、扣除项目金额#1、房地产成本按评估价格计算取得土地使用权所支付的金额#2、房地产成本按评估价格计算旧房及建筑物的评估价格#3、房地产成本按评估价格计算评估费用#4、房地产成本按购房发票计算购房发票金额#5、房地产成本按购房发票计算发票加计扣除金额#6、房地产成本按购房发票计算购房契税#2、与转让房地产有关的税金营业税#3、与转让房地产有关的税金城市维护建设税#4、与转让房地产有关的税金印花税#5、与转让房地产有关的税金教育费附加#三、增值额#四、应缴土地增值税税额#五、减免税额#六、已缴土地增值税税额#七、应补（退）土地增值税税额";
		colsHName[67] = "序号#项目#项目#项目#合计#个人住宅#个人其他类型房地产#非个人";


		sjNum[68] = 2;
		colsL[68] = "HJ#YCYC#10SYX#10D16S#16D20S#20D25S#25D30S#30D40S#40SYS#ESYC#1KC#2HC#SGC#SMTC#WQTCL#1ZYZYC#2LSZYJXC#LCB#1JDCB#200DYX#200D2000D#2000D10000D#10000DYS#2YT#10MYX#10D18M#18D30M#30MYS";
		colsH[68] = "XH#XM#CLSHJL#CBSHJS#NYJSE#BNJMSE#BNYJSE#BNYBTSE";
		colsLName[68] = "合计#一、乘用车#1.0升以下#1.0-1.6升#1.6-2.0升#2.0-2.5升#2.5-3.0升#3.0-4.0升#4.0升以上#二、商用车#1、客车#2、货车#三、挂车#四、摩托车#五、其他车辆#1、专用作业车#2、轮式专用机械车#六、船舶#1、机动船舶#200吨以下#200-2000吨#2000-10000吨#10000吨以上#2、游艇#10米以下#10-18米#18-30米#30米以上";
		colsHName[68] = "序号#项目#车辆数合计（辆）#船舶数合计（艘）#年应缴税额#本年减免税额#本年已缴税额#本年应补（退）税额";

		
		sjNum[69] = 2;
		colsL[69] = "HJ#YYSG#YYGM";
		colsH[69] = "XH#XM#SGGMJE#YNSE1#YNSE2#YRKSE";
		colsLName[69] = "合计#烟叶收购#烟叶购买";
		colsHName[69] = "序号#项目#收购/购买金额#应纳税额#已纳税额#应入库税额";
		

		
		sjNum[70] = 2;
		colsL[70] = "HJ#YTDCB#EJTJCSSJS#SGYJS#SSYJS#WZZJS#LNCJMJF#QJSSS#BXX#JYEY#SYY#SYYLY#SEQT";
		colsH[70] = "XH#XM#JSMJWPFM#QZJMSMJWPFM#JZSE#JMSE#YJSE1#YJSE2";
		colsLName[70] = "合计#一、土地储备#二、交通基础设施建设#三、工业建设#四、商业建设#五、住宅建设#六、农村居民建房#七、军事设施#八、学校#九、幼儿园#十、医院#十一、养老院#十二、其他";
		colsHName[70] = "序号#项目#计税面积（万平方米）#其中：减免税面积（万平方米）#计征税额#减免税额#已缴税额#应缴税额";
		


		sjNum[71] = 2;
		colsL[71] = "HJ#YGDJBNT#EGDFJBNT#SYD#SLD#WMCD#LNTSLYD#QYZSM#BYYSYTT#JCD#SWT#SYQTLXTD";
		colsH[71] = "XH#XM#JSMJWPFM#QZJMSMJWPFM#JZSE#JMSE#YJSE1#YJSE2";
		colsLName[71] = "合计#一、耕地（基本农田）#二、耕地（非基本农田）#三、园地#四、林地#五、牧草地#六、农田水利用地#七、养殖水面#八、渔业水域滩涂#九、草地#十、苇田#十一、其他类型土地";
		colsHName[71] = "序号#项目#计税面积（万平方米）#其中：减免税面积（万平方米）#计征税额#减免税额#已缴税额#应缴税额";
		

		sjNum[72] = 2;
		colsL[72] = "1HJ#2YTDQSZYHJ#3YTDSYQCR#41JZYD#52SYYD#63GYYD#74ZHYD#85QTYD#9ETDSYQZR#101JZYD#112SYYD#123GYYD#134ZHYD#145QTYD#15EFWQSZYHJ#16YZLF#17QZ1JTWYZF#1890PMYS#1990PMJYX#202JTDETZF#2190PMYS#2290PMJYX#233FZF#24ECLF#25QZ1JTWYZF#2690PMYS#2790PMJYX#282JTDETZF#2990PMYS#3090PMJYX#313FZF";
		colsH[72] = "XH#XM#QSZYMJWPFM#JZSE#JMSE#YNSE";
		colsLName[72] = "合计#一、土地权属转移合计#（一）土地使用权出让#1.居住用地#2.商业用地#3.工业用地#4.综合用地#5.其他用地#（二）土地使用权转让#1.居住用地#2.商业用地#3.工业用地#4.综合用地#5.其他用地#二、房屋权属转移合计#（一）增量房#其中：1.家庭唯一住房#90平米以上#90平米及以下#2.家庭第二套住房#90平米以上#90平米及以下#3.非住房#（二）存量房#其中：1.家庭唯一住房#90平米以上#90平米及以下#2.家庭第二套住房#90平米以上#90平米及以下#3.非住房";
		colsHName[72] = "序号#项目#权属转移面积（万平方米）#计征税额#减免税额#应纳税额";
		
		
		sjNum[73] = 2;
		colsL[73] = "HJ#YDQWRWQK#QZHYGCQK1#YDYHWQK#EEYHLQK#SYBXFCQK#SYCQK#WBBaZQK#LQTQK#ESWRWQK#QZHYGCQK2#YDYLSWRWQK#1ZQQK#2ZSQK#3ZZQK#4ZGQK#5ZGQK#6QTQK#EDELSWRWQK#1HXXYLCODcrQK#2XFWSSQK#3ADQK#4SYLQK#5QTQK#SPHZSDDCJQSYLL#SQXYZYXXQYHDSCYSWR#SGTFWD#QZHYGCD#YMZSD#EWKD#SWXFWD#SYLZD#WFMHD#LLZD#QQTD#SZSWR";
		colsH[73] = "XH#XM#JLDW#WRWPFL#JSYJ#BQYNSE#BQJMSE#BQYJSE#BQYBTSE";
		colsLName[73] = "合计-#一、大气污染物千克#其中：海洋工程千克#（一）氮氧化物千克#（二）二氧化硫千克#（三）一般性粉尘千克#（四）烟尘千克#（五）苯并(a)芘千克#（六）其他千克#二、水污染物千克#其中：海洋工程千克#（一）第一类水污染物千克#1.总铅千克#2.总砷千克#3.总镉千克#4.总汞千克#5.总铬千克#6.其他千克#（二）第二类水污染物千克#1.化学需氧量(CODcr)千克#2.悬浮物(SS)千克#3.氨氮千克#4.石油类千克#5.其他千克#（三）PH值、色度、大肠菌群数、余氯量-#（四）禽畜养殖业、小型企业和第三产业水污染-#三、固体废物吨#其中：海洋工程吨#（一）煤矸石吨#（二）尾矿吨#（三）危险废物吨#（四）冶炼渣吨#（五）粉煤灰吨#（六）炉渣吨#（七）其他吨#四、噪声污染-";
		colsHName[73] = "序号#项目#计量单位#污染物排放量#计税依据#本期应纳税额#本期减免税额#本期已缴税额#本期应补（退）税额";

		
		sjNum[74] = 2;
		colsL[74] = "JSSBYYSR#JSSBYYCB#JSSBLRKSE#JSSBAGDKMBDYQNDKSE#JSSBYNSSDE#JSSBSJYNQYSDSE#JSSBJMQYSDSE#ASRZEHDSRZE#ASRZEHDYNSSDE#ASRZEHDSJYNQYSDSE#ASRZEHDJMQYSDSE#AJFZCHDJFZCZE#AJFZCHDHSDSRE#AJFZCHDYNSSDE#AJFZCHDSJYNQYSDSE#AJFZCHDJMQYSDSE#ACBFYHDCBFYZE#ACBFYHDHSDSRE#ACBFYHDYNSSDE#ACBFYHDSJYNQYSDSE#ACBFYHDJMQYSDSE";
		colsH[74] = "XH#XM1#XM2#HJ#XG#TW#AM#HG#RB#MG#XJP#JND#ADLY#YG#ELS#DG#FG#BLS#QTGJ";
		colsLName[74] = "据实申报营业收入#据实申报营业成本#据实申报利润（亏损）额#据实申报按规定可弥补的以前年度亏损额#据实申报应纳税所得额#据实申报实际应纳企业所得税额#据实申报减（免）企业所得税额#按收入总额核定收入总额#按收入总额核定应纳税所得额#按收入总额核定实际应纳企业所得税额#按收入总额核定减（免）企业所得税额#按经费支出核定经费支出总额#按经费支出核定换算的收入额#按经费支出核定应纳税所得额#按经费支出核定实际应纳企业所得税额#按经费支出核定减（免）企业所得税额#按成本费用核定成本费用总额#按成本费用核定换算的收入额#按成本费用核定应纳税所得额#按成本费用核定实际应纳企业所得税额#按成本费用核定减（免）企业所得税额";
		colsHName[74] = "序号#项目#项目#合计#香港#台湾#澳门#韩国#日本#美国#新加坡#加拿大#澳大利亚#英国#俄罗斯#德国#法国#比利时#其他国家"; 
		
		
		//无
		sjNum[75] = 0;
		colsL[75] = "";
		colsH[75] = "";
		colsLName[75] = "";
		colsHName[75] = ""; 
				
		//无
		sjNum[76] = 0;
		colsL[76] = "";
		colsH[76] = "";
		colsLName[76] = "";
		colsHName[76] = "";
		
		//无
		sjNum[77] = 0;
		colsL[77] = "";
		colsH[77] = "";
		colsLName[77] = "";
		colsHName[77] = "";
		

		sjNum[78] = 3;
		colsL[78] = "YZZSNSR#1YBNSR#2XGMNSR#EXFSNSR#SYYSNSR#SQYSDSNSR#1JMQYSDSNSR#1NZQY#2WZQY#2FJMQYSDSNSR#WGRSDSNSR#LZYSNSR#QCSWHJSSNSR#BFCSNSR#JYHSNSR#SCZTDSYSNSR#SYTDZZSNSR#SECCSNSR#SSCLGZSNSR#SSYYSNSR#SWGDZYSNSR#SLQSNSR#SQHJBHSNSR#SBQTSSNSR#FLZLDJHS#QZQYNSR#GTNSR";
		colsH[78] = "XH#XM#BQXZHHJ#BQXZHQZ1ZCH#BQXZH2FZCH#QMDJHHJ#QMDJHQZ1ZCH#QMDJH2FZCH#BQZXHHJ#BQZXHQZBQDJBQZX#F1QMZJGHS#QMFZJGHS#F2QMLSNSRDJHS";
		colsLName[78] = "一、增值税纳税人#1.一般纳税人#2.小规模纳税人#二、消费税纳税人#三、营业税纳税人#四、企业所得税纳税人#1.居民企业所得税纳税人#（1）内资企业#（2）外资企业#2.非居民企业所得税纳税人#五、个人所得税纳税人#六、资源税纳税人#七、城市维护建设税纳税人#八、房产税纳税人#九、印花税纳税人#十、城镇土地使用税纳税人#十一、土地增值税纳税人#十二、车船税纳税人#十三、车辆购置税纳税人#十四、烟叶税纳税人#十五、耕地占用税纳税人#十六、契税纳税人#十七、环境保护税纳税人#十八、其他税收纳税人#附列资料：登记户数#其中：企业纳税人#个体纳税人";
		colsHName[78] = "序号#项目#本期新增户合计#本期新增户其中：1.正常户#本期新增户2.非正常户#期末登记户合计#期末登记户其中：1.正常户#期末登记户2.非正常户#本期注销户合计#本期注销户其中：本期登记本期注销#附1：期末总机构户数#期末分支机构户数#附2：期末临时纳税人登记户数";
		
 
		sjNum[79] = 4;
		colsL[79] = "YZZSNSR#1YBNSR#2XGMNSR#EXFSNSR#SYYSNSR#SQYSDSNSR#1JMQYSDSNSR#1NZQY#2WZQY#2FJMQYSDSNSR#WGRSDSNSR#LZYSNSR#QCSWHJSSNSR#BFCSNSR#JYHSNSR#SCZTDSYSNSR#SYTDZZSNSR#SECCSNSR#SSCLGZSNSR#SSYYSNSR#SWGDZYSNSR#SLQSNSR#SQHJBHSNSR#SBQTSSNSR#FLZLQYSDSNDHSQJ";
		colsH[79] = "XH#XM#YYSBHSHJ#YYSBHS1YSBHSXJ#YYSBHS2YSBHSQZZQSBHS#YYSBHS3YSBHSQZYQSBHS#YYSBHS2WSBHS#EYFKBSBHS#QZWDQZD";
		colsLName[79] = "一、增值税纳税人#1.一般纳税人#2.小规模纳税人#二、消费税纳税人#三、营业税纳税人#四、企业所得税纳税人#1.居民企业所得税纳税人#（1）内资企业#（2）外资企业#2.非居民企业所得税纳税人#五、个人所得税纳税人#六、资源税纳税人#七、城市维护建设税纳税人#八、房产税纳税人#九、印花税纳税人#十、城镇土地使用税纳税人#十一、土地增值税纳税人#十二、车船税纳税人#十三、车辆购置税纳税人#十四、烟叶税纳税人#十五、耕地占用税纳税人#十六、契税纳税人#十七、环境保护税纳税人#十八、其他税收纳税人#附列资料：企业所得税年度汇算清缴";
		colsHName[79] = "序号#项目#一、应申报户数合计#一、应申报户数1.已申报户数小计#一、应申报户数2.已申报户数其中：准期申报户数#一、应申报户数3.已申报户数其中：逾期申报户数#一、应申报户数2.未申报户数#二、依法可不申报户数#其中：未达起征点";
		
		
		

		sjNum[80] = 3;
		colsL[80] = "HJ#YDYCY#EDECY#YCKY#1MTKCHXXY#2SYHTRQKCY#3HSJSKCXY#4YSJSKCXY#5FJSKCXY#6QTCKY#EZZY#1NFSPJGY#2SPZZY#3JYLHJZCZZY#4YCZPY#5FZY#6FZFZFSY#7PGMPYMJQZPHZXY#8MCJGHMZTZCZPY#9JJZZY#10ZZHZZPY#11YSHJLMJFZY#12WJGMTYHYLYPZZY#13SYMTJQTRLJGY#14HXYLHHXZPZZY#15YYZZY#16HXXWZZY#17XJHSLZPY#18FJSKWZPY#19HSJSYLHYYJGY#20YSJSYLHYYJGY#21JSZPY#22TYSBZZY#23ZYSBZZY#24QCZZY#25TLCBHKHTHQTYSSBZZY#26DQJXHQCZZY#27JSJTXHQTDZSBZZY#28YBYQZZY#29QTZZY#SDLRLRQJSDSCHGYY#1DLRLDSCHGYY#2RQSCHGYY#3SDSCHGYY#SJZY#1FWJZY#2TMGCJZY#3JZAZY#4JZZSZXHQTJZY#SDSCY#YPFHLSY#1PFY#2LSY#EJTYSCCHYZY#1TLYSY#2DLYSY#3SSYSY#4HKYSY#5GDYSY#6DSLYHYSDLY#7ZXBYHCCY#8YZY#SZSHCYY#1ZSY#2CYY#SXXCSRJHXXJSFWY#1DXGBDSHWXCSFWY#2HLWHXGFW#3RJHXXJSFWY#WJRY#1HBJRFW#2ZBSCFW#3BXY#4QTJRY#LFDCY#QZLHSWFWY#1ZLY#2SWFWY#BKXYJHJSFWY#JJMFWXLHQTFWY#SJY#SYWSHSHGZ#SEWHTYHYLY#SSGGGLSHBZHSHZZ#SSQTXY";
		colsH[80] = "XH#XM#GNZZS#QZYBNSRZZS#GNXFS#YYS#QYSDSNZQY#QYSDSWZQY#GRSDS#CSWHJSS#FCS#YHS#CZTDSYS#TDZZS#CLGZS#CCS#GDZYS#QS#HJBHS#QTGS#FLZLNSHS#DJHS#FZJGHS1#FZJGHS2";
		colsLName[80] = "合计#一、第一产业#二、第二产业#(一)采矿业#1.煤炭开采和洗选业#2.石油和天然气开采业#3.黑色金属矿采选业#4.有色金属矿采选业#5.非金属矿采选业#6.其他采矿业#(二)制造业#1.农副食品加工业#2.食品制造业#3.酒、饮料和精制茶制造业#4.烟草制品业#5.纺织业#6.纺织服装、服饰业#7.皮革、毛皮、羽毛及其制品和制鞋业#8.木材加工和木竹藤棕草制品业#9.家具制造业#10.造纸和纸制品业#11.印刷和记录媒介复制业#12.文教、工美、体育和娱乐用品制造业#13.石油、煤炭及其他燃料加工业#14.化学原料和化学制品制造业#15.医药制造业#16.化学纤维制造业#17.橡胶和塑料制品业#18.非金属矿物制品业#19.黑色金属冶炼和压延加工业#20.有色金属冶炼和压延加工业#21.金属制品业#22.通用设备制造业#23.专用设备制造业#24.汽车制造业#25.铁路、船舶、航空航天和其他运输设备制造业#26.电气机械和器材制造业#27.计算机、通信和其他电子设备制造业#28.仪表仪器制造业#29.其他制造业#(三)电力、热力、燃气及水的生产和供应业#1.电力、热力的生产和供应业#2.燃气生产和供应业#3.水的生产和供应业#(四)建筑业#1.房屋建筑业#2.土木工程建筑业#3.建筑安装业#4.建筑装饰、装修和其他建筑业#三、第三产业#(一)批发和零售业#1.批发业#2.零售业#(二)交通运输、仓储和邮政业#1.铁路运输业#2.道路运输业#3.水上运输业#4.航空运输业#5.管道运输业#6.多式联运和运输代理业#7.装卸搬运和仓储业#8.邮政业#(三)住宿和餐饮业#1.住宿业#2.餐饮业#（四）信息传输、软件和信息技术服务业#1.电信、广播电视和卫星传输服务业#2.互联网和相关服务#3.软件和信息技术服务业#(五)金融业#1.货币金融服务#2.资本市场服务#3.保险业#4.其他金融业#(六)房地产业#(七)租赁和商务服务业#1.租赁业#2.商务服务业#(八）科学研究和技术服务业#（九）居民服务、修理和其他服务业#(十)教育#（十一）卫生和社会工作#(十二)文化、体育和娱乐业#(十三)公共管理、社会保障和社会组织#(十四)其他行业";
		colsHName[80] = "序号#项目#国内增值税#其中:一般纳税人增值税#国内消费税#营业税#企业所得税内资企业#企业所得税外资企业#个人所得税#城市维护建设税#房产税#印花税#城镇土地使用税#土地增值税#车辆购置税#车船税#耕地占用税#契税#环境保护税#其他各税#附列资料：纳税户数#登记户数#附：总机构户数#分支机构户数";
		


		sjNum[81] = 3;
		colsL[81] = "1ZZS#YBNSR#XGMNSR#2XFS#3YYS#4QYSDS#5GRSDS#6ZYS#7CSWHJSS#8FCS#9YHS#10CZTDSYS#11TDZZS#12CCS#13CLGZS#14YYS#15GDZYS#16QS#17HJBHS#18QTSS#FLZLNSHS#DJHS";
		colsH[81] = "XH#XM#HJ#NZQYXJ#NZQYGYQY#NZQYJTQY#NZQYGFHZQY#NZQYLYQY#NZQYQZGYKG1#NZQYGFGS#NZQYQZGYKG2#NZQYSYQY#NZQYQTQY#GATTZQY#QZGYKG1#WSTZQY#QZGYKG2#GTJY#FZJGHS1#FZJGHS2";
		colsLName[81] = "1.增值税#一般纳税人#小规模纳税人#2.消费税#3.营业税#4.企业所得税#5.个人所得税#6.资源税#7.城市维护建设税#8.房产税#9.印花税#10.城镇土地使用税#11.土地增值税#12.车船税#13.车辆购置税#14.烟叶税#15.耕地占用税#16.契税#17.环境保护税#18.其他税收#附列资料：纳税户数#登记户数";
		colsHName[81] = "序号#项目#合计#内资企业小计#内资企业国有企业#内资企业集体企业#内资企业股份合作企业#内资企业联营企业#内资企业其中：国有控股#内资企业股份公司#内资企业其中：国有控股#内资企业私营企业#内资企业其他企业#港澳台投资企业#其中：国有控股#外商投资企业#其中：国有控股#个体经营#附：总机构户数#分支机构户数";
		
		

		sjNum[0] = 0;
		colsL[0] = "";
		colsH[0] = "";
		colsLName[0] = "";
		colsHName[0] = "";
		
		

		sjNum[0] = 0;
		colsL[0] = "";
		colsH[0] = "";
		colsLName[0] = "";
		colsHName[0] = "";
		
		

		sjNum[0] = 0;
		colsL[0] = "";
		colsH[0] = "";
		colsLName[0] = "";
		colsHName[0] = "";
		
		
		
	}
	

}
