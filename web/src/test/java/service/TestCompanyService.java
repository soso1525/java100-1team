//package service;
//
//import static org.junit.Assert.*;
//
//import org.junit.Test;
//
//import java100.app.service.CompanyService;
//
//public class TestCompanyService {
//
//	@Test
//	public void test() {
//		
//		String compName = "�Ｚ����";
//		String compNum = "121231232131232";
//		
//		CompanyService cs = new CompanyService();
//		
//		boolean exists = cs.isMatchCompanyInfo(compName, compNum);
//		
//	}
//	
//	@Test
//	public void testParsingXML () {
//		String result = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><response><header><resultCode>00</resultCode><resultMsg>NORMAL SERVICE.</resultMsg></header><body><items><item><bzowrRgstNo>124815****</bzowrRgstNo><dataCrtYm>201606</dataCrtYm><ldongAddrMgplDgCd>28</ldongAddrMgplDgCd><ldongAddrMgplSgguCd>170</ldongAddrMgplSgguCd><ldongAddrMgplSgguEmdCd>102</ldongAddrMgplSgguEmdCd><seq>12474880</seq><wkplJnngStcd>1</wkplJnngStcd><wkplNm>�Ｚ���ڷ�����(��)-�Ͽ�-��������3�� ������� �ó���� ��ġ</wkplNm><wkplRoadNmDtlAddr>��õ������ ���� ����������</wkplRoadNmDtlAddr><wkplStylDvcd>1</wkplStylDvcd></item><item><bzowrRgstNo>124815****</bzowrRgstNo><dataCrtYm>201602</dataCrtYm><ldongAddrMgplDgCd>11</ldongAddrMgplDgCd><ldongAddrMgplSgguCd>650</ldongAddrMgplSgguCd><ldongAddrMgplSgguEmdCd>108</ldongAddrMgplSgguEmdCd><seq>5255505</seq><wkplJnngStcd>1</wkplJnngStcd><wkplNm>�Ｚ���ڷ�����(��)(�Ͽ�)��������� ����� �� �����ڼ��� ����</wkplNm><wkplRoadNmDtlAddr>����Ư���� ���ʱ� �����߾ӷ�</wkplRoadNmDtlAddr><wkplStylDvcd>1</wkplStylDvcd></item><item><bzowrRgstNo>124815****</bzowrRgstNo><dataCrtYm>201705</dataCrtYm><ldongAddrMgplDgCd>41</ldongAddrMgplDgCd><ldongAddrMgplSgguCd>117</ldongAddrMgplSgguCd><ldongAddrMgplSgguEmdCd>101</ldongAddrMgplSgguEmdCd><seq>32943515</seq><wkplJnngStcd>1</wkplJnngStcd><wkplNm>�Ｚ���ڷ������ֽ�ȸ��</wkplNm><wkplRoadNmDtlAddr>��⵵ ������ ���뱸 �Ｚ��</wkplRoadNmDtlAddr><wkplStylDvcd>1</wkplStylDvcd></item><item><bzowrRgstNo>124815****</bzowrRgstNo><dataCrtYm>201707</dataCrtYm><ldongAddrMgplDgCd>41</ldongAddrMgplDgCd><ldongAddrMgplSgguCd>117</ldongAddrMgplSgguCd><ldongAddrMgplSgguEmdCd>101</ldongAddrMgplSgguEmdCd><seq>36340588</seq><wkplJnngStcd>1</wkplJnngStcd><wkplNm>�Ｚ���ڷ������ֽ�ȸ��</wkplNm><wkplRoadNmDtlAddr>��⵵ ������ ���뱸 �Ｚ��</wkplRoadNmDtlAddr><wkplStylDvcd>1</wkplStylDvcd></item><item><bzowrRgstNo>124815****</bzowrRgstNo><dataCrtYm>201706</dataCrtYm><ldongAddrMgplDgCd>41</ldongAddrMgplDgCd><ldongAddrMgplSgguCd>117</ldongAddrMgplSgguCd><ldongAddrMgplSgguEmdCd>101</ldongAddrMgplSgguEmdCd><seq>34632546</seq><wkplJnngStcd>1</wkplJnngStcd><wkplNm>�Ｚ���ڷ������ֽ�ȸ��</wkplNm><wkplRoadNmDtlAddr>��⵵ ������ ���뱸 �Ｚ��</wkplRoadNmDtlAddr><wkplStylDvcd>1</wkplStylDvcd></item><item><bzowrRgstNo>124815****</bzowrRgstNo><dataCrtYm>201704</dataCrtYm><ldongAddrMgplDgCd>41</ldongAddrMgplDgCd><ldongAddrMgplSgguCd>117</ldongAddrMgplSgguCd><ldongAddrMgplSgguEmdCd>101</ldongAddrMgplSgguEmdCd><seq>31272170</seq><wkplJnngStcd>1</wkplJnngStcd><wkplNm>�Ｚ���ڷ������ֽ�ȸ��</wkplNm><wkplRoadNmDtlAddr>��⵵ ������ ���뱸 �Ｚ��</wkplRoadNmDtlAddr><wkplStylDvcd>1</wkplStylDvcd></item><item><bzowrRgstNo>124815****</bzowrRgstNo><dataCrtYm>201703</dataCrtYm><ldongAddrMgplDgCd>41</ldongAddrMgplDgCd><ldongAddrMgplSgguCd>117</ldongAddrMgplSgguCd><ldongAddrMgplSgguEmdCd>101</ldongAddrMgplSgguEmdCd><seq>29618604</seq><wkplJnngStcd>1</wkplJnngStcd><wkplNm>�Ｚ���ڷ������ֽ�ȸ��</wkplNm><wkplRoadNmDtlAddr>��⵵ ������ ���뱸 �Ｚ��</wkplRoadNmDtlAddr><wkplStylDvcd>1</wkplStylDvcd></item><item><bzowrRgstNo>124815****</bzowrRgstNo><dataCrtYm>201702</dataCrtYm><ldongAddrMgplDgCd>41</ldongAddrMgplDgCd><ldongAddrMgplSgguCd>117</ldongAddrMgplSgguCd><ldongAddrMgplSgguEmdCd>101</ldongAddrMgplSgguEmdCd><seq>27952475</seq><wkplJnngStcd>1</wkplJnngStcd><wkplNm>�Ｚ���ڷ������ֽ�ȸ��</wkplNm><wkplRoadNmDtlAddr>��⵵ ������ ���뱸 �Ｚ��</wkplRoadNmDtlAddr><wkplStylDvcd>1</wkplStylDvcd></item><item><bzowrRgstNo>124815****</bzowrRgstNo><dataCrtYm>201612</dataCrtYm><ldongAddrMgplDgCd>41</ldongAddrMgplDgCd><ldongAddrMgplSgguCd>117</ldongAddrMgplSgguCd><ldongAddrMgplSgguEmdCd>101</ldongAddrMgplSgguEmdCd><seq>24739710</seq><wkplJnngStcd>1</wkplJnngStcd><wkplNm>�Ｚ���ڷ������ֽ�ȸ��</wkplNm><wkplRoadNmDtlAddr>��⵵ ������ ���뱸 �Ｚ��</wkplRoadNmDtlAddr><wkplStylDvcd>1</wkplStylDvcd></item><item><bzowrRgstNo>124815****</bzowrRgstNo><dataCrtYm>201709</dataCrtYm><ldongAddrMgplDgCd>41</ldongAddrMgplDgCd><ldongAddrMgplSgguCd>117</ldongAddrMgplSgguCd><ldongAddrMgplSgguEmdCd>101</ldongAddrMgplSgguEmdCd><seq>39816067</seq><wkplJnngStcd>1</wkplJnngStcd><wkplNm>�Ｚ���ڷ������ֽ�ȸ��</wkplNm><wkplRoadNmDtlAddr>��⵵ ������ ���뱸 �Ｚ��</wkplRoadNmDtlAddr><wkplStylDvcd>1</wkplStylDvcd></item></items><numOfRows>10</numOfRows><pageNo>1</pageNo><totalCount>58</totalCount></body></response>";
//		// ..... <totalCount>xxxx</totalCount>"
//		//                   ^   ^ 
//		int p0 = result.indexOf("<totalCount>");
//		if ( p0 < 0 ) {
////			throw new RuntimeException("<totalCount> ����!");
//		}
//		p0 += "<totalCount>".length();
//		
//		int p1 = result.indexOf("</totalCount>");
//		if ( p1 < 0 ) {
//			throw new RuntimeException("</totalCount> ����!");
//		}
//		// p1 += "</totalCount>".length();
//		
//		String s = result.substring(p0, p1);
//		int cnt = Integer.parseInt(s);
//		assertEquals(58, cnt);
//	}
//
//}
