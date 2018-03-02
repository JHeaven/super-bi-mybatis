package com.heaven.main.analyse2017;

import java.util.Date;

/**
 * 
 * ��������map��sql
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
				//����MAP
				//getMaps(i);
				System.out.println();
				//����SQL
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
		colsLName[1] = "�ϼ�#1.����˰��#2.������������#3.����˰��#4.����˰��#5.��;˰��#6.���˰��#7.�����������#8.����˰��#9.��������ʧ˰��#10.��ʧ˰�����#11.���ܿ�";
		colsHName[1] = "���#�ʽ�ռ�ÿ�Ŀ#�ʽ�ռ��������#�ʽ�ռ����ĩ���#�ʽ���Դ��Ŀ#�ʽ���Դ������#�ʽ���Դ��ĩ���";
		
		sjNum[2] = 4;
		colsL[2] = "ZJ#SSSRHJ#ZZSSR#GNZZS#YBZZS#GZZZS#QZZGTLZGSGZZZSSR#CJRJYZZSTS#RJZZSTS#SGZHLYZZSTS#SDZZSTS#ZYZHLYZZSTS#CPYZZSTS#MDDZZZS#MDDZGZZZS#2JKHWZZS#2XFSSR#GNXFS#QZCPYXFS#JKXFPXFS#QZJKCPYXFS#3YYS#JRBXYYYS#QTYYS#4QYSDS#QZZYGDSR#1YBQYSDS#NZQY1#WZQY1#2FZJGYJSDS#NZQY2#WZQY2#3ZJGYJSDS#NZQY3#WZQY3#4FZJGHSQJSDS#NZQY4#WZQY4#5ZJGHSQJSDS#NZQY5#WZQY5#6QYSDSDFPSR#NZQY6#WZQY6#5GRSDS#LXSDS#QTGRSDS#6ZYS#7GDZCTZFXDJS#8CSWHJSS#9FCS#10YHS#ZQJYYHS#QTYHS#11CZTDSYS#12TDZZS#13CCS#14CLGZS#15YYS#16GDZYS#17QS#18QTSS#ECPYXFSTS#SCKTSHJ#1CKHWTZZS#2GZZZSCKTS#3MDDJZZS#4MDDJGZZZS#5CKXFPTXFS#SFSSRHJ#1JYFFJSR#2DFJYFJ#3WHSYJSFSR#4HSSYKQSYFSR#5SWBMFMSR#6CJRJYBZJJ#7SHBXJJSR#QYZGJBYLBXJJSR#JGSYDWJBYLBXJJSR#SYBXJJSR1#JBYLBXJJSR#GSBXJJSR#SYBXJJSR2#QTSHBXJJSR#8ZFXJJSR#FQDQDZCPCLJJSR#QTZFXJJSR#9GHJFSR#10QTFSSR";
		colsH[2] = "XH#XM#HJ#BNXQRK#20010501HCQRK#20010501QCQRK#ZY#DFXJ1#DFSJ1#DFSJ2#DFXJ2";
		colsLName[2] = "�ܼ�#˰������ϼ�#��ֵ˰����#������ֵ˰#һ����ֵ˰#������ֵ˰#�����й���·�ܹ�˾������ֵ˰����#�м��˾�ҵ��ֵ˰��˰#�����ֵ˰��˰#ɭ���ۺ�������ֵ˰��˰#ˮ����ֵ˰��˰#��Դ�ۺ�������ֵ˰��˰#��Ʒ����ֵ˰��˰#��ֵ�����ֵ˰#��ֵ���������ֵ˰#(2)���ڻ�����ֵ˰#2.����˰����#��������˰#���У���Ʒ������˰#��������Ʒ����˰#���У����ڳ�Ʒ������˰#3.Ӫҵ˰#���ڱ���ҵӪҵ˰#����Ӫҵ˰#4.��ҵ����˰#���У�����̶�����#��1��һ����ҵ����˰#������ҵ#������ҵ#��2����֧����Ԥ������˰#������ҵ#������ҵ#��3���ܻ���Ԥ������˰#������ҵ#������ҵ#��4����֧���������������˰#������ҵ#������ҵ#��5���ܻ��������������˰#������ҵ#������ҵ#��6����ҵ����˰����������#������ҵ#������ҵ#5.��������˰#��Ϣ����˰#������������˰#6.��Դ˰#7.�̶��ʲ�Ͷ�ʷ������˰#8.����ά������˰#9.����˰#10.ӡ��˰#֤ȯ����ӡ��˰#����ӡ��˰#11.��������ʹ��˰#12.������ֵ˰#13.����˰#14.��������˰#15.��Ҷ˰#16.����ռ��˰#17.��˰#18.����˰��#������Ʒ������˰��˰#����������˰�ϼ�#1.���ڻ�������ֵ˰#2.������ֵ˰������˰#3.��ֵ�����ֵ˰#4.��ֵ���������ֵ˰#5.��������Ʒ������˰#�ġ���˰����ϼ�#1.�����Ѹ�������#2.�ط���������#3.�Ļ���ҵ���������#4.����ʯ�Ϳ���ʹ�÷�����#5.˰���ŷ�û����#6.�м��˾�ҵ���ϻ���#7.��ᱣ�ջ�������#��ҵְ���������ϱ��ջ�������#������ҵ��λ�������ϱ��ջ�������#ʧҵ���ջ�������#����ҽ�Ʊ��ջ�������#���˱��ջ�������#�������ջ�������#������ᱣ�ջ�������#8.�����Ի�������#�����������Ӳ�Ʒ�����������#���������Ի�������#9.���ᾭ������#10.������˰����";
		colsHName[2] = "���#��Ŀ#�ϼ�#������Ƿ���#2001��5��1���Ժ��Ƿ���#2001��5��1����ǰ��Ƿ���#����#�ط�С��#�ط�ʡ��#�ط��м�#�ط��ؼ�";
		
		sjNum[3] = 3;
		colsL[3] = "ZJ#YSSSRHJ#1ZZSSR#QZGZZZS#2XFSSR#3YYS#4QYSDS#5GRSDS#6ZYS#7GDZCTZFXDJS#8CSWHJSS#9FCS#10YHS#11CZTDSYS#12TDZZS#13CCS#14CLGZS#15YYS#16GDZYS#17QS#18QTSS#EQTSRHJ#QZFQDQDZCPCLJJSR";
		colsH[3] = "XH#XM#NCYE#DNFSEHJ#DNFSEGYQY#DNFSEJTQY#DNFSEGFHZQY#DNFSELYQY#DNFSEQZGYKG1#DNFSEGFGS#DNFSEQZGYKG2#DNFSESYQY#DNFSEGATTZQY#DNFSEQZGYKG3#DNFSEWSTZQY#DNFSEQZGYKG4#DNFSEQTQY#QMYE";
		colsLName[3] = "�ܼ�#һ��˰������ϼ�#1.��ֵ˰����#���У�������ֵ˰#2.����˰����#3.Ӫҵ˰#4.��ҵ����˰#5.��������˰#6.��Դ˰#7.�̶��ʲ�Ͷ�ʷ������˰#8.����ά������˰#9.����˰#10.ӡ��˰#11.��������ʹ��˰#12.������ֵ˰#13.����˰#14.��������˰#15.��Ҷ˰#16.����ռ��˰#17.��˰#18.����˰��#������������ϼ�#���У������������Ӳ�Ʒ�����������";
		colsHName[3] = "���#��Ŀ#������#���귢����ϼ�#���귢���������ҵ#���귢�������ҵ#���귢����ɷݺ�����ҵ#���귢������Ӫ��ҵ#���귢�������У����пع�#���귢����ɷݹ�˾#���귢�������У����пع�#���귢����˽Ӫ��ҵ#���귢����۰�̨Ͷ����ҵ#���귢�������У����пع�#���귢��������Ͷ����ҵ#���귢�������У����пع�#���귢����������ҵ#��ĩ���";
		
		
		sjNum[4] = 2;
		colsL[4] = "ZJ1#YSSSRHJ2#WDQYJSK3#JPZHZ4#GTJKKQYQS5#WNCQ6#BNXQ7#1GNZZS8#QZGZZZS9#WDQYJSK10#JPZHZ11#GTJKKQYQS12#WNCQ13#BNXQ14#2GNXFS15#WDQYJSK16#JPZHZ17#GTJKKQYQS18#WNCQ19#BNXQ20#3YYS21#WDQYJSK22#JPZHZ23#GTJKKQYQS24#WNCQ25#BNXQ26#4QYSDS27#WDQYJSK28#JPZHZ29#GTJKKQYQS30#WNCQ31#BNXQ32#5GRSDS33#WDQYJSK34#JPZHZ35#GTJKKQYQS36#WNCQ37#BNXQ38#6ZYS39#WDQYJSK40#JPZHZ41#GTJKKQYQS42#WNCQ43#BNXQ44#7CSWHJSS45#WDQYJSK46#JPZHZ47#GTJKKQYQS48#WNCQ49#BNXQ50#8FCS51#WDQYJSK52#JPZHZ53#GTJKKQYQS54#WNCQ55#BNXQ56#9YHS57#WDQYJSK58#JPZHZ59#GTJKKQYQS60#WNCQ61#BNXQ62#10CZTDSYS63#WDQYJSK64#JPZHZ65#GTJKKQYQS66#WNCQ67#BNXQ68#11TDZZS69#WDQYJSK70#JPZHZ71#GTJKKQYQS72#WNCQ73#BNXQ74#12CCS75#WDQYJSK76#JPZHZ77#GTJKKQYQS78#WNCQ79#BNXQ80#13YYS81#WDQYJSK82#JPZHZ83#GTJKKQYQS84#WNCQ85#BNXQ86#14GDZYS87#WDQYJSK88#JPZHZ89#GTJKKQYQS90#WNCQ91#BNXQ92#15QS93#WDQYJSK94#JPZHZ95#GTJKKQYQS96#WNCQ97#BNXQ98#16QTSS99#WDQYJSK100#JPZHZ101#GTJKKQYQS102#WNCQ103#BNXQ104#EQTSRHJ105#QZFQDQDZCPCLJJSR106";
		colsH[4] = "XH#XM#QCYE#BQZJE#BQJSE#QMYE";
		colsLName[4] = "�ܼ�#һ��˰������ϼ�#δ����Ӧ��˰��#����׼����#�ء�ͣ���տ���ҵǷ˰#�����Ƿ#������Ƿ#1.������ֵ˰#���У�������ֵ˰#δ����Ӧ��˰��#����׼����#�ء�ͣ���տ���ҵǷ˰#�����Ƿ#������Ƿ#2.��������˰#δ����Ӧ��˰��#����׼����#�ء�ͣ���տ���ҵǷ˰#�����Ƿ#������Ƿ#3.Ӫҵ˰#δ����Ӧ��˰��#����׼����#�ء�ͣ���տ���ҵǷ˰#�����Ƿ#������Ƿ#4.��ҵ����˰#δ����Ӧ��˰��#����׼����#�ء�ͣ���տ���ҵǷ˰#�����Ƿ#������Ƿ#5.��������˰#δ����Ӧ��˰��#����׼����#�ء�ͣ���տ���ҵǷ˰#�����Ƿ#������Ƿ#6.��Դ˰#δ����Ӧ��˰��#����׼����#�ء�ͣ���տ���ҵǷ˰#�����Ƿ#������Ƿ#7.����ά������˰#δ����Ӧ��˰��#����׼����#�ء�ͣ���տ���ҵǷ˰#�����Ƿ#������Ƿ#8.����˰#δ����Ӧ��˰��#����׼����#�ء�ͣ���տ���ҵǷ˰#�����Ƿ#������Ƿ#9.ӡ��˰#δ����Ӧ��˰��#����׼����#�ء�ͣ���տ���ҵǷ˰#�����Ƿ#������Ƿ#10.��������ʹ��˰#δ����Ӧ��˰��#����׼����#�ء�ͣ���տ���ҵǷ˰#�����Ƿ#������Ƿ#11.������ֵ˰#δ����Ӧ��˰��#����׼����#�ء�ͣ���տ���ҵǷ˰#�����Ƿ#������Ƿ#12.����˰#δ����Ӧ��˰��#����׼����#�ء�ͣ���տ���ҵǷ˰#�����Ƿ#������Ƿ#13.��Ҷ˰#δ����Ӧ��˰��#����׼����#�ء�ͣ���տ���ҵǷ˰#�����Ƿ#������Ƿ#14.����ռ��˰#δ����Ӧ��˰��#����׼����#�ء�ͣ���տ���ҵǷ˰#�����Ƿ#������Ƿ#15.��˰#δ����Ӧ��˰��#����׼����#�ء�ͣ���տ���ҵǷ˰#�����Ƿ#������Ƿ#16.����˰��#δ����Ӧ��˰��#����׼����#�ء�ͣ���տ���ҵǷ˰#�����Ƿ#������Ƿ#������������ϼ�#���У������������Ӳ�Ʒ�����������";
		colsHName[4] = "���#��Ŀ#�ڳ����#�������Ӷ�#���ڼ��ٶ�#��ĩ���";
		
		
		
		sjNum[5] = 2;
		colsL[5] = "ZJ#YSSSRHJ#1ZZS#QZGZZZS#JXLD#2XFS#QZCPYXFS#3YYS#4QYSDS#5GRSDS#6ZYS#7GDZCTZFXDJS#8CSWHJSS#9FCS#10YHS#11CZTDSYS#12TDZZS#13CCS#14CLGZS#15YYS#16GDZYS#17QS#18QTSS#EQTSRHJ#QZFQDQDZCPCLJJSR#FLZLZZSJXLDSE";
		colsH[5] = "XH#XM#HJ#CKTS#XZHT#JMTS#HSQJJSTS#WSTS#QTTS";
		colsLName[5] = "�ܼ�#һ��˰������ϼ�#1.��ֵ˰#���У�������ֵ˰#��������#2.����˰#���У���Ʒ������˰#3.Ӫҵ˰#4.��ҵ����˰#5.��������˰#6.��Դ˰#7.�̶��ʲ�Ͷ�ʷ������˰#8.����ά������˰#9.����˰#10.ӡ��˰#11.��������ʹ��˰#12.������ֵ˰#13.����˰#14.��������˰#15.��Ҷ˰#16.����ռ��˰#17.��˰#18.����˰��#������������ϼ�#���У������������Ӳ�Ʒ�����������#�������ϣ���ֵ˰��������˰��";
		colsHName[5] = "���#�� Ŀ#�ϼ�#������˰#��������#������˰#������ɽ�����˰#������˰#������˰";
		
		
		sjNum[6] = 3;
		colsL[6] = "ZJ#QZZQJM#TKJM#DDQS#YGSMS#1ZF#2JZJZJ#3JZZY#4ZJYFC#5SHBZ#6TGJMSR#7QT#EGLGXJS#1JSZR#2KJFZ#3ZZCX#4KYJGZZ#5TZCY#6WBFW#7GXJS#8QT#SCJXWQYFZ#1JRSC#2WDQZD#3MZZZSHYYSZC#4QT1#SZZSJ#1QYFZ#2QYZZGZ#3QT#WJNHB#1HJBH#2DLJS#3ZYZHLY#4QT2#LCJQYFZ#1XBKF#2DBFZ#3LAJL#4QT3#QZCWHJYTY#1JY#2TY#3WH#BZCJRZBSC#1ZBSC#2JRSC#JZCSN#1NCJS#2FLSL#3CYSJ#4JRSC#5QT1#SZCQTGXSY#1FJZZ#2JCSSJS#3CPY#4GFJS#5GJF#6YLWS#7JTYS#8WCYZ#9GY#10SPCB#11WJRY#12ZXCZXZJ#13QT#SYXSSSXDDY#1GX#2LX#3TXQSYF#4CCSY#5QT2";
		colsH[6] = "XH#XM#HJ#SSSRXJ#SSSRZZS#SSSRQZ��GZZZS#SSSRXFS#SSSRYYS#SSSRQYSDS#SSSRGRSDS#SSSRZYS#SSSRCSWHJSS#SSSRFCS#SSSRYHS#SSSRCZTDSYS#SSSRTDZZS#SSSRCCS#SSSRCLGZS#SSSRGDZYS#SSSRQS#SSSRQTSS#QTSRHJ#QYSDSYJYJJM";
		colsLName[6] = "�ܼ�#���У���ǰ����#�˿����#�ֶ�Ƿ˰#һ����������#1.ס��#2.���ּ��ؽ�#3.��ת��ҵ#4.�پ�ҵ����#5.��ᱣ��#6.��߾�������#7.����#�����������¼���#1.����ת��#2.�Ƽ���չ#3.��������#4.���л���ת��#5.Ͷ�ʴ�ҵ#6.�������#7.���¼���#8.����#�����ٽ�С΢��ҵ��չ#1.�����г�#2.δ��������#3.������ֵ˰��Ӫҵ˰����#4.����#�ġ�ת������#1.��ҵ��չ#2.��ҵ�������#3.����#�塢���ܻ���#1.��������#2.��������#3.��Դ�ۺ�����#4.����#�����ٽ�����չ#1.��������#2.������չ#3.��������#4.����#�ߡ�֧���Ļ���������#1.����#2.����#3.�Ļ�#�ˡ�֧�ֽ����ʱ��г�#1.�ʱ��г�#2.�����г�#�š�֧����ũ#1.ũ�彨��#2.��������#3.��ҵ����#4.�����г�#5.����#ʮ��֧������������ҵ#1.�ɻ�����#2.������ʩ����#3.��Ʒ��#4.��������#5.���취#6.ҽ������#7.��ͨ����#8.�޳�Ԯ��#9.����#10.��Ʒ����#11.�⼮��Ա#12.ר��������ʽ�#13.����#ʮһ������˰��Э������#1.��Ϣ#2.��Ϣ#3.����Ȩʹ�÷�#4.�Ʋ�����#5.����";
		colsHName[6] = "���#��Ŀ#�ϼ�#˰������С��#˰��������ֵ˰#˰���������У�������ֵ˰#˰����������˰#˰������Ӫҵ˰#˰��������ҵ����˰#˰�������������˰#˰��������Դ˰#˰���������ά������˰#˰�����뷿��˰#˰������ӡ��˰#˰�������������ʹ��˰#˰������������ֵ˰#˰�����복��˰#˰�����복������˰#˰���������ռ��˰#˰��������˰#˰����������˰��#��������ϼ�#��ҵ����˰�£�����Ԥ�ɼ���";
		
		
		sjNum[7] = 3;
		colsL[7] = "ZJ#YSSSRHJ#1ZZSSR#QZGNZZS#2XFSSR#QZGNXFS#3YYS#4QYSDS#5GRSDS#6ZYS#7GDZCTZFXDJS#8CSWHJSS#9FCS#10YHS#11CZTDSYS#12TDZZS#13CCS#14CLGZS#15YYS#16GDZYS#17QS#18QTSS#EQTSRHJ#FQDQDZCPCLJJSR";
		colsH[7] = "XH#XM#DJSJNCYE#DJSJQMYE#ZTSJNCYE#ZTSJQMYE#DJSJNCYE2#DJSJQMYE2#DCLSSSJNCYE#DCLSSSJQMYE#SSSJHXNCYE#SSSJHXQMYE";
		colsLName[7] = "�ܼ�#һ��˰������ϼ�#1.��ֵ˰����#���У�������ֵ˰#2.����˰����#���У���������˰#3.Ӫҵ˰#4.��ҵ����˰#5.��������˰#6.��Դ˰#7.�̶��ʲ�Ͷ�ʷ������˰#8.����ά������˰#9.����˰#10.ӡ��˰#11.��������ʹ��˰#12.������ֵ˰#13.����˰#14.��������˰#15.��Ҷ˰#16.����ռ��˰#17.��˰#18.����˰��#������������ϼ�#�����������Ӳ�Ʒ�����������";
		colsHName[7] = "���#��Ŀ#���˰��������������#���˰����ĩ�����ĩ���#��;˰��������������#��;˰����ĩ�����ĩ���#����˰��������������#����˰����ĩ�����ĩ���#��������ʧ˰��������������#��������ʧ˰����ĩ�����ĩ���#��ʧ˰�����������������#��ʧ˰�������ĩ�����ĩ���";
		
		
		
		sjNum[8] = 5;
		colsL[8] = "ZJ#YSSSRHJ#1ZZS#QZGZZZS#2XFS#3YYS#4QYSDS#5GRSDS#6ZYS#7GDZCTZFXDJS#8CSWHJSS#9FCS#10YHS#11CZTDSYS#12TDZZS#13CCS#14CLGZS#15YYS#16GDZYS#17QS#18QTSS#EQTSRHJ#QZ1JYFFJSR#2WHSYJSFSR#3FQDQDZCPCLJJSR#4QTFMSR";
		colsH[8] = "XH#XM#HJ1#YZCBSJSWJCBMCBSK#YZCBSJSWJCBMCBZNJ#YZCBSJSWJCBMCBFK#YZCBSJSWJCBMCBQZZCBS#YZCBSJSWQTBMCBSK#YZCBSJSWQTBMCBZNJ#YZCBSJSWQTBMCBFK#QZ1TBNSDZ#YZCBSJSWQTBMCB2NSPG#YZCBSJWBMCBSK#YZCBSJWBMCBZNJ#YZCBSJWBMCBFK#HJ2#RKCBSJSWJCBMCBXJ#RKCBSJSWJCBMCBZY#RKCBSJSWJCBMCBXJDF#RKCBSJSWJCBMCBSK#RKCBSJSWJCBMCBZNJ#RKCBSJSWJCBMCBFK#RKCBSJSWJCBMCBQZZCBS#RKCBSJSWQTBMCBSK#RKCBSJSWQTBMCBZNJ#RKCBSJSWQTBMCBFK#RKCBSJSWQTBMCBQZ1TBNSDZ#RKCBSJSWQTBMCB2NSPG#RKCBSJWBMCBSK#RKCBSJWBMCBZNJ#RKCBSJWBMCBFK#RKSKZNJFKSR";
		colsLName[8] = "�ܼ�#һ��˰������ϼ�#1.��ֵ˰#���У�������ֵ˰#2.����˰#3.Ӫҵ˰#4.��ҵ����˰#5.��������˰#6.��Դ˰#7.�̶��ʲ�Ͷ�ʷ������˰#8.����ά������˰#9.����˰#10.ӡ��˰#11.��������ʹ��˰#12.������ֵ˰#13.����˰#14.��������˰#15.��Ҷ˰#16.����ռ��˰#17.��˰#18.����˰��#������������ϼ�#����:1.�����Ѹ�������#2.�Ļ���ҵ���������#3.�����������Ӳ�Ʒ�����������#4.������û����";
		colsHName[8] = "���#��Ŀ#�ϼ�1#Ӧ���鲹˰��˰����鲿�Ų鲹˰��#Ӧ���鲹˰��˰����鲿�Ų鲹���ɽ�#Ӧ���鲹˰��˰����鲿�Ų鲹����#Ӧ���鲹˰��˰����鲿�Ų鲹����:�Բ鲹˰#Ӧ���鲹˰��˰���������Ų鲹˰��#Ӧ���鲹˰��˰���������Ų鲹���ɽ�#Ӧ���鲹˰��˰���������Ų鲹����#���У�1.�ر���˰����#Ӧ���鲹˰��˰���������Ų鲹2.��˰����#Ӧ���鲹˰���ⲿ�Ų鲹˰��#Ӧ���鲹˰���ⲿ�Ų鲹���ɽ�#Ӧ���鲹˰���ⲿ�Ų鲹����#�ϼ�2#���鲹˰��˰����鲿�Ų鲹С��#���鲹˰��˰����鲿�Ų鲹����#���鲹˰��˰����鲿�Ų鲹С�Ƶط�#���鲹˰��˰����鲿�Ų鲹˰��#���鲹˰��˰����鲿�Ų鲹���ɽ�#���鲹˰��˰����鲿�Ų鲹����#���鲹˰��˰����鲿�Ų鲹����:�Բ鲹˰#���鲹˰��˰���������Ų鲹˰��#���鲹˰��˰���������Ų鲹���ɽ�#���鲹˰��˰���������Ų鲹����#���鲹˰��˰���������Ų鲹���У�1.�ر���˰����#���鲹˰��˰���������Ų鲹2.��˰����#���鲹˰���ⲿ�Ų鲹˰��#���鲹˰���ⲿ�Ų鲹���ɽ�#���鲹˰���ⲿ�Ų鲹����#���˰�����ɽ𡢷�������";
		
		
		sjNum[9] = 2;
		colsL[9] = "SSSRHJ#1ZZS#QZGZZZS#2XFS#3YYS#4QYSDS#5GRSDS#6ZYS#7GDTZFXDJS#8CSWHJSS#9FCS#10YHS#11CZTDSYS#12TDZZS#13CCS#14CLGZS#15YYS#16GDZYS#17QS#18QTSS";
		colsH[9] = "XH#XM#HJ#RKZNJ#HXZNJ#YJWJZNJ";
		colsLName[9] = "˰������ϼ�#1.��ֵ˰#���У�������ֵ˰#2.����˰#3.Ӫҵ˰#4.��ҵ����˰#5.��������˰#6.��Դ˰#7.�̶�Ͷ�ʷ������˰#8.����ά������˰#9.����˰#10.ӡ��˰#11.��������ʹ��˰#12.������ֵ˰#13.����˰#14.��������˰#15.��Ҷ˰#16.����ռ��˰#17.��˰#18.����˰��";
		colsHName[9] = "���#��Ŀ#�ϼ�#������ɽ�#�������ɽ�#Ӧ��δ�����ɽ�";
		
		
		sjNum[10] = 2;
		colsL[10] = "ZJ#YSSSRHJ#1ZZS#QZGZZZS#2XFS#3YYS#4QYSDS#5GRSDS#6ZYS#7GDZCTZFXDJS#8CSWHJSS#9FCS#10YHS#QZZQJYYHS#11CZTDSYS#12TDZZS#13CCS#14CLGZS#15YYS#16GDZYS#17QS#18QTSS#EQTSRHJ#QZJYFFJSR#FQDQDZCPCLJJSR";
		colsH[10] = "XH#XM#HJ#DKDS#WTDZ";
		colsLName[10] = "�ܼ�#һ��˰������ϼ�#1.��ֵ˰#���У�������ֵ˰#2.����˰#3.Ӫҵ˰#4.��ҵ����˰#5.��������˰#6.��Դ˰#7.�̶��ʲ�Ͷ�ʷ������˰#8.����ά������˰#9.����˰#10.ӡ��˰#���У�֤ȯ����ӡ��˰#11.��������ʹ��˰#12.������ֵ˰#13.����˰#14.��������˰#15.��Ҷ˰#16.����ռ��˰#17.��˰#18.����˰��#������������ϼ�#���У������Ѹ�������#�����������Ӳ�Ʒ�����������";
		colsHName[10] = "���#��Ŀ#�ϼ�#���۴���#ί�д���";
		
		
		sjNum[11] = 3;
		colsL[11] = "HJ#NSBZJ#FPBZJ#NSDBJ#SSBQK#PMBMK#QT";
		colsH[11] = "XH#XM#NCYE#SRBY#SRBNLJ#ZCBY#ZCBNLJ#QMYE";
		colsLName[11] = "�ϼ�#��˰��֤��#��Ʊ��֤��#��˰������#˰�ձ�ȫ��#����������#����";
		colsHName[11] = "���#��Ŀ#������#���뱾��#���뱾���ۼ�#֧������#֧�������ۼ�#��ĩ���";
		
		
		sjNum[12] = 2;
		colsL[12] = "ZJ#YSSSRHJ#1ZZS#2XFS#3YYS#4QYSDS#5GRSDS#6ZYS#7GDZCTZFXDJS#8CSWHJSS#9FCS#10YHS#11CZTDSYS#12TDZZS#13CCS#14CLGZS#15YYS#16GDZYS#17QS#18QTSS#EQTSRHJ";
		colsH[12] = "XH#XM#HJ#GTQYDZSJ#KKQYDZSJ#ZFZCXDZSJ#QT";
		colsLName[12] = "�ܼ�#һ��˰������ϼ�#1.��ֵ˰#2.����˰#3.Ӫҵ˰#4.��ҵ����˰#5.��������˰#6.��Դ˰#7.�̶��ʲ�Ͷ�ʷ������˰#8.����ά������˰#9.����˰#10.ӡ��˰#11.��������ʹ��˰#12.������ֵ˰#13.����˰#14.��������˰#15.��Ҷ˰#16.����ռ��˰#17.��˰#18.����˰��#������������ϼ�";
		colsHName[12] = "���#��Ŀ#�ϼ�#�ء�ͣ��ҵ����˰��#�տ���ҵ����˰��#���������Դ���˰��#����";


		sjNum[13] = 3;
		colsL[13] = "HJ#YJTYSFW#1LLYSFW#2SLYSFW#3HKYSFW#4GDYSFW#EYZFW#1YZPBFW#2YZTSFW#3QTYZFW#SDXFW#1JCDXFW#2ZZDXFW#SJZFW#1GCFW#2AZFW#3XSFW#4ZSFW#5QTJZFW#WJRFW#1DKFW#2ZJSFJRFW#3BXFW#4JRSPZR#LXDFW#1YFHJSFW#2XXJSFW#3WHCYFW#4WLFZFW#5ZLFW#6JZZXFW#7GBYSFW#8SWFZFW#9QTXDFW#QSHFW#1WHTYFW#2JYYLFW#3LYYLFW#4CYZSFW#5JMRCFW#6QTSHFW#BXSWXZC#1ZLHFZLJS#2SBHZZQ#3TDSYQ#4QTZRZYSYQ#5QTQYXWXZC#JXSBDC#1JZW#QZESFJY1#2GZW#QZESFJY2";
		colsH[13] = "XH#XM#RKSJ#YZSJNCYE#YZSJQMYE#DZSJNCYE#DZSJQMYE#TTSJ#JMSJ#DJSJ1#ZTSJ#DJSJ2#DCLSSSJ#SSSJHX";
		colsLName[13] = "�ϼ�#һ����ͨ�������#1.½·�������#2.ˮ·�������#3.�����������#4.�ܵ��������#������������#1.�����ձ����#2.�����������#3.������������#�������ŷ���#1.�������ŷ���#2.��ֵ���ŷ���#�ġ���������#1.���̷���#2.��װ����#3.���ɷ���#4.װ�η���#5.������������#�塢���ڷ���#1.�������#2.ֱ���շѽ��ڷ���#3.���շ���#4.������Ʒת��#�����ִ�����#1.�з��ͼ�������#2.��Ϣ��������#3.�Ļ��������#4.������������#5.���޷���#6.��֤��ѯ����#7.�㲥Ӱ�ӷ���#8.����������#9.�����ִ�����#�ߡ��������#1.�Ļ���������#2.����ҽ�Ʒ���#3.�������ַ���#4.����ס�޷���#5.�����ճ�����#6.�����������#�ˡ����������ʲ�#1.ר�����ר������#2.�̱������Ȩ#3.����ʹ��Ȩ#4.������Ȼ��Դʹ��Ȩ#5.����Ȩ���������ʲ�#�š����۲�����#1.������#���У����ַ�����#2.������#���У����ַ�����";
		colsHName[13] = "���#��Ŀ#���˰��#Ӧ��˰��������#Ӧ��˰����ĩ���#����˰��������#����˰����ĩ���#����˰��#����˰��#���˰��#��;˰��#����˰��#��������ʧ˰��#��ʧ˰�����";
		
		sjNum[14] = 3;
		colsL[14] = "HJ#QZBNXQ#WNCQ#GTJKKQYQS#1GNZZS#QZGZZZS#2GNXFS#3YYS#4QYSDS#5GRSDS#6ZYS#7GDZCTZFXDJS#8CSWHJSS#9FCS#10YHS#11CZTDSYS#12TDZZS#13CCS#14CLGZS#15YYS#16GDZYS#17QS#18QTSS";
		colsH[14] = "XH#XM#QMYEHJ#DFXQJRK#DFXQJDJ#DFXQJ#DFXQJQMYE#ZFXQJRK#ZFXQJDJ#ZFXQJHX#ZFXQJQMYE#GFXQJRK#GFXQJDJ#GFXQJHX#GFXQJQMYE#GWQJRK#GWQJDJ#GWQJHX#GWQJQMYE";
		colsLName[14] = "�ϼ�#���У�������Ƿ#�����Ƿ#��ͣ���տ���ҵǷ˰#1.������ֵ˰#���У�������ֵ˰#2.��������˰#3.Ӫҵ˰#4.��ҵ����˰#5.��������˰#6.��Դ˰#7.�̶��ʲ�Ͷ�ʷ������˰#8.����ά������˰#9.����˰#10.ӡ��˰#11.��������ʹ��˰#12.������ֵ˰#13.����˰#14.��������˰#15.��Ҷ˰#16.����ռ��˰#17.��˰#18.����˰��";
		colsHName[14] = "���#��Ŀ#��ĩ���ϼ�#�ͷ���Ƿ�����#�ͷ���Ƿ�ɵֽ�#�ͷ���Ƿ��#�ͷ���Ƿ����ĩ���#�з���Ƿ�����#�з���Ƿ�ɵֽ�#�з���Ƿ�ɺ���#�з���Ƿ����ĩ���#�߷���Ƿ�����#�߷���Ƿ�ɵֽ�#�߷���Ƿ�ɺ���#�߷���Ƿ����ĩ���#��ΣǷ�����#��ΣǷ�ɵֽ�#��ΣǷ�ɺ���#��ΣǷ����ĩ���";
		
		
		//15��ʽ���⴦��
		sjNum[15] = 0;
		colsL[15] = "";
		colsH[15] = "";
		colsLName[15] = "";
		colsHName[15] = "";
		
		sjNum[16] = 2;
		colsL[16] = "HJ#YNZQY#YGYQY#EJTQY#SGFHZQY#SLYQY#QZGYKG1#1GYLYQY#2JTLYQY#3GYYJTLYQY#4QTLYQY#WYXZRGS#QZGYKG2#1GYDZQY#2QTYXZRGS#LGFYXGS#QZ:GYKG#QSYQY#1SYDZQY#2SYHHQY#3SYYXZRGS#4SYGFYXGS#BQTQY#EGATSTZQY#QZGYKG3#1HZJYQYGHATZ#2HZJYQYGHATZ#3GATSDZJYQY#4GATSTZGFYXGS#5QTGATSTZQY#SWSTZQY#QZGYKG4#1ZWHZJYQY#2ZWHZJYQY#3WZQY#4WSTZGFYXGS#5QTWSTZQY#SGTJY#1GTH#2GRHH";
		colsH[16] = "XH#XM#SSSRHJ#GNZZS#QZ��YBNSR#GNXFS#YYS#QYSDS#GRSDS#ZYS#CSWHJSS#FCS#YHS#CZTDSYS#TDZZS#CCS#CLGZS#GDZYS#QS#QTSS";
		colsLName[16] = "�ϼ�#һ��������ҵ#(һ)������ҵ#(��)������ҵ#(��)�ɷݺ�����ҵ#(��)��Ӫ��ҵ#����:���пع�#1.������Ӫ��ҵ#2.������Ӫ��ҵ#3.�����뼯����Ӫ��ҵ#4.������Ӫ��ҵ#(��)�������ι�˾#����:���пع�#1.���ж�����ҵ#2.�����������ι�˾#(��)�ɷ����޹�˾#����:���пع�#(��)˽Ӫ��ҵ#1.˽Ӫ������ҵ#2.˽Ӫ�ϻ���ҵ#3.˽Ӫ�������ι�˾#4.˽Ӫ�ɷ����޹�˾#(��)������ҵ#�����ۡ��ġ�̨��Ͷ����ҵ#����:���пع�#1.���ʾ�Ӫ��ҵ���ۻ�ġ�̨�ʣ�#2.������Ӫ��ҵ���ۻ�ġ�̨�ʣ�#3.�ۡ��ġ�̨�̶��ʾ�Ӫ��ҵ#4.�ۡ��ġ�̨��Ͷ�ʹɷ����޹�˾#5.�����ۡ��ġ�̨��Ͷ����ҵ#��������Ͷ����ҵ#����:���пع�#1.������ʾ�Ӫ��ҵ#2.���������Ӫ��ҵ#3.������ҵ#4.����Ͷ�ʹɷ����޹�˾#5.��������Ͷ����ҵ#�ġ����徭Ӫ#1.���廧#2.���˺ϻ�";
		colsHName[16] = "���#��Ŀ#˰������ϼ�#������ֵ˰#���У�һ����˰��#��������˰#Ӫҵ˰#��ҵ����˰#��������˰#��Դ˰#����ά������˰#����˰#ӡ��˰#��������ʹ��˰#������ֵ˰#����˰#��������˰#����ռ��˰#��˰#����˰��";
		
		sjNum[17] = 3;
		colsL[17] = "YZZSSRHJ#YGNZZS#1CKY#1MTKCHXXY#2SYHTRQKCY#QZYY#3HSJSKCXY#4YSJSKCXY#5FJSKCXY#6QTCKY#2ZZY#1NFSPJGY#2SPZZY#3JYLHJZCZZY#JDZZ#QZJJ#YLZZ#JZCZZ#4YCZPY#YYFK#JYZZ#QTYCZPZZ#5FZY#6FZFZFSY#QZJZFZZZ#7PGMPYMJQZPHZXY#QZPGMP#8MCJGJMZTZCZPY#9JJZZY#10ZZJZZPY#ZJZZ#ZZ#QZJZZJZBZZ#ZZPZZ#11YSHJLMJFZY#12WJGMTYHYLYPZZY#13SYJGLJHHRLJGY#YYJGJSYZPZZ#QZCPY#RZYYZZ#LJ#HRLJG#14HXYLJHXZPY#FLZZ#NYZZ#ZYHXCPZZ#RYHXCPZZ#QZHZPZZ#QT1#15YYZZY#16HXXWZZY#17XJHSLZPY#QZLTZZ#18FJSKWZPY#SNSHHSGZZ#QZSNZZ#SNJSGZPZZ#BLJBLZPZZ#QT2#19HSJSYLJYYJGY#QZGYYJG#20YSJSYLJYYJGY#21JSZPY#22TYSBZZY#23ZYSBZZY#24QCZZY#QZQCZCZZ#DCZZ#25TLCBHKHTHQTYSSBZZY#QZTLYSSBZZ#CBJXGZZZZ#HKHTJSBZZ#MTCZZ#26DQJXHQCZZY#DJZZ#DXDLGLJDGQCZZ#JYDLQJZZ#QT3#27JSJTXHQTDZSBZZY#JSJZZ#TXSBZZ#GBDSSBZZ#STSBZZ#QT4#28YBYQZZY#29QTZZY#3DLRLRQJSDSCHGYY#1DLRLSCHGYY#DLSC#QZHLFD#SLFD#HLFD#FLFD#TYNFD#DLGY#RLSCHGY#2RQSCHGYY#3SDSCHGYY#4PFHLSY#1PFY#SPYLJYCZPPF#QZYCZPPF#FZFZJJTYPPF#KCPJCJHGCPPF#QZMTJZPPF#SYJZPPF#JCPF#JXSBWJJDJDZCPPF#QZQCPF#MTCJLPJPF#DQSBPF#JSJRJJFZSBPF#QT5#2LSY#5JTYSCCHYZY#1JTYSY#TLYSY#DLYSY#SSYSY#HKYSY#GDYSY#ZXBYHYSDLY#2CCY#3YZY#6ZSHCYY#1ZSY#2CYY#7XXCSRJHXXJSFWY#1DXGBDSHWXCSFWY#QZDX#2HLWHXGFW#3RJHXXJSFWY#8JRY#1HBJRFW#QZYX#JRZL#2ZBSCFW#3BXY#4QTJRY#9FDCY#1FDCKFJYY#2WYGL#3FDCZJFW#4ZYFDCJYHD#5QTFDCY#10ZLHSWFWY#1ZLY#2SWFWY#QZZXYDC#GGY#ZSCQFW#HYJZLFW#11KXYJHJSFWY#1YJHSYFZ#2ZYJSFWY#QZZYHSJFW#3KJTGHYYFWY#12JMFWXLHQTFWY#QZJMFWY#JDCDZCPHRYCPXLY#13JY#14WSHSHGZ#QZWS#15WHTYHYLY#QZXWHCBY#GBDSDYHYSLYZZY#TY#YLY#16GGGLSHBZHSHZZ#17JZY#1FWJZY#2TMGCJZY#3JZAZY#4JZZSHQTJZY#18SLHJHGGSSGLY#QZGGSSGLY#19QTXY#EJKHWZZS#ECKTZZSHJ";
		colsH[17] = "XH#XM#HJ#QZMDDK#NZQYXJ#NZQYGYQY#NZQYJTQY#NZQYGFHZQY#NZQYLYQY#NZQYQZGYKG1#NZQYGFGS#NZQYQZGYKG2#NZQYSYQY#NZQYQTQY#GATTZQY#QZGYKG1#WSTZQY#QZGYKG2#GTJY#FLZLGDZCJXSE#SJDKZZS#DDKGDZCJXSE";
		colsLName[17] = "һ����ֵ˰����ϼ�#(һ)������ֵ˰#1.�ɿ�ҵ#(1)ú̿���ɺ�ϴѡҵ#(2)ʯ�ͺ���Ȼ������ҵ#���У�ԭ��#(3)��ɫ�������ѡҵ#(4)��ɫ�������ѡҵ#(5)�ǽ������ѡҵ#(6)�����ɿ�ҵ#2.����ҵ#(1)ũ��ʳƷ�ӹ�ҵ#(2)ʳƷ����ҵ#(3)�ơ����Ϻ;��Ʋ�����ҵ#�پƵ�����#���У��ƾ�#����������#�۾��Ʋ�����#(4)�̲���Ʒҵ#����Ҷ����#�ھ�������#�������̲���Ʒ����#(5)��֯ҵ#(6)��֯��װ������ҵ#���У���֯��װ����#(7)Ƥ�ëƤ����ë������Ʒ����Ьҵ#���У�Ƥ�ëƤ#(8)ľ�ļӹ���ľ�����ز���Ʒҵ#(9)�Ҿ�����ҵ#(10)��ֽ��ֽ��Ʒҵ#��ֽ������#����ֽ#���У�����ֽ��ֽ������#��ֽ��Ʒ����#(11)ӡˢ�ͼ�¼ý�鸴��ҵ#(12)�Ľ̡�������������������Ʒ����ҵ#(13)ʯ�ͼӹ��������ͺ�ȼ�ϼӹ�ҵ#��ԭ�ͼӹ���ʯ����Ʒ����#���У���Ʒ��#������ԭ������#������#�ܺ�ȼ�ϼӹ�#(14)��ѧԭ�ϼ���ѧ��Ʒҵ#�ٷ�������#��ũҩ����#��ר�û�ѧ��Ʒ����#�����û�ѧ��Ʒ����#���У���ױƷ����#������#(15)ҽҩ����ҵ#(16)��ѧ��ά����ҵ#(17)�𽺺�������Ʒҵ#���У���̥����#(18)�ǽ���������Ʒҵ#��ˮ�ࡢʯ�Һ�ʯ������#���У�ˮ������#��ˮ�༰ʯ����Ʒ����#�۲�����������Ʒ����#������#(19)��ɫ����ұ����ѹ�Ӽӹ�ҵ#���У���ѹ�Ӽӹ�#(20)��ɫ����ұ����ѹ�Ӽӹ�ҵ#(21)������Ʒҵ#(22)ͨ���豸����ҵ#(23)ר���豸����ҵ#(24)��������ҵ#���У�������������#�糵����#(25)��·�����������պ�������������豸����ҵ#���У���·�����豸����#���������װ������#���ա����켰�豸����#Ħ�г�����#(26)������е����������ҵ#�ٵ������#�ڵ��ߵ��¹��¼��繤��������#�ۼ��õ�����������#������#(27)�������ͨ�ź����������豸����ҵ#�ټ��������#��ͨ���豸����#�۹㲥�����豸����#�������豸����#������#(28)�Ǳ���������ҵ#(29)��������ҵ#3.������������ȼ����ˮ�������͹�Ӧҵ#(1)���������������͹�Ӧҵ#�ٵ�������#���У���������#ˮ������#��������#��������#̫���ܷ���#�ڵ�����Ӧ#�����������͹�Ӧ#(2)ȼ�������͹�Ӧҵ#(3)ˮ�������͹�Ӧҵ#4.����������ҵ#(1)����ҵ#��ʳƷ�����ϼ��̲���Ʒ����#����:�̲���Ʒ����#�ڷ�֯����װ����ͥ��Ʒ����#�ۿ��Ʒ�����ļ�������Ʒ����#���У�ú̿����Ʒ����#ʯ�ͼ���Ʒ����#��������#�ܻ�е�豸����𽻵缰���Ӳ�Ʒ����#���У���������#Ħ�г������������#�����豸����#�����������������豸����#������#(2)����ҵ#5.��ͨ���䡢�ִ�������ҵ#(1)��ͨ����ҵ#��·����ҵ#��·����ҵ#ˮ������ҵ#��������ҵ#�ܵ�����ҵ#װж���˺��������ҵ#(2)�ִ�ҵ#(3)����ҵ#6.ס�޺Ͳ���ҵ#(1)ס��ҵ#(2)����ҵ#7.��Ϣ���䡢�������Ϣ��������ҵ#(1)���š��㲥���Ӻ����Ǵ������ҵ#���У�����#(2)����������ط���#(3)�������Ϣ��������ҵ#8.����ҵ#(1)���ҽ��ڷ���#���У�����#��������#(2)�ʱ��г�����#(3)����ҵ#(4)��������ҵ#9.���ز�ҵ#(1)���ز�������Ӫҵ#(2)��ҵ����#(3)���ز��н����#(4)���з��ز���Ӫ�#(5)�������ز�ҵ#10.���޺��������ҵ#(1)����ҵ#(2)�������ҵ#���У���ѯ�����#���ҵ#֪ʶ��Ȩ����#���鼰չ������#11.��ѧ�о��ͼ�������ҵ#(1)�о���ʵ�鷢չ#(2)רҵ��������ҵ#���У�רҵ����Ʒ���#(3)�Ƽ��ƹ��Ӧ�÷���ҵ#12.��������������������ҵ#���У��������ҵ#�����������Ӳ�Ʒ�����ò�Ʒ����ҵ#13.����#14.��������Ṥ��#���У�����#15.�Ļ�������������ҵ#���У����źͳ���ҵ#�㲥�����ӡ���Ӱ��Ӱ��¼������ҵ#����#����ҵ#16.����������ᱣ�Ϻ������֯#17.����ҵ#(1)���ݽ���ҵ#(2)��ľ���̽���ҵ#(3)������װҵ#(4)����װ�κ���������ҵ#18.ˮ���������͹�����ʩ����ҵ#���У�������ʩ����ҵ#19.������ҵ#(��)���ڻ�����ֵ˰#������������ֵ˰�ϼ�";
		colsHName[17] = "���#��Ŀ#�ϼ�#����:��ֵ���#������ҵС��#������ҵ������ҵ#������ҵ������ҵ#������ҵ�ɷݺ�����ҵ#������ҵ��Ӫ��ҵ#������ҵ���У����пع�#������ҵ�ɷݹ�˾#������ҵ���У����пع�#������ҵ˽Ӫ��ҵ#������ҵ������ҵ#�۰�̨Ͷ����ҵ#���У����пع�#����Ͷ����ҵ#���У����пع�#���徭Ӫ#�������ϣ��̶��ʲ�����˰��#ʵ�ʵֿ���ֵ˰#���ֿ۹̶��ʲ�����˰��";
		
		sjNum[18] = 3;
		colsL[18] = "YXFSSR#YGNXFS#1JJJJ#1BJ#2HJ#3PJ#4QTJ#5JJ#2Y#1GYJY#QZA56SLZS#A36SLZS#2XQY#3YS#4SYPFJY#3CPY#1QY#2CY#3SNY#4RJY#5RHY#6RLY#7HKMY#4XQC#1CYC#A1SLZS#A3SLZS#A5SLZS#A9SLZS#A12SLZS#A25SLZS#A40SLZS#2ZQXSYKC#3CHHXQC#5MTC#6GEFQJQJ#7QCLT#8GDHZP#9GZSS#10BPYH#11GDSB#12YT#13MZYCXKZ#14SMDB#15DC#16TL#17QT#18SKZNJFKSR#EJKXFPXFS#ECKXFPTXFS";
		colsH[18] = "XH#XM#HJ#NZQYXJ#NZQYGYQY#NZQYJTQY#NZQYGFHZQY#NZQYLYQY#NZQYQZGYKG1#NZQYGFGS#NZQYQZGYKG2#NZQYSYQY#NZQYQTQY#GATTZQY#QZGYKG1#WSTZQY#QZGYKG2#GTJY";
		colsLName[18] = "һ������˰����#(һ)��������˰#1.�Ƽ��ƾ�#(1)�׾�#(2)�ƾ�#(3)ơ��#(4)������#(5)�ƾ�#2.��#(1)��ҵ����#���У���56%˰������#��36%˰������#(2)ѩ����#(3)��˿#(4)��ҵ��������#3.��Ʒ��#(1)����#(2)����#(3)ʯ����#(4)�ܼ���#(5)����#(6)ȼ����#(7)����ú��#4.С����#(1)���ó�#��1%˰������#��3%˰������#��5%˰������#��9%˰������#��12%˰������#��25%˰������#��40%˰������#(2)���������ÿͳ�#(3)������С����#5.Ħ�г�#6.�߶��������#7.������̥#8.�ߵ���ױƷ#9.��������#10.�������#11.�ߵ��ֱ�#12.��ͧ#13.ľ��һ���Կ���#14.ʵľ�ذ�#15.���#16.Ϳ��#17.����#18.˰�����ɽ𷣿�����#(��)��������Ʒ����˰#������������Ʒ������˰";
		colsHName[18] = "���#��Ŀ#�ϼ�#������ҵС��#������ҵ������ҵ#������ҵ������ҵ#������ҵ�ɷݺ�����ҵ#������ҵ��Ӫ��ҵ#������ҵ���У����пع�#������ҵ�ɷݹ�˾#������ҵ���У����пع�#������ҵ˽Ӫ��ҵ#������ҵ������ҵ#�۰�̨Ͷ����ҵ#���У����пع�#����Ͷ����ҵ#���У����пع�#���徭Ӫ";
		
		
		//19��ʽ���⴦��
		sjNum[19] = 0;
		colsL[19] = "ZJ#YCKY#1MTKCHXXY#2SYHTRQKCY#QZYY#3HSJSKCXY#4YSJSKCXY#5FJSKCXY#6QTCKY#EZZY#1NFSPJGY#2SPZZY#3JYLHJZCZZY#JDZZ#QZJJ#YLZZ#JZCZZ#4YCZPY#YYFK#JYZZ#QTYCZPJG#5FZY#6FZFZFSY#QZFZFZ#7PGMPYMJQZPHZXY#QZPGMP#8MCJGHMZTZCZPY#9JJZZY#10ZZHZZPY#ZJZZ#ZZ#QZJZZJZBZZ#ZZPZZ#11YSHJLMJFZY#12WJGMTYHYLYPZZY#13SYJGLJHHRLJGY#QZCPY#14HXYLHHXZPZZY#FLZZ#NYZZ#ZYHXCPZZ#RYHXCPZZ#QZHZPZZ#QT1#15YYZZY#16HXXWZZY#17XJHSLZPY#QZLTZZ#18FJSKWZPY#SNSHHSGZZ#QZSNZZ#SNJSGZPZZ#BLJBLZPZZ#QT2#19HSJSYLHYYJGY#QZGYYJG#20YSJSYLHYYJGY#21JSZPY#22TYSBZZY#23ZYSBZZY#24QCZZY#25TLCBHKHTHQTYSSBZZY#QZTLYSSBZZ#CBJXGZZZZ#HKHTJSBZZ#MTCZZ#26DQJXHQCZZY#DJZZ#DXDLGLJDGQCZZ#JYDLQJZZ#QT3#27JSJTXHQTDZSBZZY#JSJZZ#TXSBZZ#GBDSSBZZ#STSBZZ#QT#28YBYQZZY#29QTZZY#SDLRLRQJSDSCHGYY#1DLRLSCHGYY#DLSC#QZHLFD#SLFD#HLFD#FLFD#TYNFD#DLGY#RLSCHGYY#2RQSCHGYY#3SDSCHGYY#SJZY#1FWJZY#2TMGCJZY#3JZAZY#4JZZSHQTJZY#WPFHLSY#1PFY#QZYCZPPF#MTJZPPF#SYJQZPPF#QCJLPJPF#2LSY#LJTYSCCHYZY#1JTYSY#2CCY#3YZY#QZSHCYY#1ZSY#2CYY#BXXCSRJHXXJSFWY#1DXGBDSHWXCSFWY#QZDX#2HLWHXGFW#3RJHXXJSFWY#JJRY#1HBJRFW#QZYX#JRZL#2ZBSCFW#3BXY#4QTJRY#SFDCY#SYZLHSWFWY#1ZLY#2SWFWY#SEKXYJHJSFWY#SSJMFWXLHQTFWY#QZJMFWY#JDCDZCPHRYCPXLY#SSJY#SWWSHSHGZ#QZWS#SLWHTYHYLY#QZXWHCBY#GBDSDYHYSLYZZY#TY#YLY#SQGGGLSHBZHSHZZ#SBQTXY";
		colsH[19] = "XH#XM#HJ#NZQYXJ#NZQYGYQY#NZQYJTQY#NZQYGFHZQY#NZQYLYQY#NZQYQZGYKG1#NZQYGFGS#NZQYQZGYKG2#NZQYSYQY#NZQYQTQY#GATTZQY#QZGYKG1#WSTZQY#QZGYKG2";
		colsLName[19] = "�ܼ�#(һ)�ɿ�ҵ#1.ú̿���ɺ�ϴѡҵ#2.ʯ�ͺ���Ȼ������ҵ#����:ԭ��#3.��ɫ�������ѡҵ#4.��ɫ�������ѡҵ#5.�ǽ������ѡҵ#6.�����ɿ�ҵ#(��)����ҵ#1.ũ��ʳƷ�ӹ�ҵ#2.ʳƷ����ҵ#3.�ơ����Ϻ;��Ʋ�����ҵ#�پƵ�����#���У��ƾ�#����������#�۾��Ʋ�����#4.�̲���Ʒҵ#��Ҷ����#��������#�����̲���Ʒ�ӹ�#5.��֯ҵ#6.��֯��װ������ҵ#���У���֯��װ#7.Ƥ�ëƤ����ë������Ʒ����Ьҵ#���У�Ƥ�ëƤ#8.ľ�ļӹ���ľ�����ز���Ʒҵ#9.�Ҿ�����ҵ#10.��ֽ��ֽ��Ʒҵ#��ֽ������#����ֽ#���У�����ֽ��ֽ������#��ֽ��Ʒ����#11.ӡˢ�ͼ�¼ý�鸴��ҵ#12.�Ľ̡�������������������Ʒ����ҵ#13.ʯ�ͼӹ��������ͺ�ȼ�ϼӹ�ҵ#���У���Ʒ��#14.��ѧԭ�Ϻͻ�ѧ��Ʒ����ҵ#�ٷ�������#��ũҩ����#��ר�û�ѧ��Ʒ����#�����û�ѧ��Ʒ����#���У���ױƷ����#������#15.ҽҩ����ҵ#16.��ѧ��ά����ҵ#17.�𽺺�������Ʒҵ#���У���̥����#18.�ǽ���������Ʒҵ#��ˮ�ࡢʯ�Һ�ʯ������#���У�ˮ������#��ˮ�༰ʯ����Ʒ����#�۲�����������Ʒ����#������#19.��ɫ����ұ����ѹ�Ӽӹ�ҵ#���У���ѹ�Ӽӹ�#20.��ɫ����ұ����ѹ�Ӽӹ�ҵ#21.������Ʒҵ#22.ͨ���豸����ҵ#23.ר���豸����ҵ#24.��������ҵ#25.��·�����������պ�������������豸����ҵ#���У���·�����豸����#���������װ������#���ա����켰�豸����#Ħ�г�����#26.������е����������ҵ#�ٵ������#�ڵ��ߵ��¹��¼��繤��������#�ۼ��õ�����������#������#27.�������ͨ�ź����������豸����ҵ#�ټ��������#��ͨ���豸����#�۹㲥�����豸����#�������豸����#������#28.�Ǳ���������ҵ#29.��������ҵ#(��)������������ȼ����ˮ�������͹�Ӧҵ#1.���������������͹�Ӧҵ#�ٵ�������#���У���������#ˮ������#��������#��������#̫���ܷ���#�ڵ�����Ӧ#�����������͹�Ӧҵ#2.ȼ�������͹�Ӧҵ#3.ˮ�������͹�Ӧҵ#(��)����ҵ#1.���ݽ���ҵ#2.��ľ���̽���ҵ#3.������װҵ#4.����װ�κ���������ҵ#(��)����������ҵ#1.����ҵ#����:�̲���Ʒ����#ú̿����Ʒ����#ʯ�ͼ�����Ʒ����#���������������#2.����ҵ#(��)��ͨ���䡢�ִ�������ҵ#1.��ͨ����ҵ#2.�ִ�ҵ#3.����ҵ#(��)ס�޺Ͳ���ҵ#1.ס��ҵ#2.����ҵ#���ˣ���Ϣ���䡢�������Ϣ��������ҵ#1.���š��㲥���Ӻ����Ǵ������ҵ#���У�����#2.����������ط���#3.�������Ϣ��������ҵ#(��)����ҵ#1.���ҽ��ڷ���#���У�����#��������#2.�ʱ��г�����#3.����ҵ#4.��������ҵ#(ʮ)���ز�ҵ#(ʮһ)���޺��������ҵ#1.����ҵ#2.�������ҵ#(ʮ������ѧ�о��ͼ�������ҵ#(ʮ������������������������ҵ#���У��������ҵ#�����������Ӳ�Ʒ�����ò�Ʒ����ҵ#(ʮ��)����#(ʮ��)��������Ṥ��#���У�����#(ʮ��)�Ļ�������������ҵ#���У����źͳ���ҵ#�㲥�����ӡ���Ӱ��Ӱ��¼������ҵ#����#����ҵ#(ʮ��)����������ᱣ�Ϻ������֯#(ʮ��)������ҵ";
		colsHName[19] = "���#��Ŀ#�ϼ�#������ҵС��#������ҵ������ҵ#������ҵ������ҵ#������ҵ�ɷݺ�����ҵ#������ҵ��Ӫ��ҵ#������ҵ���У����пع�#������ҵ�ɷݹ�˾#������ҵ���У����пع�#������ҵ˽Ӫ��ҵ#������ҵ������ҵ#�۰�̨Ͷ����ҵ#���У����пع�#����Ͷ����ҵ#���У����пع�";
		
		
		sjNum[20] = 2;
		colsL[20] = "ZJ#YCKY#1MTKCHXXY#2SYHTRQKCY#QZYY#3HSJSKCXY#4YSJSKCXY#5FJSKCXY#6QTCKY#EZZY#1NFSPJGY#2SPZZY#3JYLHJZCZZY#JDZZ#QZJJ#YLZZ#JZCZZ#4YCZPY#YYFK#JYZZ#QTYCZPJG#5FZY#6FZFZFSY#QZFZFZ#7PGMPYMJQZPHZXY#QZPGMP#8MCJGHMZTZCZPY#9JJZZY#10ZZHZZPY#ZJZZ#ZZ#QZJZZJZBZZ#ZZPZZ#11YSHJLMJFZY#12WJGMTYHYLYPZZY#13SYJGLJHHRLJGY#QZCPY#14HXYLHHXZPZZY#FLZZ#NYZZ#ZYHXCPZZ#RYHXCPZZ#QZHZPZZ#QT1#15YYZZY#16HXXWZZY#17XJHSLZPY#QZLTZZ#18FJSKWZPY#SNSHHSGZZ#QZSNZZ#SNJSGZPZZ#BLJBLZPZZ#QT2#19HSJSYLHYYJGY#QZGYYJG#20YSJSYLHYYJGY#21JSZPY#22TYSBZZY#23ZYSBZZY#24QCZZY#25TLCBHKHTHQTYSSBZZY#QZTLYSSBZZ#CBJXGZZZZ#HKHTJSBZZ#MTCZZ#26DQJXHQCZZY#DJZZ#DXDLGLJDGQCZZ#JYDLQJZZ#QT3#27JSJTXHQTDZSBZZY#JSJZZ#TXSBZZ#GBDSSBZZ#STSBZZ#QT#28YBYQZZY#29QTZZY#SDLRLRQJSDSCHGYY#1DLRLSCHGYY#DLSC#QZHLFD#SLFD#HLFD#FLFD#TYNFD#DLGY#RLSCHGYY#2RQSCHGYY#3SDSCHGYY#SJZY#1FWJZY#2TMGCJZY#3JZAZY#4JZZSHQTJZY#WPFHLSY#1PFY#QZYCZPPF#MTJZPPF#SYJQZPPF#QCJLPJPF#2LSY#LJTYSCCHYZY#1JTYSY#2CCY#3YZY#QZSHCYY#1ZSY#2CYY#BXXCSRJHXXJSFWY#1DXGBDSHWXCSFWY#QZDX#2HLWHXGFW#3RJHXXJSFWY#JJRY#1HBJRFW#QZYX#JRZL#2ZBSCFW#3BXY#4QTJRY#SFDCY#SYZLHSWFWY#1ZLY#2SWFWY#SEKXYJHJSFWY#SSJMFWXLHQTFWY#QZJMFWY#JDCDZCPHRYCPXLY#SSJY#SWWSHSHGZ#QZWS#SLWHTYHYLY#QZXWHCBY#GBDSDYHYSLYZZY#TY#YLY#SQGGGLSHBZHSHZZ#SBQTXY";
		colsH[20] = "XH#XM#HJ#YJ#HSQJ#JNYQNDQS";
		colsLName[20] = "�ܼ�#(һ)�ɿ�ҵ#1.ú̿���ɺ�ϴѡҵ#2.ʯ�ͺ���Ȼ������ҵ#����:ԭ��#3.��ɫ�������ѡҵ#4.��ɫ�������ѡҵ#5.�ǽ������ѡҵ#6.�����ɿ�ҵ#(��)����ҵ#1.ũ��ʳƷ�ӹ�ҵ#2.ʳƷ����ҵ#3.�ơ����Ϻ;��Ʋ�����ҵ#�پƵ�����#���У��ƾ�#����������#�۾��Ʋ�����#4.�̲���Ʒҵ#��Ҷ����#��������#�����̲���Ʒ�ӹ�#5.��֯ҵ#6.��֯��װ������ҵ#���У���֯��װ#7.Ƥ�ëƤ����ë������Ʒ����Ьҵ#���У�Ƥ�ëƤ#8.ľ�ļӹ���ľ�����ز���Ʒҵ#9.�Ҿ�����ҵ#10.��ֽ��ֽ��Ʒҵ#��ֽ������#����ֽ#���У�����ֽ��ֽ������#��ֽ��Ʒ����#11.ӡˢ�ͼ�¼ý�鸴��ҵ#12.�Ľ̡�������������������Ʒ����ҵ#13.ʯ�ͼӹ��������ͺ�ȼ�ϼӹ�ҵ#���У���Ʒ��#14.��ѧԭ�Ϻͻ�ѧ��Ʒ����ҵ#�ٷ�������#��ũҩ����#��ר�û�ѧ��Ʒ����#�����û�ѧ��Ʒ����#���У���ױƷ����#������#15.ҽҩ����ҵ#16.��ѧ��ά����ҵ#17.�𽺺�������Ʒҵ#���У���̥����#18.�ǽ���������Ʒҵ#��ˮ�ࡢʯ�Һ�ʯ������#���У�ˮ������#��ˮ�༰ʯ����Ʒ����#�۲�����������Ʒ����#������#19.��ɫ����ұ����ѹ�Ӽӹ�ҵ#���У���ѹ�Ӽӹ�#20.��ɫ����ұ����ѹ�Ӽӹ�ҵ#21.������Ʒҵ#22.ͨ���豸����ҵ#23.ר���豸����ҵ#24.��������ҵ#25.��·�����������պ�������������豸����ҵ#���У���·�����豸����#���������װ������#���ա����켰�豸����#Ħ�г�����#26.������е����������ҵ#�ٵ������#�ڵ��ߵ��¹��¼��繤��������#�ۼ��õ�����������#������#27.�������ͨ�ź����������豸����ҵ#�ټ��������#��ͨ���豸����#�۹㲥�����豸����#�������豸����#������#28.�Ǳ���������ҵ#29.��������ҵ#(��)������������ȼ����ˮ�������͹�Ӧҵ#1.���������������͹�Ӧҵ#�ٵ�������#���У���������#ˮ������#��������#��������#̫���ܷ���#�ڵ�����Ӧ#�����������͹�Ӧҵ#2.ȼ�������͹�Ӧҵ#3.ˮ�������͹�Ӧҵ#(��)����ҵ#1.���ݽ���ҵ#2.��ľ���̽���ҵ#3.������װҵ#4.����װ�κ���������ҵ#(��)����������ҵ#1.����ҵ#����:�̲���Ʒ����#ú̿����Ʒ����#ʯ�ͼ�����Ʒ����#���������������#2.����ҵ#(��)��ͨ���䡢�ִ�������ҵ#1.��ͨ����ҵ#2.�ִ�ҵ#3.����ҵ#(��)ס�޺Ͳ���ҵ#1.ס��ҵ#2.����ҵ#���ˣ���Ϣ���䡢�������Ϣ��������ҵ#1.���š��㲥���Ӻ����Ǵ������ҵ#���У�����#2.����������ط���#3.�������Ϣ��������ҵ#(��)����ҵ#1.���ҽ��ڷ���#���У�����#��������#2.�ʱ��г�����#3.����ҵ#4.��������ҵ#(ʮ)���ز�ҵ#(ʮһ)���޺��������ҵ#1.����ҵ#2.�������ҵ#(ʮ������ѧ�о��ͼ�������ҵ#��ʮ������������������������ҵ#���У��������ҵ#�����������Ӳ�Ʒ�����ò�Ʒ����ҵ#(ʮ��)����#��ʮ�壩��������Ṥ��#���У�����#(ʮ��)�Ļ�������������ҵ#���У����źͳ���ҵ#�㲥�����ӡ���Ӱ��Ӱ��¼������ҵ#����#����ҵ#(ʮ��)����������ᱣ�Ϻ������֯#(ʮ��)������ҵ";
		colsHName[20] = "���#��Ŀ#�ϼ�#Ԥ��#�������#������ǰ���Ƿ˰";
		
		sjNum[21] = 2;
		colsL[21] = "ZJ#1GZXJSD#A3SLZS#A10SLZS1#A20SLZS1#A25SLZS#A30SLZS1#A35SLZS1#A45SLZS#2GTGSHSCJYSD#A5SLZS1#A10SLZS2#A20SLZS2#A30SLZS2#A35SLZS2#HDZS1#3QSYDWCBCZJYSD#A5SLZS#A10SLZS#A20SLZS3#A30SLZS3#A35SLZS#HDZS#4LWBCSD#A20SLZS#A30SLZS#A40SLZS#5GCSD#6TXQSYFSD#7LXGXHLSD#QZCXCKLXSD#8CCZLSD#9CCZRSD#QZXSGZRSD#FWZRSD#10ORSD#11QTSD#12SKZNJFKSR";
		colsH[21] = "XH#XM#HJ#DL#GAT#WG";
		colsLName[21] = "�ܼ�#1�����ʡ�н������#��3%˰������#��10%˰������#��20%˰������#��25%˰������#��30%˰������#��35%˰������#��45%˰������#2�����幤�̻���������Ӫ����#��5%˰������#��10%˰������#��20%˰������#��30%˰������#��35%˰������#�˶�����#3������ҵ��λ�а������⾭Ӫ����#��5%˰������#��10%˰������#��20%˰������#��30%˰������#��35%˰������#�˶�����#4�����񱨳�����#��20%˰������#��30%˰������#��40%˰������#5���������#6������Ȩʹ�÷�����#7����Ϣ����Ϣ����������#���У���������Ϣ����#8���Ʋ���������#9���Ʋ�ת������#���У����۹�ת������#����ת������#10��żȻ����#11����������#12��˰�����ɽ𡢷�������";
		colsHName[21] = "���#��Ŀ#�ϼ�#��½#�۰�̨#���";
		
		sjNum[22] = 3;
		colsL[22] = "ZJ#YNYK#1MT#2YY#3TRQ#4MCCQ#5DR#6QTNYK#EJSK#1TK#2JK#3TK#4LTK#5QXK#6NK#7XK#8ZZXTK#9QXTK#10WK#11ZK#12MK#13YK#14QTJSK#SFJSK#1SM#2GZT#3GLT#4YS#5SHS#6LTK#7LK#8LHJ#9LSJ#10ZT#11SS#12JKY#13HY#14HY#15DXLSSZDY#16KQS#17DLY#18HGY#19NHZT#20MX#21QTFJSK#SSZY#1DBS#2DXS#WQT#LSKZNJFKSR";
		colsH[22] = "XH#XM#HJ#NZQYXJ#NZQYGYQY#NZQYJTQY#NZQYGFHZQY#NZQYLYQY#NZQYQZGYKG1#NZQYGFGS#NZQYQZGYKG2#NZQYSYQY#NZQYQTQY#GATTZQY#QZGYKG1#WSTZQY#QZGYKG2#GTJY";
		colsLName[22] = "�ܼ�#һ����Դ��#1.ú̿#2.ԭ��#3.��Ȼ��#4.ú�㣨�ɣ���#5.����#6.������Դ��#����������#1.����#2.���#3.ͭ��#4.������#5.Ǧп��#6.����#7.����#8.����ϡ����#9.��ϡ����#10.�ٿ�#11.���#12.�̿�#13.����#14.����������#�����ǽ�����#1.ʯī#2.������#3.������#4.өʯ#5.ʯ��ʯ#6.������#7.�׿�#8.�Ȼ���#9.�����#10.ճ��#11.ɰʯ#12.������#13.����#14.����#15.����±ˮɹ�Ƶ���#16.��Ȫˮ#17.������#18.������#19.�ͻ�ճ��#20.â��#21.�����ǽ�����#�ġ�ˮ��Դ#1.�ر�ˮ#2.����ˮ#�塢����#����˰�����ɽ𡢷�������";
		colsHName[22] = "���#��Ŀ#�ϼ�#������ҵС��#������ҵ������ҵ#������ҵ������ҵ#������ҵ�ɷݺ�����ҵ#������ҵ��Ӫ��ҵ#������ҵ���У����пع�#������ҵ�ɷݹ�˾#������ҵ���У����пع�#������ҵ˽Ӫ��ҵ#������ҵ������ҵ#�۰�̨Ͷ����ҵ#���У����пع�#����Ͷ����ҵ#���У����пع�#���徭Ӫ";
		
		sjNum[23] = 2;
		colsL[23] = "YSWSSSR1#YZWHZJYQY2#1CKY3#2ZZY4#3DLRLRQJSDSCHGYY5#4JZY6#5PFHLSY7#6JTYSCCHYZY8#7ZSHCYY9#8XXCSRJHXXJSFWY10#9JRY11#10FDCY12#11ZLHSWFWY13#12KXYJHJSFWY14#13WHTYHYLY15#14QTXY16#EZWHZJYQY17#1CKY18#2ZZY19#3DLRLRQJSDSCHGYY20#4JZY21#5PFHLSY22#6JTYSCCHYZY23#7ZSHCYY24#8XXCSRJHXXJSFWY25#9JRY26#10FDCY27#11ZLHSWFWY28#12KXYJHJSFWY29#13WHTYHYLY30#14QTXY31#SWZQY32#1CKY33#2ZZY34#3DLRLRQJSDSCHGYY35#4JZY36#5PFHLSY37#6JTYSCCHYZY38#7ZSHCYY39#8XXCSRJHXXJSFWY40#9JRY41#10FDCY42#11ZLHSWFWY43#12KXYJHJSFWY44#13WHTYHYLY45#14QTXY46#SFJMQY47#1WGQYCZDBJG48#2TGLWCBGCZY49#3JRHBX50#4GJYSSR51#5ZFDWKJ52#6QT53#WWJGR54#LJKHWSS55#ECKHWTS56";
		colsH[23] = "XH#XM#HJ#ZZS#XFS#YYS#QYSDS#GRSDS#CSWHJSS#FCS#CZTDSYS#CCS#QTGS";
		colsLName[23] = "һ������˰������#��һ��������ʾ�Ӫ��ҵ#1���ɿ�ҵ#2������ҵ#3��������������ȼ����ˮ�������͹�Ӧҵ#4������ҵ#5������������ҵ#6����ͨ���䡢�ִ�������ҵ#7��ס�޺Ͳ���ҵ#8����Ϣ���䡢�������Ϣ��������ҵ#9������ҵ#10�����ز�ҵ#11�����޺��������ҵ#12����ѧ�о��ͼ�������ҵ#13���Ļ�������������ҵ#14��������ҵ#(��)���������Ӫ��ҵ#1���ɿ�ҵ#2������ҵ#3��������������ȼ����ˮ�������͹�Ӧҵ#4������ҵ#5������������ҵ#6����ͨ���䡢�ִ�������ҵ#7��ס�޺Ͳ���ҵ#8����Ϣ���䡢�������Ϣ��������ҵ#9������ҵ#10�����ز�ҵ#11�����޺��������ҵ#12����ѧ�о��ͼ�������ҵ#13���Ļ�������������ҵ#14��������ҵ#(��)������ҵ#1���ɿ�ҵ#2������ҵ#3��������������ȼ����ˮ�������͹�Ӧҵ#4������ҵ#5������������ҵ#6����ͨ���䡢�ִ�������ҵ#7��ס�޺Ͳ���ҵ#8����Ϣ���䡢�������Ϣ��������ҵ#9������ҵ#10�����ز�ҵ#11�����޺��������ҵ#12����ѧ�о��ͼ�������ҵ#13���Ļ�������������ҵ#14��������ҵ#(��)�Ǿ�����ҵ#1�������ҵ��פ�������#2���ṩ���񡢳а�������ҵ#3�����ںͱ���#4��������������#5��֧����λ�۽�#6������#(��)�⼮����#(��)���ڻ���˰��#�������ڻ�����˰";
		colsHName[23] = "���#��Ŀ#�ϼ�#��ֵ˰#����˰#Ӫҵ˰#��ҵ����˰#��������˰#����ά������˰#����˰#��������ʹ��˰#����˰#������˰";
		
		sjNum[24] = 2;
		colsL[24] = "ZJ#BNXQ#WNCQ#1GNZZS#1YCZPY#QZJY#2JZZY#3FZY#4YYJGJSYZPZZY#QZCPY#5HXYLHHXZPZZY#6FJSKWZPY#7HSJSYLJYYJGY#QZGPGC#8QCZZY#9MTCZZY#10MTKCHXXY#11YYHTRQKC#QZYY#12DLSCHGYY#13JZY#14JTYSY#QZTLYSFW#LLYSFW#SLYSFW#HKYSFW#GDYSFW#15YZY#16DXY#17JRY#QZHBJRFW#ZBSCFW#BXY#18FDCY#QZFDCKFJYY#19KXYJHJSFWY#2GNXFS#QZ1JJJJ#J#JJ#2Y#JY#XQY#YS#3CPY#4XQC#5MTC#3YYS#4QYSDS#5CSWHJSS#6QTGS";
		colsH[24] = "XH#XM#HJ#GYQY#JTQY#GFHZQY#LYQY#QZGYKG1#GFGS#QZGYKG2#SYQY#GATTZQY#QZGYKG3#WSTZQY#QZGYKG4#QTQY#GTJKKQY";
		colsLName[24] = "�ܼ�#������Ƿ#�����Ƿ#1��������ֵ˰#��1���̲���Ʒҵ#���о���#��2��������ҵ#��3����֯ҵ#��4��ԭ�ͼӹ���ʯ����Ʒ����ҵ#���У���Ʒ��#��5����ѧԭ�Ϻͻ�ѧ��Ʒ����ҵ#��6���ǽ���������Ʒҵ#��7����ɫ����ұ����ѹ�Ӽӹ�ҵ#����:�������ֲ�#(8)��������ҵ#(9)Ħ�г�����ҵ#(10)ú̿���ɺ�ϴѡҵ#(11)ԭ�ͺ���Ȼ������#����:ԭ��#(12)���������͹�Ӧҵ#��13������ҵ#(14)��ͨ����ҵ#���У���·�������#½·�������#ˮ·�������#�����������#�ܵ��������#(15)����ҵ#(16)����ҵ#(17)����ҵ#���У����ҽ��ڷ���#�ʱ��г�����#����ҵ#��18�����ز�ҵ#���У����ز�������Ӫҵ#(19����ѧ�о��ͼ�������ҵ#2����������˰#���У�(1)�Ƽ��ƾ�#��#�ƾ�#��2����#����#ѩ����#��˿#��3����Ʒ��#(4)С����#(5)Ħ�г�#3��Ӫҵ˰#4����ҵ����˰#5������ά������˰#6��������˰";
		colsHName[24] = "���#��Ŀ#�ϼ�#������ҵ#������ҵ#�ɷݺ�����ҵ#��Ӫ��ҵ#���У����пع�#�ɷݹ�˾#���У����пع�#˽Ӫ��ҵ#�۰�̨Ͷ����ҵ#���У����пع�#����Ͷ����ҵ#���У����пع�#������ҵ#�ء�ͣ���տ���ҵ";
		
		sjNum[25] = 3;
		colsL[25] = "QMYEZJ#QMYE1GNZZS#QMYE2GNXFS#QMYE3YYS#QMYE4QYSDS#QMYE5GRSDS#QMYE6ZYS#QMYE7GDTZFXDJS#QMYE8CSWHJSS#QMYE9FCS#QMYE10YHS#QMYE11CSTDSYS#QMYE12TDZZS#QMYE13CCS#QMYE14CLGZS#QMYE15YYS#QMYE16GDZYS#QMYE17QS#QMYE18QTSS#DNRKZJ#DNRK1GNZZS#DNRK2GNXFS#DNRK3YYS#DNRK4QYSDS#DNRK5GRSDS#DNRK6ZYS#DNRK7GDTZFXDJS#DNRK8CSWHJSS#DNRK9FCS#DNRK10YHS#DNRKCSTDSYS#DNRKTDZZS#DNRKCCS#DNRKCLGZS#DNRKYYS#DNRKGDZYS#DNRKQS#DNRKQTSS";
		colsH[25] = "XH#XM1#XM2#QSHJ#1WNCQXJ#2WNCQ5NYS#3WNCQ2012N#4WNCQ2013N#5WNCQ2014N#6WNCQ2015N#7WNCQ2016N#2BNXQ#3GTJKKQYQSWN#4GTJKKQYQSBN";
		colsLName[25] = "��ĩ����ܼ�#��ĩ���1.������ֵ˰#��ĩ���2.��������˰#��ĩ���3.Ӫҵ˰#��ĩ���4.��ҵ����˰#��ĩ���5.��������˰#��ĩ���6.��Դ˰#��ĩ���7.�̶�Ͷ�ʷ������˰#��ĩ���8.����ά������˰#��ĩ���9.����˰#��ĩ���10.ӡ��˰#��ĩ���11.��������ʹ��˰#��ĩ���12.������ֵ˰#��ĩ���13.����˰#��ĩ���14.��������˰#��ĩ���15.��Ҷ˰#��ĩ���16.����ռ��˰#��ĩ���17.��˰#��ĩ���18.����˰��#��������ܼ�#�������1.������ֵ˰#�������2.��������˰#�������3.Ӫҵ˰#�������4.��ҵ����˰#�������5.��������˰#�������6.��Դ˰#�������7.�̶�Ͷ�ʷ������˰#�������8.����ά������˰#�������9.����˰#�������10.ӡ��˰#��������������ʹ��˰#�������������ֵ˰#������⳵��˰#������⳵������˰#���������Ҷ˰#����������ռ��˰#���������˰#�����������˰��";
		colsHName[25] = "���#��Ŀ#��Ŀ#Ƿ˰�ϼ�#1.�����ǷС��#2.�����Ƿ5������#3.�����Ƿ2012��#4.�����Ƿ2013��#5.�����Ƿ2014��#6.�����Ƿ2015��#7.�����Ƿ2016��#2.������Ƿ#3.��ͣ���տ���ҵǷ˰����#4.��ͣ���տ���ҵǷ˰����";
		
		sjNum[26] = 2;
		colsL[26] = "ZJ#QZ1Y#2J#3YJ#4MT#5YY#6CPY#7HG#8DL#9FZP#10QC#11MTC#12JRBX#13JTYS";
		colsH[26] = "XH#XM#HJ#GNZZS#GNXFS#YYS#QYSDS#CSWHJSS#QTGS";
		colsLName[26] = "�ܼ�#���У�1����#2����#3��ұ��#4��ú̿#5��ԭ��#6����Ʒ��#7������#8������#9����֯Ʒ#10������#11��Ħ�г�#12�����ڡ�����#13����ͨ����";
		colsHName[26] = "���#��Ŀ#�ϼ�#������ֵ˰#��������˰#Ӫҵ˰#��ҵ����˰#����ά������˰#������˰";
		
		sjNum[27] = 2;
		colsL[27] = "ZJ#YGSMS#1ZF#2JZJZJ#3JZZY#4ZJYFC#5SHBZ#6TGJMSR#7QT#EGLGXJS#1JSZR#2KJFZ#3ZZCX#4KYJGZZ#5TZCY#6WBFW#7GXJS#8QT#SCJXWQYFZ#1JRSC#2WDQZD#3MZZZSHYYSZC#4QT1#SZZSJ#1QYFZ#2QYZZGZ#3QT#WJNHB#1HJBH#2DLJS#3ZYZHLY#4QT2#LCJQYFZ#1XBKF#2DBFZ#3LAJL#4QT3#QZCWHJYTY#1JY#2TY#3WH#BZCJRZBSC#1ZBSC#2JRSC#JZCSN#1NCJS#2FLSL#3CYSJ#4JRSC#5QT#SZCQTGXSY#1FJZZ#2JCSSJS#3CPY#4GFJS#5GJF#6YLWS#7JTYS#8WCYZ#9GY#10SPCB#11WJRY#12ZXCZXZJ#13XSSSXDDY#GX#LX#TXQSYF#CCSY#QT#14QT";
		colsH[27] = "XH#XM#HJ#CKY#ZZY#DLRQJSDSCHGYY#JZY#JTYSCCJYZY#PFHLSY#JRY#XXCSJSJFWHRJY#ZLHSWFWY#FDCY#QTXY";
		colsLName[27] = "�ܼ�#һ����������#1.ס��#2.���ּ��ؽ�#3.��ת��ҵ#4.�پ�ҵ����#5.��ᱣ��#6.��߾�������#7.����#�����������¼���#1.����ת��#2.�Ƽ���չ#3.��������#4.���л���ת��#5.Ͷ�ʴ�ҵ#6.�������#7.���¼���#8.����#�����ٽ�С΢��ҵ��չ#1.�����г�#2.δ��������#3.������ֵ˰��Ӫҵ˰����#4.����#�ġ�ת������#1.��ҵ��չ#2.��ҵ�������#3.����#�塢���ܻ���#1.��������#2.��������#3.��Դ�ۺ�����#4.����#�����ٽ�����չ#1.��������#2.������չ#3.��������#4.����#�ߡ�֧���Ļ���������#1.����#2.����#3.�Ļ�#�ˡ�֧�ֽ����ʱ��г�#1.�ʱ��г�#2.�����г�#�š�֧����ũ#1.ũ�彨��#2.��������#3.��ҵ����#4.�����г�#5.����#ʮ��֧������������ҵ#1.�ɻ�����#2.������ʩ����#3.��Ʒ��#4.��������#5.���취#6.ҽ������#7.��ͨ����#8.�޳�Ԯ��#9.����#10.��Ʒ����#11.�⼮��Ա#12.ר��������ʽ�#13.����˰��Э������#��Ϣ#��Ϣ#����Ȩʹ�÷�#�Ʋ�����#����#14.����";
		colsHName[27] = "���#��Ŀ#�ϼ�#�ɿ�ҵ#����ҵ#����ȼ����ˮ�������͹�Ӧҵ#����ҵ#��ͨ����ִ�������ҵ#����������ҵ#����ҵ#��Ϣ����������������ҵ#���޺��������ҵ#���ز�ҵ#������ҵ";
		
		sjNum[28] = 3;
		colsL[28] = "ZJ#YGSMS#1ZF#2JZJZJ#3JZZY#4ZJYFC#5SHBZ#6TGJMSR#7QT#EGLGXJS#1JSZR#2KJFZ#3ZZCX#4KYJGZZ#5TZCY#6WBFW#7GXJS#8QT#SCJXWQYFZ#1JRSC#2WDQZD#3MZZZSHYYSZC#4QT1#SZZSJ#1QYFZ#2QYZZGZ#3QT#WJNHB#1HJBH#2DLJS#3ZYZHLY#4QT2#LCJQYFZ#1XBKF#2DBFZ#3LAJL#4QT3#QZCWHJYTY#1JY#2TY#3WH#BZCJRZBSC#1ZBSC#2JRSC#JZCSN#1NCJS#2FLSL#3CYSJ#4JRSC#5QT#SZCQTGXSY#1FJZZ#2JCSSJS#3CPY#4GFJS#5GJF#6YLWS#7JTYS#8WCYZ#9GY#10SPCB#11WJRY#12ZXCZXZJ#13XSSSXDDY#GX#LX#TXQSYF#CCSY#QT#14QT";
		colsH[28] = "XH#XM#HJ#NZQYXJ#NZQYGYQY#NZQYJTQY#NZQYGFHZQY#NZQYLYQY#NZQYGFGS#NZQYSYQY#NZQYQTNZQY#GATTZQY#WSTZQY#GTJY";
		colsLName[28] = "�ܼ�#һ����������#1.ס��#2.���ּ��ؽ�#3.��ת��ҵ#4.�پ�ҵ����#5.��ᱣ��#6.��߾�������#7.����#�����������¼���#1.����ת��#2.�Ƽ���չ#3.��������#4.���л���ת��#5.Ͷ�ʴ�ҵ#6.�������#7.���¼���#8.����#�����ٽ�С΢��ҵ��չ#1.�����г�#2.δ��������#3.������ֵ˰��Ӫҵ˰����#4.����#�ġ�ת������#1.��ҵ��չ#2.��ҵ�������#3.����#�塢���ܻ���#1.��������#2.��������#3.��Դ�ۺ�����#4.����#�����ٽ�����չ#1.��������#2.������չ#3.��������#4.����#�ߡ�֧���Ļ���������#1.����#2.����#3.�Ļ�#�ˡ�֧�ֽ����ʱ��г�#1.�ʱ��г�#2.�����г�#�š�֧����ũ#1.ũ�彨��#2.��������#3.��ҵ����#4.�����г�#5.����#ʮ��֧������������ҵ#1.�ɻ�����#2.������ʩ����#3.��Ʒ��#4.��������#5.���취#6.ҽ������#7.��ͨ����#8.�޳�Ԯ��#9.����#10.��Ʒ����#11.�⼮��Ա#12.ר��������ʽ�#13.����˰��Э������#��Ϣ#��Ϣ#����Ȩʹ�÷�#�Ʋ�����#����#14.����";
		colsHName[28] = "���#��Ŀ#�ϼ�#������ҵС��#������ҵ������ҵ#������ҵ������ҵ#������ҵ�ɷݺ�����ҵ#������ҵ��Ӫ��ҵ#������ҵ�ɷݹ�˾#������ҵ˽Ӫ��ҵ#������ҵ����������ҵ#�۰�̨Ͷ����ҵ#����Ͷ����ҵ#���徭Ӫ";
		
		sjNum[29] = 2;
		colsL[29] = "ZJ#YGSMS#1ZF#2JZJZJ#3JZZY#4ZJYFC#5SHBZ#6TGJMSR#7QT#EGLGXJS#1JSZR#2KJFZ#3ZZCX#4KYJGZZ#5TZCY#6WBFW#7GXJS#8QT#SCJXWQYFZ#1JRSC#2WDQZD#3MZZZSHYYSZC#4QT1#SZZSJ#1QYFZ#2QYZZGZ#3QT#WJNHB#1HJBH#2DLJS#3ZYZHLY#4QT2#LCJQYFZ#1XBKF#2DBFZ#3LAJL#4QT3#QZCWHJYTY#1JY#2TY#3WH#BZCJRZBSC#1ZBSC#2JRSC#JZCSN#1NCJS#2FLSL#3CYSJ#4JRSC#5QT#SZCQTGXSY#1FJZZ#2JCSSJS#3CPY#4GFJS#5GJF#6YLWS#7JTYS#8WCYZ#9GY#10SPCB#11WJRY#12ZXCZXZJ#13XSSSXDDY#GX#LX#TXQSYF#CCSY#QT#14QT";
		colsH[29] = "XH#XM#HJ#ZQJM#TKJM#DDQS";
		colsLName[29] = "�ܼ�#һ����������#1.ס��#2.���ּ��ؽ�#3.��ת��ҵ#4.�پ�ҵ����#5.��ᱣ��#6.��߾�������#7.����#�����������¼���#1.����ת��#2.�Ƽ���չ#3.��������#4.���л���ת��#5.Ͷ�ʴ�ҵ#6.�������#7.���¼���#8.����#�����ٽ�С΢��ҵ��չ#1.�����г�#2.δ��������#3.������ֵ˰��Ӫҵ˰����#4.����#�ġ�ת������#1.��ҵ��չ#2.��ҵ�������#3.����#�塢���ܻ���#1.��������#2.��������#3.��Դ�ۺ�����#4.����#�����ٽ�����չ#1.��������#2.������չ#3.��������#4.����#�ߡ�֧���Ļ���������#1.����#2.����#3.�Ļ�#�ˡ�֧�ֽ����ʱ��г�#1.�ʱ��г�#2.�����г�#�š�֧����ũ#1.ũ�彨��#2.��������#3.��ҵ����#4.�����г�#5.����#ʮ��֧������������ҵ#1.�ɻ�����#2.������ʩ����#3.��Ʒ��#4.��������#5.���취#6.ҽ������#7.��ͨ����#8.�޳�Ԯ��#9.����#10.��Ʒ����#11.�⼮��Ա#12.ר��������ʽ�#13.����˰��Э������#��Ϣ#��Ϣ#����Ȩʹ�÷�#�Ʋ�����#����#14.����";
		colsHName[29] = "���#��Ŀ#�ϼ�#��ǰ����#�˿����#�ֶ�Ƿ˰";
		
		sjNum[33] = 2;
		colsL[33] = "HJ#YDYCY#EDECY#YCKY#1MTKCHXXY#2SYHTRQKCY#3HSJSKCXY#4YSJSKCXY#5FJSKCXY#6QTCKY#EZZY#1NFSPJGY#2SPZZY#3JYLHJZCZZY#4YCZPY#5FZY#6FZFZFSY#7PGMPYMJQZPHZXY#8MCJGHMZTZCZPY#9JJZZY#10ZZHZZPY#11YSHJLMJFZY#12WJGMTYHYLYPZZY#13SYJGLJHHRLJGY#14HXYLHHXZPZZY#15YYZZY#16HXXWZZY#17XJHSLZPY#18FJSKWZPY#19HSJSYLHYYJGY#20YSJSYLHYYJGY#21JSZPY#22TYSBZZY#23ZYSBZZY#24QCZZY#25TLCBHKHTHQTYSSBZZY#26DQJXHQCZZY#27JSJTXHQTDZSBZZY#28YBYQZZY#29QTZZY#SDLRLRQJSDSCHGYY#1DLRLSCHGYY#2RQSCHGYY#3SDSCHGYY#SJZY#1FWJZY#2TMGCJZY#3JZAZY#4JZZSHQTJZY#SDSCY#YPFHLSY#1PFY#2LSY#EJTYSCCHYZY#1TLYSY#2DLYSY#3SSYSY#4HKYSY#5GDYSY#6ZXBYHYSDLY#7CCY#8YZY#SZSHCYY#1ZSY#2CYY#SXXCSRJHXXJSFWY#1DXGBDSHWXCSFWY#2HLWHXGFW#3RJHXXJSFWY#WJRY#1HBJRFW#2ZBSCFW#3BXY#4QTJRY#LFDCY#1FDCKFJYY#2WYGL#3FDCZJFW#4ZYFDCJYHD#5QTFDCY#QZLHSWFWY#1ZLY#2SWFWY#QZZXYDC#GGY#ZSCQFW#HYZLFW#BKXYJHJSFWY#1YJHSYFZ#2ZYJSFWY#QZZYHSJFW#3KJTGHYYFWY#JSLHJHGGSSGLY#QZGGSSGLY#SJMFWXLHQTFWY#SYJY#SEWSHSHGZ#SSWHTYHYLY#SSGGGLSHBZHSHZZ#SWQTXY";
		colsH[33] = "XH#XM#HJ#YJTYSFW#1LLYSFW#2SLYSFW#3HKYSFW#4GDYSFW#EYZFW#1YZPBFW#2YZTSFW#3QTYZFW#SDXFW#1JCDXFW#2ZZDXFW#SJZFW#1GCFW#2AZFW#3XSFW#4ZSFW#5QTJZFW#WJRFW#1DKFW#2ZJSFJRFW#3BXFW#4JRSPZR#LXDFW#1YFHJSFW#2XXJSFW#3WHCYFW#4WLFZFW#5ZLFW#6JZZXFW#7GBYSFW#8SWFZFW#9QTXDFW#QSHFW#1WHTYFW#2JYYLFW#3LYYLFW#4CYZSFW#5JMRCFW#6QTSHFW#BXSWXZC#1ZLHFZLJS#2SBHZZQ#3TDSYQ#4QTZRZYSYQ#5QTQYXWXZC#JXSBDC#1JZW#QZESFJY1#2GZW#QZESFJY2";
		colsLName[33] = "�ϼ�#һ����һ��ҵ#�����ڶ���ҵ#(һ)�ɿ�ҵ#1.ú̿���ɺ�ϴѡҵ#2.ʯ�ͺ���Ȼ������ҵ#3.��ɫ�������ѡҵ#4.��ɫ�������ѡҵ#5.�ǽ������ѡҵ#6.�����ɿ�ҵ#(��)����ҵ#1.ũ��ʳƷ�ӹ�ҵ#2.ʳƷ����ҵ#3.�ơ����Ϻ;��Ʋ�����ҵ#4.�̲���Ʒҵ#5.��֯ҵ#6.��֯��װ������ҵ#7.Ƥ�ëƤ����ë������Ʒ����Ьҵ#8.ľ�ļӹ���ľ�����ز���Ʒҵ#9.�Ҿ�����ҵ#10.��ֽ��ֽ��Ʒҵ#11.ӡˢ�ͼ�¼ý�鸴��ҵ#12.�Ľ̡�������������������Ʒ����ҵ#13.ʯ�ͼӹ��������ͺ�ȼ�ϼӹ�ҵ#14.��ѧԭ�Ϻͻ�ѧ��Ʒ����ҵ#15.ҽҩ����ҵ#16.��ѧ��ά����ҵ#17.�𽺺�������Ʒҵ#18.�ǽ���������Ʒҵ#19.��ɫ����ұ����ѹ�Ӽӹ�ҵ#20.��ɫ����ұ����ѹ�Ӽӹ�ҵ#21.������Ʒҵ#22.ͨ���豸����ҵ#23.ר���豸����ҵ#24.��������ҵ#25.��·�����������պ�������������豸����ҵ#26.������е����������ҵ#27.�������ͨ�ź����������豸����ҵ#28.�Ǳ���������ҵ#29.��������ҵ#(��)������������ȼ����ˮ�������͹�Ӧҵ#1.���������������͹�Ӧҵ#2.ȼ�������͹�Ӧҵ#3.ˮ�������͹�Ӧҵ#(��)����ҵ#1.���ݽ���ҵ#2.��ľ���̽���ҵ#3.������װҵ#4.����װ�κ���������ҵ#����������ҵ#(һ)����������ҵ#1.����ҵ#2.����ҵ#(��)��ͨ���䡢�ִ�������ҵ#1.��·����ҵ#2.��·����ҵ#3.ˮ������ҵ#4.��������ҵ#5.�ܵ�����ҵ#6.װж���˺��������ҵ#7.�ִ�ҵ#8.����ҵ#(��)ס�޺Ͳ���ҵ#1.ס��ҵ#2.����ҵ#(��)��Ϣ���䡢�������Ϣ��������ҵ#1.���š��㲥���Ӻ����Ǵ������ҵ#2.����������ط���#3.�������Ϣ��������ҵ#(��)����ҵ#1.���ҽ��ڷ���#2.�ʱ��г�����#3.����ҵ#4.��������ҵ#(��)���ز�ҵ#1.���ز�������Ӫҵ#2.��ҵ����#3.���ز��н����#4.���з��ز���Ӫ�#5.�������ز�ҵ#(��)���޺��������ҵ#1.����ҵ#2.�������ҵ#���У���ѯ�����#���ҵ#֪ʶ��Ȩ����#����չ������#(��)��ѧ�о��ͼ�������ҵ#1.�о���ʵ�鷢չ#2.רҵ��������ҵ#���У�רҵ����Ʒ���#3.�Ƽ��ƹ��Ӧ�÷���ҵ#(��)ˮ���������͹�����ʩ����ҵ#���У�������ʩ����ҵ#(ʮ)��������������������ҵ#(ʮһ)����#(ʮ��)��������Ṥ��#(ʮ��)�Ļ�������������ҵ#(ʮ��)����������ᱣ�Ϻ������֯#(ʮ��)������ҵ";
		colsHName[33] = "���#��Ŀ#�ϼ�#һ����ͨ�������#1��½·�������#2��ˮ·�������#3�������������#4���ܵ��������#������������#1.�����ձ����#2.�����������#3.������������#�������ŷ���#1.�������ŷ���#2.��ֵ���ŷ���#�ġ���������#1.���̷���#2.��װ����#3.���ɷ���#4.װ�η���#5.������������#�塢���ڷ���#1.�������#2.ֱ���շѽ��ڷ���#3.���շ���#4.������Ʒת��#�����ִ�����#1.�з��ͼ�������#2.��Ϣ��������#3.�Ļ��������#4.������������#5.���޷���#6.��֤��ѯ����#7.�㲥Ӱ�ӷ���#8.����������#9.�����ִ�����#�ߡ��������#1.�Ļ���������#2.����ҽ�Ʒ���#3.�������ַ���#4.����ס�޷���#5.�����ճ�����#6.�����������#�ˡ����������ʲ�#1.ר�����ר������#2.�̱������Ȩ#3.����ʹ��Ȩ#4.������Ȼ��Դʹ��Ȩ#5.����Ȩ���������ʲ�#�š����۲�����#1.������#���У����ַ�����#2.������#���У����ַ�����";
		

		sjNum[34] = 3;
		colsL[34] = "HJ#YDYCY#EDECY#YCKY#1MTKCHXXY#2SYHTRQKCY#3HSJSKCXY#4YSJSKCXY#5FJSKCXY#6QTCKY#EZZY#1NFSPJGY#2SPZZY#3JYLHJZCZZY#4YCZPY#5FZY#6FZFZFSY#7PGMPYMJQZPHZXY#8MCJGHMZTZCZPY#9JJZZY#10ZZHZZPY#11YSHJLMJFZY#12WJGMTYHYLYPZZY#13SYJGLJHHRLJGY#14HXYLHHXZPZZY#15YYZZY#16HXXWZZY#17XJHSLZPY#18FJSKWZPY#19HSJSYLHYYJGY#20YSJSYLHYYJGY#21JSZPY#22TYSBZZY#23ZYSBZZY#24QCZZY#25TLCBHKHTHQTYSSBZZY#26DQJXHQCZZY#27JSJTXHQTDZSBZZY#28YBYQZZY#29QTZZY#SDLRLRQJSDSCHGYY#1DLRLSCHGYY#2RQSCHGYY#3SDSCHGYY#SJZY#1FWJZY#2TMGCJZY#3JZAZY#4JZZSHQTJZY#SDSCY#YPFHLSY#1PFY#2LSY#EJTYSCCHYZY#1TLYSY#2DLYSY#3SSYSY#4HKYSY#5GDYSY#6ZXBYHYSDLY#7CCY#8YZY#SZSHCYY#1ZSY#2CYY#SXXCSRJHXXJSFWY#1DXGBDSHWXCSFWY#2HLWHXGFW#3RJHXXJSFWY#WJRY#1HBJRFW#2ZBSCFW#3BXY#4QTJRY#LFDCY#1FDCKFJYY#2WYGL#3FDCZJFW#4ZYFDCJYHD#5QTFDCY#QZLHSWFWY#1ZLY#2SWFWY#QZZXYDC#GGY#ZSCQFW#HYZLFW#BKXYJHJSFWY#1YJHSYFZ#2ZYJSFWY#QZZYHSJFW#3KJTGHYYFWY#JSLHJHGGSSGLY#QZGGSSGLY#SJMFWXLHQTFWY#1JMFWY#2JDCDZCPHRYCPXLY#3QTFWY#SYJY#SEWSHSHGZ#1WS#2SHGZ#SSWHTYHYLY#1XWHCBY#2GBDSDYHYSLYZZY#3WHYSY#4TY#5YLY#SSGGGLSHBZHSHZZ#SWQTXY";
		colsH[34] = "XH#XM#HJ#QZMDDK#NZQYXJ#NZQYGYQY#NZQYJTQY#NZQYGFHZQY#NZQYLYQY#NZQYQZGYKG1#NZQYGFGS#NZQYQZGYKG2#NZQYSYQY#NZQYQTQY#GATTZQY#QZGYKG1#WSTZQY#QZGYKG2#GTJY";
		colsLName[34] = "�ϼ�#һ����һ��ҵ#�����ڶ���ҵ#(һ)�ɿ�ҵ#1.ú̿���ɺ�ϴѡҵ#2.ʯ�ͺ���Ȼ������ҵ#3.��ɫ�������ѡҵ#4.��ɫ�������ѡҵ#5.�ǽ������ѡҵ#6.�����ɿ�ҵ#(��)����ҵ#1.ũ��ʳƷ�ӹ�ҵ#2.ʳƷ����ҵ#3.�ơ����Ϻ;��Ʋ�����ҵ#4.�̲���Ʒҵ#5.��֯ҵ#6.��֯��װ������ҵ#7.Ƥ�ëƤ����ë������Ʒ����Ьҵ#8.ľ�ļӹ���ľ�����ز���Ʒҵ#9.�Ҿ�����ҵ#10.��ֽ��ֽ��Ʒҵ#11.ӡˢ�ͼ�¼ý�鸴��ҵ#12.�Ľ̡�������������������Ʒ����ҵ#13.ʯ�ͼӹ��������ͺ�ȼ�ϼӹ�ҵ#14.��ѧԭ�Ϻͻ�ѧ��Ʒ����ҵ#15.ҽҩ����ҵ#16.��ѧ��ά����ҵ#17.�𽺺�������Ʒҵ#18.�ǽ���������Ʒҵ#19.��ɫ����ұ����ѹ�Ӽӹ�ҵ#20.��ɫ����ұ����ѹ�Ӽӹ�ҵ#21.������Ʒҵ#22.ͨ���豸����ҵ#23.ר���豸����ҵ#24.��������ҵ#25.��·�����������պ�������������豸����ҵ#26.������е����������ҵ#27.�������ͨ�ź����������豸����ҵ#28.�Ǳ���������ҵ#29.��������ҵ#(��)������������ȼ����ˮ�������͹�Ӧҵ#1.���������������͹�Ӧҵ#2.ȼ�������͹�Ӧҵ#3.ˮ�������͹�Ӧҵ#(��)����ҵ#1.���ݽ���ҵ#2.��ľ���̽���ҵ#3.������װҵ#4.����װ�κ���������ҵ#����������ҵ#(һ)����������ҵ#1.����ҵ#2.����ҵ#(��)��ͨ���䡢�ִ�������ҵ#1.��·����ҵ#2.��·����ҵ#3.ˮ������ҵ#4.��������ҵ#5.�ܵ�����ҵ#6.װж���˺��������ҵ#7.�ִ�ҵ#8.����ҵ#(��)ס�޺Ͳ���ҵ#1.ס��ҵ#2.����ҵ#(��)��Ϣ���䡢�������Ϣ��������ҵ#1.���š��㲥���Ӻ����Ǵ������ҵ#2.����������ط���#3.�������Ϣ��������ҵ#(��)����ҵ#1.���ҽ��ڷ���#2.�ʱ��г�����#3.����ҵ#4.��������ҵ#(��)���ز�ҵ#1.���ز�������Ӫҵ#2.��ҵ����#3.���ز��н����#4.���з��ز���Ӫ�#5.�������ز�ҵ#(��)���޺��������ҵ#1.����ҵ#2.�������ҵ#���У���ѯ�����#���ҵ#֪ʶ��Ȩ����#����չ������#(��)��ѧ�о��ͼ�������ҵ#1.�о���ʵ�鷢չ#2.רҵ��������ҵ#���У�רҵ����Ʒ���#3.�Ƽ��ƹ��Ӧ�÷���ҵ#(��)ˮ���������͹�����ʩ����ҵ#���У�������ʩ����ҵ#(ʮ)��������������������ҵ#1.�������ҵ#2.�����������Ӳ�Ʒ�����ò�Ʒ����ҵ#3.��������ҵ#(ʮһ)����#(ʮ��)��������Ṥ��#1.����#2.��Ṥ��#(ʮ��)�Ļ�������������ҵ#1.���źͳ���ҵ#2.�㲥�����ӡ���Ӱ��Ӱ��¼������ҵ#3.�Ļ�����ҵ#4.����#5.����ҵ#(ʮ��)����������ᱣ�Ϻ������֯#(ʮ��)������ҵ";
		colsHName[34] = "���#��Ŀ#�ϼ�#���У���ֵ���#������ҵС��#������ҵ������ҵ#������ҵ������ҵ#������ҵ�ɷݺ�����ҵ#������ҵ��Ӫ��ҵ#������ҵ���У����пع�#������ҵ�ɷݹ�˾#������ҵ���У����пع�#������ҵ˽Ӫ��ҵ#������ҵ������ҵ#�۰�̨Ͷ����ҵ#���У����пع�#����Ͷ����ҵ#���У����пع�#���徭Ӫ";
		

		sjNum[35] = 3;
		colsL[35] = "HJ#YJTYSFW#1LLYSFW#1TLYSFW#2QTLLYSFW#2SLYSFW#3HKYSFW#4GDYSFW#EYZFW#1YZPBFW#2YZTSFW#3QTYZFW#SDXFW#1JCDXFW#2ZZDXFW#SJZFW#1GCFW#2AZFW#3XSFW#4ZSFW#5QTJZFW#WJRFW#1DKFW#2ZJSFJRFW#3BXFW#1RSBXFW#2CCBXFW#4JRSPZR#LXDFW#1YFHJSFW#1YFFW#2HTNYGLFW#3GCKCKTFW#4ZYJSFW#2XXJSFW#1RJFW#2DLSJJCSFW#3XXXTFW#4YWLCGLFW#5XXXTZZFW#3WHCYFW#1SJFW#2ZSCQFW#3GGFW#4HYZLFW#4WLFZFW#1HKFW#2GKMTFW#3HYKYCZFW#4DLJZFW#5ZXBYFW#6CCFW#7SPFW#5ZLFW#1BDCRZZL#2BDCJYZL#3YXDCRZZL#4YXDCJYZL#6JZZXFW#1RZFW#2JZFW#3ZXFW#7GBYSFW#1GBYSJMZPZZFW#2GBYSJMZPFXFW#3GBYSJMZPBYFW#8SWFZFW#1QYGLFW#2JJDLFW#3RLZYFW#4AQBHFW#9QTXDFW#QSHFW#1WHTYFW#1WHFW#2TYFW#2JYYLFW#1JYFW#2YLFW1#3LYYLFW#1LYFW#2YLFW2#4CYZSFW#1CYFW#2ZSFW#5JMRCFW#6QTSHFW#BXSWXZC#1ZLHFZLJS#2SBHZZQ#3TDSYQ#4QTZRZYSYQ#5QTQYXWXZC#JXSBDC#1JZW#QZESFJY1#2GZW#QZESFJY2";
		colsH[35] = "XH#XM#HJ#QZMDDK#NZQYXJ#NZQYGYQY#NZQYJTQY#NZQYGFHZQY#NZQYLYQY#NZQYQZGYKG1#NZQYGFGS#NZQYQZGYKG2#NZQYSYQY#NZQYQTQY#GATTZQY#QZGYKG1#WSTZQY#QZGYKG2#GTJY";
		colsLName[35] = "�ϼ�#һ����ͨ�������#1.½·�������#��1����·�������#��2������½·�������#2.ˮ·�������#3.�����������#4.�ܵ��������#������������#1.�����ձ����#2.�����������#3.������������#�������ŷ���#1.�������ŷ���#2.��ֵ���ŷ���#�ġ���������#1.���̷���#2.��װ����#3.���ɷ���#4.װ�η���#5.������������#�塢���ڷ���#1.�������#2.ֱ���շѽ��ڷ���#3.���շ���#��1�������շ���#��2���Ʋ����շ���#4.������Ʒת��#�����ִ�����#1.�з��ͼ�������#(1)�з�����#(2)��ͬ��Դ�������#(3)���̿��쿱̽����#(4)רҵ��������#2.��Ϣ��������#(1)�������#(2)��·��Ƽ����Է���#(3)��Ϣϵͳ����#(4)ҵ�����̹������#(5)��Ϣϵͳ��ֵ����#3.�Ļ��������#(1)��Ʒ���#(2)֪ʶ��Ȩ����#(3)������#(4)����չ������#4.������������#(1)���շ���#(2)�ۿ���ͷ����#(3)���˿��˳�վ����#(4)���̾�������#(5)װж���˷���#(6)�ִ�����#(7)���ɷ���#5.���޷���#(1)��������������#(2)��������Ӫ����#(3)���ζ�����������#(4)���ζ�����Ӫ����#6.��֤��ѯ����#(1)��֤����#(2)��֤����#(3)��ѯ����#7.�㲥Ӱ�ӷ���#(1)�㲥Ӱ�ӽ�Ŀ����Ʒ����������#(2)�㲥Ӱ�ӽ�Ŀ����Ʒ�����з���#(3)�㲥Ӱ�ӽ�Ŀ����Ʒ����ӳ����#8.����������#(1)��ҵ�������#(2)���ʹ������#(3)������Դ����#(4)��ȫ��������#9.�����ִ�����#�ߡ��������#1.�Ļ���������#(1)�Ļ�����#(2)��������#2.����ҽ�Ʒ���#(1)��������#(2)ҽ�Ʒ���#3.�������ַ���#(1)���η���#(2)���ַ���#4.����ס�޷���#(1)��������#(2)ס�޷���#5.�����ճ�����#6.�����������#�ˡ����������ʲ�#1.ר�����ר������#2.�̱������Ȩ#3.����ʹ��Ȩ#4.������Ȼ��Դʹ��Ȩ#5.����Ȩ���������ʲ�#�š����۲�����#1.������#���У����ַ�����#2.������#���У����ַ�����";
		colsHName[35] = "���#��Ŀ#�ϼ�#���У���ֵ���#������ҵС��#������ҵ������ҵ#������ҵ������ҵ#������ҵ�ɷݺ�����ҵ#������ҵ��Ӫ��ҵ#������ҵ���У����пع�#������ҵ�ɷݹ�˾#������ҵ���У����пع�#������ҵ˽Ӫ��ҵ#������ҵ������ҵ#�۰�̨Ͷ����ҵ#���У����пع�#����Ͷ����ҵ#���У����пع�#���徭Ӫ";
		
		
		sjNum[36] = 5;
		colsL[36] = "GNSSSRHJ#1ZZSSR#QZYBNSR#XGMNSR#2XFSSR#3YYS#4QYSDS#5GRSDS#6ZYS#7GDZCTZFXDJS#8CSWHJSS#9FCS#10YHS#11CZTDSYS#12TDZZS#13CCS#14CLGZS#15YYS#16GDZYS#17QS#18QTGS";
		colsH[36] = "XH#SZ#HJHS#HJSSSR#DXQYHS#DXQYSSSR#ZXQYHS#ZXQYSSSR#XWQYXJHS#XWQYXJSSSR#XWQYXXQYHS#XWQYXXQYSSSR#XWQYWXQYHS#XWQYWXQYSSSR";
		colsLName[36] = "����˰������ϼ�#1.��ֵ˰����#����:һ����˰��#С��ģ��˰��#2.����˰����#3.Ӫҵ˰#4.��ҵ����˰#5.��������˰#6.��Դ˰#7.�̶��ʲ�Ͷ�ʷ������˰#8.����ά������˰#9.����˰#10.ӡ��˰#11.��������ʹ��˰#12.������ֵ˰#13.����˰#14.��������˰#15.��Ҷ˰#16.����ռ��˰#17.��˰#18.������˰";
		colsHName[36] = "���#˰��#�ϼƻ���#�ϼ�˰������#������ҵ����#������ҵ˰������#������ҵ����#������ҵ˰������#С΢��ҵС�ƻ���#С΢��ҵС��˰������#С΢��ҵС����ҵ����#С΢��ҵС����ҵ˰������#С΢��ҵ΢����ҵ����#С΢��ҵ΢����ҵ˰������";
		

		sjNum[37] = 5;
		colsL[37] = "HJ#YDYCY#EDECY#YCKY#EZZY#1NFSPJGY#2SPZZY#3JYLHJZCZZY#4YCZPY#5FZY#6FZFZFSY#7PGMPYMJQZPHZXY#8MCJGHMZTZCZPY#9JJZZY#10ZZHZZPY#11YSHJLMJFZY#12WJGMTYHYLYPZZY#13SYJGLJHHRLJGY#14HXYLHHXZPZZY#15YYZZY#16HXXWZZY#17XJHSLZPY#18FJSKWZPY#19HSJSYLHYYJGY#20YSJSYLHYYJGY#21JSZPY#22TYSBZZY#23ZYSBZZY#24QCZZY#25TLCBHKHTHQTYSSBZZY#26DQJXHQCZZY#27JSJTXHQTDZSBZZY#28YBYQZZY#29QTZZY#SDLRLRQJSDSCHGYY#1DLRLSCHGYY#2RQSCHGYY#3SDSCHGYY#SJZY#1FWJZY#2TMGCJZY#3JZAZY#4JZZSHQTJZY#SDSCY#YPFHLSY#1PFY#2LSY#EJTYSCCHYZY#1JTYSY#x1TLYSY#x2QTJTYSY#2CCY#3YZY#SZSHCYY#1ZSY#2CYY#SXXCSRJHXXJSFWY#1DXGBDSHWXCSFWY#2HLWHXGFW#3RJHXXJSFWY#WJRY#1HBJRFW#2ZBSCFW#3BXY#4QTJRY#LFDCY#1FDCKFJY#2WYGL#3QTFDCY#QZLHSWFWY#1ZLY#2SWFWY#BKXYJHJSFWY#JJMFWXLHQTFWY#SJY#SYWSHSHGZ#SEWHTYHYLY#SSGGGLSHBZHSHZZ#SSQTXY";
		colsH[37] = "XH#XM#HJHS#HJSSSR#DXQYHS#DXQYSSSR#ZXQYHS#ZXQYSSSR#XWQYXJHS#XWQYXJSSSR#XWQYXXQYHS#XWQYXXQYSSSR#XWQYWXQYHS#XWQYWXQYSSSR";
		colsLName[37] = "�ϼ�#һ����һ��ҵ#�����ڶ���ҵ#(һ)�ɿ�ҵ#(��)����ҵ#1.ũ��ʳƷ�ӹ�ҵ#2.ʳƷ����ҵ#3.�ơ����Ϻ;��Ʋ�����ҵ#4.�̲���Ʒҵ#5.��֯ҵ#6.��֯��װ������ҵ#7.Ƥ�ëƤ����ë������Ʒ����Ьҵ#8.ľ�ļӹ���ľ�����ز���Ʒҵ#9.�Ҿ�����ҵ#10.��ֽ��ֽ��Ʒҵ#11.ӡˢ�ͼ�¼ý�鸴��ҵ#12.�Ľ̡�������������������Ʒ����ҵ#13.ʯ�ͼӹ��������ͺ�ȼ�ϼӹ�ҵ#14.��ѧԭ�Ϻͻ�ѧ��Ʒ����ҵ#15.ҽҩ����ҵ#16.��ѧ��ά����ҵ#17.�𽺺�������Ʒҵ#18.�ǽ���������Ʒҵ#19.��ɫ����ұ����ѹ�Ӽӹ�ҵ#20.��ɫ����ұ����ѹ�Ӽӹ�ҵ#21.������Ʒҵ#22.ͨ���豸����ҵ#23.ר���豸����ҵ#24.��������ҵ#25.��·�����������պ�������������豸����ҵ#26.������е����������ҵ#27.�������ͨ�ź����������豸����ҵ#28.�Ǳ���������ҵ#29.��������ҵ#(��)������������ȼ����ˮ�������͹�Ӧҵ#1.���������������͹�Ӧҵ#2.ȼ�������͹�Ӧҵ#3.ˮ�������͹�Ӧҵ#(��)����ҵ#1.���ݽ���ҵ#2.��ľ���̽���ҵ#3.������װҵ#4.����װ�κ���������ҵ#����������ҵ#(һ)����������ҵ#1.����ҵ#2.����ҵ#(��)��ͨ���䡢�ִ�������ҵ#1.��ͨ����ҵ#����·����ҵ#��������ͨ����ҵ#2.�ִ�ҵ#3.����ҵ#(��)ס�޺Ͳ���ҵ#1.ס��ҵ#2.����ҵ#(��)��Ϣ���䡢�������Ϣ��������ҵ#1.���š��㲥���Ӻ����Ǵ������ҵ#2.����������ط���#3.�������Ϣ��������ҵ#(��)����ҵ#1.���ҽ��ڷ���#2.�ʱ��г�����#3.����ҵ#4.��������ҵ#(��)���ز�ҵ#1.���ز�������Ӫ#2.��ҵ����#3.�������ز�ҵ#(��)���޺��������ҵ#1.����ҵ#2.�������ҵ#(��)��ѧ�о��ͼ�������ҵ#(��)��������������������ҵ#(ʮ)����#(ʮһ)��������Ṥ��#(ʮ��)�Ļ�������������ҵ#(ʮ��)����������ᱣ�Ϻ������֯#(ʮ��)������ҵ";
		colsHName[37] = "���#��Ŀ#�ϼƻ���#�ϼ�˰������#������ҵ����#������ҵ˰������#������ҵ����#������ҵ˰������#С΢��ҵС�ƻ���#С΢��ҵС��˰������#С΢��ҵС����ҵ����#С΢��ҵС����ҵ˰������#С΢��ҵ΢����ҵ����#С΢��ҵ΢����ҵ˰������";
		

		sjNum[38] = 5;
		colsL[38] = "HJ#YNZQYXJ#YNZQY1GYQY#YNZQY2JTQY#YNZQY3GFHZQY#YNZQY4LYQY#YNZQYQZGYKG1#YNZQY5GFGS#YNZQYQZGYKG2#YNZQY6SYQY#YNZQY7QTQY#EGATTZQY#QZGYKG1#SWSTZQY#QZGYKG2#SGTJY";
		colsH[38] = "XH#QYLX1#QYLX2#HJHS#HJSSSR#DXQYHS#DXQYSSSR#ZXQYHS#ZXQYSSSR#XWQYXJHS#XWQYXJSSSR#XWQYXXQYHS#XWQYXXQYSSSR#XWQYWXQYHS#XWQYWXQYSSSR";
		colsLName[38] = "�ϼ�#һ��������ҵС��#һ��������ҵ1.������ҵ#һ��������ҵ2.������ҵ#һ��������ҵ3.�ɷݺ�����ҵ#һ��������ҵ4.��Ӫ��ҵ#һ��������ҵ���У����пع�#һ��������ҵ5.�ɷݹ�˾#һ��������ҵ���У����пع�#һ��������ҵ6.˽Ӫ��ҵ#һ��������ҵ7.������ҵ#�����۰�̨Ͷ����ҵ#���У����пع�#��������Ͷ����ҵ#���У����пع�#�ġ����徭Ӫ";
		colsHName[38] = "���#��ҵ����#��ҵ����#�ϼƻ���#�ϼ�˰������#������ҵ����#������ҵ˰������#������ҵ����#������ҵ˰������#С΢��ҵС�ƻ���#С΢��ҵС��˰������#С΢��ҵС����ҵ����#С΢��ҵС����ҵ˰������#С΢��ҵ΢����ҵ����#С΢��ҵ΢����ҵ˰������";
		

		sjNum[39] = 3;
		colsL[39] = "YXSEHJ#1ASYSLZSHWJLWXSE#2AJYZSBFZSHWXSE#3MDTBFCKHWXSE#4MSHWJLWXSE#EYNSEHJ#1XXSE#2JXSE#SQLDSE#JXSEZC#MDTHWYTSE#ASYSLJSDNSJCYBJSE#3YDKSE#4SJDKSE#5QMLDSE#6JYZSBFJSDYNSE#7YNSEJZE";
		colsH[39] = "XH#XM#HJ#GY#JYDZZ#JDZZ#FZY#YYJGJSYZPZZ#HXYLJHXZPZZY#FJSKWZPY#HSJSYLHYYJGY#QCZZY#MTKCHXXY#SYHTRQKCY#DLRLSCHGYY#PFY#LSY";
		colsLName[39] = "һ.���۶�ϼ�#1.������˰����˰���Ｐ�������۶�#2.���������հ취��˰�������۶�#3.��.��.�˰취���ڻ������۶�#4.��˰���Ｐ�������۶�#��.Ӧ��˰��ϼ�#1.����˰��#2.����˰��#��������˰��#����˰��ת��#����˻���Ӧ��˰��#������˰�ʼ������˰���Ӧ����˰��#3.Ӧ�ֿ�˰��#4.ʵ�ʵֿ�˰��#5.��ĩ����˰��#6.�������հ취�����Ӧ��˰��#7.Ӧ��˰�������";
		colsHName[39] = "���#��Ŀ#�ϼ�#��ҵ#���̵�����#�Ƶ�����#��֯ҵ#ԭ�ͼӹ���ʯ����Ʒ����#��ѧԭ�ϼ���ѧ��Ʒ����ҵ#�ǽ���������Ʒҵ#��ɫ����ұ����ѹ�Ӽӹ�ҵ#��������ҵ#ú̿���ɺ�ϴѡҵ#ʯ�ͺ���Ȼ������ҵ#���������������͹�Ӧҵ#����ҵ#����ҵ";
		

		sjNum[40] = 2;
		colsL[40] = "YXSEHJ#1ASYSLZSHWJLWXSE#2AJYZSBFZSHWXSE#3MDTBFCKHWXSE#4MSHWJLWXSE#EYNSEHJ#1XXSE#2JXSE#SQLDSE#JXSEZC#MDTHWYTSE#ASYSLJSDNSJCYBJSE#3YDKSE#4SJDKSE#5QMLDSE#6JYZSBFJSDYNSE#7YNSEJZE#F1XGMNSRXSE#F2XGMNSRYNSE";
		colsH[40] = "XH#XM#HJ#YJTYSFW#1LLYSFW#2SLYSFW#3HKYSFW#4GDYSFW#EYZFW#SDXFW#SJZFW#QZGCFW#WJRFW#1DKFW#2ZJSFJRFW#3BXFW#4JRSPZR#LXDFW#1YFHJSFW#2XXJSFW#3WHCYFW#4WLFZFW#5ZLFW#6JZZXFW#7GBYSFW#8SWFZFW#9QTXDFW#QSHFW#BXSWXZC#JXSBDC#QZESFJY";
		colsLName[40] = "һ.���۶�ϼ�#1.������˰����˰���Ｐ�������۶�#2.���������հ취��˰�������۶�#3.��.��.�˰취���ڻ������۶�#4.��˰���Ｐ�������۶�#��.Ӧ��˰��ϼ�#1.����˰��#2.����˰��#��������˰��#����˰��ת��#����˻���Ӧ��˰��#������˰�ʼ������˰���Ӧ����˰��#3.Ӧ�ֿ�˰��#4.ʵ�ʵֿ�˰��#5.��ĩ����˰��#6.�������հ취�����Ӧ��˰��#7.Ӧ��˰�������#��1��С��ģ��˰�����۶�#��2��С��ģ��˰��Ӧ��˰��";
		colsHName[40] = "���#��Ŀ#�ϼ�#һ����ͨ�������#1��½·�������#2��ˮ·�������#3�������������#4���ܵ��������#������������#�������ŷ���#�ġ���������#���У����̷���#�塢���ڷ���#1.�������#2.ֱ���շѽ��ڷ���#3.���շ���#4.������Ʒת��#�����ִ�����#1.�з��ͼ�������#2.��Ϣ��������#3.�Ļ��������#4.������������#5.���޷���#6.��֤��ѯ����#7.�㲥Ӱ�ӷ���#8.����������#9.�����ִ�����#�ߡ��������#�ˡ����������ʲ�#�š����۲�����#���У����ַ�����";


		sjNum[42] = 2;
		colsL[42] = "CZZSASJLREYJYYSR#CZZSASJLREYJYYCB#CZZSASJLREYJLRZE#CZZSASJLREYJTDYWJSDYNSSDE#CZZSASJLREYJBZSSRHSJJMYNSSDE#CZZSASJLREYJGDZCJSZJKCDJE#CZZSASJLREYJMBYQNDKS#CZZSASJLREYJSJLRE#CZZSASJLREYJYNSDSE#CZZSASJLREYJJMSDSE#CZZSASJLREYJQZFHTJDXXWLQYJMSDSE#CZZSASJLREYJSJYNSDSE#CZZSASYNSNDYJSYNDYNSSDE#CZZSASYNSNDYJJZBYJYNSDSE#CZZSAQTFFYJJZBYJQDYJDSDSE#HDZSASRZEHDSRZE#HDZSASRZEHDBZSSR#HDZSASRZEHDMSSR#HDZSASRZEHDYSSRE#HDZSASRZEHDYNSSDE#HDZSASRZEHDYNSDSE#HDZSACBFYHDCBFYZE#HDZSACBFYHDYNSSDE#HDZSACBFYHDYNSDSE#HDZSYSWJGHDYNSEYNSDSE#ZFJGJNQYSDSQKZJGYFTQYSDSE#ZFJGJNQYSDSQKCZJZFPSDSE#ZFJGJNQYSDSQKFZJGYFTQYSDSE#ZFJGJNQYSDSQKQZZJGDLSCJYBMYFTSDSE#ZFJGJNQYSDSQKZJGYCXFZJGYFTSDSE";
		colsH[42] = "XH#XM#HJ#YDYCY#EDECY#YCKY#EZZY#SDLRLRQJSDSCHGYY#SJZY#SDSCY#YPFHLSY#EJTYSCCHYZY#SZSHCYY#SXXCSRJHXXJSFWY#WJRY#LFDCY#QZLHSWFWY#BKXYJHJSFWY#JJMFWXLHQTFWY#SJY#SYWSHSHGZ#SEWHTYHYLY#SSGGGLSHBZHSHZZ#SSQTXY";
		colsLName[42] = "�������հ�ʵ�������Ԥ��Ӫҵ����#�������հ�ʵ�������Ԥ��Ӫҵ�ɱ�#�������հ�ʵ�������Ԥ�������ܶ�#�������հ�ʵ�������Ԥ���ض�ҵ������Ӧ��˰���ö�#�������հ�ʵ�������Ԥ�ɲ���˰�����˰������Ӧ��˰���ö�#�������հ�ʵ�������Ԥ�ɹ̶��ʲ������۾ɣ��۳���������#�������հ�ʵ�������Ԥ���ֲ���ǰ��ȿ���#�������հ�ʵ�������Ԥ��ʵ�������#�������հ�ʵ�������Ԥ��Ӧ������˰��#�������հ�ʵ�������Ԥ�ɼ�������˰��#�������հ�ʵ�������Ԥ�����У�����������С��΢����ҵ��������˰��#�������հ�ʵ�������Ԥ��ʵ��Ӧ������˰��#�������հ���һ��˰���Ԥ����һ���Ӧ��˰���ö�#�������հ���һ��˰���Ԥ�ɽ������£�����Ӧ������˰��#�������հ���������Ԥ�ɽ������£�����ȷ��Ԥ�ɵ�����˰��#�˶����հ������ܶ�˶������ܶ�#�˶����հ������ܶ�˶�����˰����#�˶����հ������ܶ�˶���˰����#�˶����հ������ܶ�˶�Ӧ˰�����#�˶����հ������ܶ�˶�Ӧ��˰���ö�#�˶����հ������ܶ�˶�Ӧ������˰��#�˶����հ��ɱ����ú˶��ɱ������ܶ�#�˶����հ��ɱ����ú˶�Ӧ��˰���ö�#�˶����հ��ɱ����ú˶�Ӧ������˰��#�˶�������˰����غ˶�Ӧ��˰��Ӧ������˰��#�ֻܷ���������ҵ����˰����ܻ���Ӧ��̯��ҵ����˰��#�ֻܷ���������ҵ����˰����������з�������˰��#�ֻܷ���������ҵ����˰�����֧����Ӧ��̯��ҵ����˰��#�ֻܷ���������ҵ����˰������У��ܻ�������������Ӫ����Ӧ��̯����˰��#�ֻܷ���������ҵ����˰����ܻ����ѳ�����֧����Ӧ��̯����˰��";
		colsHName[42] = "���#��Ŀ#�ϼ�#һ����һ��ҵ#�����ڶ���ҵ#(һ)�ɿ�ҵ#(��)����ҵ#(��)������������ȼ����ˮ�������͹�Ӧҵ#(��)����ҵ#����������ҵ#(һ)����������ҵ#(��)��ͨ���䡢�ִ�������ҵ#(��)ס�޺Ͳ���ҵ#(�ģ���Ϣ���䡢�������Ϣ��������ҵ#(��)����ҵ#(��)���ز�ҵ#(��)���޺��������ҵ#(��)��ѧ�о��ͼ�������ҵ#(��)��������������������ҵ#(ʮ)����#(ʮһ)��������Ṥ��#(ʮ��)�Ļ�������������ҵ#(ʮ��)����������ᱣ�Ϻ������֯#(ʮ��)������ҵ";


		sjNum[59] = 2;
		colsL[59] = "HJ#YNYK#1MT#2YY#3TRQ#4MCCQ#5DR#6QTNYK#EJSK#1TK#2JK#3TK#4LTK#5QXK#6NK#7XK#8ZZXTK#9QXTK#10WK#11ZK#12MK#13YK#14QTJSK#SFJSK#1SM#2GZT#3GLT#4YS#5SHS#6LTK#7LK#8LHJ#9LSJ#10ZT#11SS#12JKY#13HY#14HY#15DXLSSZDY#16KQS#17DLY#18HGY#19NHZT#20MX#21QTFJSK#SSZY#1DBS#2DXS#WQT#LSKZNJFKSR";
		colsH[59] = "XH#XM#JLDW#XSL#XSE#BQYNSE1#BQJMSE#BQYNSE2#BQYBTSE";
		colsLName[59] = "�ϼ�#һ����Դ��#1.ú̿#2.ԭ��#3.��Ȼ��#4.ú�㣨�ɣ���#5.����#6.������Դ��#����������#1.����#2.���#3.ͭ��#4.������#5.Ǧп��#6.����#7.����#8.����ϡ����#9.��ϡ����#10.�ٿ�#11.���#12.�̿�#13.����#14.����������#�����ǽ�����#1.ʯī#2.������#3.������#4.өʯ#5.ʯ��ʯ#6.������#7.�׿�#8.�Ȼ���#9.�����#10.ճ��#11.ɰʯ#12.������#13.����#14.����#15.����±ˮɹ�Ƶ���#16.��Ȫˮ#17.������#18.������#19.�ͻ�ճ��#20.â��#21.�����ǽ�����#�ġ�ˮ��Դ#1.�ر�ˮ#2.����ˮ#�塢����#����˰�����ɽ𡢷�������";
		colsHName[59] = "���#��Ŀ#������λ#������#���۶�#����Ӧ��˰��#���ڼ���˰��#��������˰��#����Ӧ�����ˣ�˰��";


		sjNum[60] = 3;
		colsL[60] = "HJ#YA1SLZS#EA5SLZS#SA7SLZS#QT";
		colsH[60] = "XH#XM#JSYJHJ#JSYJZZS#JSYJQZYBZZS#JSYJQZMDZZS#JSYJXFS#JSYJYYS#BQYNSE#BQJMSE#BQYJSE#BQYBTSE";
		colsLName[60] = "�ϼ�#һ����1%˰������#������5%˰������#������7%˰������#����";
		colsHName[60] = "���#��Ŀ#��˰���ݺϼ�#��˰������ֵ˰#��˰�������У�һ����ֵ˰#��˰�������У������ֵ˰#��˰��������˰#��˰����Ӫҵ˰#����Ӧ��˰��#���ڼ���˰��#�����ѽ�˰��#����Ӧ�����ˣ�˰��";


		sjNum[61] = 3;
		colsL[61] = "HJ#YCJJZ#1DWNSR#2GRNSR#ECZJZ#1DWNSR#2GRNSR#QZGRCZZF";
		colsH[61] = "XH#XM#FCYZ#QZCZFCYZ#QZJMSFCYZ#FCYZ/BQYZSJSR#BQYNSE#BQJMSE#BQYJSE#BQYBTSE";
		colsLName[61] = "�ϼ�#һ���Ӽۼ���#1����λ��˰��#2��������˰��#�����������#1����λ��˰��#2��������˰��#���У����˳���ס��";
		colsHName[61] = "���#��Ŀ#����ԭֵ#���У����ⷿ��ԭֵ#���У�����˰����ԭֵ#����ԭֵ����Ӧ��˰������#����Ӧ��˰��#���ڼ���˰��#�����ѽ�˰��#����Ӧ�����ˣ�˰��";


		sjNum[62] = 2;
		colsL[62] = "HJ#YGXHT#EJGCLHT#SJSGCKCSJHT#SJZAZGCCBHT#WCCZLHT#LHWYSHT#QCCBGHT#BJKHT#JCCBXHT#SJSHT#SYCQZYSJ#SEYYZBJZZJ#SSYYZBQT#SSQLXKZZ";
		colsH[62] = "XH#XM#JSJEHJS#HDZSDHDYJ#BQYNSE#BQYJSE#BQJMSE#BQYBTSE";
		colsLName[62] = "�ϼ�#һ��������ͬ#�����ӹ�������ͬ#�������蹤�̿�����ƺ�ͬ#�ġ�������װ���̳а���ͬ#�塢�Ʋ����޺�ͬ#�������������ͬ#�ߡ��ִ����ܺ�ͬ#�ˡ�����ͬ#�š��Ʋ����պ�ͬ#ʮ��������ͬ#ʮһ����Ȩת�����#ʮ����Ӫҵ�ʲ��������ʽ�#ʮ����Ӫҵ�ʲ���������#ʮ�ġ�Ȩ�������֤��";
		colsHName[62] = "���#��Ŀ#��˰�������#�˶����յĺ˶�����#����Ӧ��˰��#�����ѽ�˰��#���ڼ���˰��#����Ӧ�����ˣ�˰��";


		sjNum[63] = 2;
		colsL[63] = "HJ#YFSETJ#103Y#236Y#3612Y#41218Y#51824Y#62430Y#730YYS#EFYTTJ#1GY#2SY#3JZ#4ZH#5FDCKFQYKFYD#6QT";
		colsH[63] = "XH#XM#TDZMJWPFM#QZJMSZMJWPFM#BQYNSE#BQJMSE#BQYJSE#BQYBTSE";
		colsLName[63] = "�ϼ�#һ����˰��ͳ��#1��0-3Ԫ#2��3-6Ԫ#3��6-12Ԫ#4��12-18Ԫ#5��18-24Ԫ#6��24-30Ԫ#7��30Ԫ����#��������;ͳ��#1.��ҵ#2����ҵ#3����ס#4���ۺ�#5�����ز�������ҵ�����õ�#6������";
		colsHName[63] = "���#��Ŀ#�������������ƽ���ף�#���У�����˰���������ƽ���ף�#����Ӧ��˰��#���ڼ���˰��#�����ѽ�˰��#����Ӧ�����ˣ�˰��";


		sjNum[64] = 3;
		colsL[64] = "HJ#YPTZZ#PTZZ11YX#PTZZ212#PTZZ323#PTZZ43YS#EFPTZZ#FPTZZ12YX#FPTZZ224#FPTZZ346#FPTZZ46YS#SQTLXFDC#QTLXFDC12YX#QTLXFDC224#QTLXFDC346#QTLXFDC46YS";
		colsH[64] = "XH#XM#YSSRHJ#YSSRHBSR#YSSRSWSRJQTSR#YSSRSTXSSR#YNSE#SKJNBQYJSK1#SKJNBQYJSK2";
		colsLName[64] = "�ϼ�#һ����ͨסլ#1��1%����#2��1%-2%#3��2%-3%#4��3%����#��������ͨסլ#1��2%����#2��2%-4%#3��4%-6%#4��6%����#�����������ͷ��ز�#1��2%����#2��2%-4%#3��4%-6%#4��6%����";
		colsHName[64] = "���#��Ŀ#Ӧ˰����ϼ�#Ӧ˰�����������#Ӧ˰����ʵ�����뼰��������#Ӧ˰������ͬ��������#Ӧ��˰��#˰����ɱ����ѽ�˰��#˰����ɱ���Ӧ��˰��";


		sjNum[65] = 2;
		colsL[65] = "YZRFDCSRZE#EKCXMJE#1QDTDSYQSZFDJE#2FDCKFCB#TDZYJCQBCF#QQGCF#JZAZGCF#JCSSF#GGPTSSF#KFJJFY#3FDCKFFY#LXZC#QTFDCKFFY#4YZRFDCYGDSJD#YYS#CSWHJSS#JYFFJ#5CZBGDDQTKCXM#SZZE#SYJTDZZSSE#WJMSE#LYJTDZZSSE#QYBTTDZZSSE";
		colsH[65] = "XH#XM#HJ#PTZZ#FPTZZ#QTLXFDC";
		colsLName[65] = "һ��ת�÷��ز������ܶ�#�����۳���Ŀ���#1.ȡ������ʹ��Ȩ��֧���Ľ��#2.���ز������ɱ�#�������ü���Ǩ������#ǰ�ڹ��̷�#������װ���̷�#������ʩ��#����������ʩ��#������ӷ���#3.���ز���������#��Ϣ֧��#�������ز���������#4.��ת�÷��ز��йص�˰���#Ӫҵ˰#����ά������˰#�����Ѹ���#5.�������涨�������۳���Ŀ#������ֵ��#�ġ�Ӧ��������ֵ˰˰��#�塢����˰��#�����ѽ�������ֵ˰˰��#�ߡ�Ӧ�����ˣ�������ֵ˰˰��";
		colsHName[65] = "���#��Ŀ#�ϼ�#��ͨסլ#����ͨסլ#�������ͷ��ز�";


		sjNum[66] = 3;
		colsL[66] = "YZRFDCSRZE#EKCXMJE#1FDCCBAPGJGJSQDTDSYQSZFDJE#2FDCCBAPGJGJSJFJJZWDPGJG#3FDCCBAPGJGJSPGFY#4FDCCBAGFFPJSGFFPJE#5FDCCBAGFFPJSFPJJKCJE#6FDCCBAGFFPJSGFQS#2YZRFDCYGDSJYYS#3YZRFDCYGDSJCSWHJSS#4YZRFDCYGDSJYHS#5YZRFDCYGDSJJYFFJ#SZZE#SYJTDZZSSE#WJMSE#LYJTDZZSSE#QYBTTDZZSSE";
		colsH[66] = "XH#XM1#XM2#XM3#HJ#GRZZ#GRQTLXFDC#FGR";
		colsLName[66] = "һ��ת�÷��ز������ܶ�#�����۳���Ŀ���#1�����ز��ɱ��������۸����ȡ������ʹ��Ȩ��֧���Ľ��#2�����ز��ɱ��������۸����ɷ���������������۸�#3�����ز��ɱ��������۸������������#4�����ز��ɱ���������Ʊ���㹺����Ʊ���#5�����ز��ɱ���������Ʊ���㷢Ʊ�Ӽƿ۳����#6�����ز��ɱ���������Ʊ���㹺����˰#2����ת�÷��ز��йص�˰��Ӫҵ˰#3����ת�÷��ز��йص�˰�����ά������˰#4����ת�÷��ز��йص�˰��ӡ��˰#5����ת�÷��ز��йص�˰������Ѹ���#������ֵ��#�ġ�Ӧ��������ֵ˰˰��#�塢����˰��#�����ѽ�������ֵ˰˰��#�ߡ�Ӧ�����ˣ�������ֵ˰˰��";
		colsHName[66] = "���#��Ŀ#��Ŀ#��Ŀ#�ϼ�#����סլ#�����������ͷ��ز�#�Ǹ���";


		sjNum[67] = 2;
		colsL[67] = "HJ#YCYC#10SYX#10D16S#16D20S#20D25S#25D30S#30D40S#40SYS#ESYC#1KC#2HC#SGC#SMTC#WQTCL#1ZYZYC#2LSZYJXC#LCB#1JDCB#200DYX#200D2000D#2000D10000D#10000DYS#2YT#10MYX#10D18M#18D30M#30MYS";
		colsH[67] = "XH#XM#CLSHJL#CBSHJS#NYJSE#BNJMSE#BNYJSE#BNYBTSE";
		colsLName[67] = "�ϼ�#һ�����ó�#1.0������#1.0-1.6��#1.6-2.0��#2.0-2.5��#2.5-3.0��#3.0-4.0��#4.0������#�������ó�#1���ͳ�#2������#�����ҳ�#�ġ�Ħ�г�#�塢��������#1��ר����ҵ��#2����ʽר�û�е��#��������#1����������#200������#200-2000��#2000-10000��#10000������#2����ͧ#10������#10-18��#18-30��#30������";
		colsHName[67] = "���#��Ŀ#�������ϼƣ�����#�������ϼƣ��ң�#��Ӧ��˰��#�������˰��#�����ѽ�˰��#����Ӧ�����ˣ�˰��";


		sjNum[68] = 2;
		colsL[68] = "HJ#YYSG#YYGM";
		colsH[68] = "XH#XM#SGGMJE#YNSE1#YNSE2#YRKSE";
		colsLName[68] = "�ϼ�#��Ҷ�չ�#��Ҷ����";
		colsHName[68] = "���#��Ŀ#�չ�������#Ӧ��˰��#����˰��#Ӧ���˰��";


		sjNum[69] = 2;
		colsL[69] = "HJ#YTDCB#EJTJCSSJS#SGYJS#SSYJS#WZZJS#LNCJMJF#QJSSS#BXX#JYEY#SYY#SYYLY#SEQT";
		colsH[69] = "XH#XM#JSMJWPFM#QZJMSMJWPFM#JZSE#JMSE#YJSE1#YJSE2";
		colsLName[69] = "�ϼ�#һ�����ش���#������ͨ������ʩ����#������ҵ����#�ġ���ҵ����#�塢סլ����#����ũ����񽨷�#�ߡ�������ʩ#�ˡ�ѧУ#�š��׶�԰#ʮ��ҽԺ#ʮһ������Ժ#ʮ��������";
		colsHName[69] = "���#��Ŀ#��˰���(��ƽ����)#���У�����˰���(��ƽ����)#����˰��#����˰��#�ѽ�˰��#Ӧ��˰��";
		

		//70��ը��
		

		sjNum[71] = 2;
		colsL[71] = "HJ#YTDQSZYHJ#YTDSYQCR#TDSYQCR1JZYD#TDSYQCR2SYYD#TDSYQCR3GYYD#TDSYQCR4ZHYD#TDSYQCR5QTYD#ETDSYQZR#TDSYQZR1JZYD#TDSYQZR2SYYD#TDSYQZR3GYYD#TDSYQZR4ZHYD#TDSYQZR5QTYD#EFWQSZYHJ#YZLF#ZLFQZ1JTWYZF#ZLFQZ90PMYS#ZLF90PMJYX1#ZLF2JTDETZF#ZLF90PMYS#ZLF90PMJYX2#ZLF3FZF#ECLF#CLFQZ1JTWYZF#CLFQZ90PMYS#CLF90PMJYX1#CLF2JTDETZF#CLF90PMYS#CLF90PMJYX2#CLF3FZF";
		colsH[71] = "XH#XM#QSZYMJWPFM#JZSE#JMSE#YNSE";
		colsLName[71] = "�ϼ�#һ������Ȩ��ת�ƺϼ�#��һ������ʹ��Ȩ����#1.��ס�õ�#2.��ҵ�õ�#3.��ҵ�õ�#4.�ۺ��õ�#5.�����õ�#����������ʹ��Ȩת��#1.��ס�õ�#2.��ҵ�õ�#3.��ҵ�õ�#4.�ۺ��õ�#5.�����õ�#��������Ȩ��ת�ƺϼ�#��һ��������#���У�1.��ͥΨһס��#���У�90ƽ������#90ƽ�׼�����#2.��ͥ�ڶ���ס��#90ƽ������#90ƽ�׼�����#3.��ס��#������������#���У�1.��ͥΨһס��#���У�90ƽ������#90ƽ�׼�����#2.��ͥ�ڶ���ס��#90ƽ������#90ƽ�׼�����#3.��ס��";
		colsHName[71] = "���#��Ŀ#Ȩ��ת���������ƽ���ף�#����˰��#����˰��#Ӧ��˰��";
		

		sjNum[72] = 2;
		colsL[72] = "JSSBYYSR#JSSBYYCB#JSSBLRKSE#JSSBAGDKMBDYQNDKSE#JSSBYNSSDE#JSSBSJYNQYSDSE#JSSBJMQYSDSE#ASRZEHDSRZE#ASRZEHDYNSSDE#ASRZEHDSJYNQYSDSE#ASRZEHDJMQYSDSE#AJFZCHDJFZCZE#AJFZCHDHSDSRE#AJFZCHDYNSSDE#AJFZCHDSJYNQYSDSE#AJFZCHDJMQYSDSE#ACBFYHDCBFYZE#ACBFYHDHSDSRE#ACBFYHDYNSSDE#ACBFYHDSJYNQYSDSE#ACBFYHDJMQYSDSE";
		colsH[72] = "XH#XM#XM#HJ#XG#TW#AM#HG#RB#MG#XJP#JND#ADLY#YG#ELS#DG#FG#BLS#QTGJ";
		colsLName[72] = "��ʵ�걨Ӫҵ����#��ʵ�걨Ӫҵ�ɱ�#��ʵ�걨���󣨿��𣩶�#��ʵ�걨���涨���ֲ�����ǰ��ȿ����#��ʵ�걨Ӧ��˰���ö�#��ʵ�걨ʵ��Ӧ����ҵ����˰��#��ʵ�걨�����⣩��ҵ����˰��#�������ܶ�˶������ܶ�#�������ܶ�˶�Ӧ��˰���ö�#�������ܶ�˶�ʵ��Ӧ����ҵ����˰��#�������ܶ�˶������⣩��ҵ����˰��#������֧���˶�����֧���ܶ�#������֧���˶�����������#������֧���˶�Ӧ��˰���ö�#������֧���˶�ʵ��Ӧ����ҵ����˰��#������֧���˶������⣩��ҵ����˰��#���ɱ����ú˶��ɱ������ܶ�#���ɱ����ú˶�����������#���ɱ����ú˶�Ӧ��˰���ö�#���ɱ����ú˶�ʵ��Ӧ����ҵ����˰��#���ɱ����ú˶������⣩��ҵ����˰��";
		colsHName[72] = "���#��Ŀ#��Ŀ#�ϼ�#���#̨��#����#����#�ձ�#����#�¼���#���ô�#�Ĵ�����#Ӣ��#����˹#�¹�#����#����ʱ#��������";
		

		sjNum[76] = 3;
		colsL[76] = "YZZSNSR#1YBNSR#2XGMNSR#EXFSNSR#SYYSNSR#SQYSDSNSR#1JMQYSDSNSR#1NZQY#2WZQY#2FJMQYSDSNSR#WGRSDSNSR#LZYSNSR#QGDZCTZFXDJSNSR#BCSWHJSSNSR#JFCSNSR#SYHSNSR#SYCZTDSYSNSR#SETDZZSNSR#SSCCSNSR#SSCLGZSNSR#SWYYSNSR#SLGDZYSNSR#SQQSNSR#SBQTSSNSR#FLZLDJHS#QZQYNSR#GTNSR";
		colsH[76] = "XH#XM#BQXZHHJ#QZ1ZCH1#2FZCH1#QMDJHHJ#QZ1ZCH2#2FZCH2#BQZXHHJ#QZBQDJBQZX#F1QMZJGHS#QMFZJGHS#F2QMLSNSRDJHS";
		colsLName[76] = "һ����ֵ˰��˰��#1.һ����˰��#2.С��ģ��˰��#��������˰��˰��#����Ӫҵ˰��˰��#�ġ���ҵ����˰��˰��#1.������ҵ����˰��˰��#��1��������ҵ#��2��������ҵ#2.�Ǿ�����ҵ����˰��˰��#�塢��������˰��˰��#������Դ˰��˰��#�ߡ��̶��ʲ�Ͷ�ʷ������˰��˰��#�ˡ�����ά������˰��˰��#�š�����˰��˰��#ʮ��ӡ��˰��˰��#ʮһ����������ʹ��˰��˰��#ʮ����������ֵ˰��˰��#ʮ��������˰��˰��#ʮ�ġ���������˰��˰��#ʮ�塢��Ҷ˰��˰��#ʮ��������ռ��˰��˰��#ʮ�ߡ���˰��˰��#ʮ�ˡ�����˰����˰��#�������ϣ��Ǽǻ���#���У���ҵ��˰��#������˰��";
		colsHName[76] = "���#��Ŀ#�����������ϼ�#���У�1.������#2.��������#��ĩ�Ǽǻ��ϼ�#���У�1.������#2.��������#����ע�����ϼ�#���У����ڵǼǱ���ע��#��1����ĩ�ܻ�������#��ĩ��֧��������#��2����ĩ��ʱ��˰�˵Ǽǻ���";
		

		sjNum[77] = 4;
		colsL[77] = "YZZSNSR#1YBNSR#2XGMNSR#EXFSNSR#SYYSNSR#SQYSDSNSR#1JMQYSDSNSR#1NZQY#2WZQY#2FJMQYSDSNSR#WGRSDSNSR#LZYSNSR#QGDZCTZFXDJSNSR#BCSWHJSSNSR#JFCSNSR#SYHSNSR#SYCZTDSYSNSR#SETDZZSNSR#SSCCSNSR#SSCLGZSNSR#SWYYSNSR#SLGDZYSNSR#SQQSNSR#SBQTSSNSR#FLZLQYSDSNDHSQJ";
		colsH[77] = "XH#XM#YYSBHSHJ#1YSBHSXJ#QZZQSBHS#QZYQSBHS#2WSBHS#EYFKBSBHS#QZWDQZD";
		colsLName[77] = "һ����ֵ˰��˰��#1.һ����˰��#2.С��ģ��˰��#��������˰��˰��#����Ӫҵ˰��˰��#�ġ���ҵ����˰��˰��#1.������ҵ����˰��˰��#��1��������ҵ#��2��������ҵ#2.�Ǿ�����ҵ����˰��˰��#�塢��������˰��˰��#������Դ˰��˰��#�ߡ��̶��ʲ�Ͷ�ʷ������˰��˰��#�ˡ�����ά������˰��˰��#�š�����˰��˰��#ʮ��ӡ��˰��˰��#ʮһ����������ʹ��˰��˰��#ʮ����������ֵ˰��˰��#ʮ��������˰��˰��#ʮ�ġ���������˰��˰��#ʮ�塢��Ҷ˰��˰��#ʮ��������ռ��˰��˰��#ʮ�ߡ���˰��˰��#ʮ�ˡ�����˰����˰��#�������ϣ���ҵ����˰��Ȼ������";
		colsHName[77] = "���#��Ŀ#һ��Ӧ�걨�����ϼ�#1.���걨����С��#���У�׼���걨����#���У������걨����#2.δ�걨����#���������ɲ��걨����#���У�δ��������";
		

		sjNum[78] = 3;
		colsL[78] = "HJ#YDYCY#EDECY#YCKY#1MTKCHXXY#2SYHTRQKCY#3HSJSKCXY#4YSJSKCXY#5FJSKCXY#6QTCKY#EZZY#1NFSPJGY#2SPZZY#3JYLHJZCZZY#4YCZPY#5FZY#6FZFZFSY#7PGMPYMJQZPHZXY#8MCJGHMZTZCZPY#9JJZZY#10ZZHZZPY#11YSHJLMJFZY#12WJGMTYHYLYPZZY#13SYJGLJHHRLJGY#14HXYLHHXZPZZY#15YYZZY#16HXXWZZY#17XJHSLZPY#18FJSKWZPY#19HSJSYLHYYJGY#20YSJSYLHYYJGY#21JSZPY#22TYSBZZY#23ZYSBZZY#24QCZZY#25TLCBHKHTHQTYSSBZZY#26DQJXHQCZZY#27JSJTXHQTDZSBZZY#28YBYQZZY#29QTZZY#SDLRLRQJSDSCHGYY#1DLRLDSCHGYY#2RQSCHGYY#3SDSCHGYY#SJZY#1FWJZY#2TMGCJZY#3JZAZY#4JZZSHQTJZY#SDSCY#YPFHLSY#1PFY#2LSY#EJTYSCCHYZY#1JTYSY#2CCY#3YZY#SZSHCYY#1ZSY#2CYY#SXXCSRJHXXJSFWY#1DXGBDSHWXCSFWY#2HLWHXGFW#3RJHXXJSFWY#WJRY#1HBJRFW#2ZBSCFW#3BXY#4QTJRY#LFDCY#QZLHSWFWY#1ZLY#2SWFWY#BKXYJHJSFWY#JJMFWXLHQTFWY#SJY#YWSHSHGZ#SEWHTYHYLY#SSGGGLSHBZHSHZZ#SSQTXY";
		colsH[78] = "XH#XM#GNZZS#QZYBNSRZZS#GNXFS#YYS#QYSDSNZQY#QYSDSWZQY#GRSDS#CSWHJSS#FCS#YHS#CZTDSYS#TDZZS#CLGZS#CCS#GDZYS#QS#QTGS#FLZLNSHS#DJHS#FZJGHS1#FZJGHS2";
		colsLName[78] = "�ϼ�#һ����һ��ҵ#�����ڶ���ҵ#(һ)�ɿ�ҵ#1.ú̿���ɺ�ϴѡҵ#2.ʯ�ͺ���Ȼ������ҵ#3.��ɫ�������ѡҵ#4.��ɫ�������ѡҵ#5.�ǽ������ѡҵ#6.�����ɿ�ҵ#(��)����ҵ#1.ũ��ʳƷ�ӹ�ҵ#2.ʳƷ����ҵ#3.�ơ����Ϻ;��Ʋ�����ҵ#4.�̲���Ʒҵ#5.��֯ҵ#6.��֯��װ������ҵ#7.Ƥ�ëƤ����ë������Ʒ����Ьҵ#8.ľ�ļӹ���ľ�����ز���Ʒҵ#9.�Ҿ�����ҵ#10.��ֽ��ֽ��Ʒҵ#11.ӡˢ�ͼ�¼ý�鸴��ҵ#12.�Ľ̡�������������������Ʒ����ҵ#13.ʯ�ͼӹ��������ͺ�ȼ�ϼӹ�ҵ#14.��ѧԭ�Ϻͻ�ѧ��Ʒ����ҵ#15.ҽҩ����ҵ#16.��ѧ��ά����ҵ#17.�𽺺�������Ʒҵ#18.�ǽ���������Ʒҵ#19.��ɫ����ұ����ѹ�Ӽӹ�ҵ#20.��ɫ����ұ����ѹ�Ӽӹ�ҵ#21.������Ʒҵ#22.ͨ���豸����ҵ#23.ר���豸����ҵ#24.��������ҵ#25.��·�����������պ�������������豸����ҵ#26.������е����������ҵ#27.�������ͨ�ź����������豸����ҵ#28.�Ǳ���������ҵ#29.��������ҵ#(��)������������ȼ����ˮ�������͹�Ӧҵ#1.�����������������͹�Ӧҵ#2.ȼ�������͹�Ӧҵ#3.ˮ�������͹�Ӧҵ#(��)����ҵ#1.���ݽ���ҵ#2.��ľ���̽���ҵ#3.������װҵ#4.����װ�κ���������ҵ#����������ҵ#(һ)����������ҵ#1.����ҵ#2.����ҵ#(��)��ͨ���䡢�ִ�������ҵ#1.��ͨ����ҵ#2.�ִ�ҵ#3.����ҵ#(��)ס�޺Ͳ���ҵ#1.ס��ҵ#2.����ҵ#(��)��Ϣ���䡢�������Ϣ��������ҵ#1.���š��㲥���Ӻ����Ǵ������ҵ#2.����������ط���#3.�������Ϣ��������ҵ#(��)����ҵ#1.���ҽ��ڷ���#2.�ʱ��г�����#3.����ҵ#4.��������ҵ#(��)���ز�ҵ#(��)���޺��������ҵ#1.����ҵ#2.�������ҵ#(��)��ѧ�о��ͼ�������ҵ#(��)��������������������ҵ#(ʮ)����#(һ)��������Ṥ��#(ʮ��)�Ļ�������������ҵ#(ʮ��)����������ᱣ�Ϻ������֯#(ʮ��)������ҵ";
		colsHName[78] = "���#��Ŀ#������ֵ˰#����:һ����˰����ֵ˰#��������˰#Ӫҵ˰#��ҵ����˰������ҵ#��ҵ����˰������ҵ#��������˰#����ά������˰#����˰#ӡ��˰#��������ʹ��˰#������ֵ˰#��������˰#����˰#����ռ��˰#��˰#������˰#�������ϣ���˰����#�Ǽǻ���#�����ܻ�������#��֧��������";
		

		sjNum[79] = 3;
		colsL[79] = "1ZZS#YBNSR#XGMNSR#2XFS#3YYS#4QYSDS#5GRSDS#6ZYS#7GDZCTZFXDJS#8CSWHJSS#9FCS#10YHS#11CZTDSYS#12TDZZS#13CCS#14CLGZS#15YYS#16GDZYS#17QS#18QTSS#FLZLNSHS#DJHS";
		colsH[79] = "XH#XM#HJ#NZQYXJ#NZQYGYQY#NZQYJTQY#NZQYGFHZQY#NZQYLYQY#NZQYQZGYKG1#NZQYGFGS#NZQYQZGYKG2#NZQYSYQY#NZQYQTQY#GATTZQY#QZGYKG1#WSTZQY#QZGYKG2#GTJY#FZJGHS1#FZJGHS2";
		colsLName[79] = "1.��ֵ˰#һ����˰��#С��ģ��˰��#2.����˰#3.Ӫҵ˰#4.��ҵ����˰#5.��������˰#6.��Դ˰#7.�̶��ʲ�Ͷ�ʷ������˰#8.����ά������˰#9.����˰#10.ӡ��˰#11.��������ʹ��˰#12.������ֵ˰#13.����˰#14.��������˰#15.��Ҷ˰#16.����ռ��˰#17.��˰#18.����˰��#�������ϣ���˰����#�Ǽǻ���";
		colsHName[79] = "���#��Ŀ#�ϼ�#������ҵС��#������ҵ������ҵ#������ҵ������ҵ#������ҵ�ɷݺ�����ҵ#������ҵ��Ӫ��ҵ#������ҵ���У����пع�#������ҵ�ɷݹ�˾#������ҵ���У����пع�#������ҵ˽Ӫ��ҵ#������ҵ������ҵ#�۰�̨Ͷ����ҵ#���У����пع�#����Ͷ����ҵ#���У����пع�#���徭Ӫ#�����ܻ�������#��֧��������";
		

		sjNum[0] = 0;
		colsL[0] = "";
		colsH[0] = "";
		colsLName[0] = "";
		colsHName[0] = "";
		

		
		
	}
	

}
