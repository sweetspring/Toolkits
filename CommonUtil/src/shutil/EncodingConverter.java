package shutil;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * �����ļ����µ�java�ļ��ı����Զ�ת������gbkתutf-8
 * 
 * @author Wen Fuqiang
 * @company Fayhong Technology Co., Ltd.
 * @date 2010-1-26
 */
public class EncodingConverter {

	/**
	 * main�������
	 * 
	 * @param args
	 *            args[0] ������Ҫת�����ļ��� args[1] ָ����Ҫת���ı��룬��utf-8��
	 */
	public static void main(String[] args) {
		// if (args.length<2){
		// System.out.println("please input path of folder and encoding name");
		// System.exit(1);
		// }
		// else{
		// ec.convertEncode(args[0], args[1]);
		// }

		EncodingConverter ec = new EncodingConverter();

		// ��ʱ��src_path�滻args[0]��encoding_name�滻arg[1]
		String src_path = "D:\\www\\ECSHOP\\Bus";
		String encoding_name = "utf-8";
		ec.convertEncode(src_path, encoding_name);

	}

	public void convertEncode(String sourceFloder, String encoding_name) {
		File file = new File(sourceFloder);
		String[] files = file.list();

		for (String s : files) {
			if (s.indexOf('.') == -1) { // �������Ǹ���Ŀ¼���ع���ô˺���
				convertEncode(file.getAbsolutePath() + "\\" + s, encoding_name);
			} else {
				if (s.endsWith("php") || s.endsWith("txt") || s.endsWith("html") || s.endsWith("htm")) {
					//doConvertEncode(file.getAbsolutePath() + "\\" + s, file.getAbsolutePath()+ "\\" + s, encoding_name);
					try {
						String newfolderstr = file.getAbsolutePath().replace("D:\\www\\ECSHOP\\Bus", "D:\\www\\ECSHOP\\Bus2");
						File newfolder=new File(newfolderstr);
						 if (!newfolder.exists()) {
							 newfolder.mkdirs();
						 }
						IOCVUtils.changeEncoding(file.getAbsolutePath() + "\\" + s, newfolder+ "\\" + s, IOCVUtils.sourceEncoding,IOCVUtils.targetEncoding);
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				}
			}
		}
	}

	/**
	 * ��ɾ���ı���ת������
	 * 
	 * @param inputFile
	 *            �����ļ�
	 * @param outputFile
	 *            ����ļ�
	 * @param encoding_name
	 *            ��Ҫת�ɵı����ʽ
	 */
	public void doConvertEncode(String inputFile, String outputFile,
			String encoding_name) {
		Runtime rt = Runtime.getRuntime();
		String cmd[] = { "native2ascii.exe", "-reverse", "-encoding",
				encoding_name, inputFile, outputFile };
		System.out.println("Execing convert command for " + inputFile + " ...");

		try {
			Process proc = rt.exec(cmd);

			// any error message?
			StreamGobbler errorGobbler = new StreamGobbler(proc.getErrorStream(), "ERROR");

			// any output?
			StreamGobbler outputGobbler = new StreamGobbler(proc.getInputStream(), "OUTPUT");

			// kick them off
			errorGobbler.start();
			outputGobbler.start();

			// any error???
			int exitVal = proc.waitFor();
			System.out.println("ExitValue: " + exitVal);

		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
