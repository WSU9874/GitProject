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
		// ������ ���� �غ�
		DocumentBuilder k20_docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

		// xml������ ó�� PC�ȿ� �־ ��ü��θ� ����, xml�Ľ� ó�� ����
		Document k20_doc = k20_docBuilder.parse(new File("C:\\Users\\w\\Desktop\\score.txt"));

		Element k20_root = k20_doc.getDocumentElement(); // root�±׸� ������ ���⵵ �ϴϸ� ������ �Ⱦ�

		NodeList k20_tag_name = k20_doc.getElementsByTagName("name"); // ���Ͽ� �ۼ�
		NodeList k20_tag_studentid = k20_doc.getElementsByTagName("studentid");
		NodeList k20_tag_kor = k20_doc.getElementsByTagName("kor");
		NodeList k20_tag_eng = k20_doc.getElementsByTagName("eng");
		NodeList k20_tag_mat = k20_doc.getElementsByTagName("mat");

		System.out.printf("****************************************************\n"); // ���
		for (int k20_i = 0; k20_i < k20_tag_name.getLength(); k20_i++) {
			System.out.printf("�̸� : %s\n", k20_tag_name.item(k20_i).getFirstChild().getNodeValue());
			System.out.printf("�й� : %s\n", k20_tag_studentid.item(k20_i).getFirstChild().getNodeValue());
			System.out.printf("���� : %s\n", k20_tag_kor.item(k20_i).getFirstChild().getNodeValue());
			System.out.printf("���� : %s\n", k20_tag_eng.item(k20_i).getFirstChild().getNodeValue());
			System.out.printf("���� : %s\n", k20_tag_mat.item(k20_i).getFirstChild().getNodeValue());
			System.out.printf("************************************************\n");
		}
	}
}
