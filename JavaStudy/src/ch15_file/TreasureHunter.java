package ch15_file;

import java.io.File;

public class TreasureHunter {

	public static void main(String[] args) {
		String path = "/home/pc06/today/treasure";

		// treasure 폴더 내 파일 먼저 찾기
		File folder = new File(path);
		System.out.println(folder);

		findFile(folder);

//		File[] inner = folder.listFiles();
//		for (int i = 0; i < inner.length; i++) {
//			if (inner[i].isDirectory()) {
//				// 폴더
//				File[] innerinner = inner[i].listFiles();
//				for (int k = 0; k < innerinner.length; k++) {
//					if (innerinner[k].isDirectory()) {
//						File[] innerinnerinnr = innerinner[k].listFiles();
//					}
//				}
//			} else {
//				// 파일
//				System.out.println(inner[i]);
//			}
//		}
	} // 메인 끝

	public static void findFile(File folder) {
		File[] inner = folder.listFiles();
		for (int i = 0; i < inner.length; i++) {
			if (inner[i].isDirectory()) {
				findFile(inner[i]);
			} else {
				System.out.println(inner[i]);
			}
		}
	}
}
