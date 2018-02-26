package java100.app.service;

import java.util.List;

import java100.app.domain.Notice;
import java100.app.domain.Resume;

// => "�뿭�븷"�쓣 媛뺤“�븷 �븣�뒗 "媛앹껜(object)"�씪�뒗 留먮낫�떎�뒗 
//    "而댄룷�꼳�듃(component)"�씪�뒗 留먯쓣 �궗�슜�븳�떎.
// => "媛앹껜"�뒗 留� 洹몃�濡� �븳 媛쒖쓽 �겢�옒�뒪瑜� 媛�由ы궎�뒗 寃껋씠�씪硫�,
//    "而댄룷�꼳�듃"�뒗 洹� �뿭�븷�쓣 �닔�뻾�븯�뒗 �뿬�윭 媛앹껜�쓽 臾띠쓬�쓣 珥앹묶�븳�떎.
//
// Service 而댄룷�꼳�듃(�씤�꽣�럹�씠�뒪, 援ы쁽泥�)�뒗 "�뾽臾� 濡쒖쭅"怨� "�듃�옖�옲�뀡 泥섎━"瑜�  
// �떞�떦�븯湲� �븣臾몄뿉 �씤�꽣�럹�씠�뒪�뿉 �꽑�뼵�븯�뒗 硫붿꽌�뱶 �씠由꾨룄 
// 媛��뒫�븳 �뾽臾� �슜�뼱瑜� �궗�슜�븳�떎.
//
public interface NoticeService {
    List<Notice> list(String orderBy);
    Notice get(int no);
    int add(Notice notice);
    int update(Notice notice);
    int delete(int no);
}





