package ch09_class.quiz;

import java.util.ArrayList;

public class MovieDB {
	private ArrayList<Movie> movieList = new ArrayList<>();
	
	//싱글톤 패턴
	private MovieDB() {
		movieList.add(new Movie("신세계","거 죽기 딱 좋은 날씨네", "이정재 황정민","ㅅㅅㄱ"));
		movieList.add(new Movie("아바타2","We are Family", "외국인","ㅇㅂㅌ2"));
		movieList.add(new Movie("스타워즈","I'm Your Father", "조지 루카스, 데이브 프라우스","ㅅㅌㅇㅈ"));
		movieList.add(new Movie("관상","내가 왕이 될 관상인가?", "송강호, 이정재","ㄱㅅ"));
		movieList.add(new Movie("기생충","짜파구리 할 줄 아세요?", "송강호 이선균 최우식 조여정..","ㄱㅅㅊ"));
		movieList.add(new Movie("과속스캔들","여기있는 내눈 이거코 이거다 아부지가 만든거잔아 나 여기있잔아! 왜 내가 없었으면해? 왜! 내가 왜 이렇게 있는데 왜?!","차태현, 박보영, 왕석현", "ㄱㅅㅅㅋㄷ"));
		movieList.add(new Movie("타짜","마포대교는 무너졌냐", "조승우, 김혜수, 백윤식, 유해진 ","ㅌㅉ"));
		movieList.add(new Movie("극한직업","지금까지 이런맛은 없었다. 이것은 갈비인가, 통닭인가", "류승룡, 이하늬, 진선규, 이동휘, 공명","ㄱㅎㅈㅇ"));
		movieList.add(new Movie("명량","신에게는 아직 12척의 배가 남아있습니다", "최민식, 류승룡, 조진웅, 김명곤","명량"));
		movieList.add(new Movie("코난 극장판 : 천국으로의 카운트다운"," 밥풀을 하나라도 남기면 엄마에게 혼난다", "코난 극장판","ㅋㄴ ㄱㅈㅍ : ㅊㄱㅇㄹㅇ ㅋㅇㅌㄷㅇ"));
	}
	
	private static MovieDB instance = new MovieDB();
	
	public static MovieDB getInstance() {
		return instance;
	}
	
	public ArrayList<Movie> getMovieList(){
		return movieList;
	}
	
}
