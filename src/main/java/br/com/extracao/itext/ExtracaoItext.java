package br.com.extracao.itext;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;

public class ExtracaoItext {

	public static void main(String[] args) {

		String path = "src/main/resources/diario.pdf";
		
		try {

			//obtem stream do arquivo
			InputStream stream = new FileInputStream(path);

			//inicializa objetos para extração
			PdfReader reader = new PdfReader(stream);
			PdfReaderContentParser parser = new PdfReaderContentParser(reader);
			TextExtractionStrategy strategy;
			
			//inicializa buffer para armazenar texto do arquivo
			StringBuffer textoArquivo = new StringBuffer();

			//obtém texto de cada página do arquivo
			for (int i = 1; i <= reader.getNumberOfPages(); i++) {
				
				strategy = parser.processContent(i, new SimpleTextExtractionStrategy());
				textoArquivo.append(strategy.getResultantText());

			}
			
			//exibe texto do arquivo no console
			System.out.println(textoArquivo.toString());

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
