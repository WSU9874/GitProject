package project9;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Page_9 {

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		// 파일을 위한 준비
		DocumentBuilder k20_docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

		// xml파일을 처리 PC안에 있어서 전체경로를 저장, xml파싱 처리 시작
		Document k20_doc = k20_docBuilder.parse(new File("C:\\Users\\w\\Desktop\\score.txt"));

		Element k20_root = k20_doc.getDocumentElement(); // root태그를 가지고 오기도 하니만 지금은 안씀

		NodeList k20_tag_name = k20_doc.getElementsByTagName("name"); // 파일에 작성
		NodeList k20_tag_studentid = k20_doc.getElementsByTagName("studentid");
		NodeList k20_tag_kor = k20_doc.getElementsByTagName("kor");
		NodeList k20_tag_eng = k20_doc.getElementsByTagName("eng");
		NodeList k20_tag_mat = k20_doc.getElementsByTagName("mat");

		System.out.printf("****************************************************\n"); // 출력
		for (int k20_i = 0; k20_i < k20_tag_name.getLength(); k20_i++) {
			System.out.printf("이름 : %s\n", k20_tag_name.item(k20_i).getFirstChild().getNodeValue());
			System.out.printf("학번 : %s\n", k20_tag_studentid.item(k20_i).getFirstChild().getNodeValue());
			System.out.printf("국어 : %s\n", k20_tag_kor.item(k20_i).getFirstChild().getNodeValue());
			System.out.printf("영어 : %s\n", k20_tag_eng.item(k20_i).getFirstChild().getNodeValue());
			System.out.printf("수학 : %s\n", k20_tag_mat.item(k20_i).getFirstChild().getNodeValue());
			System.out.printf("************************************************\n");
		}
	}
}
