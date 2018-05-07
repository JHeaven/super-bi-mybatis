package com.heaven.main.analyse2018;

/**
 * 2018�汾
 * ��������map��sql
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
				//����MAP
				getMaps(i);
				System.out.println();
				//����SQL
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
		colsLName[1] = "�ϼ�#1.����˰��#2.������������#3.����˰��#4.����˰��#5.��;˰��#6.���˰��#7.�����������#8.����˰��#9.��������ʧ˰��#10.��ʧ˰�����#11.���ܿ�";
		colsHName[1] = "���#�ʽ�ռ�ÿ�Ŀ#�ʽ�ռ��������#�ʽ�ռ����ĩ���#�ʽ���Դ��Ŀ#�ʽ���Դ������#�ʽ���Դ��ĩ���";

		sjNum[2] = 4;
		colsL[2] = "1ZJ#2YSSSRHJ#31ZZSSR#41GNZZS#5YBZZS#6GZZZS#7QZZGTLZGSGZZZSSR#8CJRJYZZSTS#9RJZZSTS#10SGZHLYZZSTS#11SDZZSTS#12ZYZHLYZZSTS#13CPYZZSTS#14MDDZZZS#15MDDZGZZZS#162JKHWZZS#172XFSSR#18GNXFS#19QZCPYXFS#20JKXFPXFS#21QZJKCPYXFS#223YYS#23JRBXYYYS#24QTYYS#254QYSDS#26QZZYGDSR#271YBQYSDS#28NZQY#29WZQY#302FZJGYJSDS#31NZQY#32WZQY#333ZJGYJSDS#34NZQY#35WZQY#364FZJGHSQJSDS#37NZQY#38WZQY#395ZJGHSQJSDS#40NZQY#41WZQY#426QYSDSDFPSR#43NZQY#44WZQY#455GRSDS#46LXSDS#47QTGRSDS#486ZYS#497CSWHJSS#508FCS#519YHS#52ZQJYYHS#53QTYHS#5410CZTDSYS#5511TDZZS#5612CCS#5713CLGZS#5814YYS#5915GDZYS#6016QS#6117HJBHS#6218QTSS#63ECPYXFSTS#64SCKTSHJ#651CKHWTZZS#662GZZZSCKTS#673MDDJZZS#684MDDJGZZZS#695CKXFPTXFS#70SFSSRHJ#711JYFFJSR#722DFJYFJ#733WHSYJSFSR#744HSSYKQSYFSR#755SWBMFMSR#766CJRJYBZJJ#777SHBXJJSR#78QYZGJBYLBXJJSR#79SYBXJJSR#80ZGJBYLBXJJSR#81GSBXJJSR#82SYBXJJSR#83XXNCHZYLJJSR#84CZJMJBYLBXJJSR#85CXJMJBYLBXJJSR#86JGSYDWJBYLBXJJSR#87CXJMJBYLBXJJSR#88QTSHBXJJSR#898ZFXJJSR#90FQDQDZCPCLJJSR#91QTZFXJJSR#929GHJFSR#9310QTFSSR";
		colsH[2] = "XH#XM#HJ#BNXQRK#2001N5Y1RYHCQRK#2001N5Y1RYQCQRK#ZY#DFXJ1#DFSJ1#DFSJ2#DFXJ2";
		colsLName[2] = "�ܼ�#һ��˰������ϼ�#1.��ֵ˰����#(1)������ֵ˰#һ����ֵ˰#������ֵ˰#���У��й���·�ܹ�˾������ֵ˰����#�м��˾�ҵ��ֵ˰��˰#�����ֵ˰��˰#ɭ���ۺ�������ֵ˰��˰#ˮ����ֵ˰��˰#��Դ�ۺ�������ֵ˰��˰#��Ʒ����ֵ˰��˰#��ֵ�����ֵ˰#��ֵ���������ֵ˰#(2)���ڻ�����ֵ˰#2.����˰����#��������˰#���У���Ʒ������˰#��������Ʒ����˰#���У����ڳ�Ʒ������˰#3.Ӫҵ˰#���ڱ���ҵӪҵ˰#����Ӫҵ˰#4.��ҵ����˰#���У�����̶�����#��1��һ����ҵ����˰#������ҵ#������ҵ#��2����֧����Ԥ������˰#������ҵ#������ҵ#��3���ܻ���Ԥ������˰#������ҵ#������ҵ#��4����֧���������������˰#������ҵ#������ҵ#��5���ܻ��������������˰#������ҵ#������ҵ#��6����ҵ����˰����������#������ҵ#������ҵ#5.��������˰#��Ϣ����˰#������������˰#6.��Դ˰#7.����ά������˰#8.����˰#9.ӡ��˰#֤ȯ����ӡ��˰#����ӡ��˰#10.��������ʹ��˰#11.������ֵ˰#12.����˰#13.��������˰#14.��Ҷ˰#15.����ռ��˰#16.��˰#17.��������˰#18.����˰��#������Ʒ������˰��˰#����������˰�ϼ�#1.���ڻ�������ֵ˰#2.������ֵ˰������˰#3.��ֵ�����ֵ˰#4.��ֵ���������ֵ˰#5.��������Ʒ������˰#�ġ���˰����ϼ�#1.�����Ѹ�������#2.�ط���������#3.�Ļ���ҵ���������#4.����ʯ�Ϳ���ʹ�÷�����#5.˰���ŷ�û����#6.�м��˾�ҵ���ϻ���#7.��ᱣ�ջ�������#��ҵְ���������ϱ��ջ�������#ʧҵ���ջ�������#ְ������ҽ�Ʊ��ջ�������#���˱��ջ�������#�������ջ�������#����ũ�����ҽ�ƻ�������#����������ҽ�Ʊ��ջ�������#�������������ϱ��ջ�������#������ҵ��λ�������ϱ��ջ�������#����������ҽ�Ʊ��ջ�������#������ᱣ�ջ�������#8.�����Ի�������#�����������Ӳ�Ʒ�����������#���������Ի�������#9.���ᾭ������#10.������˰����";
		colsHName[2] = "���#��Ŀ#�ϼ�#������Ƿ���#2001��5��1���Ժ��Ƿ���#2001��5��1����ǰ��Ƿ��#����#�ط�С��#�ط�ʡ��#�ط��м�#�ط��ؼ�";


		sjNum[3] = 3 ;
		colsL[3] = "ZJ#YSSSRHJ#1ZZSSR#QZGZZZS#2XFSSR#3YYS#4QYSDS#5GRSDS#6ZYS#7CSWHJSS#8FCS#9YHS#10CZTDSYS#11TDZZS#12CCS#13CLGZS#14YYS#15GDZYS#16QS#17HJBHS#18QTSS#EQTSRHJ#QZFQDQDZCPCLJJSR";
		colsH[3] = "XH#XM#NCYE#DNFSEHJ#DNFSEGYQY#DNFSEJTQY#DNFSEGFHZQY#DNFSELYQY#DNFSEQZGYKG1#DNFSEGFGS#DNFSEQZGYKG2#DNFSESYQY#DNFSEGATTZQY#DNFSEQZGYKG3#DNFSEWSTZQY#DNFSEQZGYKG4#DNFSEQTQY#QMYE";
		colsLName[3] = "�ܼ�#һ��˰������ϼ�#1.��ֵ˰����#���У�������ֵ˰#2.����˰����#3.Ӫҵ˰#4.��ҵ����˰#5.��������˰#6.��Դ˰#7.����ά������˰#8.����˰#9.ӡ��˰#10.��������ʹ��˰#11.������ֵ˰#12.����˰#13.��������˰#14.��Ҷ˰#15.����ռ��˰#16.��˰#17.��������˰#18.����˰��#������������ϼ�#���У������������Ӳ�Ʒ�����������";
		colsHName[3] = "���#��Ŀ#������#���귢����ϼ�#���귢���������ҵ#���귢�������ҵ#���귢����ɷݺ�����ҵ#���귢������Ӫ��ҵ#���귢�������й��пع�#���귢����ɷݹ�˾#���귢�������й��пع�#���귢����˽Ӫ��ҵ#���귢����۰�̨Ͷ����ҵ#���귢�������й��пع�#���귢��������Ͷ����ҵ#���귢�������й��пع�#���귢����������ҵ#��ĩ���";



		sjNum[4] = 2;
		colsL[4] = "1ZJ#2YSSSRHJ#3WDQYJSK#4JPZHZ#5GTJKKQYQS#6WNCQ#7BNXQ#81GNZZS#9QZGZZZS#10WDQYJSK#11JPZHZ#12GTJKKQYQS#13WNCQ#14BNXQ#152GNXFS#16WDQYJSK#17JPZHZ#18GTJKKQYQS#19WNCQ#20BNXQ#213YYS#22WDQYJSK#23JPZHZ#24GTJKKQYQS#25WNCQ#26BNXQ#274QYSDS#28WDQYJSK#29JPZHZ#30GTJKKQYQS#31WNCQ#32BNXQ#335GRSDS#34WDQYJSK#35JPZHZ#36GTJKKQYQS#37WNCQ#38BNXQ#396ZYS#40WDQYJSK#41JPZHZ#42GTJKKQYQS#43WNCQ#44BNXQ#457CSWHJSS#46WDQYJSK#47JPZHZ#48GTJKKQYQS#49WNCQ#50BNXQ#518FCS#52WDQYJSK#53JPZHZ#54GTJKKQYQS#55WNCQ#56BNXQ#579YHS#58WDQYJSK#59JPZHZ#60GTJKKQYQS#61WNCQ#62BNXQ#6310CZTDSYS#64WDQYJSK#65JPZHZ#66GTJKKQYQS#67WNCQ#68BNXQ#6911TDZZS#70WDQYJSK#71JPZHZ#72GTJKKQYQS#73WNCQ#74BNXQ#7512CCS#76WDQYJSK#77JPZHZ#78GTJKKQYQS#79WNCQ#80BNXQ#8113YYS#82WDQYJSK#83JPZHZ#84GTJKKQYQS#85WNCQ#86BNXQ#8714GDZYS#88WDQYJSK#89JPZHZ#90GTJKKQYQS#91WNCQ#92BNXQ#9315QS#94WDQYJSK#95JPZHZ#96GTJKKQYQS#97WNCQ#98BNXQ#9916HJBHS#100WDQYJSK#101JPZHZ#102GTJKKQYQS#103WNCQ#104BNXQ#10517QTSS#106WDQYJSK#107JPZHZ#108GTJKKQYQS#109WNCQ#110BNXQ#111EQTSRHJ#112QZFQDQDZCPCLJJSR";
		colsH[4] = "XH#XM#QCYE#BQZJE#BQJSE#QMYE";
		colsLName[4] = "�ܼ�#һ��˰������ϼ�#δ����Ӧ��˰��#����׼����#�ء�ͣ���տ���ҵǷ˰#�����Ƿ#������Ƿ#1.������ֵ˰#���У�������ֵ˰#δ����Ӧ��˰��#����׼����#�ء�ͣ���տ���ҵǷ˰#�����Ƿ#������Ƿ#2.��������˰#δ����Ӧ��˰��#����׼����#�ء�ͣ���տ���ҵǷ˰#�����Ƿ#������Ƿ#3.Ӫҵ˰#δ����Ӧ��˰��#����׼����#�ء�ͣ���տ���ҵǷ˰#�����Ƿ#������Ƿ#4.��ҵ����˰#δ����Ӧ��˰��#����׼����#�ء�ͣ���տ���ҵǷ˰#�����Ƿ#������Ƿ#5.��������˰#δ����Ӧ��˰��#����׼����#�ء�ͣ���տ���ҵǷ˰#�����Ƿ#������Ƿ#6.��Դ˰#δ����Ӧ��˰��#����׼����#�ء�ͣ���տ���ҵǷ˰#�����Ƿ#������Ƿ#7.����ά������˰#δ����Ӧ��˰��#����׼����#�ء�ͣ���տ���ҵǷ˰#�����Ƿ#������Ƿ#8.����˰#δ����Ӧ��˰��#����׼����#�ء�ͣ���տ���ҵǷ˰#�����Ƿ#������Ƿ#9.ӡ��˰#δ����Ӧ��˰��#����׼����#�ء�ͣ���տ���ҵǷ˰#�����Ƿ#������Ƿ#10.��������ʹ��˰#δ����Ӧ��˰��#����׼����#�ء�ͣ���տ���ҵǷ˰#�����Ƿ#������Ƿ#11.������ֵ˰#δ����Ӧ��˰��#����׼����#�ء�ͣ���տ���ҵǷ˰#�����Ƿ#������Ƿ#12.����˰#δ����Ӧ��˰��#����׼����#�ء�ͣ���տ���ҵǷ˰#�����Ƿ#������Ƿ#13.��Ҷ˰#δ����Ӧ��˰��#����׼����#�ء�ͣ���տ���ҵǷ˰#�����Ƿ#������Ƿ#14.����ռ��˰#δ����Ӧ��˰��#����׼����#�ء�ͣ���տ���ҵǷ˰#�����Ƿ#������Ƿ#15.��˰#δ����Ӧ��˰��#����׼����#�ء�ͣ���տ���ҵǷ˰#�����Ƿ#������Ƿ#16.��������˰#δ����Ӧ��˰��#����׼����#�ء�ͣ���տ���ҵǷ˰#�����Ƿ#������Ƿ#17.����˰��#δ����Ӧ��˰��#����׼����#�ء�ͣ���տ���ҵǷ˰#�����Ƿ#������Ƿ#������������ϼ�#���У������������Ӳ�Ʒ�����������";
		colsHName[4] = "���#��Ŀ#�ڳ����#�������Ӷ�#���ڼ��ٶ�#��ĩ���";



		sjNum[5] = 2;
		colsL[5] = "ZJ#YSSSRHJ#1ZZS#QZGZZZS#JXLD#2XFS#QZCPYXFS#3YYS#4QYSDS#5GRSDS#6ZYS#7CSWHJSS#8FCS#9YHS#10CZTDSYS#11TDZZS#12CCS#13CLGZS#14YYS#15GDZYS#16QS#17HJBHS#18QTSS#EQTSRHJ#QZFQDQDZCPCLJJSR#FLZLZZSJXLDSE";
		colsH[5] = "XH#XM#HJ#CKTS#XZHT#JMTS#HSQJJSTS#WSTS#QTTS";
		colsLName[5] = "�ܼ�#һ��˰������ϼ�#1.��ֵ˰#���У�������ֵ˰#��������#2.����˰#���У���Ʒ������˰#3.Ӫҵ˰#4.��ҵ����˰#5.��������˰#6.��Դ˰#7.����ά������˰#8.����˰#9.ӡ��˰#10.��������ʹ��˰#11.������ֵ˰#12.����˰#13.��������˰#14.��Ҷ˰#15.����ռ��˰#16.��˰#17.��������˰#18.����˰��#������������ϼ�#���У������������Ӳ�Ʒ�����������#�������ϣ���ֵ˰��������˰��";
		colsHName[5] = "���#��Ŀ#�ϼ�#������˰#��������#������˰#������ɽ�����˰#������˰#������˰";


		sjNum[6] = 3 ;
		colsL[6] = "ZJ#QZZQJM#TKJM#DDQS#YGSMS#1ZF#2JZJZJ#3JZZY#4ZJYFC#5SHBZ#6TGJMSR#7QT#EGLGXJS#1JSZR#2KJFZ#3ZZCX#4KYJGZZ#5TZCY#6WBFW#7GXJS#8QT#SCJXWQYFZ#1JRSC#2WDQZD#3MZZZSHYYSZC#4QT1#SZZSJ#1QYFZ#2QYZZGZ#3QT#WJNHB#1HJBH#2DLJS#3ZYZHLY#4QT2#LCJQYFZ#1XBKF#2DBFZ#3LAJL#4QT3#QZCWHJYTY#1JY#2TY#3WH#BZCJRZBSC#1ZBSC#2JRSC#JZCSN#1NCJS#2FLSL#3CYSJ#4JRSC#5QT1#SZCQTGXSY#1FJZZ#2JCSSJS#3CPY#4GFJS#5GJF#6YLWS#7JTYS#8WCYZ#9GY#10SPCB#11WJRY#12ZXCZXZJ#13QT2#SYXSSSXDDY#1GX#2LX#3TXQSYF#4CCSY#5QT3";
		colsH[6] = "XH#XM#HJ#SSSRXJ#SSSRZZS#SSSRQZGZZZS#SSSRXFS#SSSRYYS#SSSRQYSDS#SSSRGRSDS#SSSRZYS#SSSRCSWHJSS#SSSRFCS#SSSRYHS#SSSRCZTDSYS#SSSRTDZZS#SSSRCCS#SSSRCLGZS#SSSRGDZYS#SSSRQS#SSSRHJBHS#SSSRQTSS#QTSRHJ#QYSDSYJYJJM";
		colsLName[6] = "�ܼ�#���У���ǰ����#�˿����#�ֶ�Ƿ˰#һ����������#1.ס��#2.���ּ��ؽ�#3.��ת��ҵ#4.�پ�ҵ����#5.��ᱣ��#6.��߾�������#7.����#�����������¼���#1.����ת��#2.�Ƽ���չ#3.��������#4.���л���ת��#5.Ͷ�ʴ�ҵ#6.�������#7.���¼���#8.����#�����ٽ�С΢��ҵ��չ#1.�����г�#2.δ��������#3.������ֵ˰��Ӫҵ˰����#4.����#�ġ�ת������#1.��ҵ��չ#2.��ҵ�������#3.����#�塢���ܻ���#1.��������#2.��������#3.��Դ�ۺ�����#4.����#�����ٽ�����չ#1.��������#2.������չ#3.��������#4.����#�ߡ�֧���Ļ���������#1.����#2.����#3.�Ļ�#�ˡ�֧�ֽ����ʱ��г�#1.�ʱ��г�#2.�����г�#�š�֧����ũ#1.ũ�彨��#2.��������#3.��ҵ����#4.�����г�#5.����#ʮ��֧������������ҵ#1.�ɻ�����#2.������ʩ����#3.��Ʒ��#4.��������#5.���취#6.ҽ������#7.��ͨ����#8.�޳�Ԯ��#9.����#10.��Ʒ����#11.�⼮��Ա#12.ר��������ʽ�#13.����#ʮһ������˰��Э������#1.��Ϣ#2.��Ϣ#3.����Ȩʹ�÷�#4.�Ʋ�����#5.����";
		colsHName[6] = "���#��Ŀ#�ϼ�#˰������С��#˰��������ֵ˰#˰���������У�������ֵ˰#˰����������˰#˰������Ӫҵ˰#˰��������ҵ����˰#˰�������������˰#˰��������Դ˰#˰���������ά������˰#˰�����뷿��˰#˰������ӡ��˰#˰�������������ʹ��˰#˰������������ֵ˰#˰�����복��˰#˰�����복������˰#˰���������ռ��˰#˰��������˰#˰�����뻷������˰#˰����������˰��#��������ϼ�#��ҵ����˰�£�����Ԥ�ɼ���";

		sjNum[7] = 3;
		colsL[7] = "ZJ#YSSSRHJ#1ZZSSR#QZGNZZS#2XFSSR#QZGNXFS#3YYS#4QYSDS#5GRSDS#6ZYS#7CSWHJSS#8FCS#9YHS#10CZTDSYS#11TDZZS#12CCS#13CLGZS#14YYS#15GDZYS#16QS#17HJBHS#18QTSS#EQTSRHJ#FQDQDZCPCLJJSR";
		colsH[7] = "XH#XM#DJSJNCYE1#DJSJQMYE2#ZTSJNCYE#ZTSJQMYE#DJSJNCYE#DJSJQMYE3#DCLSSSJNCYE#DCLSSSJQMYE#SSSJHXNCYE#SSSJHXQMYE";
		colsLName[7] = "�ܼ�#һ��˰������ϼ�#1.��ֵ˰����#���У�������ֵ˰#2.����˰����#���У���������˰#3.Ӫҵ˰#4.��ҵ����˰#5.��������˰#6.��Դ˰#7.����ά������˰#8.����˰#9.ӡ��˰#10.��������ʹ��˰#11.������ֵ˰#12.����˰#13.��������˰#14.��Ҷ˰#15.����ռ��˰#16.��˰#17.��������˰#18.����˰��#������������ϼ�#�����������Ӳ�Ʒ�����������";
		colsHName[7] = "���#��Ŀ#���˰��������#���˰����ĩ���#��;˰��������#��;˰����ĩ���#����˰��������#����˰����ĩ���#��������ʧ˰��������#��������ʧ˰����ĩ���#��ʧ˰�����������#��ʧ˰�������ĩ���";

		sjNum[8] = 5;
		colsL[8] = "ZJ#YSSSRHJ#1ZZS#QZGZZZS#2XFS#3YYS#4QYSDS#5GRSDS#6ZYS#7CSWHJSS#8FCS#9YHS#10CZTDSYS#11TDZZS#12CCS#13CLGZS#14YYS#15GDZYS#16QS#17HJBHS#18QTSS#EQTSRHJ#QZ1JYFFJSR#2WHSYJSFSR#3FQDQDZCPCLJJSR#4QTFMSR";
		colsH[8] = "XH#XM#YZCBSJHJ#YZCBSJSWJCBMCBSK#YZCBSJSWJCBMCBZNJ#YZCBSJSWJCBMCBFK#YZCBSJSWJCBMCBQZZCBS#YZCBSJSWQTBMCBSK#YZCBSJSWQTBMCBZNJ#YZCBSJSWQTBMCBFK#YZCBSJSWQTBMCBQZ1TBNSDZ#YZCBSJSWQTBMCB2NSPG#YZCBSJWBMCBSK#YZCBSJWBMCBZNJ#YZCBSJWBMCBFK#RKCBSJHJ#RKCBSJSWJCBMCBXJXJ#RKCBSJSWJCBMCBXJZY#RKCBSJSWJCBMCBXJDF#RKCBSJSWJCBMCBSK#RKCBSJSWJCBMCBZNJ#RKCBSJSWJCBMCBFK#RKCBSJSWJCBMCBQZZCBS#RKCBSJSWQTBMCBSK#RKCBSJSWQTBMCBZNJ#RKCBSJSWQTBMCBFK#RKCBSJSWQTBMCBQZ1TBNSDZ#RKCBSJSWQTBMCB2NSPG#RKCBSJWBMCBSK#RKCBSJWBMCBZNJ#RKCBSJWBMCBFK#RKSKZNJFKSR";
		colsLName[8] = "�ܼ�#һ��˰������ϼ�#1.��ֵ˰#���У�������ֵ˰#2.����˰#3.Ӫҵ˰#4.��ҵ����˰#5.��������˰#6.��Դ˰#7.����ά������˰#8.����˰#9.ӡ��˰#10.��������ʹ��˰#11.������ֵ˰#12.����˰#13.��������˰#14.��Ҷ˰#15.����ռ��˰#16.��˰#17.��������˰#18.����˰��#������������ϼ�#����:1.�����Ѹ�������#2.�Ļ���ҵ���������#3.�����������Ӳ�Ʒ�����������#4.������û����";
		colsHName[8] = "���#��Ŀ#Ӧ���鲹˰��ϼ�#Ӧ���鲹˰��˰����鲿�Ų鲹˰��#Ӧ���鲹˰��˰����鲿�Ų鲹���ɽ�#Ӧ���鲹˰��˰����鲿�Ų鲹����#Ӧ���鲹˰��˰����鲿�Ų鲹����:�Բ鲹˰#Ӧ���鲹˰��˰���������Ų鲹˰��#Ӧ���鲹˰��˰���������Ų鲹���ɽ�#Ӧ���鲹˰��˰���������Ų鲹����#Ӧ���鲹˰��˰���������Ų鲹���У�1.�ر���˰����#Ӧ���鲹˰��˰���������Ų鲹2.��˰����#Ӧ���鲹˰���ⲿ�Ų鲹˰��#Ӧ���鲹˰���ⲿ�Ų鲹���ɽ�#Ӧ���鲹˰���ⲿ�Ų鲹����#���鲹˰��ϼ�#���鲹˰��˰����鲿�Ų鲹С��С��#���鲹˰��˰����鲿�Ų鲹С������#���鲹˰��˰����鲿�Ų鲹С�Ƶط�#���鲹˰��˰����鲿�Ų鲹˰��#���鲹˰��˰����鲿�Ų鲹���ɽ�#���鲹˰��˰����鲿�Ų鲹����#���鲹˰��˰����鲿�Ų鲹����:�Բ鲹˰#���鲹˰��˰���������Ų鲹˰��#���鲹˰��˰���������Ų鲹���ɽ�#���鲹˰��˰���������Ų鲹����#���鲹˰��˰���������Ų鲹���У�1.�ر���˰����#���鲹˰��˰���������Ų鲹2.��˰����#���鲹˰���ⲿ�Ų鲹˰��#���鲹˰���ⲿ�Ų鲹���ɽ�#���鲹˰���ⲿ�Ų鲹����#���˰�����ɽ𡢷�������";

		sjNum[9] =2 ;
		colsL[9] = "SSSRHJ#1ZZS#QZGZZZS#2XFS#3YYS#4QYSDS#5GRSDS#6ZYS#7CSWHJSS#8FCS#9YHS#10CZTDSYS#11TDZZS#12CCS#13CLGZS#14YYS#15GDZYS#16QS#17HJBHS#18QTSS";
		colsH[9] = "XH#XM#HJ#RKZNJ#HXZNJ#YJWJZNJ";
		colsLName[9] = "˰������ϼ�#1.��ֵ˰#���У�������ֵ˰#2.����˰#3.Ӫҵ˰#4.��ҵ����˰#5.��������˰#6.��Դ˰#7.����ά������˰#8.����˰#9.ӡ��˰#10.��������ʹ��˰#11.������ֵ˰#12.����˰#13.��������˰#14.��Ҷ˰#15.����ռ��˰#16.��˰#17.��������˰#18.����˰��";
		colsHName[9] = "���#��Ŀ#�ϼ�#������ɽ�#�������ɽ�#Ӧ��δ�����ɽ�";

		sjNum[10] = 2;
		colsL[10] = "ZJ#YSSSRHJ#1ZZS#QZGZZZS#2XFS#3YYS#4QYSDS#5GRSDS#6ZYS#7CSWHJSS#8FCS#9YHS#QZZQJYYHS#10CZTDSYS#11TDZZS#12CCS#13CLGZS#14YYS#15GDZYS#16QS#17HJBHS#18QTSS#EQTSRHJ#QZJYFFJSR#FQDQDZCPCLJJSR";
		colsH[10] = "XH#XM#HJ#DKDS#WTDZ";
		colsLName[10] = "�ܼ�#һ��˰������ϼ�#1.��ֵ˰#���У�������ֵ˰#2.����˰#3.Ӫҵ˰#4.��ҵ����˰#5.��������˰#6.��Դ˰#7.����ά������˰#8.����˰#9.ӡ��˰#���У�֤ȯ����ӡ��˰#10.��������ʹ��˰#11.������ֵ˰#12.����˰#13.��������˰#14.��Ҷ˰#15.����ռ��˰#16.��˰#17.��������˰#18.����˰��#������������ϼ�#���У������Ѹ�������#�����������Ӳ�Ʒ�����������";
		colsHName[10] = "���#��Ŀ#�ϼ�#���۴���#ί�д���";

		sjNum[11] =3 ;
		colsL[11] = "HJ#NSBZJ#FPBZJ#NSDBJ#SSBQK#PMBMK#QT";
		colsH[11] = "XH#XM#NCYE#SRBY#SRBNLJ#ZCBY#ZCBNLJ#QMYE";
		colsLName[11] = "�ϼ�#��˰��֤��#��Ʊ��֤��#��˰������#˰�ձ�ȫ��#����������#����";
		colsHName[11] = "���#��Ŀ#������#���뱾��#���뱾���ۼ�#֧������#֧�������ۼ�#��ĩ���";

		sjNum[12] =2 ;
		colsL[12] = "ZJ#YSSSRHJ#1ZZS#2XFS#3YYS#4QYSDS#5GRSDS#6ZYS#7CSWHJSS#8FCS#9YHS#10CZTDSYS#11TDZZS#12CCS#13CLGZS#14YYS#15GDZYS#16QS#17HJBHS#18QTSS#EQTSRHJ";
		colsH[12] = "XH#XM#HJ#GTQYDZSJ#KKQYDZSJ#ZFZCXDZSJ#QT";
		colsLName[12] = "�ܼ�#һ��˰������ϼ�#1.��ֵ˰#2.����˰#3.Ӫҵ˰#4.��ҵ����˰#5.��������˰#6.��Դ˰#7.����ά������˰#8.����˰#9.ӡ��˰#10.��������ʹ��˰#11.������ֵ˰#12.����˰#13.��������˰#14.��Ҷ˰#15.����ռ��˰#16.��˰#17.��������˰#18.����˰��#������������ϼ�";
		colsHName[12] = "���#��Ŀ#�ϼ�#�ء�ͣ��ҵ����˰��#�տ���ҵ����˰��#���������Դ���˰��#����";

		sjNum[13] = 3;
		colsL[13] = "HJ#YJTYSFW#1LLYSFW#2SLYSFW#3HKYSFW#4GDYSFW#EYZFW#1YZPBFW#2YZTSFW#3QTYZFW#SDXFW#1JCDXFW#2ZZDXFW#SJZFW#1GCFW#2AZFW#3XSFW#4ZSFW#5QTJZFW#WJRFW#1DKFW#2ZJSFJRFW#3BXFW#4JRSPZR#LXDFW#1YFHJSFW#2XXJSFW#3WHCYFW#4WLFZFW#5ZLFW#6JZZXFW#7GBYSFW#8SWFZFW#9QTXDFW#QSHFW#1WHTYFW#2JYYLFW#3LYYLFW#4CYZSFW#5JMRCFW#6QTSHFW#BXSWXZC#1ZLHFZLJS#2SBHZZQ#3TDSYQ#4QTZRZYSYQ#5QTQYXWXZC#JXSBDC#1JZW#QZESFJY1#2GZW#QZESFJY2";
		colsH[13] = "XH#XM#RKSJ#YZSJNCYE#YZSJQMYE#DZSJNCYE#DZSJQMYE#TTSJ#JMSJ#DJSJ1#ZTSJ#DJSJ#DCLSSSJ#SSSJHX";
		colsLName[13] = "�ϼ�#һ����ͨ�������#1.½·�������#2.ˮ·�������#3.�����������#4.�ܵ��������#������������#1.�����ձ����#2.�����������#3.������������#�������ŷ���#1.�������ŷ���#2.��ֵ���ŷ���#�ġ���������#1.���̷���#2.��װ����#3.���ɷ���#4.װ�η���#5.������������#�塢���ڷ���#1.�������#2.ֱ���շѽ��ڷ���#3.���շ���#4.������Ʒת��#�����ִ�����#1.�з��ͼ�������#2.��Ϣ��������#3.�Ļ��������#4.������������#5.���޷���#6.��֤��ѯ����#7.�㲥Ӱ�ӷ���#8.����������#9.�����ִ�����#�ߡ��������#1.�Ļ���������#2.����ҽ�Ʒ���#3.�������ַ���#4.����ס�޷���#5.�����ճ�����#6.�����������#�ˡ����������ʲ�#1.ר�����ר������#2.�̱������Ȩ#3.����ʹ��Ȩ#4.������Ȼ��Դʹ��Ȩ#5.����Ȩ���������ʲ�#�š����۲�����#1.������#���У����ַ�����#2.������#���У����ַ�����";
		colsHName[13] = "���#��Ŀ#���˰��#Ӧ��˰��������#Ӧ��˰����ĩ���#����˰��������#����˰����ĩ���#����˰��#����˰��#���˰��#��;˰��#����˰��#��������ʧ˰��#��ʧ˰�����";

		sjNum[14] = 3;
		colsL[14] = "HJ#QZBNXQ#WNCQ#GTJKKQYQS#1GNZZS#QZGZZZS#2GNXFS#3YYS#4QYSDS#5GRSDS#6ZYS#7CSWHJSS#8FCS#9YHS#10CZTDSYS#11TDZZS#12CCS#13CLGZS#14YYS#15GDZYS#16QS#17HJBHS#18QTSS";
		colsH[14] = "XH#XM#QMYEHJ#DFXQJRK#DFXQJDJ#DFXQJHX#DFXQJQMYE#ZFXQJRK#ZFXQJDJ#ZFXQJHX#ZFXQJQMYE#GFXQJRK#GFXQJDJ#GFXQJHX#GFXQJQMYE#GWQJRK#GWQJDJ#GWQJHX#GWQJQMYE1#GWQJQMYE2";
		colsLName[14] = "�ϼ�#���У�������Ƿ#�����Ƿ#��ͣ���տ���ҵǷ˰#1.������ֵ˰#���У�������ֵ˰#2.��������˰#3.Ӫҵ˰#4.��ҵ����˰#5.��������˰#6.��Դ˰#7.����ά������˰#8.����˰#9.ӡ��˰#10.��������ʹ��˰#11.������ֵ˰#12.����˰#13.��������˰#14.��Ҷ˰#15.����ռ��˰#16.��˰#17.��������˰#18.����˰��";
		colsHName[14] = "���#��Ŀ#��ĩ���ϼ�#�ͷ���Ƿ�����#�ͷ���Ƿ�ɵֽ�#�ͷ���Ƿ�ɺ���#�ͷ���Ƿ����ĩ���#�з���Ƿ�����#�з���Ƿ�ɵֽ�#�з���Ƿ�ɺ���#�з���Ƿ����ĩ���#�߷���Ƿ�����#�߷���Ƿ�ɵֽ�#�߷���Ƿ�ɺ���#�߷���Ƿ����ĩ���#��ΣǷ�����#��ΣǷ�ɵֽ�#��ΣǷ�ɺ���#��ΣǷ����ĩ���#��ΣǷ����ĩ���";


		sjNum[1501] =3;
		colsL[1501] = "1HJ#2YNLMYY#3ECKY#41MTKCHXXY#5YMHWYMKCXX#6HMKCXX#7QT#82SYHTRQKCY#9SYKC#10TRQKC#113HSJSKCXY#12TKCX#13MKGKCX#14QT#154YSJSKCXY#16CYYSJSKCX#17GJSKCX#18XYXTJSKCX#195FJSKCXY#20TSSKC#21HXKKC#22CY#23SMJQT#246KCZYJFZXHD#25MTKCHXXZYJFZXHD#26SYHTRQKCZYJFZXHD#27QT#287QTCKY#29SZZY#301NFSPJGY#31GWMZ#32SLJG#33ZWYJG#34ZTY#35TZJRLJG#36SCPJG#37��SCJLSGHJGJG#38��QT#392SPZZY#40BKSPZZ#41TGQKLJMJZZ#42FBSPZZ#43RZPZZ#44GTSPZZ#45DWPFJZPZZ#46��QT#473JYLHJZCZZY#48JDZZ#49JJZZ#50BJZZ#51PJZZ#52HJZZ#53PTJZZ#54QT#55YLZZ#56JZCJG#574YCZPY#58YYFK#59JYZZ#60QT#615FZY#62MFZJYRJJG#63MFZJRZJJG#64MFZJRZJJG#65SJFZJYRJJG#66HXZZJYRJJG#67ZZHGZBZWJQZPZZ#68��JYFZZCPZZ#69��CYYFZZCPZZ#706FZFZFSY#71JZFZZZ#72ZZHGZBZFZZZ#73FSZZ#747PGMPYMJQZPHZXY#75PGZZJG#76PGZPZZ#77MPZZJZPJG#78YMRJGJZPZZ#79ZXY";
		colsH[1501] = "XH#XM#SSSRHJ#GNZZS#QZYBNSRZZS#GNXFS#YYS#QYSDSNZQY#QYSDSWZQY#GRSDS#ZYS#CSWHJSS#FCS#YHS#CZTDSYS#TDZZS#CLGZS#CCS#GDZYS#QS#HJBHS#QTGS";
		colsLName[1501] = "�ϼ�#һ��ũ���֡�������ҵ#�����ɿ�ҵ#1.ú̿���ɺ�ϴѡҵ#����ú������ú����ϴѡ#�ں�ú����ϴѡ#������#2.ʯ�ͺ���Ȼ������ҵ#��ʯ�Ϳ���#����Ȼ������#3.��ɫ�������ѡҵ#�������ѡ#���̿󡢸����ѡ#������#4.��ɫ�������ѡҵ#�ٳ�����ɫ�������ѡ#�ڹ�������ѡ#��ϡ��ϡ���������ѡ#5.�ǽ������ѡҵ#����ɰʯ����#�ڻ�ѧ�󿪲�#�۲���#��ʯ�޼�����#6.����רҵ�������Ի#��ú̿���ɺ�ϴѡרҵ�������Ի#��ʯ�ͺ���Ȼ������רҵ�������Ի#������#7.�����ɿ�ҵ#��������ҵ#1.ũ��ʳƷ�ӹ�ҵ#�ٹ���ĥ��#�����ϼӹ�#��ֲ���ͼӹ�#������ҵ#�����׼�����ӹ�#��ˮ��Ʒ�ӹ�#���߲ˡ����ࡢˮ���ͼ���ӹ�#������#2.ʳƷ����ҵ#�ٱ���ʳƷ����#���ǹ����ɿ������۽�����#�۷���ʳƷ����#������Ʒ����#�ݹ�ͷʳƷ����#�޵�ζƷ��������Ʒ����#������#3.�ơ����Ϻ;��Ʋ�����ҵ#�پƵ�����#�ƾ�����#�׾�����#ơ������#�ƾ�����#���Ѿ�����#����#����������#�۾��Ʋ�ӹ�#4.�̲���Ʒҵ#����Ҷ����#�ھ�������#������#5.��֯ҵ#���޷�֯��ӡȾ���ӹ�#��ë��֯��Ⱦ�����ӹ�#�����֯��Ⱦ�����ӹ�#��˿���֯��ӡȾ���ӹ�#�ݻ���֯�켰ӡȾ���ӹ�#����֯�����֯�Ｐ����Ʒ����#�߼��÷�֯�Ƴ�Ʒ����#���ҵ�÷�֯�Ƴ�Ʒ����#6.��֯��װ������ҵ#�ٻ�֯��װ����#����֯�����֯��װ����#�۷�������#7.Ƥ�ëƤ����ë������Ʒ����Ьҵ#��Ƥ�����Ƽӹ�#��Ƥ����Ʒ����#��ëƤ���Ƽ���Ʒ�ӹ�#����ë(��)�ӹ�����Ʒ����#����Ьҵ";
		colsHName[1501] = "���#��Ŀ#˰������ϼ�#������ֵ˰#���У�һ����˰����ֵ˰#��������˰#Ӫҵ˰#��ҵ����˰������ҵ#��ҵ����˰������ҵ#��������˰#��Դ˰#����ά������˰#����˰#ӡ��˰#��������ʹ��˰#������ֵ˰#��������˰#����˰#����ռ��˰#��˰#��������˰#������˰";




		sjNum[1502] =3;
		colsL[1502] = "8MCJGHMZTZCZPY#MCJG#RZBZZ#MZZPZZ#ZTZCDZPZZ#9JJZZY#MZJJZZ#ZTJJZZ#JSJJZZ#SLJJZZ#QT#10ZZHZZPY#ZJZZ#ZZ#ZZPZZ#11YSHJLMJFZY#YS#ZDJYSXGFW#JLMJFZ#12WJGMTYHYLYPZZY#WJBGYPZZ#LQZZ#GYMSJLYYPZZ#TYYPZZ#WJZZ#YYQCJYLYPZZ#13SYMTJQTRLJGY#JLSYCPZZ#QZYYJGJSYZPZZ#MTJG#HRLJG#SWZRLJG#14HXYLHHXZPZZY#JCHXYLZZ#FLZZ#NYZZ#TLYMYLJLSCPZZ#HCCLZZ#ZYHXCPZZ#QZWHYXXHXPZZ#YXSCYXXHXPZZ#ZYHGJYHCPZZ#RYHXCPZZ#15YYZZY#HXYPYLYZZ#HXYPZJZZ#ZYYPJG#ZCYSC#SYYPZZ#SWYPZPZZ#QZSWYPZZ#JYGCYWHYMZZ#WSCLJYYYPZZ#YYFLJBZCL#16HXXWZZY#XWSXWYLJXWZZ#HCXWZZ#SWJCLZZ#17XJHSLZPY#XJZPY#SLZPY#18FJSKWZPY#SNSHHSGZZ#SNZZ#SHHSGZZ#SGSNZPJLSZPZZ#QZSNZPZZ#ZWSCDJZCLZZ#BLZZ#BLZPZZ#BLXWHBLXWZQSLZPZZ#TCZPZZ#NHCLZPZZ#SMJQT#19HSJSYLHYYJGY#LT#LG#GYYJG#THJYL#20YSJSYLHYYJGY#CYYSJSYL#GJSYL#XYXTJSYL#YSJSHJZZ#YSJSYYJG";
		colsH[1502] = "XH#XM#SSSRHJ#GNZZS#QZYBNSRZZS#GNXFS#YYS#QYSDSNZQY#QYSDSWZQY#GRSDS#ZYS#CSWHJSS#FCS#YHS#CZTDSYS#TDZZS#CLGZS#CCS#GDZYS#QS#HJBHS#QTGS";
		colsLName[1502] = "8.ľ�ļӹ���ľ�����ز���Ʒҵ#��ľ�ļӹ�#�����������#��ľ����Ʒ����#�����١��ء��ݵ���Ʒ����#9.�Ҿ�����ҵ#��ľ�ʼҾ�����#�����ټҾ�����#�۽����Ҿ�����#�����ϼҾ�����#������#10.��ֽ��ֽ��Ʒҵ#��ֽ������#����ֽ#��ֽ��Ʒ����#11.ӡˢ�ͼ�¼ý�鸴��ҵ#��ӡˢ#��װ����ӡˢ��ط���#�ۼ�¼ý�鸴��#12.�Ľ̡�������������������Ʒ����ҵ#���Ľ̰칫��Ʒ����#����������#�۹���������������Ʒ����#��������Ʒ����#���������#���������ļ�������Ʒ����#13.ʯ�͡�ú̿������ȼ�ϼӹ�ҵ#�پ���ʯ�Ͳ�Ʒ����#����:ԭ�ͼӹ���ʯ����Ʒ����#��ú̿�ӹ�#�ۺ�ȼ�ϼӹ�#��������ȼ�ϼӹ�#14.��ѧԭ�Ϻͻ�ѧ��Ʒ����ҵ#�ٻ�����ѧԭ������#�ڷ�������#��ũҩ����#��Ϳ�ϡ���ī�����ϼ����Ʋ�Ʒ����#�ݺϳɲ�������#��ר�û�ѧ��Ʒ����#���У��Ļ�����Ϣ��ѧƷ����#ҽѧ��������Ϣ��ѧƷ����#��ըҩ���𹤼�����Ʒ����#�����û�ѧ��Ʒ����#15.ҽҩ����ҵ#�ٻ�ѧҩƷԭ��ҩ����#�ڻ�ѧҩƷ�Ƽ�����#����ҩ��Ƭ�ӹ�#���г�ҩ����#������ҩƷ����#������ҩƷ��Ʒ����#���У�����ҩƷ����#���򹤳�ҩ�����������#���������ϼ�ҽҩ��Ʒ����#��ҩ�ø��ϼ���װ����#16.��ѧ��ά����ҵ#����ά����άԭ�ϼ���ά����#�ںϳ���ά����#���������������#17.�𽺺�������Ʒҵ#������Ʒҵ#��������Ʒҵ#18.�ǽ���������Ʒҵ#��ˮ�ࡢʯ�Һ�ʯ������#ˮ������#ʯ�Һ�ʯ������#��ʯ�ࡢˮ����Ʒ��������Ʒ����#����:ˮ����Ʒ����#��ש�ߡ�ʯ�ĵȽ�����������#�ܲ�������#�ݲ�����Ʒ����#�޲�����ά�Ͳ�����ά��ǿ������Ʒ����#���մ���Ʒ����#���ͻ������Ʒ����#��ʯī������#19.��ɫ����ұ����ѹ�Ӽӹ�ҵ#������#������#�۸�ѹ�Ӽӹ�#�����Ͻ�ұ��#20.��ɫ����ұ����ѹ�Ӽӹ�ҵ#�ٳ�����ɫ����ұ��#�ڹ����ұ��#��ϡ��ϡ������ұ��#����ɫ�����Ͻ�����#����ɫ����ѹ�Ӽӹ�";
		colsHName[1502] = "���#��Ŀ#˰������ϼ�#������ֵ˰#���У�һ����˰����ֵ˰#��������˰#Ӫҵ˰#��ҵ����˰������ҵ#��ҵ����˰������ҵ#��������˰#��Դ˰#����ά������˰#����˰#ӡ��˰#��������ʹ��˰#������ֵ˰#��������˰#����˰#����ռ��˰#��˰#��������˰#������˰";




		sjNum[1503] =3;
		colsL[1503] = "16521JSZPY#166JGXJSZPZZ#167JSGJZZ#168JZXJJSBZRQZZ#169JSSSJQZPZZ#170JZAQYJSZPZZ#171JSBMCLJRCLJG#172TCZPZZ#173JSZRYPZZ#174ZZJQTJSZPZZ#175QZHSJSZZ#176YSJSZZ#17722TYSBZZY#178GLJYDSBZZ#179JSJGJXZZ#180WLBYSBZZ#181BFMYSJJLSJXZZ#182ZCCLHCDBJZZ#183HLFJBZDSBZZ#184WHBGYJXZZ#185QZFYHJYSBZZ#186JSQJHBZYSBZZ#187TYLBJZZ#188QT#189QZGYJQRZZ#190TSZYJQRZZ#19123ZYSBZZY#192CKYJJZZYSBZZ#193HGMCFJSJGZYSBZZ#194SPYLYCJSLSCZYSBZZ#195YSZYRHJRYPSCZYSBZZ#196FZFZHPGJGZYSBZZ#197DZHDGJXZYSBZZ#198QZBDTQJZYSBZZ#199DZYQJYJDZJSBZZ#200QTDZZYSBZZ#201NLMYZYJXZZ#202YLYQSBJQXZZ#203HBYZSHGGFWJQTZYSBZZ#20424QCZZY#205QCZCZZ#206QZXNYCZCZZ#207QCYFDJZZ#208GZQCZZ#209DSQCZZ#210DCZZ#211QCCSGCZZ#212QCLBJJPJZZ#21325TLCBHKHTHQTYSSBZZY#214TLYSSBZZ#215QZGTCZZZ#216GTSBPJZZ#217CSGDJTSBZZ#218CBJXGZZZZ#219HKHTQJSBZZ#220FJZZ#221HTQJYZHJZZ#222HTXGSBZZ#223HKXGSBZZ#224QTHKHTQZZ#225MTCZZ#226ZXCHCJRZCZZ#227ZLCZZ#228FGLXXCJLPJZZ#229QSJLJQT#23026DQJXHQCZZY#231DJZZ#232FDJJFDJZZZ#233DDJZZ#234WTDJJZJZZ#235QTDJZZ#236SPDJKZSBZZ#237BYQZLQHDGQZZ#238DRQJQPTSBZZ#239PDKGKZSBZZ#240DLDZYQJZZ#241GFSBJYQJZZ#242QT#243DXDLGLJDGQCZZ#244DXDLZZ#245GXZZ#246GLZZ#247JYZPZZ#248QT#249DCZZ#250QZZLZDCZZ#251JYDLQJZZ#252FDLJYQJZZ#253ZMQJZZ#254QZZNZMQJZZ#255QT#25627JSJTXHQTDZSBZZY#257JSJZZ#258JSJZJZZ#259JSJLBJZZ#260JSJWWSBZZ#261GYKZJSJJXTZZ#262XXAQSBZZ#263QT";
		colsH[1503] = "XH#XM#SSSRHJ#GNZZS#QZYBNSRZZS#GNXFS#YYS#QYSDSNZQY#QYSDSWZQY#GRSDS#ZYS#CSWHJSS#FCS#YHS#CZTDSYS#TDZZS#CLGZS#CCS#GDZYS#QS#HJBHS#QTGS";
		colsLName[1503] = "21.������Ʒҵ#�ٽṹ�Խ�����Ʒ����#�ڽ�����������#�ۼ�װ�估������װ��������#�ܽ���˿��������Ʒ����#�ݽ�������ȫ�ý�����Ʒ����#�޽������洦���ȴ���ӹ�#���´���Ʒ����#�����������Ʒ����#�����켰����������Ʒ����#���У���ɫ��������#��ɫ��������#22.ͨ���豸����ҵ#�ٹ�¯��ԭ���豸����#�ڽ����ӹ���е����#�����ϰ����豸����#�ܱá����š�ѹ���������ƻ�е����#����С����ֺʹ�����������#�޺�¯���������װ���豸����#���Ļ����칫�û�е����#���У���ӡ�ͽ�ӡ�豸����#������������ר���豸����#��ͨ���㲿������#������#���У���ҵ����������#������ҵ����������#23.ר���豸����ҵ#�ٲɿ�ұ�𡢽���ר���豸����#�ڻ�����ľ�ġ��ǽ����ӹ�ר���豸����#��ʳƷ�����ϡ��̲ݼ���������ר���豸����#��ӡˢ����ҩ���ջ�������Ʒ����ר���豸����#�ݷ�֯����װ��Ƥ��ӹ�ר���豸����#�޵��Ӻ͵繤��еר���豸����#���У��뵼������ר���豸����#����Ԫ�������������豸����#��������ר���豸����#��ũ���֡�������ר�û�е����#��ҽ�������豸����е����#�ỷ������������ṫ����������ר���豸����#24.��������ҵ#��������������#���У�����Դ����������#�������÷���������#�۸�װ��������#�ܵ�����������#�ݵ糵����#�����������ҳ�����#�������㲿�����������#25.��·�����������պ�������������豸����ҵ#����·�����豸����#����:������������#�����豸���������#�ڳ��й����ͨ�豸����#�۴��������װ������#�ܺ��ա����������豸����#�ɻ�����#�����������ػ������#��������豸����#��������豸����#�������պ���������#��Ħ�г�����#�����г��Ͳм�����������#������������#��ǹ�·���г������������#��Ǳˮ���̼�����#26.������е����������ҵ#�ٵ������#������������������#�綯������#΢�ص�����������#�����������#������缰�����豸����#��ѹ�����������͵��������#���������������豸����#��翪�ؿ����豸����#��������Ԫ��������#����豸��Ԫ��������#����#�۵��ߡ����¡����¼��繤��������#���ߡ���������#��������#��������#��Ե��Ʒ����#����#�ܵ������#���У�����ӵ������#�ݼ��õ�����������#�޷ǵ���������������#��������������#���У�����������������#������#27.�������ͨ�ź����������豸����ҵ#�ټ��������#�������������#������㲿������#�������Χ�豸����#��ҵ���Ƽ������ϵͳ����#��Ϣ��ȫ�豸����#����";
		colsHName[1503] = "���#��Ŀ#˰������ϼ�#������ֵ˰#���У�һ����˰����ֵ˰#��������˰#Ӫҵ˰#��ҵ����˰������ҵ#��ҵ����˰������ҵ#��������˰#��Դ˰#����ά������˰#����˰#ӡ��˰#��������ʹ��˰#������ֵ˰#��������˰#����˰#����ռ��˰#��˰#��������˰#������˰";

		sjNum[1504] =3;
		colsL[1504] = "264TXSBZZ#265TXXTSBZZ#266TXZDSBZZ#267GBDSSBZZ#268LDJPTSBZZ#269FZYSTSBZZ#270ZNXFSBZZ#271QZKCDZNSBZZ#272ZNCZSBZZ#273ZNWRFXQZZ#274FWXFJQRZZ#275QTZNXFSBZZ#276DZQJZZ#277DZYJJDZZYCLZZ#278QT#27928YBYQZZY#280TYYQYBZZ#281ZYYQYBZZ#282ZBYJSYQZZ#283GXYQZZ#284HQZZ#285QT#28629QTZZY#287RYZPZZ#288HFSJG#289QT#29030FQZYZHLYY#291JSFLHSXJGCL#292FJSFLHSXJGCL#29331JSZPJXHSBXLY#294JSZPXL#295TYSBXL#296ZYSBXL#297TLCBHKHTDYSSBXL#298QZHKHTQXL#299DQSBXL#300YQYBXL#301QT#302SDLRLRQJSDSCHGYY#3031DLRLSCHGYY#304DLSC#305HLFD#306RDLC#307SLFD#308HLFD#309FLFD#310TYNFD#311SWZNFD#312QT#313DLGY#314RLSCHGYY#3152RQSCHGYY#3163SDSCHGYY#317ZLSSCHGY#318WSCLJQZSLY#319HSDHCL#320QT#321WJZY#3221FWJZY#323ZZFWJZ#324TYCGJZ#325QTFWJZY#3262TMGCJZY#327TLDLSDHQLGCJZ#328TLGCJZ#329GLGCJZ#330SZDLGCJZ#331CSGDJTGCJZ#332QT#333SLHSYGCJZ#334SYJGSSSGCJZ#335HHZLJFHSSGCJZ#336GKJHYSSGCJZ#337HYGCJZ#338GKGCJZ#339JXHGDGCJZ#340JNHBGCSG#341DLGCSG#342QT#3433JZAZY#344DQAZ#345GDHSBAZ#346QT#3474JZZSZXHQTJZY#348JZZSHZXY#349JZWCCHCDZBHD#350TGSGSBFW#351QT#352LPFHLSY#3531PFY#354NLMYCPPF#355SPYLJYCZPPF#356QZYCZPPF";
		colsH[1504] = "XH#XM#SSSRHJ#GNZZS#QZYBNSRZZS#GNXFS#YYS#QYSDSNZQY#QYSDSWZQY#GRSDS#ZYS#CSWHJSS#FCS#YHS#CZTDSYS#TDZZS#CLGZS#CCS#GDZYS#QS#HJBHS#QTGS";
		colsLName[1504] = "��ͨ���豸����#ͨ��ϵͳ�豸����#ͨ���ն��豸����#�۹㲥�����豸����#���״Ｐ�����豸����#�ݷ�רҵ�����豸����#�����������豸����#����:�ɴ��������豸����#���ܳ����豸����#�������˷���������#�������ѻ���������#�������������豸����#�ߵ�����������#�����Ԫ��������ר�ò�������#������#28.�Ǳ���������ҵ#��ͨ�������Ǳ�����#��ר�������Ǳ�����#���ӱ����ʱ��������#�ܹ�ѧ��������#�ݺ�������#������#29.��������ҵ#��������Ʒ����#�ں˷���ӹ�#������#30.������Դ�ۺ�����ҵ#�ٽ������Ϻ���м�ӹ�����#�ڷǽ������Ϻ���м�ӹ�����#31.������Ʒ����е���豸����ҵ#�ٽ�����Ʒ����#��ͨ���豸����#��ר���豸����#����·�����������պ���������豸����#���У����պ���������#�ݵ����豸����#�������Ǳ�����#������#�ġ�������������ȼ����ˮ�������͹�Ӧҵ#1.���������������͹�Ӧҵ#�ٵ�������#��������#�ȵ�����#ˮ������#��������#��������#̫���ܷ���#�������ܷ���#����#�ڵ�����Ӧ#�����������͹�Ӧҵ#2.ȼ�������͹�Ӧҵ#3.ˮ�������͹�Ӧҵ#������ˮ�����͹�Ӧ#����ˮ��������������#�ۺ�ˮ��������#������#�塢����ҵ#1.���ݽ���ҵ#��סլ���ݽ���#���������ݽ���#���������ݽ���ҵ#2.��ľ���̽���ҵ#����·����·��������������̽���#��·���̽���#��·���̽���#������·���̽���#���й����ͨ���̽���#����#��ˮ����ˮ�˹��̽���#ˮԴ����ˮ��ʩ���̽���#�Ӻ�����������ʩ���̽���#�ۿڼ�������ʩ���̽���#�ۺ��󹤳̽���#�ܹ��󹤳̽���#�ݼ��ߺ͹ܵ����̽���#�޽��ܻ�������ʩ��#�ߵ�������ʩ��#������#3.������װҵ#�ٵ�����װ#�ڹܵ����豸��װ#������#4.����װ�Ρ�װ�޺���������ҵ#�ٽ���װ�κ�װ��ҵ#�ڽ��������ͳ���׼���#���ṩʩ���豸����#������#��������������ҵ#1.����ҵ#��ũ���֡��������Ʒ����#��ʳƷ�����ϼ��̲���Ʒ����#����:�̲���Ʒ����";
		colsHName[1504] = "���#��Ŀ#˰������ϼ�#������ֵ˰#���У�һ����˰����ֵ˰#��������˰#Ӫҵ˰#��ҵ����˰������ҵ#��ҵ����˰������ҵ#��������˰#��Դ˰#����ά������˰#����˰#ӡ��˰#��������ʹ��˰#������ֵ˰#��������˰#����˰#����ռ��˰#��˰#��������˰#������˰";


		sjNum[1505] =3;
		colsL[1505] = "357FZFZJJTYPPF#358WHTYYPJQCPF#359YYJYLQCPF#360KCPJCJHGCPPF#361MTJZPPF#362SYJQZPPF#363FJSKJZPPF#364JSJJSKPF#365JCPF#366HFPF#367NYPF#368NYBMPF#369QT#370JXSBWJCPJDZCPPF#371NYJXPF#372QCJLPJPF#373MTCJLPJPF#374WJCPPF#375DQSBPF#376JSJRJJFZSBPF#377TXSBPF#378GBYSSBPF#379QT#380MYJJYDL#381QTPFY#382QZZSWZHSYPF#383HLWPF#3842LSY#385ZHLS#386SPYLJYCZPZMLS#387FZFZJRYPZMLS#388WHTYYPJQCZMLS#389YYJYLQCZMLS#390QCMTCRLJLPJZMLS#391QCXCLS#392QCJCLS#393QCLPJLS#394MTCJLPJLS#395JDCRYLS#396JDCRQLS#397JDCCDXS#398JYDQJDZCPZMLS#399JYSTSBLS#400RYJDLS#401JSJRJJFZSBLS#402TXSBLS#403QT#404WJJJJSNZSCLZMLS#405HTWDPJQTLSY#406QZHLWLS#407QJTYSCCHYZY#4081TLYSY#409TLLKYS#410TLHWYS#411TLYSFZHD#4122DLYSY#413CSGGJTYS#414GLLKYS#415DLHWYS#416DLYSFZHD#4173SSYSY#418SSLKYS#419HSLKYS#420NHLKYS#421KYLDYS#422SSHWYS#423YYHWYS#424YHHWYS#425NHHWYS#426SSYSFZHD#4274HKYSY#428HKKHYS#429HKLKYS#430HKHWYS#431TYHKFW#432HKYSFZHD#4335GDYSY#4346DSLYHYSDLY#435DSLY#436YSDLY#4377ZXBYHCCY#438QZZXBY#4398YZY#440YZJBFW#441KDFW";
		colsH[1505] = "XH#XM#SSSRHJ#GNZZS#QZYBNSRZZS#GNXFS#YYS#QYSDSNZQY#QYSDSWZQY#GRSDS#ZYS#CSWHJSS#FCS#YHS#CZTDSYS#TDZZS#CLGZS#CCS#GDZYS#QS#HJBHS#QTGS";
		colsLName[1505] = "�۷�֯����װ����ͥ��Ʒ����#���Ļ���������Ʒ����������#��ҽҩ��ҽ����������#�޿��Ʒ�����ļ�������Ʒ����#ú̿����Ʒ����#ʯ�ͼ�����Ʒ����#�ǽ�������Ʒ����#����������������#��������#��������#ũҩ����#ũ�ñ�Ĥ����#����#�߻�е�豸������Ʒ�����Ӳ�Ʒ����#ũҵ��е����#���������������#Ħ�г������������#����Ʒ����#�����豸����#�����������������豸����#ͨѶ�豸����#�㲥Ӱ���豸����#����#��ó�׾��������#����������ҵ#����:�������ʻ���������#����������#2.����ҵ#���ۺ�����#��ʳƷ�����ϼ��̲���Ʒר������#�۷�֯����װ������Ʒר������#���Ļ���������Ʒ������ר������#��ҽҩ��ҽ������ר������#��������Ħ�г���ȼ�ϼ������ר������#�����³�����#�����ɳ�����#�������������#Ħ�г������������#������ȼ������#������ȼ������#�������������#�߼��õ��������Ӳ�Ʒר������#���������豸����#���üҵ�����#�����������������豸����#ͨ���豸����#����#����𡢼Ҿ߼�����װ�β���ר������#���̯���޵��̼���������ҵ#����:����������#�ߡ���ͨ���䡢�ִ�������ҵ#1.��·����ҵ#����·�ÿ�����#����·��������#����·���丨���#2.��·����ҵ#�ٳ��й�����ͨ����#�ڹ�·�ÿ�����#�۵�·��������#�ܵ�·���丨���#3.ˮ������ҵ#��ˮ���ÿ�����#�����ÿ�����#�ں��ÿ�����#�����ֶ�����#��ˮ�ϻ�������#Զ���������#�غ���������#�ںӻ�������#��ˮ�����丨���#4.��������ҵ#�ٺ��տͻ�����#�����ÿ�����#���ջ�������#��ͨ�ú��շ���#�ۺ������丨���#5.�ܵ�����ҵ#6.��ʽ���˺��������ҵ#�ٶ�ʽ����#���������ҵ#7.װж���˺Ͳִ�ҵ#���У�װж����#8.����ҵ#��������������#�ڿ�ݷ���";
		colsHName[1505] = "���#��Ŀ#˰������ϼ�#������ֵ˰#���У�һ����˰����ֵ˰#��������˰#Ӫҵ˰#��ҵ����˰������ҵ#��ҵ����˰������ҵ#��������˰#��Դ˰#����ά������˰#����˰#ӡ��˰#��������ʹ��˰#������ֵ˰#��������˰#����˰#����ռ��˰#��˰#��������˰#������˰";


		sjNum[1506] =3;
		colsL[1506] = "442BZSHCYY#4431ZSY#444LYFD#445YBLG#446MSFW#447LYDFW#448QT#4492CYY#450ZCFW#451KCFW#452YLJLYFW#453CYPSJWMSCFW#454QT#455JXXCSRJHXXJSFWY#4561DXGBDSHWXCSFW#457DX#458GDDXFW#459YDDXFW#460QT#461GBDSCSFW#462WXCSFW#4632HLWHXGFW#464HLWJRJXGFW#465HLWXXFW#466HLWPT#467QZHLWSCFWPT#468HLWSHFWPT#469HLWKJCXPT#470HLWGGFWPT#471QTHLWPT#472HLWAQFW#473HLWSJFW#474QT#4753RJHXXJSFWY#476RJKF#477JCDLSJ#478XXXTJCHWLWJSFW#479QZXXXTJCFW#480WLWJSFW#481YXWHFW#482XXCLHCCZCFW#483XXJSZXFW#484SZNRFW#485QTXXJSFWY#486SJRY#4871HBJRFW#488ZYYXFW#489HBYXFW#490FHBYXFW#491RZZLFW#492CWGS#493DD#494QCJRGSFW#495XEDKGSFW#496XFJRGSFW#497WLJDFW#498QT#499YXLCFW#500YXJGFW#5012ZBSCFW#502ZQSCFW#503ZQSCGLFW#504ZQJJJYFW#505GKMJZQTZJJ#506FGKMJZQTZJJ#507QZ��CYTZJJ#508TSTZ#509QHSCFW#510ZQQHJGFW#511ZBTZFW#512QT#5133BXY#514RSBX#515CCBX#516ZBX#517SYYLJ#518BXZJFW#519BXZCGL#520BXJGFW#521QT#5224QTJRY#523JRXTYGLFW#524KGGSFW#525FJRJGZFFW#526JRXXFW#527JRZCGLGS#528QT#529SYFDCY#5301FDCKFJY#5312WYGL#5323FDCZJFW#5334FDCZLJY#5345QTFDCY";
		colsH[1506] = "XH#XM#SSSRHJ#GNZZS#QZYBNSRZZS#GNXFS#YYS#QYSDSNZQY#QYSDSWZQY#GRSDS#ZYS#CSWHJSS#FCS#YHS#CZTDSYS#TDZZS#CLGZS#CCS#GDZYS#QS#HJBHS#QTGS";
		colsLName[1506] = "�ˡ�ס�޺Ͳ���ҵ#1.ס��ҵ#�����η���#��һ���ù�#�����޷���#��¶Ӫ�ط���#������#2.����ҵ#�����ͷ���#�ڿ�ͷ���#�����ϼ���������#�ܲ������ͼ������Ͳͷ���#������#�š���Ϣ���䡢�������Ϣ��������ҵ#1.���š��㲥���Ӻ����Ǵ������#�ٵ���#�̶����ŷ���#�ƶ����ŷ���#����#�ڹ㲥���Ӵ������#�����Ǵ������#2.����������ط���#�ٻ��������뼰��ط���#�ڻ�������Ϣ����#�ۻ�����ƽ̨#���У���������������ƽ̨#�������������ƽ̨#�������Ƽ�����ƽ̨#��������������ƽ̨#����������ƽ̨#�ܻ�������ȫ����#�ݻ��������ݷ���#������#3.�������Ϣ��������ҵ#���������#�ڼ��ɵ�·���#����Ϣϵͳ���ɺ���������������#���У���Ϣϵͳ���ɷ���#��������������#������ά������#����Ϣ����ʹ洢֧�ַ���#����Ϣ������ѯ����#���������ݷ���#��������Ϣ��������ҵ#ʮ������ҵ#1.���ҽ��ڷ���#���������з���#�ڻ������з���#�۷ǻ������з���#�������޷���#����˾#�䵱#�������ڹ�˾����#С����˾����#���ѽ��ڹ�˾����#����������#����#��������Ʒ���#�����м�ܷ���#2.�ʱ��г�����#��֤ȯ�г�����#֤ȯ�г��������#֤ȯ���ͽ��׷���#�ڹ���ļ��֤ȯͶ�ʻ���#�۷ǹ���ļ��֤ȯͶ�ʻ���#���У���ҵͶ�ʻ���#��ʹͶ��#���ڻ��г�����#��֤ȯ�ڻ���ܷ���#���ʱ�Ͷ�ʷ���#������#3.����ҵ#��������#�ڲƲ�����#���ٱ���#����ҵ���Ͻ�#�ݱ����н����#�ޱ����ʲ�����#�߱��ռ�ܷ���#������#4.��������ҵ#�ٽ���������������#�ڿعɹ�˾����#�۷ǽ��ڻ���֧������#�ܽ�����Ϣ����#�ݽ����ʲ�����˾#������#ʮһ�����ز�ҵ#1.���ز�������Ӫ#2.��ҵ����#3.���ز��н����#4.���ز����޾�Ӫ#5.�������ز�ҵ";
		colsHName[1506] = "���#��Ŀ#˰������ϼ�#������ֵ˰#���У�һ����˰����ֵ˰#��������˰#Ӫҵ˰#��ҵ����˰������ҵ#��ҵ����˰������ҵ#��������˰#��Դ˰#����ά������˰#����˰#ӡ��˰#��������ʹ��˰#������ֵ˰#��������˰#����˰#����ռ��˰#��˰#��������˰#������˰";


		sjNum[1507] =3;
		colsL[1507] = "535SEZLHSWFWY#5361ZLY#537JXSBZL#538QCZL#539NYJXZL#540JZGCJXYSBZL#541JSJJTXSBZL#542YYSBJYZL#543QT#544WTSBHYPCZ#545RYPCZ#5462SWFWY#547ZZGLFW#548QYZBGL#549TZYZCGL#550ZYYCQJYFW#551DWHQGLFW#552NCJTJJZZGL#553QT#554ZHGLFW#555FLFW#556LSJXGFLFW#557GZFW#558QT#559ZXYDC#560QZHJSJJSWFW#561SCDC#562GGY#563QZHLWGG#564RLZYFW#565AQBHFW#566HYZLJXGFW#567QZKJHZFW#568QT#569LXSJXGFW#570BZFW#571BGFW#572FYFW#573XYFW#574FRZDBFW#575SWDLDBFW#576PWDLFW#577QT#578SSKXYJHJSFWY#5791YJHSYFZ#580ZRKXYJHSYFZ#581GCHJSYJHSYFZ#582NYKXYJHSYFZ#583YXYJHSYFZ#584SHRWKXYJ#5852ZYJSFWY#586QXFW#587DZFW#588HYFW#589CHDLXXFW#590ZJJSFW#591HJYSTJCJCFW#592DZKC#593GCJSYSJFW#594GYYZYSJJQT#5953KJTGHYYFWY#596JSTGFW#597QZSWJSTGFW#598XCLJSTGFW#599JNJSTGFW#600XNYJSTGFW#601HBJSTGFW#602SW3DDYJSTGFW#603QT#604ZSCQFW#605KJZJFW#606CYKJFW#607QT#608SSSLHJHGGSSGLY#6091SLGLY#610QZSZYGL#6112STBHHHJZLY#612STBH#613HJZLY#6143GGSSGLY#615SZSSGL#616HJWSGL#617CXSRGL#618LHGL#619CSGYGL#620YLJQGL#6214TDGLY#622TDZZFW#623TDDCPGFW#624TDDJFW#625TDDJDLFW#626QTTDGLFW";
		colsH[1507] = "XH#XM#SSSRHJ#GNZZS#QZYBNSRZZS#GNXFS#YYS#QYSDSNZQY#QYSDSWZQY#GRSDS#ZYS#CSWHJSS#FCS#YHS#CZTDSYS#TDZZS#CLGZS#CCS#GDZYS#QS#HJBHS#QTGS";
		colsLName[1507] = "ʮ�������޺��������ҵ#1.����ҵ#�ٻ�е�豸����#��������#ũҵ��е����#�������̻�е���豸����#�������ͨѶ�豸����#ҽҩ�豸��Ӫ����#����#�������豸����Ʒ����#������Ʒ����#2.�������ҵ#����֯�������#��ҵ�ܲ�����#Ͷ�����ʲ�����#��Դ���Ȩ���׷���#��λ���ڹ������#ũ�弯�徭����֯����#����#���ۺϹ������#�۷��ɷ���#��ʦ����ط��ɷ���#��֤����#����#����ѯ�����#����:��ơ���Ƽ�˰�����#�г�����#�ݹ��ҵ#���У����������#��������Դ����#�߰�ȫ��������#����顢չ������ط���#���У��Ƽ���չ����#������#�����缰��ط���#��װ����#�칫����#�������#���÷���#�����ʵ�������#�������������#Ʊ��������#����#ʮ������ѧ�о��ͼ�������ҵ#1.�о������鷢չ#����Ȼ��ѧ�о������鷢չ#�ڹ��̺ͼ����о������鷢չ#��ũҵ��ѧ�о������鷢չ#��ҽѧ�о������鷢չ#��������Ŀ�ѧ�о�#2.רҵ��������ҵ#���������#�ڵ������#�ۺ������#�ܲ�������Ϣ����#���ʼ켼������#�޻�������̬��������#�ߵ��ʿ���#�๤�̼�������Ʒ���#�Ṥҵ��רҵ��Ƽ�����#3.�Ƽ��ƹ��Ӧ�÷���ҵ#�ټ����ƹ����#���У����＼���ƹ����#�²��ϼ����ƹ����#���ܼ����ƹ����#����Դ�����ƹ����#���������ƹ����#��ά��3D����ӡ�����ƹ����#����#��֪ʶ��Ȩ����#�ۿƼ��н����#�ܴ�ҵ�ռ����#������#ʮ�ġ�ˮ���������͹�����ʩ����ҵ#1.ˮ������ҵ#����:ˮ��Դ����#2.��̬�����ͻ�������ҵ#����̬����#�ڻ�������ҵ#3.������ʩ����ҵ#��������ʩ����#�ڻ�����������#�۳������ݹ���#���̻�����#�ݳ��й�԰����#��������������#4.���ع���ҵ#���������η���#�����ص�����������#�����صǼǷ���#�����صǼǴ������#���������ع������";
		colsHName[1507] = "���#��Ŀ#˰������ϼ�#������ֵ˰#���У�һ����˰����ֵ˰#��������˰#Ӫҵ˰#��ҵ����˰������ҵ#��ҵ����˰������ҵ#��������˰#��Դ˰#����ά������˰#����˰#ӡ��˰#��������ʹ��˰#������ֵ˰#��������˰#����˰#����ռ��˰#��˰#��������˰#������˰";


		sjNum[1508] =3;
		colsL[1508] = "627SWJMFWXLHQTFWY#6281JMFWY#629JTFW#630TESFW#631XRFW#632LFJMRFW#633XYHBJYSFW#634SYKYFW#635HYFW#636ZZFW#637QT#6382JDCDZCPHRYCPXLY#639QCMTCXLYWH#640QCXLYWH#641MTCXLYWH#642JSJHBGSBWX#643JYDQXL#644QT#6453QTFWY#646QJFW#647CWFW#648QT#649SLJY#6501XQJY#6512CDJY#6523ZDJY#653QZZYCZJY#654ZDZYXXJY#6554GDJY#656QZPTGDJY#6575TSJY#6586JNPXJYFZJQT#659QZZYJNPX#660SQWSHSHGZ#6611WS#662YY#663ZHYY#664ZYYY#665ZXYJHYY#666MZYY#667ZKYY#668LYY#669JCYLWSFW#670ZYGGWSFW#671QZJBYFKZZX#672ZKJBFZYSZ#673FYBJYSZ#674JHSYJSFWHD#675QT#6762SHGZ#677SBWHTYHYLY#6781XWHCBY#679XWY#680CBY#6812GBDSDYHYSLYZZY#682GB#683DS#684YSJMZZ#685GBDSJCBK#686DYHYSJMFX#687DYFY#688LYZZ#6893WHYSY#690WYCZYBY#691YSBYCG#692TSGYDAG#693WWJFWZWHYCBH#694BWG#695LSLYJNG#696QZWHHD#697QT#6984TY#699TYZZ#700TYCDSSGL#701JSXXHD#702QTTY#7035YLY#704SNYLHD#705YLY#706XXGGHD#707CPHD#708WHYLTYHDHJJDLFW#709QT#710SJGGGLSHBZHSHZZ#711ESQTXY";
		colsH[1508] = "XH#XM#SSSRHJ#GNZZS#QZYBNSRZZS#GNXFS#YYS#QYSDSNZQY#QYSDSWZQY#GRSDS#ZYS#CSWHJSS#FCS#YHS#CZTDSYS#TDZZS#CLGZS#CCS#GDZYS#QS#HJBHS#QTGS";
		colsLName[1508] = "ʮ�塢��������������������ҵ#1.�������ҵ#�ټ�ͥ����#���ж�������#��ϴȾ����#���������ݷ���#��ϴԡ�ͱ�����������#����Ӱ��ӡ����#�߻�������#���������#������#2.�����������Ӳ�Ʒ�����ò�Ʒ����ҵ#��������Ħ�г�������ά��#����������ά��#Ħ�г�������ά��#�ڼ�����Ͱ칫�豸ά��#�ۼ��õ�������#������#3.��������ҵ#��������#�ڳ������#������#ʮ��������#1.ѧǰ����#2.���Ƚ���#3.�еȽ���#���У�ְҵ���н���#�е�ְҵѧУ����#4.�ߵȽ���#���У���ͨ�ߵȽ���#5.�������#6.������ѵ����������������#���У�ְҵ������ѵ#ʮ�ߡ���������Ṥ��#1.����#��ҽԺ#�ۺ�ҽԺ#��ҽҽԺ#����ҽ���ҽԺ#����ҽԺ#ר��ҽԺ#����Ժ#�ڻ���ҽ����������#��רҵ������������#���У�����Ԥ����������#ר�Ƽ�������Ժ������վ��#���ױ���Ժ������վ��#�ƻ�������������#������#2.��Ṥ��#ʮ�ˡ��Ļ�������������ҵ#1.���źͳ���ҵ#������ҵ#�ڳ���ҵ#2.�㲥�����ӡ���Ӱ��Ӱ��¼������ҵ#�ٹ㲥#�ڵ���#��Ӱ�ӽ�Ŀ����#�ܹ㲥���Ӽ��ɲ���#�ݵ�Ӱ��Ӱ�ӽ�Ŀ����#�޵�Ӱ��ӳ#��¼������#3.�Ļ�����ҵ#�����մ��������#���������ݳ���#��ͼ����뵵����#�����Ｐ�������Ļ��Ų�����#�ݲ����#����ʿ��԰�������#��Ⱥ���Ļ��#������#4.����#��������֯#������������ʩ����#�۽������л#����������#5.����ҵ#���������ֻ#������԰#�����й۹�#�ܲ�Ʊ�#���Ļ�����������;��ʹ������#������#ʮ�š�����������ᱣ�Ϻ������֯#��ʮ��������ҵ";
		colsHName[1508] = "���#��Ŀ#˰������ϼ�#������ֵ˰#���У�һ����˰����ֵ˰#��������˰#Ӫҵ˰#��ҵ����˰������ҵ#��ҵ����˰������ҵ#��������˰#��Դ˰#����ά������˰#����˰#ӡ��˰#��������ʹ��˰#������ֵ˰#��������˰#����˰#����ռ��˰#��˰#��������˰#������˰";


		sjNum[16] = 2;
		colsL[16] = "HJ#YNZQY#YGYQY#EJTQY#SGFHZQY#SLYQY#QZGYKG1#1GYLYQY#2JTLYQY#3GYYJTLYQY#4QTLYQY#WYXZRGS#QZGYKG2#1GYDZQY#2QTYXZRGS#LGFYXGS#QZGYKG3#QSYQY#1SYDZQY#2SYHHQY#3SYYXZRGS#4SYGFYXGS#BQTQY#EGATSTZQY#QZGYKG4#1HZJYQYGHATZ#2HZJYQYGHATZ#3GATSDZJYQY#4GATSTZGFYXGS#5QTGATSTZQY#SWSTZQY#QZGYKG5#1ZWHZJYQY#2ZWHZJYQY#3WZQY#4WSTZGFYXGS#5QTWSTZQY#SGTJY#1GTH#2GRHH";
		colsH[16] = "XH#XM#SSSRHJ#GNZZS#QZYBNSR#GNXFS#YYS#QYSDS#GRSDS#ZYS#CSWHJSS#FCS#YHS#CZTDSYS#TDZZS#CCS#CLGZS#GDZYS#QS#HJBHS#QTSS";
		colsLName[16] = "�ϼ�#һ��������ҵ#(һ)������ҵ#(��)������ҵ#(��)�ɷݺ�����ҵ#(��)��Ӫ��ҵ#����:���пع�#1.������Ӫ��ҵ#2.������Ӫ��ҵ#3.�����뼯����Ӫ��ҵ#4.������Ӫ��ҵ#(��)�������ι�˾#����:���пع�#1.���ж�����ҵ#2.�����������ι�˾#(��)�ɷ����޹�˾#����:���пع�#(��)˽Ӫ��ҵ#1.˽Ӫ������ҵ#2.˽Ӫ�ϻ���ҵ#3.˽Ӫ�������ι�˾#4.˽Ӫ�ɷ����޹�˾#(��)������ҵ#�����ۡ��ġ�̨��Ͷ����ҵ#����:���пع�#1.���ʾ�Ӫ��ҵ���ۻ�ġ�̨�ʣ�#2.������Ӫ��ҵ���ۻ�ġ�̨�ʣ�#3.�ۡ��ġ�̨�̶��ʾ�Ӫ��ҵ#4.�ۡ��ġ�̨��Ͷ�ʹɷ����޹�˾#5.�����ۡ��ġ�̨��Ͷ����ҵ#��������Ͷ����ҵ#����:���пع�#1.������ʾ�Ӫ��ҵ#2.���������Ӫ��ҵ#3.������ҵ#4.����Ͷ�ʹɷ����޹�˾#5.��������Ͷ����ҵ#�ġ����徭Ӫ#1.���廧#2.���˺ϻ�";
		colsHName[16] = "���#��Ŀ#˰������ϼ�#������ֵ˰#���У�һ����˰��#��������˰#Ӫҵ˰#��ҵ����˰#��������˰#��Դ˰#����ά������˰#����˰#ӡ��˰#��������ʹ��˰#������ֵ˰#����˰#��������˰#����ռ��˰#��˰#��������˰#����˰��";

		sjNum[1701] = 3;
		colsL[1701] = "YZZSSRHJ#YGNZZS#1CKY#1MTKCHXXY#2SYHTRQKCY#QZYY#3HSJSKCXY#4YSJSKCXY#5FJSKCXY#6QTCKY#2ZZY#1NFSPJGY#2SPZZY#3JYLHJZCZZY#JDZZ#QZJJ#YLZZ#JZCZZ#4YCZPY#YYFK#JYZZ#QTYCZPZZ#5FZY#6FZFZFSY#QZJZFZZZ#7PGMPYMJQZPHZXY#QZPGMP#8MCJGJMZTZCZPY#9JJZZY#10ZZJZZPY#ZJZZ#ZZ#QZJZZJZBZZ#ZZPZZ#11YSHJLMJFZY#12WJGMTYHYLYPZZY#13SYMTJQTRLJGY#JLSYCPZZ#QZCPY#MTJG#HRLJG#SWZRLJG#14HXYLJHXZPY#FLZZ#NYZZ#ZYHXCPZZ#RYHXCPZZ#QZHZPZZ#QT1#15YYZZY#16HXXWZZY#17XJHSLZPY#QZLTZZ#18FJSKWZPY#SNSHHSGZZ#QZSNZZ#SNJSGZPZZ#BLJBLZPZZ#QT2#19HSJSYLJYYJGY#QZGYYJG#20YSJSYLJYYJGY#21JSZPY#22TYSBZZY#23ZYSBZZY#24QCZZY#QZQCZCZZ#DCZZ#25TLCBHKHTHQTYSSBZZY#QZTLYSSBZZ#CBJXGZZZZ#HKHTJSBZZ#MTCZZ#26DQJXHQCZZY#DJZZ#DXDLGLJDGQCZZ#JYDLQJZZ#QT#27JSJTXHQTDZSBZZY#JSJZZ#TXSBZZ#GBDSSBZZ#FZYSTSBZZ#ZNXFSBZZ#QT3#28YBYQZZY#29QTZZY";
		colsH[1701] = "XH#XM#HJ#QZMDDK#NZQYXJ#NZQYGYQY#NZQYJTQY#NZQYGFHZQY#NZQYLYQY#NZQYQZGYKG1#NZQYGFGS#NZQYQZGYKG#NZQYSYQY#NZQYQTQY#GATTZQY#QZGYKG11#WSTZQY#QZGYKG#GTJY";
		colsLName[1701] = "һ����ֵ˰����ϼ�#(һ)������ֵ˰#1.�ɿ�ҵ#��1��ú̿���ɺ�ϴѡҵ#��2��ʯ�ͺ���Ȼ������ҵ#���У�ԭ��#��3����ɫ�������ѡҵ#��4����ɫ�������ѡҵ#��5���ǽ������ѡҵ#��6�������ɿ�ҵ#2.����ҵ#��1��ũ��ʳƷ�ӹ�ҵ#��2��ʳƷ����ҵ#��3���ơ����Ϻ;��Ʋ�����ҵ#�پƵ�����#���У��ƾ�#����������#�۾��Ʋ�����#��4���̲���Ʒҵ#����Ҷ����#�ھ�������#�������̲���Ʒ����#��5����֯ҵ#��6����֯��װ������ҵ#���У���֯��װ����#��7��Ƥ�ëƤ����ë������Ʒ����Ьҵ#���У�Ƥ�ëƤ#��8��ľ�ļӹ���ľ�����ز���Ʒҵ#��9���Ҿ�����ҵ#��10����ֽ��ֽ��Ʒҵ#��ֽ������#����ֽ#���У�����ֽ��ֽ������#��ֽ��Ʒ����#��11��ӡˢ�ͼ�¼ý�鸴��ҵ#��12���Ľ̡�������������������Ʒ����ҵ#��13��ʯ�͡�ú̿������ȼ�ϼӹ�ҵ#�پ���ʯ�Ͳ�Ʒ����#���У���Ʒ��#��ú̿�ӹ�#�ۺ�ȼ�ϼӹ�#��������ȼ�ϼӹ�#��14����ѧԭ�ϼ���ѧ��Ʒҵ#�ٷ�������#��ũҩ����#��ר�û�ѧ��Ʒ����#�����û�ѧ��Ʒ����#���У���ױƷ����#������#��15��ҽҩ����ҵ#��16����ѧ��ά����ҵ#��17���𽺺�������Ʒҵ#���У���̥����#��18���ǽ���������Ʒҵ#��ˮ�ࡢʯ�Һ�ʯ������#���У�ˮ������#��ˮ�༰ʯ����Ʒ����#�۲�����������Ʒ����#������#��19����ɫ����ұ����ѹ�Ӽӹ�ҵ#���У���ѹ�Ӽӹ�#��20����ɫ����ұ����ѹ�Ӽӹ�ҵ#��21��������Ʒҵ#��22��ͨ���豸����ҵ#��23��ר���豸����ҵ#��24����������ҵ#���У�������������#�糵����#��25����·�����������պ�������������豸����ҵ#���У���·�����豸����#���������װ������#���ա����켰�豸����#Ħ�г�����#��26��������е����������ҵ#�ٵ������#�ڵ��ߵ��¹��¼��繤��������#�ۼ��õ�����������#������#��27���������ͨ�ź����������豸����ҵ#�ټ��������#��ͨ���豸����#�۹㲥�����豸����#�ܷ�רҵ�����豸����#�����������豸����#������#��28���Ǳ���������ҵ#��29����������ҵ";
		colsHName[1701] = "���#��Ŀ#�ϼ�#����:��ֵ���#������ҵС��#������ҵ������ҵ#������ҵ������ҵ#������ҵ�ɷݺ�����ҵ#������ҵ��Ӫ��ҵ#������ҵ���У����пع�#������ҵ�ɷݹ�˾#������ҵ���У����пع�#������ҵ˽Ӫ��ҵ#������ҵ������ҵ#�۰�̨Ͷ����ҵ#���У����пع�#����Ͷ����ҵ#���У����пع�#���徭Ӫ";

		sjNum[1702] = 3;
		colsL[1702] = "3DLRLRQJSDSCHGYY#1DLRLSCHGYY#DLSC#QZHLFD#RDLC#SLFD#HLFD#FLFD#TYNFD#DLGY#RLSCHGY#2RQSCHGYY#3SDSCHGYY#4PFHLSY#1PFY#SPYLJYCZPPF#QZYCZPPF#FZFZJJTYPPF#KCPJCJHGCPPF#QZMTJZPPF#SYJZPPF#JCPF#JXSBWJJDJDZCPPF#QZQCPFJLPJPF#MTCJLPJPF#DQSBPF#JSJRJJFZSBPF#QT12#2LSY#5JTYSCCHYZY#1TLYSY#2DLYSY#3SSYSY#4HKYSY#5GDYSY#6DSLYHYSDLY#7ZXBYHCCY#8YZY#6ZSHCYY#1ZSY#2CYY#7XXCSRJHXXJSFWY#1DXGBDSHWXCSFWY#QZDX#2HLWHXGFW#3RJHXXJSFWY#8JRY#1HBJRFW#QZYX#JRZL#2ZBSCFW#3BXY#4QTJRY#9FDCY#1FDCKFJYY#2WYGL#3FDCZJFW#4FDCZLJY#5QTFDCY#10ZLHSWFWY#1ZLY#2SWFWY#QZZXYDC#GGY#11KXYJHJSFWY#1YJHSYFZ#2ZYJSFWY#3KJTGHYYFWY#12JMFWXLHQTFWY#QZJMFWY#JDCDZCPHRYCPXLY#13JY#14WSHSHGZ#QZWS#15WHTYHYLY#QZXWHCBY#GBDSDYHYSLYZZY#TY#YLY#16GGGLSHBZHSHZZ#17JZY#1FWJZY#2TMGCJZY#3JZAZY#4JZZSZXHQTJZY#18SLHJHGGSSGLY#QZGGSSGLY#19QTXY#EJKHWZZS#ECKTZZSH#";
		colsH[1702] = "XH#XM#HJ#QZMDDK#NZQYXJ#NZQYGYQY#NZQYJTQY#NZQYGFHZQY#NZQYLYQY#NZQYQZGYKG1#NZQYGFGS#NZQYQZGYKG#NZQYSYQY#NZQYQTQY#GATTZQY#QZGYKG11#WSTZQY#QZGYKG#GTJY";
		colsLName[1702] = "3.������������ȼ����ˮ�������͹�Ӧҵ#��1�����������������͹�Ӧҵ#�ٵ�������#���У���������#�ȵ�����#ˮ������#��������#��������#̫���ܷ���#�ڵ�����Ӧ#�����������͹�Ӧ#��2��ȼ�������͹�Ӧҵ#��3��ˮ�������͹�Ӧҵ#4.����������ҵ#(1)����ҵ#��ʳƷ�����ϼ��̲���Ʒ����#����:�̲���Ʒ����#�ڷ�֯����װ����ͥ��Ʒ����#�ۿ��Ʒ�����ļ�������Ʒ����#���У�ú̿����Ʒ����#ʯ�ͼ���Ʒ����#��������#�ܻ�е�豸����𽻵缰���Ӳ�Ʒ����#���У��������������������#Ħ�г������������#�����豸����#�����������������豸����#������#��2)����ҵ#5.��ͨ���䡢�ִ�������ҵ#1.��·����ҵ#2.��·����ҵ#3.ˮ������ҵ#4.��������ҵ#5.�ܵ�����ҵ#6.��ʽ���˺��������ҵ#7.װж���˺Ͳִ�ҵ#8.����ҵ#6.ס�޺Ͳ���ҵ#��1��ס��ҵ#��2������ҵ#7.��Ϣ���䡢�������Ϣ��������ҵ#��1�����š��㲥���Ӻ����Ǵ������ҵ#���У�����#��2������������ط���#��3���������Ϣ��������ҵ#8.����ҵ#��1�����ҽ��ڷ���#���У�����#��������#��2���ʱ��г�����#��3������ҵ#��4����������ҵ#9.���ز�ҵ#��1�����ز�������Ӫҵ#��2����ҵ����#��3�����ز��н����#��4�����ز����޾�Ӫ#��5���������ز�ҵ#10.���޺��������ҵ#��1������ҵ#��2���������ҵ#���У���ѯ�����#���ҵ#11.��ѧ�о��ͼ�������ҵ#��1���о���ʵ�鷢չ#��2��רҵ��������ҵ#��3���Ƽ��ƹ��Ӧ�÷���ҵ#12.��������������������ҵ#���У��������ҵ#�����������Ӳ�Ʒ�����ò�Ʒ����ҵ#13.����#14.��������Ṥ��#���У�����#15.�Ļ�������������ҵ#���У����źͳ���ҵ#�㲥�����ӡ���Ӱ��Ӱ��¼������ҵ#����#����ҵ#16.����������ᱣ�Ϻ������֯#17.����ҵ#��1�����ݽ���ҵ#��2����ľ���̽���ҵ#��3��������װҵ#��4������װ�Ρ�װ�޺���������ҵ#18.ˮ���������͹�����ʩ����ҵ#���У�������ʩ����ҵ#19.������ҵ#���������ڻ�����ֵ˰#������������ֵ˰�ϼ�";
		colsHName[1702] = "���#��Ŀ#�ϼ�#����:��ֵ���#������ҵС��#������ҵ������ҵ#������ҵ������ҵ#������ҵ�ɷݺ�����ҵ#������ҵ��Ӫ��ҵ#������ҵ���У����пع�#������ҵ�ɷݹ�˾#������ҵ���У����пع�#������ҵ˽Ӫ��ҵ#������ҵ������ҵ#�۰�̨Ͷ����ҵ#���У����пع�#����Ͷ����ҵ#���У����пع�#���徭Ӫ";

		sjNum[18] = 3;
		colsL[18]="YXFSSR#YGNXFS#1JJJJ#1BJ#2HJ#3PJ#4QTJ#5JJ#2Y#1GYJY#QZA56SLZS#A36SLZS#2XQY#3YS#4SYPFJY#3CPY#1QY#2CY#3SNY#4RJY#5RHY#6RLY#7HKMY#4XQC#1CYC#A1SLZS#A3SLZS#A5SLZS#A9SLZS#A12SLZS#A25SLZS#A40SLZS#2ZQXSYKC#3CHHXQC#5MTC#6GEFQJQJ#7QCLT#8GDHZP#9GZSS#10BPYH#11GDSB#12YT#13MZYCXKZ#14SMDB#15DC#16TL#17QT#18SKZNJFKSR#EJKXFPXFS#ECKXFPTXF";
		colsH[18]="XH#XM#HJ#NZQYXJ#NZQYGYQY#NZQYJTQY#NZQYGFHZQY#NZQYLYQY#NZQYQZGYKG1#NZQYGFGS#NZQYQZGYKG2#NZQYSYQY#NZQYQTQY#GATTZQY#QZGYKG1#WSTZQY#QZGYKG2#GTJY";
		colsLName[18] = "һ������˰����#(һ)��������˰#1.�Ƽ��ƾ�#(1)�׾�#(2)�ƾ�#(3)ơ��#(4)������#(5)�ƾ�#2.��#(1)��ҵ����#���У���56%˰������#��36%˰������#(2)ѩ����#(3)��˿#(4)��ҵ��������#3.��Ʒ��#(1)����#(2)����#(3)ʯ����#(4)�ܼ���#(5)����#(6)ȼ����#(7)����ú��#4.С����#(1)���ó�#��1%˰������#��3%˰������#��5%˰������#��9%˰������#��12%˰������#��25%˰������#��40%˰������#(2)���������ÿͳ�#(3)������С����#5.Ħ�г�#6.�߶��������#7.������̥#8.�ߵ���ױƷ#9.��������#10.�������#11.�ߵ��ֱ�#12.��ͧ#13.ľ��һ���Կ���#14.ʵľ�ذ�#15.���#16.Ϳ��#17.����#18.˰�����ɽ𷣿�����#(��)��������Ʒ����˰#������������Ʒ������˰";
		colsHName[18] = "���#��Ŀ#�ϼ�#������ҵС��#������ҵ������ҵ#������ҵ������ҵ#������ҵ�ɷݺ�����ҵ#������ҵ��Ӫ��ҵ#������ҵ���У����пع�#������ҵ�ɷݹ�˾#������ҵ���У����пع�#������ҵ˽Ӫ��ҵ#������ҵ������ҵ#�۰�̨Ͷ����ҵ#���У����пع�#����Ͷ����ҵ#���У����пع�#���徭Ӫ";

		sjNum[1901] = 3;
		colsL[1901] = "HJ#YCKY#1MTKCHXXY#2SYHTRQKCY#QZYY#3HSJSKCXY#4YSJSKCXY#5FJSKCXY#6QTCKY#EZZY#1NFSPJGY#2SPZZY#3JYLHJZCZZY#JDZZ#QZJJ#YLZZ#JZCZZ#4YCZPY#YYFK#JYZZ#QTYCZPJG#5FZY#6FZFZFSY#QZFZFZ#7PGMPYMJQZPHZXY#QZPGMP#8MCJGHMZTZCZPY#9JJZZY#10ZZHZZPY#ZJZZ#ZZ#QZJZZJZBZZ#ZZPZZ#11YSHJLMJFZY#12WJGMTYHYLYPZZY#13SYMTJQTRLJGY#QZCPY#14HXYLHHXZPZZY#FLZZ#NYZZ#ZYHXCPZZ#RYHXCPZZ#QZHZPZZ#QT1#15YYZZY#16HXXWZZY#17XJHSLZPY#QZLTZZ#18FJSKWZPY#SNSHHSGZZ#QZSNZZ#SNJSGZPZZ#BLJBLZPZZ#QT2#19HSJSYLHYYJGY#QZGYYJG#20YSJSYLHYYJGY#21JSZPY#22TYSBZZY#23ZYSBZZY#24QCZZY#25TLCBHKHTHQTYSSBZZY#QZTLYSSBZZ#CBJXGZZZZ#HKHTJSBZZ#MTCZZ#26DQJXHQCZZY#DJZZ#DXDLGLJDGQCZZ#JYDLQJZZ#QT3#27JSJTXHQTDZSBZZY#JSJZZ#TXSBZZ#GBDSSBZZ#FZYSTSBZZ#ZNXFSBZZ#QT4#28YBYQZZY#29QTZZY#SDLRLRQJSDSCHGYY#1DLRLSCHGYY#DLSC#QZHLFD#RDLC#SLFD#HLFD#FLFD#TYNFD#DLGY#RLSCHGYY#2RQSCHGYY#3SDSCHGYY";
		colsH[1901] = "XH#XM#HJ#NZQYXJ#NZQYGYQY#NZQYJTQY#NZQYGFHZQY#NZQYLYQY#NZQYQZGYKG1#NZQYGFGS#NZQYQZGYKG2#NZQYSYQY#NZQYQTQY#GATTZQY#QZGYKG1#WSTZQY#QZGYKG2";
		colsLName[1901] = "�ϼ�#(һ)�ɿ�ҵ#1.ú̿���ɺ�ϴѡҵ#2.ʯ�ͺ���Ȼ������ҵ#����:ԭ��#3.��ɫ�������ѡҵ#4.��ɫ�������ѡҵ#5.�ǽ������ѡҵ#6.�����ɿ�ҵ#(��)����ҵ#1.ũ��ʳƷ�ӹ�ҵ#2.ʳƷ����ҵ#3.�ơ����Ϻ;��Ʋ�����ҵ#�پƵ�����#���У��ƾ�#����������#�۾��Ʋ�����#4.�̲���Ʒҵ#��Ҷ����#��������#�����̲���Ʒ�ӹ�#5.��֯ҵ#6.��֯��װ������ҵ#���У���֯��װ#7.Ƥ�ëƤ����ë������Ʒ����Ьҵ#���У�Ƥ�ëƤ#8.ľ�ļӹ���ľ�����ز���Ʒҵ#9.�Ҿ�����ҵ#10.��ֽ��ֽ��Ʒҵ#��ֽ������#����ֽ#���У�����ֽ��ֽ������#��ֽ��Ʒ����#11.ӡˢ�ͼ�¼ý�鸴��ҵ#12.�Ľ̡�������������������Ʒ����ҵ#13.ʯ�͡�ú̿������ȼ�ϼӹ�ҵ#���У���Ʒ��#14.��ѧԭ�Ϻͻ�ѧ��Ʒ����ҵ#�ٷ�������#��ũҩ����#��ר�û�ѧ��Ʒ����#�����û�ѧ��Ʒ����#���У���ױƷ����#������#15.ҽҩ����ҵ#16.��ѧ��ά����ҵ#17.�𽺺�������Ʒҵ#���У���̥����#18.�ǽ���������Ʒҵ#��ˮ�ࡢʯ�Һ�ʯ������#���У�ˮ������#��ˮ�༰ʯ����Ʒ����#�۲�����������Ʒ����#������#19.��ɫ����ұ����ѹ�Ӽӹ�ҵ#���У���ѹ�Ӽӹ�#20.��ɫ����ұ����ѹ�Ӽӹ�ҵ#21.������Ʒҵ#22.ͨ���豸����ҵ#23.ר���豸����ҵ#24.��������ҵ#25.��·�����������պ�������������豸����ҵ#���У���·�����豸����#���������װ������#���ա����켰�豸����#Ħ�г�����#26.������е����������ҵ#�ٵ������#�ڵ��ߵ��¹��¼��繤��������#�ۼ��õ�����������#������#27.�������ͨ�ź����������豸����ҵ#�ټ��������#��ͨ���豸����#�۹㲥�����豸����#�ܷ�רҵ�����豸����#�����������豸����#������#28.�Ǳ���������ҵ#29.��������ҵ#(��)������������ȼ����ˮ�������͹�Ӧҵ#1.���������������͹�Ӧҵ#�ٵ�������#���У���������#�ȵ�����#ˮ������#��������#��������#̫���ܷ���#�ڵ�����Ӧ#�����������͹�Ӧҵ#2.ȼ�������͹�Ӧҵ#3.ˮ�������͹�Ӧҵ";
		colsHName[1901] = "���#��Ŀ#�ϼ�#������ҵС��#������ҵ������ҵ#������ҵ������ҵ#������ҵ�ɷݺ�����ҵ#������ҵ��Ӫ��ҵ#������ҵ���У����пع�#������ҵ�ɷݹ�˾#������ҵ���У����пع�#������ҵ˽Ӫ��ҵ#������ҵ������ҵ#�۰�̨Ͷ����ҵ#���У����пع�#����Ͷ����ҵ#���У����пع�";

		sjNum[1902] = 3;
		colsL[1902] = "SJZY#1FWJZY#2TMGCJZY#3JZAZY#4JZZSZXHQTJZY#WPFHLSY#1PFY#QZYCZPPF#MTJZPPF#SYJQZPPF#QCJLPJPF#2LSY#LJTYSCCHYZY#1TLYSY#2DLYSY#3SSYSY#4HKYSY#5GDYSY#6DSLYHYSDLY#7ZXBYHCCY#8YZY#QZSHCYY#1ZSY#2CYY#BXXCSRJHXXJSFWY#1DXGBDSHWXCSFWY#QZDX#2HLWHXGFW#3RJHXXJSFWY#JJRY#1HBJRFW#QZYX#JRZL#2ZBSCFW#3BXY#4QTJRY#SFDCY#SYZLHSWFWY#1ZLY#2SWFWY#SEKXYJHJSFWY#SSJMFWXLHQTFWY#QZJMFWY#JDCDZCPHRYCPXLY#SSJY#SWWSHSHGZ#QZWS#SLWHTYHYLY#QZXWHCBY#GBDSDYHYSLYZZY#TY#YLY#SQGGGLSHBZHSHZZ#SBQTXY";
		colsH[1902] = "XH#XM#HJ#NZQYXJ#NZQYGYQY#NZQYJTQY#NZQYGFHZQY#NZQYLYQY#NZQYQZGYKG1#NZQYGFGS#NZQYQZGYKG2#NZQYSYQY#NZQYQTQY#GATTZQY#QZGYKG1#WSTZQY#QZGYKG2";
		colsLName[1902] = "(��)����ҵ#1.���ݽ���ҵ#2.��ľ���̽���ҵ#3.������װҵ#4.����װ�Ρ�װ�޺���������ҵ#(��)����������ҵ#1.����ҵ#����:�̲���Ʒ����#ú̿����Ʒ����#ʯ�ͼ�����Ʒ����#���������������#2.����ҵ#(��)��ͨ���䡢�ִ�������ҵ#1.��·����ҵ#2.��·����ҵ#3.ˮ������ҵ#4.��������ҵ#5.�ܵ�����ҵ#6.��ʽ���˺��������ҵ#7.װж���˺Ͳִ�ҵ#8.����ҵ#(��)ס�޺Ͳ���ҵ#1.ס��ҵ#2.����ҵ#���ˣ���Ϣ���䡢�������Ϣ��������ҵ#1.���š��㲥���Ӻ����Ǵ������ҵ#���У�����#2.����������ط���#3.�������Ϣ��������ҵ#(��)����ҵ#1.���ҽ��ڷ���#���У�����#��������#2.�ʱ��г�����#3.����ҵ#4.��������ҵ#(ʮ)���ز�ҵ#(ʮһ)���޺��������ҵ#1.����ҵ#2.�������ҵ#(ʮ������ѧ�о��ͼ�������ҵ#��ʮ������������������������ҵ#���У��������ҵ#�����������Ӳ�Ʒ�����ò�Ʒ����ҵ#(ʮ��)����#��ʮ�壩��������Ṥ��#���У�����#(ʮ��)�Ļ�������������ҵ#���У����źͳ���ҵ#�㲥�����ӡ���Ӱ��Ӱ��¼������ҵ#����#����ҵ#(ʮ��)����������ᱣ�Ϻ������֯#(ʮ��)������ҵ";
		colsHName[1902] = "���#��Ŀ#�ϼ�#������ҵС��#������ҵ������ҵ#������ҵ������ҵ#������ҵ�ɷݺ�����ҵ#������ҵ��Ӫ��ҵ#������ҵ���У����пع�#������ҵ�ɷݹ�˾#������ҵ���У����пع�#������ҵ˽Ӫ��ҵ#������ҵ������ҵ#�۰�̨Ͷ����ҵ#���У����пع�#����Ͷ����ҵ#���У����пع�";

		sjNum[20] = 2;
		colsL[20] = "HJ#YCKY#1MTKCHXXY#2SYHTRQKCY#QZYY#3HSJSKCXY#4YSJSKCXY#5FJSKCXY#6QTCKY#EZZY#1NFSPJGY#2SPZZY#3JYLHJZCZZY#JDZZ#QZJJ#YLZZ#JZCZZ#4YCZPY#YYFK#JYZZ#QTYCZPJG#5FZY#6FZFZFSY#QZFZFZ#7PGMPYMJQZPHZXY#QZPGMP#8MCJGHMZTZCZPY#9JJZZY#10ZZHZZPY#ZJZZ#ZZ#QZJZZJZBZZ#ZZPZZ#11YSHJLMJFZY#12WJGMTYHYLYPZZY#13SYMTJQTRLJGY#QZCPY#14HXYLHHXZPZZY#FLZZ#NYZZ#ZYHXCPZZ#RYHXCPZZ#QZHZPZZ#QT1#15YYZZY#16HXXWZZY#17XJHSLZPY#QZLTZZ#18FJSKWZPY#SNSHHSGZZ#QZSNZZ#SNJSGZPZZ#BLJBLZPZZ#QT2#19HSJSYLHYYJGY#QZGYYJG#20YSJSYLHYYJGY#21JSZPY#22TYSBZZY#23ZYSBZZY#24QCZZY#25TLCBHKHTHQTYSSBZZY#QZTLYSSBZZ#CBJXGZZZZ#HKHTJSBZZ#MTCZZ#26DQJXHQCZZY#DJZZ#DXDLGLJDGQCZZ#JYDLQJZZ#QT3#27JSJTXHQTDZSBZZY#JSJZZ#TXSBZZ#GBDSSBZZ#FZYSTSBZZ#ZNXFSBZZ#QT4#28YBYQZZY#29QTZZY#SDLRLRQJSDSCHGYY#1DLRLSCHGYY#DLSC#QZHLFD#RDLC#SLFD#HLFD#FLFD#TYNFD#DLGY#RLSCHGYY#2RQSCHGYY#3SDSCHGYY#SJZY#1FWJZY#2TMGCJZY#3JZAZY#4JZZSZXHQTJZY#WPFHLSY#1PFY#QZYCZPPF#MTJZPPF#SYJQZPPF#QCJLPJPF#2LSY#LJTYSCCHYZY#1TLYSY#2DLYSY#3SSYSY#4HKYSY#5GDYSY#6DSLYHYSDLY#7ZXBYHCCY#8YZY#QZSHCYY#1ZSY#2CYY#BXXCSRJHXXJSFWY#1DXGBDSHWXCSFWY#QZDX#2HLWHXGFW#3RJHXXJSFWY#JJRY#1HBJRFW#QZYX#JRZL#2ZBSCFW#3BXY#4QTJRY#SFDCY#SYZLHSWFWY#1ZLY#2SWFWY#SEKXYJHJSFWY#SSJMFWXLHQTFWY#QZJMFWY#JDCDZCPHRYCPXLY#SSJY#SWWSHSHGZ#QZWS#SLWHTYHYLY#QZXWHCBY#GBDSDYHYSLYZZY#TY#YLY#SQGGGLSHBZHSHZZ#SBQTXY";
		colsH[20] = "XH#XM#HJ#YJ#HSQJ#JNYQNDQS";
		colsLName[20] = "�ϼ�#(һ)�ɿ�ҵ#1.ú̿���ɺ�ϴѡҵ#2.ʯ�ͺ���Ȼ������ҵ#����:ԭ��#3.��ɫ�������ѡҵ#4.��ɫ�������ѡҵ#5.�ǽ������ѡҵ#6.�����ɿ�ҵ#(��)����ҵ#1.ũ��ʳƷ�ӹ�ҵ#2.ʳƷ����ҵ#3.�ơ����Ϻ;��Ʋ�����ҵ#�پƵ�����#���У��ƾ�#����������#�۾��Ʋ�����#4.�̲���Ʒҵ#��Ҷ����#��������#�����̲���Ʒ�ӹ�#5.��֯ҵ#6.��֯��װ������ҵ#���У���֯��װ#7.Ƥ�ëƤ����ë������Ʒ����Ьҵ#���У�Ƥ�ëƤ#8.ľ�ļӹ���ľ�����ز���Ʒҵ#9.�Ҿ�����ҵ#10.��ֽ��ֽ��Ʒҵ#��ֽ������#����ֽ#���У�����ֽ��ֽ������#��ֽ��Ʒ����#11.ӡˢ�ͼ�¼ý�鸴��ҵ#12.�Ľ̡�������������������Ʒ����ҵ#13.ʯ�͡�ú̿������ȼ�ϼӹ�ҵ#���У���Ʒ��#14.��ѧԭ�Ϻͻ�ѧ��Ʒ����ҵ#�ٷ�������#��ũҩ����#��ר�û�ѧ��Ʒ����#�����û�ѧ��Ʒ����#���У���ױƷ����#������#15.ҽҩ����ҵ#16.��ѧ��ά����ҵ#17.�𽺺�������Ʒҵ#���У���̥����#18.�ǽ���������Ʒҵ#��ˮ�ࡢʯ�Һ�ʯ������#���У�ˮ������#��ˮ�༰ʯ����Ʒ����#�۲�����������Ʒ����#������#19.��ɫ����ұ����ѹ�Ӽӹ�ҵ#���У���ѹ�Ӽӹ�#20.��ɫ����ұ����ѹ�Ӽӹ�ҵ#21.������Ʒҵ#22.ͨ���豸����ҵ#23.ר���豸����ҵ#24.��������ҵ#25.��·�����������պ�������������豸����ҵ#���У���·�����豸����#���������װ������#���ա����켰�豸����#Ħ�г�����#26.������е����������ҵ#�ٵ������#�ڵ��ߵ��¹��¼��繤��������#�ۼ��õ�����������#������#27.�������ͨ�ź����������豸����ҵ#�ټ��������#��ͨ���豸����#�۹㲥�����豸����#�ܷ�רҵ�����豸����#�����������豸����#������#28.�Ǳ���������ҵ#29.��������ҵ#(��)������������ȼ����ˮ�������͹�Ӧҵ#1.���������������͹�Ӧҵ#�ٵ�������#���У���������#�ȵ�����#ˮ������#��������#��������#̫���ܷ���#�ڵ�����Ӧ#�����������͹�Ӧҵ#2.ȼ�������͹�Ӧҵ#3.ˮ�������͹�Ӧҵ#(��)����ҵ#1.���ݽ���ҵ#2.��ľ���̽���ҵ#3.������װҵ#4.����װ�Ρ�װ�޺���������ҵ#(��)����������ҵ#1.����ҵ#����:�̲���Ʒ����#ú̿����Ʒ����#ʯ�ͼ�����Ʒ����#���������������#2.����ҵ#(��)��ͨ���䡢�ִ�������ҵ#1.��·����ҵ#2.��·����ҵ#3.ˮ������ҵ#4.��������ҵ#5.�ܵ�����ҵ#6.��ʽ���˺��������ҵ#7.װж���˺Ͳִ�ҵ#8.����ҵ#(��)ס�޺Ͳ���ҵ#1.ס��ҵ#2.����ҵ#���ˣ���Ϣ���䡢�������Ϣ��������ҵ#1.���š��㲥���Ӻ����Ǵ������ҵ#���У�����#2.����������ط���#3.�������Ϣ��������ҵ#(��)����ҵ#1.���ҽ��ڷ���#���У�����#��������#2.�ʱ��г�����#3.����ҵ#4.��������ҵ#(ʮ)���ز�ҵ#(ʮһ)���޺��������ҵ#1.����ҵ#2.�������ҵ#(ʮ������ѧ�о��ͼ�������ҵ#��ʮ������������������������ҵ#���У��������ҵ#�����������Ӳ�Ʒ�����ò�Ʒ����ҵ#(ʮ��)����#��ʮ�壩��������Ṥ��#���У�����#(ʮ��)�Ļ�������������ҵ#���У����źͳ���ҵ#�㲥�����ӡ���Ӱ��Ӱ��¼������ҵ#����#����ҵ#(ʮ��)����������ᱣ�Ϻ������֯#(ʮ��)������ҵ";
		colsHName[20] = "���#��Ŀ#�ϼ�#Ԥ��#�������#������ǰ���Ƿ˰";



		sjNum[21] = 2;
		colsL[21] = "HJ#1GZXJSD#A3SLZS1#A10SLZS2#A20SLZS3#A25SLZS4#A30SLZS5#A35SLZS6#A45SLZS7#2GTGSHSCJYSD#A5SLZS1#A10SLZS11#A20SLZS21#A30SLZS13#A35SLZS14#HDZS12#3QSYDWCBCZJYSD#A5SLZS#A10SLZS#A20SLZS14#A30SLZS15#A35SLZS#HDZS#4LWBCSD#A20SLZS#A30SLZS#A40SLZS#5GCSD#6TXQSYFSD#7LXGXHLSD#QZCXCKLXSD#8CCZLSD#9CCZRSD#QZXSGZRSD#FWZRSD#10ORSD#11QTSD#12SKZNJFKSR";
		colsH[21] = "XH#XM#HJ#DL#GAT#WG";
		colsLName[21] = "�ϼ�#1�����ʡ�н������#��3%˰������#��10%˰������#��20%˰������#��25%˰������#��30%˰������#��35%˰������#��45%˰������#2�����幤�̻���������Ӫ����#��5%˰������#��10%˰������#��20%˰������#��30%˰������#��35%˰������#�˶�����#3������ҵ��λ�а������⾭Ӫ����#��5%˰������#��10%˰������#��20%˰������#��30%˰������#��35%˰������#�˶�����#4�����񱨳�����#��20%˰������#��30%˰������#��40%˰������#5���������#6������Ȩʹ�÷�����#7����Ϣ����Ϣ����������#���У���������Ϣ����#8���Ʋ���������#9���Ʋ�ת������#���У����۹�ת������#����ת������#10��żȻ����#11����������#12��˰�����ɽ𡢷�������";
		colsHName[21] = "���#��Ŀ#�ϼ�#��½#�۰�̨#���";

		sjNum[22] =3 ;
		colsL[22] = "HJ#YNYK#1MT#2YY#3TRQ#4MCCQ#5DR#6QTNYK#EJSK#1TK#2JK#3TK#4LTK#5QXK#6NK#7XK#8ZZXTK#9QXTK#10WK#11ZK#12MK#13YK#14QTJSK#SFJSK#1SM#2GZT#3GLT#4YS#5SHS#6LTK#7LK#8LHJ#9LSJ#10ZT#11SS#12JKY#13HY#14HY#15DXLSSZDY#16KQS#17DLY#18HGY#19NHZT#20MX#21QTFJSK#SSZY#1DBS#2DXS#3ZLS#WQT#LSKZNJFKSR";
		colsH[22] = "XH#XM#HJ#NZQYXJ#NZQYGYQY#NZQYJTQY#NZQYGFHZQY#NZQYLYQY#NZQYQZGYKG1#NZQYGFGS#NZQYQZGYKG2#NZQYSYQY#NZQYQTQY#GATTZQY#QZGYKG3#WSTZQY#QZGYKG4#GTJY";
		colsLName[22] = "�ϼ�#һ����Դ��#1.ú̿#2.ԭ��#3.��Ȼ��#4.ú�㣨�ɣ���#5.����#6.������Դ��#����������#1.����#2.���#3.ͭ��#4.������#5.Ǧп��#6.����#7.����#8.����ϡ����#9.��ϡ����#10.�ٿ�#11.���#12.�̿�#13.����#14.����������#�����ǽ�����#1.ʯī#2.������#3.������#4.өʯ#5.ʯ��ʯ#6.������#7.�׿�#8.�Ȼ���#9.�����#10.ճ��#11.ɰʯ#12.������#13.����#14.����#15.����±ˮɹ�Ƶ���#16.��Ȫˮ#17.������#18.������#19.�ͻ�ճ��#20.â��#21.�����ǽ�����#�ġ�ˮ��Դ#1.�ر�ˮ#2.����ˮ#3.����ˮ#�塢����#����˰�����ɽ𡢷�������";
		colsHName[22] = "���#��Ŀ#�ϼ�#������ҵС��#������ҵ������ҵ#������ҵ������ҵ#������ҵ�ɷݺ�����ҵ#������ҵ��Ӫ��ҵ#������ҵ���У����пع�#������ҵ�ɷݹ�˾#������ҵ���У����пع�#������ҵ˽Ӫ��ҵ#������ҵ������ҵ#�۰�̨Ͷ����ҵ#���У����пع�#����Ͷ����ҵ#���У����пع�#���徭Ӫ";

		sjNum[2301] = 3;
		colsL[2301] = "HJ#YDQWRW#QZHYGC#YEYHL#EDYHW#SYYHT#SLQ#WLHQ#LFHW#QQHQ#BLSW#JGSW#SGJQHHW#SYYBXFC#SESMC#SSBLMC#SSTHC#SWQJQHHW#SLZJQHHW#SQZJQHHW#SBNJQHHW#SJXJQHHW#ESYC#ESYB#ESEJB#ESSEJB#ESSBBaZ#ESWJQ#ESLYQ#ESQBXQ#ESBJC#ESJFL#SSLQY#SSYBAL#SSELBL#SSSXJB#SSSBXZ#SSWLYX#SSLGQ#SSQLHQ#SSBA#SSJSJA#SSJLC#SSYJLM#SSEEJEL#SSSBYX#SSSELHT#SSWQT#ESWRW#QZHYGC1#YDYLSWRW#1ZG#2ZZ#3ZG#4LJG#5ZS#6ZQ#7ZN#8BBaZ#9ZZ#10ZYS#EDELSWRW#1XFWSS#2SHXYLBOD5#3HXXYLCODcr#4ZYJTTOC#5SYL#6DZWY#7HFF#8ZQHW#9LHW#10AD#11FHW#12JQ#13BAL";
		colsH[2301] = "XH#XM#HJ#NZQYXJ#NZQYGYQY1#NZQYJTQY#NZQYGFHZQY#NZQYLYQY#NZQYQZGYKG1#NZQYGFGS#NZQYQZGYKG#NZQYSYQY#NZQYQTQY#GATTZQY#QZGYKG#WSTZQY#QZGYKG1#GTJY";
		colsLName[2301] = "�ϼ�#һ��������Ⱦ��#���У����󹤳�#��һ����������#��������������#������һ����̼#���ģ�����#���壩�Ȼ���#������������#���ߣ��軯��#���ˣ�������#���ţ�������#��ʮ�������仯����#��ʮһ��һ���Է۳�#��ʮ����ʯ�޳�#��ʮ���������޳�#��ʮ�ģ�̼�ڳ�#��ʮ�壩Ǧ���仯����#��ʮ�����Ӽ��仯����#��ʮ�ߣ��뼰�仯����#��ʮ�ˣ������仯����#��ʮ�ţ������仯����#����ʮ���̳�#����ʮһ����#����ʮ�����ױ�#����ʮ�������ױ�#����ʮ�ģ�����(a)��#����ʮ�壩��ȩ#����ʮ������ȩ#����ʮ�ߣ���ϩȩ#����ʮ�ˣ��״�#����ʮ�ţ�����#����ʮ��������#����ʮһ��������#����ʮ�����ȱ���#����ʮ����������#����ʮ�ģ���ϩ��#����ʮ�壩����ϩ#����ʮ��������#����ʮ�ߣ�����#����ʮ�ˣ���#����ʮ�ţ����װ�#����ʮ������#����ʮһ��������#����ʮ�������׶���#����ʮ��������ϩ#����ʮ�ģ�����̼#����ʮ�壩����#����ˮ��Ⱦ��#���У����󹤳�#��һ����һ��ˮ��Ⱦ��#1.�ܹ�#2.����#3.�ܸ�#4.���۸�#5.����#6.��Ǧ#7.����#8.����(a)��#9.����#10.������ˮ��#�������ڶ���ˮ��Ⱦ��#1.������(SS)#2.����������(BOD5)#3.��ѧ������(CODcr)#4.���л�̼��TOC��#5.ʯ����#6.��ֲ����#7.�ӷ���#8.���軯��#9.����#10.����#11.������#12.��ȩ#13.������";
		colsHName[2301] = "���#��Ŀ#�ϼ�#������ҵС��#������ҵ������ҵ#������ҵ������ҵ#������ҵ�ɷݺ�����ҵ#������ҵ��Ӫ��ҵ#������ҵ���У����пع�#������ҵ�ɷݹ�˾#������ҵ���У����пع�#������ҵ˽Ӫ��ҵ#������ҵ������ҵ#�۰�̨Ͷ����ҵ#���У����пع�#����Ͷ����ҵ#���У����пع�#���徭Ӫ";

		sjNum[2302] = 3;
		colsL[2302] = "14XJBL#15YLZBMHXJLAS#16ZT#17ZX#18ZM#19CSXYJCD2#20ZL#21DZLYPJ#22YJLNYYPJ#23LG#24JJDLL#25MLLL#26DLL#27WLFJWLFNYWLFJ#28SLJW#29KXFYJLHWAOXYClJ#30SLHT#31SLYX#32SLYX#33B#34JB#35YB#36LEJB#37DEJB#38JEJB#39LB#40LELB#41DELB#42DXJLB#4324EXJLB#44BF#45JJF#4624ELF#47246SLF#48LBEJSEDZ#49LBEJSEXZ#50BXZ#51ZX#SpHZSDDCJQSYLL#1pHZ#2SD#3DCJQSCB#4YLLYLXDDYYFS#SQXYZYXXQYHDSCY#1QXYZCN#2QXYZCZ#3QXYZCJYDJQ#4XXQY#5YSYLFWY#6YYXDC#7YYXDWS#8YYBXDC#9YYBXDWS#10QTXXPW#SGTFW#QZHYGC#YMZS#EWK#SWXFW#SYLZ#WFMH#LLZ#QHYGCSHLJ#BQTGTFWHBGTYTFW#SZS#YCB13FB#ECB46FB#SCB79FB#SCB1012FB#WCB1315FB#LCB16FBYS#WSKZNJFKSR";
		colsH[2302] = "XH#XM#HJ#NZQYXJ#NZQYGYQY1#NZQYJTQY#NZQYGFHZQY#NZQYLYQY#NZQYQZGYKG1#NZQYGFGS#NZQYQZGYKG#NZQYSYQY#NZQYQTQY#GATTZQY#QZGYKG#WSTZQY#QZGYKG1#GTJY";
		colsLName[2302] = "14.��������#15.�����ӱ�����Լ�(LAS)#16.��ͭ#17.��п#18.����#19.��ɫ��Ӱ��(CD-2)#20.����#21.������(��P��)#22.�л���ũҩ(��P��)#23.�ֹ�#24.�׻�������#25.��������#26.������#27.���ȷӼ����ȷ���(�����ȷӼ�)#28.���ȼ���#29.�������л�±����(AOX)(��Cl��)#30.���Ȼ�̼#31.������ϩ#32.������ϩ#33.��#34.�ױ�#35.�ұ�#36.�ڣ����ױ�#37.�ԣ����ױ�#38.�䣭���ױ�#39.�ȱ�#40.�ڶ��ȱ�#41.�Զ��ȱ�#42.�������ȱ�#43.2,4���������ȱ�#44.����#45.�䣭�׷�#46.2,4�����ȷ�#47.2,4,6-���ȷ�#48.�ڱ����������֬#49.�ڱ����������֬#50.��ϩ��#51.����#������pHֵ��ɫ�ȡ��󳦾�Ⱥ����������#1.pHֵ#2.ɫ��#3.�󳦾�Ⱥ��(����)#4.������(����������ҽԺ��ˮ)#���ģ�������ֳҵ��С����ҵ�͵�����ҵ#1.������ֳ��(ţ)#2.������ֳ��(��)#3.������ֳ��(����Ѽ�ȼ���)#4.С����ҵ#5.��ʳ���ַ���ҵ#6.ҽԺ(����-��)#7.ҽԺ(����-��ˮ)#8.ҽԺ(������-��)#9.ҽԺ(������-��ˮ)#10.����С������#�����������#���У����󹤳�#��һ��ú�ʯ#������β��#������Σ�շ���#���ģ�ұ����#���壩��ú��#������¯��#���ߣ����󹤳���������#���ˣ����������������̬��Һ̬���#�ġ�����#��һ������1-3�ֱ�#����������4-6�ֱ�#����������7-9�ֱ�#���ģ�����10-12�ֱ�#���壩����13-15�ֱ�#����������16�ֱ�����#�塢˰�����ɽ𡢷�������";
		colsHName[2302] = "���#��Ŀ#�ϼ�#������ҵС��#������ҵ������ҵ#������ҵ������ҵ#������ҵ�ɷݺ�����ҵ#������ҵ��Ӫ��ҵ#������ҵ���У����пع�#������ҵ�ɷݹ�˾#������ҵ���У����пع�#������ҵ˽Ӫ��ҵ#������ҵ������ҵ#�۰�̨Ͷ����ҵ#���У����пع�#����Ͷ����ҵ#���У����пع�#���徭Ӫ";

		
		sjNum[24] = 2;
		colsL[24] = "YSWSSSR1#YZWHZJYQY2#1CKY3#2ZZY4#3DLRLRQJSDSCHGYY5#4JZY6#5PFHLSY7#6JTYSCCHYZY8#7ZSHCYY9#8XXCSRJHXXJSFWY10#9JRY11#10FDCY12#11ZLHSWFWY13#12KXYJHJSFWY14#13WHTYHYLY15#14QTXY16#EZWHZJYQY17#1CKY18#2ZZY19#3DLRLRQJSDSCHGYY20#4JZY21#5PFHLSY22#6JTYSCCHYZY23#7ZSHCYY24#8XXCSRJHXXJSFWY25#9JRY26#10FDCY27#11ZLHSWFWY28#12KXYJHJSFWY29#13WHTYHYLY30#14QTXY31#SWZQY32#1CKY33#2ZZY34#3DLRLRQJSDSCHGYY35#4JZY36#5PFHLSY37#6JTYSCCHYZY38#7ZSHCYY39#8XXCSRJHXXJSFWY40#9JRY41#10FDCY42#11ZLHSWFWY43#12KXYJHJSFWY44#13WHTYHYLY45#14QTXY46#SFJMQY47#1WGQYCZDBJG48#2TGLWCBGCZY49#3JRHBX50#4GJYSSR51#5ZFDWKJ52#6QT53#WWJGR54#LJKHWSS55#ECKHWTS56";
		colsH[24] = "XH#XM#HJ#ZZS#XFS#YYS#QYSDS#GRSDS#CSWHJSS#FCS#CZTDSYS#CCS#QTGS";
		colsLName[24] = "һ������˰������#(һ)������ʾ�Ӫ��ҵ#1���ɿ�ҵ#2������ҵ#3��������������ȼ����ˮ�������͹�Ӧҵ#4������ҵ#5������������ҵ#6����ͨ���䡢�ִ�������ҵ#7��ס�޺Ͳ���ҵ#8����Ϣ���䡢�������Ϣ��������ҵ#9������ҵ#10�����ز�ҵ#11�����޺��������ҵ#12����ѧ�о��ͼ�������ҵ#13���Ļ�������������ҵ#14��������ҵ#(��)���������Ӫ��ҵ#1���ɿ�ҵ#2������ҵ#3��������������ȼ����ˮ�������͹�Ӧҵ#4������ҵ#5������������ҵ#6����ͨ���䡢�ִ�������ҵ#7��ס�޺Ͳ���ҵ#8����Ϣ���䡢�������Ϣ��������ҵ#9������ҵ#10�����ز�ҵ#11�����޺��������ҵ#12����ѧ�о��ͼ�������ҵ#13���Ļ�������������ҵ#14��������ҵ#(��)������ҵ#1���ɿ�ҵ#2������ҵ#3��������������ȼ����ˮ�������͹�Ӧҵ#4������ҵ#5������������ҵ#6����ͨ���䡢�ִ�������ҵ#7��ס�޺Ͳ���ҵ#8����Ϣ���䡢�������Ϣ��������ҵ#9������ҵ#10�����ز�ҵ#11�����޺��������ҵ#12����ѧ�о��ͼ�������ҵ#13���Ļ�������������ҵ#14��������ҵ#(��)�Ǿ�����ҵ#1�������ҵ��פ�������#2���ṩ���񡢳а�������ҵ#3�����ںͱ���#4��������������#5��֧����λ�۽�#6������#(��)�⼮����#(��)���ڻ���˰��#�������ڻ�����˰";
		colsHName[24] = "���#��Ŀ#�ϼ�#��ֵ˰#����˰#Ӫҵ˰#��ҵ����˰#��������˰#����ά������˰#����˰#��������ʹ��˰#����˰#������˰";
		

		sjNum[25] = 2;
		colsL[25] = "HJ#QZBNXQ#WNCQ#1GNZZS#1YCZPY#QZJY#2JZZY#3FZY#4YYJGJSYZPZZY#QZCPY#5HXYLHHXZPZZY#6FJSKWZPY#7HSJSYLJYYJGY#QZGPGC#8QCZZY#9MTCZZY#10MTKCHXXY#11YYHTRQKC#QZYY#12DLSCHGYY#13JZY#14JTYSY#QZTLYSFW#LLYSFW#SLYSFW#HKYSFW#GDYSFW#15YZY#16DXY#17JRY#QZHBJRFW#ZBSCFW#BXY#18FDCY#QZFDCKFJYY#19KXYJHJSFWY#2GNXFS#QZ1JJJJ#J#JJ#2Y#JY#XQY#YS#3CPY#4XQC#5MTC#3YYS#4QYSDS#5CSWHJSS#6QTGS";
		colsH[25] = "XH#XM#HJ#GYQY#JTQY#GFHZQY#LYQY#QZGYKG1#GFGS#QZGYKG2#SYQY#GATTZQY#QZGYKG3#WSTZQY#QZGYKG4#QTQY#GTJKKQY";
		colsLName[25] = "�ϼ�#����:������Ƿ#�����Ƿ#1��������ֵ˰#(1)�̲���Ʒҵ#����:����#(2)������ҵ#(3)��֯ҵ#(4)ԭ�ͼӹ���ʯ����Ʒ����ҵ#����:��Ʒ��#(5)��ѧԭ�Ϻͻ�ѧ��Ʒ����ҵ#(6)�ǽ���������Ʒҵ#(7)��ɫ����ұ����ѹ�Ӽӹ�ҵ#����:�������ֲ�#(8)��������ҵ#(9)Ħ�г�����ҵ#(10)ú̿���ɺ�ϴѡҵ#(11)ԭ�ͺ���Ȼ������#����:ԭ��#(12)���������͹�Ӧҵ#(13)����ҵ#(14)��ͨ����ҵ#���У���·�������#½·�������#ˮ·�������#�����������#�ܵ��������#(15)����ҵ#(16)����ҵ#(17)����ҵ#���У����ҽ��ڷ���#�ʱ��г�����#����ҵ#(18)���ز�ҵ#���У����ز�������Ӫҵ#(19)��ѧ�о��ͼ�������ҵ#2����������˰#���У�(1)�Ƽ��ƾ�#��#�ƾ�#(2)��#����#ѩ����#��˿#(3)��Ʒ��#(4)С����#(5)Ħ�г�#3��Ӫҵ˰#4����ҵ����˰#5������ά������˰#6��������˰";
		colsHName[25] = "���#��Ŀ#�ϼ�#������ҵ#������ҵ#�ɷݺ�����ҵ#��Ӫ��ҵ#���У����пع�#�ɷݹ�˾#���У����пع�#˽Ӫ��ҵ#�۰�̨Ͷ����ҵ#���У����пع�#����Ͷ����ҵ#���У����пع�#������ҵ#�ء�ͣ���տ���ҵ";

		sjNum[26] = 3;
		colsL[26] = "QMYEHJ#QMYE1GNZZS#QMYE2GNXFS#QMYE3YYS#QMYE4QYSDS#QMYE5GRSDS#QMYE6ZYS#QMYE7CSWHJSS#QMYE8FCS#QMYE9YHS#QMYE10CZTDSYS#QMYE11TDZZS#QMYE12CCS#QMYE13CLGZS#QMYE14YYS#QMYE15GDZYS#QMYE16QS#QMYE17HJBHS#QMYE18QTSS#DNRKHJ#DNRK1GNZZS#DNRK2GNXFS#DNRK3YYS#DNRK4QYSDS#DNRK5GRSDS#DNRK6ZYS#DNRK7CSWHJSS#DNRK8FCS#DNRK9YHS#DNRK10CZTDSYS#DNRK11TDZZS#DNRK12CCS#DNRK13CLGZS#DNRK14YYS#DNRK15GDZYS#DNRK16QS#DNRK17HJBHS#DNRK18QTSS";
		colsH[26] = "XH#XM1#XM2#QSHJ#1WNCQXJ#1WNCQ5NYS#1WNCQ2013N#1WNCQ2014N#1WNCQ2015N#1WNCQ2016N#1WNCQ2017N#2BNXQ#3GTJKKQYQSWN#3GTJKKQYQSBN";
		colsLName[26] = "��ĩ���ϼ�#��ĩ���1.������ֵ˰#��ĩ���2.��������˰#��ĩ���3.Ӫҵ˰#��ĩ���4.��ҵ����˰#��ĩ���5.��������˰#��ĩ���6.��Դ˰#��ĩ���7.����ά������˰#��ĩ���8.����˰#��ĩ���9.ӡ��˰#��ĩ���10.��������ʹ��˰#��ĩ���11.������ֵ˰#��ĩ���12.����˰#��ĩ���13.��������˰#��ĩ���14.��Ҷ˰#��ĩ���15.����ռ��˰#��ĩ���16.��˰#��ĩ���17.��������˰#��ĩ���18.����˰��#�������ϼ�#�������1.������ֵ˰#�������2.��������˰#�������3.Ӫҵ˰#�������4.��ҵ����˰#�������5.��������˰#�������6.��Դ˰#�������7.����ά������˰#�������8.����˰#�������9.ӡ��˰#�������10.��������ʹ��˰#�������11.������ֵ˰#�������12.����˰#�������13.��������˰#�������14.��Ҷ˰#�������15.����ռ��˰#�������16.��˰#�������17.��������˰#�������18.����˰��";
		colsHName[26] = "���#��Ŀ#��Ŀ#Ƿ˰�ϼ�#1.�����ǷС��#1.�����Ƿ5������#1.�����Ƿ2013��#1.�����Ƿ2014��#1.�����Ƿ2015��#1.�����Ƿ2016��#1.�����Ƿ2017��#2.������Ƿ#3.��ͣ���տ���ҵǷ˰����#3.��ͣ���տ���ҵǷ˰����";

		sjNum[27] = 2;
		colsL[27] = "HJ#QZ1Y#2J#3YJ#4MT#5YY#6CPY#7HG#8DL#9FZP#10QC#11MTC#12JRBX#13JTYS";
		colsH[27] = "XH#XM#HJ#GNZZS#GNXFS#YYS#QYSDS#CSWHJSS#QTGS";
		colsLName[27] = "�ϼ�#���У�1����#2����#3��ұ��#4��ú̿#5��ԭ��#6����Ʒ��#7������#8������#9����֯Ʒ#10������#11��Ħ�г�#12�����ڡ�����#13����ͨ����";
		colsHName[27] = "���#��Ŀ#�ϼ�#������ֵ˰#��������˰#Ӫҵ˰#��ҵ����˰#����ά������˰#������˰";

		sjNum[28] = 2;
		colsL[28] = "ZJ#YGSMS#1ZF#2JZJZJ#3JZZY#4ZJYFC#5SHBZ#6TGJMSR#7QT1#EGLGXJS#1JSZR#2KJFZ#3ZZCX#4KYJGZZ#5TZCY#6WBFW#7GXJS#8QT2#SCJXWQYFZ#1JRSC#2WDQZD#3MZZZSHYYSZC#4QT3#SZZSJ#1QYFZ#2QYZZGZ#3QT#WJNHB#1HJBH#2DLJS#3ZYZHLY#4QT5#LCJQYFZ#1XBKF#2DBFZ#3LAJL#4QT4#QZCWHJYTY#1JY#2TY#3WH#BZCJRZBSC#1ZBSC#2JRSC#JZCSN#1NCJS#2FLSL#3CYSJ#4JRSC#5QT6#SZCQTGXSY#1FJZZ#2JCSSJS#3CPY#4GFJS#5GJF#6YLWS#7JTYS#8WCYZ#9GY#10SPCB#11WJRY#12ZXCZXZJ#13QT7#SYXSSSXDDY#1GX#2LX#3TXQSYF#4CCSY#5QT8";
		colsH[28] = "XH#XM#HJ#CKY#ZZY#DLRQJSDSCHGYY#JZY#JTYSCCJYZY#PFHLSY#JRY#XXCSJSJFWHRJY#ZLHSWFWY#FDCY#QTXY";
		colsLName[28] = "�ܼ�#һ����������#1.ס��#2.���ּ��ؽ�#3.��ת��ҵ#4.�پ�ҵ����#5.��ᱣ��#6.��߾�������#7.����#�����������¼���#1.����ת��#2.�Ƽ���չ#3.��������#4.���л���ת��#5.Ͷ�ʴ�ҵ#6.�������#7.���¼���#8.����#�����ٽ�С΢��ҵ��չ#1.�����г�#2.δ��������#3.������ֵ˰��Ӫҵ˰����#4.����#�ġ�ת������#1.��ҵ��չ#2.��ҵ�������#3.����#�塢���ܻ���#1.��������#2.��������#3.��Դ�ۺ�����#4.����#�����ٽ�����չ#1.��������#2.������չ#3.��������#4.����#�ߡ�֧���Ļ���������#1.����#2.����#3.�Ļ�#�ˡ�֧�ֽ����ʱ��г�#1.�ʱ��г�#2.�����г�#�š�֧����ũ#1.ũ�彨��#2.��������#3.��ҵ����#4.�����г�#5.����#ʮ��֧������������ҵ#1.�ɻ�����#2.������ʩ����#3.��Ʒ��#4.��������#5.���취#6.ҽ������#7.��ͨ����#8.�޳�Ԯ��#9.����#10.��Ʒ����#11.�⼮��Ա#12.ר��������ʽ�#13.����#ʮһ������˰��Э������#1.��Ϣ#2.��Ϣ#3.����Ȩʹ�÷�#4.�Ʋ�����#5.����";
		colsHName[28] = "���#��Ŀ#�ϼ�#�ɿ�ҵ#����ҵ#����ȼ����ˮ�������͹�Ӧҵ#����ҵ#��ͨ����ִ�������ҵ#����������ҵ#����ҵ#��Ϣ����������������ҵ#���޺��������ҵ#���ز�ҵ#������ҵ";

		sjNum[29] = 3;
		colsL[29] = "ZJ#YGSMS#1ZF#2JZJZJ#3JZZY#4ZJYFC#5SHBZ#6TGJMSR#7QT1#EGLGXJS#1JSZR#2KJFZ#3ZZCX#4KYJGZZ#5TZCY#6WBFW#7GXJS#8QT2#SCJXWQYFZ#1JRSC#2WDQZD#3MZZZSHYYSZC#4QT3#SZZSJ#1QYFZ#2QYZZGZ#3QT4#WJNHB#1HJBH#2DLJS#3ZYZHLY#4QT5#LCJQYFZ#1XBKF#2DBFZ#3LAJL#4QT6#QZCWHJYTY#1JY#2TY#3WH#BZCJRZBSC#1ZBSC#2JRSC#JZCSN#1NCJS#2FLSL#3CYSJ#4JRSC#5QT7#SZCQTGXSY#1FJZZ#2JCSSJS#3CPY#4GFJS#5GJF#6YLWS#7JTYS#8WCYZ#9GY#10SPCB#11WJRY#12ZXCZXZJ#13QT8#SYXSSSXDDY#1GX#2LX#3TXQSYF#4CCSY#5QT9";
		colsH[29] = "XH#XM#HJ#NZQYXJ#NZQYGYQY#NZQYJTQY#NZQYGFHZQY#NZQYLYQY#NZQYGFGS#NZQYSYQY#NZQYQTNZQY#GATTZQY#WSTZQY#GTJY";
		colsLName[29] = "�ܼ�#һ����������#1.ס��#2.���ּ��ؽ�#3.��ת��ҵ#4.�پ�ҵ����#5.��ᱣ��#6.��߾�������#7.����#�����������¼���#1.����ת��#2.�Ƽ���չ#3.��������#4.���л���ת��#5.Ͷ�ʴ�ҵ#6.�������#7.���¼���#8.����#�����ٽ�С΢��ҵ��չ#1.�����г�#2.δ��������#3.������ֵ˰��Ӫҵ˰����#4.����#�ġ�ת������#1.��ҵ��չ#2.��ҵ�������#3.����#�塢���ܻ���#1.��������#2.��������#3.��Դ�ۺ�����#4.����#�����ٽ�����չ#1.��������#2.������չ#3.��������#4.����#�ߡ�֧���Ļ���������#1.����#2.����#3.�Ļ�#�ˡ�֧�ֽ����ʱ��г�#1.�ʱ��г�#2.�����г�#�š�֧����ũ#1.ũ�彨��#2.��������#3.��ҵ����#4.�����г�#5.����#ʮ��֧������������ҵ#1.�ɻ�����#2.������ʩ����#3.��Ʒ��#4.��������#5.���취#6.ҽ������#7.��ͨ����#8.�޳�Ԯ��#9.����#10.��Ʒ����#11.�⼮��Ա#12.ר��������ʽ�#13.����#ʮһ������˰��Э������#1.��Ϣ#2.��Ϣ#3.����Ȩʹ�÷�#4.�Ʋ�����#5.����";
		colsHName[29] = "���#��Ŀ#�ϼ�#������ҵС��#������ҵ������ҵ#������ҵ������ҵ#������ҵ�ɷݺ�����ҵ#������ҵ��Ӫ��ҵ#������ҵ�ɷݹ�˾#������ҵ˽Ӫ��ҵ#������ҵ����������ҵ#�۰�̨Ͷ����ҵ#����Ͷ����ҵ#���徭Ӫ";

		sjNum[30] =2 ;
		colsL[30] = "ZJ#YGSMS#1ZF#2JZJZJ#3JZZY#4ZJYFC#5SHBZ#6TGJMSR#7QT1#EGLGXJS#1JSZR#2KJFZ#3ZZCX#4KYJGZZ#5TZCY#6WBFW#7GXJS#8QT3#SCJXWQYFZ#1JRSC#2WDQZD#3MZZZSHYYSZC#4QT4#SZZSJ#1QYFZ#2QYZZGZ#3QT4#WJNHB#1HJBH#2DLJS#3ZYZHLY#4QT12#LCJQYFZ#1XBKF#2DBFZ#3LAJL#4QT5#QZCWHJYTY#1JY#2TY#3WH#BZCJRZBSC#1ZBSC#2JRSC#JZCSN#1NCJS#2FLSL#3CYSJ#4JRSC#5QT6#SZCQTGXSY#1FJZZ#2JCSSJS#3CPY#4GFJS#5GJF#6YLWS#7JTYS#8WCYZ#9GY#10SPCB#11WJRY#12ZXCZXZJ#13QT7#SYXSSSXDDY#1GX#2LX#3TXQSYF#4CCSY#5QT19";
		colsH[30] = "XH#XM#HJ#ZQJM#TKJM#DDQS";
		colsLName[30] = "�ܼ�#һ����������#1.ס��#2.���ּ��ؽ�#3.��ת��ҵ#4.�پ�ҵ����#5.��ᱣ��#6.��߾�������#7.����#�����������¼���#1.����ת��#2.�Ƽ���չ#3.��������#4.���л���ת��#5.Ͷ�ʴ�ҵ#6.�������#7.���¼���#8.����#�����ٽ�С΢��ҵ��չ#1.�����г�#2.δ��������#3.������ֵ˰��Ӫҵ˰����#4.����#�ġ�ת������#1.��ҵ��չ#2.��ҵ�������#3.����#�塢���ܻ���#1.��������#2.��������#3.��Դ�ۺ�����#4.����#�����ٽ�����չ#1.��������#2.������չ#3.��������#4.����#�ߡ�֧���Ļ���������#1.����#2.����#3.�Ļ�#�ˡ�֧�ֽ����ʱ��г�#1.�ʱ��г�#2.�����г�#�š�֧����ũ#1.ũ�彨��#2.��������#3.��ҵ����#4.�����г�#5.����#ʮ��֧������������ҵ#1.�ɻ�����#2.������ʩ����#3.��Ʒ��#4.��������#5.���취#6.ҽ������#7.��ͨ����#8.�޳�Ԯ��#9.����#10.��Ʒ����#11.�⼮��Ա#12.ר��������ʽ�#13.����#ʮһ������˰��Э������#1.��Ϣ#2.��Ϣ#3.����Ȩʹ�÷�#4.�Ʋ�����#5.����";
		colsHName[30] = "���#��Ŀ#�ϼ�#��ǰ����#�˿����#�ֶ�Ƿ˰";

		sjNum[3401] = 2;
		colsL[3401] = "HJ#YDYCY#EDECY#YCKY#1MTKCHXXY#2SYHTRQKCY#3HSJSKCXY#4YSJSKCXY#5FJSKCXY#6QTCKY#EZZY#1NFSPJGY#2SPZZY#3JYLHJZCZZY#4YCZPY#5FZY#6FZFZFSY#7PGMPYMJQZPHZXY#8MCJGHMZTZCZPY#9JJZZY#10ZZHZZPY#11YSHJLMJFZY#12WJGMTYHYLYPZZY#13SYMTJQTRLJGY#14HXYLHHXZPZZY#15YYZZY#16HXXWZZY#17XJHSLZPY#18FJSKWZPY#19HSJSYLHYYJGY#20YSJSYLHYYJGY#21JSZPY#22TYSBZZY#23ZYSBZZY";
		colsH[3401] = "XH#XM#HJ#YJTYSFW#1LLYSFW#2SLYSFW#3HKYSFW#4GDYSFW#EYZFW#1YZPBFW#2YZTSFW#3QTYZFW#SDXFW#1JCDXFW#2ZZDXFW#SJZFW#1GCFW#2AZFW#3XSFW#4ZSFW#5QTJZFW#WJRFW#1DKFW#2ZJSFJRFW#3BXFW#4JRSPZR#LXDFW#1YFHJSFW#2XXJSFW#3WHCYFW#4WLFZFW#5ZLFW#6JZZXFW#7GBYSFW#8SWFZFW#9QTXDFW#QSHFW#1WHTYFW#2JYYLFW#3LYYLFW#4CYZSFW#5JMRCFW#6QTSHFW#BXSWXZC#1ZLHFZLJS#2SBHZZQ#3TDSYQ#4QTZRZYSYQ#5QTQYXWXZC#JXSBDC#1JZW#QZESFJY1#2GZW#QZESFJY2";
		colsLName[3401] = "�ϼ�#һ����һ��ҵ#�����ڶ���ҵ#(һ)�ɿ�ҵ#1.ú̿���ɺ�ϴѡҵ#2.ʯ�ͺ���Ȼ������ҵ#3.��ɫ�������ѡҵ#4.��ɫ�������ѡҵ#5.�ǽ������ѡҵ#6.�����ɿ�ҵ#(��)����ҵ#1.ũ��ʳƷ�ӹ�ҵ#2.ʳƷ����ҵ#3.�ơ����Ϻ;��Ʋ�����ҵ#4.�̲���Ʒҵ#5.��֯ҵ#6.��֯��װ������ҵ#7.Ƥ�ëƤ����ë������Ʒ����Ьҵ#8.ľ�ļӹ���ľ�����ز���Ʒҵ#9.�Ҿ�����ҵ#10.��ֽ��ֽ��Ʒҵ#11.ӡˢ�ͼ�¼ý�鸴��ҵ#12.�Ľ̡�������������������Ʒ����ҵ#13.ʯ�͡�ú̿������ȼ�ϼӹ�ҵ#14.��ѧԭ�Ϻͻ�ѧ��Ʒ����ҵ#15.ҽҩ����ҵ#16.��ѧ��ά����ҵ#17.�𽺺�������Ʒҵ#18.�ǽ���������Ʒҵ#19.��ɫ����ұ����ѹ�Ӽӹ�ҵ#20.��ɫ����ұ����ѹ�Ӽӹ�ҵ#21.������Ʒҵ#22.ͨ���豸����ҵ#23.ר���豸����ҵ";
		colsHName[3401] = "���#��Ŀ#�ϼ�#һ����ͨ�������#1.½·�������#2.ˮ·�������#3.�����������#4.�ܵ��������#������������#1.�����ձ����#2.�����������#3.������������#�������ŷ���#1.�������ŷ���#2.��ֵ���ŷ���#�ġ���������#1.���̷���#2.��װ����#3.���ɷ���#4.װ�η���#5.������������#�塢���ڷ���#1.�������#2.ֱ���շѽ��ڷ���#3.���շ���#4.������Ʒת��#�����ִ�����#1.�з��ͼ�������#2.��Ϣ��������#3.�Ļ��������#4.������������#5.���޷���#6.��֤��ѯ����#7.�㲥Ӱ�ӷ���#8.����������#9.�����ִ�����#�ߡ��������#1.�Ļ���������#2.����ҽ�Ʒ���#3.�������ַ���#4.����ס�޷���#5.�����ճ�����#6.�����������#�ˡ����������ʲ�#1.ר�����ר������#2.�̱������Ȩ#3.����ʹ��Ȩ#4.������Ȼ��Դʹ��Ȩ#5.����Ȩ���������ʲ�#�š����۲�����#1.������#���У����ַ�����#2.������#����:���ַ�����";
		
		
		
		sjNum[3402] = 2;
		colsL[3402] = "24QCZZY#25TLCBHKHTHQTYSSBZZY#26DQJXHQCZZY#27JSJTXHQTDZSBZZY#28YBYQZZY#29QTZZY#SDLRLRQJSDSCHGYY#1DLRLSCHGYY#2RQSCHGYY#3SDSCHGYY#SJZY#1FWJZY#2TMGCJZY#3JZAZY#4JZZSZXHQTJZY#SDSCY#YPFHLSY#1PFY#2LSY#EJTYSCCHYZY#1TLYSY#2DLYSY#3SSYSY#4HKYSY#5GDYSY#6DSLYHYSDLY#7ZXBYHCCY#8YZY#SZSHCYY#1ZSY#2CYY#SXXCSRJHXXJSFWY#1DXGBDSHWXCSFWY#2HLWHXGFW#3RJHXXJSFWY";
		colsH[3402] = "XH#XM#HJ#YJTYSFW#1LLYSFW#2SLYSFW#3HKYSFW#4GDYSFW#EYZFW#1YZPBFW#2YZTSFW#3QTYZFW#SDXFW#1JCDXFW#2ZZDXFW#SJZFW#1GCFW#2AZFW#3XSFW#4ZSFW#5QTJZFW#WJRFW#1DKFW#2ZJSFJRFW#3BXFW#4JRSPZR#LXDFW#1YFHJSFW#2XXJSFW#3WHCYFW#4WLFZFW#5ZLFW#6JZZXFW#7GBYSFW#8SWFZFW#9QTXDFW#QSHFW#1WHTYFW#2JYYLFW#3LYYLFW#4CYZSFW#5JMRCFW#6QTSHFW#BXSWXZC#1ZLHFZLJS#2SBHZZQ#3TDSYQ#4QTZRZYSYQ#5QTQYXWXZC#JXSBDC#1JZW#QZESFJY1#2GZW#QZESFJY2";
		colsLName[3402] = "24.��������ҵ#25.��·�����������պ�������������豸����ҵ#26.������е����������ҵ#27.�������ͨ�ź����������豸����ҵ#28.�Ǳ���������ҵ#29.��������ҵ#(��)������������ȼ����ˮ�������͹�Ӧҵ#1.���������������͹�Ӧҵ#2.ȼ�������͹�Ӧҵ#3.ˮ�������͹�Ӧҵ#(��)����ҵ#1.���ݽ���ҵ#2.��ľ���̽���ҵ#3.������װҵ#4.����װ�Ρ�װ�޺���������ҵ#����������ҵ#(һ)����������ҵ#1.����ҵ#2.����ҵ#(��)��ͨ���䡢�ִ�������ҵ#1.��·����ҵ#2.��·����ҵ#3.ˮ������ҵ#4.��������ҵ#5.�ܵ�����ҵ#6.��ʽ���˺��������ҵ#7.װж���˺Ͳִ�ҵ#8.����ҵ#(��)ס�޺Ͳ���ҵ#1.ס��ҵ#2.����ҵ#���ģ���Ϣ���䡢�������Ϣ��������ҵ#1.���š��㲥���Ӻ����Ǵ������ҵ#2.����������ط���#3.�������Ϣ��������ҵ";
		colsHName[3402] = "���#��Ŀ#�ϼ�#һ����ͨ�������#1.½·�������#2.ˮ·�������#3.�����������#4.�ܵ��������#������������#1.�����ձ����#2.�����������#3.������������#�������ŷ���#1.�������ŷ���#2.��ֵ���ŷ���#�ġ���������#1.���̷���#2.��װ����#3.���ɷ���#4.װ�η���#5.������������#�塢���ڷ���#1.�������#2.ֱ���շѽ��ڷ���#3.���շ���#4.������Ʒת��#�����ִ�����#1.�з��ͼ�������#2.��Ϣ��������#3.�Ļ��������#4.������������#5.���޷���#6.��֤��ѯ����#7.�㲥Ӱ�ӷ���#8.����������#9.�����ִ�����#�ߡ��������#1.�Ļ���������#2.����ҽ�Ʒ���#3.�������ַ���#4.����ס�޷���#5.�����ճ�����#6.�����������#�ˡ����������ʲ�#1.ר�����ר������#2.�̱������Ȩ#3.����ʹ��Ȩ#4.������Ȼ��Դʹ��Ȩ#5.����Ȩ���������ʲ�#�š����۲�����#1.������#���У����ַ�����#2.������#����:���ַ�����";
		
		
		sjNum[3403] = 2;
		colsL[3403] = "WJRY#1HBJRFW#2ZBSCFW#3BXY#4QTJRY#LFDCY#1FDCKFJYY#2WYGL#3FDCZJFW#4FDCZLJY#5QTFDCY#QZLHSWFWY#1ZLY#2SWFWY#QZZXYDC#GGY#BKXYJHJSFWY#1YJHSYFZ#2ZYJSFWY#3KJTGHYYFWY#JSLHJHGGSSGLY#QZGGSSGLY#SJMFWXLHQTFWY#SYJY#SEWSHSHGZ#SSWHTYHYLY#SSGGGLSHBZHSHZZ#SWQTXY";
		colsH[3403] = "XH#XM#HJ#YJTYSFW#1LLYSFW#2SLYSFW#3HKYSFW#4GDYSFW#EYZFW#1YZPBFW#2YZTSFW#3QTYZFW#SDXFW#1JCDXFW#2ZZDXFW#SJZFW#1GCFW#2AZFW#3XSFW#4ZSFW#5QTJZFW#WJRFW#1DKFW#2ZJSFJRFW#3BXFW#4JRSPZR#LXDFW#1YFHJSFW#2XXJSFW#3WHCYFW#4WLFZFW#5ZLFW#6JZZXFW#7GBYSFW#8SWFZFW#9QTXDFW#QSHFW#1WHTYFW#2JYYLFW#3LYYLFW#4CYZSFW#5JMRCFW#6QTSHFW#BXSWXZC#1ZLHFZLJS#2SBHZZQ#3TDSYQ#4QTZRZYSYQ#5QTQYXWXZC#JXSBDC#1JZW#QZESFJY1#2GZW#QZESFJY2";
		colsLName[3403] = "(��)����ҵ#1.���ҽ��ڷ���#2.�ʱ��г�����#3.����ҵ#4.��������ҵ#(��)���ز�ҵ#1.���ز�������Ӫҵ#2.��ҵ����#3.���ز��н����#4.���ز����޾�Ӫ#5.�������ز�ҵ#(��)���޺��������ҵ#1.����ҵ#2.�������ҵ#���У���ѯ�����#���ҵ#(�ˣ���ѧ�о��ͼ�������ҵ#1.�о���ʵ�鷢չ#2.רҵ��������ҵ#3.�Ƽ��ƹ��Ӧ�÷���ҵ#���ţ�ˮ���������͹�����ʩ����ҵ#���У�������ʩ����ҵ#��ʮ����������������������ҵ#(ʮһ)����#��ʮ��)��������Ṥ��#(ʮ��)�Ļ�������������ҵ#(ʮ��)����������ᱣ�Ϻ������֯#(ʮ��)������ҵ";
		colsHName[3403] = "���#��Ŀ#�ϼ�#һ����ͨ�������#1.½·�������#2.ˮ·�������#3.�����������#4.�ܵ��������#������������#1.�����ձ����#2.�����������#3.������������#�������ŷ���#1.�������ŷ���#2.��ֵ���ŷ���#�ġ���������#1.���̷���#2.��װ����#3.���ɷ���#4.װ�η���#5.������������#�塢���ڷ���#1.�������#2.ֱ���շѽ��ڷ���#3.���շ���#4.������Ʒת��#�����ִ�����#1.�з��ͼ�������#2.��Ϣ��������#3.�Ļ��������#4.������������#5.���޷���#6.��֤��ѯ����#7.�㲥Ӱ�ӷ���#8.����������#9.�����ִ�����#�ߡ��������#1.�Ļ���������#2.����ҽ�Ʒ���#3.�������ַ���#4.����ס�޷���#5.�����ճ�����#6.�����������#�ˡ����������ʲ�#1.ר�����ר������#2.�̱������Ȩ#3.����ʹ��Ȩ#4.������Ȼ��Դʹ��Ȩ#5.����Ȩ���������ʲ�#�š����۲�����#1.������#���У����ַ�����#2.������#����:���ַ�����";
		
		
		
		sjNum[35] = 3;
		colsL[35] = "HJ#YDYCY#EDECY#YCKY#1MTKCHXXY#2SYHTRQKCY#3HSJSKCXY#4YSJSKCXY#5FJSKCXY#6QTCKY#EZZY#1NFSPJGY#2SPZZY#3JYLHJZCZZY#4YCZPY#5FZY#6FZFZFSY#7PGMPYMJQZPHZXY#8MCJGHMZTZCZPY#9JJZZY#10ZZHZZPY#11YSHJLMJFZY#12WJGMTYHYLYPZZY#13SYMTJQTRLJGY#14HXYLHHXZPZZY#15YYZZY#16HXXWZZY#17XJHSLZPY#18FJSKWZPY#19HSJSYLHYYJGY#20YSJSYLHYYJGY#21JSZPY#22TYSBZZY#23ZYSBZZY#24QCZZY#25TLCBHKHTHQTYSSBZZY#26DQJXHQCZZY#27JSJTXHQTDZSBZZY#28YBYQZZY#29QTZZY#SDLRLRQJSDSCHGYY#1DLRLSCHGYY#2RQSCHGYY#3SDSCHGYY#SJZY#1FWJZY#2TMGCJZY#3JZAZY#4JZZSZXHQTJZY#SDSCY#YPFHLSY#1PFY#2LSY#EJTYSCCHYZY#1TLYSY#2DLYSY#3SSYSY#4HKYSY#5GDYSY#6DSLYHYSDLY#7ZXBYHCCY#8YZY#SZSHCYY#1ZSY#2CYY#SXXCSRJHXXJSFWY#1DXGBDSHWXCSFWY#2HLWHXGFW#3RJHXXJSFWY#WJRY#1HBJRFW#2ZBSCFW#3BXY#4QTJRY#LFDCY#1FDCKFJYY#2WYGL#3FDCZJFW#4FDCZLJY#5QTFDCY#QZLHSWFWY#1ZLY#2SWFWY#QZZXYDC#GGY#BKXYJHJSFWY#1YJHSYFZ#2ZYJSFWY#3KJTGHYYFWY#JSLHJHGGSSGLY#QZGGSSGLY#SJMFWXLHQTFWY#1JMFWY#2JDCDZCPHRYCPXLY#3QTFWY#SYJY#SEWSHSHGZ#1WS#2SHGZ#SSWHTYHYLY#1XWHCBY#2GBDSDYHYSLYZZY#3WHYSY#4TY#5YLY#SSGGGLSHBZHSHZZ#SWQTXY";
		colsH[35] = "XH#XM#HJ#QZMDDK#NZQYXJ#NZQYGYQY#NZQYJTQY#NZQYGFHZQY#NZQYLYQY#NZQYQZGYKG1#NZQYGFGS#NZQYQZGYKG2#NZQYSYQY#NZQYQTQY#GATTZQY#QZGYKG1#WSTZQY#QZGYKG2#GTJY";
		colsLName[35] = "�ϼ�#һ����һ��ҵ#�����ڶ���ҵ#(һ)�ɿ�ҵ#1.ú̿���ɺ�ϴѡҵ#2.ʯ�ͺ���Ȼ������ҵ#3.��ɫ�������ѡҵ#4.��ɫ�������ѡҵ#5.�ǽ������ѡҵ#6.�����ɿ�ҵ#(��)����ҵ#1.ũ��ʳƷ�ӹ�ҵ#2.ʳƷ����ҵ#3.�ơ����Ϻ;��Ʋ�����ҵ#4.�̲���Ʒҵ#5.��֯ҵ#6.��֯��װ������ҵ#7.Ƥ�ëƤ����ë������Ʒ����Ьҵ#8.ľ�ļӹ���ľ�����ز���Ʒҵ#9.�Ҿ�����ҵ#10.��ֽ��ֽ��Ʒҵ#11.ӡˢ�ͼ�¼ý�鸴��ҵ#12.�Ľ̡�������������������Ʒ����ҵ#13.ʯ�͡�ú̿������ȼ�ϼӹ�ҵ#14.��ѧԭ�Ϻͻ�ѧ��Ʒ����ҵ#15.ҽҩ����ҵ#16.��ѧ��ά����ҵ#17.�𽺺�������Ʒҵ#18.�ǽ���������Ʒҵ#19.��ɫ����ұ����ѹ�Ӽӹ�ҵ#20.��ɫ����ұ����ѹ�Ӽӹ�ҵ#21.������Ʒҵ#22.ͨ���豸����ҵ#23.ר���豸����ҵ#24.��������ҵ#25.��·�����������պ�������������豸����ҵ#26.������е����������ҵ#27.�������ͨ�ź����������豸����ҵ#28.�Ǳ���������ҵ#29.��������ҵ#(��)������������ȼ����ˮ�������͹�Ӧҵ#1.���������������͹�Ӧҵ#2.ȼ�������͹�Ӧҵ#3.ˮ�������͹�Ӧҵ#(��)����ҵ#1.���ݽ���ҵ#2.��ľ���̽���ҵ#3.������װҵ#4.����װ�Ρ�װ�޺���������ҵ#����������ҵ#(һ)����������ҵ#1.����ҵ#2.����ҵ#(��)��ͨ���䡢�ִ�������ҵ#1.��·����ҵ#2.��·����ҵ#3.ˮ������ҵ#4.��������ҵ#5.�ܵ�����ҵ#6.��ʽ���˺��������ҵ#7.װж���˺Ͳִ�ҵ#8.����ҵ#(��)ס�޺Ͳ���ҵ#1.ס��ҵ#2.����ҵ#���ģ���Ϣ���䡢�������Ϣ��������ҵ#1.���š��㲥���Ӻ����Ǵ������ҵ#2.����������ط���#3.�������Ϣ��������ҵ#(��)����ҵ#1.���ҽ��ڷ���#2.�ʱ��г�����#3.����ҵ#4.��������ҵ#(��)���ز�ҵ#1.���ز�������Ӫҵ#2.��ҵ����#3.���ز��н����#4.���ز����޾�Ӫ#5.�������ز�ҵ#(��)���޺��������ҵ#1.����ҵ#2.�������ҵ#���У���ѯ�����#���ҵ#(�ˣ���ѧ�о��ͼ�������ҵ#1.�о���ʵ�鷢չ#2.רҵ��������ҵ#3.�Ƽ��ƹ��Ӧ�÷���ҵ#���ţ�ˮ���������͹�����ʩ����ҵ#���У�������ʩ����ҵ#��ʮ����������������������ҵ#1.�������ҵ#2.�����������Ӳ�Ʒ�����ò�Ʒ����ҵ#3.��������ҵ#(ʮһ)����#��ʮ������������Ṥ��#1.����#2.��Ṥ��#(ʮ��)�Ļ�������������ҵ#1.���źͳ���ҵ#2.�㲥�����ӡ���Ӱ��Ӱ��¼������ҵ#3.�Ļ�����ҵ#4.����#5.����ҵ#(ʮ��)����������ᱣ�Ϻ������֯#(ʮ��)������ҵ";
		colsHName[35] = "���#��Ŀ#�ϼ�#���У���ֵ���#������ҵС��#������ҵ������ҵ#������ҵ������ҵ#������ҵ�ɷݺ�����ҵ#������ҵ��Ӫ��ҵ#������ҵ���У����пع�#������ҵ�ɷݹ�˾#������ҵ���У����пع�#������ҵ˽Ӫ��ҵ#������ҵ������ҵ#�۰�̨Ͷ����ҵ#���У����пع�#����Ͷ����ҵ#���У����пع�#���徭Ӫ";
		
		
		sjNum[36] = 3;
		colsL[36] = "HJ#YJTYSFW#1LLYSFW#1TLYSFW#2QTLLYSFW#2SLYSFW#3HKYSFW#4GDYSFW#EYZFW#1YZPBFW#2YZTSFW#3QTYZFW#SDXFW#1JCDXFW#2ZZDXFW#SJZFW#1GCFW#2AZFW#3XSFW#4ZSFW#5QTJZFW#WJRFW#1DKFW#2ZJSFJRFW#3BXFW#1RSBXFW#2CCBXFW#4JRSPZR#LXDFW#1YFHJSFW#1YFFW#2HTNYGLFW#3GCKCKTFW#4ZYJSFW#2XXJSFW#1RJFW#2DLSJJCSFW#3XXXTFW#4YWLCGLFW#5XXXTZZFW#3WHCYFW#1SJFW#2ZSCQFW#3GGFW#4HYZLFW#4WLFZFW#1HKFW#2GKMTFW#3HYKYCZFW#4DLJZFW#5ZXBYFW#6CCFW#7SPFW#5ZLFW#1BDCRZZL#2BDCJYZL#3YXDCRZZL#4YXDCJYZL#6JZZXFW#1RZFW#2JZFW#3ZXFW#7GBYSFW#1GBYSJMZPZZFW#2GBYSJMZPFXFW#3GBYSJMZPBYFW#8SWFZFW#1QYGLFW#2JJDLFW#3RLZYFW#4AQBHFW#9QTXDFW#QSHFW#1WHTYFW#1WHFW#2TYFW#2JYYLFW#1JYFW#2YLFW1#3LYYLFW#1LYFW#2YLFW2#4CYZSFW#1CYFW#2ZSFW#5JMRCFW#6QTSHFW#BXSWXZC#1ZLHFZLJS#2SBHZZQ#3TDSYQ#4QTZRZYSYQ#5QTQYXWXZC#JXSBDC#1JZW#QZESFJY1#2GZW#QZESFJY2";
		colsH[36] = "XH#XM#HJ#QZMDDK#NZQYXJ#NZQYGYQY#NZQYJTQY#NZQYGFHZQY#NZQYLYQY#NZQYQZGYKG1#NZQYGFGS#NZQYQZGYKG2#NZQYSYQY#NZQYQTQY#GATTZQY#QZGYKG1#WSTZQY#QZGYKG2#GTJY";
		colsLName[36] = "�ϼ�#һ����ͨ�������#1.½·�������#(1)��·�������#(2)����½·�������#2.ˮ·�������#3.�����������#4.�ܵ��������#������������#1.�����ձ����#2.�����������#3.������������#�������ŷ���#1.�������ŷ���#2.��ֵ���ŷ���#�ġ���������#1.���̷���#2.��װ����#3.���ɷ���#4.װ�η���#5.������������#�塢���ڷ���#1.�������#2.ֱ���շѽ��ڷ���#3.���շ���#(1)�����շ���#(2)�Ʋ����շ���#4.������Ʒת��#�����ִ�����#1.�з��ͼ�������#(1)�з�����#(2)��ͬ��Դ�������#(3)���̿��쿱̽����#(4)רҵ��������#2.��Ϣ��������#(1)�������#(2)��·��Ƽ����Է���#(3)��Ϣϵͳ����#(4)ҵ�����̹������#(5)��Ϣϵͳ��ֵ����#3.�Ļ��������#(1)��Ʒ���#(2)֪ʶ��Ȩ����#(3)������#(4)����չ������#4.������������#(1)���շ���#(2)�ۿ���ͷ����#(3)���˿��˳�վ����#(4)���̾�������#(5)װж���˷���#(6)�ִ�����#(7)���ɷ���#5.���޷���#(1)��������������#(2)��������Ӫ����#(3)���ζ�����������#(4)���ζ�����Ӫ����#6.��֤��ѯ����#(1)��֤����#(2)��֤����#(3)��ѯ����#7.�㲥Ӱ�ӷ���#(1)�㲥Ӱ�ӽ�Ŀ����Ʒ����������#(2)�㲥Ӱ�ӽ�Ŀ����Ʒ�����з���#(3)�㲥Ӱ�ӽ�Ŀ����Ʒ����ӳ����#8.����������#(1)��ҵ�������#(2)���ʹ������#(3)������Դ����#(4)��ȫ��������#9.�����ִ�����#�ߡ��������#1.�Ļ���������#(1)�Ļ�����#(2)��������#2.����ҽ�Ʒ���#(1)��������#(2)ҽ�Ʒ���#3.�������ַ���#(1)���η���#(2)���ַ���#4.����ס�޷���#(1)��������#(2)ס�޷���#5.�����ճ�����#6.�����������#�ˡ����������ʲ�#1.ר�����ר������#2.�̱������Ȩ#3.����ʹ��Ȩ#4.������Ȼ��Դʹ��Ȩ#5.����Ȩ���������ʲ�#�š����۲�����#1.������#���У����ַ�����#2.������#���У����ַ�����";
		colsHName[36] = "���#��Ŀ#�ϼ�#���У���ֵ���#������ҵС��#������ҵ������ҵ#������ҵ������ҵ#������ҵ�ɷݺ�����ҵ#������ҵ��Ӫ��ҵ#������ҵ���У����пع�#������ҵ�ɷݹ�˾#������ҵ���У����пع�#������ҵ˽Ӫ��ҵ#������ҵ������ҵ#�۰�̨Ͷ����ҵ#���У����пع�#����Ͷ����ҵ#���У����пع�#���徭Ӫ";
		
		
		sjNum[37] = 4;
		colsL[37] = "SSSRHJ#1ZZSSR#QZYBNSR#XGMNSR#2XFSSR#3YYS#4QYSDS#5GRSDS#6ZYS#7CSWHJSS#8FCS#9YHS#10CZTDSYS#11TDZZS#12CCS#13CLGZS#14YYS#15GDZYS#16QS#17HJBHS#18QTSS";
		colsH[37] = "XH#SZ1#SZ2#HJHS#HJSSSR#DXQYHS#DXQYSSSR#ZXQYHS#ZXQYSSSR#XWQYXJHS#XWQYXJSSSR#XWQYXXQYHS#XWQYXXQYSSSR#XWQYWXQYHS#XWQYWXQYSSSR";
		colsLName[37] = "˰������ϼ�#1.��ֵ˰����#���У�һ����˰��#С��ģ��˰��#2.����˰����#3.Ӫҵ˰#4.��ҵ����˰#5.��������˰#6.��Դ˰#7.����ά������˰#8.����˰#9.ӡ��˰#10.��������ʹ��˰#11.������ֵ˰#12.����˰#13.��������˰#14.��Ҷ˰#15.����ռ��˰#16.��˰#17.��������˰#18.����˰��";
		colsHName[37] = "���#˰��#˰��#�ϼƻ���#�ϼ�˰������#������ҵ����#������ҵ˰������#������ҵ����#������ҵ˰������#С΢��ҵС�ƻ���#С΢��ҵС��˰������#С΢��ҵС����ҵ����#С΢��ҵС����ҵ˰������#С΢��ҵ΢����ҵ����#С΢��ҵ΢����ҵ˰������";
		
		sjNum[38] = 4;
		colsL[38] = "HJ#YDYCY#EDECY#YCKY#EZZY#1NFSPJGY#2SPZZY#3JYLHJZCZZY#4YCZPY#5FZY#6FZFZFSY#7PGMPYMJQZPHZXY#8MCJGHMZTZCZPY#9JJZZY#10ZZHZZPY#11YSHJLMJFZY#12WJGMTYHYLYPZZY#13SYMTJQTRLJGY#14HXYLHHXZPZZY#15YYZZY#16HXXWZZY#17XJHSLZPY#18FJSKWZPY#19HSJSYLHYYJGY#20YSJSYLHYYJGY#21JSZPY#22TYSBZZY#23ZYSBZZY#24QCZZY#25TLCBHKHTHQTYSSBZZY#26DQJXHQCZZY#27JSJTXHQTDZSBZZY#28YBYQZZY#29QTZZY#SDLRLRQJSDSCHGYY#1DLRLSCHGYY#2RQSCHGYY#3SDSCHGYY#SJZY#1FWJZY#2TMGCJZY#3JZAZY#4JZZSZXHQTJZY#SDSCY#YPFHLSY#1PFY#2LSY#EJTYSCCHYZY#1TLYSY#2DLYSY#3SSYSY#4HKYSY#5GDYSY#6DSLYHYSDLY#7ZXBYHCCY#8YZY#SZSHCYY#1ZSY#2CYY#SXXCSRJHXXJSFWY#1DXGBDSHWXCSFWY#2HLWHXGFW#3RJHXXJSFWY#WJRY#1HBJRFW#2ZBSCFW#3BXY#4QTJRY#LFDCY#1FDCKFJY#2WYGL#3QTFDCY#QZLHSWFWY#1ZLY#2SWFWY#BKXYJHJSFWY#JJMFWXLHQTFWY#SJY#SYWSHSHGZ#SEWHTYHYLY#SSGGGLSHBZHSHZZ#SSQTXY";
		colsH[38] = "XH#XM1#XM2#HJHS#HJSSSR#DXQYHS#DXQYSSSR#ZXQYHS#ZXQYSSSR#XWQYXJHS#XWQYXJSSSR#XWQYXXQYHS#XWQYXXQYSSSR#XWQYWXQYHS#XWQYWXQYSSSR";
		colsLName[38] = "�ϼ�#һ����һ��ҵ#�����ڶ���ҵ#(һ)�ɿ�ҵ#(��)����ҵ#1.ũ��ʳƷ�ӹ�ҵ#2.ʳƷ����ҵ#3.�ơ����Ϻ;��Ʋ�����ҵ#4.�̲���Ʒҵ#5.��֯ҵ#6.��֯��װ������ҵ#7.Ƥ�ëƤ����ë������Ʒ����Ьҵ#8.ľ�ļӹ���ľ�����ز���Ʒҵ#9.�Ҿ�����ҵ#10.��ֽ��ֽ��Ʒҵ#11.ӡˢ�ͼ�¼ý�鸴��ҵ#12.�Ľ̡�������������������Ʒ����ҵ#13.ʯ�͡�ú̿������ȼ�ϼӹ�ҵ#14.��ѧԭ�Ϻͻ�ѧ��Ʒ����ҵ#15.ҽҩ����ҵ#16.��ѧ��ά����ҵ#17.�𽺺�������Ʒҵ#18.�ǽ���������Ʒҵ#19.��ɫ����ұ����ѹ�Ӽӹ�ҵ#20.��ɫ����ұ����ѹ�Ӽӹ�ҵ#21.������Ʒҵ#22.ͨ���豸����ҵ#23.ר���豸����ҵ#24.��������ҵ#25.��·�����������պ�������������豸����ҵ#26.������е����������ҵ#27.�������ͨ�ź����������豸����ҵ#28.�Ǳ���������ҵ#29.��������ҵ#(��)������������ȼ����ˮ�������͹�Ӧҵ#1.���������������͹�Ӧҵ#2.ȼ�������͹�Ӧҵ#3.ˮ�������͹�Ӧҵ#(��)����ҵ#1.���ݽ���ҵ#2.��ľ���̽���ҵ#3.������װҵ#4.����װ�Ρ�װ�޺���������ҵ#����������ҵ#(һ)����������ҵ#1.����ҵ#2.����ҵ#(��)��ͨ���䡢�ִ�������ҵ#1.��·����ҵ#2.��·����ҵ#3.ˮ������ҵ#4.��������ҵ#5.�ܵ�����ҵ#6.��ʽ���˺��������ҵ#7.װж���˺Ͳִ�ҵ#8.����ҵ#(��)ס�޺Ͳ���ҵ#1.ס��ҵ#2.����ҵ#���ģ���Ϣ���䡢�������Ϣ��������ҵ#1.���š��㲥���Ӻ����Ǵ������ҵ#2.����������ط���#3.�������Ϣ��������ҵ#(��)����ҵ#1.���ҽ��ڷ���#2.�ʱ��г�����#3.����ҵ#4.��������ҵ#(��)���ز�ҵ#1.���ز�������Ӫ#2.��ҵ����#3.�������ز�ҵ#(��)���޺��������ҵ#1.����ҵ#2.�������ҵ#(�ˣ���ѧ�о��ͼ�������ҵ#���ţ���������������������ҵ#(ʮ)����#��ʮһ����������Ṥ��#(ʮ��)�Ļ�������������ҵ#(ʮ��)����������ᱣ�Ϻ������֯#(ʮ��)������ҵ";
		colsHName[38] = "���#��Ŀ#��Ŀ#�ϼƻ���#�ϼ�˰������#������ҵ����#������ҵ˰������#������ҵ����#������ҵ˰������#С΢��ҵС�ƻ���#С΢��ҵС��˰������#С΢��ҵС����ҵ����#С΢��ҵС����ҵ˰������#С΢��ҵ΢����ҵ����#С΢��ҵ΢����ҵ˰������";
		

		sjNum[39] = 4;
		colsL[39] = "HJ#YNZQYXJ#YNZQY1GYQY#YNZQY2JTQY#YNZQY3GFHZQY#YNZQY4LYQY#YNZQYQZGYKG1#YNZQY5GFGS#YNZQYQZGYKG2#YNZQY6SYQY#YNZQY7QTQY#EGATTZQY#QZGYKG1#SWSTZQY#QZGYKG2#SGTJY";
		colsH[39] = "XH#QYLX1#QYLX2#HJHS#HJSSSR#DXQYHS#DXQYSSSR#ZXQYHS#ZXQYSSSR#XWQYXJHS#XWQYXJSSSR#XWQYXXQYHS#XWQYXXQYSSSR#XWQYWXQYHS#XWQYWXQYSSSR";
		colsLName[39] = "�ϼ�#һ��������ҵС��#һ��������ҵ1.������ҵ#һ��������ҵ2.������ҵ#һ��������ҵ3.�ɷݺ�����ҵ#һ��������ҵ4.��Ӫ��ҵ#һ��������ҵ���У����пع�#һ��������ҵ5.�ɷݹ�˾#һ��������ҵ���У����пع�#һ��������ҵ6.˽Ӫ��ҵ#һ��������ҵ7.������ҵ#�����۰�̨Ͷ����ҵ#���У����пع�#��������Ͷ����ҵ#���У����пع�#�ġ����徭Ӫ";
		colsHName[39] = "���#��ҵ����#��ҵ����#�ϼƻ���#�ϼ�˰������#������ҵ����#������ҵ˰������#������ҵ����#������ҵ˰������#С΢��ҵС�ƻ���#С΢��ҵС��˰������#С΢��ҵС����ҵ����#С΢��ҵС����ҵ˰������#С΢��ҵ΢����ҵ����#С΢��ҵ΢����ҵ˰������";
		
		
		sjNum[40] = 3;
		colsL[40] = "YXSEHJ#1ASYSLZSHWJLWXSE#2AJYZSBFZSHWXSE#3MDTBFCKHWXSE#4MSHWJLWXSE#EYNSEHJ#1XXSE#2JXSE#SQLDSE#JXSEZC#MDTHWYTSE#ASYSLJSDNSJCYBJSE#3YDKSE#4SJDKSE#5QMLDSE#6JYZSBFJSDYNSE#7YNSEJZE";
		colsH[40] = "XH#XM#HJ#GY#JYDZZ#JDZZ#FZY#YYJGJSYZPZZ#HXYLJHXZPZZY#FJSKWZPY#HSJSYLHYYJGY#QCZZY#MTKCHXXY#SYHTRQKCY#DLRLSCHGYY#PFY#LSY";
		colsLName[40] = "һ.���۶�ϼ�#1.������˰����˰���Ｐ�������۶�#2.���������հ취��˰�������۶�#3.��.��.�˰취���ڻ������۶�#4.��˰���Ｐ�������۶�#��.Ӧ��˰��ϼ�#1.����˰��#2.����˰��#��������˰��#����˰��ת��#����˻���Ӧ��˰��#������˰�ʼ������˰���Ӧ����˰��#3.Ӧ�ֿ�˰��#4.ʵ�ʵֿ�˰��#5.��ĩ����˰��#6.�������հ취�����Ӧ��˰��#7.Ӧ��˰�������";
		colsHName[40] = "���#��Ŀ#�ϼ�#��ҵ#���̵�����#�Ƶ�����#��֯ҵ#ԭ�ͼӹ���ʯ����Ʒ����#��ѧԭ�ϼ���ѧ��Ʒ����ҵ#�ǽ���������Ʒҵ#��ɫ����ұ����ѹ�Ӽӹ�ҵ#��������ҵ#ú̿���ɺ�ϴѡҵ#ʯ�ͺ���Ȼ������ҵ#���������������͹�Ӧҵ#����ҵ#����ҵ";
		
		
		sjNum[41] = 2;
		colsL[41] = "YXSEHJ#1ASYSLZSHWJLWXSE#2AJYZSBFZSHWXSE#3MDTBFCKHWXSE#4MSHWJLWXSE#EYNSEHJ#1XXSE#2JXSE#SQLDSE#JXSEZC#MDTHWYTSE#ASYSLJSDNSJCYBJSE#3YDKSE#4SJDKSE#5QMLDSE#6JYZSBFJSDYNSE#7YNSEJZE#F1XGMNSRXSE#F2XGMNSRYNSE";
		colsH[41] = "XH#XM#HJ#YJTYSFW#1LLYSFW#2SLYSFW#3HKYSFW#4GDYSFW#EYZFW#SDXFW#SJZFW#QZGCFW#WJRFW#1DKFW#2ZJSFJRFW#3BXFW#4JRSPZR#LXDFW#1YFHJSFW#2XXJSFW#3WHCYFW#4WLFZFW#5ZLFW#6JZZXFW#7GBYSFW#8SWFZFW#9QTXDFW#QSHFW#BXSWXZC#JXSBDC#QZESFJY";
		colsLName[41] = "һ.���۶�ϼ�#1.������˰����˰���Ｐ�������۶�#2.���������հ취��˰�������۶�#3.��.��.�˰취���ڻ������۶�#4.��˰���Ｐ�������۶�#��.Ӧ��˰��ϼ�#1.����˰��#2.����˰��#��������˰��#����˰��ת��#����˻���Ӧ��˰��#������˰�ʼ������˰���Ӧ����˰��#3.Ӧ�ֿ�˰��#4.ʵ�ʵֿ�˰��#5.��ĩ����˰��#6.�������հ취�����Ӧ��˰��#7.Ӧ��˰�������#��1��С��ģ��˰�����۶�#��2��С��ģ��˰��Ӧ��˰��";
		colsHName[41] = "���#��Ŀ#�ϼ�#һ����ͨ�������#1��½·�������#2��ˮ·�������#3�������������#4���ܵ��������#������������#�������ŷ���#�ġ���������#���У����̷���#�塢���ڷ���#1.�������#2.ֱ���շѽ��ڷ���#3.���շ���#4.������Ʒת��#�����ִ�����#1.�з��ͼ�������#2.��Ϣ��������#3.�Ļ��������#4.������������#5.���޷���#6.��֤��ѯ����#7.�㲥Ӱ�ӷ���#8.����������#9.�����ִ�����#�ߡ��������#�ˡ����������ʲ�#�š����۲�����#���У����ַ�����";
		
		
		//��
		sjNum[42] = 0;
		colsL[42] = "";
		colsH[42] = "";
		colsLName[42] = "";
		colsHName[42] = "";

		
		
		sjNum[43] = 2;
		colsL[43] = "CZZSASJLREYJYYSR#CZZSASJLREYJYYCB#CZZSASJLREYJLRZE#CZZSASJLREYJTDYWJSDYNSSDE#CZZSASJLREYJBZSSRHSJJMYNSSDE#CZZSASJLREYJGDZCJSZJKCDJE#CZZSASJLREYJMBYQNDKS#CZZSASJLREYJSJLRE#CZZSASJLREYJYNSDSE#CZZSASJLREYJJMSDSE#CZZSASJLREYJQZFHTJDXXWLQYJMSDSE#CZZSASJLREYJSJYNSDSE#CZZSASYNDYJSYNDYNSSDE#CZZSASYNDYJJZBYJYNSDSE#CZZSAQTFFYJJZBYJQDYJDSDSE#HDZSASRZEHDSRZE#HDZSASRZEHDBZSSR#HDZSASRZEHDMSSR#HDZSASRZEHDYSSRE#HDZSASRZEHDYNSSDE#HDZSASRZEHDYNSDSE#HDZSACBFYHDCBFYZE#HDZSACBFYHDYNSSDE#HDZSACBFYHDYNSDSE#HDZSHDYNSEYNSDSE#ZFJGJNQYSDSQKZJGYFTQYSDSE#ZFJGJNQYSDSQKCZJZFPSDSE#ZFJGJNQYSDSQKFZJGYFTQYSDSE#ZFJGJNQYSDSQKQZZJGDLSCJYBMYFTSDSE#ZFJGJNQYSDSQKZJGYCXFZJGYFTSDSE";
		colsH[43] = "XH#XM1#XM2#XM3#HJ#YDYCY#EDECY#YCKY#EZZY#SDLRLRQJSDSCHGYY#SJZY#SDSCY#YPFHLSY#EJTYSCCHYZY#SZSHCYY#SXXCSRJHXXJSFWY#WJRY#LFDCY#QZLHSWFWY#BKXYJHJSFWY#JJMFWXLHQTFWY#SJY#SYWSHSHGZ#SEWHTYHYLY#SSGGGLSHBZHSHZZ#SSQTXY";
		colsLName[43] = "�������հ�ʵ�������Ԥ��Ӫҵ����#�������հ�ʵ�������Ԥ��Ӫҵ�ɱ�#�������հ�ʵ�������Ԥ�������ܶ�#�������հ�ʵ�������Ԥ���ض�ҵ������Ӧ��˰���ö�#�������հ�ʵ�������Ԥ�ɲ���˰�����˰������Ӧ��˰���ö�#�������հ�ʵ�������Ԥ�ɹ̶��ʲ������۾ɣ��۳���������#�������հ�ʵ�������Ԥ���ֲ���ǰ��ȿ���#�������հ�ʵ�������Ԥ��ʵ�������#�������հ�ʵ�������Ԥ��Ӧ������˰��#�������հ�ʵ�������Ԥ�ɼ�������˰��#�������հ�ʵ�������Ԥ�����У�����������С��΢����ҵ��������˰��#�������հ�ʵ�������Ԥ��ʵ��Ӧ������˰��#�������հ���һ���Ԥ����һ���Ӧ��˰���ö�#�������հ���һ���Ԥ�ɽ������£�����Ӧ������˰��#�������հ���������Ԥ�ɽ������£�����ȷ��Ԥ�ɵ�����˰��#�˶����հ������ܶ�˶������ܶ�#�˶����հ������ܶ�˶�����˰����#�˶����հ������ܶ�˶���˰����#�˶����հ������ܶ�˶�Ӧ˰�����#�˶����հ������ܶ�˶�Ӧ��˰���ö�#�˶����հ������ܶ�˶�Ӧ������˰��#�˶����հ��ɱ����ú˶��ɱ������ܶ�#�˶����հ��ɱ����ú˶�Ӧ��˰���ö�#�˶����հ��ɱ����ú˶�Ӧ������˰��#�˶����պ˶�Ӧ��˰��Ӧ������˰��#�ֻܷ���������ҵ����˰����ܻ���Ӧ��̯��ҵ����˰��#�ֻܷ���������ҵ����˰����������з�������˰��#�ֻܷ���������ҵ����˰�����֧����Ӧ��̯��ҵ����˰��#�ֻܷ���������ҵ����˰������У��ܻ�������������Ӫ����Ӧ��̯����˰��#�ֻܷ���������ҵ����˰����ܻ����ѳ�����֧����Ӧ��̯����˰��";
		colsHName[43] = "���#��Ŀ#��Ŀ#��Ŀ#�ϼ�#һ����һ��ҵ#�����ڶ���ҵ#(һ)�ɿ�ҵ#(��)����ҵ#(��)������������ȼ����ˮ�������͹�Ӧҵ#(��)����ҵ#����������ҵ#(һ)����������ҵ#(��)��ͨ���䡢�ִ�������ҵ#(��)ס�޺Ͳ���ҵ#���ģ���Ϣ���䡢�������Ϣ��������ҵ#(��)����ҵ#(��)���ز�ҵ#(��)���޺��������ҵ#(�ˣ���ѧ�о��ͼ�������ҵ#���ţ���������������������ҵ#(ʮ)����#��ʮһ����������Ṥ��#(ʮ��)�Ļ�������������ҵ#(ʮ��)����������ᱣ�Ϻ������֯#(ʮ��)������ҵ";
		
		
		
		//44-57��û��
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
		colsLName[58] = "�ϼ�#һ�����ʡ�н������#�������幤�̻�����������Ӫ����#��������ҵ��λ�ĳа���Ӫ�����⾭Ӫ����#�ġ����񱨳�����#�塢�������#��������Ȩʹ�÷�����#�ߡ���Ϣ����Ϣ����������#�ˡ��Ʋ���������#�š��Ʋ�ת������#���У����۹�ת������#����ת������#ʮ��żȻ����#ʮһ����������";
		colsHName[58] = "���#��Ŀ#�����ö�#��Ӧ��˰���ö�#��Ӧ��˰��#�ѽɣ��ۣ�˰��#�ֿ�˰��#Ӧ�����ˣ�˰��#��ʵ�����˰��";

		
		//��
		sjNum[59] = 0;
		colsL[59] = "";
		colsH[59] = "";
		colsLName[59] = "";
		colsHName[59] = "";


		sjNum[60] = 2;
		colsL[60] = "HJ#YNYK#1MTD#2YYD#3TRQQLFM#4MCCQQLFM#5DRD/LFM#6QTNYK#EJSK#1TKD#2JKQK#3TKD#4LTKD#5QXKD#6NKD#7XKD#8ZZXTKD#9QXTKD#10WKD#11ZKD#12MKD#13YKD#14QTJSK#SFJSK#1SMD#2GZTD#3GLTD#4YSD#5SHSD#6LTKD#7LKD#8LHJD#9LSJD#10ZTLFM#11SSLFM#12JKYD#13HYD#14HYD#15DXLSSZDYD#16KQSD/LFM#17DLYD#18HGYD#19NHZTD#20MXD#21QTFJSK#SSZY#1DBSLFM#2DXSLFM#3ZLSLFM#WQT#LSKZNJFKSR";
		colsH[60] = "XH#XM#JLDW#XSL#XSE#BQYNSE1#BQJMSE#BQYNSE2#BQYBTSE";
		colsLName[60] = "�ϼ�#һ����Դ��#1.ú̿#2.ԭ��#3.��Ȼ��#4.ú�㣨�ɣ���#5.����#6.������Դ��#����������#1.����#2.���#3.ͭ��#4.������#5.Ǧп��#6.����#7.����#8.����ϡ����#9.��ϡ����#10.�ٿ�#11.���#12.�̿�#13.����#14.����������#�����ǽ�����#1.ʯī#2.������#3.������#4.өʯ#5.ʯ��ʯ#6.������#7.�׿�#8.�Ȼ���#9.�����#10.ճ��#11.ɰʯ#12.������#13.����#14.����#15.����±ˮɹ�Ƶ���#16.��Ȫˮ#17.������#18.������#19.�ͻ�ճ��#20.â��#21.�����ǽ�����#�ġ�ˮ��Դ#1.�ر�ˮ#2.����ˮ#3.����ˮ#�塢����#����˰�����ɽ𡢷�������";
		colsHName[60] = "���#��Ŀ#������λ#������#���۶�#����Ӧ��˰��#���ڼ���˰��#��������˰��#����Ӧ�����ˣ�˰��";


		sjNum[61] = 3;
		colsL[61] = "HJ#YA1SLZS#EA5SLZS#SA7SLZS#QT";
		colsH[61] = "XH#XM#JSYJHJ#JSYJZZS#JSYJQZYBZZS#JSYJQZMDZZS#JSYJXFS#JSYJYYS#BQYNSE#BQJMSE#BQYJSE#BQYBTSE";
		colsLName[61] = "�ϼ�#һ����1%˰������#������5%˰������#������7%˰������#����";
		colsHName[61] = "���#��Ŀ#��˰���ݺϼ�#��˰������ֵ˰#��˰�������У�һ����ֵ˰#��˰�������У������ֵ˰#��˰��������˰#��˰����Ӫҵ˰#����Ӧ��˰��#���ڼ���˰��#�����ѽ�˰��#����Ӧ�����ˣ�˰��";


		sjNum[62] = 3;
		colsL[62] = "HJ#YCJJZ#1DWNSR1#2GRNSR1#ECZJZ#1DWNSR2#2GRNSR2#QZGRCZZF";
		colsH[62] = "XH#XM#FCYZ#QZCZFCYZ#QZJMSFCYZ#FCYZ/BQYZSJSR#BQYNSE#BQJMSE#BQYJSE#BQYBTSE";
		colsLName[62] = "�ϼ�#һ���Ӽۼ���#1.��λ��˰��#2.������˰��#�����������#1.��λ��˰��#2.������˰��#���У����˳���ס��";
		colsHName[62] = "���#��Ŀ#����ԭֵ#���У����ⷿ��ԭֵ#���У�����˰����ԭֵ#����ԭֵ����Ӧ��˰������#����Ӧ��˰��#���ڼ���˰��#�����ѽ�˰��#����Ӧ�����ˣ�˰��";


		sjNum[63] = 2;
		colsL[63] = "HJ#YGXHT#EJGCLHT#SJSGCKCSJHT#SJZAZGCCBHT#WCCZLHT#LHWYSHT#QCCBGHT#BJKHT#JCCBXHT#SJSHT#SYCQZYSJ#SEYYZBJZZJ#SSYYZBQT#SSQLXKZZ";
		colsH[63] = "XH#XM#JSJEHJS#HDZSDHDYJ#BQYNSE#BQYJSE#BQJMSE#BQYBTSE";
		colsLName[63] = "�ϼ�#һ��������ͬ#�����ӹ�������ͬ#�������蹤�̿�����ƺ�ͬ#�ġ�������װ���̳а���ͬ#�塢�Ʋ����޺�ͬ#�������������ͬ#�ߡ��ִ����ܺ�ͬ#�ˡ�����ͬ#�š��Ʋ����պ�ͬ#ʮ��������ͬ#ʮһ����Ȩת�����#ʮ����Ӫҵ�ʲ��������ʽ�#ʮ����Ӫҵ�ʲ���������#ʮ�ġ�Ȩ�������֤��";
		colsHName[63] = "���#��Ŀ#��˰�������#�˶����յĺ˶�����#����Ӧ��˰��#�����ѽ�˰��#���ڼ���˰��#����Ӧ�����ˣ�˰��";


		sjNum[64] = 2;
		colsL[64] = "YFSETJ#103Y#236Y#3612Y#41218Y#51824Y#62430Y#730YYS#EFYTTJ#1GY#2SY#3JZ#4ZH#5FDCKFQYKFYD#6QT";
		colsH[64] = "XH#XM#TDZMJWPFM#QZJMSZMJWPFM#BQYNSE#BQJMSE#BQYJSE#BQYBTSE";
		colsLName[64] = "һ����˰��ͳ��#1��0-3Ԫ#2��3-6Ԫ#3��6-12Ԫ#4��12-18Ԫ#5��18-24Ԫ#6��24-30Ԫ#7��30Ԫ����#��������;ͳ��#1.��ҵ#2����ҵ#3����ס#4���ۺ�#5�����ز�������ҵ�����õ�#6������";
		colsHName[64] = "���#��Ŀ#�������������ƽ���ף�#���У�����˰���������ƽ���ף�#����Ӧ��˰��#���ڼ���˰��#�����ѽ�˰��#����Ӧ�����ˣ�˰��";


		sjNum[65] = 3;
		colsL[65] = "HJ#YPTZZ#PTZZ11YX#PTZZ212#PTZZ323#PTZZ43YS#EFPTZZ#FPTZZ12YX#FPTZZ224#FPTZZ346#FPTZZ46YS#SQTLXFDC#QTLXFDC12YX#QTLXFDC224#QTLXFDC346#QTLXFDC46YS";
		colsH[65] = "XH#XM#YSSRHJ#YSSRHBSR#YSSRSWSRJQTSR#YSSRSTXSSR#YNSE#SKJNBQYJSK1#SKJNBQYJSK2";
		colsLName[65] = "�ϼ�#һ����ͨסլ#1.1%������#2.1%-2%����2%��#3.2%-3%����3%��#4.3%����#��������ͨסլ#1.2%������#2.2%-4%����4%��#3.4%-6%����6%��#4.6%����#�����������ͷ��ز�#1.2%������#2.2%-4%����4%��#3.4%-6%����6%��#4.6%����";
		colsHName[65] = "���#��Ŀ#Ӧ˰����ϼ�#Ӧ˰�����������#Ӧ˰����ʵ�����뼰��������#Ӧ˰������ͬ��������#Ӧ��˰��#˰����ɱ����ѽ�˰��#˰����ɱ���Ӧ��˰��";


		sjNum[66] = 2;
		colsL[66] = "YZRFDCSRZE#EKCXMJE#1QDTDSYQSZFDJE#2FDCKFCB#TDZYJCQBCF#QQGCF#JZAZGCF#JCSSF#GGPTSSF#KFJJFY#3FDCKFFY#LXZC#QTFDCKFFY#4YZRFDCYGDSJD#YYS#CSWHJSS#JYFFJ#5CZBGDDQTKCXM#SZZE#SYJTDZZSSE#WJMSE#LYJTDZZSSE#QYBTTDZZSSE";
		colsH[66] = "XH#XM#HJ#PTZZ#FPTZZ#QTLXFDC";
		colsLName[66] = "һ��ת�÷��ز������ܶ�#�����۳���Ŀ���#1.ȡ������ʹ��Ȩ��֧���Ľ��#2.���ز������ɱ�#�������ü���Ǩ������#ǰ�ڹ��̷�#������װ���̷�#������ʩ��#����������ʩ��#������ӷ���#3.���ز���������#��Ϣ֧��#�������ز���������#4.��ת�÷��ز��йص�˰���#Ӫҵ˰#����ά������˰#�����Ѹ���#5.�������涨�������۳���Ŀ#������ֵ��#�ġ�Ӧ��������ֵ˰˰��#�塢����˰��#�����ѽ�������ֵ˰˰��#�ߡ�Ӧ�����ˣ�������ֵ˰˰��";
		colsHName[66] = "���#��Ŀ#�ϼ�#��ͨסլ#����ͨסլ#�������ͷ��ز�";


		sjNum[67] = 3;
		colsL[67] = "YZRFDCSRZE#EKCXMJE#1FDCCBAPGJGJSQDTDSYQSZFDJE#2FDCCBAPGJGJSJFJJZWDPGJG#3FDCCBAPGJGJSPGFY#4FDCCBAGFFPJSGFFPJE#5FDCCBAGFFPJSFPJJKCJE#6FDCCBAGFFPJSGFQS#2YZRFDCYGDSJYYS#3YZRFDCYGDSJCSWHJSS#4YZRFDCYGDSJYHS#5YZRFDCYGDSJJYFFJ#SZZE#SYJTDZZSSE#WJMSE#LYJTDZZSSE#QYBTTDZZSSE";
		colsH[67] = "XH#XM1#XM2#XM3#HJ#GRZZ#GRQTLXFDC#FGR";
		colsLName[67] = "һ��ת�÷��ز������ܶ�#�����۳���Ŀ���#1�����ز��ɱ��������۸����ȡ������ʹ��Ȩ��֧���Ľ��#2�����ز��ɱ��������۸����ɷ���������������۸�#3�����ز��ɱ��������۸������������#4�����ز��ɱ���������Ʊ���㹺����Ʊ���#5�����ز��ɱ���������Ʊ���㷢Ʊ�Ӽƿ۳����#6�����ز��ɱ���������Ʊ���㹺����˰#2����ת�÷��ز��йص�˰��Ӫҵ˰#3����ת�÷��ز��йص�˰�����ά������˰#4����ת�÷��ز��йص�˰��ӡ��˰#5����ת�÷��ز��йص�˰������Ѹ���#������ֵ��#�ġ�Ӧ��������ֵ˰˰��#�塢����˰��#�����ѽ�������ֵ˰˰��#�ߡ�Ӧ�����ˣ�������ֵ˰˰��";
		colsHName[67] = "���#��Ŀ#��Ŀ#��Ŀ#�ϼ�#����סլ#�����������ͷ��ز�#�Ǹ���";


		sjNum[68] = 2;
		colsL[68] = "HJ#YCYC#10SYX#10D16S#16D20S#20D25S#25D30S#30D40S#40SYS#ESYC#1KC#2HC#SGC#SMTC#WQTCL#1ZYZYC#2LSZYJXC#LCB#1JDCB#200DYX#200D2000D#2000D10000D#10000DYS#2YT#10MYX#10D18M#18D30M#30MYS";
		colsH[68] = "XH#XM#CLSHJL#CBSHJS#NYJSE#BNJMSE#BNYJSE#BNYBTSE";
		colsLName[68] = "�ϼ�#һ�����ó�#1.0������#1.0-1.6��#1.6-2.0��#2.0-2.5��#2.5-3.0��#3.0-4.0��#4.0������#�������ó�#1���ͳ�#2������#�����ҳ�#�ġ�Ħ�г�#�塢��������#1��ר����ҵ��#2����ʽר�û�е��#��������#1����������#200������#200-2000��#2000-10000��#10000������#2����ͧ#10������#10-18��#18-30��#30������";
		colsHName[68] = "���#��Ŀ#�������ϼƣ�����#�������ϼƣ��ң�#��Ӧ��˰��#�������˰��#�����ѽ�˰��#����Ӧ�����ˣ�˰��";

		
		sjNum[69] = 2;
		colsL[69] = "HJ#YYSG#YYGM";
		colsH[69] = "XH#XM#SGGMJE#YNSE1#YNSE2#YRKSE";
		colsLName[69] = "�ϼ�#��Ҷ�չ�#��Ҷ����";
		colsHName[69] = "���#��Ŀ#�չ�/������#Ӧ��˰��#����˰��#Ӧ���˰��";
		

		
		sjNum[70] = 2;
		colsL[70] = "HJ#YTDCB#EJTJCSSJS#SGYJS#SSYJS#WZZJS#LNCJMJF#QJSSS#BXX#JYEY#SYY#SYYLY#SEQT";
		colsH[70] = "XH#XM#JSMJWPFM#QZJMSMJWPFM#JZSE#JMSE#YJSE1#YJSE2";
		colsLName[70] = "�ϼ�#һ�����ش���#������ͨ������ʩ����#������ҵ����#�ġ���ҵ����#�塢סլ����#����ũ����񽨷�#�ߡ�������ʩ#�ˡ�ѧУ#�š��׶�԰#ʮ��ҽԺ#ʮһ������Ժ#ʮ��������";
		colsHName[70] = "���#��Ŀ#��˰�������ƽ���ף�#���У�����˰�������ƽ���ף�#����˰��#����˰��#�ѽ�˰��#Ӧ��˰��";
		


		sjNum[71] = 2;
		colsL[71] = "HJ#YGDJBNT#EGDFJBNT#SYD#SLD#WMCD#LNTSLYD#QYZSM#BYYSYTT#JCD#SWT#SYQTLXTD";
		colsH[71] = "XH#XM#JSMJWPFM#QZJMSMJWPFM#JZSE#JMSE#YJSE1#YJSE2";
		colsLName[71] = "�ϼ�#һ�����أ�����ũ�#�������أ��ǻ���ũ�#����԰��#�ġ��ֵ�#�塢���ݵ�#����ũ��ˮ���õ�#�ߡ���ֳˮ��#�ˡ���ҵˮ��̲Ϳ#�š��ݵ�#ʮ��έ��#ʮһ��������������";
		colsHName[71] = "���#��Ŀ#��˰�������ƽ���ף�#���У�����˰�������ƽ���ף�#����˰��#����˰��#�ѽ�˰��#Ӧ��˰��";
		

		sjNum[72] = 2;
		colsL[72] = "1HJ#2YTDQSZYHJ#3YTDSYQCR#41JZYD#52SYYD#63GYYD#74ZHYD#85QTYD#9ETDSYQZR#101JZYD#112SYYD#123GYYD#134ZHYD#145QTYD#15EFWQSZYHJ#16YZLF#17QZ1JTWYZF#1890PMYS#1990PMJYX#202JTDETZF#2190PMYS#2290PMJYX#233FZF#24ECLF#25QZ1JTWYZF#2690PMYS#2790PMJYX#282JTDETZF#2990PMYS#3090PMJYX#313FZF";
		colsH[72] = "XH#XM#QSZYMJWPFM#JZSE#JMSE#YNSE";
		colsLName[72] = "�ϼ�#һ������Ȩ��ת�ƺϼ�#��һ������ʹ��Ȩ����#1.��ס�õ�#2.��ҵ�õ�#3.��ҵ�õ�#4.�ۺ��õ�#5.�����õ�#����������ʹ��Ȩת��#1.��ס�õ�#2.��ҵ�õ�#3.��ҵ�õ�#4.�ۺ��õ�#5.�����õ�#��������Ȩ��ת�ƺϼ�#��һ��������#���У�1.��ͥΨһס��#90ƽ������#90ƽ�׼�����#2.��ͥ�ڶ���ס��#90ƽ������#90ƽ�׼�����#3.��ס��#������������#���У�1.��ͥΨһס��#90ƽ������#90ƽ�׼�����#2.��ͥ�ڶ���ס��#90ƽ������#90ƽ�׼�����#3.��ס��";
		colsHName[72] = "���#��Ŀ#Ȩ��ת���������ƽ���ף�#����˰��#����˰��#Ӧ��˰��";
		
		
		sjNum[73] = 2;
		colsL[73] = "HJ#YDQWRWQK#QZHYGCQK1#YDYHWQK#EEYHLQK#SYBXFCQK#SYCQK#WBBaZQK#LQTQK#ESWRWQK#QZHYGCQK2#YDYLSWRWQK#1ZQQK#2ZSQK#3ZZQK#4ZGQK#5ZGQK#6QTQK#EDELSWRWQK#1HXXYLCODcrQK#2XFWSSQK#3ADQK#4SYLQK#5QTQK#SPHZSDDCJQSYLL#SQXYZYXXQYHDSCYSWR#SGTFWD#QZHYGCD#YMZSD#EWKD#SWXFWD#SYLZD#WFMHD#LLZD#QQTD#SZSWR";
		colsH[73] = "XH#XM#JLDW#WRWPFL#JSYJ#BQYNSE#BQJMSE#BQYJSE#BQYBTSE";
		colsLName[73] = "�ϼ�-#һ��������Ⱦ��ǧ��#���У����󹤳�ǧ��#��һ����������ǧ��#��������������ǧ��#������һ���Է۳�ǧ��#���ģ��̳�ǧ��#���壩����(a)��ǧ��#����������ǧ��#����ˮ��Ⱦ��ǧ��#���У����󹤳�ǧ��#��һ����һ��ˮ��Ⱦ��ǧ��#1.��Ǧǧ��#2.����ǧ��#3.����ǧ��#4.�ܹ�ǧ��#5.�ܸ�ǧ��#6.����ǧ��#�������ڶ���ˮ��Ⱦ��ǧ��#1.��ѧ������(CODcr)ǧ��#2.������(SS)ǧ��#3.����ǧ��#4.ʯ����ǧ��#5.����ǧ��#������PHֵ��ɫ�ȡ��󳦾�Ⱥ����������-#���ģ�������ֳҵ��С����ҵ�͵�����ҵˮ��Ⱦ-#������������#���У����󹤳̶�#��һ��ú�ʯ��#������β���#������Σ�շ����#���ģ�ұ������#���壩��ú�Ҷ�#������¯����#���ߣ�������#�ġ�������Ⱦ-";
		colsHName[73] = "���#��Ŀ#������λ#��Ⱦ���ŷ���#��˰����#����Ӧ��˰��#���ڼ���˰��#�����ѽ�˰��#����Ӧ�����ˣ�˰��";

		
		sjNum[74] = 2;
		colsL[74] = "JSSBYYSR#JSSBYYCB#JSSBLRKSE#JSSBAGDKMBDYQNDKSE#JSSBYNSSDE#JSSBSJYNQYSDSE#JSSBJMQYSDSE#ASRZEHDSRZE#ASRZEHDYNSSDE#ASRZEHDSJYNQYSDSE#ASRZEHDJMQYSDSE#AJFZCHDJFZCZE#AJFZCHDHSDSRE#AJFZCHDYNSSDE#AJFZCHDSJYNQYSDSE#AJFZCHDJMQYSDSE#ACBFYHDCBFYZE#ACBFYHDHSDSRE#ACBFYHDYNSSDE#ACBFYHDSJYNQYSDSE#ACBFYHDJMQYSDSE";
		colsH[74] = "XH#XM1#XM2#HJ#XG#TW#AM#HG#RB#MG#XJP#JND#ADLY#YG#ELS#DG#FG#BLS#QTGJ";
		colsLName[74] = "��ʵ�걨Ӫҵ����#��ʵ�걨Ӫҵ�ɱ�#��ʵ�걨���󣨿��𣩶�#��ʵ�걨���涨���ֲ�����ǰ��ȿ����#��ʵ�걨Ӧ��˰���ö�#��ʵ�걨ʵ��Ӧ����ҵ����˰��#��ʵ�걨�����⣩��ҵ����˰��#�������ܶ�˶������ܶ�#�������ܶ�˶�Ӧ��˰���ö�#�������ܶ�˶�ʵ��Ӧ����ҵ����˰��#�������ܶ�˶������⣩��ҵ����˰��#������֧���˶�����֧���ܶ�#������֧���˶�����������#������֧���˶�Ӧ��˰���ö�#������֧���˶�ʵ��Ӧ����ҵ����˰��#������֧���˶������⣩��ҵ����˰��#���ɱ����ú˶��ɱ������ܶ�#���ɱ����ú˶�����������#���ɱ����ú˶�Ӧ��˰���ö�#���ɱ����ú˶�ʵ��Ӧ����ҵ����˰��#���ɱ����ú˶������⣩��ҵ����˰��";
		colsHName[74] = "���#��Ŀ#��Ŀ#�ϼ�#���#̨��#����#����#�ձ�#����#�¼���#���ô�#�Ĵ�����#Ӣ��#����˹#�¹�#����#����ʱ#��������"; 
		
		
		//��
		sjNum[75] = 0;
		colsL[75] = "";
		colsH[75] = "";
		colsLName[75] = "";
		colsHName[75] = ""; 
				
		//��
		sjNum[76] = 0;
		colsL[76] = "";
		colsH[76] = "";
		colsLName[76] = "";
		colsHName[76] = "";
		
		//��
		sjNum[77] = 0;
		colsL[77] = "";
		colsH[77] = "";
		colsLName[77] = "";
		colsHName[77] = "";
		

		sjNum[78] = 3;
		colsL[78] = "YZZSNSR#1YBNSR#2XGMNSR#EXFSNSR#SYYSNSR#SQYSDSNSR#1JMQYSDSNSR#1NZQY#2WZQY#2FJMQYSDSNSR#WGRSDSNSR#LZYSNSR#QCSWHJSSNSR#BFCSNSR#JYHSNSR#SCZTDSYSNSR#SYTDZZSNSR#SECCSNSR#SSCLGZSNSR#SSYYSNSR#SWGDZYSNSR#SLQSNSR#SQHJBHSNSR#SBQTSSNSR#FLZLDJHS#QZQYNSR#GTNSR";
		colsH[78] = "XH#XM#BQXZHHJ#BQXZHQZ1ZCH#BQXZH2FZCH#QMDJHHJ#QMDJHQZ1ZCH#QMDJH2FZCH#BQZXHHJ#BQZXHQZBQDJBQZX#F1QMZJGHS#QMFZJGHS#F2QMLSNSRDJHS";
		colsLName[78] = "һ����ֵ˰��˰��#1.һ����˰��#2.С��ģ��˰��#��������˰��˰��#����Ӫҵ˰��˰��#�ġ���ҵ����˰��˰��#1.������ҵ����˰��˰��#��1��������ҵ#��2��������ҵ#2.�Ǿ�����ҵ����˰��˰��#�塢��������˰��˰��#������Դ˰��˰��#�ߡ�����ά������˰��˰��#�ˡ�����˰��˰��#�š�ӡ��˰��˰��#ʮ����������ʹ��˰��˰��#ʮһ��������ֵ˰��˰��#ʮ��������˰��˰��#ʮ������������˰��˰��#ʮ�ġ���Ҷ˰��˰��#ʮ�塢����ռ��˰��˰��#ʮ������˰��˰��#ʮ�ߡ���������˰��˰��#ʮ�ˡ�����˰����˰��#�������ϣ��Ǽǻ���#���У���ҵ��˰��#������˰��";
		colsHName[78] = "���#��Ŀ#�����������ϼ�#�������������У�1.������#����������2.��������#��ĩ�Ǽǻ��ϼ�#��ĩ�Ǽǻ����У�1.������#��ĩ�Ǽǻ�2.��������#����ע�����ϼ�#����ע�������У����ڵǼǱ���ע��#��1����ĩ�ܻ�������#��ĩ��֧��������#��2����ĩ��ʱ��˰�˵Ǽǻ���";
		
 
		sjNum[79] = 4;
		colsL[79] = "YZZSNSR#1YBNSR#2XGMNSR#EXFSNSR#SYYSNSR#SQYSDSNSR#1JMQYSDSNSR#1NZQY#2WZQY#2FJMQYSDSNSR#WGRSDSNSR#LZYSNSR#QCSWHJSSNSR#BFCSNSR#JYHSNSR#SCZTDSYSNSR#SYTDZZSNSR#SECCSNSR#SSCLGZSNSR#SSYYSNSR#SWGDZYSNSR#SLQSNSR#SQHJBHSNSR#SBQTSSNSR#FLZLQYSDSNDHSQJ";
		colsH[79] = "XH#XM#YYSBHSHJ#YYSBHS1YSBHSXJ#YYSBHS2YSBHSQZZQSBHS#YYSBHS3YSBHSQZYQSBHS#YYSBHS2WSBHS#EYFKBSBHS#QZWDQZD";
		colsLName[79] = "һ����ֵ˰��˰��#1.һ����˰��#2.С��ģ��˰��#��������˰��˰��#����Ӫҵ˰��˰��#�ġ���ҵ����˰��˰��#1.������ҵ����˰��˰��#��1��������ҵ#��2��������ҵ#2.�Ǿ�����ҵ����˰��˰��#�塢��������˰��˰��#������Դ˰��˰��#�ߡ�����ά������˰��˰��#�ˡ�����˰��˰��#�š�ӡ��˰��˰��#ʮ����������ʹ��˰��˰��#ʮһ��������ֵ˰��˰��#ʮ��������˰��˰��#ʮ������������˰��˰��#ʮ�ġ���Ҷ˰��˰��#ʮ�塢����ռ��˰��˰��#ʮ������˰��˰��#ʮ�ߡ���������˰��˰��#ʮ�ˡ�����˰����˰��#�������ϣ���ҵ����˰��Ȼ������";
		colsHName[79] = "���#��Ŀ#һ��Ӧ�걨�����ϼ�#һ��Ӧ�걨����1.���걨����С��#һ��Ӧ�걨����2.���걨�������У�׼���걨����#һ��Ӧ�걨����3.���걨�������У������걨����#һ��Ӧ�걨����2.δ�걨����#���������ɲ��걨����#���У�δ��������";
		
		
		

		sjNum[80] = 3;
		colsL[80] = "HJ#YDYCY#EDECY#YCKY#1MTKCHXXY#2SYHTRQKCY#3HSJSKCXY#4YSJSKCXY#5FJSKCXY#6QTCKY#EZZY#1NFSPJGY#2SPZZY#3JYLHJZCZZY#4YCZPY#5FZY#6FZFZFSY#7PGMPYMJQZPHZXY#8MCJGHMZTZCZPY#9JJZZY#10ZZHZZPY#11YSHJLMJFZY#12WJGMTYHYLYPZZY#13SYMTJQTRLJGY#14HXYLHHXZPZZY#15YYZZY#16HXXWZZY#17XJHSLZPY#18FJSKWZPY#19HSJSYLHYYJGY#20YSJSYLHYYJGY#21JSZPY#22TYSBZZY#23ZYSBZZY#24QCZZY#25TLCBHKHTHQTYSSBZZY#26DQJXHQCZZY#27JSJTXHQTDZSBZZY#28YBYQZZY#29QTZZY#SDLRLRQJSDSCHGYY#1DLRLDSCHGYY#2RQSCHGYY#3SDSCHGYY#SJZY#1FWJZY#2TMGCJZY#3JZAZY#4JZZSZXHQTJZY#SDSCY#YPFHLSY#1PFY#2LSY#EJTYSCCHYZY#1TLYSY#2DLYSY#3SSYSY#4HKYSY#5GDYSY#6DSLYHYSDLY#7ZXBYHCCY#8YZY#SZSHCYY#1ZSY#2CYY#SXXCSRJHXXJSFWY#1DXGBDSHWXCSFWY#2HLWHXGFW#3RJHXXJSFWY#WJRY#1HBJRFW#2ZBSCFW#3BXY#4QTJRY#LFDCY#QZLHSWFWY#1ZLY#2SWFWY#BKXYJHJSFWY#JJMFWXLHQTFWY#SJY#SYWSHSHGZ#SEWHTYHYLY#SSGGGLSHBZHSHZZ#SSQTXY";
		colsH[80] = "XH#XM#GNZZS#QZYBNSRZZS#GNXFS#YYS#QYSDSNZQY#QYSDSWZQY#GRSDS#CSWHJSS#FCS#YHS#CZTDSYS#TDZZS#CLGZS#CCS#GDZYS#QS#HJBHS#QTGS#FLZLNSHS#DJHS#FZJGHS1#FZJGHS2";
		colsLName[80] = "�ϼ�#һ����һ��ҵ#�����ڶ���ҵ#(һ)�ɿ�ҵ#1.ú̿���ɺ�ϴѡҵ#2.ʯ�ͺ���Ȼ������ҵ#3.��ɫ�������ѡҵ#4.��ɫ�������ѡҵ#5.�ǽ������ѡҵ#6.�����ɿ�ҵ#(��)����ҵ#1.ũ��ʳƷ�ӹ�ҵ#2.ʳƷ����ҵ#3.�ơ����Ϻ;��Ʋ�����ҵ#4.�̲���Ʒҵ#5.��֯ҵ#6.��֯��װ������ҵ#7.Ƥ�ëƤ����ë������Ʒ����Ьҵ#8.ľ�ļӹ���ľ�����ز���Ʒҵ#9.�Ҿ�����ҵ#10.��ֽ��ֽ��Ʒҵ#11.ӡˢ�ͼ�¼ý�鸴��ҵ#12.�Ľ̡�������������������Ʒ����ҵ#13.ʯ�͡�ú̿������ȼ�ϼӹ�ҵ#14.��ѧԭ�Ϻͻ�ѧ��Ʒ����ҵ#15.ҽҩ����ҵ#16.��ѧ��ά����ҵ#17.�𽺺�������Ʒҵ#18.�ǽ���������Ʒҵ#19.��ɫ����ұ����ѹ�Ӽӹ�ҵ#20.��ɫ����ұ����ѹ�Ӽӹ�ҵ#21.������Ʒҵ#22.ͨ���豸����ҵ#23.ר���豸����ҵ#24.��������ҵ#25.��·�����������պ�������������豸����ҵ#26.������е����������ҵ#27.�������ͨ�ź����������豸����ҵ#28.�Ǳ���������ҵ#29.��������ҵ#(��)������������ȼ����ˮ�������͹�Ӧҵ#1.�����������������͹�Ӧҵ#2.ȼ�������͹�Ӧҵ#3.ˮ�������͹�Ӧҵ#(��)����ҵ#1.���ݽ���ҵ#2.��ľ���̽���ҵ#3.������װҵ#4.����װ�Ρ�װ�޺���������ҵ#����������ҵ#(һ)����������ҵ#1.����ҵ#2.����ҵ#(��)��ͨ���䡢�ִ�������ҵ#1.��·����ҵ#2.��·����ҵ#3.ˮ������ҵ#4.��������ҵ#5.�ܵ�����ҵ#6.��ʽ���˺��������ҵ#7.װж���˺Ͳִ�ҵ#8.����ҵ#(��)ס�޺Ͳ���ҵ#1.ס��ҵ#2.����ҵ#���ģ���Ϣ���䡢�������Ϣ��������ҵ#1.���š��㲥���Ӻ����Ǵ������ҵ#2.����������ط���#3.�������Ϣ��������ҵ#(��)����ҵ#1.���ҽ��ڷ���#2.�ʱ��г�����#3.����ҵ#4.��������ҵ#(��)���ز�ҵ#(��)���޺��������ҵ#1.����ҵ#2.�������ҵ#(�ˣ���ѧ�о��ͼ�������ҵ#���ţ���������������������ҵ#(ʮ)����#��ʮһ����������Ṥ��#(ʮ��)�Ļ�������������ҵ#(ʮ��)����������ᱣ�Ϻ������֯#(ʮ��)������ҵ";
		colsHName[80] = "���#��Ŀ#������ֵ˰#����:һ����˰����ֵ˰#��������˰#Ӫҵ˰#��ҵ����˰������ҵ#��ҵ����˰������ҵ#��������˰#����ά������˰#����˰#ӡ��˰#��������ʹ��˰#������ֵ˰#��������˰#����˰#����ռ��˰#��˰#��������˰#������˰#�������ϣ���˰����#�Ǽǻ���#�����ܻ�������#��֧��������";
		


		sjNum[81] = 3;
		colsL[81] = "1ZZS#YBNSR#XGMNSR#2XFS#3YYS#4QYSDS#5GRSDS#6ZYS#7CSWHJSS#8FCS#9YHS#10CZTDSYS#11TDZZS#12CCS#13CLGZS#14YYS#15GDZYS#16QS#17HJBHS#18QTSS#FLZLNSHS#DJHS";
		colsH[81] = "XH#XM#HJ#NZQYXJ#NZQYGYQY#NZQYJTQY#NZQYGFHZQY#NZQYLYQY#NZQYQZGYKG1#NZQYGFGS#NZQYQZGYKG2#NZQYSYQY#NZQYQTQY#GATTZQY#QZGYKG1#WSTZQY#QZGYKG2#GTJY#FZJGHS1#FZJGHS2";
		colsLName[81] = "1.��ֵ˰#һ����˰��#С��ģ��˰��#2.����˰#3.Ӫҵ˰#4.��ҵ����˰#5.��������˰#6.��Դ˰#7.����ά������˰#8.����˰#9.ӡ��˰#10.��������ʹ��˰#11.������ֵ˰#12.����˰#13.��������˰#14.��Ҷ˰#15.����ռ��˰#16.��˰#17.��������˰#18.����˰��#�������ϣ���˰����#�Ǽǻ���";
		colsHName[81] = "���#��Ŀ#�ϼ�#������ҵС��#������ҵ������ҵ#������ҵ������ҵ#������ҵ�ɷݺ�����ҵ#������ҵ��Ӫ��ҵ#������ҵ���У����пع�#������ҵ�ɷݹ�˾#������ҵ���У����пع�#������ҵ˽Ӫ��ҵ#������ҵ������ҵ#�۰�̨Ͷ����ҵ#���У����пع�#����Ͷ����ҵ#���У����пع�#���徭Ӫ#�����ܻ�������#��֧��������";
		
		

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
