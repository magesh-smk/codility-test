package com.ts.test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.ts.songs.impl.PlayList;
import com.ts.songs.model.Song;
import com.ts.songs.util.Genres;


/*
 * タイトル：プレイリストのテストクラス
 * 説明    ：楽曲のシャッフルの動作確認クラスです。
 * 　　　　　　　
 *
 * 著作権  ：Copyright(c) 2020　ts
 * 会社名  ：ts
 *
 * 変更履歴：2020/6/6（土）
 *        ：新規作成 マヘーシュ
 *
 */
public class ShuffleTest {

	
	/**
	 * マイン処理です。
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String args[]) {
		
		// プレイリストのインスタンスを作成
		PlayList plList= new PlayList();
		
		// case 1: 複数アーティスト、アルバム、曲種のテスト
		//　曲のレコードを作成
		Song songList[] = new Song[27];
		songList[0] = new Song("title1","artist1","album1",Genres.JAZZ,120,2.4);
		songList[1] = new Song("title2","artist1","album1",Genres.JAZZ,130,3.0);
		songList[2] = new Song("title3","artist1","album2",Genres.HIPHOP,230,5.5);
		songList[3] = new Song("title4","artist1","album2",Genres.HIPHOP,220,1.2);
		songList[4] = new Song("title5","artist1","album3",Genres.RNB,310,2.3);
		songList[5] = new Song("title6","artist2","album4",Genres.TECHNO,560,4.0);
		songList[6] = new Song("title7","artist2","album5",Genres.TECHNO,410,3.6);
		songList[7] = new Song("title8","artist2","album5",Genres.TECHNO,250,3.3);
		songList[8] = new Song("title9","artist2","album6",Genres.ROCK,170,6.0);
		songList[9] = new Song("title10","artist2","album6",Genres.ROCK,300,9.5);
		songList[10] = new Song("title11","artist3","album7",Genres.ROCK,310,8.5);
		songList[11] = new Song("title12","artist3","album7",Genres.ROCK,200,4.5);
		songList[12] = new Song("title13","artist3","album7",Genres.ROCK,305,7.5);
		songList[13] = new Song("title14","artist3","album7",Genres.ROCK,168,1.3);
		songList[14] = new Song("title15","artist3","album7",Genres.ROCK,180,4.2);
		songList[15] = new Song("title16","artist4","album8",Genres.ELECTRO,200,10.0);
		songList[16] = new Song("title17","artist4","album8",Genres.ELECTRO,240,9.7);
		songList[17] = new Song("title18","artist4","album8",Genres.ELECTRO,210,7.5);
		songList[18] = new Song("title19","artist4","album9",Genres.ELECTRO,150,6.3);
		songList[19] = new Song("title20","artist5","album10",Genres.COUNTRY,450,5.5);
		songList[20] = new Song("title21","artist5","album11",Genres.FOLK,322,2.8);
		songList[21] = new Song("title23","artist5","album12",Genres.POP,202,4.1);
		songList[22] = new Song("title24","artist5","album13",Genres.POP,500,7.1);
		songList[23] = new Song("title25","artist5","album12",Genres.POP,270,5.4);
		songList[24] = new Song("title26","artist6","album21",Genres.RNB,300,6.9);
		//重複リスト
		songList[25] = new Song("title11","artist3","album7",Genres.ROCK,310,8.5);
		songList[26] = new Song("title18","artist4","album8",Genres.ELECTRO,210,7.5);
		
		// 曲のレコードを設定します。
		plList.setSongs(songList);
		
		// 1巡目
		System.out.println("---------------------- Case 1 -------------------------------");
		System.out.println("1巡目：");
		System.out.println("予定曲: " + Stream.of(plList.peekQueue()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("予定曲: " + Stream.of(plList.peekQueue()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("予定曲: " + Stream.of(plList.peekQueue()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("予定曲: " + Stream.of(plList.peekQueue()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("予定曲: " + Stream.of(plList.peekQueue()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("予定曲: " + Stream.of(plList.peekQueue()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("2巡目：");		
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("予定曲: " + Stream.of(plList.peekQueue()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("予定曲: " + Stream.of(plList.peekQueue()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("予定曲: " + Stream.of(plList.peekQueue()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("予定曲: " + Stream.of(plList.peekQueue()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("予定曲: " + Stream.of(plList.peekQueue()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("3巡目：");		
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("---------------------- Case 1 -------------------------------");
		// case 1: 終了

		
		// case 2: 複数アーティスト、アルバム
		//　曲のレコードを作成
		songList = new Song[7];
		songList[0] = new Song("title9","artist2","album6",Genres.ROCK,170,6.0);
		songList[1] = new Song("title10","artist2","album6",Genres.ROCK,300,9.5);
		songList[2] = new Song("title11","artist3","album7",Genres.ROCK,310,8.5);
		songList[3] = new Song("title12","artist3","album7",Genres.ROCK,210,8.3);
		songList[4] = new Song("title13","artist3","album7",Genres.ROCK,305,7.5);
		songList[5] = new Song("title14","artist4","album7",Genres.ROCK,168,1.3);
		songList[6] = new Song("title15","artist3","album7",Genres.ROCK,180,4.2);
		// 曲のレコードを設定します。
		plList.setSongs(songList);
		System.out.println("---------------------- Case 2 -------------------------------");
		System.out.println("1巡目：");
		System.out.println("予定曲: " + Stream.of(plList.peekQueue()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("予定曲: " + Stream.of(plList.peekQueue()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("2巡目：");
		System.out.println("予定曲: " + Stream.of(plList.peekQueue()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("予定曲: " + Stream.of(plList.peekQueue()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("---------------------- Case 2 -------------------------------");
		// case 2: 終了

		
		// case 3: 複数アーティスト、曲種のテスト
		//　曲のレコードを作成
		songList = new Song[14];
		songList[0] = new Song("title1","artist1","album1",Genres.JAZZ,120,2.4);
		songList[1] = new Song("title3","artist1","album1",Genres.HIPHOP,230,5.5);
		songList[2] = new Song("title4","artist1","album1",Genres.HIPHOP,220,1.2);
		songList[3] = new Song("title5","artist1","album1",Genres.RNB,310,2.3);
		songList[4] = new Song("title6","artist2","album1",Genres.TECHNO,560,4.0);
		songList[5] = new Song("title7","artist2","album1",Genres.TECHNO,410,3.6);
		songList[6] = new Song("title8","artist2","album1",Genres.TECHNO,250,3.3);
		songList[7] = new Song("title18","artist4","album1",Genres.ELECTRO,210,7.5);
		songList[8] = new Song("title19","artist4","album1",Genres.ELECTRO,150,6.3);
		songList[9] = new Song("title21","artist5","album1",Genres.FOLK,322,2.8);
		songList[10] = new Song("title23","artist5","album1",Genres.POP,202,4.1);
		songList[11] = new Song("title24","artist5","album1",Genres.POP,500,7.1);
		songList[12] = new Song("title25","artist5","album1",Genres.POP,270,5.4);
		songList[13] = new Song("title26","artist6","album1",Genres.RNB,300,6.9);
		// 曲のレコードを設定します。
		plList.setSongs(songList);
		System.out.println("---------------------- Case 3 -------------------------------");
		System.out.println("1巡目：");
		System.out.println("予定曲: " + Stream.of(plList.peekQueue()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("予定曲: " + Stream.of(plList.peekQueue()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("予定曲: " + Stream.of(plList.peekQueue()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("2巡目：");
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("予定曲: " + Stream.of(plList.peekQueue()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("---------------------- Case 3 -------------------------------");
		// case 3: 終了		
				
		// case 4: 同じアーティスト
		//　曲のレコードを作成
		songList = new Song[8];
		songList[0] = new Song("title20","artist5","album10",Genres.COUNTRY,450,5.5);
		songList[1] = new Song("title21","artist5","album11",Genres.FOLK,322,2.8);
		songList[2] = new Song("title22","artist5","album12",Genres.POP,108,3.3);
		songList[3] = new Song("title23","artist5","album12",Genres.POP,202,4.1);
		songList[4] = new Song("title24","artist5","album13",Genres.POP,500,7.1);
		songList[5] = new Song("title25","artist5","album12",Genres.POP,270,5.4);
		songList[6] = new Song("title26","artist5","album21",Genres.RNB,300,6.9);
		songList[7] = new Song("title27","artist5","album22",Genres.FOLK,120,4.0);
		// 曲のレコードを設定します。
		plList.setSongs(songList);
		System.out.println("---------------------- Case 4 -------------------------------");
		System.out.println("1巡目：");
		System.out.println("予定曲: " + Stream.of(plList.peekQueue()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("予定曲: " + Stream.of(plList.peekQueue()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("2巡目：");
		System.out.println("予定曲: " + Stream.of(plList.peekQueue()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("次の曲: " + Stream.of(plList.getNextSong()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("予定曲: " + Stream.of(plList.peekQueue()).map(Song::toString).collect(Collectors.joining(",", "[", "]")));
		System.out.println("---------------------- Case 4 -------------------------------");
		// case 4: 終了

		
	}
	
}
