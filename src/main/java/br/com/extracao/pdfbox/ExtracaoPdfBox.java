package br.com.extracao.pdfbox;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

public class ExtracaoPdfBox {

	public static void main(String[] args) {

		String path = "src/main/resources/diario.pdf";
		
		try {
			
			//obtem stream do arquivo
			InputStream file = new FileInputStream(path);

			//inicializando objetos responsáveis pela conversão
			PDFTextStripper pdfStripper = null;
			PDDocument pdDoc = null;
			COSDocument cosDoc = null;
			PDFParser parser;

			//realiza conversão do pdf em texto
			parser = new PDFParser(file);
			parser.parse();
			cosDoc = parser.getDocument();
			pdDoc = new PDDocument(cosDoc);
			pdfStripper = new PDFTextStripper();
			
			//obtem texto extraido do pdf
			String textoPdf = pdfStripper.getText(pdDoc);
			
			//exibe texto extraido no console
			System.out.println(textoPdf);
			
			cosDoc.close();
			pdDoc.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
