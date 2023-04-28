package ch15_file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutput {

	public static void main(String[] args) {
		// 자바에서 파일에 내용 쓰기
		String filePath = "/home/pc06/today/test.txt";

		File test = new File(filePath);

		// 다음과 같이 작성하면 .close 할필요없이 알아서 닫아줌
		// new FileOutPutStream(test) -> 기존 파일 내용을 덮어씀
		// new FileOutPutStream(test, true) -> 기존 파일 내용에 이어서 씀
		try(FileOutputStream fos = new FileOutputStream(test, true)) {

			String temp = "\n 월요일도 쉬지롱~~~";

			// String 에 .getBytes()하면 byte[] 를 리턴
			byte[] tempByte = temp.getBytes();

			// .write 바이트 배열을 작성하고 넘길 수 있음
			fos.write(tempByte);
			System.out.println("작성 완료!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
